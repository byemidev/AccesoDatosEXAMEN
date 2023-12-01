package es.iescanaveral.dam2.aadd.geaz;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorFicheros {

	protected static final String pathOrigen_familiaprofesional = "/home/dam2aadd/eclipse-workspace/DataAccessDAM/geaz/act15/familia_profesional.csv";
	protected static final String pathOrigen_titulaciones = "/home/dam2aadd/eclipse-workspace/DataAccessDAM/geaz/act15/informacion_titulaciones.txt";

	public static void main(String[] args) {
		for(Titulacion titu : getListaTitulaciones()) {
			System.out.println(titu);
		}
		
	}

	
	public static List<Titulacion> getListaTitulaciones(){
		List<Titulacion> titulacionesIT = new ArrayList<Titulacion>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(pathOrigen_titulaciones));
			String ifc = getFamiliaProfesional("IFC").getCodigoFamilia();
			String linea = 	null;
			int counter = 0;
			while((linea = br.readLine()) != null){
				if(counter < 3  && linea.contains(ifc)){
					String nomFamilia = linea.split("\\,")[1].replace("'", "");
					System.out.println("Las siguientes titulaciones pertenecen a:" + nomFamilia);
				}else if (counter > 3){
					String codTitu = linea.split("\\,")[0].replace("'", "");
					String nomTitu = linea.split("\\,")[1].replace("'", "");
					String horasTitu = linea.split("\\,")[2].replace("'", "");
					String codFamilia = linea.split("\\,")[3].replace("'", "");
					String nvlTitu = linea.split("\\,")[4].replace("'", "");
					titulacionesIT.add(new Titulacion(codTitu.trim(), nomTitu.trim(), Integer.parseInt(horasTitu.trim()), codFamilia.trim(), nvlTitu.trim()));
					
				}
				counter++;
			}
		} catch (IOException e) {
			System.err.println("Error en getTitulaciones()" + e.getMessage());
		}finally {
			try {
				br.close();
			}catch(Exception e ) {
				System.err.println("error cerrando br   " + e.getMessage());
			}
		}
		return titulacionesIT;
	}

	protected static List<FamiliaProfesional> getListaFamiliaProfesional(String pathOrigen) throws IOException {
		// Lectura del fichero familia_profesional.csv con OpenCSV
		Reader reader = Files.newBufferedReader(Paths.get(pathOrigen));
		List<FamiliaProfesional> familias = new CsvToBeanBuilder<FamiliaProfesional>(reader)
				.withType(FamiliaProfesional.class).withIgnoreEmptyLine(true).build().parse();
		for (FamiliaProfesional familia : familias) {
			String[] familiaSplited = familia.getCodigoFamilia().split("\\|");
			familia.setCodigoFamilia(familiaSplited[0]);
			familia.setNombreFamilia(familiaSplited[1]);
		}
		return familias;
	}

	// este metodo usara el metodo getListaFamiliaProfesional() //para obetener un
	// objeto familiaProfesional con cod IFC
	
	protected static FamiliaProfesional getFamiliaProfesional(String codFamiliaProfesional) throws IOException {
		
		List<FamiliaProfesional> familias = getListaFamiliaProfesional(pathOrigen_familiaprofesional);
		int i = 0;
		int index = 0;
		for(FamiliaProfesional f : familias) {
			if(f.getCodigoFamilia().contentEquals(codFamiliaProfesional)) {
				index = i;
			}
			i++;
		}
		return familias.get(index);
	}
	
	
}
