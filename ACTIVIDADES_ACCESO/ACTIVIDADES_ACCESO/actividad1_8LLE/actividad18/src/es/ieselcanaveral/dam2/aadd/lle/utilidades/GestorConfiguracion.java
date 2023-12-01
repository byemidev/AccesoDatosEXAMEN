package es.ieselcanaveral.dam2.aadd.lle.utilidades;



import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class GestorConfiguracion {
	private static Properties propiedades=null;
	public static String getInfoConfiguracion(String clave) {
		String valor = null;
		// Se carga la información del fichero de configuración (una vez)- Utilización del patrón Singleton 
		if(propiedades ==null) {
			InputStream inputStream=null;
			propiedades = new Properties();
			try {
				inputStream = new FileInputStream("config/actividad1_8.properties");
				propiedades.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Se devuelve un valor.
		valor=propiedades.getProperty(clave);
		
		return valor;
	}
}
