package itv2;

import itv2.util.GestorIO;
public class Vehicle {
    GestorIO gestorIO = new GestorIO(); 
    private String matricula;
    private String model;
    private  TipusVehicle tipusVehicle ;
    public static final String PATRO_MATRICULA = "\\d{4}[A-Z]{3}";
    
    public Vehicle(String matricula, String model, TipusVehicle tipusVehicle ){// constructor de la clase vehículo
        this.matricula = matricula;    // atribuetos de la clase vehículo
        this.model = model;            
        this.tipusVehicle = tipusVehicle;
    }
    public boolean teVehicle(String matricula){
      
            return this.matricula.equals(matricula);  // comprobar
     
    }
    public String getMatricula(){
        return matricula;
    }
   
    public static TipusVehicle TipusSegonsIndex(int index){
        switch (index){
            
        case 1:
        return TipusVehicle.Cotxe;
        
        case 2:
        return TipusVehicle.Furgoneta;
       
        case 3:
        return TipusVehicle.Microbús;
       
        case 4:
        return TipusVehicle.Camió;
        
        default:
        return TipusVehicle.Altre;   
        }    
    }    
    @Override
     public String toString(){
       return "[Matricula : " + matricula + "] [Model : " +model + "] [Tipus : " +tipusVehicle+"]";
    }
}
