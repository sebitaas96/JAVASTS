package org.ssirbu.pap2021.entities;



import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String nombre; 
	private String password;
	//Es many to one por que muchas personas nacen en un pais y ya lo hemsos mapeado en pai
	@ManyToOne
	private Pais nace;
	
	@ManyToMany
	private Collection<Aficion>aficionesGusta;
	
	
	//============================	
	public Persona() {
		this.nombre = "Jhon Doe";
		this.aficionesGusta = new ArrayList<Aficion>();
	}

	public Persona(String nombre , String password , Pais nace) {
		this.nombre = nombre;
		this.password= encriptar(password);
		this.nace = nace;
		
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
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = encriptar(password);
	}
	
	public Pais getNace() {
		return nace;
	}

	public void setNace(Pais nace) {
		this.nace = nace;
		this.nace.getNativos().add(this);
	}
	


	public Collection<Aficion> getAficionesGusta() {
		return aficionesGusta;
	}

	public void setAficionesGusta(Collection<Aficion> aficionesGusta) {
		this.aficionesGusta = aficionesGusta;
	}
	

	//=============================

	
	public void addAficionGusta(Aficion aficion) {
		this.aficionesGusta.add(aficion);
		aficion.getPersonasGustan().add(this);
	}

	private String encriptar(String password) {
		return (new BCryptPasswordEncoder()).encode(password);
	}
	
	
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + "]";
	}
	
}
