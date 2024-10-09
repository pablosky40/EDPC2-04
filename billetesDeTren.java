package Peticiones;

public class billetesDeTren implements iLecturaFicheros {

	private String IDBillete, IDUsuario, tipoSuscripcion, tipoDestino, destino, numBilletes;

	public billetesDeTren(String iDBillete, String iDUsuario, String tipoSuscripcion, String tipoDestino,
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

	public String getTipoSuscripcion() {
		return tipoSuscripcion;
	}

	public void setTipoSuscripcion(String tipoSuscripcion) {
		this.tipoSuscripcion = tipoSuscripcion;
	}

	public String getTipoDestino() {
		return tipoDestino;
	}

	public void setTipoDestino(String tipoDestino) {
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

	public void leerFichero(String[]datosPeticiones) {
		datosPeticiones[0]=IDBillete;
		datosPeticiones[1]=IDUsuario;
		datosPeticiones[2]=tipoSuscripcion;
		datosPeticiones[3]=tipoDestino;
		datosPeticiones[4]=destino;
		datosPeticiones[5]=numBilletes;
	}
}
