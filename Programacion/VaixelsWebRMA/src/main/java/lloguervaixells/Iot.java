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
public class Iot extends Esportiu{
    private int nombreCabines;

    public Iot(int nombreCabines, int potencia, String matricula, double eslora, int anyFabricacio) {
        super(potencia, matricula, eslora, anyFabricacio);
        this.nombreCabines = nombreCabines;
    }

    public int getNombreCabines() {
        return nombreCabines;
    }
    
    public double getFactor(){
        return super.getFactor() + getNombreCabines()*10;
    }
}
