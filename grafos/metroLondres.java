package grafos;
import graphsDS_ESI_UCLM_v2.*;
import java.io.*;
public class MetroLondres {
	public static void main(String[] args) throws FileNotFoundException{
		Graph <Estacion,Trayecto> grafo=new TreeMapGraph<>();
		mostrarEstacionesTrayectos(grafo);
	}
	public static void mostrarEstacionesTrayectos(Graph<Estacion,Trayecto> grafo) throws FileNotFoundException{
		LecturaFichero<Estacion> ficheroEstacion=new LecturaFichero<>("london_stations.csv");
		LecturaFichero<Linea> ficheroLinea=new LecturaFichero<>("london_lines.csv");
		Estacion estaciones=new Estacion();
		int numEstaciones=0;
		int numLineas=0;
		ficheroEstacion.saltar();
		ficheroLinea.saltar();
		while(ficheroEstacion.finLectura()) {
			ficheroEstacion.leer(estaciones);
			grafo.insertVertex(estaciones);
			numEstaciones++;
		}
		while(ficheroLinea.finLectura()) {
			Linea lineas=new Linea();
			ficheroLinea.leer(lineas);
			Vertex<Estacion> estacion1=grafo.getVertex(lineas.getEstacion1());
			Vertex<Estacion> estacion2=grafo.getVertex(lineas.getEstacion2());
			grafo.insertEdge(estacion1, estacion2);
			numLineas++;
		}
		System.out.println("Hay "+numEstaciones+" estaciones");
		System.out.println("Hay "+numLineas+" lineas");
		ficheroEstacion.cerrar();
		ficheroLinea.cerrar();
	}
	
}

