package org.ssirbu.pap2021.entities.copy;



import java.time.LocalDate;
import java.time.Period;
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
	private String dni; 
	private String nombre; 
	private String apellido; 
	private String password;

	//============================	
	public Persona() {
		this.nombre = "Jhon";
		this.apellido="Doe"
	}

	public Persona(String nombre , String password , Pais nace ,Pais vive,LocalDate fNacimiento ) {
		this.nombre = nombre;
		this.aficionesGusta = new ArrayList<Aficion>();
		this.aficionesDisgusta = new ArrayList<Aficion>();
		this.password= encriptar(password);
		this.nace = nace;
		this.nace.getNativos().add(this);
		this.vive = vive;
		this.vive.getResidentes().add(this);
		this.setfNacimiento(fNacimiento);
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
	
	
	public Pais getVive() {
		return vive;
	}

	public void setVive(Pais vive) {
		this.vive = vive;
		this.vive.getResidentes().add(this);
	}

	public LocalDate getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(LocalDate fNacimiento) {
		this.fNacimiento = fNacimiento;
	}


	public Collection<Aficion> getAficionesGusta() {
		return aficionesGusta;
	}

	public void setAficionesGusta(Collection<Aficion> aficionesGusta) {
		this.aficionesGusta = aficionesGusta;
	}
	public Collection<Aficion> getAficionesDisgusta() {
		return aficionesDisgusta;
	}

	public void setAficionesDisgusta(Collection<Aficion> aficionesDisgusta) {
		this.aficionesDisgusta = aficionesDisgusta;
	}
	
	
	//=============================

	
	public void addAficionGusta(Aficion aficion) {
		this.aficionesGusta.add(aficion);
		aficion.getPersonasGustan().add(this);
	}
	
	public void addAficionDisgusta(Aficion aficion) {
		this.aficionesDisgusta.add(aficion);
		aficion.getPersonasDisgustan().add(this);
	}


	private String encriptar(String password) {
		return (new BCryptPasswordEncoder()).encode(password);
	}
	
	public Integer getEdad() {
		int sol =0;
		LocalDate hoy = LocalDate.now();
		LocalDate fNac = this.getfNacimiento();
		if(fNac !=null) {
			Period intervalo = Period.between(fNac, hoy);
			sol = intervalo.getYears();
		}
		return sol;
	}
	
	public String getRol() {
		return nombre.equals("admin")?"admin":"auth";
	}
	
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + "]";
	}




	
}
