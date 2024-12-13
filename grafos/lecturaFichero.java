package P5; 
import java.util.*;
import java.io.*; 

// Clase para leer datos de un archivo y cargarlos en objetos que implementen iLecturaFichero
public class LecturaFichero <T extends iLecturaFichero> {
	private File fichero; // Representa el archivo que se va a leer
	private Scanner sc; // Scanner para leer el contenido del archivo
	private String separador; // Se utilza para separar

	// Constructor que inicializa la clase con la ruta del archivo
	public LecturaFichero(String directorio) throws FileNotFoundException {
		this.fichero = new File(directorio); // Crea un objeto File 
		this.sc = new Scanner(fichero); // Inicializa el Scanner con el archivo
		this.separador = ","; // Define el separador por defecto como una coma
	}

	// Método para leer datos del archivo y cargarlos en un objeto de tipo T
	public void leer(T t) {
		String datos[] = sc.nextLine().split(separador); // Lee una línea y la divide usando el separador
		t.leerDatos(datos); // Llama al método leerDatos del objeto pasado para cargar los datos
	}

	// Método para saltar una línea del archivo (útil para encabezados, por ejemplo)
	public void saltar() {
		sc.nextLine(); // Lee y descarta la siguiente línea del archivo
	}

	// Método para cerrar el Scanner y liberar los recursos asociados al archivo
	public void cerrar() {
		sc.close(); // Cierra el Scanner
	}

	// Método para comprobar si hay más líneas disponibles para leer en el archivo
	public boolean finLectura() {
		return sc.hasNextLine(); // Devuelve true si hay otra línea para leer
	}
}
