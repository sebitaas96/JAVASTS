package org.ssirbu.notasClase2022.entities;



import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	private String dni;
	private String nombre; 
	private String apellido;
	private String password;



	//============================	
	public Usuario() {
		this.dni = "0";
		this.nombre = "Jhon";
		this.apellido = "Doe";
	}

	public Usuario(String dni, String nombre , String apellido, String password){
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password= encriptar(password);
	}

	
	//=============================
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
	//=============================

	


	private String encriptar(String password) {
		return (new BCryptPasswordEncoder()).encode(password);
	}
	
	
	public String getRol() {
		return nombre.equals("admin")?"admin":"auth";
	}
	
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + "]";
	}




	
}
