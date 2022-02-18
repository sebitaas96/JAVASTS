package org.ssirbu.notasClase2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssirbu.notasClase2022.entities.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

}
