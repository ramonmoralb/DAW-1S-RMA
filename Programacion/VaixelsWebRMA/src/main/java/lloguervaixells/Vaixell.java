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
public class Vaixell {

    private String matricula;
    private double eslora;
    private int anyFabricacio;

    public Vaixell(String matricula, double eslora, int anyFabricacio) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anyFabricacio = anyFabricacio;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getEslora() {
        return eslora;
    }

    public int getAnyFabricacio() {
        return anyFabricacio;
    }

    public double getFactor() {
        return this.getEslora() * 10;
    }

}
