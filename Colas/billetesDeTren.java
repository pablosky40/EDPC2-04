/*
 * J_P_M_C2-04
 * Nombre de la clase: billetesDeTren
 * Nombre del autor: Jesús Márquez Duque
 * Fecha de creación: 09/10/2024
 * Versión de la clase: 4.30.0
 * Descripción de la clase: Indica todas las variables y métodos necesarios para un billete de tren, según indique el enunciado
 */
package Colas;

public class billetesDeTren implements iLecturaFicheros,Comparable<billetesDeTren> {//Implementa la interfaz del programa, y otra interfaz del tipo de la misma clase, que corresponde con la interfaz de una cola con prioridad

	public enum tipoSuscripcion {DIAMOND,GOLD,SILVER,BASIC};//Variable de enumeracion que indica el orden de la cola con prioridad por el tipo de suscrpipcion
	public enum tipoDestino{NATIONAL,INTERNATIONAL};//Variable de enumeracion que indica el orden de la cola con prioridad por el tipo de destino
	private String IDBillete, IDUsuario, destino, numBilletes;//Cadenas de caracteres que tienen los billetes de tren según el enunciado
	private tipoSuscripcion TipoSuscripcion;//Variable del tipo de enumeracion tipoSusucrpcion mencionado anteriormente
	private tipoDestino TipoDestino;//Variable del tipo de enumeracion tipoDestino mencionado anteriormente
	/*
	 * Nombre del método: getIDBillete
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Obtiene el valor de la variable IDBillete
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getIDBillete() {
		return IDBillete;
	}
	/*
	 * Nombre del método: setIDBillete
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Actualiza el valor de la variable IDBillete
	 * Argumentos de llamada: 
	 *		iDBillete: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setIDBillete(String iDBillete) {
		IDBillete = iDBillete;
	}
	/*
	 * Nombre del método: getIDUauario
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Obtiene el valor de la variable IDUsuario
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getIDUsuario() {
		return IDUsuario;
	}
	/*
	 * Nombre del método: setIDUusario
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Actualiza el valor de la variable IDUusario
	 * Argumentos de llamada: 
	 *		iDUsuario: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setIDUsuario(String iDUsuario) {
		IDUsuario = iDUsuario;
	}
	/*
	 * Nombre del método: getTipoSuscripcion
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Obtiene el valor de la variable tipoSusucripcion
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: tipoSusucripcion, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public tipoSuscripcion getTipoSuscripcion() {
		return TipoSuscripcion;
	}
	/*
	 * Nombre del método: setTipoSuscripcion
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Actualiza el valor de la variable tipoSuscripcion
	 * Argumentos de llamada: 
	 *		tipoSusucrpcion: Variable del tipo tipoSusucrpcion que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setTipoSuscripcion(tipoSuscripcion tipoSuscripcion) {
		this.TipoSuscripcion = tipoSuscripcion;
	}
	/*
	 * Nombre del método: getDestino
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Obtiene el valor de la variable tipoDestino
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: tipoDestino, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public tipoDestino getTipoDestino() {
		return TipoDestino;
	}
	/*
	 * Nombre del método: setTipoDestino
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Actualiza el valor de la variable tipoDestino
	 * Argumentos de llamada: 
	 *		tipoDestino: Variable del tipo tipoDestino que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setTipoDestino(tipoDestino tipoDestino) {
		this.TipoDestino = tipoDestino;
	}
	/*
	 * Nombre del método: getDestino
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Obtiene el valor de la variable destino
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getDestino() {
		return destino;
	}
	/*
	 * Nombre del método: setDestino
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Actualiza el valor de la variable destino
	 * Argumentos de llamada: 
	 *		destino: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}
	/*
	 * Nombre del método: getNumBilletes
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Obtiene el valor de la variable numBilletes
	 * Argumentos de llamada: Ninguno
	 * Valor de retorno: String, pues devuelve el tipo de variable que se quiere obtener
	 * Archivos necesarios: Ninguno
	 */
	public String getNumBilletes() {
		return numBilletes;
	}
	/*
	 * Nombre del método: setNumBilletes
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Actualiza el valor de la variable numBilletes
	 * Argumentos de llamada: 
	 *		numBilletes: String que indica el valor que se desea actualizar
	 * Valor de retorno: Void, pues solo actualiza
	 * Archivos necesarios: Ninguno
	 */
	public void setNumBilletes(String numBilletes) {
		this.numBilletes = numBilletes;
	}
	/*
	 * Nombre del método: toString
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Representa en una cadena de caracteres lo que tiene la clase
	 * Argumentos de llamada: Nunguno
	 * Valor de retorno: String, pues devuelve una cadena de caracteres con lo que tiene la clase
	 * Archivos necesarios: Ninguno
	 */
	@Override //Indica que ha sido generado el código por el propio programa
	public String toString() {
		return "IDBillete=" + IDBillete + ", IDUsuario=" + IDUsuario + ", tipoSuscripcion="
				+ TipoSuscripcion + ", tipoDestino=" + TipoDestino + ", destino=" + destino + ", numBilletes="
				+ numBilletes;
	}
	/*
	 * Nombre del método: compareTo
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Devuelve la prioridad que tiene un billete al ser añadido a la cola de prioridad
	 * Argumentos de llamada: 
	 *		billetes: Objeto de la misma clase que se compara la saber la prioridad
	 * Valor de retorno: int, devuelve un entero que corresponde a la prioridad
	 * Archivos necesarios: Ninguno
	 */
	@Override
	public int compareTo(billetesDeTren billetes) {
		int prioridad;//Variable de tipo entero que indica la prioridad
		if(this.getTipoSuscripcion().ordinal()==billetes.getTipoSuscripcion().ordinal())//Condicion que se cumple si el enum de la variable tipoSusucrpcion de la clase es igual al enum de la variable tipoSuscripcion de la clase pasada por entrada
			prioridad=0;//Delara que la prioridad es 0, pues no se realiza ningun cambio
		else if(this.getTipoSuscripcion().ordinal()<billetes.getTipoSuscripcion().ordinal())//Condicion que se cumple si el enum de la variable tipoSusucrpcion de la clase es menor que el enum de la variable tipoSuscripcion de la clase pasada por entrada
			prioridad=-1;//Declara que la prioridad es -1, pues indica que el objeto de nuestra clase va después del objeto de la clase pasada por entrada
		else//Condicion que se cumple si no se cumple lo anterior
			prioridad=1;//Declara que la prioridad es 1, pues indica que el objeto de nuestra clase va antes del objeto de la clase pasada por entrada
		return prioridad;
	}
	/*
	 * Nombre del método: leerFichero
	 * Nombre del autor original: Jesús Márquez Duque
	 * Descripcion del método: Guarda lo leído en el fichero en un vector de cadenas
	 * Argumentos de llamada: 
	 *		datosPeticiones: Vector de cadenas de caracteres donde se van a almacenar dicha lectura
	 * Valor de retorno: Void, pues solo guarda
	 * Archivos necesarios: Ninguno
	 */
	public void leerFichero(String[]datosPeticiones) {
		this.IDBillete=datosPeticiones[0];//Guarda el IDBillete en la posicion 0
		this.IDUsuario=datosPeticiones[1];//Guarda el IDUsuario en la posicion 1
		switch(datosPeticiones[2]) {//Según el valor de la cadena, se guardará un tipoSusucripcion cualesquiera en la posicion 2
			case "BASIC"://Si el valor de la cadena es BASIC
				this.TipoSuscripcion=tipoSuscripcion.BASIC;//Indica que el valor de tipoSusucripcion es BASIC
			break;//Fin del caso
			case "SILVER"://Si el valor de la cadena es SILVER
				this.TipoSuscripcion=tipoSuscripcion.SILVER;//Indica que el valor de tipoSusucripcion es SILVER
			break;
			case "GOLD"://Si el valor de la cadena es GOLD
				this.TipoSuscripcion=tipoSuscripcion.GOLD;//Indica que el valor de tipoSusucripcion es GOLD
			break;
			case "DIAMOND"://Si el valor de la cadena es DIAMOND
				this.TipoSuscripcion=tipoSuscripcion.DIAMOND;//Indica que el valor de tipoSusucripcion es DIAMOND
			break;
		}
		switch(datosPeticiones[3]) {//Según el valor de la cadena, se guardará un tipoDestino cualesquiera en la posicion 3
			case "N"://Si el valor de la cadena es N
				this.TipoDestino=tipoDestino.NATIONAL;//Indica que el valor de tipoDestino es NATIONAL
			break;
			case "I"://Si el valor de la cadena es I
				this.TipoDestino=tipoDestino.INTERNATIONAL;//Indica que el valor de tipoDestino es INTERNATIONAL
			break;
		}
		this.destino=datosPeticiones[4];//Guarda el destino en la posicion 4
		this.numBilletes=datosPeticiones[5];//Guarda el numBilletes en la posicion 5
	}
}
