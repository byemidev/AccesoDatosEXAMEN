package es.ieselcanaveral.dam2.aadd.lle;


import java.io.FileNotFoundException;




import java.io.IOException;
import java.util.List;

import es.ieselcanaveral.dam2.aadd.lle.exception.FPException;
import es.ieselcanaveral.dam2.aadd.lle.vo.FamiliaProfesional;
import es.ieselcanaveral.dam2.aadd.lle.vo.Titulacion;

public class AppPrincipal {

	public static void main(String[] args) throws IOException, FPException {
		try {
			
			GestorFicheros gestorFicheros = new GestorFicheros();

			// Tratamiento de Niveles de Titulacion
	    	List<Titulacion> listaTitulaciones= gestorFicheros.obtenerListaTitulaciones();
			// Imprimir la lista de Niveles de titulacion
	    	System.out.println(listaTitulaciones);	

					 
	    	// Mínimo 3 parámetros.
	    	if (args.length ==3) {
		    	String codigo_familia=args[0];
		    	String nombre_familia=args[1];
		    	String operacion=args[2];
		    	FamiliaProfesional familia=new FamiliaProfesional();
		    	familia.setCodigoFamilia(codigo_familia);
		    	familia.setNombreFamilia(nombre_familia);
		    	gestorFicheros.tratarFamiliaProfesional(familia,operacion);
	    	}else {
		    	System.out.println("Ha de introducir tres parámetros. Uno para el código de familia, otro para el nombre de Familia y otro para la Operación a realizar (valores 'A'--> Actualizar o 'B'--> Borrar.");	    		
	    	}

		}catch (FileNotFoundException excepcion) {
	    	excepcion.printStackTrace();
	    	
		}catch (FPException e) {
			long codigoError = e.getCodigoError();
			
			if (codigoError == FPException.EXCEPCION_CREAR) {
				System.err.println("Error al crear una familia profesional: " + e.getMessage());
			} else if (codigoError == FPException.EXCEPCION_ACTUALIZAR) {
				System.err.println("Error al actualizar una familia profesional: " + e.getMessage());
			} else if (codigoError == FPException.EXCEPCION_BORRAR) {
				System.err.println("Error al borrar una familia profesional: " + e.getMessage());
			} else if (codigoError == FPException.EXCEPCION_CONSULTAR) {
				System.err.println("Error al consultar una familia profesional: " + e.getMessage());
			} else {
				System.err.println("Error desconocido: " + e.getMessage());
			}
			
		
		}catch (Exception excepcion) {
			excepcion.printStackTrace();
	    }			

	}
}
