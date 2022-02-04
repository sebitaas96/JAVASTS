package org.ssirbu.pap2021.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssirbu.pap2021.entities.Persona;
import org.ssirbu.pap2021.repository.PersonaRepository;

@Controller
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository; //Pedimos a spring el acceso a un repositorio y que lo cablee
	
	@GetMapping("/persona/r")
	public String r(
			//Creamos un model map vacio
			ModelMap m 
			) {
		List<Persona> paises = personaRepository.findAll();
		m.put("personas", paises);
		m.put("view","persona/r");
		return "_t/frame";
	}
	
	@GetMapping("/persona/c")
	public String c(ModelMap m) {
		m.put("view","persona/c");
		return "_t/frame";
	}
	
	@PostMapping("/persona/cPost") // Para recibir  datos Post hay que usar PostMapping
	public String cPost(
			@RequestParam("nom") String nombre,
			ModelMap m
			) {
			//Los parametros que vienen del formulario vienen por los corchetes
			personaRepository.save(new Persona(nombre));
			m.put("view","persona/r");
			return "_t/frame";
	}	
}
