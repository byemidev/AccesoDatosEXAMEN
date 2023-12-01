package es.ieselcanaveral.dam2.aadd.lle.trabajo;


import com.opencsv.bean.CsvBindByName;

public class TitulacionCSV{
	 @CsvBindByName(column = "codigo_titulacion", required = true)// Nombre de la columna en el archivo CSV para realizar el mapeo
	 private String codigoTitulacion;
	 
	 @CsvBindByName(column = "nombre_titulacion", required = true)// Nombre de la columna en el archivo CSV para realizar el mapeo
	 private String nombreTitulacion;
	 
	 @CsvBindByName(column = "numero_horas", required = true) // Nombre de la columna en el archivo CSV para realizar el mapeo
	 private int numeroHoras;
	 
	 @CsvBindByName(column = "codigo_familia", required = true)// Nombre de la columna en el archivo CSV para realizar el mapeo
	 private String codigoFamiliaProfesional; // Nuevo atributo del codigo familia
	 
	 @CsvBindByName(column = "codigo_nivel", required = true)// Nombre de la columna en el archivo CSV para realizar el mapeo
	 private String codigoNivel;// Nuevo atributo de codigo nivel

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
		return codigoNivel;
	}

	public void setCodigoNivelTitulacion(String codigoNivelTitulacion) {
		this.codigoNivel= codigoNivelTitulacion;
	}

	@Override
	public String toString() {
		return "TitulacionCSV [codigoTitulacion=" + codigoTitulacion + ", nombreTitulacion=" + nombreTitulacion
				+ ", numeroHoras=" + numeroHoras + ", codigoFamiliaProfesional=" + codigoFamiliaProfesional
				+ ", codigoNivelTitulacion=" + codigoNivel + "]";
	}
	 
	 
}