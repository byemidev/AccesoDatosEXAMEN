package es.ieselcanaveral.dam2.aadd.lle.dao.impl;


import es.ieselcanaveral.dam2.aadd.lle.dao.IFamiliaProfesional;

import es.ieselcanaveral.dam2.aadd.lle.vo.FamiliaProfesional;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class FamiliaProfesionalDAOImpl implements IFamiliaProfesional{
	private static String RUTA_FICHERO_FAMILIAS_PROFESIONALES="/home/bbdd2324/inm/act17/familia_profesional.csv";
	public static char SEPARADOR_CSV_FAMILIA='|';

	/* Obtiene un objeto de tipo FamiliasProfesional a partir del código de nivel de titulación*/
	public FamiliaProfesional obtenerFamiliaProfesional(String codigo) {
		FamiliaProfesional familiaProfesional=null;
		
		List<FamiliaProfesional> listaFamiliasProfesionales = obtenerListaFamiliasProfesionales();
		for (FamiliaProfesional familia : listaFamiliasProfesionales) {
			if(familia.getCodigoFamilia()!=null && familia.getCodigoFamilia().equals(codigo)) {
				familiaProfesional=familia;
				break;
			}
			
		}
			
		return familiaProfesional;
	}

	/* Obtiene la lista de FamiliasProfesional a partir del fichero CSV*/
	public List<FamiliaProfesional> obtenerListaFamiliasProfesionales() {
		List<FamiliaProfesional> listaFamiliasProfesionales =null; 
		// Fichero de entrada
		FileReader fileReader=null;
		try {
			fileReader = new FileReader(RUTA_FICHERO_FAMILIAS_PROFESIONALES);
			listaFamiliasProfesionales = new CsvToBeanBuilder(fileReader).withSeparator(SEPARADOR_CSV_FAMILIA)
				       .withType(FamiliaProfesional.class).build().parse();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaFamiliasProfesionales;
	}

	/* Inserta una FamiliaProfesional en el fichero CSV*/
	public void insertarFamiliaProfesional(FamiliaProfesional familiaProfesional) {
		Path rutaFichero = Paths.get(RUTA_FICHERO_FAMILIAS_PROFESIONALES);
		String lineaFamiliProfesional = familiaProfesional.getCodigoFamilia() + SEPARADOR_CSV_FAMILIA +  familiaProfesional.getNombreFamilia()+ System.getProperty("line.separator");
		System.out.println(lineaFamiliProfesional);
        try {
			Files.writeString(rutaFichero, lineaFamiliProfesional, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* Actualizar una FamiliaProfesional en el fichero CSV*/
	public void actualizarFamiliaProfesional(FamiliaProfesional familiaProfesional) {
		List<FamiliaProfesional> familiasProfesionales =obtenerListaFamiliasProfesionales();
		boolean registroActualizado=false;
		for (FamiliaProfesional familiaProfesional2 : familiasProfesionales) {
			if (familiaProfesional2.getCodigoFamilia().equals(familiaProfesional.getCodigoFamilia()) ){
				familiaProfesional2.setNombreFamilia(familiaProfesional.getNombreFamilia());
				
				registroActualizado=true;
				
				break;
			}
		}
		// Si se ha actualizado alguna familia profesional se crea un nuevo fichero.
		if(registroActualizado) {
			// Crear un fichero con las Familias Profesionales.
			Path rutaFichero = Paths.get(RUTA_FICHERO_FAMILIAS_PROFESIONALES);
			String cabecera=null;
			try {
				cabecera= Files.readAllLines(rutaFichero).get(0)+ System.getProperty("line.separator");
		        Files.writeString(rutaFichero, cabecera, StandardCharsets.UTF_8);
				System.out.println(cabecera);
				for (FamiliaProfesional familia : familiasProfesionales) {				
					String lineaFamiliProfesional = familia.getCodigoFamilia() + SEPARADOR_CSV_FAMILIA +  familia.getNombreFamilia()+ System.getProperty("line.separator");
					System.out.println(lineaFamiliProfesional);
			        Files.writeString(rutaFichero, lineaFamiliProfesional, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
				}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	/* Borrar una FamiliaProfesional del fichero CSV*/
	public void borrarFamiliaProfesional(FamiliaProfesional familiaProfesional) {
		List<FamiliaProfesional> familiasProfesionales =obtenerListaFamiliasProfesionales();
		boolean registroBorrado=false;
		for (FamiliaProfesional familiaProfesional2 : familiasProfesionales) {
			if (familiaProfesional2.getCodigoFamilia().equals(familiaProfesional.getCodigoFamilia()) ){
				familiasProfesionales.remove(familiaProfesional2);
				registroBorrado=true;
				break;
			}
		}
		// Si se ha borrado alguna familia profesional se crea un nuevo fichero.
		if(registroBorrado) {
			// Crear un fichero con las Familias Profesionales.
			Path rutaFichero = Paths.get(RUTA_FICHERO_FAMILIAS_PROFESIONALES);
			String cabecera=null;
			try {
				cabecera = Files.readAllLines(rutaFichero).get(0)+ System.getProperty("line.separator");
				Files.writeString(rutaFichero, cabecera, StandardCharsets.UTF_8);

				System.out.println(cabecera);
				for (FamiliaProfesional familia : familiasProfesionales) {				
					String lineaFamiliProfesional = familia.getCodigoFamilia() + SEPARADOR_CSV_FAMILIA +  familia.getNombreFamilia()+ System.getProperty("line.separator");
					System.out.println(lineaFamiliProfesional);
							//System.getProperty("line.separator");
					Files.writeString(rutaFichero, lineaFamiliProfesional, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
				}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

}
