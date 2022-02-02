package pruebaSpring.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrompetaAdapter implements InstrumentoMusical{
	@Autowired
	private Trompeta trompeta;

	public void tocar() {
		this.trompeta.calentar();
		this.trompeta.sonar();
	}
}
