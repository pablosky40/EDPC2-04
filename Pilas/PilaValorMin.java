package Pilas;
import java.util.Stack;
public class PilaValorMin extends Stack<Float> {

	private Stack<Float> pilaMinima;

	public PilaValorMin() {
		super();
		pilaMinima = new Stack<Float>();
	}

	public Float push(Float num) {
		if (empty())
			pilaMinima.push(num);
		else if (num <= pilaMinima.peek())
			pilaMinima.push(num);
		return super.push(num);
	}

	public Float pop() {
		Float valor = super.peek();
		if (valor.equals(pilaMinima.peek())) {
			pilaMinima.pop();
		}
		return valor;
		
	}

	public Float min() {
		return pilaMinima.peek();

	}

	public void partir() {
		int mitad = size() / 2;
		for (int i = 0; i < mitad; i++)
			pop();
	}

	public String toString() {
		return "La pila auxiliar contiene los elementos: "+super.toString()+" y la de valor mínimo contiene"
				+ "los elementos: "+pilaMinima;
	}
}
