package org.ssirbu.pap2021.controller.copy2;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssirbu.pap2021.entities.Pais;
import org.ssirbu.pap2021.exception.DangerException;
import org.ssirbu.pap2021.exception.InfoException;
import org.ssirbu.pap2021.exception.PRG;
import org.ssirbu.pap2021.repository.PaisRepository;

@Controller
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository; //Pedimos a spring el acceso a un repositorio y que lo cablee
	
	@GetMapping("r")
	public String r(
			//Creamos un model map vacio
			ModelMap m 
			) {
		List<Pais> paises = paisRepository.findAll();
		m.put("paises", paises);
		m.put("view","pais/r");
		return "_t/frame";
	}
	
	@GetMapping("c")
	public String c(
			ModelMap m
			) {
		m.put("view", "pais/c");
		return "_t/frame";
	}
	
	@PostMapping("cPost") // Para recibir  datos Post hay que usar PostMapping
	public void cPost(
			@RequestParam("nom") String nombre,
			ModelMap m
			) throws DangerException, InfoException {
			//Los parametros que vienen del formulario vienen por los corchetes		
		try {
			paisRepository.save(new Pais(nombre));
			
		}
		catch(Exception e) {
			PRG.error("El pais ya existe" ,"/pais/c");
		}
		PRG.info("El pais se ha insertado correctamente" ,"/pais/r");
	}
	
	@PostMapping("u")
	public String u(
			@RequestParam("pais")Long paisId,
			ModelMap m 
			) {
		Pais pais = paisRepository.getById(paisId);
		m.put("pais", pais);
		m.put("view","pais/u");
		return "_t/frame";
	}
	@PostMapping("uPost")
	public void uPost(
			@RequestParam("nom")String nombre,
			@RequestParam("id")Long id,
			ModelMap m 
			) throws DangerException, InfoException {

		try {
			Pais pais = paisRepository.getById(id);
			pais.setNombre(nombre);
			paisRepository.save(pais);
			
		}
		catch(Exception e) {
			PRG.error("El pais no se ha podido actualizar" ,"/pais/r");
		}
		PRG.info("El pais se ha actualizado correctamente" ,"/pais/r");


	}
	
	@PostMapping("dPost")
	public void dPost(
			@RequestParam("pais")Long id
			) throws DangerException, InfoException {
		try {
			paisRepository.deleteById(id);
			
		}
		catch(Exception e) {
			PRG.error("El pais no se ha podido eliminar"+e.getMessage(),"/pais/r");
		}
		
		PRG.info("El pais se ha eliminado" ,"/pais/r");

	}
}
