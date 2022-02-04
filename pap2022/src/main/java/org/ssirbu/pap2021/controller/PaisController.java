package org.ssirbu.pap2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssirbu.pap2021.entities.Pais;
import org.ssirbu.pap2021.repository.PaisRepository;

@Controller
public class PaisController {

	@Autowired
	private PaisRepository paisRepository; //Pedimos a spring el acceso a un repositorio y que lo cablee
	
	@GetMapping("/pais/r")
	public String r(
			//Creamos un model map vacio
			ModelMap m 
			) {
		List<Pais> paises = paisRepository.findAll();
		m.put("paises", paises);
		m.put("view","pais/r");
		return "_t/frame";
	}
	
	@GetMapping("/pais/c")
	public String c(
			ModelMap m
			) {
		m.put("view", "pais/c");
		return "_t/frame";
	}
	
	@PostMapping("/pais/cPost") // Para recibir  datos Post hay que usar PostMapping
	public String cPost(
			@RequestParam("nom") String nombre,
			ModelMap m
			) {
			//Los parametros que vienen del formulario vienen por los corchetes
			paisRepository.save(new Pais(nombre));
		m.put("view", "pais/r");
		return "_t/frame";
	}	
}
