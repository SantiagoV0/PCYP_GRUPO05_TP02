package ar.edu.unju.lineas;

import java.io.BufferedReader;
import java.io.FileReader;

public class ContarLineas {

    public void contarMostrar() throws Exception {
        String rutaArchivo = "TP01Frase.txt"; 

        String lineaMasCorta = null;
        String lineaMasLarga = null;

        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        while ((linea = br.readLine()) != null) {

        	if (!linea.trim().isEmpty()) { // verifica no contar lineas vacias 
	            if (lineaMasCorta == null || linea.length() < lineaMasCorta.length()) {
	                lineaMasCorta = linea;
	            }
	
	            if (lineaMasLarga == null || linea.length() > lineaMasLarga.length()) {
	                lineaMasLarga = linea;
	            }
        	}
        }
        br.close();

        System.out.println("Linea mas corta (" + (lineaMasCorta != null ? lineaMasCorta.length() : 0) + " caracteres):");
        System.out.println(lineaMasCorta);
        System.out.println("\nLinea mas larga (" + (lineaMasLarga != null ? lineaMasLarga.length() : 0) + " caracteres):");
        System.out.println(lineaMasLarga);

    }
}