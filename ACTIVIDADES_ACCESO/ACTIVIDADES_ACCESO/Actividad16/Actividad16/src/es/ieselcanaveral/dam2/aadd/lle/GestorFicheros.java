package es.ieselcanaveral.dam2.aadd.lle;

import java.io.BufferedReader;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import es.ieselcanaveral.dam2.aadd.lle.NivelTitulacion;
import es.ieselcanaveral.dam2.aadd.lle.FamiliaProfesional;

public class GestorFicheros {
	 // Método privado para obtener la lista de NivelesTitulacion desde niveltitulacion.csv
	//En este caso este método utiliza la librería OpenCSV para leer el archivo "niveltitulacion.csv" 
  public List<NivelTitulacion> getListaNiveles() throws IOException, CsvValidationException {
    	 CSVParser separador = new CSVParserBuilder().withSeparator('#').build();
    	  List<NivelTitulacion> listaNiveles = new ArrayList<>();
    	  try (CSVReader lecturaCSV = new CSVReaderBuilder(new FileReader("/home/dam2aadd/eclipse-workspace/Actividad16/niveltitulacion.csv"))
                  .withCSVParser(separador).build()) {

              String[] partes;
              while ((partes = lecturaCSV.readNext()) != null) {
                  NivelTitulacion nivelTitulacion = new NivelTitulacion();
                  nivelTitulacion.setCodigoNivel(partes[0].trim());
                  nivelTitulacion.setNombreNivel(partes[1].trim());
                  listaNiveles.add(nivelTitulacion);
              }
          }
          return listaNiveles;
    }


    // Método público para obtener la lista de Titulaciones de la familia de Informática y Comunicaciones
  // Método para obtener la lista de Titulaciones a partir de informacion_titulaciones.csv
 
  public List<Titulacion> getListaTitulacionesDesdeCSV() throws IOException, CsvValidationException {
      List<Titulacion> listaTitulaciones = new ArrayList<>();
      List<NivelTitulacion> listaNiveles = getListaNiveles();
      List<FamiliaProfesional> listaFamilias = obtenerFamilia();

      try (CSVReader lecturaCSV = new CSVReader(new FileReader("/home/dam2aadd/eclipse-workspace/Actividad16/informacion_titulaciones.csv"))) {
          CsvToBean<TitulacionCSV> csvToBean = new CsvToBeanBuilder<TitulacionCSV>(lecturaCSV)
              .withType(TitulacionCSV.class)
              .withSeparator(',')
              .withIgnoreLeadingWhiteSpace(true)
              .withSkipLines(1) // Saltar la primera línea (encabezados)
              .build();

          List<TitulacionCSV> titulacionCSVList = csvToBean.parse();

          for (TitulacionCSV titulacionCSV : titulacionCSVList) {
              Titulacion titulacion = new Titulacion();

              // Mapear atributos de TitulacionCSV a Titulacion
              titulacion.setCodigoTitulacion(titulacionCSV.getCodigoTitulacion());
              titulacion.setNombreTitulacion(titulacionCSV.getNombreTitulacion());
              titulacion.setNumeroHoras(titulacionCSV.getNumeroHoras());
              titulacion.setCodigoFamilia(titulacionCSV.getCodigoFamiliaProfesional());
              titulacion.setCodigoNivel(titulacionCSV.getCodigoNivelTitulacion());

              listaTitulaciones.add(titulacion);
          }
      }

      return listaTitulaciones;
  }

    // Método privado para obtener un NivelTitulacion por código
    private NivelTitulacion generarNivelTitulacionPorCodigo(String codigoTitulacion, List<NivelTitulacion> listaNiveles) {
        for (NivelTitulacion nivelTitulacion : listaNiveles) {
            if (nivelTitulacion.getCodigoNivel().equalsIgnoreCase(codigoTitulacion)) {
                return nivelTitulacion;
            }
        }
        return null;
        
    }
    
    
    
    
    
