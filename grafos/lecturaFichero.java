/*
 * J_P_M_C2-04
 * Nombre de la clase: lecturaPeticiones
 * Nombre de los autores: Jesús Márquez Duque, Miguel Mora Vega, Pablo Santillana Fernandez
 * Fecha de creación: 13/11/2024
 * Versión de la clase: 4.30.0
 * Descripción de la clase: Lee el fichero, de forma secuencial, de las peticiones de un objeto
 */
package grafos;

import java.util.*;//Importa diversos elementos en la clase, en cuanto a entrada/salida
import java.io.*;//Importa diversos elementos en la clase, en cuanto a lectura de ficheros

public class LecturaFichero <T extends iLecturaFichero>{//Se crea una variable genérica que hereda de la interfaz del programa
	private File fichero;//Archivo que va a leerse
	private Scanner sc;//Escáner que va a leer el archivo
	private String separador;//Cadena de caracteres que separa las variables al detectar dicha cadena
	/*
	 * Nombre del método: lecturaPeticiones
	 * Descripcion del método: Es el constructor de la clase
	 * Argumentos de llamada:
	 * 		nombreFichero: Cadena de caracteres que indica dónde se localiza el fichero
	 * Valor de retorno: Un objeto de la misma clase, pues es el constructor
	 * Archivos necesarios: Un archivo de datos (.csv, .txt, etc.)
	 * El archivo no hace falta que esté abierto
	 * FileNotFoundexception, que salta si el archivo no se ha encontrado
	 */
	public LecturaFichero(String directorio) throws FileNotFoundException{
		this.fichero=new File(directorio);//Crea un archivo
		this.sc=new Scanner(fichero);//Crea un escáner que lee el archivo anterior
		this.separador=",";
	}
	/*
	 * Nombre del método: leer
	 * Descripcion del método: Lee un fichero, de forma secuencial, a partir de un tipo de dato
	 * Argumentos de llamada:
	 * 		t: Variable de tipo genérico de la que va a partir la lectura del fichero
	 * Valor de retorno: Void, no devuelve nada, solo lee el fichero
	 * Archivos necesarios: Un archivo de datos (.csv, .txt, etc.)
	 * El archivo no hace falta que esté abierto
	 */
	public void leer(T t) {
		String datos[]=sc.nextLine().split(separador);//Cadena de caracteres que guarda los datos que lee el fichero, separados por la cadena de caracteres separador
		t.leerDatos(datos);//Guarda los datos leídos en la variable generica
	}
	/*
	 * Nombre del método: cerrar
	 * Descripcion del método: Cierra la lectura del fichero cuando se le indica
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: Void, no devuelve nada, cierra el fichero
	 * Archivos necesarios: Un archivo de datos (.csv, .txt, etc.)
	 * El archivo no hace falta que esté abierto
	 */
	public void saltar() {
		sc.nextLine();
	}
	/*
	 * Nombre del método: cerrar
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
