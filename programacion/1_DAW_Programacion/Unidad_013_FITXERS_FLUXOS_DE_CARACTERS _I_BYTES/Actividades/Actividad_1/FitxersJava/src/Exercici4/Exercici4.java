package Exercici4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramon
 */
public class Exercici4 {
    
    public static void mostrarNotasMedias(File archivoAlumnos) throws IOException {
        Map<String, List<Integer>> mapAlumnos = new HashMap<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivoAlumnos));  // buferreader para leer el archivo 
            String linea;
            boolean salir = false;
            
            while (!salir){
                linea = br.readLine();
                if(linea==null){
                    salir=true;
                }else {
                    String lineaSeparada[] = linea.split(" ");   // para las separaciones del arcrhivo, por ejemplo en un csv split(";") 
                    String clave = lineaSeparada[0]+" "+lineaSeparada[1];  // en este caso la clave son el nombre y apellido, 
                    List<Integer> notas = new ArrayList<>();
                    
                    for (int i = 2; i<lineaSeparada.length ; i++) {
                       notas.add(Integer.valueOf(lineaSeparada[i])); //añado las notas !!!Tengo en cuenta desde la tercera posición[2], [0][1]SON LA CLAVE
                    }
                    mapAlumnos.put(clave, notas); // en cada iteración del while clave(Nombre de alumno), y notas(ArrayList)
                }                
            }
            //System.out.println(mapAlumnos); 
            for(Map.Entry<String, List<Integer>>  entry : mapAlumnos.entrySet()){
                String alumno = entry.getKey();          //entry.getKey()  recojo la clave del mapa
                List<Integer> totalNotas = entry.getValue(); 
                Double media = calculaMedia(totalNotas);
               System.out.printf("Alumno: %s  \nNota Media: %.2f\n", alumno, media);
               System.out.println("**********************************");
                
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exercici4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 
    public static Double calculaMedia(List<Integer> notas){
        
        Integer suma = 0;
        
        for (Integer nota : notas) {
            suma +=nota;
        }     
        return (double) suma / notas.size();       // necesario castear
    }
    
    
    public static void main(String[] args) throws IOException {
  
        String rutaANotas = "src/Exercici4/alumnes_notes.txt";  //pruebas
        File archivoNotas= new File(rutaANotas);  
       
        System.out.println("Notas medias:\n");
        mostrarNotasMedias(archivoNotas);
       
        
          //   System.out.println(archivoNotas.getAbsolutePath());       
       //File localizacionArc = new File(System.getProperty("user.dir"));
       // System.out.println("getProperty: "+System.getProperty("user.dir"));
       // System.out.println(localizacionArc.getAbsoluteFile());
       // System.out.println("existe = "+ archivoNotas.exists());
       // System.out.println("get parent "+archivoNotas.getParent());
       // System.out.println("ruta absoluta "+archivoNotas.getAbsolutePath());
        
       
        
    }
}
