package org.ssirbu.pap2021.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssirbu.pap2021.entities.Aficion;
import org.ssirbu.pap2021.entities.Pais;
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
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@RequestParam("fNacimiento")
			LocalDate fNacimiento,
			//Si ponemos el required false podemos decir que podemso asumir que no venga nada en este parametro
			@RequestParam(value="afiGusta[]", required=false)List<Long>afiGustaIds,
			ModelMap m
			) throws DangerException, InfoException {
			//Los parametros que vienen del formulario vienen por los corchetes
		try {
			Persona p = new Persona(nombre , password,paisRepository.getById(naceId),fNacimiento);
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
	
	
	@PostMapping("/persona/u")
	public String u(
			@RequestParam("persona")Long personaId,
			ModelMap m 
			) {
		Persona persona = personaRepository.getById(personaId);
		List<Pais>paises = paisRepository.findAll();
		List<Aficion>aficiones = aficionRepository.findAll();
		
		m.put("persona", persona);
		m.put("paises" , paises);
		m.put("aficiones", aficiones);
		m.put("view","persona/u");
		return "_t/frame";
	}
	@PostMapping("/persona/uPost")
	public void uPost(
			@RequestParam("nom")String nombre,
			@RequestParam("idPersona")Long id,
			@RequestParam("nace")Long idNace,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			@RequestParam("fNacimiento")
			LocalDate fNacimiento,
			@RequestParam(value="afiGusta[]" , required=false) List<Long> idsAficion,
			ModelMap m 
			) throws DangerException, InfoException {

		try {
			
			Persona persona = personaRepository.getById(id);
			persona.setNombre(nombre);
			persona.setfNacimiento(fNacimiento);
			
			if(idNace != persona.getNace().getId()) {
				Pais nuevoPaisNacimiento  = paisRepository.getById(idNace);
				persona.setNace(nuevoPaisNacimiento);
			}
			
			ArrayList<Aficion> nuevasAficiones = new ArrayList<Aficion>();
			
			if(idsAficion !=null) {
				for (Long idAficion : idsAficion) {
					nuevasAficiones.add(aficionRepository.getById(idAficion));
				}
			}
			persona.setAficionesGusta(nuevasAficiones);	
			personaRepository.save(persona);
			}
		catch(Exception e) {
			PRG.error("La persona no se ha podido actualizar" ,"/persona/r");
		}
		PRG.info("La persona se ha actualizado correctamente" ,"/persona/r");


	}
}
