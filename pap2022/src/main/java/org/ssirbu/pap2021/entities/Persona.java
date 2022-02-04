package org.ssirbu.pap2021.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre; 
	
	//============================	
	public Persona() {
		
	}

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	
	//=============================
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	//=============================
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + "]";
	}
	
}
