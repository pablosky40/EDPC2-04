package FicheroSecuencial;

import java.io.*;

public class principal <T extends satelite> {
	public static void main(String[] args) throws FileNotFoundException {
		String nombreFichero="weather.csv";
		String separador=",";
		ficheroSecuencial<satelite> fichero=new ficheroSecuencial<>(nombreFichero,separador);
		fichero.saltar();
		while(fichero.finLectura()) {
			satelite s=new satelite();
			fichero.leer(s);
			double movimientoMedio=Double.parseDouble(s.getMovimientoMedio());
			if(movimientoMedio<3.0) {
					System.out.println("El satelite "+s.getNombreSatelite()+", hace "+movimientoMedio+" órbitas diarias");
			}
		}
		fichero.cerrar();
	}
}
