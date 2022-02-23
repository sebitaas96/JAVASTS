package org.ssirbu.notasClase2022.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssirbu.notasClase2022.entities.Alumno;
import org.ssirbu.notasClase2022.entities.Asignatura;
import org.ssirbu.notasClase2022.entities.Profesor;
import org.ssirbu.notasClase2022.repository.AlumnoRepository;
import org.ssirbu.notasClase2022.repository.AsignaturaRepository;
import org.ssirbu.notasClase2022.repository.ProfesorRepository;


@Service
public class AsignaturaService {
	@Autowired
	private AsignaturaRepository asignaturaRepository; 
	
	@Autowired
	private AlumnoRepository alumnoRepository; 
	
	@Autowired
	private ProfesorRepository profesorRepository;
	
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
	
	public void updateAsignatura(Long id , String nombre) throws Exception {
		try {
			Asignatura asignatura = asignaturaRepository.getById(id);
			asignatura.setNombre(nombre);
			asignaturaRepository.save(asignatura);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	
	public void deleteById(Long id) throws Exception {
		try {
			Asignatura a = asignaturaRepository.getById(id);
			Profesor p = a.getProfesorImparte();
			Collection<Alumno> alumnosMatriculados = a.getAlumnosMatriculados();
			
			if(alumnosMatriculados!=null) {
				for(Alumno al : alumnosMatriculados) {
					al.removeasignaturasMatriculado(a);
					alumnoRepository.save(al);
				}
			}
			if(p !=null) {
				p.removeAsignaturaImparte(a);
				profesorRepository.save(p);
			}
			asignaturaRepository.save(a);
			asignaturaRepository.deleteById(id);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
