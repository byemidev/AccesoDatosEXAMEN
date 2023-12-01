package es.iescanaveral.dam2.aadd.geaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GestorFicheroNivelTitulacion {
	  public static void main(String[] args) {
		     String pathOrigen = "/home/dam2aadd/eclipse-workspace/Actividad12/niveltitulacion.csv";
		     readingCSV(pathOrigen);
		  }

		  private static void readingCSV(String origen ){
		  
		    BufferedReader br = null;
		     String linea = "";
		     String columns [] = null;
		     
		     if (existAndCanRW(new File(origen)) != false) {
		       try {
		         br = new BufferedReader(new FileReader(origen));
		         linea = br.readLine();
		         int counter = 1;
		         while (linea != null) {
			    	 if(counter == 1) {
			    		columns = extractColumns(linea);
			    		System.out.println("label 1 " + columns[0] + "label 2 " + columns[1]);
			    		counter++;
			    	 }
			    	 linea = br.readLine();
			    	 linea = formatingLine(linea);
			    	 System.out.println(linea);
			    	 
		         }
		       } catch (Exception e) {
		         System.err.println("error en lectura csv>>> " + e.getMessage());
		       } finally {
		         try {
		           br.close();
		         } catch (Exception e) {
		           // TODO: handle exception
		         }
		       }
		     }
		  }   

		private static String[] extractColumns(String linea){
			String splited [] = linea.split("\\#");
			for(int i = 0; i < splited.length; i++) {
				splited[i] = splited[i].trim();
				System.out.println(splited[i]);
			}
			return splited;
		}


		  private static String formatingLine(String linea) {
		    System.out.println("formating this line .... ");
		    String splited[] = linea.split("\\#");
		    String newLine = "\"" + splited[0].trim() + "\"," + "\"" + splited[1]+ "\"";
		    return newLine;
		  }

		  private static Boolean existAndCanRW(File fichero) {
		    if (fichero.exists() && fichero.canRead() && fichero.canWrite()) {
		      System.out.println("The file exists. Can be read and modified/write");
		      return true;
		    } else {
		      return false;
		    }
		  }
}
