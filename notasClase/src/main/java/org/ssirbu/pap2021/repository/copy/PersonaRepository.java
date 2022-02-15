package org.ssirbu.pap2021.repository.copy;

import org.springframework.data.jpa.repository.JpaRepository;




import org.springframework.stereotype.Repository;
import org.ssirbu.pap2021.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	//Funcion getByAtributo de maven no hace falta ni programarla coge el atributo
	public Persona getByNombre(String nombre);
}
