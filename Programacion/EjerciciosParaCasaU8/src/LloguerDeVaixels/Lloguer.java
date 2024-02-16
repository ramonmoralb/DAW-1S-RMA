
package LloguerDeVaixels;

/**
 *
 * @author RamonMoreno
 */
public  class Lloguer  {
    protected String NomClient;
    protected String DNIClient;
    protected int diesOcupacio;
    protected int numAmarrament;
    protected Vaixel vaixel;
    protected double precio;

    public Lloguer(String NomClient, String DNIClient, int diesOcupacio,int numAmarrament,Vaixel vaixel){
        this.NomClient=NomClient;
        this.DNIClient = DNIClient;
        this.diesOcupacio = diesOcupacio;
        this.numAmarrament = numAmarrament;
        this.vaixel = vaixel;
        this.precio=calcularPrecio();
   } 
   public double calcularPrecio(){
       return diesOcupacio*vaixel.getEslora()*vaixel.factorCalculoPrecio();
   }

    public double getPrecio() {
        return precio;
    }
   
}