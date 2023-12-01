package es.ieselcanaveral.dam2.aadd.lle.trabajo;


import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import es.ieselcanaveral.dam2.aadd.lle.exception.FPException;
import es.ieselcanaveral.dam2.aadd.lle.utilidades.GestorConfiguracion;

public class GestorTitulacionCSV {
	private static String RUTA_FICHERO_TITULACIONES=GestorConfiguracion.getInfoConfiguracion("ruta.csv.titulacion");
	
	/* Lista de los Titulación CSV obtenido del fichero CSV*/
	public List<TitulacionCSV> obtenerListaTitulacionesCSV() throws IOException, FPException
	
	{
		// Fichero de entrada
		FileReader fileReader = new FileReader(RUTA_FICHERO_TITULACIONES);
		List<TitulacionCSV> listaTitulacionesCSV = new CsvToBeanBuilder(fileReader).withType(TitulacionCSV.class).build().parse();

		return listaTitulacionesCSV;
	}	

}