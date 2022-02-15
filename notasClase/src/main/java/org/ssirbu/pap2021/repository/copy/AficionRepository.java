package org.ssirbu.pap2021.repository.copy;

import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;
import org.ssirbu.pap2021.entities.Aficion;

@Repository
public interface AficionRepository extends JpaRepository<Aficion, Long> {
	
}
