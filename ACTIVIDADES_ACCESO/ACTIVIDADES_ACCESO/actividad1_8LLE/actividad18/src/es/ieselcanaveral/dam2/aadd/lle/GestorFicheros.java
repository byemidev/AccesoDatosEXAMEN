package es.ieselcanaveral.dam2.aadd.lle;



import java.io.IOException;



import java.util.List;

import es.ieselcanaveral.dam2.aadd.lle.dao.IFamiliaProfesional;
import es.ieselcanaveral.dam2.aadd.lle.dao.ITitulacion;
import es.ieselcanaveral.dam2.aadd.lle.dao.impl.FamiliaProfesionalDAOImpl;
import es.ieselcanaveral.dam2.aadd.lle.dao.impl.TitulacionDAOImpl;
import es.ieselcanaveral.dam2.aadd.lle.vo.FamiliaProfesional;
import es.ieselcanaveral.dam2.aadd.lle.vo.Titulacion;
import es.ieselcanaveral.dam2.aadd.lle.exception.FPException;
public class GestorFicheros {
	
	public List<Titulacion> obtenerListaTitulaciones() throws IOException, FPException
	{
		ITitulacion iTitulacionDAO = new TitulacionDAOImpl();
		return iTitulacionDAO.obtenerListaTitulaciones();
	}	

	/* Tratamiento de la información de Familia Profesional obtenido de parámetros de entrada*/
	public void tratarFamiliaProfesional(FamiliaProfesional familia, String operacion) throws IOException, FPException
	{
		IFamiliaProfesional iFamiliaProfesionalDAO = new FamiliaProfesionalDAOImpl();
		// Se obtiene la lista de familias profesionales.
		FamiliaProfesional familiaProfesional=iFamiliaProfesionalDAO.obtenerFamiliaProfesional(familia.getCodigoFamilia());
		if (familiaProfesional==null) {  // Añadirla lista
			iFamiliaProfesionalDAO.insertarFamiliaProfesional(familiaProfesional);
		}else if (operacion!=null && (!operacion.equals("A") && !operacion.equals("B")))
			System.out.println("La operación introducida '" + operacion + "' Es errónea. Ha de valer 'A' , o 'B'");
		else if (operacion.equals("A")) { // Actualización Nombre en la lista
			System.out.println("Actualizar nombre de Familia profesional.");
			iFamiliaProfesionalDAO.actualizarFamiliaProfesional(familia);
		}else { // Borrado de la lista
			System.out.println("Borrar fila de Familia profesional.");
			iFamiliaProfesionalDAO.borrarFamiliaProfesional(familiaProfesional);
		}
	}	

}

