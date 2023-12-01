package es.ieselcanaveral.dam2.aadd.lle.trabajo;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class GestorTitulacionCSV {
	private static String RUTA_FICHERO_TITULACIONES="/home/bbdd2324/inm/act17/informacion_titulaciones.csv";
	
	/* Lista de los Titulación CSV obtenido del fichero CSV*/
	public List<TitulacionCSV> obtenerListaTitulacionesCSV() throws IOException
	{
		// Fichero de entrada
		FileReader fileReader = new FileReader(RUTA_FICHERO_TITULACIONES);
		List<TitulacionCSV> listaTitulacionesCSV = new CsvToBeanBuilder(fileReader).withType(TitulacionCSV.class).build().parse();

		return listaTitulacionesCSV;
	}	

}
