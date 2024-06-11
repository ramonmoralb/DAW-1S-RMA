package itvCobrosRMA;
/**
 * @author RamónMorenoAlbert
 */
import java.util.Arrays;
public class CuaInicial{
    private int idCola;
    private Vehicle vehicles[];
     
    public CuaInicial(){
        vehicles = new Vehicle[0];
    }
   
                                                //nombreCola se usará para nombrar la cola tanto inicial como de pago
    public void afegirVehicle(Vehicle vehicle, String nombreCola){                        /*nuevoArray cada vez que se usa el metodo*/
        // Crear un nuevo array con longitud aumentada en 1                 /*  es candidato para el recolector de basura*/                          
        Vehicle[] nuevoArray = new Vehicle[vehicles.length + 1];

            // copia los vehicles de vehicles al nuevo array
            
            for (int i = 0; i < vehicles.length; i++) {
                nuevoArray[i] = vehicles[i];
            }

    // añade el vehicle añ final del nuevo array. !!!!array.length-1 apunta a la ultima posición del array
    nuevoArray[nuevoArray.length - 1] = vehicle;

    // copia el nuevo array con el nuevo vehiculo en la última posicion
    vehicles = nuevoArray;
    System.out.println("El "+vehicle+" s'ha afegit a la "+nombreCola+" en la posició: "+(vehicles.length));
    System.out.println("------------------------------------------------------------------------");
    }
    public Vehicle traure(){
        Vehicle vehiculoExtraido=vehicles[0];
       //  System.out.println("longitud vehicles antes del arrays.copyOF "+vehicles.length); // control interno
        
          for (int i = 1; i < vehicles.length; i++) {
            vehicles[i - 1] = vehicles[i];
            }

            vehicles = Arrays.copyOf(vehicles, vehicles.length - 1); //crea el array con una posicion menos despues de mover los vehiculos hacia adelante
         // System.out.println("longitud vehicles despues del arrays.copyOF"+vehicles.length); // comprobacion interna BORRAR O COMENTAR
          return vehiculoExtraido;
    }
    
    public void mostrarCua(){
        System.out.println("***************");
        System.out.println("**Cua Inicial**"); 
        System.out.println("***************");
            for(int i = 0;i<vehicles.length;i++){
                System.out.println((i+1) +". " +vehicles[i]);
            }
         System.out.println("----------------------------");    
        }
        public void mostrarCuaPaga(){
        System.out.println("********************");
        System.out.println("**Cua de Pagaments**"); 
        System.out.println("********************");
            for(int i = 0;i<vehicles.length;i++){
                System.out.println((i+1) +". " +vehicles[i]);
            }
         System.out.println("----------------------------");    
        }
    public boolean estaBuida(){
            if (vehicles.length==0){
                return true;
            }else{
                return false; 
        }       
    }  
    public boolean conteMatrcicula(String matricula){
        for(int i =0;i<vehicles.length;i++){
            if(vehicles[i].getMatricula().equals(matricula)){  
                System.out.println("No es pot añadir a la cua inicial. La matricula ja exiteix.");
                return true;  // si retorna true finaliza el metodo.
            }
        }
        return false;  //solo llegaría si no entra el if.
    }
}
