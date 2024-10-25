package FicheroSecuencial;

public class Satelite implements LectorFicheroSecuencial {
	private String nombreSatelite;
	private String designador;
	private String epoca;
	private String inclinacion;
	private String RAAN;
	private String excentricidad;
	private String argumentoPerigreo;
	private String movimientoMedio;
	public Satelite(String nombreSatelite, String designador, String epoca, String inclinacion, String RAAN,
			String excentricidad, String argumentoPerigreo, String movimientoMedio) {
		this.nombreSatelite = nombreSatelite;
		this.designador = designador;
		this.epoca = epoca;
		this.inclinacion = inclinacion;
		this.RAAN = RAAN;
		this.excentricidad = excentricidad;
		this.argumentoPerigreo = argumentoPerigreo;
		this.movimientoMedio = movimientoMedio;
	}
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
	public void readData(String []str) {
		str[0]=nombreSatelite;
		str[1]=designador;
		str[2]=epoca;
		str[3]=inclinacion;
		str[4]=RAAN;
		str[5]=excentricidad;
		str[6]=argumentoPerigreo;
		str[7]=movimientoMedio;
	}
}

