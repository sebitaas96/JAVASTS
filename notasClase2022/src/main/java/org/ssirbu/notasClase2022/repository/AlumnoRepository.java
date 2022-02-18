package org.ssirbu.notasClase2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssirbu.notasClase2022.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
