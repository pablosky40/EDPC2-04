/*
 * J_P_M_C2-04
 * Nombre de la clase: Visitar
 * Nombre de los autores: Jesús Márquez Duque, Miguel Mora Vega, Pablo Santillana Fernandez
 * Fecha de creación: 13/11/2024
 * Versión de la clase: 4.30.0
 * Descripción de la clase: Indica si el vértice del grafo ha sido visitado al hacer BFS
 */
package grafos;
import graphsDS_ESI_UCLM_v2.*;//Importa los elementos de la librería de grafos graphsDS_ESI_UCLM_v2
public class Visitar<DA> extends Decorator {//Dicha clase, con una variable generica, hereda de la clase Decorator de grafos
	private boolean visitado;//Variable privada booleana que indica que el vertice ha sido visitado
	private Visitar padre;//Variable privada del tipo de la clase que indica el vertice
	/*
	 * Nombre del método: Visitar
	 * Descripcion del método: Constructor de la clase, que es como se va a inicializar
	 * Argumentos de llamada: 
		datos: DA, es decir, del tipo genérico
	 * Valor de retorno: Void, no devuelvo nada, pues es el constructor
	 * Archivos necesarios: Ninguno
	 */
	public Visitar(DA datos) {
		super(datos);//Coge la variable de la clase Decortator, que es la que hereda
		visitado=false;//Inicializa la variable visitado a falsa
		padre=null;//Inicializa la variable padre como vacía
	}
	/*
	 * Nombre del método: isVisitado
	 * Descripcion del método: Obtiene el valor de la variable visitado
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: boolean, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public boolean isVisitado() {
		return visitado;
	}
	/*
	 * Nombre del método: setVisitado
	 * Descripcion del método: Actualiza el valor de la variable visitado
	 * Argumentos de llamada: 
	 *		visitado: boolean que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	/*
	 * Nombre del método: getPadre
	 * Descripcion del método: Obtiene el valor de la variable padre
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: Visitar, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public Visitar getPadre() {
		return padre;
	}
	/*
	 * Nombre del método: setPadre
	 * Descripcion del método: Actualiza el valor de la variable padre
	 * Argumentos de llamada: 
	 *		padre: Visitar que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setPadre(Visitar padre) {
		this.padre = padre;
	}
	/*
	 * Nombre del método: toString
	 * Descripcion del método: Representa en una cadena de caracteres lo que tiene la clase
	 * Argumentos de llamada: Nunguno
	 * Valor de retorno: String, pues devuelve una cadena de caracteres con lo que tiene la clase
	 * Archivos necesarios: Ninguno
	 */
	public String toString() {
		return visitado+"";
	}
	
}
