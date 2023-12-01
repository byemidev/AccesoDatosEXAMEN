package es.ieselcanaveral.dam2.aadd.lle.vo;


import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;

public class NivelTitulacion implements Serializable{
	private static final long serialVersionUID = 2693878549729382685L;
	 @CsvBindByName(column = "codigo_nivel", required = true)
	private String codigoNivel;
	 
	 @CsvBindByName(column = "nombre_nivel", required = true)
	private String nombreNivel;
	
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

	@Override
	public String toString() {
		return "NivelTitulacion [codigoNivel=" + codigoNivel + ", nombreNivel=" + nombreNivel + "]";
	}

}
