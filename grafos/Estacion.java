/*
 * J_P_M_C2-04
 * Nombre de la clase: Estacion
 * Nombre de los autores: Jesús Márquez Duque, Miguel Mora Vega, Pablo Santillana Fernandez
 * Fecha de creación: 13/11/2024
 * Versión de la clase: 4.30.0
 * Descripción de la clase: Indica todos los atributos y métodos necesarios para la clase Estacion, que serán los vertices del grafo
 */
package grafos;
import graphsDS_ESI_UCLM_v2.*;//Importa los elementos de la librería de grafos graphsDS_ESI_UCLM_v2

public class Estacion implements iLecturaFichero,Identity {//Implementa las interfaces de lectura de ficheros y la que identifica el vertice del grafo
	//Atributos privados de la clase de tipo cadena de caracteres
	private String identificador;
	private String latitud;
	private String longitud;
	private String nombre;
	private String zona;
	private String numLineas;
	/*
	 * Nombre del método: getIdentificador
	 * Descripcion del método: Obtiene el valor de la variable identificador
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getIdentificador() {
		return identificador;
	}
	/*
	 * Nombre del método: setIdentificador
	 * Descripcion del método: Actualiza el valor de la variable identificador
	 * Argumentos de llamada: 
	 *		identificador: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	/*
	 * Nombre del método: getLatitud
	 * Descripcion del método: Obtiene el valor de la variable latitud
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getLatitud() {
		return latitud;
	}
	/*
	 * Nombre del método: setLatitud
	 * Descripcion del método: Actualiza el valor de la variable latitud
	 * Argumentos de llamada: 
	 *		latitud: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	/*
	 * Nombre del método: getLongitud
	 * Descripcion del método: Obtiene el valor de la variable longitud
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getLongitud() {
		return longitud;
	}
	/*
	 * Nombre del método: setLongitud
	 * Descripcion del método: Actualiza el valor de la variable longitud
	 * Argumentos de llamada: 
	 *		longitud: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	/*
	 * Nombre del método: getNombre
	 * Descripcion del método: Obtiene el valor de la variable nombre
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getNombre() {
		return nombre;
	}
	/*
	 * Nombre del método: setNombre
	 * Descripcion del método: Actualiza el valor de la variable nombre
	 * Argumentos de llamada: 
	 *		nombre: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*
	 * Nombre del método: getZona
	 * Descripcion del método: Obtiene el valor de la variable zona
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getZona() {
		return zona;
	}
	/*
	 * Nombre del método: setZona
	 * Descripcion del método: Actualiza el valor de la variable zona
	 * Argumentos de llamada: 
	 *		zona: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}
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
	 * Nombre del método: leerFichero
	 * Descripcion del método: Guarda lo leído en el fichero en un vector de cadenas
	 * Argumentos de llamada: 
	 *		s: Vector de cadenas de caracteres donde se van a almacenar dicha lectura
	 * Valor de retorno: Void, pues solo guarda
	 * Archivos necesarios: Ninguno
	 */
	public void leerDatos(String [] s) {
		this.identificador=s[0];//Guarda el valor del identificador en la posicion 0
		this.latitud=s[1];//Guarda el valor de la variable latitud en la posicion 1
		this.longitud=s[2];//Guarda el valor de la variable longitud en la posicion 2
		this.nombre=s[3];//Guarda el valor de la variable nombre en la posicion 3
		this.numLineas=s[6];//Guarda el valor de la variable numLineas en la posicion 6
		this.zona=s[5];//Guarda el valor de la variable zona en la posicion 5
	}
	/*
	 * Nombre del método: toString
	 * Descripcion del método: Representa en una cadena de caracteres lo que tiene la clase
	 * Argumentos de llamada: Nunguno
	 * Valor de retorno: String, pues devuelve una cadena de caracteres con lo que tiene la clase
	 * Archivos necesarios: Ninguno
	 */
	public String toString() {
		return "Estacion con: Identificador=" + identificador + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", nombre=" + nombre + ", zona=" + zona + " y numero de líneas=" + numLineas ;
	}
	/*
	 * Nombre del método: getID
	 * Descripcion del método: Obtiene el identificador del vertice del grafo, que será idéntico al atributo identificador
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getID() {
		return identificador;
	}
}
