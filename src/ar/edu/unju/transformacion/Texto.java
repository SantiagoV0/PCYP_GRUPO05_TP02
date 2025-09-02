package ar.edu.unju.transformacion;

//Leer y escribir archivos
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Texto {
    //throws Exception para simplificar el manejo de errores de E/S, ya que se esta usando la lectura y escritura de archivos
    public void procesarTexto() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("TP01Frase.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Punto02.txt"));

        StringBuilder lineaModificada = new StringBuilder();
        int caracter;

        while ((caracter = br.read()) != -1) {
            char letra = (char) caracter;

            // Transformar vocales, se le suma 20 a su valor ASCII
            if ("aeiouAEIOUáéíóúÁÉÍÓÚ".indexOf(letra) != -1) {
                letra = (char) (letra + 20);
            }

            lineaModificada.append(letra);

            // Si se detecta salto de línea, escribe la línea modificada con fecha
            if (letra == '\n') {
                String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                bw.write(lineaModificada.toString().trim() + " [" + fechaHora + "]");
                bw.newLine();
                lineaModificada.setLength(0); // limpiar para la próxima línea
            }
        }

        // Si el archivo no termina con \n, escribir la última línea
        if (lineaModificada.length() > 0) {
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            bw.write(lineaModificada.toString().trim() + " [" + fechaHora + "]");
            bw.newLine();
        }

        br.close();
        bw.close();
    }

}
