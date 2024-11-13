package grafos;

import java.util.*;
import java.io.*;

public class lecturaFichero <T extends iLecturaFichero>{
	private File fichero;
	private Scanner sc;
	private String separador;
	public lecturaFichero(String directorio) throws FileNotFoundException{
		this.fichero=new File(directorio);
		this.sc=new Scanner(fichero);
		this.separador=",";
	}
	public void leer(T t) {
		String datos[]=sc.nextLine().split(separador);
		t.leerDatos(datos);
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
