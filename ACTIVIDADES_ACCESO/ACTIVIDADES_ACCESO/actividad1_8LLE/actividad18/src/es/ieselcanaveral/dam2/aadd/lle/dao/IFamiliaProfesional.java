package es.ieselcanaveral.dam2.aadd.lle.dao;




import java.util.List;




import es.ieselcanaveral.dam2.aadd.lle.exception.FPException;
import es.ieselcanaveral.dam2.aadd.lle.vo.FamiliaProfesional;

public interface IFamiliaProfesional {
	public FamiliaProfesional obtenerFamiliaProfesional(String codigo) throws FPException;
	public List<FamiliaProfesional> obtenerListaFamiliasProfesionales() throws FPException;
	public void insertarFamiliaProfesional (FamiliaProfesional familiaProfesional) throws FPException;
	public void actualizarFamiliaProfesional (FamiliaProfesional familiaProfesional) throws FPException;
	public void borrarFamiliaProfesional (FamiliaProfesional familiaProfesional) throws FPException;
}