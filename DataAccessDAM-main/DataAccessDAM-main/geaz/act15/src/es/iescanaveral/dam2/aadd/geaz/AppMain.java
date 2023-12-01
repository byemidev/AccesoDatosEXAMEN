package es.iescanaveral.dam2.aadd.geaz;

import java.io.IOException;
import java.util.List;

public class AppMain {
	public static void main (String args[]) {
		//logica para recoger los dos argumentos del ejercicio B. Act15
		String code = null;
		String name = null;
		
		for(int i = 0; i < args.length;i++) {
			code = args[0];
			name = args[1];
			//Gestorficheros object para ejecutar logica comparar si existe o no la familia profesional 
			GestorFicheros gs = new GestorFicheros();
			try {
				List<FamiliaProfesional> fp = gs.getListaFamiliaProfesional(gs.pathOrigen_familiaprofesional);//cambiar path casa/clase
				for(FamiliaProfesional f : fp) {
					System.out.println("desde AppMain\n" + f );
					//if(fp.contains( new FamiliaProfesional(code,name))== true) {
						//System.out.printf("voy a crear una nueva familia con codigo %d y nombre %d", code, name);
						//TODO metodo para escribir la nueva familia profesiona, y escribirla en el fichero familia_profesional.csv 
					//}
				}
			} catch (IOException e) {
				System.err.println("error en Appmain" + e.getMessage());
			}	
		}//for
	}//main 
}
