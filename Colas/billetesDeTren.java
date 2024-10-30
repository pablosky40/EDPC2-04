package Colas;

public class billetesDeTren implements iLecturaFicheros<billetesDeTren>,Comparable<billetesDeTren> {

	public enum tipoSuscripcion {DIAMOND,GOLD,SILVER,BASIC};
	public enum tipoDestino{NATIONAL,INTERNATIONAL};
	private String IDBillete, IDUsuario, destino, numBilletes;
	private tipoSuscripcion tipoSuscripcion;
	private tipoDestino tipoDestino;

	public String getIDBillete() {
		return IDBillete;
	}

	public void setIDBillete(String iDBillete) {
		IDBillete = iDBillete;
	}

	public String getIDUsuario() {
		return IDUsuario;
	}

	public void setIDUsuario(String iDUsuario) {
		IDUsuario = iDUsuario;
	}

	public tipoSuscripcion getTipoSuscripcion() {
		return tipoSuscripcion;
	}

	public void setTipoSuscripcion(tipoSuscripcion tipoSuscripcion) {
		this.tipoSuscripcion = tipoSuscripcion;
	}

	public tipoDestino getTipoDestino() {
		return tipoDestino;
	}

	public void setTipoDestino(tipoDestino tipoDestino) {
		this.tipoDestino = tipoDestino;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getNumBilletes() {
		return numBilletes;
	}

	public void setNumBilletes(String numBilletes) {
		this.numBilletes = numBilletes;
	}

	
	@Override
	public String toString() {
		return "billetesDeTren [IDBillete=" + IDBillete + ", IDUsuario=" + IDUsuario + ", tipoSuscripcion="
				+ tipoSuscripcion + ", tipoDestino=" + tipoDestino + ", destino=" + destino + ", numBilletes="
				+ numBilletes + "]";
	}
	

	@Override
	public int compareTo(billetesDeTren billetes) {
		int prioridad;
		if(billetes.getTipoSuscripcion().ordinal()==this.getTipoSuscripcion().ordinal())
			prioridad=0;
		else if(billetes.getTipoSuscripcion().ordinal()<this.getTipoSuscripcion().ordinal())
			prioridad=-1;
		else
			prioridad=1;
		return prioridad;
	}

	public void leerFichero(String[]datosPeticiones) {
		this.IDBillete=datosPeticiones[0];
		this.IDUsuario=datosPeticiones[1];
		switch(datosPeticiones[2]) {
			case "BASIC":
				this.tipoSuscripcion=tipoSuscripcion.BASIC;
			break;
			case "SILVER":
				this.tipoSuscripcion=tipoSuscripcion.SILVER;
			break;
			case "GOLD":
				this.tipoSuscripcion=tipoSuscripcion.GOLD;
			break;
			case "DIAMOND":
				this.tipoSuscripcion=tipoSuscripcion.DIAMOND;
			break;
		}
		switch(datosPeticiones[3]) {
			case "NATIONAL":
				this.tipoDestino=tipoDestino.NATIONAL;
			break;
			case "INTERNATIONAL":
				this.tipoDestino=tipoDestino.INTERNATIONAL;
			break;
		}
		this.destino=datosPeticiones[4];
		this.numBilletes=datosPeticiones[5];
	}
}

