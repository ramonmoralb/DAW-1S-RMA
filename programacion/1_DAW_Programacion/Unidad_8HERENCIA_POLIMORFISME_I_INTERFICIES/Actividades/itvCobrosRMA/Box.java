
package itvCobrosRMA;

/**
 * @author Ramón
 */
public class Box {
    private int id;
    private FaseRevisio fasesRevisio[];
    
    private static final String[] TITOLS_FASES = new String[]{
        "1. Seguretat        : ",
        "2. Sistema elèctric : ",
        "3. Fums             : ",
        "4. Frens y direcció : "};
    
    
    private static final int NUM_FASES=4;
    
    public Box(int id){
        this.id = id;
        this.fasesRevisio = new FaseRevisio[NUM_FASES];   
            for (int i = 0; i < this.fasesRevisio.length; i++) {  //
                this.fasesRevisio[i] = new FaseRevisio(TITOLS_FASES[i]);
            }
        
    }
   
    public void afegirVehicle(Vehicle vehicle){
        fasesRevisio[0].asignarVehicle(vehicle);
         System.out.println(vehicle+" Ha sigut afegit al box: ["+id+"]." );
    }
    public void mostrar(){
        System.out.println("-------------------------"); 
        System.out.println("Situación del box : "+id);
        System.out.println("-------------------------");   
            for (int i = 0; i < fasesRevisio.length; i++) {
            FaseRevisio faseRevisio = fasesRevisio[i]; // agregar la fase en cada iteración del for
            faseRevisio.mostrar(); //muesta
        } 
        System.out.println("-------------------------");    
    }
    
     
    public Vehicle pasarVehiclesDeFase() {
       Vehicle vehiculoASaca= fasesRevisio[3].sacarApagar();
      
        fasesRevisio[2].añadirVehicleA(fasesRevisio[3]);
        fasesRevisio[1].añadirVehicleA(fasesRevisio[2]);
        fasesRevisio[0].añadirVehicleA(fasesRevisio[1]);
        fasesRevisio[0].desasignarVehicles();    
        return vehiculoASaca;
    }
    
    public boolean estaLliure(){
    return fasesRevisio[0].teVehicle(); // devuelve true si tiene vehiculo
    }
    public boolean tieneVehiculoUltima(){
    return fasesRevisio[3].teVehicle(); // devuelve true si tiene vehiculo
    }
    
    public int getId(){
        this.id=id;
        return id;
    }

   
}
