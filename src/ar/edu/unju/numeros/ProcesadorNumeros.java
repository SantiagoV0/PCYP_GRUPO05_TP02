package ar.edu.unju.numeros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcesadorNumeros {

    public void procesarArchivo() throws Exception {
        String rutaArchivo = "TP02Numeros.txt";
        
        // lista (ArrayList) para almacenar los numeros
        // crecen automaticamente segun se necesiten
        List<Integer> numerosEncontrados = new ArrayList<>();
        int suma = 0; // suma total de los numero
        
        // patron para buscar numeros usando expresiones regulares
        // -? contempla negativos
        // \\d+ mas de un digito
        Pattern patronNumero = Pattern.compile("-?\\d+");
        
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        
        while ((linea = br.readLine()) != null) {
            // buscador (Matcher) para aplicar la expresion regular a cada linea
            Matcher matcher = patronNumero.matcher(linea);
            
            while (matcher.find()) {
	            // texto que coincide
	            String textoNumero = matcher.group();
	            
	            // conversion a entero
	            int numero = Integer.parseInt(textoNumero);
	            
	            numerosEncontrados.add(numero);
	            
	            suma += numero; 
            }
        }
        br.close();
        
  
        // metodo size() de listas devuelve cantidad de elementos
        System.out.println("a) Cantidad de números: " + numerosEncontrados.size());
        
        System.out.println("b) Listado de números:");
        for (int i = 0; i < numerosEncontrados.size(); i++) {
            int numero = numerosEncontrados.get(i);
            System.out.print(numero + ", ");
        }
        System.out.println();
        
        System.out.println("c) Total de la suma: " + suma);
    }
}