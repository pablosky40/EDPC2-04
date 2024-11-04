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
	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getTipoDestino() {
		return TipoDestino;
	}

	public void setTipoDestino(String tipoDestino) {
		TipoDestino = tipoDestino;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public int getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(int popularidad) {
		this.popularidad = popularidad;
	}


	public String toString() {
        return Destino + " (" + Pais + ")  " + TipoDestino + "  " + duracion + " días  " + coste + "€  Popularidad: " + popularidad;
    }
}


