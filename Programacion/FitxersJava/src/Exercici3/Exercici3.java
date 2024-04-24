package Exercici3;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author ramon
 */
public class Exercici3 {
    // clase que cargue el texto en un treemap y lo devuelva.
    //debe recibir el archivo y leerlo linea por linea

    public static TreeMap<String, List<String>> cargarArcivo(File file) {
        TreeMap<String, List<String>> mapa = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {  // inicializa el buferReader y recibe el fichero que leera
            String linea;  // la linea obtendrá cada linea usando el metodod readline().
            boolean salir = false;  
            while (!salir) {  // cuando no queden lineas devolverá null cambia a true y sale del while
                linea = br.readLine();  
                if (linea == null) {
                    salir = true;
                } else {
                    String palabrasSeparada[] = linea.split(",");  // cambio el separador con split, para que sea  "," por defecto es el espacio
                    String clave = palabrasSeparada[0].toLowerCase(); //  uso el 0 del array para la clave paso a minuscula para que al mapear no discrimine por mayusculas
                    List<String> valores= new ArrayList<>(); // lista que contedra los valores

                    for (int i = 1; i < palabrasSeparada.length; i++) { // desde el 1 a 3 seran los valores
                        valores.add(palabrasSeparada[i]); 
                    }
                    mapa.put(clave, valores); // la vlave la he recogido como un string y los valores como un array y es lo que recoge el map
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return mapa; // devuelvo el mapa
    }

    public static void main(String[] args) {
        String ruta = "src/Exercici3/sinonimos.txt";  // la ruta al archivo
        File archivo = new File(ruta);                // creo el archivo 
        TreeMap<String, List<String>> mapaSinonimos = cargarArcivo(archivo); // creo el map con el metodo que lee las lineas del archivo (sinonimos.txt)
       // System.out.println("Primera entrada : " + mapaSinonimos.firstEntry());  // compruebo que se ha cargado el archivo imprimiendo la primera entrada
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce la palabra para la que deseas buscar sinonimos: ");
        String palabraBuscarSin = input.nextLine();                                  // paso a minusculas para que no falle la comprobación
        List<String> sinonimos = mapaSinonimos.get(palabraBuscarSin.toLowerCase()); // recibe la clave y devuelve los valores del mapa que cargo en un array
        if (sinonimos != null) {
            System.out.println("Para la palabra ["+palabraBuscarSin +"] se han encontrado los siguientes sinonimos:  "+sinonimos);
        } else {
            System.out.println("No se han encontrado sinonimos para: " + palabraBuscarSin);
        }
    }

}
