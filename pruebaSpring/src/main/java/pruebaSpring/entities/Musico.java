package pruebaSpring.entities;

public class Musico {
	
	//private Trompeta trompeta;
	private Guitarra guitarra;
	
	public Musico() {
		//this.trompeta= new Trompeta();
		this.guitarra = new Guitarra();
	}

	
	public void tocar() {
	//	this.trompeta.calentar();
		//this.trompeta.sonar();
		this.guitarra.rasgar();
	}

}
