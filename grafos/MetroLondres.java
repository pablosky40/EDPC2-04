package P5;

import graphsDS_ESI_UCLM_v2.*;
import java.io.*;
import java.util.*;

public class MetroLondres {
	final static Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
	    // Se crea un grafo vacío usando TreeMapGraph que esta en el campus virtual 
	    Graph<Estacion, Trayecto> grafo = new TreeMapGraph<>();
	    
	    // Muestra las estaciones y trayectos del grafo
	    mostrarEstacionesTrayectos(grafo);
	    
	    // Variables para almacenar los identificadores de las estaciones de origen y destino
	    String estacion1 = "", estacion2 = "";
	    
	    try {
	        do {
	            // Solicita el identificador de la estación de origen
	            System.out.println("Introduce el identificador de la estacion de origen: ");
	            estacion1 = TECLADO.nextLine();
	            
	            // Solicita el identificador de la estación de destino
	            System.out.println("Introduce el identificador de la estacion de destino: ");
	            estacion2 = TECLADO.nextLine();
	            
	            // Verifica que los identificadores no sean vacíos
	            while (estacion1 == "" || estacion2 == "") {
	                // Si alguna estación está vacía, solicita de nuevo los identificadores
	            }
	            
	            // Asegura que las estaciones no sean iguales
	            while (grafo.getVertex(estacion1) == grafo.getVertex(estacion2) && (estacion1 != "" || estacion2 != "")) {
	                System.out.println("Los identificadores son iguales. Introduce dos identificadores que sean distintos entre sí");
	                estacion1 = TECLADO.nextLine();
	                estacion2 = TECLADO.nextLine();
	            }
	            
	            // Convierte las estaciones a enteros para validarlas
	            int e1 = Integer.parseInt(estacion1);
	            int e2 = Integer.parseInt(estacion2);
	            
	            // Verifica que los identificadores estén dentro del rango válido
	            while (e1 > grafo.getN() || e2 > grafo.getN()) {
	                if (e1 > grafo.getN()) {
	                    System.out.println("El identificador " + e1 + " no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
	                    e1 = TECLADO.nextInt();
	                }
	                if (e2 > grafo.getN()) {
	                    System.out.println("El identificador " + e2 + " no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
	                    e2 = TECLADO.nextInt();
	                }
	                if (e1 > grafo.getN() && e2 > grafo.getN()) {
	                    System.out.println("Los identificadores no pertenecen a vértices del grafo. Introduce dos identificadores que pertenezcan:");
	                    e1 = TECLADO.nextInt();
	                    e2 = TECLADO.nextInt();
	                }
	            }
	            
	            // Convierte los números a cadenas de texto
	            estacion1 = e1 + "";
	            estacion2 = e2 + "";
	            
	        } while (estacion1 == null || estacion2 == null);
	        
	        // Obtiene los vértices de origen y destino del grafo
	        Vertex<Estacion> vOrigen = grafo.getVertex(estacion1);
	        Vertex<Estacion> vDestino = grafo.getVertex(estacion2);
	        
	        // Variables para la búsqueda de la ruta más corta
	        Visitar<Vertex<Estacion>> nodo;
	        int trayectos = 0;
	        Stack<Visitar<Vertex<Estacion>>> pila = new Stack();
	        
	        // Realiza la búsqueda de la ruta más corta entre las dos estaciones
	        nodo = buscarRutaCorta(vOrigen, vDestino, grafo);
	        
	        // Si no se encuentra una ruta, muestra el mensaje correspondiente
	        if (nodo.getPadre() == null) {
	            System.out.println("No hay ruta posible");
	        } else {
	            // Si se encuentra una ruta, muestra las estaciones por las que pasa
	            System.out.println("La ruta más corta pasa por las estaciones: ");
	            System.out.println(vOrigen.getData().toString());
	            
	            // Mostramos los nodos de la ruta
	            do {
	                pila.push(nodo);
	                nodo = nodo.getPadre();
	            } while (nodo.getPadre() != null);
	            
	            // Calcula el número de trayectos en la ruta
	            trayectos = pila.size();
	            
	            // Desapila y muestra las estaciones de la ruta más corta
	            for (int i = 0; i < trayectos; i++) {
	                nodo = pila.pop();
	                System.out.println(nodo.getData());
	            }
	        }
	        
	        // Muestra el número total de trayectos en la ruta más corta
	        System.out.println("La ruta más corta hace " + trayectos + " trayectos");
	        
	    } catch (NumberFormatException e) {
	        // En caso de que ocurra un error de formato al ingresar los datos, muestra un mensaje
	        System.out.println("Pasemos al siguiente metodo");
	    }
	    
	    // Muestra las estaciones terminales (sin salida o entrada)
	    System.out.println("Estaciones terminales: ");
	    Queue<Vertex<Estacion>> terminales = buscarTerminales(grafo);
	    while (!terminales.isEmpty()) {
	        System.out.println(terminales.poll().getData().toString());
	    }
	    
	   
	    System.out.println("");
	    
	    // Conecta las estaciones terminales entre sí
	    conectarVertices(grafo);
	    System.out.println("Ya conectados los terminales, hay " + grafo.getM() + " trayectos");
	    
	    // Solicita al usuario el identificador de una estación para eliminar
	    String estacion;
	    try {
	        do {
	            System.out.println("Introduce el identificador de la estacion que desea eliminar: ");
	            estacion = TECLADO.nextLine();
	            
	            // Verifica que el identificador no esté vacío
	            while (estacion == "") {
	                int e = Integer.parseInt(estacion1);
	                
	                // Verifica que el identificador sea válido
	                while (e > grafo.getN()) {
	                    System.out.println("El identificador no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
	                    e = TECLADO.nextInt();
	                }
	                estacion = e + "";
	            }
	        } while (estacion == null);
	        
	        // Elimina el vértice correspondiente al identificador de estación
	        Vertex<Estacion> v = grafo.getVertex(estacion);
	        eliminarNodo(grafo, v);
	        System.out.println("Al eliminar el nodo " + v.getData().getIdentificador() + ", y sus trayectos incidentes...");
	        System.out.println("Tendremos " + grafo.getN() + " estaciones, y " + grafo.getM() + " trayectos");
	        
	    } catch (NumberFormatException e) {
	        // En caso de error de formato en la eliminación, muestra el mensaje correspondiente
	        System.out.println("Pasemos al siguiente metodo");
	    }
	    
	    // Realiza otra búsqueda de ruta más corta (igual que antes)
	    try {
	        do {
	            System.out.println("Introduce el identificador de la estacion de origen: ");
	            estacion1 = TECLADO.nextLine();
	            System.out.println("Introduce el identificador de la estacion de destino: ");
	            estacion2 = TECLADO.nextLine();
	            
	            // Verifica que los identificadores no estén vacíos
	            while (estacion1 == "" || estacion2 == "") {
	                while (grafo.getVertex(estacion1) == grafo.getVertex(estacion2) && (estacion1 != "" || estacion2 != "")) {
	                    System.out.println("Los identificadores son iguales. Introduce dos identificadores que sean distintos entre sí");
	                    estacion1 = TECLADO.nextLine();
	                    estacion2 = TECLADO.nextLine();
	                }
	                int e1 = Integer.parseInt(estacion1);
	                int e2 = Integer.parseInt(estacion2);
	                
	                // Verifica que los identificadores sean válidos
	                while (e1 > grafo.getN() || e2 > grafo.getN()) {
	                    if (e1 > grafo.getN()) {
	                        System.out.println("El identificador " + e1 + " no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
	                        e1 = TECLADO.nextInt();
	                    }
	                    if (e2 > grafo.getN()) {
	                        System.out.println("El identificador " + e2 + " no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
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
	        } while (estacion1 == null || estacion2 == null);
	        
	        // Realiza la búsqueda de la ruta más corta como antes
	        Vertex<Estacion> vOrigen = grafo.getVertex(estacion1);
	        Vertex<Estacion> vDestino = grafo.getVertex(estacion2);
	        Visitar<Vertex<Estacion>> nodo;
	        int trayectos = 0;
	        Stack<Visitar<Vertex<Estacion>>> pila = new Stack();
	        nodo = buscarRutaCorta(vOrigen, vDestino, grafo);
	        
	        // Si no hay ruta, muestra el mensaje correspondiente
	        if (nodo.getPadre() == null) {
	            System.out.println("No hay ruta posible");
	        } else {
	            // Muestra las estaciones de la ruta más corta
	            System.out.println("La ruta más corta pasa por las estaciones: ");
	            System.out.println(vOrigen.getData().toString());
	            do {
	                pila.push(nodo);
	                nodo = nodo.getPadre();
	            } while (nodo.getPadre() != null);
	            trayectos = pila.size();
	            for (int i = 0; i < trayectos; i++) {
	                nodo = pila.pop();
	                System.out.println(nodo.getData());
	            }
	        }
	        
	        // Muestra la cantidad de trayectos
	        System.out.println("La ruta más corta hace " + trayectos + " trayectos");
	        
	    } catch (NumberFormatException e) {
	        // Si ocurre un error de formato, finaliza el programa
	        System.out.println("Fin del programa");
	    }
	}


	// Método para mostrar las estaciones y trayectos del grafo
	private static void mostrarEstacionesTrayectos(Graph<Estacion, Trayecto> grafo) throws FileNotFoundException {
	    // Se crean objetos de LecturaFichero para leer las estaciones y trayectos desde archivos CSV
	    LecturaFichero<Estacion> ficheroEstacion = new LecturaFichero<>("london_stations.csv");
	    LecturaFichero<Trayecto> ficheroLinea = new LecturaFichero<>("london_lines.csv");
	    
	    // Saltar la primera línea de cada archivo (generalmente encabezados)
	    ficheroEstacion.saltar();
	    ficheroLinea.saltar();
	    
	    // Lectura y almacenamiento de estaciones en el grafo
	    while (ficheroEstacion.finLectura()) {
	        Estacion estaciones = new Estacion();
	        ficheroEstacion.leer(estaciones); // Lee una estación del archivo
	        grafo.insertVertex(estaciones); // Inserta la estación en el grafo
	    }
	    
	    // Lectura y almacenamiento de trayectos en el grafo
	    while (ficheroLinea.finLectura()) {
	        Trayecto linea = new Trayecto();
	        ficheroLinea.leer(linea); // Lee un trayecto del archivo
	        
	        // Obtiene los vértices correspondientes a las estaciones de inicio y fin del trayecto
	        Vertex<Estacion> estacion1 = grafo.getVertex(linea.getEstacion1());
	        Vertex<Estacion> estacion2 = grafo.getVertex(linea.getEstacion2());
	        
	        // Inserta el trayecto como una arista entre las dos estaciones
	        Edge<Trayecto> E = grafo.insertEdge(estacion1, estacion2);
	        grafo.replaceEdge(E, linea); // Reemplaza la arista con el trayecto leído
	    }
	    
	    // Muestra la cantidad de estaciones y trayectos en el grafo
	    System.out.println("Hay " + grafo.getN() + " estaciones");
	    System.out.println("Hay " + grafo.getM() + " trayectos");
	    
	    // Cierra los archivos
	    ficheroEstacion.cerrar();
	    ficheroLinea.cerrar();
	}

	// Método para buscar la ruta más corta entre dos estaciones usando BFS, ejemplo que hay proporcionado en campus 
	private static Visitar buscarRutaCorta(Vertex<Estacion> v1, Vertex<Estacion> v2, Graph<Estacion, Trayecto> grafo) {
	    Iterator<Vertex<Estacion>> itVertices;
	    Queue<Vertex<Estacion>> cola = new LinkedList<>();
	    boolean destinoNoEncontrado = true;
	    Vertex<Estacion> v, w = null;
	    Edge<Trayecto> e;
	    Iterator<Edge<Trayecto>> itAristas;
	    Visitar<Trayecto> vVisitado = null;
	    
	    // Inicializa los decoradores para marcar los vértices como no visitados
	    itVertices = grafo.getVertices();
	    while (itVertices.hasNext()) {
	        v = itVertices.next();
	        v.setDecorator(new Visitar(v.getData()));
	    }
	    
	    // Marca el vértice de inicio como visitado y lo coloca en la cola
	    ((Visitar) v1.getDecorator()).setVisitado(true);
	    cola.offer(v1);
	    
	    // Realiza la búsqueda en amplitud (BFS)
	    while (!cola.isEmpty() && destinoNoEncontrado) {
	        v = cola.poll();
	        itAristas = grafo.incidentEdges(v);
	        
	        // Recorre las aristas del vértice actual
	        while (itAristas.hasNext() && destinoNoEncontrado) {
	            e = itAristas.next();
	            w = grafo.opposite(v, e);
	            vVisitado = (Visitar) w.getDecorator();
	            
	            // Si el vértice no ha sido visitado, lo marca como visitado y lo agrega a la cola
	            if (!vVisitado.isVisitado()) {
	                vVisitado.setVisitado(true);
	                cola.offer(w);
	                vVisitado.setPadre((Visitar) v.getDecorator());
	                destinoNoEncontrado = !(w.getData().equals(v2.getData())); // Verifica si se ha llegado al destino
	            }
	        }
	    }
	    
	    // Si no se encontró el destino, devuelve null
	    if (destinoNoEncontrado) {
	        vVisitado = null;
	    }
	    
	    return vVisitado;
	}

	// Método para calcular el grado de un vértice (número de aristas incidentes)
	private static int calcularGrado(Graph<Estacion, Trayecto> grafo, Vertex<Estacion> v) {
	    Iterator<Edge<Trayecto>> it = grafo.incidentEdges(v);
	    int grado = 0;
	    while (it.hasNext()) {
	        grado++;
	        it.next(); // Avanza al siguiente elemento
	    }
	    return grado;
	}

	// Método para buscar estaciones terminales (con grado 1)
	private static Queue<Vertex<Estacion>> buscarTerminales(Graph<Estacion, Trayecto> grafo) {
	    Iterator<Vertex<Estacion>> it = grafo.getVertices();
	    Queue<Vertex<Estacion>> colaTerminales = new LinkedList<>();
	    
	    // Recorre todos los vértices y agrega a la cola los que tienen grado 1
	    while (it.hasNext()) {
	        Vertex<Estacion> v = it.next();
	        int grado = calcularGrado(grafo, v);
	        if (grado == 1) {
	            colaTerminales.add(v);
	        }
	    }
	    
	    return colaTerminales;
	}

	// Método para calcular la distancia entre dos estaciones usando sus coordenadas geográficas
	private static double calcularDistancia(Vertex<Estacion> v, Vertex<Estacion> w) {
	    // Factor de conversión de grados a metros (aproximación)
	    double f = 111320;
	    double latitudV = Double.parseDouble(v.getData().getLatitud());
	    double latitudW = Double.parseDouble(w.getData().getLatitud());
	    double longitudV = Double.parseDouble(v.getData().getLongitud());
	    double longitudW = Double.parseDouble(w.getData().getLongitud());
	    
	    // Calcula la distancia euclidiana en coordenadas geográficas
	    double distanciaC = Math.sqrt(((latitudV - latitudW) * (latitudV - latitudW)) + ((longitudV - longitudW) * (longitudV - longitudW)));
	    double distancia = f * distanciaC;
	    
	    return distancia;
	}

	// Método para conectar estaciones terminales entre sí, creando trayectos nuevos
	private static void conectarVertices(Graph<Estacion, Trayecto> grafo) {
	    // Obtiene las estaciones terminales (con grado 1)
	    Queue<Vertex<Estacion>> terminales = buscarTerminales(grafo);
	    List<Vertex<Estacion>> listaTerminales = new ArrayList<>(terminales);
	    
	    // Arreglo para marcar las estaciones ya conectadas
	    boolean[] conectadas = new boolean[listaTerminales.size()];
	    
	    // Conecta las estaciones terminales de manera más cercana (por distancia)
	    for (int i = 0; i < listaTerminales.size(); i++) {
	        if (conectadas[i]) {
	            continue; // Si la estación ya está conectada, se salta
	        }
	        
	        int cercano = -1;
	        double menorDistancia = Double.MAX_VALUE;
	        
	        // Busca la estación más cercana no conectada
	        for (int j = 0; j < listaTerminales.size(); j++) {
	            if (i != j && !conectadas[j]) {
	                double distancia = calcularDistancia(listaTerminales.get(i), listaTerminales.get(j));
	                if (distancia < menorDistancia) {
	                    menorDistancia = distancia;
	                    cercano = j;
	                }
	            }
	        }
	        
	        // Si se encontró una estación cercana, se conecta
	        if (cercano != -1) {
	            Vertex<Estacion> e1 = listaTerminales.get(i);
	            Vertex<Estacion> e2 = listaTerminales.get(cercano);
	            
	            // Crea un trayecto nuevo entre las dos estaciones
	            Trayecto trayectoNuevo = new Trayecto();
	            trayectoNuevo.setEstacion1(e1.getData().getIdentificador());
	            trayectoNuevo.setEstacion2(e2.getData().getIdentificador());
	            trayectoNuevo.setNumLineas("E");
	            
	            // Inserta el trayecto en el grafo
	            Edge<Trayecto> eNuevo = grafo.insertEdge(e1, e2);
	            grafo.replaceEdge(eNuevo, trayectoNuevo);
	            
	            // Marca las estaciones como conectadas
	            conectadas[i] = true;
	            conectadas[cercano] = true;
	            System.out.println("Los nodos: " + e1.getData().getIdentificador() + " y " + e2.getData().getIdentificador() + ", con una distancia de " + menorDistancia + " metros entre sí han sido conectados correctamente");
	        }
	    }
	}

	// Método para eliminar un vértice del grafo
	private static void eliminarNodo(Graph<Estacion, Trayecto> grafo, Vertex<Estacion> v) {
	    // Obtiene las aristas incidentes al vértice
	    Iterator<Edge<Trayecto>> it = grafo.incidentEdges(v);
	    
	    // Elimina el vértice del grafo
	    grafo.removeVertex(v);
	    
	    // Elimina las aristas incidentes
	    while (it.hasNext()) {
	        grafo.removeEdge(it.next());
	    }
	}
}
