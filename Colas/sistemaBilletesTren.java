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
		System.out.println("Peticiones:");
		while(fichero.finLectura()) {
			fichero.leer(billete);
			billetes.add(billete);
			System.out.println(billete.toString());
		}
		System.out.println("\n");
		billetesDeTren b[]=new billetesDeTren[billetes.size()];
		for(int i=0;i<=b.length-1;i++){
			b[i]=billetes.remove();
		}
		if(limInternacional!=20||limNacional!=30) {
			for(int i=0;i<=b.length-1;i++) {
				switch(b[i].getTipoDestino()){
					case INTERNATIONAL:
						billetesInternacionales.add(billete);
						System.out.println("Billete internacional con información "+billete.toString()+" procesado correctamente");
						limInternacional++;
					break;
					case NATIONAL:
						billetesNacionales.add(billete);
						System.out.println("Billete nacional con información "+billete.toString()+" procesado correctamente");
						limNacional++;
					break;
				}
			}
		}
		else
			System.out.println("No se ha podido procesar el billete. Límite de billetes alcanzado");
		fichero.cerrar();
	}
}
