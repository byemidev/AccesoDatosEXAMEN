package es.ieselcanaveral.dam2.aadd.lle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import es.ieselcanaveral.dam2.aadd.lle.trabajo.TitulacionCSV;
import es.ieselcanaveral.dam2.aadd.lle.utilidades.GestorConfiguracion;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
    
    public void crearInformeModulosPrograma() throws IOException {
        try {
            // Crear un nuevo documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document newDocument = builder.newDocument();

            // Crear el elemento raíz
            Element rootElement = newDocument.createElement("informacion-modulos");

            // Obtener la información de los módulos que empiezan por "Programa"
            NodeList moduloNodes = document.getElementsByTagName("modulo");
            for (int i = 0; i < moduloNodes.getLength(); i++) {
                Element modulo = (Element) moduloNodes.item(i);
                String titulo = modulo.getElementsByTagName("titulo").item(0).getTextContent();
                if (titulo.startsWith("Programa")) {
                    // Crear un nuevo elemento de módulo en el nuevo documento
                    Element newModulo = newDocument.createElement("modulo");
                    newModulo.setAttribute("id", modulo.getAttribute("id"));
                    newModulo.setAttribute("ref", modulo.getAttribute("ref"));

                    // Añadir el título y las horas
                    Element newTitulo = newDocument.createElement("titulo");
                    newTitulo.setTextContent(titulo);
                    newModulo.appendChild(newTitulo);

                    Element newHoras = newDocument.createElement("numerohoras");
                    newHoras.setTextContent(modulo.getElementsByTagName("numerohoras").item(0).getTextContent());
                    newModulo.appendChild(newHoras);

                    rootElement.appendChild(newModulo);
                }
            }

            newDocument.appendChild(rootElement);
         // Obtener la ruta y el nombre del archivo desde la configuración
            String rutaEscritura = GestorConfiguracion.getInfoConfiguracion("ruta.xml.escritura");
            String nombreArchivo = GestorConfiguracion.getInfoConfiguracion("nombre.xml.escritura");

            // Crear el archivo en la ruta especificada
            File outputFile = new File(rutaEscritura, nombreArchivo);
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(new DOMSource(newDocument), new StreamResult(outputFile));

            // Verificar si el archivo se creó correctamente
            if (outputFile.exists() && outputFile.length() > 0) {
                System.out.println("El fichero " + nombreArchivo + " ha sido creado correctamente en la ruta: " + rutaEscritura);
            } else {
                System.err.println("Error al crear el archivo.");
            }
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
    public static void crearFicheroInformacionXML() throws IOException {
        try {
            // Cargar la configuración desde el archivo de propiedades
            Properties properties = new Properties();
            properties.load(new FileInputStream("config/configuracion.properties"));

            // Obtener la ruta y el nombre del archivo XML desde la configuración
            String rutaEscritura = properties.getProperty("ruta.xml.informacion.titulaciones.escritura");
            String nombreArchivo = properties.getProperty("nombre.xml.informacion.titulaciones.escritura");

            // Combinar la ruta y el nombre para obtener la ruta completa del archivo XML
            String rutaXML = rutaEscritura + File.separator + nombreArchivo;

            // Crear una lista de objetos TitulacionCSV con datos reales
            List<TitulacionCSV> titulaciones = new ArrayList<>();
            TitulacionCSV titulacion1 = new TitulacionCSV();
            titulacion1.setCodigoTitulacion("IFC01");
            titulacion1.setNombreTitulacion("Título Profesional Básico en Informática de Oficina");
            titulacion1.setNumeroHoras(2000);
            titulacion1.setCodigoFamiliaProfesional("IFC");
            titulacion1.setCodigoNivelTitulacion("CFGB");
            
            // Asigna valores a otras propiedades de titulacion1

            TitulacionCSV titulacion2 = new TitulacionCSV();
            titulacion2.setCodigoTitulacion("IFC02");
            titulacion2.setNombreTitulacion("ítulo Profesional Básico en Informática y Comunicaciones");
            titulacion2.setNumeroHoras(2000);
            titulacion2.setCodigoFamiliaProfesional("IFC");
            titulacion2.setCodigoNivelTitulacion("CFGB");
            
            TitulacionCSV titulacion3 = new TitulacionCSV();
            titulacion3.setCodigoTitulacion("IFC03");
            titulacion3.setNombreTitulacion("Técnico en Sistemas Microinformáticos y Redes");
            titulacion3.setNumeroHoras(2000);
            titulacion3.setCodigoFamiliaProfesional("IFC");
            titulacion3.setCodigoNivelTitulacion("CFGM");
            
            TitulacionCSV titulacion4 = new TitulacionCSV();
            titulacion4.setCodigoTitulacion("IFC04");
            titulacion4.setNombreTitulacion("Técnico Superior en Administración de Sistemas Informáticos en Red");
            titulacion4.setNumeroHoras(2000);
            titulacion4.setCodigoFamiliaProfesional("IFC");
            titulacion4.setCodigoNivelTitulacion("CFGS");
            
            TitulacionCSV titulacion5 = new TitulacionCSV();
            titulacion5.setCodigoTitulacion("IFC05");
            titulacion5.setNombreTitulacion("Desarrollo de Aplicaciones Multiplataforma");
            titulacion5.setNumeroHoras(2000);
            titulacion5.setCodigoFamiliaProfesional("IFC");
            titulacion5.setCodigoNivelTitulacion("CFGS");
            
            TitulacionCSV titulacion6 = new TitulacionCSV();
            titulacion6.setCodigoTitulacion("IFC06");
            titulacion6.setNombreTitulacion("Desarrollo de Aplicaciones Web");
            titulacion6.setNumeroHoras(2000);
            titulacion6.setCodigoFamiliaProfesional("IFC");
            titulacion6.setCodigoNivelTitulacion("CFGS");
            
            TitulacionCSV titulacion7 = new TitulacionCSV();
            titulacion7.setCodigoTitulacion("IFC07");
            titulacion7.setNombreTitulacion("Curso de Especialización en Inteligencia Artificial y Big Data (Acceso GS)");
            titulacion7.setNumeroHoras(400);
            titulacion7.setCodigoFamiliaProfesional("IFC");
            titulacion7.setCodigoNivelTitulacion("CE");
            
            TitulacionCSV titulacion8 = new TitulacionCSV();
            titulacion8.setCodigoTitulacion("IFC08");
            titulacion8.setNombreTitulacion("Curso de Especialización en Ciberseguridad en Entornos de las Tecnologías de la Información (Acceso GS)");
            titulacion8.setNumeroHoras(400);
            titulacion8.setCodigoFamiliaProfesional("IFC");
            titulacion8.setCodigoNivelTitulacion("CE");
            
            TitulacionCSV titulacion9 = new TitulacionCSV();
            titulacion9.setCodigoTitulacion("IFC09");
            titulacion9.setNombreTitulacion("Curso de Especialización en Desarrollo de videojuegos y realidad virtual (Acceso GS)");
            titulacion9.setNumeroHoras(400);
            titulacion9.setCodigoFamiliaProfesional("IFC");
            titulacion9.setCodigoNivelTitulacion("CE");
            
            TitulacionCSV titulacion10 = new TitulacionCSV();
            titulacion10.setCodigoTitulacion("SAN01");
            titulacion10.setNombreTitulacion("Técnico Superior en Radioterapia y Dosimetría");
            titulacion10.setNumeroHoras(2000);
            titulacion10.setCodigoFamiliaProfesional("IFC");
            titulacion10.setCodigoNivelTitulacion("CFGM");
            
            TitulacionCSV titulacion11 = new TitulacionCSV();
            titulacion11.setCodigoTitulacion("SAN02");
            titulacion11.setNombreTitulacion("Técnico en Farmacia y Parafarmacia");
            titulacion11.setNumeroHoras(2000);
            titulacion11.setCodigoFamiliaProfesional("SAN");
            titulacion11.setCodigoNivelTitulacion("CFGS");


            // Agregar los objetos TitulacionCSV a la lista
            titulaciones.add(titulacion1);
            titulaciones.add(titulacion2);
            titulaciones.add(titulacion3);
            titulaciones.add(titulacion4);
            titulaciones.add(titulacion5);
            titulaciones.add(titulacion6);
            titulaciones.add(titulacion7);
            titulaciones.add(titulacion8);
            titulaciones.add(titulacion9);
            titulaciones.add(titulacion10);
            titulaciones.add(titulacion11);
            // Crear un objeto XmlMapper
            XmlMapper xmlMapper = new XmlMapper();

            // Configurar el mapper para que genere XML legible
            xmlMapper.enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION);
            xmlMapper.setDefaultPrettyPrinter(new DefaultXmlPrettyPrinter());

            // Convertir la lista de objetos TitulacionCSV a formato XML
            String xmlData = xmlMapper.writeValueAsString(titulaciones);

            // Guardar el XML en el archivo en la ruta especificada
            File xmlFile = new File(rutaXML);
            xmlMapper.writeValue(xmlFile, titulaciones);

            System.out.println("Datos convertidos y guardados en el archivo XML: " + rutaXML);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
