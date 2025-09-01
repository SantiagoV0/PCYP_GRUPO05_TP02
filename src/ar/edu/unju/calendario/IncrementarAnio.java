package ar.edu.unju.calendario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.time.DayOfWeek;


public class IncrementarAnio {
    public void mostrarFechas(){
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter  formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for(int i=0; i<=100; i++){
            LocalDate nuevaFecha = fechaActual.plusYears(i);
            DayOfWeek diaSemana = nuevaFecha.getDayOfWeek();
            String diaSpanish = diaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES")); //getDisplayName() con Locale permite obtener el nombre en español
            System.out.println("Fecha: " + nuevaFecha.format(formato) + " - Día de la semana: " + diaSpanish);
        }


    }
}
