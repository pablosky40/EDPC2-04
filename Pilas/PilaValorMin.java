/*
 * J_P_M_C2-04
*/
package pilas;

import java.util.*;
 
public class PilaValorMin extends Stack<Double> {

	private Stack<Double> pilaMinima;

	public PilaValorMin() {
		super();
		pilaMinima = new Stack<Double>();
	}

	public Double push(Double num) {
		if (empty())
			pilaMinima.push(num);
		else if (num <= pilaMinima.peek())
			pilaMinima.push(num);
		return super.push(num);
	}

	public Double pop() {
		Double valor = super.pop();
		if (valor.equals(pilaMinima.peek())) {
			pilaMinima.pop();
		}
		return valor;

	}

	public Double min() {
		return pilaMinima.peek();

	}

	public void partir() {
		int mitad = size() / 2;
		for (int i = 0; i < mitad; i++)
			pop();
	}

	@Override
	public String toString() {
		return "[pilaMinima=" + pilaMinima + "]";
	}

}
