/*
 * J_P_M_C2-04
 * Nombre de la clase: sistemaBilletesTren
 * Nombre del autor: Jesús Márquez Duque
 * Fecha de creación: 09/10/2024
 * Versión de la clase: 4.30.0
 * Descripción de la clase: Clase pricipal
 */
package Colas;
import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;//Importa los elementos de las colas unidireccionales
public class sistemaBilletesTren{
	public static void main(String[] args) throws FileNotFoundException {
		lecturaPeticiones<billetesDeTren> fichero=new lecturaPeticiones <>("petitions.csv");//Creacion del objeto lecturaPeticiones, con una variable generica de la clase billetesDeTren
		PriorityQueue<billetesDeTren> billetes=new PriorityQueue<>();//Creacion de una cola con prioridad, con una variable genérica de la clase billetesDeTren
		Queue<billetesDeTren> billetesNacionales=new LinkedBlockingQueue <>();//Creacion de una cola unidireccional, con una variable genérica de la clase billetesDeTren
		Queue<billetesDeTren> billetesInternacionales=new LinkedBlockingQueue<>();
		int limInternacional=0;//Creacion de una variable entera que induca cuantos billetes internacionales están siendo procesados, en este caso, 0
		int limNacional=0;//Creacion de una variable entera que induca cuantos billetes nacionales están siendo procesados, en este caso, 0
		fichero.saltar();//Salta una línea en la lectura del fichero
		billetesDeTren billete=new billetesDeTren();//Creacion de un objeto de la clase billetesDeTren
		while(fichero.finLectura()) {//Bucle que se realiza mientras la lectura del fichero no termine
			fichero.leer(billete);//Lee el fichero, y guarda sus billetes en el objeto billetes
			billetes.add(billete);//Añade a la cola con prioridad los billetes leídos
			System.out.println(billete.toString());//Imprime por pantalla la representacion del objeto billete
			if(limInternacional!=20||limNacional!=30) {//Condicion que se cumple si no se alcanza el límite de los billetes procesados
				switch(billete.getTipoDestino()) {//Según el tipo de destino se relizara un determinado proceso
					case INTERNATIONAL://Caso en el que el tipo de destino sea internacional
						billetesInternacionales.add(billete);//Añade a la cola de billetes internacionales el billete internacional
						System.out.println("Dicho billete internacional ha sido procesado correctamente");//Imprime un mensaje si se ha podido procesar el billete internacional
						break;
					case NATIONAL://Caso en el que el tipo de destino sea nacional
						billetesNacionales.add(billete);//Añade a la cola de billetes nacionales el billete nacional
						System.out.println("Dicho billete nacional ha sido procesado correctamente");//Imprime un mensaje si se ha podido procesar el billete nacional
						break;
				}
			}
			else//Condicion que se cumple si no se ha cumplido lo anterior
				System.out.println("El billete no ha podido procesarse. Límite de billetes alcanzado");//Imprime un mensaje si no ha podido procesar el billete
		}
		fichero.cerrar();//Cierra la lectura del fichero
	}
}
