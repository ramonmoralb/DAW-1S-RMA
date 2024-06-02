
package estudioficherocoche;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import modelo.*;
/**
 *
 * @author Ramon
 */
public class EstudioFicheroCoche {

    
    public static void main(String[] args) {
        Path p = Paths.get("src/modelo/coches.txt");
        System.out.println("e "+  Files.exists(p));
        ArrayList<Coche> lista = CocheDAO.getAll();
        lista.forEach(System.out::println);
        lista.add(new Coche("Audi", "A4", 1992, "rojo"));
        CocheDAO.persist(lista); 
    }  
}

