package es.ieselcanaveral.dam2.aadd.geaz;

import java.util.Scanner;

public class AppMain {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Elige una de las siguientes opciones para "
				+ "las consultas de este programa\n"
				+ "\n1- Lista de Paises del continente Americano que empiezan por 'Sa'"
				+ "\n2 - Se añadira un nuevo continente Antartida"
				+ "\n3 - Actualizar el nombre del pais con cod 107 a 'Capital city'"
				+ "\n4 - Se eliminara el continente con codigo 06"
				+ "\n\n *****Si no eliges ninguna de estas opcines el programa terminara");
		
		int opcion = sc.nextInt();
		GestorDB gestor = new GestorDB();
		
		switch (opcion) {
		case 1: 
			gestor.listarPaisesAmericanos();
			break;
		case 2: 
			gestor.addContinenteNuevo();
			break;
		case 3: 
			gestor.actualizarNombrePais();
			break; 
		case 4:
			gestor.eliminarContinente();														
		break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}			
		
	}
}
