package org.ssirbu.notasClase2022.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Alumno extends Usuario{

	@OneToMany(mappedBy = "calificado" ,cascade = CascadeType.ALL)
	private Collection<Nota> calificados;
	
	public Alumno() {
		super();
		this.calificados = new ArrayList<Nota>();
	}

	public Alumno(String dni, String nombre, String apellido, String password) {
		super(dni, nombre, apellido, password);
		this.calificados = new ArrayList<Nota>();
	}



	
	//=====================================

	public Collection<Nota> getCalificados() {
		return calificados;
	}

	public void setCalificados(Collection<Nota> calificados) {
		this.calificados = calificados;
	}
}
