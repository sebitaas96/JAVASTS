package org.ssirbu.notasClase2022.entities;

import javax.persistence.Entity;

@Entity
public class Profesor  extends Usuario{

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(String dni, String nombre, String apellido, String password) {
		super(dni, nombre, apellido, password);
		// TODO Auto-generated constructor stub
	}
	
}
