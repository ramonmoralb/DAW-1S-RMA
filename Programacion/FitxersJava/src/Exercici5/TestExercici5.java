package Exercici5;

import java.util.Map;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author ramon
 */
public class TestExercici5 {

    public static void main(String[] args) throws IOException {
        boolean salir = false;
        GeneradorMapaTemperaturas generador = new GeneradorMapaTemperaturas();
        ComparadorFechaTemperaturas comparadorFechaTemperaturas = new ComparadorFechaTemperaturas();
        File archivoAemet = new File("src"+File.separator+"Exercici5"+File.separator+"Aemet20171031.csv");
        Map<Ciudad, DatosMeterologicos> mapa = generador.generaMapa(archivoAemet);
        boolean iniciar = comparadorFechaTemperaturas.comparador(archivoAemet);

        if (iniciar) {
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
                        generador.mostrarMinimaTemperatura(mapa);
                        break;
                    case 4:
                        generador.mostrarMaximaPrecipitaciones(mapa);
                        break;
                    case 5:
                        System.out.println("Fin del Programa.");
                        salir = true;
                        break;               
                }
            } while (!salir);
        } else {
            System.out.println("La fecha no contiene datos.");
        }
    }
}
