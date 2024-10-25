package Pilas;
import java.util.Stack;
public class PilaValorMin extends Stack <Float> {
	private Stack <Float> pilaMinima;
	public PilaValorMin() {
		super();
		pilaMinima=new Stack <>();
	}
	public Float push(Float numero) {
		if(pilaMinima.empty()) {
			pilaMinima.push(numero);
		}
		else if(numero<=super.peek()) {
			pilaMinima.push(numero);
		}
		super.push(numero);
		return numero;
	}
	public void pop(Float numero) {
		if(numero>super.peek()) {
			pilaMinima.pop();
		}
		super.pop();
	}
	public Float min() {
		return pilaMinima.peek();
	}
	public void partir() {
		int mitad=size()/2;
		for(int i=0; i<mitad;i++) {
			pop();
		}
	}
	public String toString() {
		return "La pila auxiliar contiene los elementos: "+super.toString()+" y la de valor mínimo contiene"
				+ "los elementos: "+pilaMinima;
	}
}
