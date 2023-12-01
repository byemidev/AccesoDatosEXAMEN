package es.ieselcanaveral.dam2.aadd.lle.dao.impl;


import java.io.FileNotFoundException;

import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import es.ieselcanaveral.dam2.aadd.lle.dao.INivelTitulacion;
import es.ieselcanaveral.dam2.aadd.lle.exception.FPException;
import es.ieselcanaveral.dam2.aadd.lle.utilidades.GestorConfiguracion;
import es.ieselcanaveral.dam2.aadd.lle.vo.NivelTitulacion;

public class NivelTitulacionDAOImpl implements INivelTitulacion {
	private static String RUTA_FICHERO_NIVELES_TITULACION=GestorConfiguracion.getInfoConfiguracion("ruta.csv.nivel.titulacion");
	public static char SEPARADOR_CSV_NIVEL_TITULACION=GestorConfiguracion.getInfoConfiguracion("separador.csv.nivel.titulacion").charAt(0);

	@Override
	/* Obtiene un Nivel de Titulación a partir del un código fichero CSV*/
	public NivelTitulacion obtenerNivelTitulacion(String codigo) throws FPException {
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
	public List<NivelTitulacion> obtenerListaNivelesTitulacion() throws FPException {
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
			throw new FPException(FPException.EXCEPCION_CONSULTAR, e);
			
		}

		return listaNivelesTitulacion;

	}

}
