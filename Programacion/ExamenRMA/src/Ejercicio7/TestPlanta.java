package Ejercicio7;

/**
 *
 * @author RamonMorenoAlbert
 */
public class TestPlanta {
    public static void main(String[] args) throws AltutaInvalida, NombreInvalido{
       
        
        try {
            Planta planta1 = new Planta("Ro",25);
            
        } catch (AltutaInvalida | NombreInvalido e) {
            System.out.println(e.getMessage());
        }
         try {
            Planta planta2 = new Planta("Rosa",25);
            planta2.setAltura(-7); 
        } catch (AltutaInvalida | NombreInvalido e) {
            System.out.println(e.getMessage());
        }
        
     //array de plantas 
        
         Planta listaDePlantas[] = new Planta[5];
         try {
             Planta planta3 = new Planta("Geraneo",7);
             listaDePlantas[6]=planta3;
                     
            
        } catch (AltutaInvalida | NombreInvalido | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
         
    }
     
    
 
    
    
}
