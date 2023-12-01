package es.iescanaveral.dam2.geaz;

import java.io.BufferedReader;
import java.io.FileReader;

public class InsertTitulaciones {

	public static void main(String[] args) {
	    String fileName = "/home/dam2aadd/eclipse-workspace/geaz/act11/Actividad11/informacion_titulaciones.txt"; /*
         * donde esta mi archivo. Si lo tengo en el directorio del
         * proyecto lo deberia leer, si no deberiamos poner la ruta aqui.
         * o crear una variable path anadiendo /filename.txt
         */
	    BufferedReader br = null;
		
		try {
		      br = new BufferedReader(new FileReader(fileName)); /*
		                                                          * como no haremos nada intermedio con FileWriter y sabemos que
		                                                          * Buffered reader es mejor en la mayoria de casos solo lo
		                                                          * pasamos como parametro para crear el buffered reader
		                                                          */
		      String linea = br.readLine();/* leemos primera linea */
		      int contador = 1; /* ya hemos leido una linea asi que inicializamos a 1 el contador */
		      while (linea != null) { /*
		                               * estaremos dentro del bucle hasta final de fichero ya br devuelve null al
		                               * terminar de leer
		                               */
		        if (contador > 4) {/* queremos insertar desde la cuarta linea hasta el final */
		        	insertarEnBD(linea);
		        }
		        linea = br.readLine();/* si ha podido insertar leemos la siguiente linea */
		        contador++; /*
		                     * contamos +1 esto es util solo hasta la 4 linea que era lo que necesitamos, si
		                     * querriamos sacar un numero total de insercciones serviria tambien pero dentro
		                     * del if
		                     */
		      }
		    } catch (Exception e) {
		      System.err.println("error con lectura fichero >>>" + e.getMessage());
		    }	

	}
	
	static void insertarEnBD(String linea) { /* Metodo para recibir la linea posteriormente para insertar en formacion_fp*/
													         
		String MySqlQuery = "INSERT INTO T_TITULACIONES VALUES (" + linea + ");";
		System.out.println(MySqlQuery);/*ejecuto esto para que se vea que se va a ejecutar esta query cada vez que entre la linea no tiene que ver con el ejercicio*/
	}
}
