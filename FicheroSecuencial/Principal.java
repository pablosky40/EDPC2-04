package Sesion1;

import java.io.*;

public class Principal <T extends LectorFicheroSecuencial> {
	public static void main(String[] args) throws FileNotFoundException {
		FicheroSecuencial <Satelite> fichero = new FicheroSecuencial<Satelite>(
				"D:\\ESI UCLM\\Segundo año\\2ºC\\Primer cuatrimestre\\Estructura de datos (EDA)\\Practicas\\Practica 1\\weather.csv",
				",");
		int numSatelites=74;
		Satelite s[]=new Satelite[numSatelites];
		while(fichero.finLectura()==true) {
			for(int i=0;i<=numSatelites;i++) {
				fichero.leer(s[i]);
				fichero.saltar();
			}
			if(fichero.finLectura()==true) 
				fichero.cerrar();
		}
	}
}
