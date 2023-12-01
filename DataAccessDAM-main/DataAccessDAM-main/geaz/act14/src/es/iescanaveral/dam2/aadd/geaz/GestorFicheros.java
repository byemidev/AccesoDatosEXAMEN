package es.iescanaveral.dam2.aadd.geaz;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorFicheros {
	
	public static void main(String[] args) {
		System.out.println("\n\nOUTPUT CAMBIOS CON JAVA.NIO\n\n");
		
		 List<Titulacion> titulaciones = obtenerTitulaciones(); //funcionando
		 for(Titulacion o : titulaciones) { 
			 System.out.println(o); 
			 }
		
		System.out.println("\n\nOUTPUT LISTA DE-SERIALIZAR titulaciones.ser >>>>>>\n\n");
			
		List<Titulacion> listaTituDeserializada;
		try {
			listaTituDeserializada = leerTitulaciones(); //funcionando
			for(Titulacion o : listaTituDeserializada) {
				System.out.println(o);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// Lectura del fichero titulaciones.ser con java.nio
	public static List<Titulacion> leerTitulaciones() {
        List<Titulacion> titulaciones = null;

        try {
            RandomAccessFile aFile = new RandomAccessFile("/home/dam2aadd/eclipse-workspace/geaz/Actividad14/titulaciones.ser", "r");
            FileChannel inChannel = aFile.getChannel();
            long fileSize = inChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
            inChannel.read(buffer);
            buffer.flip();
            byte[] bytes = buffer.array();

            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            List<Titulacion> list = (List<Titulacion>) ois.readObject();
			titulaciones = list;

            ois.close();
            bais.close();
            inChannel.close();
            aFile.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("error en LEER TITULACIONES" + e.getLocalizedMessage());       }

        return titulaciones;
    }

	
	public static List<Titulacion> obtenerTitulaciones() {
        List<Titulacion> titulaciones = new ArrayList<>();

        try {
            // Lectura del fichero informacion_titulaciones.txt con java.nio
            List<String> lineas= Files.readAllLines(Paths.get("/home/dam2aadd/eclipse-workspace/geaz/Actividad14/informacion_titulaciones.txt"));
            int counter = 0;
            for (String linea : lineas) {
            	if(counter >= 4){
            		String[] parts = linea.split(",");
            		Titulacion titulacion = new Titulacion();
            		titulacion.setCodigoTitulacion((parts[0].trim()).replaceAll("\\'", " "));
            		titulacion.setNombreTitulacion((parts[1]).trim().replaceAll("\\'", " "));
            		titulacion.setNumeroHoras(Integer.parseInt((parts[2].trim()).replaceAll("\\'", " ")));
            		
            		FamiliaProfesional familia = new FamiliaProfesional();
            		familia.setCodigoFamilia((parts[3].trim()).replaceAll("\\'", " "));
            		familia.setNombreFamilia((parts[4].trim()).replaceAll("\\'", " "));
            		titulacion.setFamilia(familia.getCodigoFamilia());
            		
            		titulaciones.add(titulacion);
            	}
            	counter++;
            }

            // Lectura del fichero niveltitulacion.csv con OpenCSV
            Reader reader = Files.newBufferedReader(Paths.get("/home/dam2aadd/eclipse-workspace/geaz/Actividad14/niveltitulacion.csv"));
            List<NivelTitulacion> niveles = new CsvToBeanBuilder<NivelTitulacion>(reader)
                    .withType(NivelTitulacion.class)
                    .build()
                    .parse();

            for (Titulacion titulacion : titulaciones) {
                for (NivelTitulacion nivel : niveles) {
                    if (titulacion.getCodigoTitulacion().equals((nivel.getCodigoNivel().trim()).replace("\\'", " "))) {
                        titulacion.setNivel((nivel.getCodigoNivel().trim()).replace("\\'", " "));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return titulaciones;
    }
}
