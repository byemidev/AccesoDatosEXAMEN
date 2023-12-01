package es.iescanaveral.dam2.aadd.geaz;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.BufferedReader;
public class GestorFicheros{
	public static void main(String[] args) {
		
		File fNivelTitu = new File("/home/dam2aadd/eclipse-workspace/geaz/Actividad13/niveltitulacion.csv");
		File fInfoTitulaciones = new File("/home/dam2aadd/eclipse-workspace/geaz/Actividad13/informacion_titulaciones.txt");
		
		List<NivelTitulacion> niveles = new ArrayList<NivelTitulacion>();
		List<Titulacion> titulaciones = new ArrayList<Titulacion>();
		
		try {
			niveles= getListaNvlTitulaciones(fNivelTitu);
			for(NivelTitulacion o : niveles) {
				System.out.println(o);
			}
			
			BufferedReader br = null;
			Titulacion objTitulacion = null;
			String codigoTitulacion, nombreTitulacion, familia, nivel;
			int numeroHoras = 0;
			codigoTitulacion = "";
			nombreTitulacion = ""; 
			numeroHoras = 0;  
			familia = ""; 
			nivel = "";
				
				br = new BufferedReader(new FileReader(fInfoTitulaciones));
				String linea = br.readLine();
				int counter = 1;
				
				while(linea!=null) {
					String[] familiaSplited = linea.split("\\,");
					if(linea.contains("IFC") && counter < 4) {
						familiaSplited[0] = (familiaSplited[0].trim().replace("\'", ""));
						familia = familiaSplited[0];						
					}else if(counter > 4 && linea.contains("CFGS")) {
						String splited[] = linea.split("\\,");
						codigoTitulacion = (splited[0].trim()).replace("\'", " ");
						nombreTitulacion = (splited[1].trim()).replace("\'", " ");
						numeroHoras = Integer.parseInt((splited[2].trim()));
						nivel = (splited[4].trim()).replace("\'", " ");
						objTitulacion = new Titulacion(codigoTitulacion, nombreTitulacion, numeroHoras, familia, nivel);
						titulaciones.add(objTitulacion);
						System.out.println(objTitulacion);
						
					}
					linea = br.readLine();
					counter++;
				}
				br.close();
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		guardarTitulaciones(titulaciones);
	}
	
	private static void guardarTitulaciones(List<Titulacion> titulaciones) {
	    try {//Serializable
	        FileOutputStream fileOut = new FileOutputStream("/home/dam2aadd/eclipse-workspace/geaz/Actividad13/titulaciones.ser");
	        ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(titulaciones);
	        out.close();
	        fileOut.close();
	    } catch (IOException i) {
	        i.printStackTrace();
	    }
	}

	private static  ArrayList<NivelTitulacion> getListaNvlTitulaciones(File fNivelTitu)throws IOException, Exception
	{//funciona
		ArrayList<NivelTitulacion> listaNivelTitu = new ArrayList<NivelTitulacion>();
		BufferedReader br1 = null;
		String codNivel = "";
		String nameNivel = "";
		
		try {
		br1 = new BufferedReader(new FileReader(fNivelTitu));
		String linea = br1.readLine();
		int counter = 1;
		while(linea!=null) {
			if(counter > 1 ) {
				
				String splited [] = linea.split("\\#");
				codNivel = splited[0].trim();
				nameNivel = splited[1].trim();
				listaNivelTitu.add(new NivelTitulacion(codNivel, nameNivel));
			}
			linea = br1.readLine();
			counter++;
		}
			
		}finally {
			br1.close();
		}
		
		return listaNivelTitu;
	}
	
}
