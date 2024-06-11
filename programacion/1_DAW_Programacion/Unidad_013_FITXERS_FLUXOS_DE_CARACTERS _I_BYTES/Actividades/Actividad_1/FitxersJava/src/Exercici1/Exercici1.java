package Exercici1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramon
 */
public class Exercici1 {

    //metodo para crear carpetas
    public static void crearCarpeta(String nombreCarpeta) {    // el método recibirá el nombre de la carpeta, el cual lo generará la iteración del cuble
        File carpeta = new File(nombreCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
        else{
            System.out.println("La carpeta ya exixte "+nombreCarpeta);        }
    }
    //metodo para crear ficheros
    public static void crearFichero(String nombreFichero) throws IOException {  //recibirá el nombre del fichrero que saldrá de un bucle
        File fichero = new File(nombreFichero + ".txt");
        try {
            PrintWriter output = new PrintWriter(new FileWriter(fichero, true)); // necesioto filewriter para darle true al append
           for (int i = 0; i < 100; i++) {  
            output.write(String.valueOf(i)); // si no lo convierto a string imprime simbolos
            output.println(); 
        }
        output.close();  // si no cierro no guarda

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exercici1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // genero numero aleatorio
    public static int numeroAleatorio() {
        Random numero = new Random();
        return numero.nextInt(1001);
    }

    
    
    
    public static void main(String[] args) throws IOException {
        String dirDeTrabajo = System.getProperty("user.dir"); // directorio de la app
        System.out.println(dirDeTrabajo);
        String rutaParaCarpetas = "src/Exercici1/";  // uso la ruta para concatenarle el nombre de la carpeta 1,2 3 ....
        String nombreCarpeta;
        //creo las carpetas
        for (int i = 0; i < 10; i++) {
            nombreCarpeta = rutaParaCarpetas + i + "/";
            crearCarpeta(nombreCarpeta);
            //crea los ficheros
            for (int j = 0; j < 100; j++) {
                String nombreFichero = String.valueOf(numeroAleatorio());
                crearFichero(nombreCarpeta + nombreFichero);
            }
        }
    }
}
