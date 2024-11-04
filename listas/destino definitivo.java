// J_P_M_C2-04 


package Listas;

import java.util.*;
import java.io.*;


import java.util.Objects;

public class destino implements Comparable<destino> {
    private String destino;
    private String pais;
    private String tipoDestino;
    private int duracion;
    private double coste;
    private int popularidad;

    public destino(String destino, String pais, String tipoDestino, int duracion, double coste, int popularidad) {
        this.destino = destino;
        this.pais = pais;
        this.tipoDestino = tipoDestino;
        this.duracion = duracion;
        this.coste = coste;
        this.popularidad = popularidad;
    }

   
    public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getTipoDestino() {
		return tipoDestino;
	}


	public void setTipoDestino(String tipoDestino) {
		this.tipoDestino = tipoDestino;
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


	
    public int compareTo(destino otro) {
        int comparacion = Integer.compare(otro.popularidad, this.popularidad); 
        return comparacion!= 0 ? comparacion : Double.compare(this.coste, otro.coste); 
    }

    
    public String toString() {
        return String.format("Destino: %s, País: %s, Tipo: %s, Duración: %d días, Coste: %.2f€, Popularidad: %d",
                destino, pais, tipoDestino, duracion, coste, popularidad);
    }

    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        destino destino1 = (destino) o;
        return destino.equals(destino1.destino);
    }

    
    public int hashCode() {
        return Objects.hash(destino);
    }
}
