package FicheroSecuencial;

public class satelite implements iLectorFicheroSecuencial<satelite> {
	private String nombreSatelite;
	private String designador;
	private String epoca;
	private String inclinacion;
	private String RAAN;
	private String excentricidad;
	private String argumentoPerigreo;
	private String movimientoMedio;
	
	public String getNombreSatelite() {
		return nombreSatelite;
	}
	public void setNombreSatelite(String nombreSatelite) {
		this.nombreSatelite = nombreSatelite;
	}
	public String getDesigandor() {
		return designador;
	}
	public void setDesigandor(String desigandor) {
		this.designador = desigandor;
	}
	public String getEpoca() {
		return epoca;
	}
	public void setEpoca(String epoca) {
		this.epoca = epoca;
	}
	public String getInclinacion() {
		return inclinacion;
	}
	public void setInclinacion(String inclinacion) {
		this.inclinacion = inclinacion;
	}
	public String getRAAN() {
		return RAAN;
	}
	public void setRAAN(String rAAN) {
		RAAN = rAAN;
	}
	public String getExcentricidad() {
		return excentricidad;
	}
	public void setExcentricidad(String excentricidad) {
		this.excentricidad = excentricidad;
	}
	public String getArgumentoPerigreo() {
		return argumentoPerigreo;
	}
	public void setArgumentoPerigreo(String argumentoPerigreo) {
		this.argumentoPerigreo = argumentoPerigreo;
	}
	public String getMovimientoMedio() {
		return movimientoMedio;
	}
	public void setMovimientoMedio(String movimientoMedio) {
		this.movimientoMedio = movimientoMedio;
	}
	public String toString() {
		return "satelite [nombreSatelite=" + nombreSatelite + ", designador=" + designador + ", epoca=" + epoca
				+ ", inclinacion=" + inclinacion + ", RAAN=" + RAAN + ", excentricidad=" + excentricidad
				+ ", argumentoPerigreo=" + argumentoPerigreo + ", movimientoMedio=" + movimientoMedio + "]";
	}
	public void readData(String []str) {
		this.nombreSatelite=str[0];
		this.designador=str[1];
		this.epoca=str[2];
		this.movimientoMedio=str[3];
		this.excentricidad=str[4];
		this.inclinacion=str[5];
		this.RAAN=str[6];
		this.argumentoPerigreo=str[7];
	}
}

