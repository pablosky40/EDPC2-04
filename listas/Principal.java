// J_P_M_C2-04 
package listas;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws FileNotFoundException {
        // Crear lector para el archivo CSV
        Leerarchivo<Destino> lector = new Leerarchivo<>("travels.csv", ";");

        // Lista para almacenar todos los destinos
        List<Destino> destinos = new ArrayList<>();

        // Saltar la primera línea (encabezado)
        lector.saltar();

        // Leer el archivo y cargar los destinos en la lista
        while (lector.finLectura()) {
            Destino destino = new Destino();
            lector.leer(destino);
            destinos.add(destino);
        }
        
        // Cerrar el lector
        lector.cerrar();

        // Lista de Viajes Económicos (menos de 1000)
        List<Destino> viajesEconomicos = new ArrayList<>();
        for (Destino destino : destinos) {
            if (Double.parseDouble(destino.getCoste()) < 1000) {
                viajesEconomicos.add(destino);
            }
        }
        System.out.println("Lista de Viajes Económicos:");
        System.out.println(viajesEconomicos);

        // Recomendaciones Personalizadas
        List<Destino> amantesPlaya = new ArrayList<>();
        List<Destino> aventurerosExtremos = new ArrayList<>();
        for (Destino destino : destinos) {
            switch (destino.getTipodestino()) {
                case BEACH:
                    amantesPlaya.add(destino);
                    break;
                case ADVENTURE:
                    aventurerosExtremos.add(destino);
                    break;
                default:
                    // No hacer nada si no coincide con los tipos especificados
                    break;
            }
        }

        System.out.println("\nRecomendaciones para Amantes de la Playa:");
        System.out.println(amantesPlaya);

        System.out.println("\nRecomendaciones para Aventureros Extremos:");
        System.out.println(aventurerosExtremos);

        // Top 3 Destinos de España
        List<Destino> destinosEspana = new ArrayList<>();
        for (Destino destino : destinos) {
            if (destino.getPais().equalsIgnoreCase("España")) {
                destinosEspana.add(destino);
            }
        }

        // Ordenar los destinos de España por popularidad (si es un número)
        destinosEspana.sort(Comparator.comparingInt(d -> Integer.parseInt(d.getPopularidad())));
        List<Destino> top3Espana = destinosEspana.subList(0, Math.min(3, destinosEspana.size()));

        System.out.println("\nTop 3 Destinos de España:");
        System.out.println(top3Espana);
    }
}
