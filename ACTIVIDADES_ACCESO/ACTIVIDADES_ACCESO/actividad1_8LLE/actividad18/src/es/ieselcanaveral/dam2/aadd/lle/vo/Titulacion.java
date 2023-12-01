package es.ieselcanaveral.dam2.aadd.lle.vo;


import java.io.Serializable;

public class Titulacion implements Serializable{
	private static final long serialVersionUID = -3419631810357507044L;
	private String codigoTitulacion;
	private String nombreTitulacion;
	private int numeroHoras;
	private FamiliaProfesional familiaProfesional;
	private NivelTitulacion nivelTitulacion;
	

	public String getCodigoTitulacion() {
		return codigoTitulacion;
	}


	public void setCodigoTitulacion(String codigoTitulacion) {
		this.codigoTitulacion = codigoTitulacion;
	}


	public String getNombreTitulacion() {
		return nombreTitulacion;
	}


	public void setNombreTitulacion(String nombreTitulacion) {
		this.nombreTitulacion = nombreTitulacion;
	}


	public int getNumeroHoras() {
		return numeroHoras;
	}


	public void setNumeroHoras(int numeroHoras) {
		this.numeroHoras = numeroHoras;
	}


	public FamiliaProfesional getFamiliaProfesional() {
		return familiaProfesional;
	}


	public void setFamiliaProfesional(FamiliaProfesional familiaProfesional) {
		this.familiaProfesional = familiaProfesional;
	}


	public NivelTitulacion getNivelTitulacion() {
		return nivelTitulacion;
	}


	public void setNivelTitulacion(NivelTitulacion nivelTitulacion) {
		this.nivelTitulacion = nivelTitulacion;
	}


	@Override
	public String toString() {
		return "Titulacion [codigoTitulacion=" + codigoTitulacion + ", nombreTitulacion=" + nombreTitulacion
				+ ", numeroHoras=" + numeroHoras + ", familiaProfesional=" + familiaProfesional + ", nivelTitulacion="
				+ nivelTitulacion + "]";
	}
}
