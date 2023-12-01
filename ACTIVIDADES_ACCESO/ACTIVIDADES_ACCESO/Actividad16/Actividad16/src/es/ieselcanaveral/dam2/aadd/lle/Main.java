package es.ieselcanaveral.dam2.aadd.lle;
import java.io.*;

import java.util.*;
import com.opencsv.exceptions.CsvValidationException;
import es.ieselcanaveral.dam2.aadd.lle.GestorFicheros;


public class Main {

	public static void main(String[] args) throws NumberFormatException, CsvValidationException, ClassNotFoundException, IOException {
		 GestorFicheros gestorFicheros = new GestorFicheros();

	        try {
	            // Obtener la lista de titulaciones
	            List<Titulacion> listaTitulaciones = gestorFicheros.getListaTitulacionesDesdeCSV();

	            // Imprimir la lista de titulaciones de Informática y Comunicaciones
	            System.out.println("TITULACIONES DE INFORMÁTICA Y COMUNICACIONES:");
	            for (Titulacion titulacion : listaTitulaciones) {
	                System.out.println(titulacion);
	            }

	            if (args.length < 2) {
	                System.out.println("Debes proporcionar el código de familia y el nombre de familia como argumentos.");
	                return;
	            }

	            String codigoFamilia = args[0];
	            String nombreFamilia = args[1];

	            // Verificar si el código de familia ya existe en el archivo CSV
	            if (codigoFamiliaExiste(codigoFamilia)) {
	                System.out.println("El código de familia profesional ya existe.");
	            } else {
	                // Si el código de familia no existe, agregarlo al archivo CSV
	                agregarFamiliaAlArchivo(codigoFamilia, nombreFamilia);
	                System.out.println("Familia profesional agregada con éxito.");
	            }
	        } catch (IOException | CsvValidationException e) {
	            e.printStackTrace();
	        }
	        
	        
	        if (args.length != 3) {
	            System.out.println("Debes proporcionar tres argumentos: código de familia, nombre de familia y acción (A o B).");
	            return;
	        }

	        String codigoFamilia = args[0];
	        String nombreFamilia = args[1];
	        String accion = args[2];

	        if (!accion.equals("A") && !accion.equals("B")) {
	            System.out.println("Parámetro de acción incorrecto. Debe tomar los valores 'A' o 'B'.");
	            return;
	        }


	        try {
	            if (accion.equals("A")) {
	                if (gestorFicheros.codigoFamiliaExiste(codigoFamilia)) {
	                    gestorFicheros.actualizarNombreFamilia(codigoFamilia, nombreFamilia);
	                    System.out.println("Nombre de familia actualizado con éxito.");
	                } else {
	                    System.out.println("El código de familia no existe en el archivo.");
	                }
	            } else if (accion.equals("B")) {
	                if (gestorFicheros.codigoFamiliaExiste(codigoFamilia)) {
	                    gestorFicheros.borrarFamilia(codigoFamilia);
	                    System.out.println("Familia profesional borrada con éxito.");
	                } else {
	                    System.out.println("El código de familia no existe en el archivo.");
	                }
	            }
	            else {
	                // Si el código de familia no existe, agregarlo al archivo CSV
	                agregarFamiliaAlArchivo(codigoFamilia, nombreFamilia);
	                System.out.println("Familia profesional agregada con éxito.");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }




    // Método para poder deserializar Titulacion
    public static void deserealizarTitulacion() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("/home/dam2aadd/eclipse-workspace/Actividad14/titulaciones.ser"))) {

            List<Titulacion> datosDeserealizados = (List<Titulacion>) inputStream.readObject();
            System.out.println("Las Titulaciones se han deserializado correctamente");
            for (Titulacion t : datosDeserealizados) {
                System.out.println(t);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para el código de familia si existe.
    private static boolean codigoFamiliaExiste(String codigoFamilia) {
        try {
            File archivoCSV = new File("/home/dam2aadd/eclipse-workspace/Actividad15/familia_profesional.csv");
            FileReader fileReader = new FileReader(archivoCSV);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes.length >= 1 && partes[0].equalsIgnoreCase(codigoFamilia)) {
                    return true;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
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
