package grafos;
import graphsDS_ESI_UCLM_v2.*;
public class Visitar<DA> extends Decorator {
	private boolean visitado;
	private Visitar padre;
	public Visitar(DA datos) {
		super(datos);
		visitado=false;
		padre=null;
	}
	public boolean isVisitado() {
		return visitado;
	}
	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	public Visitar getPadre() {
		return padre;
	}
	public void setPadre(Visitar padre) {
		this.padre = padre;
	}
	public String toString() {
		return visitado+"";
	}
	
}
