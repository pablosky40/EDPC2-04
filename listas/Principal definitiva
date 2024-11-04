// J_P_M_C2-04 

package Listas;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class Principal {
	public static void main(String[] args) {
		try {
           
            List<destino> destinos = Leerarchivo.leerDestinos("travels.csv");

            
            System.out.println("1. Lista de Viajes Económicos:");
            List<destino> viajesEconomicos = listaViajesEconomicos(destinos);
            viajesEconomicos.forEach(System.out::println);

            
            System.out.println("\n2.1 Lista para Amantes de la Playa:");
            List<destino> amantesPlaya = listaAmantesPlaya(destinos);
            amantesPlaya.forEach(System.out::println);

          
            System.out.println("\n2.2 Lista para Aventureros Extremos:");
            List<destino> aventurerosExtremos = listaAventurerosExtremos(destinos);
            aventurerosExtremos.forEach(System.out::println);

            
            System.out.println("\n3. Top 3 Destinos de España:");
            List<destino> top3España = top3DestinosEspaña(destinos);
            top3España.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
	
	  private static List<destino> listaViajesEconomicos(List<destino> destinos) {
	        return destinos.stream()
	                .filter(d -> d.getCoste() < 1000)
	                .sorted()
	                .collect(Collectors.toList());
	    }
	  
	  private static List<destino> listaAmantesPlaya(List<destino>destinos) {
		 return destinos.stream()
		                .filter(d -> d.getTipoDestino().equalsIgnoreCase("Beach") && d.getDuracion() < 7)
		                .collect(Collectors.toList());
		    }
	  

private static List<destino> listaAventurerosExtremos(List<destino> destinos) {
    return destinos.stream()
            .filter(d -> d.getTipoDestino().equalsIgnoreCase("Adventure") && d.getPopularidad() >= 4)
            .collect(Collectors.toList());
}


private static List<destino> top3DestinosEspaña(List<destino> destinos){
	return destinos.stream()
			.filter(d -> d.getPais().equalsIgnoreCase("España"))
            .sorted()
            .limit(3)
            .collect(Collectors.toList());
}

	
	




}
