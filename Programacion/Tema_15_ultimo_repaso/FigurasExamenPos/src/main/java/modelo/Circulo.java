/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Circulo extends Figura{
    private double radi;
    
    public Circulo(double radi, String color){
        super(color);
        this.radi=radi;
    }

    public double getRadi() {
        return radi;
    }

    public void setRadi(double radi) {
        this.radi = radi;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radi, 2);
    }
    
    @Override
    public double getPerimetro() {
        return 2*Math.PI * radi;
    }

    @Override
    public String toString() {
        return  "Circulo{" + "radi=" + radi + '}';
    }

    
}
