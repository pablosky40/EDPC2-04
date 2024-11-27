package grafos;
import graphsDS_ESI_UCLM_v2.*;

public class Linea implements iLecturaFichero,Identity {
	private String estacion1;
	private String estacion2;
	private String numLineas;
	private String ID;
	public String getNumLineas() {
		return numLineas;
	}
	public void setNumLineas(String numLineas) {
		this.numLineas = numLineas;
	}
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
	public String toString() {
		return "Linea con Estacion1=" + estacion1 + ", estacion2=" + estacion2+", y con "+numLineas+" líneas" ;
	}
	public void leerDatos(String []s) {
		this.estacion1=s[0];
		this.estacion2=s[1];
		this.numLineas=s[2];
	}
	public String getID() {
		return ID;
	}
}

