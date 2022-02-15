package org.ssirbu.pap2021.repository.copy2;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import org.ssirbu.pap2021.entities.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
	
}
