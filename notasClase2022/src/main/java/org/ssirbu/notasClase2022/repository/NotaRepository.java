package org.ssirbu.notasClase2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssirbu.notasClase2022.entities.Nota;


public interface NotaRepository extends JpaRepository<Nota, Long> {

}
