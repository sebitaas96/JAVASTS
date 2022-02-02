package pruebaSpring.entities;

import org.springframework.stereotype.Component;

@Component
public class Trompeta {
	
	public void  calentar() {
		System.out.println("Calentando");
	}
	
	public void sonar() {
		System.out.println("PUEEET");
	}
}
