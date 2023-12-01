package es.ieselcanaveral.dam2.aadd.lle.dao;


import java.util.List;

import es.ieselcanaveral.dam2.aadd.lle.vo.Titulacion;


import java.util.List;


public interface ITitulacion {
	public Titulacion obtenerTitulacion(String codigo);
	public List<Titulacion> obtenerListaTitulaciones();
}
