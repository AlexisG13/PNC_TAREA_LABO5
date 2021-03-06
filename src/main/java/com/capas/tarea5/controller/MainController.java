package com.capas.tarea5.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.capas.tarea5.dao.EstudianteDAO;
import com.capas.tarea5.domain.Estudiante;

@Controller
public class MainController {
	@Autowired
	private EstudianteDAO estudianteDAO;

	@RequestMapping("listado")
	public ModelAndView Listado() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		return mav;
	}

	@RequestMapping("inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("ingresarEstudiante")
	public ModelAndView findOne(@Valid() @ModelAttribute() Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("index");
			return mav;
		}
		try {
			estudianteDAO.insert(estudiante);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("index");
		return mav;
	}
}
