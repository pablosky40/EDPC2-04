/* 
 * J_P_M_C2-04
 * Nombre de la clase: iLecturaFicheros
 * Nombre de los autores: Jesús Márquez Duque, Miguel Mora Vega y Pablo Santillana Fernandez
 * Fecha de creacion: 13/11/2024
 * Version de la clase: 4.30.0
 * Descripción de la clase: Interfaz del programa que, al ser implementada, se crea un método que guarde los datos del fichero leídos en un objeto/variable
 */
package grafos;
public interface iLecturaFichero {
	/*
	 * Nombre del método: leerFichero
	 * Descripcion del método: Al implemetarse, se guarda los datos del fichero leídos en un objeto/variable
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: Void, no devuelve nada, pues solo guarda datos
	 * Archivos necesarios: Ninguno
	 * La clase es pública (Al ser una interfaz), y abstarcta, pues ha de implemetarse en una clase, no en la interfaz
	 */
	abstract void leerDatos(String [] s);
}
