/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lloguervaixells;

/**
 *
 * @author jmas
 */
public class Esportiu extends Vaixell {
    private int potencia;

    public Esportiu(int potencia, String matricula, double eslora, int anyFabricacio) {
        super(matricula, eslora, anyFabricacio);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }
    
    
    
    public double getFactor(){
        return super.getFactor() + this.getPotencia()/2;
    }
    
    
}
