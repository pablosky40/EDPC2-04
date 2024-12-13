package P5;
import graphsDS_ESI_UCLM_v2.*; 

// Clase que extiende la funcionalidad de un objeto con Decorator
public class Visitar<DA> extends Decorator {
	private boolean visitado; // Indicaremos si es true o falsevisitado
	private Visitar padre; // Respecto al  nodo o elemento padre en el recorrido

	// Constructor que inicializa la clase con los datos y establece valores predeterminados
	public Visitar(DA datos) {
		super(datos); // Llama al constructor de la clase base Decorator
		visitado = false; // Inicialmente, el nodo esta en false
		padre = null; // Inicialmente, el nodo no tiene un padre
	}

	// Método para verificar si el nodo ha sido visitado
	public boolean isVisitado() {
		return visitado;
	}

	// Método para marcar el nodo como visitado o no visitado
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	// Método para obtener el nodo padre
	public Visitar getPadre() {
		return padre;
	}

	// Método para establecer el nodo padre
	public void setPadre(Visitar padre) {
		this.padre = padre;
	}

	// Método que devuelve una representación en texto del estado de visita
	public String toString() {
		return visitado + ""; // Convierte el valor booleano visitado a una cadena
	}
}
