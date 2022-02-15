package org.ssirbu.notasClase2022.entities;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Asignatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String nombre;
	
	@OneToMany(mappedBy = "calificada" ,cascade = CascadeType.ALL)
	private Collection<Nota> calificadas;

	//====================================
	public Asignatura() {
		this.nombre="EF";
		this.calificadas = new ArrayList<Nota>();
	}
	
	public Asignatura(String nombre, Collection<Nota> calificadas) {
		this.nombre = nombre;
		this.calificadas = new ArrayList<Nota>();
	}


	
	//====================================
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

	public Collection<Nota> getCalificadas() {
		return calificadas;
	}

	public void setCalificadas(Collection<Nota> calificadas) {
		this.calificadas = calificadas;
	}
	

}
