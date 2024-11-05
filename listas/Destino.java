// J_P_M_C2-04 


package listas;

public class Destino implements Comparable<Destino>,iLeerarchivo { //Implementa la interfaz del programa
	

    private String destino;    //conjunto de strings que nos dicen de que se componen el fichero
    private String pais;
    private  String duracion;
    private String  coste;
    private  String popularidad;
    public enum tipodestino{BEACH,MOUNTAIN,CITY,ADVENTURE}; //enumeracion que nos indica el orden 
    public tipodestino tipodestino;

   
    
    // conjunto de todos los  getter and setters 
    public tipodestino getTipodestino() {
		return tipodestino;
	}


	public void setTipodestino(tipodestino tipodestino) {
		this.tipodestino = tipodestino;
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


	public String getDuracion() {
		return duracion;
	}


	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	public String getCoste() {
		return coste;
	}


	public void setCoste(String coste) {
		this.coste = coste;
	}


	public String getPopularidad() {
		return popularidad;
	}


	public void setPopularidad(String popularidad) {
		this.popularidad = popularidad;
	}

// este es el vector de cadenas donde se almacenara la lectura
	@Override
	public void readData(String[] str) {
		this.destino=str[0];
		this.coste=str[4];
		this.duracion=str[3];
		this.pais=str[1];
		this.popularidad=str[5];
		switch(str[2]) {
		case "Beach":
		this.tipodestino=tipodestino.BEACH; //nos indica si el valor es BEACH
		break;
		case "Mountain":
			this.tipodestino=tipodestino.MOUNTAIN;//nos indica si el valor es MOUNTAIN
		break;
		case "City":
			this.tipodestino=tipodestino.CITY;//nos indica si el valor es CITY
		break;
		case "Adventure":
			this.tipodestino=tipodestino.ADVENTURE;//nos indica si el valor es ADVENTURE
		break;
		
		
		}
		
		
		
		
		
		
	}
//representa en una cadena de caracteres lo que tiene una clase

	@Override
	public String toString() {
		return "destino [destino=" + destino + ", pais=" + pais + ", duracion=" + duracion + ", coste=" + coste
				+ ", popularidad=" + popularidad + ", tipodestino=" + tipodestino + "]";
	}

	
	
	// nos devuelve la prioridad de cada destino dependiendo de la condicion
  public int compareTo (Destino destino) {
	  int prioridad;
	  if(this.getTipodestino().ordinal()==destino.getTipodestino().ordinal()) { 
		  prioridad=0;//Delara que la prioridad es 0, pues no se realiza ningun cambio
		  
	  }
	  else if(this.getTipodestino().ordinal()<destino.getTipodestino().ordinal()) {
		  prioridad=-1;//Declara que la prioridad es -1, pues indica que el objeto de nuestra clase va después del objeto de la clase pasada por entrada
	  }
	  else {
		  prioridad=1;//Declara que la prioridad es 1, pues indica que el objeto de nuestra clase va antes del objeto de la clase pasada por entrada
	  }
	  return prioridad;
  }
}
