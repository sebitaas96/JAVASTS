package org.ssirbu.notasClase2022.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssirbu.notasClase2022.entities.Asignatura;
import org.ssirbu.notasClase2022.repository.AsignaturaRepository;


@Service
public class AsignaturaService {
	@Autowired
	private AsignaturaRepository asignaturaRepository; 
	
	public void crearAsignatura(String nombre) throws Exception {
		try {
			asignaturaRepository.save(new Asignatura(nombre, null, null));
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Asignatura> findAll() {
		return asignaturaRepository.findAll();
	}
	
	public Asignatura getById (Long id) {
		return asignaturaRepository.getById(id);
	}
}
