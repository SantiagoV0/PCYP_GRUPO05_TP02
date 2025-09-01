package ar.edu.unju.aplicacion;
import java.util.Scanner;
import ar.edu.unju.transformacion.Texto;
import ar.edu.unju.calendario.IncrementarAnio;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Seleccione el punto a ejecutar ===");
        System.out.println("1 - Transformación de texto ");
        System.out.println("2 - Incrementar año y mostrar día de la semana");
        System.out.println("3 - ");
		System.out.println("4 - ");
		System.out.println("5 - ");
		System.out.println();
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

                break;
			case 4:

            	break;
			case 5:

            	break;
			case 6:

                break;
            default:
                System.out.println("Opción no valida");
        }

        sc.close();
    }
}
