package es.iescanaveral.dam2.aadd.geaz;

import java.io.Serializable;

public class FamiliaProfesional implements Serializable{
	private String codigoFamilia, nombreFamilia;
	
	public FamiliaProfesional() {
		
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
