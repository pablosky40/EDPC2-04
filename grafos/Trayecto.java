package P5;
import graphsDS_ESI_UCLM_v2.*; 

// Clase que representa un trayecto entre dos estaciones
public class Trayecto implements iLecturaFichero, Identity {
	private String identificador; // Identificador único del trayecto
	private String estacion1; // Primera estación del trayecto
	private String estacion2; // Segunda estación del trayecto
	private String numLineas; // Número de líneas asociadas al trayecto

	// Método para obtener el número de líneas del trayecto
	public String getNumLineas() {
		return numLineas;
	}

	// Método para establecer el número de líneas del trayecto
	public void setNumLineas(String numLineas) {
		this.numLineas = numLineas;
	}

	// Método para obtener la primera estación del trayecto
	public String getEstacion1() {
		return estacion1;
	}

	// Método para establecer la primera estación del trayecto
	public void setEstacion1(String estacion1) {
		this.estacion1 = estacion1;
	}

	// Método para obtener la segunda estación del trayecto
	public String getEstacion2() {
		return estacion2;
	}

	// Método para establecer la segunda estación del trayecto
	public void setEstacion2(String estacion2) {
		this.estacion2 = estacion2;
	}

	// Método que devuelve una representación en texto del trayecto
	public String toString() {
		return "Linea con estacion1=" + estacion1 + ", estacion2=" + estacion2 + ", y con " + numLineas + " líneas";
	}

	// Método para leer los datos del trayecto desde un array de cadenas
	public void leerDatos(String[] s) {
		this.estacion1 = s[0]; // Asigna la primera estación desde la posición 0 del array
		this.estacion2 = s[1]; // Asigna la segunda estación desde la posición 1 del array
		this.numLineas = s[2]; // Asigna el número de líneas desde la posición 2 del array
	}

	// El método getID() de la interfaz Identity
	public String getID() {
		return identificador;
	}
}

		
