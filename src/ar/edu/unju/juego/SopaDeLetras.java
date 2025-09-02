package ar.edu.unju.juego;
import java.util.Random;

public class SopaDeLetras {
	char[][] sopa = new char[12][12];
	Random rand = new Random();
	String[] palabras = { "CAMELLO", "ELEFANTE", "AGUILA", "CAMALEON", "AVESTRUZ", "COCODRILO", "ANTILOPE", "SERPIENTE", "BUFALO", "COMADREJA"};

	// Todas las 8 direcciones posibles
    int[] x = {1, -1, 0, 0, 1, -1, 1, -1};  // x = cambio en columna
    int[] y = {0, 0, 1, -1, 1, 1, -1, -1};  // y = cambio en fila

    // Método principal: crea la sopa de letras
    public void crearSopaDeLetras() {
        
    	// Inicializamos la matriz con espacios vacios
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                sopa[i][j] = '\0';
            }
        }

        // Bucle para colocar cada palabra
        for (String palabra : palabras) {
            colocarPalabra(palabra);
        }

        // Bucle para llenar los espacios vacíos con letras aleatorias
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (sopa[i][j] == '\0') {
                    sopa[i][j] = (char) ('A' + rand.nextInt(26));
                }
            }
        }
    }

    // Metodo para mostrar la sopa de letras
    public void mostrarSopaDeLetras() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(sopa[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para colocar una palabra en la sopa de letras
    public void colocarPalabra(String palabra) {
        boolean colocada = false;

        while (!colocada) {
        	
        	// Elige de manera aleatoria una de las 8 direcciones posibles
            int direccion = rand.nextInt(8);
            int fila = rand.nextInt(12);
            int columna = rand.nextInt(12);
            int direccionX = x[direccion];
            int direccionY = y[direccion];

            // Verificamos si la palabra cabe y respeta las letras existentes
            if (verificarPosicionPalabra(palabra, fila, columna, direccionX, direccionY)) {
                for (int i = 0; i < palabra.length(); i++) {
                    sopa[fila + i * direccionY][columna + i * direccionX] = palabra.charAt(i);
                }
                colocada = true;
            }
        }
    }

    // Verifica si la palabra puede colocarse en esa posición
    public boolean verificarPosicionPalabra(String palabra, int fila, int columna, int direccionX, int direccionY) {
        for (int i = 0; i < palabra.length(); i++) {
            int f = fila + i * direccionY;
            int c = columna + i * direccionX;

            // Verificamos que no sobrepase los límites de la matriz
            if (f < 0 || f >= 12 || c < 0 || c >= 12)
                return false;

            // Verificamos si se superpone a otra palabra ya colocada, si ese es el caso, entonces solo se permite si coincide la letra
            if (sopa[f][c] != '\0' && sopa[f][c] != palabra.charAt(i))
                return false;
        }
        return true;
    }
}
