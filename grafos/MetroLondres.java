package grafos;

import graphsDS_ESI_UCLM_v2.*;
import java.io.*;
import java.util.*;

public class MetroLondres {
	final static Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		Graph<Estacion,Trayecto> grafo = new TreeMapGraph<>();
		mostrarEstacionesTrayectos(grafo);
		String estacion1="", estacion2="";
		try {
			do {
			System.out.println("Introduce el identificador de la estacion de origen: ");
			estacion1 = TECLADO.nextLine();
			System.out.println("Introduce el identificador de la estacion de destino: ");
			estacion2 = TECLADO.nextLine();
			while(estacion1==""||estacion2=="") {
					while (grafo.getVertex(estacion1) == grafo.getVertex(estacion2)&&(estacion1!=""||estacion2!="")) {
						System.out.println("Los identificadores son iguales. Introduce dos identificadores que sean distintos entre sí");
						estacion1 = TECLADO.nextLine();
						estacion2 = TECLADO.nextLine();
					}
					int e1 = Integer.parseInt(estacion1);
					int e2 = Integer.parseInt(estacion2);
					while (e1 > grafo.getN() || e2 > grafo.getN()) {
						if (e1 > grafo.getN()) {
							System.out.println("El identificador " + e1+ " no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
							e1 = TECLADO.nextInt();
						}
						if (e2 > grafo.getN()) {
							System.out.println("El identificador " + e2+ " no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
							e2 = TECLADO.nextInt();
						}
						if (e1 > grafo.getN() && e2 > grafo.getN()) {
							System.out.println("Los identificadores no pertenecen a vértices del grafo. Introduce dos identificadores que pertenezcan:");
							e1 = TECLADO.nextInt();
							e2 = TECLADO.nextInt();
						}
					}
					estacion1 = e1 + "";
					estacion2 = e2 + "";
				}
			}while(estacion1==null||estacion2==null);
			Vertex<Estacion> vOrigen = grafo.getVertex(estacion1);
			Vertex <Estacion>vDestino = grafo.getVertex(estacion2);
			Visitar<Vertex<Estacion>> nodo;
			int trayectos=0;
			Stack<Visitar<Vertex<Estacion>>> pila=new Stack();
			Iterator<Vertex<Estacion>> it;
			nodo=buscarRutaCorta(vOrigen,vDestino,grafo);
			if(nodo.getPadre()==null) {
				System.out.println("No hay ruta posible");
			}
			else {
				System.out.println("La ruta más corta pasa por las estaciones: ");
				System.out.println(vOrigen.getData().toString());
				do {
					pila.push(nodo);
					nodo=nodo.getPadre();
				}while(nodo.getPadre()!=null);
				trayectos=pila.size();
				for(int i=0;i<trayectos;i++) {
					nodo=pila.pop();
					System.out.println(nodo.getData());
				}
			}
			System.out.println("La ruta más corta hace "+trayectos+" trayectos");
		}
		catch(NumberFormatException e){
			System.out.println("Pasemos al siguiente metodo");
		}
		System.out.println("Estaciones terminales: ");
		Queue<Vertex<Estacion>> terminales=buscarTerminales(grafo);
		while(!terminales.isEmpty()){
			System.out.println(terminales.poll().getData().toString());
		}
		System.out.println("");
		conectarVertices(grafo);
		System.out.println("Ya conectados los terminales, hay "+grafo.getM()+" trayectos");
		String estacion;
		try {
			do {
			System.out.println("Introduce el identificador de la estacion que desea eliminar: ");
			estacion = TECLADO.nextLine();
			while(estacion=="") {
					int e = Integer.parseInt(estacion1);
					while (e > grafo.getN()) {
						if (e > grafo.getN()) {
							System.out.println("El identificador no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
							e = TECLADO.nextInt();
						}
					}
					estacion = e + "";
				}
			}while(estacion==null);
			Vertex<Estacion> v = grafo.getVertex(estacion);
			eliminarNodo(grafo,v);
			System.out.println("Al eliminar el nodo "+v.getData().getIdentificador()+", y sus trayectos incidentes, tendremos "+grafo.getN()+" estaciones, y "+grafo.getM()+" trayectos");
		}
		catch(NumberFormatException e){
			System.out.println("Pasemos al siguiente metodo");
		}
		try {
			do {
			System.out.println("Introduce el identificador de la estacion de origen: ");
			estacion1 = TECLADO.nextLine();
			System.out.println("Introduce el identificador de la estacion de destino: ");
			estacion2 = TECLADO.nextLine();
			while(estacion1==""||estacion2=="") {
					while (grafo.getVertex(estacion1) == grafo.getVertex(estacion2)&&(estacion1!=""||estacion2!="")) {
						System.out.println("Los identificadores son iguales. Introduce dos identificadores que sean distintos entre sí");
						estacion1 = TECLADO.nextLine();
						estacion2 = TECLADO.nextLine();
					}
					int e1 = Integer.parseInt(estacion1);
					int e2 = Integer.parseInt(estacion2);
					while (e1 > grafo.getN() || e2 > grafo.getN()) {
						if (e1 > grafo.getN()) {
							System.out.println("El identificador " + e1+ " no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
							e1 = TECLADO.nextInt();
						}
						if (e2 > grafo.getN()) {
							System.out.println("El identificador " + e2+ " no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
							e2 = TECLADO.nextInt();
						}
						if (e1 > grafo.getN() && e2 > grafo.getN()) {
							System.out.println("Los identificadores no pertenecen a vértices del grafo. Introduce dos identificadores que pertenezcan:");
							e1 = TECLADO.nextInt();
							e2 = TECLADO.nextInt();
						}
					}
					estacion1 = e1 + "";
					estacion2 = e2 + "";
				}
			}while(estacion1==null||estacion2==null);
			Vertex<Estacion> vOrigen = grafo.getVertex(estacion1);
			Vertex <Estacion>vDestino = grafo.getVertex(estacion2);
			Visitar<Vertex<Estacion>> nodo;
			int trayectos=0;
			Stack<Visitar<Vertex<Estacion>>> pila=new Stack();
			Iterator<Vertex<Estacion>> it;
			nodo=buscarRutaCorta(vOrigen,vDestino,grafo);
			if(nodo.getPadre()==null) {
				System.out.println("No hay ruta posible");
			}
			else {
				System.out.println("La ruta más corta pasa por las estaciones: ");
				System.out.println(vOrigen.getData().toString());
				do {
					pila.push(nodo);
					nodo=nodo.getPadre();
				}while(nodo.getPadre()!=null);
				trayectos=pila.size();
				for(int i=0;i<trayectos;i++) {
					nodo=pila.pop();
					System.out.println(nodo.getData());
				}
			}
			System.out.println("La ruta más corta hace "+trayectos+" trayectos");
		}
		catch(NumberFormatException e){
			System.out.println("Fin del programa");
		}
	}

	private static void mostrarEstacionesTrayectos(Graph<Estacion, Trayecto> grafo) throws FileNotFoundException {
		LecturaFichero<Estacion> ficheroEstacion = new LecturaFichero<>("london_stations.csv");
		LecturaFichero<Trayecto> ficheroLinea = new LecturaFichero<>("london_lines.csv");
		ficheroEstacion.saltar();
		ficheroLinea.saltar();
		while (ficheroEstacion.finLectura()) {
			Estacion estaciones = new Estacion();
			ficheroEstacion.leer(estaciones);
			grafo.insertVertex(estaciones);
		}
		while (ficheroLinea.finLectura()) {
			Trayecto linea = new Trayecto();
			ficheroLinea.leer(linea);
			Vertex<Estacion> estacion1 = grafo.getVertex(linea.getEstacion1());
			Vertex<Estacion> estacion2 = grafo.getVertex(linea.getEstacion2());
			Edge<Trayecto> E = grafo.insertEdge(estacion1, estacion2);
			grafo.replaceEdge(E, linea);
		}
		System.out.println("Hay " + grafo.getN() + " estaciones");
		System.out.println("Hay " + grafo.getM() + " trayectos");
		ficheroEstacion.cerrar();
		ficheroLinea.cerrar();
	}

	private static Visitar buscarRutaCorta(Vertex<Estacion> v1, Vertex<Estacion> v2,Graph<Estacion, Trayecto> grafo) {
		Iterator<Vertex<Estacion>> itVertices;
		Queue<Vertex<Estacion>> cola = new LinkedList();
		boolean destinoNoEncontrado = true;
		Vertex<Estacion> v, w = null;
		Edge<Trayecto> e;
		Iterator<Edge<Trayecto>> itAristas;
		Visitar<Trayecto> vVisitado = null;
		itVertices = grafo.getVertices();
		while (itVertices.hasNext()) {
			v = itVertices.next();
			v.setDecorator(new Visitar(v.getData()));
		}
		((Visitar) v1.getDecorator()).setVisitado(true);
		cola.offer(v1);
		while (!cola.isEmpty() && destinoNoEncontrado) {
			v = cola.poll();
			itAristas = grafo.incidentEdges(v);
			while (itAristas.hasNext() && destinoNoEncontrado) {
				e = itAristas.next();
				w = grafo.opposite(v, e);
				vVisitado = (Visitar) w.getDecorator();
				if (!vVisitado.isVisitado()) {
					vVisitado.setVisitado(true);
					cola.offer(w);
					vVisitado.setPadre((Visitar) v.getDecorator());
					destinoNoEncontrado = !(w.getData().equals(v2.getData()));
				}
			}
		}
		if (destinoNoEncontrado) {
			vVisitado = null;
		}
		return vVisitado;
	}
	private static int calcularGrado(Graph<Estacion,Trayecto> grafo,Vertex<Estacion> v){
		Iterator<Edge<Trayecto>> it=grafo.incidentEdges(v);
		int grado=0;
		while(it.hasNext()) {
			grado++;
			it.next();
		}
		return grado;
	}
	private static Queue<Vertex<Estacion>> buscarTerminales(Graph<Estacion,Trayecto> grafo){
		Iterator<Vertex<Estacion>> it=grafo.getVertices();
		Queue<Vertex<Estacion>> colaTerminales=new LinkedList<>();
		while(it.hasNext()) {
			Vertex<Estacion> v=it.next();
			int grado=calcularGrado(grafo,v);
			if(grado==1) {
				colaTerminales.add(v);
			}
		}
		return colaTerminales;
	}
	private static double calcularDistancia(Vertex<Estacion> v,Vertex<Estacion> w) {
		double f=111320;
		double latitudV=Double.parseDouble(v.getData().getLatitud());
		double latitudW=Double.parseDouble(w.getData().getLatitud());
		double longitudV=Double.parseDouble(v.getData().getLongitud());
		double longitudW=Double.parseDouble(w.getData().getLongitud());
		double distanciaC=Math.sqrt(((latitudV-latitudW)*(latitudV-latitudW))+((longitudV-longitudW)*(longitudV-longitudW)));
		double distancia=f*distanciaC;
		return distancia;
	}
	private static void conectarVertices(Graph<Estacion,Trayecto> grafo) {
		Queue<Vertex<Estacion>> terminales=buscarTerminales(grafo);
		List<Vertex<Estacion>> listaTerminales=new ArrayList<>(terminales);
		boolean[] conectadas=new boolean[listaTerminales.size()];
		for(int i=0;i<listaTerminales.size();i++) {
			if(conectadas[i]) {
				continue;
			}
			int cercano=-1;
			double menorDistancia=Double.MAX_VALUE;
			for(int j=0;j<listaTerminales.size();j++) {
				if(i!=j&&!conectadas[j]) {
					double distancia=calcularDistancia(listaTerminales.get(i),listaTerminales.get(j));
					if(distancia<menorDistancia) {
						menorDistancia=distancia;
						cercano=j;
					}
				}
			}
			if(cercano!=-1) {
				Vertex<Estacion> e1=listaTerminales.get(i);
				Vertex<Estacion> e2=listaTerminales.get(cercano);
				Trayecto trayectoNuevo=new Trayecto();
				trayectoNuevo.setEstacion1(e1.getData().getIdentificador());
				trayectoNuevo.setEstacion2(e2.getData().getIdentificador());
				trayectoNuevo.setNumLineas("E");
				Edge<Trayecto> eNuevo=grafo.insertEdge(e1, e2);
				grafo.replaceEdge(eNuevo, trayectoNuevo);
				conectadas[i]=true;
				conectadas[cercano]=true;
				System.out.println("Los nodos: "+e1.getData().getIdentificador()+" y "+e2.getData().getIdentificador()+", con una distancia de "+menorDistancia+" metros entre sí han sido conectados correctamente");
			}
		}
	}
	private static void eliminarNodo(Graph<Estacion,Trayecto> grafo,Vertex<Estacion> v) {
		Iterator<Edge<Trayecto>> it=grafo.incidentEdges(v);
		grafo.removeVertex(v);
		while(it.hasNext()) {
			grafo.removeEdge(it.next());
		}
	}
}
