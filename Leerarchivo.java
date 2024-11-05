// J_P_M_C2-04 

package listas;

import java.io.*;//Importa diversos elementos en la clase, en cuanto a lectura de ficheros
import java.util.*;//Importa diversos elementos en la clase, en cuanto a entrada/salida


     public class Leerarchivo <T extends iLeerarchivo>{ // creamos variable que hereda la interfaz
		private File fichero; //archivo que se lee
		private Scanner escaner;//este es el scanner 
		private String separador;//cadena de caracteres que separa las variables
		public Leerarchivo(String nombreFichero, String separador)throws FileNotFoundException {//nombre del metodo leerarchivo
			this.fichero = new File(nombreFichero);//crear archivo
			this.escaner = new Scanner(fichero);//crea scanner 
			this.separador = separador;
		}
		public void leer(T t) {
			String [] datos=escaner.nextLine().split(separador);//Cadena de caracteres que guarda los datos que lee el fichero, separados por la cadena de caracteres separador
			t.readData(datos);
		}
		public void saltar() { //metodo para saltar a la siguiente linea
			escaner.nextLine();
		}
		public void cerrar() { // metodo para cerrar la lectura
			escaner.close();
		}
		public boolean finLectura() {  // metodo que indica cuando finaliza 
			return escaner.hasNextLine();
		}
	}
