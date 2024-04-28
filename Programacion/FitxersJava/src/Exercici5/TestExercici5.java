package Exercici5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Exercici5.DatosMeterologicos;

/**
 *
 * @author ramon
 */
public class TestExercici5 {

    public static void main(String[] args) throws IOException {
        boolean salir = false;
        GeneradorMapaTemperaturas generador = new GeneradorMapaTemperaturas();
        File archivoAemet = new File("src/Exercici5/Aemet20171031.csv");
        Map<Ciudad, DatosMeterologicos> mapa = generador.generaMapa(archivoAemet);
        Menu menu = new Menu();

        
        do {
            
            int opcion = menu.generarMenu();
            switch (opcion) {
                case 1:
                    generador.mostrarCiudadElegida(mapa);
                    break;
                case 2:
                    generador.mostrarMaximaTemperatura(mapa);
                    break;    
                case 3:
                    
                    break;
                case 4:
                    
                    break;    
                case 5:
                    System.out.println("Fin del Programa.");
                    salir = true;
                    break;
                default:
                    throw new AssertionError();
            }
            
        } while (!salir);
    }
}
