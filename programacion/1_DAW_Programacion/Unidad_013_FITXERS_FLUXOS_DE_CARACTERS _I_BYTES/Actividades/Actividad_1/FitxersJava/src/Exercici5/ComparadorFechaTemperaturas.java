package Exercici5;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author ramon
 */
public class ComparadorFechaTemperaturas {

    public boolean comparador(File archivo) {
        Scanner input = new Scanner(System.in);
        String rutaArchivo = archivo.getAbsolutePath();
        String fechaDeseada = "";
        String rutaAdirectorio = archivo.getParentFile().getAbsolutePath();
        System.out.println(rutaArchivo); // para ver la fecha
        System.out.println("Introduce la fecha que desea obtener información sobre las temperaturas.");
        System.out.print("Introduzca el año [2017]: ");
        String anyo = input.nextLine();
        fechaDeseada += anyo;
        System.out.print("Introduzca el mes [10]: ");
        String mes = input.nextLine();
        fechaDeseada += mes;
        System.out.print("Introduzca el dia [31]: ");
        String dia = input.nextLine();
        fechaDeseada += dia;
        rutaAdirectorio += File.separator+"Aemet" + fechaDeseada + ".csv";
        if (rutaArchivo.equals(rutaAdirectorio)) {
            return true;
        } else {
            return false;
        }
    }

}
