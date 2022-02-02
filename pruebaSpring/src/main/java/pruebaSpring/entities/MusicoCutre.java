package pruebaSpring.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicoCutre {
	@Autowired //Cuando ve esta anotacion, la asocia con su bolsa de componentes SPRING
	private Guitarra guitarra;

	public void tocar() {
		this.guitarra.rasgar();
	}

}
