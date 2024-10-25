package Colas;
import java.io.*;
import java.util.*;
public class sistemaBilletesTren{
	public static void main(String[] args) throws FileNotFoundException {
		int numBilletes=34;
		billetesDeTren billetes[]=new billetesDeTren[numBilletes];
		leerPeticiones(billetes,"D:\\ESI UCLM\\Segundo año\\2ºC\\Primer cuatrimestre\\Estructura de datos (EDA)\\Practicas\\Practica 3\\petitions.csv\"");
		
	}
	public static void leerPeticiones(billetesDeTren [] t,String directorio) throws FileNotFoundException {
		lecturaPeticiones <billetesDeTren> peticion=new lecturaPeticiones <billetesDeTren>("D:\\ESI UCLM\\Segundo año\\2ºC\\Primer cuatrimestre\\Estructura de datos (EDA)\\Practicas\\Practica 3\\petitions.csv\"");
		while(peticion.finLectura()==false) {
			for(int i=0;i<t.length;i++) {
				peticion.leer(t[i]);
				peticion.saltar();
			}
			if(peticion.finLectura()==true) {
				peticion.cerrar();
			}
		}
	}

}
