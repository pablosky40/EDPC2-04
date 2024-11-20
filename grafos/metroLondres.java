package grafos;
import graphsDS_ESI_UCLM_v2.*;
import java.io.*;
public class MetroLondres {
	public static void main(String[] args) {
		Graph <Estacion,Trayecto> grafo=new TreeMapGraph<>();
		
	}
	public static void mostrarEstacionesTrayectos(Graph<Estacion,Trayecto> grafo) throws FileNotFoundException{
		LecturaFichero<Estacion> ficheroEstacion=new LecturaFichero<>("london_stations.csv");
		LecturaFichero<Linea> ficheroLinea=new LecturaFichero<>("london_lines.csv");
		int iEstacion=0;
		ficheroEstacion.saltar();
		ficheroLinea.saltar();
		while(ficheroEstacion.finLectura()) {
			iEstacion++;
			Estacion estacionLeer=new Estacion();
			ficheroEstacion.leer(estacionLeer);
			
		}
		while(ficheroLinea.finLectura()) {

			
		}
	}
}
