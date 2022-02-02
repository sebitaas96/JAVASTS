package pruebaSpring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pruebaSpring.entities.Musico;
import pruebaSpring.entities.MusicoCutre;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Comienza la fiesta");
		//Musico musico = new Musico();
		//musico.tocar();
		
		//Vemmos como cargar spring
			/*1-Le damos la vuelta al control para darselo a SpringBoot: IOC inversion of control*/
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");;
			/*2-Anotamos el main con ComponentScan y las clases normales con Component*/
			/*3-Interactuar con los objetos que spring ya ha escaneado ,entonces le decimos
			 * al contexto que nos de un bean con la clase que ha escnaedo OJOOOO: EL NOMBRE
			 * DE LAS CLASES LAS PONE EN MINUSCULA*/
				Musico mc =(Musico) context.getBean("sebas");
				mc.tocar();
	}
	
	

}
