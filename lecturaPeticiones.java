package Peticiones;

import java.io.*;
import java.util.*;

public class lecturaPeticiones <T extends iLecturaFicheros> {

	private File fichero;
	private Scanner sc;
	private String separador;
	public lecturaPeticiones(String nombreFichero)throws FileNotFoundException {
		this.fichero=new File(nombreFichero);
		this.sc=new Scanner(fichero);
		this.separador=";";
	}
	public void leer(T t) {
		String c[]=sc.nextLine().split(separador);
		t.leerFichero(c);
	}
	public void saltar() {
		sc.nextLine();
	}
	public void cerrar() {
		sc.close();
	}
	public boolean finLectura() {
		return sc.hasNextLine();
	}
	
}
