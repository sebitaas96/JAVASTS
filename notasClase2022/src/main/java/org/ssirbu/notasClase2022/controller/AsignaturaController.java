package org.ssirbu.notasClase2022.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssirbu.notasClase2022.entities.Asignatura;
import org.ssirbu.notasClase2022.exception.DangerException;
import org.ssirbu.notasClase2022.exception.InfoException;
import org.ssirbu.notasClase2022.exception.PRG;
import org.ssirbu.notasClase2022.service.AsignaturaService;



@Controller
@RequestMapping("/asignatura")
public class AsignaturaController {

	@Autowired
	private AsignaturaService asignaturaService;
	
	@GetMapping("r")
	public String r(
			//Creamos un model map vacio
			ModelMap m 
			) {
		List<Asignatura> asignaturas = asignaturaService.findAll();
		m.put("asignaturas", asignaturas);
		m.put("view","asignatura/r");
		return "_t/frame";
	}
	
	@GetMapping("c")
	public String c(
			ModelMap m
			) {
		m.put("view", "asignatura/c");
		return "_t/frame";
	}
	
	@PostMapping("cPost") // Para recibir  datos Post hay que usar PostMapping
	public void cPost(
			@RequestParam("nom") String nombre,
			ModelMap m
			) throws DangerException, InfoException {
			//Los parametros que vienen del formulario vienen por los corchetes		
		try {
			asignaturaService.crearAsignatura(nombre);
		}
		catch(Exception e) {
			PRG.error("Ha habido un error añadiendo la asignatura "+e.getMessage() ,"/asignatura/c");
		}
		PRG.info("La asignatura se ha insertado correctamente" ,"/asignatura/r");
	}
	
	@PostMapping("u")
	public String u(
			@RequestParam("asignatura")Long asignaturaId,
			ModelMap m 
			) {
		Asignatura asignatura= asignaturaService.getById(asignaturaId);
		m.put("asignatura", asignatura);
		m.put("view","asignatura/u");
		return "_t/frame";
	}
	@PostMapping("uPost")
	public void uPost(
			@RequestParam("nom")String nombre,
			@RequestParam("id")Long id
			) throws DangerException, InfoException {

		try {
			asignaturaService.updateAsignatura(id , nombre);
		}
		catch(Exception e) {
			PRG.error("La asignatura no se ha podido actualizar"+e.getMessage() ,"/asignatura/r");
		}
		PRG.info("La asignatura se ha actualizado correctamente" ,"/asignatura/r");


	}
	
	@PostMapping("dPost")
	public void d(
			@RequestParam("asignatura")Long id
			) throws DangerException, InfoException {
		try {
			asignaturaService.deleteById(id);
		}
		catch(Exception e) {
			PRG.error("La asignatura no se ha podido eliminar"+e.getMessage(),"/asignatura/r");
		}
		
		PRG.info("La asignatura se ha eliminado" ,"/asignatura/r");

	}
	
}
