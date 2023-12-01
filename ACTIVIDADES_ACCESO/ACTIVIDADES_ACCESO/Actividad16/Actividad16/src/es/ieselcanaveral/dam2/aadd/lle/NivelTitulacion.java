package es.ieselcanaveral.dam2.aadd.lle;


import java.io.Serializable;




import com.opencsv.bean.CsvBindByName;
public class NivelTitulacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Atributos de tipo String
	
	@CsvBindByName(column = "CodigoNivel") // Nombre de la columna en el archivo CSV para realizar el mapeo
	private String codigoNivel;
	@CsvBindByName(column = "NombreNivel") // Nombre de la columna en el archivo CSV para realizar el mapeo
    private String nombreNivel;

    // Constructor
    public NivelTitulacion() {
        this.codigoNivel = codigoNivel;
        this.nombreNivel = nombreNivel;
    }

    
    // Getter para codigoNivel
    public String getCodigoNivel() {
        return codigoNivel;
    }

    // Setter para codigoNivel
    public void setCodigoNivel(String codigoNivel) {
        this.codigoNivel = codigoNivel;
    }

    
    
    // Getter para nombreNivel
    public String getNombreNivel() {
        return nombreNivel;
    }

    // Setter para nombreNivel
    public void setNombreNivel(String nombreFamilia) {
        this.nombreNivel = nombreFamilia;
    }
    
    
    
    
    @Override
    public String toString() {
    	
    	return "Nivel: "+this.codigoNivel+", "+this.nombreNivel;
    }
}
