package TestPerro;
/**
 * @author Ramón
 */
import Ejercicio2.Perro;
import ExcepcionesEjerecicio2.*;
public class TestPerro {
    public static void main(String[] args)throws EdadInvalida,NombreInvalido{
     
        try {
                    Perro perro1 = new Perro("Boby", 7);
                    perro1.setEdad(-7);
                    
        } catch (NombreInvalido | EdadInvalida e) {
            System.out.println(e.getMessage());
        }
        
        Perro listaDePerros[] = new Perro[5];
        
        try {
             Perro perro1 = new Perro("Sultám", 7);
             listaDePerros[6]=perro1;
        } catch (NombreInvalido | EdadInvalida | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        
    }
       
}
