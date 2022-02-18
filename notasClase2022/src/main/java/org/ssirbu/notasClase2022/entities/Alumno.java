package org.ssirbu.notasClase2022.entities;

import java.util.ArrayList;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class Alumno extends Usuario{

	@OneToMany(mappedBy = "calificado" ,cascade = CascadeType.ALL)
	private Collection<Nota> calificados;
	@ManyToMany()
	private Collection<Asignatura>asignaturasMatriculado;
	
	public Alumno() {
		super();
		this.calificados = new ArrayList<Nota>();
		this.asignaturasMatriculado = new ArrayList<Asignatura>();
	}

	public Alumno(String dni, String nombre, String apellido, String password) {
		super(dni, nombre, apellido, password);
		this.calificados = new ArrayList<Nota>();
		this.asignaturasMatriculado = new ArrayList<Asignatura>();
	}



	
	//=====================================

	public Collection<Nota> getCalificados() {
		return calificados;
	}

	public void setCalificados(Collection<Nota> calificados) {
		this.calificados = calificados;
	}

	public Collection<Asignatura> getAsignaturasMatriculado() {
		return asignaturasMatriculado;
	}

	public void setAsignaturasMatriculado(Collection<Asignatura> asignaturasMatriculado) {
		this.asignaturasMatriculado = asignaturasMatriculado;
	}
	//==================================0
	public void addasignaturasMatriculado(Asignatura asignatura) {
		this.asignaturasMatriculado.add(asignatura);
		asignatura.getAlumnosMatriculados().add(this);
	}
	
	public void removeasignaturasMatriculado(Asignatura asignatura) {
		this.asignaturasMatriculado.remove(asignatura);
		asignatura.getAlumnosMatriculados().remove(this);
	}
	

}
