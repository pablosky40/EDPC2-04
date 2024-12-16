/*
 * J_P_M_C2-04
 * Nombre de la clase: CompeticionNBA
 * Nombre de los autores: Jesús Márquez Duque, Miguel Mora Vega, Pablo Santillana Fernandez
 * Fecha de creación: 13/11/2024
 * Versión de la clase: 4.30.0
 * Descripción de la clase: Clase pricipal
 */
package arboles;

import treesDS_ESI_UCLM_v2.BinTree;
import treesDS_ESI_UCLM_v2.BinTreeInterface;
import treesDS_ESI_UCLM_v2.NodeBinTree;

public class competicionNBA{
  public static void main(String args[]) {
    /*
		 * Nombre del método: main
		 * Descripcion del método: Metodo principal que es donde se ejecuta el programa
		 * Argumentos de llamada: 
			args: Vector de cadenas de caracteres que indica los caracteres
		 * Valor de retorno: Void, no devuelvo nada, pues solo ejecuta
		 * Archivos necesarios: Ninguno
		 */
    BinTreeInterface<Integer> t=new BinTree<>(); //Creamos un nuevo árbol t pertenciente a la librería importada
    NodeBinTree<Integer> nLak4 = new NodeBinTree<>(6);// Añadimos el número de victorias a cada equipo y su fase con el DNI de mayor valor
    NodeBinTree<Integer> nLak2 = new NodeBinTree<>(7);
    NodeBinTree<Integer> nMia4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nBos4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nBos1 = new NodeBinTree<>(1);
    NodeBinTree<Integer> nKni4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nNug4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nCav4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nCav2 = new NodeBinTree<>(3);
    NodeBinTree<Integer> nMem1 = new NodeBinTree<>(3);
    NodeBinTree<Integer> nMemW= new NodeBinTree<>(7);
    NodeBinTree<Integer> nPhi4 = new NodeBinTree<>(5);
    NodeBinTree<Integer> nBos2= new NodeBinTree<>(3);
    NodeBinTree<Integer> nMem2=new NodeBinTree<>(9);
    NodeBinTree<Integer> nMem4=new NodeBinTree<>(5);
    
    t.addRoot(nMemW); //añadimos los nodos al árbol según la imagen del enunciado comenzando por el ganador (la raíz)
    t.addLeft(nMemW,nBos1);
    t.addRight(nMemW, nMem1);
    t.addLeft(nBos1, nLak2);
    t.addRight(nBos1, nBos2);
    t.addLeft(nMem1, nCav2);
    t.addRight(nMem1, nMem2);
    t.addRight(nLak2, nMia4);
    t.addLeft(nBos2, nBos4);
    t.addRight(nBos2, nKni4);
    t.addLeft(nCav2, nNug4);
    t.addRight(nCav2, nCav4);
    t.addLeft(nMem2, nMem4);
    t.addRight(nMem2, nPhi4);
    t.addLeft(nLak2, nLak4);
    //

    System.out.println("Mejor conferencia: "+mejorConferencia(t));//Sacamos por pantalla el resultado de la conferencia con más victorias
    System.out.println("El número de nodos es: "+t.size());//Sacamos por pantalla el número total de nodos del arbol
  }
  
  private static String mejorConferencia(BinTreeInterface<Integer> t)
  {
    /*
		 * Nombre del método: mejorConferencia
		 * Descripcion del método: método que devuelve "Este" u "oeste" según el número de victorias de cada conferencia
		 * Argumentos de llamada: t, el arbol creado anteriormente
		 * Valor de retorno: String, cadena de caracteres
		 * Archivos necesarios: Ninguno
		 */
  	int vOeste=sumarVictorias(t,t.getRoot().getLeft()),//variables que almacenan las victorias de cada conferencia
  			vEste=sumarVictorias(t,t.getRoot().getRight());

  	if(vOeste>vEste) 
  	  return "West";
  	else 
  		return "East";
  }

  private static int sumarVictorias(BinTreeInterface<Integer> t, NodeBinTree<Integer> nodo)
  {
    /*
		 * Nombre del método: sumarVictorias
		 * Descripcion del método: método que devuelve el número de victorias de una conferencia
		 * Argumentos de llamada: t, el arbol creado anteriormente y los nodos del árbol
		 * Valor de retorno: int
		 * Archivos necesarios: Ninguno
		 */
  	int sv=0; //contador de victorias
    if(t.isExternal(nodo)) //si el nodo es una hoja solo cuenta el suyo
    	sv=nodo.getElement();
    else if(t.isInternal(nodo)) //si el nodo es interno se cuenta tanto el suyo como el de sus hijos
      sv=nodo.getElement()+nodo.getLeft().getElement()+nodo.getRight().getElement();
    return sv;
  }
}
