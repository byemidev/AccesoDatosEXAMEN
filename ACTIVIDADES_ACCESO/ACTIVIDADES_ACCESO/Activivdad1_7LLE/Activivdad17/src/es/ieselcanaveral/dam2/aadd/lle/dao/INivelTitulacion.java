package es.ieselcanaveral.dam2.aadd.lle.dao;
import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;
import es.ieselcanaveral.dam2.aadd.lle.vo.NivelTitulacion;

public interface INivelTitulacion {
	public NivelTitulacion obtenerNivelTitulacion(String codigo);
	public List<NivelTitulacion> obtenerListaNivelesTitulacion();
}
