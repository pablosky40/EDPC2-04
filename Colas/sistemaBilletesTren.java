package Colas;
import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
public class sistemaBilletesTren{
	public static void main(String[] args) throws FileNotFoundException {
		lecturaPeticiones<billetesDeTren> fichero=new lecturaPeticiones <>("petitions.csv");
		PriorityQueue<billetesDeTren> billetes=new PriorityQueue<>();
		Queue<billetesDeTren> billetesNacionales=new LinkedBlockingQueue <>();
		Queue<billetesDeTren> billetesInternacionales=new LinkedBlockingQueue<>();
		int limInternacional=0;
		int limNacional=0;
		fichero.saltar();
		billetesDeTren billete=new billetesDeTren();
		while(fichero.finLectura()) {
			fichero.leer(billete);
			billetes.add(billete);
			if(limInternacional!=20||limNacional!=30) {
				switch(billete.getTipoDestino()) {
					case INTERNATIONAL:
						billetesInternacionales.add(billete);
						System.out.println("Billete internacional con datos "+billete.toString()+" ha sido procesado correctamente");
						break;
					case NATIONAL:
						billetesNacionales.add(billete);
						System.out.println("Billete nacional con datos "+billete.toString()+" ha sido procesado correctamente");
						break;
				}
			}
			else
				System.out.println("El billete no ha podido procesarse. Límite de billetes alcanzado");
		}
		fichero.cerrar();
	}
}
