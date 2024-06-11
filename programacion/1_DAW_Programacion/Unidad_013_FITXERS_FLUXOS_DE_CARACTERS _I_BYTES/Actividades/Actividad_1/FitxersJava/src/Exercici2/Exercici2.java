package Exercici2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author ramon
 */
public class Exercici2 {

    public static boolean comprobadorPrimos(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String rutaParaCarpetas = "src/Exercici2/";
        String nombreFichero = "FicheroPrimos";
        File filePrimos = new File(rutaParaCarpetas + nombreFichero);
        try {
            int contador = 0;
            int numeroAcomprobar = 2;            
            try (PrintWriter output = new PrintWriter(new FileWriter(filePrimos, true))){ // hasta aquí no se ha creado el fichero
                while (contador < 1000) {
                    long inicioTiempo = System.currentTimeMillis();
                    //System.out.println("inicio t "+inicioTiempo);
                    if (comprobadorPrimos(numeroAcomprobar)) {
                        long finalTiempo = System.currentTimeMillis(); // el tiempo aparece a 0ms por que tarda menos de un ms en encpntrarlo
                        output.write(contador + ". Número primo: [" + String.valueOf(numeroAcomprobar) + "] Tiempo en calcular: " + (finalTiempo - inicioTiempo) + " ms.");
                        output.println();
                        contador++;
                    }
                    numeroAcomprobar++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FICHERO NO CREADO");
        }
    }
}
