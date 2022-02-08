package org.ssirbu.pap2021.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssirbu.pap2021.entities.Persona;
import org.ssirbu.pap2021.exception.DangerException;
import org.ssirbu.pap2021.exception.InfoException;
import org.ssirbu.pap2021.exception.PRG;
import org.ssirbu.pap2021.repository.AficionRepository;
import org.ssirbu.pap2021.repository.PaisRepository;
import org.ssirbu.pap2021.repository.PersonaRepository;

@Controller
public class PersonaController {

	@Autowired
	private PersonaRepository personaRepository; //Pedimos a spring el acceso a un repositorio y que lo cablee
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private AficionRepository aficionRepository;
	
	@GetMapping("/persona/r")
	public String r(
			//Creamos un model map vacio
			ModelMap m 
			) {
		List<Persona> personas = personaRepository.findAll();
		m.put("personas", personas);
		m.put("view","persona/r");
		return "_t/frame";
	}
	
	@GetMapping("/persona/c")
	public String c(ModelMap m) {
		m.put("paises", paisRepository.findAll());
		m.put("aficiones", aficionRepository.findAll());
		m.put("view","persona/c");
		return "_t/frame";
	}
	
	@PostMapping("/persona/cPost") // Para recibir  datos Post hay que usar PostMapping
	public void cPost(
			@RequestParam("nom") String nombre,
			@RequestParam("pass") String password,
			@RequestParam("nace") Long naceId,
			//Si ponemos el required false podemos decir que podemso asumir que no venga nada en este parametro
			@RequestParam(value="afiGusta[]", required=false)List<Long>afiGustaIds,
			ModelMap m
			) throws DangerException, InfoException {
			//Los parametros que vienen del formulario vienen por los corchetes
		try {
			Persona p = new Persona(nombre , password,paisRepository.getById(naceId));
			if(afiGustaIds !=null) {
				for(Long id : afiGustaIds) {
					p.addAficionGusta(aficionRepository.getById(id));
				}
			}

			personaRepository.save(p);
		}
		catch(Exception e) {
			PRG.error("Error identerminado al crear a la persona: "+e.getMessage() ,"/persona/c");
		}
		PRG.info("La persona se ha insertado correctamente" ,"/persona/r");
	}	
}
