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
public class Veler extends Vaixell {

    private int nombreMastelers;

    public Veler(int nombreMastelers, String matricula, double eslora, int anyFabricacio) {
        super(matricula, eslora, anyFabricacio);
        this.nombreMastelers = nombreMastelers;
    }

    public int getNombreMastelers() {
        return nombreMastelers;
    }

    @Override
    public double getFactor() {
        return super.getFactor() + this.getNombreMastelers() * 5;
    }

}
