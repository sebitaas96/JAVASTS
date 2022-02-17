package org.ssirbu.notasClase2022.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private float cantidad;
	
	@ManyToOne
	private Alumno calificado;
	@ManyToOne
	private Asignatura calificada;
	
	
	public Nota() {
		this.cantidad = 0.0F;
	}
	
	
	public Nota(float cantidad, Alumno calificado, Asignatura calificada) {
		this.cantidad = cantidad;
		this.calificado = calificado;
		this.calificado.getCalificados().add(this);
		this.calificada = calificada;
		this.calificada.getCalificadas().add(this);
	}
	//=========================================
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}


	public Alumno getCalificado() {
		return calificado;
	}


	public void setCalificado(Alumno calificado) {
		this.calificado = calificado;
		this.calificado.getCalificados().add(this);
	}


	public Asignatura getCalificada() {
		return calificada;
	}


	public void setCalificada(Asignatura calificada) {
		this.calificada = calificada;
		this.calificada.getCalificadas().add(this);
	}
	
	
	//=========================================
	
	
	
	
	
	
}
