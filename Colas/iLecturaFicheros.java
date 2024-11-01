/*
 * Nombre de la clase: iLecturaFicheros
 * Nombre del autor: Jesús Márquez Duque
 * Fecha de creación: 09/10/2024
 * Versión de la clase: 4.30.0
 * Descripción de la clase: Interfaz del programa que, al ser implementada, se crea un método que guarde los datos del fichero leídos en un objeto/variable
 */
package Colas;

public interface iLecturaFicheros {
	/*
	 * Nombre del método: leerFichero
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Al implemetarse, se guarda los datos del fichero leídos en un objeto/variable
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: Void, no devuelve nada, pues solo guarda datos
	 * Archivos necesarios: Ninguno
	 * La clase es pública (Al ser una interfaz), y abstarcta, pues ha de implemetarse en una clase, no en la interfaz
	 */
	abstract void leerFichero(String[] s);
}
