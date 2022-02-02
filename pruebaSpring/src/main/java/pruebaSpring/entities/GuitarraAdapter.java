package pruebaSpring.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuitarraAdapter implements InstrumentoMusical {
	@Autowired
	private Guitarra guitarra;
	
	public void tocar() {
		this.guitarra.rasgar();
	}
}
