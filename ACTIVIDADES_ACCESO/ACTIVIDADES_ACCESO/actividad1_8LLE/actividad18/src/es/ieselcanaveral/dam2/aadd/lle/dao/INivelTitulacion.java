package es.ieselcanaveral.dam2.aadd.lle.dao;




import java.util.List;


import es.ieselcanaveral.dam2.aadd.lle.exception.FPException;
import es.ieselcanaveral.dam2.aadd.lle.vo.NivelTitulacion;

public interface INivelTitulacion {
	public NivelTitulacion obtenerNivelTitulacion(String codigo)throws FPException;
	public List<NivelTitulacion> obtenerListaNivelesTitulacion()throws FPException;
}