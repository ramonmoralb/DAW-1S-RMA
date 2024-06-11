package itvCobrosRMA;
/**
 * @author Ramón
 */
public class Furgoneta extends Vehicle {
    private double pma;
    private int cilindres;
    private double importe;
    private int centimetrosCubicos;
    
    
    public Furgoneta(String matricula, String model, TipusVehicle tipusVehicle,  int cilindres,int centimetrosCubicos, double pma, double importe) {
        super(matricula, model, importe, tipusVehicle);
        this.pma = pma;
        this.cilindres = cilindres;
        this.importe = importe;
        this.centimetrosCubicos=centimetrosCubicos; 
    }

    
    /**  @Override
    public String toString() {
        //necesita super.toString para imprimir todo. No se como pero importa el toString de la superClase Vehicle
return super.toString() +  "] [Cilindres: " + cilindres + "]"+"el importe es ccilindros *2 =  "+importe;  
}
* */

}



