package org.ssirbu.notasClase2022.helper;

import javax.servlet.http.HttpSession;

import org.ssirbu.notasClase2022.entities.Usuario;
import org.ssirbu.notasClase2022.exception.DangerException;


public class H {
	/**
	 * 
	 * @param 	rolExigido 			Tres posibilidades "anon", "auth", "admin"
	 * @param 	s   				la sesión activa
	 * @throws 	DangerException		si el rol no coincide con el del usuario activo
	 */
	public static void isRolOK(String rolExigido, HttpSession s) throws DangerException {
		String rolActual = "anon";
		if (s.getAttribute("usuario") != null) {
			rolActual = ((Usuario)s.getAttribute("usuario")).getRol()!="admin" ? "auth" : "admin";
		}
		if ((rolActual=="anon" ||  rolActual=="auth") 	&& rolExigido=="admin") {
			throw new DangerException("Rol inadecuado");
		}
		
		if ((rolActual=="anon" ) && rolExigido=="auth") {
			throw new DangerException("Rol inadecuado");
		}
		
		if ((rolActual!="anon" ) && rolExigido=="anon") {
			throw new DangerException("Rol inadecuado");
		}
}
	}
