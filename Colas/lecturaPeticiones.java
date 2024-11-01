/*
 * Nombre de la clase: lecturaPeticiones
 * Nombre del autor: Jesús Márquez Duque
 * Fecha de creación: 09/10/2024
 * Versión de la clase: 4.30.0
 * Descripción de la clase: Lee el fichero, de forma secuencial, de las peticiones de billetes de tren
 */
package Colas;

import java.io.*;//Importa diversos elementos en la clase, en cuanto a lectura de ficheros
import java.util.*;//Importa diversos elementos en la clase, en cuanto a entrada/salida

public class lecturaPeticiones <T extends iLecturaFicheros> {//Se crea una variable genérica que hereda de la interfaz del programa

	private File fichero;//Archivo que va a leerse
	private Scanner sc;//Escáner que va a leer el archivo
	private String separador;//Cadena de caracteres que separa las variables al detectar dicha cadena
	/*
	 * Nombre del método: lecturaPeticiones
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Indica qué variables son necesarias de crear para implementar la clase
	 * Argumentos de llamada:
	 * 		nombreFichero: Cadena de caracteres que indica dónde se localiza el fichero
	 * Valor de retorno: Void, no devuelve nada, pues es un constructor
	 * Archivos necesarios: Un archivo de datos (.csv, .txt, etc.)
	 * El archivo no hace falta que esté abierto
	 * FileNotFoundexception, que salta si el archivo no se ha encontrado
	 */
	public lecturaPeticiones(String nombreFichero)throws FileNotFoundException {
		this.fichero=new File(nombreFichero);//Crea un archivo
		this.sc=new Scanner(fichero);//Crea un escáner que lee el archivo anterior
		this.separador=";";
	}
	/*
	 * Nombre del método: leer
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Lee un fichero, de forma secuencial, a partir de un tipo de dato
	 * Argumentos de llamada:
	 * 		t: Variable de tipo genérico de la que va a partir la lectura del fichero
	 * Valor de retorno: Void, no devuelve nada, solo lee el fichero
	 * Archivos necesarios: Un archivo de datos (.csv, .txt, etc.)
	 * El archivo no hace falta que esté abierto
	 */
	public void leer(T t) {
		String c[]=sc.nextLine().split(separador);//Cadena de caracteres que guarda los datos que lee el fichero, separados por la cadena de caracteres separador
		t.leerFichero(c);//Guarda los datos leídos en la variable generica
	}
	/*
	 * Nombre del método: saltar
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Salta a la linea siguiente de lectura cuando se le indica
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: Void, no devuelve nada, solo salta una linea en el fichero
	 * Archivos necesarios: Un archivo de datos (.csv, .txt, etc.)
	 * El archivo no hace falta que esté abierto
	*/
	public void saltar() {
		sc.nextLine();
	}
	/*
	 * Nombre del método: cerrar
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Cierra la lectura del fichero cuando se le indica
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: Void, no devuelve nada, cierra el fichero
	 * Archivos necesarios: Un archivo de datos (.csv, .txt, etc.)
	 * El archivo no hace falta que esté abierto
	 */
	public void cerrar() {
		sc.close();
	}
	/*
	 * Nombre del método: finLectura
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Indica cuando la lectura del fichero se termina
	 * Argumentos de llamada:Ninguno 
	 * Valor de retorno: Boolean, que devuelve true cuando la lectura del fichero se termina
	 * Archivos necesarios: Un archivo de datos (.csv, .txt, etc.)
	 * El archivo no hace falta que esté abierto
	 */
	public boolean finLectura() {
		return sc.hasNextLine();
	}
	
}

