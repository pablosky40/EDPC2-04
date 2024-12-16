/*
 * J_P_M_C2-04
 * Nombre de la clase: Trayecto
 * Nombre de los autores: Jesús Márquez Duque, Miguel Mora Vega, Pablo Santillana Fernandez
 * Fecha de creación: 13/11/2024
 * Versión de la clase: 4.30.0
 * Descripción de la clase: Indica todos los atributos y métodos necesarios para la clase Trayecto, que serán las aristas del grafo
 */
package grafos;
import graphsDS_ESI_UCLM_v2.*;//Importa los elementos de la librería de grafos graphsDS_ESI_UCLM_v2
public class Trayecto implements iLecturaFichero,Identity{//Implementa las interfaces de lectura de ficheros y la que identifica el vertice del grafo
	//Atributos privados de la clase de tipo cadena de caracteres
	private String identificador;
	private String estacion1;
	private String estacion2;
	private String numLineas;
	/*
	 * Nombre del método: getNumLineas
	 * Descripcion del método: Obtiene el valor de la variable numLineas
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getNumLineas() {
		return numLineas;
	}
	/*
	 * Nombre del método: setNumLineas
	 * Descripcion del método: Actualiza el valor de la variable numLineas
	 * Argumentos de llamada: 
	 *		numLineas: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setNumLineas(String numLineas) {
		this.numLineas = numLineas;
	}
	/*
	 * Nombre del método: getEstacion1
	 * Descripcion del método: Obtiene el valor de la variable estacion1
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getEstacion1() {
		return estacion1;
	}
	/*
	 * Nombre del método: setEstacion1
	 * Descripcion del método: Actualiza el valor de la variable estacion1
	 * Argumentos de llamada: 
	 *		estacion1: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setEstacion1(String estacion1) {
		this.estacion1 = estacion1;
	}
	/*
	 * Nombre del método: getEstacion2
	 * Descripcion del método: Obtiene el valor de la variable estacion2
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getEstacion2() {
		return estacion2;
	}
	/*
	 * Nombre del método: setEstacion2
	 * Descripcion del método: Actualiza el valor de la variable estacion2
	 * Argumentos de llamada: 
	 *		estacion2: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setEstacion2(String estacion2) {
		this.estacion2 = estacion2;
	}
	/*
	 * Nombre del método: toString
	 * Descripcion del método: Representa en una cadena de caracteres lo que tiene la clase
	 * Argumentos de llamada: Nunguno
	 * Valor de retorno: String, pues devuelve una cadena de caracteres con lo que tiene la clase
	 * Archivos necesarios: Ninguno
	 */
	public String toString() {
		return "Linea con estacion1=" + estacion1 + ", estacion2=" + estacion2+", y con "+numLineas+" líneas" ;
	}
	/*
	 * Nombre del método: leerFichero
	 * Descripcion del método: Guarda lo leído en el fichero en un vector de cadenas
	 * Argumentos de llamada: 
	 *		s: Vector de cadenas de caracteres donde se van a almacenar dicha lectura
	 * Valor de retorno: Void, pues solo guarda
	 * Archivos necesarios: Ninguno
	 */
	public void leerDatos(String []s) {
		this.estacion1=s[0];//Guarda el valor de la variable estacion1 en la posicion 0
		this.estacion2=s[1];//Guarda el valor de la variable estacion2 en la posicion 1
		this.numLineas=s[2];//Guarda el valor de la variable numLineas en la posicion 2
	}
	/*
	 * Nombre del método: getID
	 * Descripcion del método: Obtiene el identificador de la arista del grafo, que será idéntico al atributo identificador
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getID() {
		return identificador;
	}
	
}
