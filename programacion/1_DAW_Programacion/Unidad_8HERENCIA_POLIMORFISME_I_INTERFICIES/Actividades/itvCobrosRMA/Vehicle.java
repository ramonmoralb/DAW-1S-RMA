package itvCobrosRMA;
/**
 * @author RamónMorenoAlbert
 */
public class Vehicle {
    private String matricula;
    private String model;
    private  TipusVehicle tipusVehicle ;
    private double  importeAPagar;
    public static final double PRECIO_BASE=15;
    public static final double PRECIO_PLAZA_COCHE=1.5;
    public static final double PRECIO_PLAZA_MICROBUS=2;
    public static final double FIJO_CAMION=40;
    public static final double AUMENTO_BASE_CAMION=0.2;
    public static final double ADICIONAL_CAMION=20;
    public static final String PATRO_MATRICULA = "\\d{4}[A-Z]{3}";
    
    public Vehicle(String matricula, String model, double importeAPagar , TipusVehicle tipusVehicle){// constructor de la clase vehículo
        this.matricula = matricula;    // atribuetos de la clase vehículo
        this.model = model;            
        this.tipusVehicle = tipusVehicle;
        this.importeAPagar=importeAPagar;
        
    }
    public boolean teVehicle(String matricula){
      
            return this.matricula.equals(matricula);  // comprobar
     
    }
    public String getMatricula(){
        return matricula;
    }
    public double getimporte(){
        return importeAPagar;
    }
    
   
    public static TipusVehicle TipusSegonsIndex(int index){
        switch (index){
            
        case 1:
        return TipusVehicle.Cotxe;
        
        case 2:
        return TipusVehicle.Furgoneta;
       
        case 3:
        return TipusVehicle.Camió;
       
        case 4:
        return TipusVehicle.Microbus;
        
        default:
        return null;   
        } 
    }    
    @Override
     public String toString(){
       return "[Matricula : " + matricula + "] [Model : " +model + "] [Tipus : " +tipusVehicle+"]";
    }
     
     public static double calcularPrecio(int cilindres, TipusVehicle tipusVehicle, int numPlaces, int centimetrosCubicos, double pma ){
       double total=0;
       if (tipusVehicle == TipusVehicle.Cotxe){
            if(numPlaces>3){
                total=((numPlaces-3)*PRECIO_PLAZA_COCHE)+(cilindres*PRECIO_BASE);
            }else{
                total= cilindres*PRECIO_BASE;
            }
            if(centimetrosCubicos>1200){
                total +=10;
            }
       }
       if (tipusVehicle == TipusVehicle.Microbus){
            if(numPlaces>3){
                total=((numPlaces-3)*PRECIO_PLAZA_MICROBUS)+(cilindres*PRECIO_BASE);
            }else{
                total= cilindres*PRECIO_BASE;
            }
            if(centimetrosCubicos>1200){
                total +=10;
            }
       }
       if(tipusVehicle == TipusVehicle.Furgoneta){
            if(cilindres<10){
               total=(pma*3)+(cilindres*PRECIO_BASE);
            }
            else{
               total=(pma*4)+(cilindres*PRECIO_BASE);
            }
       }
       if(tipusVehicle == TipusVehicle.Camió){
           if(cilindres<10){
               total=FIJO_CAMION+((pma*3)+(cilindres*PRECIO_BASE)+((cilindres*PRECIO_BASE)*AUMENTO_BASE_CAMION));
            }
            else{
                total=FIJO_CAMION+((pma*4)+(cilindres*PRECIO_BASE)+((cilindres*PRECIO_BASE)*AUMENTO_BASE_CAMION));          
            }
                if(centimetrosCubicos>2000){
                    total +=ADICIONAL_CAMION;
                }
       }
       return total;
   }
    
    
}
