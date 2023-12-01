package es.iescanaveral.dam2.aadd.geaz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class GestorFicheroFrases {
	  public static void main(String[] args) {
		    String pathOrigen = "/home/dam2aadd/eclipse-workspace/Actividad12/frases.txt";
		    String pathDestino = "/home/dam2aadd/eclipse-workspace/Actividad12/frases_filtradas.txt";
		    fileFiltering(pathOrigen, pathDestino);
		  }

		  private static void fileFiltering(String origen, String destino) {

		    BufferedReader br = null;
		    String linea = "";
		    
		    if (existAndCanRW(new File(origen)) != false) {
		      try {
		        br = new BufferedReader(new FileReader(origen));
		        linea = br.readLine();
		        while (linea != null) {
		          if (linea.startsWith("2") || linea.contains("Monroe") || linea.contains("Davis")) {
		            saveInNewFile(formatingLine(linea), destino);
		          }
		          linea = br.readLine();
		        }
		      } catch (Exception e) {
		        System.err.println("error en FileFilter() >>> " + e.getMessage());
		      } finally {
		        try {
		          br.close();
		        } catch (Exception e) {
		          // TODO: handle exception
		        }
		      }
		    }
		  }

		  private static void saveInNewFile(String linea, String destino) throws IOException {
		    System.out.println("saving line ...");
		    BufferedWriter bw = null;
		    try {
		      bw = new BufferedWriter(new FileWriter(destino, true));
		      bw.write(linea);
		      bw.newLine();
		    } catch (Exception e) {
		      System.err.println(e.getMessage());
		    } finally {
		      System.out.println("saved.");
		      bw.close();
		    }
		  }

		  
		  private static String formatingLine(String linea){
		    System.out.println("formating this line .... ");
		    String splited [] = linea.split("\\|");
		    String newLine = "\"" + splited[1].trim() + "\" -" + splited[2];
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
