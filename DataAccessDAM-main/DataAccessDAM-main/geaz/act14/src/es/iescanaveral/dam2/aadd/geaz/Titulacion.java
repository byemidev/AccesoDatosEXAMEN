package es.iescanaveral.dam2.aadd.geaz;

import java.io.Serializable;

public class Titulacion implements Serializable{
	
	private static final long serialVersionUID = 8182231761108481461L;
	private String codigoTitulacion, nombreTitulacion, familia, nivel;
	private int numeroHoras;
	
	public Titulacion() {}


	public Titulacion(String codigoTitulacion, String nombreTitulacion, int numeroHoras, String familia, String nivel) {
		this.codigoTitulacion = codigoTitulacion;
		this.nombreTitulacion = nombreTitulacion;
		this.numeroHoras = numeroHoras;
		this.familia = familia;
		this.nivel = nivel;
		}
	
	

	@Override
	public String toString() {
		return "Titulacion [codigoTitulacion=" + codigoTitulacion + ", nombreTitulacion=" + nombreTitulacion
				+ ", numeroHoras=" + numeroHoras + ", familia=" + familia + ", nivel=" + nivel + "]";
	}



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

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
}
