package es.ieselcanaveral.dam2.aadd.lle;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            GestorFichero gestor = new GestorFichero();

            // Imprimir nombre del instituto y su tipo
            gestor.imprimirNombreInstitutoYTipo();

            // Imprimir módulos que empiezan por "Programa"
            gestor.imprimirModulosQueEmpiezanPorPrograma();

            // Imprimir módulos que empiezan por "Programa" del curso 1
            gestor.imprimirModulosQueEmpiezanPorProgramaDelCurso1();
            
            // Crear el archivo XML con los módulos de "Programa"
            gestor.crearInformeModulosPrograma();
            
            //Crear informacion_titulaciones.xml con Jackson:
            gestor.crearFicheroInformacionXML();

        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}

