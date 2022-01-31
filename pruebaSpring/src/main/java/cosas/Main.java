package cosas;

public class Main {
	public static void main(String[] args) {
		A a = new A();
		//Upcastting del hijo al padre 
		A b = new B(); //es como disfrazarlo  y  pude hacer cosas del padre
		C c = new C();
		a.f();
		b.f();
		((B) b).soloB();
		c.f();
		c.soloC();
	}
}
