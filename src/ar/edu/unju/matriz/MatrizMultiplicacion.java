package ar.edu.unju.matriz;

public class MatrizMultiplicacion {
	int[][] matriz;

	// Constructor para crear el objeto matriz
    public MatrizMultiplicacion() {
        matriz = new int[10][10]; // matriz de enteros 10x10
    }

    // Metodo para completar la fila de la matriz
    public boolean completarFila(int numero) {
        if (numero < 1 || numero > 10) {
            System.out.println("Error: Número fuera de rango (1-10)");
            return false;
        }

        int fila = numero - 1;
        for (int j = 0; j < 10; j++) {
            matriz[fila][j] = numero * (j + 1);
        }
        return true;
    }


    // Metodo para mostrar la matriz completa
    public void mostrarMatriz() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