 // Método privado para obtener la lista de FamiliaProfesional desde familia_profesional.csv utilizando las librerias CSV
    List<FamiliaProfesional> obtenerFamilia() throws IOException, CsvValidationException {
        CSVParser separador = new CSVParserBuilder().withSeparator('|').build();
        List<FamiliaProfesional> listaFamilia = new ArrayList<FamiliaProfesional>();

        try (CSVReader lecturaCSV = new CSVReaderBuilder(
                new FileReader("/home/dam2aadd/eclipse-workspace/Actividad16/familia_profesional.csv")).withCSVParser(separador)
                        .build()) {
            String[] partes;

            // Leer y descartar la primera línea (cabecera)
            lecturaCSV.readNext();

            while ((partes = lecturaCSV.readNext()) != null) {
                FamiliaProfesional claseFamiliaProfesional = new FamiliaProfesional();
                if (partes.length >= 2) { // Verificar si hay al menos 2 partes en la línea
                    claseFamiliaProfesional.setCodigoFamilia(partes[0].trim());
                    claseFamiliaProfesional.setNombreFamilia(partes[1].trim());
                    listaFamilia.add(claseFamiliaProfesional);
                }
            }
        }
        return listaFamilia;
    }

    

    
    // Método privado para obtener una FamiliaProfesional por código
    private FamiliaProfesional generarFamiliaPorCodigo(String codigoFamilia, List<FamiliaProfesional> listaFamilias) {
        for (FamiliaProfesional familia : listaFamilias) {
            if (familia.getCodigoFamilia().equalsIgnoreCase(codigoFamilia)) {
                return familia;
            }
        }
        return null;
    }
    
    // Método para verificar si el código de familia existe en el archivo
    public boolean codigoFamiliaExiste(String codigoFamilia) throws IOException, CsvValidationException {
        try (CSVReader lecturaCSV = new CSVReaderBuilder(new FileReader("/home/dam2aadd/eclipse-workspace/Actividad16/familia_profesional.csv"))
                .withCSVParser(new CSVParserBuilder().withSeparator('|').build())
                .build()) {
            String[] partes;
            while ((partes = lecturaCSV.readNext()) != null) {
                if (partes.length >= 1 && partes[0].trim().equalsIgnoreCase(codigoFamilia)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método para actualizar el nombre de familia en el archivo
    public void actualizarNombreFamilia(String codigoFamilia, String nuevoNombre) throws IOException, CsvValidationException {
        List<String[]> lineas = new ArrayList<>();

        try (CSVReader lecturaCSV = new CSVReaderBuilder(new FileReader("/home/dam2aadd/eclipse-workspace/Actividad16/familia_profesional.csv"))
                .withCSVParser(new CSVParserBuilder().withSeparator('|').build())
                .build()) {
            String[] partes;
            while ((partes = lecturaCSV.readNext()) != null) {
                if (partes.length >= 1 && partes[0].trim().equalsIgnoreCase(codigoFamilia)) {
                    partes[1] = nuevoNombre;
                }
                lineas.add(partes);
            }
        }

        try (CSVWriter escrituraCSV = new CSVWriter(new FileWriter("/home/dam2aadd/eclipse-workspace/Actividad16/familia_profesional.csv"))) {
            for (String[] linea : lineas) {
                escrituraCSV.writeNext(linea);
            }
        }
    }

    // Método para borrar la familia del archivo
    public void borrarFamilia(String codigoFamilia) throws IOException {
        List<String[]> lineas = new ArrayList<>();

        try (CSVReader lecturaCSV = new CSVReader(new FileReader("/home/dam2aadd/eclipse-workspace/Actividad16/familia_profesional.csv"))) {
            String[] partes;
            try {
				while ((partes = lecturaCSV.readNext()) != null) {
				    if (partes.length >= 1 && !partes[0].trim().equalsIgnoreCase(codigoFamilia)) {
				        lineas.add(partes);
				    }
				}
			} catch (CsvValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        try (CSVWriter escrituraCSV = new CSVWriter(new FileWriter("/home/dam2aadd/eclipse-workspace/Actividad16/familia_profesional.csv"))) {
            for (String[] linea : lineas) {
                escrituraCSV.writeNext(linea);
            }
        }
    }

    // Método para agregar las familias al archivo.
    private static void agregarFamiliaAlArchivo(String codigoFamilia, String nombreFamilia) {
        try {
            FileWriter fileWriter = new FileWriter("/home/dam2aadd/eclipse-workspace/Actividad15/familia_profesional.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println(codigoFamilia + "|" + nombreFamilia);

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
