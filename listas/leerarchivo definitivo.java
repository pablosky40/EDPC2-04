// J_P_M_C2-04 

package Listas;

import java.io.*;
import java.util.*;

public class Leerarchivo {

    public static List<destino> leerDestinos(String archivo) throws IOException {
        List<destino> destinos = new ArrayList<>();

        
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
              
                String[] partes = linea.split(";");
                if (partes.length == 6) {
                    String destino = partes[0];
                    String pais = partes[1];
                    String tipoDestino = partes[2];
                    int duracion = Integer.parseInt(partes[3]);
                    double coste = Double.parseDouble(partes[4]);
                    int popularidad = Integer.parseInt(partes[5]);

                    destino nuevoDestino = new destino(destino, pais, tipoDestino, duracion, coste, popularidad);
                    destinos.add(nuevoDestino);
                }
            }
        }
        return destinos;
    }
}