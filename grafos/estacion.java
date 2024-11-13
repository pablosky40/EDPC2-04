package grafos;

public class estacion implements iLecturaFichero {
	private String identificador;
	private String latitud;
	private String longitud;
	private String nombre;
	private String zona;
	private String numLineas;
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getNumLineas() {
		return numLineas;
	}
	public void setNumLineas(String numLineas) {
		this.numLineas = numLineas;
	}
	public void leerDatos(String [] s) {
		this.identificador=s[0];
		this.latitud=s[1];
		this.longitud=s[2];
		this.nombre=s[3];
		this.numLineas=s[4];
		this.zona=s[5];
	}
	public String toString() {
		return "Estacion con: Identificador=" + identificador + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", nombre=" + nombre + ", zona=" + zona + "y numero de líneas=" + numLineas ;
	}
	
}
