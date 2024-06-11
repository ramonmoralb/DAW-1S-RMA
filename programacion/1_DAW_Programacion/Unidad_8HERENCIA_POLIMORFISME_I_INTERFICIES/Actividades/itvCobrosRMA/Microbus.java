package itvCobrosRMA;
/**
 * @author Ramón
 */
public class Microbus extends Vehicle {
    private int numPlaces;
    private int cilindres;
    private double importe;
    private int centimetrosCubicos;
    
    
    public Microbus(String matricula, String model, TipusVehicle tipusVehicle, int numPlaces, int cilindres,int centimetrosCubicos, double importe) {
        super(matricula, model, importe, tipusVehicle);
        this.numPlaces = numPlaces;
        this.cilindres = cilindres;
        this.importe = importe;
        this.centimetrosCubicos=centimetrosCubicos; 
    }
   /**    @Override
*    public String toString() {
*       //necesita super.toString para imprimir todo. No se como pero importa el toString de la superClase Vehicle
*return super.toString() +  "] [Cilindres: " + cilindres + "]"+"el importe es ccilindros *2 =  "+importe;   
*    }
**/


}


