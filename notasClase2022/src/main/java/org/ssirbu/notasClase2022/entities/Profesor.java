package org.ssirbu.notasClase2022.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Profesor  extends Usuario{
	
	@OneToMany(mappedBy = "profesorImparte")
	private Collection<Asignatura>asignaturasImparte;
	
	public Profesor() {
		super();
		this.asignaturasImparte = new ArrayList<Asignatura>();
	}

	public Profesor(String dni, String nombre, String apellido, String password) {
		super(dni, nombre, apellido, password);
		this.asignaturasImparte = new ArrayList<Asignatura>();
	}

	public Collection<Asignatura> getAsignaturasImparte() {
		return asignaturasImparte;
	}

	public void setAsignaturasImparte(Collection<Asignatura> asignaturasImparte) {
		this.asignaturasImparte = asignaturasImparte;
	}
	
	//==========================
	public void addAsignaturaImparte(Asignatura asignatura) {
		this.asignaturasImparte.add(asignatura);
		asignatura.setProfesorImparte(this);
	}
	
	
}
