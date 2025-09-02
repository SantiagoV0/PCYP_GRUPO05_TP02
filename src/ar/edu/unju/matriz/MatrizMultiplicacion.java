package ar.edu.unju.matriz;

import java.util.Scanner;

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

        // fila elegida de acuerdo al numero
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
    
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese 10 numeros entre 1 y 10");
        
        int numerosIngresados = 0;
        
        while (numerosIngresados < 10) {
            System.out.print("Ingreso: ");
            
            int numero = Integer.parseInt(scanner.nextLine());
            
            if (completarFila(numero)) {
                numerosIngresados++;
                System.out.println("Tabla del " + numero + " agregada correctamente");
            } else {
                System.out.println("Debe ser un numero entero entre 1 y 10");
            }
        }
        scanner.close();
        mostrarMatriz();
    }
}
