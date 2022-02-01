package pruebaSpring.entities;



public class Musico {
	
	private InstrumentoMusical instrumento;
	
	public Musico(){
		InstrumentoMusicalFactory imf = InstrumentoMusicalFactory.getIMF();
		this.instrumento = imf.getInstrumento();
	}

	
	public void tocar() {
		this.instrumento.tocar();
	}

}
