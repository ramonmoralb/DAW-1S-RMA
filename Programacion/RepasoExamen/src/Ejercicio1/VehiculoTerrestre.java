
package Ejercicio1;

/**
 *
 * @author Ramón
 */
public class VehiculoTerrestre extends Vehiculo {
    private int ruedas;

    public VehiculoTerrestre(String matricula, String modelo,int ruedas) {
        super(matricula, modelo);
        this.ruedas=ruedas;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }
    @Override
    public void imprimir(){
        System.out.println("Información del vheiculo terrestre: \n"
                + "Matrcícula = "+getMatricula()
                + "\nModelo     = "+getModelo()
                + "\nNum Ruedas = "+getRuedas());
        System.out.println("------------------------------------------");
    }
    
}
