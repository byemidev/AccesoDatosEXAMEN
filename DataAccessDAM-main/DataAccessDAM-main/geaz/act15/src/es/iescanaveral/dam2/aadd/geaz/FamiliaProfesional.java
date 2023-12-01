package es.iescanaveral.dam2.aadd.geaz;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByPosition;

public class FamiliaProfesional implements Serializable{

	@CsvBindByPosition(position=0)
	private String codigoFamilia; 
	
	@CsvBindByPosition(position=1)
	private String nombreFamilia;
	
	
	
	@Override
	public String toString() {
		return "FamiliaProfesional [codigoFamilia=" + codigoFamilia + ", nombreFamilia=" + nombreFamilia + "]";
	}
	public FamiliaProfesional() {
		super();
	}

	public FamiliaProfesional(String codFamilia) {
		super();
		this.codigoFamilia = codFamilia;
	}

	public FamiliaProfesional(String codigoFamilia, String nombreFamilia) {
		super();
		this.codigoFamilia = codigoFamilia;
		this.nombreFamilia = nombreFamilia;
	}


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
}
