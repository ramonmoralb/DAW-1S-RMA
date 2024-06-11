package itvCobrosRMA;

/**
 * @author RamónMorenoAlbert
 */
//completamente necesario de momento en el extends agregar todo a los parametros para luego poder usarlo
//investigar otros metodos de hacerlo???
public class Cotxe extends Vehicle {
    private int numPlaces;
    private int cilindres;
    private double importe;
    private int centimetrosCubicos;

    public Cotxe(String matricula, String model, TipusVehicle tipusVehicle, int numPlaces, int cilindres, int centimetrosCubicos, double importe) {
        super(matricula, model, importe, tipusVehicle); 
        this.numPlaces = numPlaces;
        this.cilindres = cilindres;
        this.importe = importe;
        this.centimetrosCubicos=centimetrosCubicos; 
    }   
  
    
// @Override //desactivar al finalizar para imprimiren formato correcto
  //  public String toString() {
        //necesita super.toString para imprimir todo. No se como pero importa el toString de la superClase Vehicle
        //return super.toString() + " [NumPlaces: " + numPlaces + "] [Cilindres: " + cilindres + "]"+"el importe es ccilindros *2 =  "+importe;
  //  }
    
}

