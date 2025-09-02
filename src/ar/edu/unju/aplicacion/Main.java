package ar.edu.unju.aplicacion;
import java.util.Scanner;

import ar.edu.unju.calendario.IncrementarAnio;
import ar.edu.unju.juego.SopaDeLetras;
import ar.edu.unju.lineas.ContarLineas;
import ar.edu.unju.matriz.MatrizMultiplicacion;
import ar.edu.unju.numeros.ProcesadorNumeros;
import ar.edu.unju.transformacion.Texto;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Seleccione el punto a ejecutar ===");
        System.out.println("1 - Transformación de texto ");
        System.out.println("2 - Incrementar año y mostrar día de la semana");
        System.out.println("3 - Contar y mostrar la linea mas larga y la mas corta");
		System.out.println("4 - Procesar archivo de numeros");
		System.out.println("5 - Matriz de numeros enteros");
		System.out.println("6 - Crear Sopa de Letras");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {

            case 1:
                try {
                    new Texto().procesarTexto();
					System.out.println("Ejecutado correctamente, revisar el archivo txt creado.");
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 2:
				try{
					new IncrementarAnio().mostrarFechas();
				}catch(Exception e){
					System.out.println("Error: " + e.getMessage());
				}
                break;
            case 3:
				try{
					new ContarLineas().contarMostrar();
				}catch(Exception e){
					System.out.println("Error: " + e.getMessage());
				}
                break;
			case 4:
		        try {
		            new ProcesadorNumeros().procesarArchivo();		            
		        } catch (Exception e) {
		            System.err.println("Error al procesar el archivo: " + e.getMessage());
		        }
            	break;
			case 5:
			    try {
			        new MatrizMultiplicacion().ejecutar();
			    } catch (Exception e) {
			        System.out.println("Error: " + e.getMessage());
			    }
			    break;
			case 6:
				try {
			        SopaDeLetras sopa = new SopaDeLetras();
        			sopa.crearSopaDeLetras();
        			sopa.mostrarSopaDeLetras();
			    } catch (Exception e) {
			        System.out.println("Error: " + e.getMessage());
			    }
                break;
            default:
                System.out.println("Opción no valida");
        }

        sc.close();
    }
}
