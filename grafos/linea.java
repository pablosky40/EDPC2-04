package grafos;

public class linea implements iLecturaFichero {
	public String estacion1;
	public String estacion2;
	public String numLinea;
	public String getEstacion1() {
		return estacion1;
	}
	public void setEstacion1(String estacion1) {
		this.estacion1 = estacion1;
	}
	public String getEstacion2() {
		return estacion2;
	}
	public void setEstacion2(String estacion2) {
		this.estacion2 = estacion2;
	}
	public String getNumLinea() {
		return numLinea;
	}
	public void setNumLinea(String numLineas) {
		this.numLinea = numLineas;
	}
	public String toString() {
		return "Linea con Estacion1=" + estacion1 + ", estacion2=" + estacion2 + " y número de línea=" + numLinea ;
	}
	public void leerDatos(String []s) {
		this.estacion1=s[0];
		this.estacion2=s[1];
		this.numLinea=s[2];
	}
	
}
