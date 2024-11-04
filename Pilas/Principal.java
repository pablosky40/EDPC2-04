/*
 * J_P_M_C2-04
*/
package pilas;

public class Principal {

	public static void main(String[] args) {
		PilaValorMin p1 = new PilaValorMin(); //se instancia la primera pila de este tipo
		PilaValorMin p2 = new PilaValorMin(); // se hace lo mismo con la segunda

		p1.push(5.0); //se empieza a invocar todos los metodos propios de esta pila empezando con el push para introducir los numeros en la pila
		p1.push(3.0);
		p1.push(11.2);
		p1.push(1.2);
		p1.push(4.8);

		p2.push(12.4); //se intoducen los numeros en la otra pila
		p2.push(9.0);
		p2.push(2.1);
		p2.push(7.0);
		p2.push(10.0);

		p1.pop(); //se saca el primer elemento de las pilas
		p2.pop();

		p1.partir(); // se divide el tamaño de las pilas por 2, asi que quedan la mitad de los elementos
		p2.partir();
		
		System.out.println(mostrarPilas(p1)); // se muestran tanto el minimo como el contenido total de las pilas
		System.out.println(mostrarPilas(p2));

	}
	
	public static String mostrarPilas(PilaValorMin p) { // metodo para modularizar la salida del programa
		String cad = "El valor mínimo de la pila: " + p.min();
		cad += ", contenido de la pila" + p;
		return cad;
		
	}

}
