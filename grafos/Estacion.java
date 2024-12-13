package P5;
import graphsDS_ESI_UCLM_v2.*;

// Clase que representa una estación y proporciona métodos para manejar sus datos
public class Estacion implements iLecturaFichero,Identity {
	private String identificador; // Identificador
	private String latitud; // Latitud 
	private String longitud; // Longitud 
	private String nombre; // Nombre de la estación
	private String zona; // Zona a la que pertenece la estación
	private String numLineas; // Número de líneas de la estación

	// Método para obtener el identificador de la estación
	public String getIdentificador() {
		return identificador;
	}

	// Método para establecer el identificador de la estación
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	// Método para obtener la latitud de la estación
	public String getLatitud() {
		return latitud;
	}

	// Método para establecer la latitud de la estación
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	// Método para obtener la longitud de la estación
	public String getLongitud() {
		return longitud;
	}

	// Método para establecer la longitud de la estación
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	// Método para obtener el nombre de la estación
	public String getNombre() {
		return nombre;
	}

	// Método para establecer el nombre de la estación
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Método para obtener la zona de la estación
	public String getZona() {
		return zona;
	}

	// Método para establecer la zona de la estación
	public void setZona(String zona) {
		this.zona = zona;
	}

	// Método para obtener el número de líneas de la estación
	public String getNumLineas() {
		return numLineas;
	}

	// Método para establecer el número de líneas de la estación
	public void setNumLineas(String numLineas) {
		this.numLineas = numLineas;
	}

	// Método para leer datos de un array de cadenas y asignarlos a los campos de la estación segun el archivo que esta puesto en campusvirtual
	public void leerDatos(String [] s) {// el numero de cada uno esta puesto tal y como viene en el archivo del campus
		this.identificador = s[0]; // Asigna el identificador desde la posición 0 del array
		this.latitud = s[1]; // Asigna la latitud desde la posición 1 del array
		this.longitud = s[2]; // Asigna la longitud desde la posición 2 del array
		this.nombre = s[3]; // Asigna el nombre desde la posición 3 del array
		this.numLineas = s[6]; // Asigna el número de líneas desde la posición 6 del array
		this.zona = s[5]; // Asigna la zona desde la posición 5 del array
	}

	// Método para representar la estación como una cadena de texto
	public String toString() {
		return "Estacion con: Identificador=" + identificador + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", nombre=" + nombre + ", zona=" + zona + " y numero de líneas=" + numLineas;
	}

	// Implementación del método getID() de la interfaz Identity
	public String getID() {
		return identificador;
	}
}
