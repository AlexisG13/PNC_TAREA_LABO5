package com.capas.tarea5.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.capas.tarea5.domain.Estudiante;

public interface EstudianteDAO {
	
	public List<Estudiante> findAll() throws DataAccessException;
	
	public void insert(Estudiante estudiante) throws DataAccessException;

}
