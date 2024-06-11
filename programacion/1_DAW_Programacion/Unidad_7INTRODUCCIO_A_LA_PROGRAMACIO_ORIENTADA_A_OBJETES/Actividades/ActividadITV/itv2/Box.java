
package itv2;

/**
 * @author Ramón
 */
public class Box {
    private int id;
    private FaseRevisio fasesRevisio[];  //creo un nuevo array de FaseRevisio que almacenara los vehiculos los cuales vendran desde la clase Faserevisio llamando al metodo .asignarVehicle(vehicle);
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
         System.out.println("El vehicle "+vehicle+" se ha añadido al box "+id+".");
        System.out.println("-------------------------");   
    }
    public void mostrar(){
        System.out.println("-------------------------"); 
        System.out.println("Situación del box : "+id);
        System.out.println("-------------------------");   
            for (int i = 0; i < fasesRevisio.length; i++) {
            FaseRevisio faseRevisio = fasesRevisio[i]; // agregar la fase en cada iteración del fot
            faseRevisio.mostrar();
        }
         System.out.println("-------------------------");     
    }
    
    public void pasarVehiclesDeFase() {
        fasesRevisio[2].añadirVehicleA(fasesRevisio[3]);
        fasesRevisio[1].añadirVehicleA(fasesRevisio[2]);
        fasesRevisio[0].añadirVehicleA(fasesRevisio[1]);
        fasesRevisio[0].desasignarVehicles();     
    }
    
    public boolean estaLliure(){
    return fasesRevisio[0].teVehicle(); // devuelve true si tiene vehiculo
    }
    
}
