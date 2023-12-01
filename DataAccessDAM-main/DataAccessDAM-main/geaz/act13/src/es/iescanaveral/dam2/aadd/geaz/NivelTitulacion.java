package es.iescanaveral.dam2.aadd.geaz;

import java.io.Serializable;

public class NivelTitulacion implements Serializable{
	
	
	
	private String codigoNivel, nombreNivel;

	
	
	public NivelTitulacion(String codigoNivel, String nombreNivel) {
		super();
		this.codigoNivel = codigoNivel;
		this.nombreNivel = nombreNivel;
	}
	
	@Override
	public String toString() {
		return "NivelTitulacion [codigoNivel=" + codigoNivel + ", nombreNivel=" + nombreNivel + "]";
	}



	public String getCodigoNivel() {
		return codigoNivel;
	}

	public void setCodigoNivel(String codigoNivel) {
		this.codigoNivel = codigoNivel;
	}

	public String getNombreNivel() {
		return nombreNivel;
	}

	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}
}
