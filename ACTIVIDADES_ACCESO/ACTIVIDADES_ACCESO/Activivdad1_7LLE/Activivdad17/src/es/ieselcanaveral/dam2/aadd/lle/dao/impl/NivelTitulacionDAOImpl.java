package es.ieselcanaveral.dam2.aadd.lle.dao.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import es.ieselcanaveral.dam2.aadd.lle.vo.NivelTitulacion;
import es.ieselcanaveral.dam2.aadd.lle.dao.INivelTitulacion;

public class NivelTitulacionDAOImpl implements INivelTitulacion{
	private static String RUTA_FICHERO_NIVELES_TITULACION="/home/bbdd2324/inm/act17/niveltitulacion.csv";
	public static char SEPARADOR_CSV_NIVEL_TITULACION='#';

	@Override
	/* Obtiene un Nivel de Titulación a partir del un código fichero CSV*/
	public NivelTitulacion obtenerNivelTitulacion(String codigo) {
		NivelTitulacion nivelTitulacion=null;
		List<NivelTitulacion> listaNiveles = obtenerListaNivelesTitulacion();
		for (NivelTitulacion nivel : listaNiveles) {
			if(nivel.getCodigoNivel()!=null && nivel.getCodigoNivel().equals(codigo)) {
				nivelTitulacion=nivel;
				break;
			}			
		}
			
		return nivelTitulacion;
	}

	/* Obtiene la lista de Niveles de Titulación a partir del fichero CSV*/
	public List<NivelTitulacion> obtenerListaNivelesTitulacion() {
		List<NivelTitulacion> listaNivelesTitulacion =null; 
		// Fichero de entrada
		FileReader fileReader=null;
		try {
			fileReader = new FileReader(RUTA_FICHERO_NIVELES_TITULACION);
			listaNivelesTitulacion =new CsvToBeanBuilder(fileReader).withSeparator(SEPARADOR_CSV_NIVEL_TITULACION)
				       .withType(NivelTitulacion.class).build().parse();
 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaNivelesTitulacion;

	}

}
