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
public class Lloguer {
    private String nomClient;
    private String dniClient;
    private int diesOcupacio;
    private int posicioAmarrament;
    private Vaixell vaixell;

    public Lloguer(String nomClient, String dniClient, int diesOcupacio, int posicioAmarrament, Vaixell vaixell) {
        this.nomClient = nomClient;
        this.dniClient = dniClient;
        this.diesOcupacio = diesOcupacio;
        this.posicioAmarrament = posicioAmarrament;
        this.vaixell = vaixell;
    }

    
    public String getNomClient() {
        return nomClient;
    }

    public String getDniClient() {
        return dniClient;
    }

    public int getDiesOcupacio() {
        return diesOcupacio;
    }

    public int getPosicioAmarrament() {
        return posicioAmarrament;
    }

    public Vaixell getVaixell() {
        return vaixell;
    }
    
    
    
    public double getPreuLloguer(){
        return this.getDiesOcupacio() * this.getVaixell().getFactor();
    }
}
