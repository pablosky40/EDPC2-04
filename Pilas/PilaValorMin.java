/*
 * J_P_M_C2-04
*/
package pilas;

import java.util.*;
 
public class PilaValorMin extends Stack<Double> {

	private Stack<Double> pilaMinima; //se declara la pila

	public PilaValorMin() {
		super();
		pilaMinima = new Stack<Double>();
	}
	/*
	 * Nombre del método: PilaValorMin
	 * Descripcion del método: Es un constructor de la pila de este tipo
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: Ninguno, es para instanciar
	 * Archivos necesarios: Ninguno
	 */
	public Double push(Double num) {
		if (empty())
			pilaMinima.push(num);
		else if (num <= pilaMinima.peek())
			pilaMinima.push(num);
		return super.push(num);
	}
	/*
	 * Nombre del método: push
	 * Descripcion del método: Introduce el elemento de entrada a la pila segun las restricciones del valor que tenga
	 * Argumentos de llamada: num(el elemento que queremos meter a la pila)
	 * Valor de retorno: la pila
	 * Archivos necesarios: Ninguno
	 */
	public Double pop() {
		Double valor = super.pop();
		if (valor.equals(pilaMinima.peek())) {
			pilaMinima.pop();
		}
		return valor;

	}
	/*
	 * Nombre del método: pop
	 * Descripcion del método: Elimina el elemento de la cima de la pila segun las restricciones
	 * Argumentos de llamada: no
	 * Valor de retorno: la pila sin el elemento eliminado
	 * Archivos necesarios: Ninguno
	 */
	public Double min() {
		return pilaMinima.peek();

	}
	/*
	 * Nombre del método: min
	 * Descripcion del método: devuelve el valor del elemento de la cima, que en este tipo de pila es el valor minimo
	 * Argumentos de llamada: no
	 * Valor de retorno: el elemento de la cima
	 * Archivos necesarios: Ninguno
	 */
	public void partir() {
		int mitad = size() / 2;
		for (int i = 0; i < mitad; i++)
			pop();
	}
	/*
	 * Nombre del método: partir
	 * Descripcion del método: divide el numero de elementos de la pila por 2, se queda media pila
	 * Argumentos de llamada: no
	 * Valor de retorno: ninguno, reduce el tamaño de la pila a la mitad
	 * Archivos necesarios: Ninguno
	 */
	@Override
	public String toString() {
		return "[pilaMinima=" + pilaMinima + "]";
	}

}
