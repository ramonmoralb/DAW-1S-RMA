package Exercici5;

import java.util.Scanner;

/**
 *
 * @author ramon
 */
public class Menu {
    public int generarMenu() {
        Scanner input = new Scanner(System.in);
        boolean salir = false;
        int opcion = -1;
        System.out.println();
        System.out.println("1. MOSTRAR CIUDAD");
        System.out.println("2. MOSTRAR CIUDAD CON MÁXIMA TEMPERATURA");
        System.out.println("3. MOSTRAR CIUDAD CON MÍNIMA TEMPERATURA");
        System.out.println("4. MOSTRAR CIUDAD CON MÁS PRECIPITACIONES");
        System.out.println("5. SALIR");
        do {
            System.out.print("Introduzca su opción: ");
            if (input.hasNextInt()) {
                opcion = input.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    salir = true;
                } else {
                    System.out.println("Error. Debes introducir un número entre 1 y 5.");
                }
            } else {
                System.out.println("Error. Debes introducir un número entre 1 y 5.");
                input.next();
            }
        } while (!salir);
        return opcion;
    }
}
