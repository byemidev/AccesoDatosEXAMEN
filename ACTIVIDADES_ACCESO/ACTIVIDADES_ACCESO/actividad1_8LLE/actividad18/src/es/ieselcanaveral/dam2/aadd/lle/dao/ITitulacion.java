package es.ieselcanaveral.dam2.aadd.lle.dao;



import java.util.List;



import es.ieselcanaveral.dam2.aadd.lle.exception.FPException;
import es.ieselcanaveral.dam2.aadd.lle.vo.Titulacion;

public interface ITitulacion {
	public Titulacion obtenerTitulacion(String codigo)throws FPException;
	public List<Titulacion> obtenerListaTitulaciones()throws FPException;
}