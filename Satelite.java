package Sesion1;

public class Satelite implements LectorFicheroSecuencial{
	private String nombreSatelite;
	private String designador;
	private String epoca;
	private double inclinacion;
	private double RAAN;
	private String excentricidad;
	private String argumentoPerigreo;
	private double movimientoMedio;
	public Satelite(String nombreSatelite, String designador, String epoca, double inclinacion, double RAAN,
			String excentricidad, String argumentoPerigreo, double movimientoMedio) {
		super();
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
	public double getInclinacion() {
		return inclinacion;
	}
	public void setInclinacion(double inclinacion) {
		this.inclinacion = inclinacion;
	}
	public double getRAAN() {
		return RAAN;
	}
	public void setRAAN(double rAAN) {
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
	public double getMovimientoMedio() {
		return movimientoMedio;
	}
	public void setMovimientoMedio(double movimientoMedio) {
		this.movimientoMedio = movimientoMedio;
	}
	public void readData(String []str) {
		str[0]=nombreSatelite;
		str[1]=designador;
		
	}
}

