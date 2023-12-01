package es.ieselcanaveral.dam2.aadd.lle.dao.impl;




import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.ieselcanaveral.dam2.aadd.lle.dao.IFamiliaProfesional;
import es.ieselcanaveral.dam2.aadd.lle.dao.INivelTitulacion;
import es.ieselcanaveral.dam2.aadd.lle.dao.ITitulacion;
import es.ieselcanaveral.dam2.aadd.lle.exception.FPException;
import es.ieselcanaveral.dam2.aadd.lle.trabajo.GestorTitulacionCSV;
import es.ieselcanaveral.dam2.aadd.lle.trabajo.TitulacionCSV;
import es.ieselcanaveral.dam2.aadd.lle.vo.FamiliaProfesional;
import es.ieselcanaveral.dam2.aadd.lle.vo.NivelTitulacion;
import es.ieselcanaveral.dam2.aadd.lle.vo.Titulacion;

public class TitulacionDAOImpl implements ITitulacion{


	@Override
	public Titulacion obtenerTitulacion(String codigo)throws FPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Titulacion> obtenerListaTitulaciones() throws FPException{
		// Beans para el tratamiento de la información el los ficheos.
		List<Titulacion> listaTitulaciones=new ArrayList<Titulacion>();
	

		// Se obtiene la lista de familias profesionales para utilizarla posteriomente en el tratamiento de Titulaciones.
		IFamiliaProfesional iFamiliaProfesionalDAO = new FamiliaProfesionalDAOImpl();
		
		// Se obtiene la lista de niveles para utilizarla posteriomente en el tratamiento de Titulaciones.
		INivelTitulacion iNivelTitulacion = new NivelTitulacionDAOImpl();

		GestorTitulacionCSV gestorTitulacionCSV = new GestorTitulacionCSV();
		try {
			List<TitulacionCSV> listaTitulacionesCSV=gestorTitulacionCSV.obtenerListaTitulacionesCSV();
			if (listaTitulacionesCSV!=null) {
				for (TitulacionCSV titulacionCSV : listaTitulacionesCSV) {
					Titulacion titulacion = new Titulacion();
					titulacion.setCodigoTitulacion(titulacionCSV.getCodigoTitulacion());
					titulacion.setNombreTitulacion(titulacionCSV.getNombreTitulacion());
					titulacion.setNumeroHoras(titulacionCSV.getNumeroHoras());
					
					
					// Obtener la familia profesional
					FamiliaProfesional familiaProfesional = null;
					familiaProfesional=iFamiliaProfesionalDAO.obtenerFamiliaProfesional(titulacionCSV.getCodigoFamiliaProfesional());
					titulacion.setFamiliaProfesional(familiaProfesional);
					
					// Obtener el nivel Titulación
					NivelTitulacion nivelTitulacion = null;
					nivelTitulacion=iNivelTitulacion.obtenerNivelTitulacion(titulacionCSV.getCodigoNivelTitulacion());
			 		titulacion.setNivelTitulacion(nivelTitulacion);

					listaTitulaciones.add(titulacion);
				}
			}

		}
		catch (IOException e) 
		{
			e.printStackTrace();
			throw new FPException(FPException.EXCEPCION_CONSULTAR, e);
		}

		return listaTitulaciones;
	}

}


