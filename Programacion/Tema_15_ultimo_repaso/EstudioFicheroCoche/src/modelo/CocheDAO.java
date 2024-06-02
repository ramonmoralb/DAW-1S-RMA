
package modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramon
 */
public class CocheDAO {
  
    public static String cocheToLinea(Coche c){
        
        return c.marca()+" "+c.modelo()+": "+c.anyoFabr()+" "+c.color();
    }
    
    public static Coche lineaToCoche(String linea){
        String partes[] = linea.split(": ");
        String marcaYmod [] = partes[0].split(" ");
        String anyYcolor [] = partes[1].split(" ");
        
        return new Coche(marcaYmod[0], marcaYmod[1], Integer.parseInt(anyYcolor[0]), anyYcolor[1]);
    }
    
    public static void persist(ArrayList<Coche> listaCoches){
        List<String> listaCocStr = new ArrayList<>();
        Path p = Paths.get("src/modelo/coches.txt");
       
        for (Coche c : listaCoches){
            listaCocStr.add(cocheToLinea(c));   
        }
        
        try {
            Files.write(p, listaCocStr);
        } catch (IOException ex) {
            System.out.println("Error en la escritura.  "+ex.getMessage());
        }
    }
        
        public static ArrayList<Coche>  getAll(){
            List<String> listaCocheStr = new ArrayList<>();
            ArrayList<Coche> listaCocheObj  = new ArrayList<>();
            Path p = Paths.get("src/modelo/coches.txt");
        try {
            listaCocheStr = Files.readAllLines(p);
            for (String cocheStr : listaCocheStr) {
                listaCocheObj.add(lineaToCoche(cocheStr));
            }
            
        } catch (IOException ex) {
             System.out.println("Error en la lectura.  "+ex.getMessage());
        }
        return listaCocheObj;
        }
        
    }
 


