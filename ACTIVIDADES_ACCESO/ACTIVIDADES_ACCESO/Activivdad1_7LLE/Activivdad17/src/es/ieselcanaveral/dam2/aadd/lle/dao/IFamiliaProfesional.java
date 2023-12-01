package es.ieselcanaveral.dam2.aadd.lle.dao;

import es.ieselcanaveral.dam2.aadd.lle.vo.FamiliaProfesional;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvValidationException;

public interface IFamiliaProfesional {
	public FamiliaProfesional obtenerFamiliaProfesional(String codigo);
	public List<FamiliaProfesional> obtenerListaFamiliasProfesionales();
	public void insertarFamiliaProfesional (FamiliaProfesional familiaProfesional);
	public void actualizarFamiliaProfesional (FamiliaProfesional familiaProfesional);
	public void borrarFamiliaProfesional (FamiliaProfesional familiaProfesional);
}
