package listas;
import java.util.*;
import java.io.*;


public class destino{
	
	String Destino;
	String Pais;
	String TipoDestino;
	int duracion;
	double coste;
	int popularidad;

	
	public destino(String Destino, String Pais, String TipoDestino, int duracion, double coste, int popularidad) {
		this.Destino=Destino;
		this.Pais=Pais;
		this.TipoDestino=TipoDestino;
		this.duracion=duracion;
		this.coste=coste;
		this.popularidad=popularidad;
		
	}

	public String toString() {
        return Destino + " (" + Pais + ")  " + TipoDestino + "  " + duracion + " días  " + coste + "€  Popularidad: " + popularidad;
    }
}
