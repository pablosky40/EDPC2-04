package Peticiones;

public class billetesDeTren implements iLecturaFicheros,Comparable<billetesDeTren> {

	public enum tipoSuscripcion {DIAMOND,GOLD,SILVER,BASIC};
	public enum tipoDestino{NATIONAL,INTERNATIONAL};
	private String IDBillete, IDUsuario, destino, numBilletes;
	private tipoSuscripcion tipoSuscripcion;
	private tipoDestino tipoDestino;
	
	public billetesDeTren(String iDBillete, String iDUsuario, tipoSuscripcion tipoSuscripcion, tipoDestino tipoDestino,
			String destino, String numBilletes) {
		this.IDBillete = iDBillete;
		this.IDUsuario = iDUsuario;
		this.tipoSuscripcion = tipoSuscripcion;
		this.tipoDestino = tipoDestino;
		this.destino = destino;
		this.numBilletes = numBilletes;
	}

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
		datosPeticiones[0]=IDBillete;
		datosPeticiones[1]=IDUsuario;
		switch(tipoSuscripcion) {
			case BASIC:
				datosPeticiones[3]="BASIC";
			break;
			case SILVER:
				datosPeticiones[3]="SILVER";
			break;
			case GOLD:
				datosPeticiones[3]="GOLD";
			break;
			case DIAMOND:
				datosPeticiones[3]="DIAMOND";
			break;
		}
		switch(tipoDestino) {
			case NATIONAL:
				datosPeticiones[4]="NATIONAL";
			break;
			case INTERNATIONAL:
				datosPeticiones[4]="INTERNATIONAL";
			break;
		}
		datosPeticiones[4]=destino;
		datosPeticiones[5]=numBilletes;
	}
}
