package org.ssirbu.notasClase2022.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssirbu.notasClase2022.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
	public List<Alumno> findByApellido(String apellido);
	public List<Alumno> findByasignaturasMatriculadoNombre(String nombreAsignatura);
			
}
