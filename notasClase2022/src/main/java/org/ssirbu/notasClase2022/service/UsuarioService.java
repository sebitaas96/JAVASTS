package org.ssirbu.notasClase2022.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.ssirbu.notasClase2022.entities.Usuario;
import org.ssirbu.notasClase2022.repository.UsuarioRepository;
@Service
public class UsuarioService {
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private 
	
	
	public void login(String nombre ,String pwd) {
		Usuario u = null;
		if (new BCryptPasswordEncoder().matches(password,u.getPassword())){
			//Abrimos una sesion que funciona como un map y agregamos los valores que queramo
			s.setAttribute("usuario", u);
		}
		
	}
}
