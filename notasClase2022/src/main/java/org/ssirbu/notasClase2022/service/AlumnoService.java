package org.ssirbu.notasClase2022.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssirbu.notasClase2022.entities.Alumno;
import org.ssirbu.notasClase2022.repository.AlumnoRepository;
import org.ssirbu.notasClase2022.repository.AsignaturaRepository;


@Service
public class AlumnoService {
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private AsignaturaRepository asignaturaRepository; 
	
	public void crearAlumno(String dni ,String nombre ,String apellido ,String pwd ,List<Long> asigMatriculado) throws Exception {
		try {
			Alumno a= new Alumno(dni , nombre,apellido,pwd);
			if(asigMatriculado !=null) {
				for(Long id : asigMatriculado) {
					a.addasignaturasMatriculado(asignaturaRepository.getById(id));
				}
			}

			alumnoRepository.save(a);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Alumno> findAll() {
		return alumnoRepository.findAll();
	}
}
