package Ejercicio1;
/**
 *
 * @author Ramón
 */
public class Moto extends VehiculoTerrestre{
    private String color;
    
    public Moto(String matricula, String modelo,int rueda, String color){
        super(matricula, modelo, rueda);
        this.color=color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
     @Override
    public void imprimir(){
       
         System.out.println("Información del vheiculo terrestre: \n"
                + "Matrcícula = "+getMatricula()
                + "\nModelo     = "+getModelo()
                + "\nNum Ruedas = "+getRuedas()
                + "\nDe tipo moto de color "+color );
        System.out.println("------------------------------------------");

    }
}
