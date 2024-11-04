package listas;
import java.io.*;
import java.util.*;

public class Principal {
	public static void main(String[] args) {
		try {
           
            List<destino> destinos = leerDestinos("travels.csv");

            
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
	
	




}
