package es.ieselcanaveral.dam2.aadd.lle.vo;


import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;

public class FamiliaProfesional implements Serializable {
	private static final long serialVersionUID = 1L;
	@CsvBindByName (column = "codigo_familia", required = true)// Nombre de la columna en el archivo CSV para realizar el mapeo en familia profesional
	@CsvBindByName (column = "nombre_familia", required = true)// Nombre de la columna en el archivo CSV para realizar el mapeo en familia profesional
	
	//Atributos de tipo String
    private String codigoFamilia;
    private String nombreFamilia;

    // Constructor
    public FamiliaProfesional() {
        this.codigoFamilia = codigoFamilia;
        this.nombreFamilia = nombreFamilia;
    }

  
    // Getter para codigoFamilia
    public String getCodigoFamilia() {
        return codigoFamilia;
    }

    // Getter para nombreFamilia
    public String getNombreFamilia() {
    	return nombreFamilia;
    }

    
    
    // Setter para codigoFamilia
    public void setCodigoFamilia(String codigoFamilia) {
        this.codigoFamilia = codigoFamilia;
    }


    // Setter para nombreFamilia
    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }


    
    @Override
    public String toString() {
    	return "Familia: "+this.codigoFamilia+", "+this.nombreFamilia;
    }
}
