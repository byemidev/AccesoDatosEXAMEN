package es.ieselcanaveral.dam2.aadd.lle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import es.ieselcanaveral.dam2.aadd.lle.utilidades.GestorConfiguracion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class GestorFichero {
    private Document document;

    public GestorFichero() throws IOException, SAXException, ParserConfigurationException {
        // Obtiene la ruta del archivo XML desde el archivo de configuración
        String rutaFichero = GestorConfiguracion.getInfoConfiguracion("ruta.ficheros") + "/" +
                GestorConfiguracion.getInfoConfiguracion("fichero.xml.lectura");

        // Parsea el archivo XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        document = builder.parse(new File(rutaFichero));
    }

    public void imprimirNombreInstitutoYTipo() {
        Element instituto = document.getDocumentElement();
        String nombre = instituto.getAttribute("nombre");
        String tipo = instituto.getAttribute("tipo");
        System.out.println("Nombre del instituto: " + nombre);
        System.out.println("Tipo del instituto: " + tipo);
    }

    public void imprimirModulosQueEmpiezanPorPrograma() {
        NodeList moduloNodes = document.getElementsByTagName("modulo");
        for (int i = 0; i < moduloNodes.getLength(); i++) {
            Element modulo = (Element) moduloNodes.item(i);
            String titulo = modulo.getElementsByTagName("titulo").item(0).getTextContent();
            if (titulo.startsWith("Programa")) {
                String id = modulo.getAttribute("id");
                String ref = modulo.getAttribute("ref");
                String horas = modulo.getElementsByTagName("numerohoras").item(0).getTextContent();
                System.out.println("ID: " + id);
                System.out.println("Referencia: " + ref);
                System.out.println("Horas: " + horas);
                System.out.println("Título: " + titulo);
                System.out.println();
            }
        }
    }

    public void imprimirModulosQueEmpiezanPorProgramaDelCurso1() {
        Element ciclo = (Element) document.getElementsByTagName("ciclo").item(0);
        Element curso = (Element) ciclo.getElementsByTagName("curso").item(0);
        NodeList moduloNodes = curso.getElementsByTagName("modulo");
        for (int i = 0; i < moduloNodes.getLength(); i++) {
            Element modulo = (Element) moduloNodes.item(i);
            String titulo = modulo.getElementsByTagName("titulo").item(0).getTextContent();
            if (titulo.startsWith("Programa")) {
                String id = modulo.getAttribute("id");
                String ref = modulo.getAttribute("ref");
                String horas = modulo.getElementsByTagName("numerohoras").item(0).getTextContent();
                System.out.println("ID: " + id);
                System.out.println("Referencia: " + ref);
                System.out.println("Horas: " + horas);
                System.out.println("Título: " + titulo);
                System.out.println();
            }
        }
    }
}
