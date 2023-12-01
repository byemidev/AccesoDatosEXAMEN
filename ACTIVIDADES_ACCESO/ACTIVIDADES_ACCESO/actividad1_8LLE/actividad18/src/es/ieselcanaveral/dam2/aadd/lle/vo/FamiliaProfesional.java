package es.ieselcanaveral.dam2.aadd.lle.vo;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;

public class FamiliaProfesional implements Serializable{
	private static final long serialVersionUID = 1533157230501370953L;
	
	@CsvBindByName(column = "codigo_familia", required = true)
	private String codigoFamilia;
	
	@CsvBindByName(column = "nombre_familia", required = true)
	private String nombreFamilia;
	

	public String getCodigoFamilia() {
		return codigoFamilia;
	}


	public void setCodigoFamilia(String codigoFamilia) {
		this.codigoFamilia = codigoFamilia;
	}


	public String getNombreFamilia() {
		return nombreFamilia;
	}


	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}


	@Override
	public String toString() {
		return "FamiliaProfesional [codigoFamilia=" + codigoFamilia + ", nombreFamilia=" + nombreFamilia + "]\n";
	}

}

