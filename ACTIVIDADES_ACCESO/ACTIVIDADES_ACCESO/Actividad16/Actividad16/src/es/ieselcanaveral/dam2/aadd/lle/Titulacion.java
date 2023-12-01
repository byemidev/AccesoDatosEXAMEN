package es.ieselcanaveral.dam2.aadd.lle;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;
import es.ieselcanaveral.dam2.aadd.lle.FamiliaProfesional;
import es.ieselcanaveral.dam2.aadd.lle.NivelTitulacion;

public class Titulacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private String codigoTitulacion;
	
	
	private String nombreTitulacion;
	
	
	private int numeroHoras;
	
	
	 private String codigoFamilia; 
	

	 private String codigoNivel; 
	
	//Tipo "bean"
	private FamiliaProfesional familiaProfesional;
	private NivelTitulacion nivelTitulacion;
	
	//Constructor
	public Titulacion() {
		this.codigoTitulacion = codigoTitulacion;
		this.nombreTitulacion = nombreTitulacion;
	    this.numeroHoras = numeroHoras;
	    this.familiaProfesional = familiaProfesional;
	    this.nivelTitulacion = nivelTitulacion;
		this.codigoFamilia = codigoFamilia;
		this.codigoNivel = codigoNivel;
		
	}
	 // Getter para codigoTitulacion
    public String getCodigoTitulacion() {
        return codigoTitulacion;
    }

    // Setter para codigoTitulacion
    public void setCodigoTitulacion(String codigoTitulacion) {
        this.codigoTitulacion = codigoTitulacion;
    }
    
    
    
    // Getter para nombreTitulacion
    public String getNombreTitulacion() {
        return nombreTitulacion;
    }

    // Setter para nombreTitulacion
    public void setNombreTitulacion(String nombreTitulacion) {
        this.nombreTitulacion = nombreTitulacion;
    }

   
    
    // Getter para numeroHoras
    public int getNumeroHoras() {
        return numeroHoras;
    }

    // Setter para numeroHoras
    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    
   
    // Getter para familia
    public FamiliaProfesional getFamiliaProfesional() {
        return familiaProfesional;
    }

    // Setter para familia
    public void setFamiliaProfesional(FamiliaProfesional familiaProfesional) {
        this.familiaProfesional = familiaProfesional;
    }
    
    
    
    // Getter para nivel
    public NivelTitulacion getNivelTitulacion() {
        return nivelTitulacion;
    }
    // Setter para nivel
    public void setNivelTitulacion(NivelTitulacion nivel) {
        this.nivelTitulacion = nivel;
    }
    
    
    //Getter para codigo familia
    public String getCodigoFamilia() {
        return codigoFamilia;
    }
    //Setter para codigo familia
    public void setCodigoFamilia(String codigoFamilia) {
        this.codigoFamilia = codigoFamilia;
    }

    //Getter para codigo nivel
    public String getCodigoNivel() {
        return codigoNivel;
    }
    //Setter para codigo nivel
    public void setCodigoNivel(String codigoNivel) {
        this.codigoNivel = codigoNivel;
    }
   
    
    @Override
    public String toString() {
    	
    	return "Titulacion: "+this.codigoTitulacion+", "+this.nombreTitulacion+", "+this.numeroHoras+", "+this.familiaProfesional+", "+this.nivelTitulacion;
    }
	
}
