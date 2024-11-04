package pilas;

public class MainPilas {

	public static void main(String[] args) {
		PilaValorMin p1 = new PilaValorMin();
		PilaValorMin p2 = new PilaValorMin();

		p1.push(5.0);
		p1.push(3.0);
		p1.push(11.2);
		p1.push(1.2);
		p1.push(4.8);

		p2.push(12.4);
		p2.push(9.0);
		p2.push(2.1);
		p2.push(7.0);
		p2.push(10.0);

		p1.pop();
		p2.pop();

		p1.partir();
		p2.partir();
		
		System.out.println(mostrarPilas(p1));
		System.out.println(mostrarPilas(p2));

	}
	
	public static String mostrarPilas(PilaValorMin p) {
		String cad = "El valor mínimo de la pila: " + p.min();
		cad += ", contenido de la pila" + p;
		return cad;
		
	}

}
