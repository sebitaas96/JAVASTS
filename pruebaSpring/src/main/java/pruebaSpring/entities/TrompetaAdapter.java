package pruebaSpring.entities;

public class TrompetaAdapter implements InstrumentoMusical{
	private Trompeta trompeta;
	
	public TrompetaAdapter() {
		this.trompeta = new Trompeta();
	}
	public void tocar() {
		this.trompeta.calentar();
		this.trompeta.sonar();
	}
}
