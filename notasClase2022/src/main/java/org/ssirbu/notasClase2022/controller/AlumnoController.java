package org.ssirbu.notasClase2022.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssirbu.notasClase2022.entities.Alumno;
import org.ssirbu.notasClase2022.entities.Asignatura;
import org.ssirbu.notasClase2022.exception.DangerException;
import org.ssirbu.notasClase2022.exception.InfoException;
import org.ssirbu.notasClase2022.exception.PRG;
import org.ssirbu.notasClase2022.service.AlumnoService;
import org.ssirbu.notasClase2022.service.AsignaturaService;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	@Autowired
	private AlumnoService alumnoService;
	@Autowired
	private AsignaturaService asignaturaService;
	
	@GetMapping("r")
	public String r(
			//Creamos un model map vacio
			ModelMap m 
			) {
		List<Alumno> alumnos = alumnoService.findAll();
		m.put("alumnos", alumnos);
		m.put("view","alumno/r");
		return "_t/frame";
	}
	
	@GetMapping("c")
	public String c(
			ModelMap m
			) {
		List<Asignatura> asignaturas = asignaturaService.findAll();
		System.out.println(asignaturas);
		m.put("asignaturas", asignaturas);
		m.put("view", "alumno/c");
		return "_t/frame";
	}
	
	@PostMapping("cPost") 
	public void cPost(
			@RequestParam("dni") String dni,
			@RequestParam("nom") String nombre,
			@RequestParam("ape") String apellido,
			@RequestParam("pass") String pwd,
			@RequestParam(value="asigMatriculado[]" ,required=false)List<Long>asigMatriculado
			) throws DangerException, InfoException {
	
		try {
			alumnoService.crearAlumno(dni ,nombre ,apellido , pwd , asigMatriculado);
		}
		catch(Exception e) {
			PRG.error("Ha habido un error añadiendo al alumno"+e.getMessage() ,"/alumno/c");
		}
		PRG.info("El alumno se ha insertado correctamente" ,"/alumno/r");
	}
}
