/*
 * J_P_M_C2-04
 * Nombre de la clase: MetroLondres
 * Nombre de los autores: Jesús Márquez Duque, Miguel Mora Vega, Pablo Santillana Fernandez
 * Fecha de creación: 13/11/2024
 * Versión de la clase: 4.30.0
 * Descripción de la clase: Clase pricipal
 */
package grafos;

import graphsDS_ESI_UCLM_v2.*;//Importa los elementos de la librería de grafos graphsDS_ESI_UCLM_v2
import java.io.*;//Importa diversos elementos en la clase, en cuanto a lectura de ficheros
import java.util.*;//Importa diversos elementos en la clase, en cuanto a entrada/salida

public class MetroLondres {
	final static Scanner TECLADO = new Scanner(System.in);//Constante del tipo Scanner, que detecta el teclado como introduccion de datos
	/*
	 * Nombre del método: main
	 * Descripcion del método: Metodo principal que es donde se ejecuta el programa
	 * Argumentos de llamada: 
		args: Vector de cadenas de caracteres que indica los caracteres
	 * Valor de retorno: Void, no devuelvo nada, pues solo ejecuta
	 * Archivos necesarios: Ninguno
	 * FileNotFoundException, que se lanza si no se ha encontrado un fichero
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Graph<Estacion,Trayecto> grafo = new TreeMapGraph<>();//Creacion del grafo, que tiene las clases Estaciones para vértices, y Trayecto para aristas
		mostrarEstacionesTrayectos(grafo);//Implementacion del metodo mostrarEstacionesTrayectos, al que se le pasa el grafo
		String estacion1="", estacion2="";//Cadenas de caracteres que indicaran los identificadores de las estaciones
		try {//Detectara si hay una excepcion
			do {//Bucle con condición final
			System.out.println("Introduce el identificador de la estacion de origen: ");//Imprime texto por pantalla
			estacion1 = TECLADO.nextLine();//Introduce el valor de lo introducido por teclado en la variable indicada
			System.out.println("Introduce el identificador de la estacion de destino: ");
			estacion2 = TECLADO.nextLine();
			while(estacion1==""||estacion2=="") {//Bucle que se realiza mientras alguna de las cadenas de caracteres indicadas estan en blanco
					while (grafo.getVertex(estacion1) == grafo.getVertex(estacion2)&&(estacion1!=""||estacion2!="")) {//Bucle que se realiza mientras alguna de las cadenas de caracteres indicadas no esten en blanco, y las cadenas son iguales
						System.out.println("Los identificadores son iguales. Introduce dos identificadores que sean distintos entre sí");
						estacion1 = TECLADO.nextLine();
						estacion2 = TECLADO.nextLine();
					}
					int e1 = Integer.parseInt(estacion1);//Convierte una cadena de caracteres en un entero
					int e2 = Integer.parseInt(estacion2);
					while (e1 > grafo.getN() || e2 > grafo.getN()) {//Bucle que se realiza mientras alguno de los enteros convertidos es mayor que el número de vértices del grafo
						if (e1 > grafo.getN()) {//Condicion que se realiza si se cumple una de las condiciones del bucle anterior
							System.out.println("El identificador " + e1+ " no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
							e1 = TECLADO.nextInt();
						}
						if (e2 > grafo.getN()) {//Condicion que se realiza si se cumple la otra de las condiciones del bucle anterior
							System.out.println("El identificador " + e2+ " no pertenece a un vértice del grafo. Introduce un identificador que pertenezca:");
							e2 = TECLADO.nextInt();
						}
						if (e1 > grafo.getN() && e2 > grafo.getN()) {//Condicion que se realiza si se cumplen las dos condiciones del bucle anterior
							System.out.println("Los identificadores no pertenecen a vértices del grafo. Introduce dos identificadores que pertenezcan:");
							e1 = TECLADO.nextInt();
							e2 = TECLADO.nextInt();
						}
					}
					estacion1 = e1 + "";//Pasamos el entero al cadena de caracteres añadiendo un caracter blanco
					estacion2 = e2 + "";
				}
			}while(estacion1==null||estacion2==null);//Condicion final del bucle
			Vertex<Estacion> vOrigen = grafo.getVertex(estacion1);//Vertice de uno de los identificadores
			Vertex <Estacion>vDestino = grafo.getVertex(estacion2);
			Visitar<Vertex<Estacion>> nodo;//Creacion de un objeto de la clase Visitar
			int trayectos=0;//Variable entera inicializada a 0
			Stack<Visitar<Vertex<Estacion>>> pila=new Stack();//Cracion de una pila con los vertices del grafo
			Iterator<Vertex<Estacion>> it;//Cracion de un iterator con los vertices del grafo
			nodo=buscarRutaCorta(vOrigen,vDestino,grafo);//Llama al metodo BFS que se le pasa los vertices origen y destino, y el grafo
			if(nodo.getPadre()==null) {//Condicion que se realiza si el nodo está vacío
				System.out.println("No hay ruta posible");
			}
			else {//Condicion que se realiza si el nodo no esta vacío
				System.out.println("La ruta más corta pasa por las estaciones: ");
				System.out.println(vOrigen.getData().toString());//Imprime el toString de la clase Estacion
				do {
					pila.push(nodo);//Mete en la pila el nodo
					nodo=nodo.getPadre();//Mete el nodo padre en el objeto nodo
				}while(nodo.getPadre()!=null);
				trayectos=pila.size();//Saca la longitud de la pila y la mete en la variable trayectos
				for(int i=0;i<trayectos;i++) {//Bucle que se relaiza desde 0 hasta el valor de la variable trayectos con paso 1
					nodo=pila.pop();//Saca el primer elemento de la pila y lo mete en el objeto nodo
					System.out.println(nodo.getData());
				}
			}
			System.out.println("La ruta más corta hace "+trayectos+" trayectos");
		}
		catch(NumberFormatException e){//Sentencia que se realiza si se ha detectado la excepcion NumberPointerException
			System.out.println("Pasemos al siguiente metodo");
		}
		System.out.println("Estaciones terminales: ");
		Queue<Vertex<Estacion>> terminales=buscarTerminales(grafo);//Busca las estaciones terminales del grafo, y las introduce en una cola con los vertices
		while(!terminales.isEmpty()){//Bucle que se realiza si la cola no esta vacia
			System.out.println(terminales.poll().getData().toString());
		}
		System.out.println("");
		conectarVertices(grafo);//Llama al metodo que conecta las estaciones terminales
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
			eliminarNodo(grafo,v);//Llamada al metodo de eliminacion de vertices del grafo, pasandose el vertice a eliminar y el grafo como parametro
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
	/*
	 * Nombre del método: mostrarEstacionesTrayectos
	 * Descripcion del método: Metodo estático que crea el grafo y muestra el número de estaciones y aristas
	 * Argumentos de llamada: 
		grafo: Objeto de la clase Graph que tiene como variables genéricas Estacion y Trayecto
	 * Valor de retorno: Void, no devuelvo nada, pues solo muestra
	 * Archivos necesarios: london_stations.csv y london_lines.csv
	 * Los archivos no hace falta que estén abiertos
	 * FileNotFoundException, que se lanza si no se ha encontrado un fichero
	 */
	private static void mostrarEstacionesTrayectos(Graph<Estacion, Trayecto> grafo) throws FileNotFoundException {
		LecturaFichero<Estacion> ficheroEstacion = new LecturaFichero<>("london_stations.csv");//Objeto de la clase LecturaFichero, con variable generica Estacion, que implementará el fichero london_stations.csv
		LecturaFichero<Trayecto> ficheroLinea = new LecturaFichero<>("london_lines.csv");//Objeto de la clase LecturaFichero, con variable generica Trayecto, que implementará el fichero london_lines.csv
		ficheroEstacion.saltar();//Llamada al metodo saltar de la clase LecturaFichero
		ficheroLinea.saltar();
		while (ficheroEstacion.finLectura()) {//Bucle que se realiza mientras el objeto de lectura no lea una linea en blanco del fichero usado
			Estacion estaciones = new Estacion();//Creacion de un objeto de la clase Estacion
			ficheroEstacion.leer(estaciones);//Mete los datos leídos en el obejeto de la clase Estacion
			grafo.insertVertex(estaciones);//Crea un nodo con dichos datos
		}
		while (ficheroLinea.finLectura()) {
			Trayecto linea = new Trayecto();//Creacion de un objeto de la clase Trayecto
			ficheroLinea.leer(linea);//Mete los datos leídos en el obejeto de la clase Trayecto
			Vertex<Estacion> estacion1 = grafo.getVertex(linea.getEstacion1());//Creacion de un vertice, con variable genérica Estacion
			Vertex<Estacion> estacion2 = grafo.getVertex(linea.getEstacion2());
			Edge<Trayecto> E = grafo.insertEdge(estacion1, estacion2);//Creacion de una arista con los vértices
			grafo.replaceEdge(E, linea);//Mete los datos leidos en la arista
		}
		System.out.println("Hay " + grafo.getN() + " estaciones");//Se muestra por pantalla el número de vértices del grafo
		System.out.println("Hay " + grafo.getM() + " trayectos");//Se muestra por pantalla el número de aristas del grafo
		ficheroEstacion.cerrar();//Se cierra la lectura de fichero
		ficheroLinea.cerrar();
	}
	/*
	 * Nombre del método: buscarRutaCorta
	 * Descripcion del método: Metodo estático que crea que busca la ruta más corta desde un vertice a otro del grafo (BFS)
	 * Argumentos de llamada: 
		grafo: Objeto de la clase Graph que tiene como variables genéricas Estacion y Trayecto
		v1: Objeto de la clase Vertice, que indicara desde cual nodo se empieza la ruta
		v2: Objeto de la clase Vertice, que indicara hasta cual nodo se finaliza la ruta
	 * Valor de retorno: Visitar, indicará el trayecto mas corto de la busqueda
	 */
	private static Visitar buscarRutaCorta(Vertex<Estacion> v1, Vertex<Estacion> v2,Graph<Estacion, Trayecto> grafo) {
		Iterator<Vertex<Estacion>> itVertices;//Creacion de una lista del tipo Iterator con vertices del grafo
		Queue<Vertex<Estacion>> cola = new LinkedList();//Creacion de una cola unidireccional con vertices del grafo
		boolean destinoNoEncontrado = true;//Variable booleana inicializada a true
		Vertex<Estacion> v, w = null;//Vertices, con variable generica Estacion vacíos
		Edge<Trayecto> e;//Arista con variable generica Trayecto
		Iterator<Edge<Trayecto>> itAristas;//Creacion de una lista del tipo Iterator con aristas del grafo
		Visitar<Trayecto> vVisitado = null;//Objeto de la clase visitar, con variable generica Trayecto, vacip
		itVertices = grafo.getVertices();//Inserta los vertices del grafo en el Iterator
		while (itVertices.hasNext()) {//Bucle que se realiza mientras el Iterator tenga contenido
			v = itVertices.next();//Mete en el objeto el un elemento del Iterator
			v.setDecorator(new Visitar(v.getData()));//Actualiza el Decorator de la clase Visitar 
		}
		((Visitar) v1.getDecorator()).setVisitado(true);//Actualiza la variable booleana de la clase Visitar
		cola.offer(v1);//Introduce el vertice 1 en la cola
		while (!cola.isEmpty() && destinoNoEncontrado) {//Bucle que se realiza mientras la cola no este vacía, y la variable booleana sera true
			v = cola.poll();//Mete un elemento de la cola en el objeto, el cual sera eliminado de la cola
			itAristas = grafo.incidentEdges(v);//Mete en el Iterator las aristas incidentes del vertice
			while (itAristas.hasNext() && destinoNoEncontrado) {//Bucle que se realiza mientras el Iterator tenga contenido, y la variable booleana sera true
				e = itAristas.next();//Mete en el objeto el un elemento del Iterator
				w = grafo.opposite(v, e);//Mete en el objeto el siguiente vertice que hay en la arista desde el vertice pasado como parámetro
				vVisitado = (Visitar) w.getDecorator();//Obtiene el Decorator de la clase Visitar
				if (!vVisitado.isVisitado()) {//Condicion que se cumple si la variable booleana de la clase Visitar es false
					vVisitado.setVisitado(true);//Actualiza la variable booleana de la clase Visitar a true
					cola.offer(w);//Mete el vertice w en la cola
					vVisitado.setPadre((Visitar) v.getDecorator());//Actualiza el objeto padre de la clase Visitar
					destinoNoEncontrado = !(w.getData().equals(v2.getData()));//Introduce en la variable booleana true o false, segun si el vertice del itertor es igual al vertice 2
				}
			}
		}
		if (destinoNoEncontrado) {//Condicion que se cumple si la variable booleana es true
			vVisitado = null;//Vacía el objeto de la clase Visitar
		}
		return vVisitado;//Devuelve el objeto de la clase Visitar
	}
	/*
	 * Nombre del método: calcularGrado
	 * Descripcion del método: Metodo estático que calcula el grado de un vertice del grafo
	 * Argumentos de llamada: 
		grafo: Objeto de la clase Graph que tiene como variables genéricas Estacion y Trayecto
		v: Objeto de la clase Vertice, que indicara desde cual nodo se empieza la ruta
	 * Valor de retorno: int, pues se indica el grado del vertice
	 */
	private static int calcularGrado(Graph<Estacion,Trayecto> grafo,Vertex<Estacion> v){
		Iterator<Edge<Trayecto>> it=grafo.incidentEdges(v);
		int grado=0;//Variable entera inicializada a 0
		while(it.hasNext()) {
			grado++;//Incrementa el entero de 1 en 1
			it.next();
		}
		return grado;//Devuelve el entero
	}
	/*
	 * Nombre del método: buscarTerminales
	 * Descripcion del método: Metodo estático que busca los vertices de grado 1 del grafo
	 * Argumentos de llamada: 
		grafo: Objeto de la clase Graph que tiene como variables genéricas Estacion y Trayecto
	 * Valor de retorno: Cola con los vertices del grafo, que serán los que tengan grado 1
	 */
	private static Queue<Vertex<Estacion>> buscarTerminales(Graph<Estacion,Trayecto> grafo){
		Iterator<Vertex<Estacion>> it=grafo.getVertices();//Itertor con los vertices del grafo
		Queue<Vertex<Estacion>> colaTerminales=new LinkedList<>();//Cola unidireccional con los vertices de grado 1 del grafo
		while(it.hasNext()) {
			Vertex<Estacion> v=it.next();
			int grado=calcularGrado(grafo,v);//Llamada al metodo que calcula el grado de un vertice del grafo
			if(grado==1) {//Condicion que se cumple si el valor entero es 1
				colaTerminales.add(v);//Se agrega un vertice a la cola
			}
		}
		return colaTerminales;//Devuelve la cola con los vertices de grado 1 del grafo
	}
	/*
	 * Nombre del método: calcularDistancia
	 * Descripcion del método: Metodo estático que calcula la distancia entre vertices del grafo
	 * Argumentos de llamada: 
		v: Objeto de la clase Vertice, que indicara desde cual nodo se empieza la ruta
		w: Objeto de la clase Vertice, que indicara hasta cual nodo se finaliza la ruta
	 * Valor de retorno: double, pues será las distancia entre esos vertices
	 */
	private static double calcularDistancia(Vertex<Estacion> v,Vertex<Estacion> w) {
		double f=111320;//Variable de tipo double inicializada a 111320
		double latitudV=Double.parseDouble(v.getData().getLatitud());//Convierte la latitud del nodo del grafo, que es una cadena de caracteres a double
		double latitudW=Double.parseDouble(w.getData().getLatitud());
		double longitudV=Double.parseDouble(v.getData().getLongitud());//Convierte la longitud del nodo del grafo, que es una cadena de caracteres a double
		double longitudW=Double.parseDouble(w.getData().getLongitud());
		double distanciaC=Math.sqrt(((latitudV-latitudW)*(latitudV-latitudW))+((longitudV-longitudW)*(longitudV-longitudW)));//Calculo de la distacia geografica entre vertices del grafo
		double distancia=f*distanciaC;//Calculo de la distancia en metros entre esos dos vertices
		return distancia;//Devuelve la distancia entre los vertices del grafo
	}
	/*
	 * Nombre del método: conectarVertices
	 * Descripcion del método: Metodo estático que crea aristas entre vertices de grado 1 del grafo mas cercanos
	 * Argumentos de llamada: 
		grafo: Objeto de la clase Graph que tiene como variables genéricas Estacion y Trayecto
	 * Valor de retorno: Void, pues solo conecta vertices
	 */
	private static void conectarVertices(Graph<Estacion,Trayecto> grafo) {
		Queue<Vertex<Estacion>> terminales=buscarTerminales(grafo);//Cola con los vertices de grado 1 del grafo, a traves de la llamada del metodo que los busca
		List<Vertex<Estacion>> listaTerminales=new ArrayList<>(terminales);//Arraylist con los vertices de la cola anterior
		boolean[] conectadas=new boolean[listaTerminales.size()];//Vector de variables booleanas de longitud igual a longitud e la lista anterior
		for(int i=0;i<listaTerminales.size();i++) {//Bucle que recorre la lista de vertices de grado 1
			if(conectadas[i]) {//Condicion que se cumple si el booleano del vector es true
				continue;//Se sale del bucle
			}
			int cercano=-1;//Variable entera inicializada a -1
			double menorDistancia=100000.0;//Variable double inicializada a 100000.0
			for(int j=0;j<listaTerminales.size();j++) {
				if(i!=j&&!conectadas[j]) {//Condicion que se cumple si los enteros que recorren la lista son distintos y el booleano del vector es falso
					double distancia=calcularDistancia(listaTerminales.get(i),listaTerminales.get(j));//Llamada al vector que calcula la distancia entre terminales
					if(distancia<menorDistancia) {//Condicion que se cumple que distancia es menor que menorDistancia
						menorDistancia=distancia;//Se declara a menorDistancia la distancia entre vertices cercanos del grafo
						cercano=j;//Se declara la posicion del vertice mas cercano
					}
				}
			}
			if(cercano!=-1) {//Condicion que se cumple si la variable entera es distinta de -1
				Vertex<Estacion> e1=listaTerminales.get(i);
				Vertex<Estacion> e2=listaTerminales.get(cercano);
				Trayecto trayectoNuevo=new Trayecto();
				trayectoNuevo.setEstacion1(e1.getData().getIdentificador());
				trayectoNuevo.setEstacion2(e2.getData().getIdentificador());
				trayectoNuevo.setNumLineas("E");
				Edge<Trayecto> eNuevo=grafo.insertEdge(e1, e2);
				grafo.replaceEdge(eNuevo, trayectoNuevo);
				conectadas[i]=true;//Se declara la posicion del vector de booleanos a true
				conectadas[cercano]=true;
				System.out.println("Los nodos: "+e1.getData().getIdentificador()+" y "+e2.getData().getIdentificador()+", con una distancia de "+menorDistancia+" metros entre sí han sido conectados correctamente");
			}
		}
	}
	/*
	 * Nombre del método: eliminarNodo
	 * Descripcion del método: Metodo estático que elimina un vertice del grafo y sus aristas incidentes
	 * Argumentos de llamada: 
		grafo: Objeto de la clase Graph que tiene como variables genéricas Estacion y Trayecto
		v: Objeto de la clase Vertice, que indicara desde cual nodo se empieza la ruta
	 * Valor de retorno: Void, pues solo elimina vertices del grafo
	 */
	private static void eliminarNodo(Graph<Estacion,Trayecto> grafo,Vertex<Estacion> v) {
		Iterator<Edge<Trayecto>> it=grafo.incidentEdges(v);
		grafo.removeVertex(v);//Elimina el vertice del grafo
		while(it.hasNext()) {
			grafo.removeEdge(it.next());//Elimina la arista del grafo
		}
	}
}
