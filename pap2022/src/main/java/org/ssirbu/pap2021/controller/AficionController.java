package org.ssirbu.pap2021.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssirbu.pap2021.entities.Aficion;
import org.ssirbu.pap2021.exception.DangerException;
import org.ssirbu.pap2021.exception.InfoException;
import org.ssirbu.pap2021.exception.PRG;
import org.ssirbu.pap2021.repository.AficionRepository;


@Controller
public class AficionController {

	@Autowired
	private AficionRepository aficionRepository; //Pedimos a spring el acceso a un repositorio y que lo cablee
	
	@GetMapping("/aficion/r")
	public String r(
			//Creamos un model map vacio
			ModelMap m 
			) {
		List<Aficion> aficiones= aficionRepository.findAll();
		m.put("aficiones", aficiones);
		m.put("view","aficion/r");
		return "_t/frame";
	}
	
	@GetMapping("/aficion/c")
	public String c(ModelMap m) {
		m.put("view","aficion/c");
		return "_t/frame";
	}
	
	@PostMapping("/aficion/cPost") // Para recibir  datos Post hay que usar PostMapping
	public void cPost(
			@RequestParam("nom") String nombre,
			ModelMap m
			) throws DangerException, InfoException {
		//Los parametros que vienen del formulario vienen por los corchetes
		try {
			aficionRepository.save(new Aficion(nombre));
		}
		catch(Exception e) {
			PRG.error("La aficion ya existe" ,"/aficion/c");
		}
		PRG.info("La aficion se ha insertado correctamente" ,"/aficion/r");
	
	}	
}
