package org.ssirbu.pap2021.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssirbu.pap2021.entities.Persona;
import org.ssirbu.pap2021.repository.PersonaRepository;

@Controller
public class HomeController {
	@Autowired
	private PersonaRepository personaRepository;
	
	
	@GetMapping("/info")
	public String info(HttpSession s, ModelMap m) {
		String mensaje = s.getAttribute("_mensaje") != null ? (String) s.getAttribute("_mensaje")
				: "Pulsa para volver a home";
		String severity = s.getAttribute("_severity") != null ? (String) s.getAttribute("_severity") : "info";
		String link = s.getAttribute("_link") != null ? (String) s.getAttribute("_link") : "/";

		s.removeAttribute("_mensaje");
		s.removeAttribute("_severity");
		s.removeAttribute("_link");

		m.put("mensaje", mensaje);
		m.put("severity", severity);
		m.put("link", link);

		m.put("view", "/_t/info");
		return "/_t/frame";
	}

	
	@GetMapping("/login")
	public String login(
			ModelMap m
			) {
		m.put("view","home/login");
		return "_t/frame";
	}
	
	@PostMapping("/login")
	public String loginPost(
			@RequestParam("nom")String nombre,
			@RequestParam("pass")String password,
			HttpSession s //Le pasamso esta variable que es la sesion  , para ver si hay una creada o no  
			) {
		
		String returnLocation = "redirect:/";
		try {
		Persona p = personaRepository.getByNombre(nombre);
		if (new BCryptPasswordEncoder().matches(password,p.getPassword())){
			//Abrimos una sesion que funciona como un map y agregamos los valores que queramo
			s.setAttribute("persona", p);
		}
		}
		catch(Exception e) {
			returnLocation = "redirect:/error)msg=Usuario incorrecto";
		}
		return returnLocation;
	}
	
	@GetMapping("/logout")
	public String logout(
			HttpSession sesion
			) {
		//Borramos la variable de sesion
		sesion.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String index(ModelMap m) {
		m.put("view","home/index");
		return "_t/frame";
	}
}
