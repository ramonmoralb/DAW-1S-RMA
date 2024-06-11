package itvCobrosRMA;
/**
 * @author RamónMorenoAlbert
 */
public class FaseRevisio {
    String nom;
    private Vehicle vehicle;
    
    public FaseRevisio(String nom){  //el nombre 
        this.nom = nom;
        this.vehicle =null;
    }
    public void asignarVehicle(Vehicle vehicle){
       this.vehicle=vehicle;
    }
    public void mostrar(){
        System.out.print("Fase: "+nom);
            if (vehicle==null){
                System.out.println("buida ");
            }else{
                System.out.println(vehicle);
            }   
    }
    public void añadirVehicleA(FaseRevisio faseRevisio){
        faseRevisio.vehicle=vehicle; 
        desasignarVehicles();
    }
    public void desasignarVehicles(){
        vehicle=null;
    }
    public boolean teVehicle(){ //si es null devulve true
        return vehicle==null;
    }
      public Vehicle sacarApagar(){
        Vehicle VehiculoaColaPaga=vehicle;
        return VehiculoaColaPaga;
    }
      
}
