package es.ieselcanaveral.dam2.aadd.lle.trabajo;


import com.opencsv.bean.CsvBindByName;

public class TitulacionCSV{
	 @CsvBindByName(column = "codigo_titulacion", required = true)
	 private String codigoTitulacion;
	 
	 @CsvBindByName(column = "nombre_titulacion", required = true)
	 private String nombreTitulacion;
	 
	 @CsvBindByName(column = "numero_horas", required = true)
	 private int numeroHoras;
	 
	 @CsvBindByName(column = "codigo_familia", required = true)
	 private String codigoFamiliaProfesional;
	 
	 @CsvBindByName(column = "codigo_nivel", required = true)
	 private String codigoNivelTitulacion;

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

	public String getCodigoFamiliaProfesional() {
		return codigoFamiliaProfesional;
	}

	public void setCodigoFamiliaProfesional(String codigoFamiliaProfesional) {
		this.codigoFamiliaProfesional = codigoFamiliaProfesional;
	}

	public String getCodigoNivelTitulacion() {
		return codigoNivelTitulacion;
	}

	public void setCodigoNivelTitulacion(String codigoNivelTitulacion) {
		this.codigoNivelTitulacion = codigoNivelTitulacion;
	}

	@Override
	public String toString() {
		return "TitulacionCSV [codigoTitulacion=" + codigoTitulacion + ", nombreTitulacion=" + nombreTitulacion
				+ ", numeroHoras=" + numeroHoras + ", codigoFamiliaProfesional=" + codigoFamiliaProfesional
				+ ", codigoNivelTitulacion=" + codigoNivelTitulacion + "]";
	}
	 
	 
}
