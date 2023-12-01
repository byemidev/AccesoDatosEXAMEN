package es.ieselcanaveral.dam2.aadd.lle.trabajo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "titulacion") // Nombre del elemento raíz en el XML
public class TitulacionCSV {
    @JacksonXmlProperty(localName = "codigo_titulacion") // Nombre de la propiedad en el XML
    private String codigoTitulacion;

    @JacksonXmlProperty(localName = "nombre_titulacion")
    private String nombreTitulacion;

    @JacksonXmlProperty(localName = "numero_horas")
    private int numeroHoras;

    @JacksonXmlProperty(localName = "codigo_familia")
    private String codigoFamiliaProfesional;

    @JacksonXmlProperty(localName = "codigo_nivel")
    private String codigoNivelTitulacion;

    // Getters y setters
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
