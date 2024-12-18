//Nombre de la clase: FicheroSecuencial
//Nombre del autor: Jesús Márquez Duque
//Fecha de creacion: 25/09/2024
//Version de la clase: 4.30.0
package FicheroSecuencial;
import java.util.*;
import java.io.*;
public class ficheroSecuencial <T extends iLectorFicheroSecuencial<satelite>>{
	private File fichero;
	private Scanner escaner;
	private String separador;
	public ficheroSecuencial(String nombreFichero, String separador)throws FileNotFoundException {
		this.fichero = new File(nombreFichero);
		this.escaner = new Scanner(fichero);
		this.separador = separador;
	}
	public void leer(T t) {
		String [] datos=escaner.nextLine().split(separador);
		t.readData(datos);
	}
	public void saltar() {
		escaner.nextLine();
	}
	public void cerrar() {
		escaner.close();
	}
	public boolean finLectura() {
		return escaner.hasNextLine();
	}
}
