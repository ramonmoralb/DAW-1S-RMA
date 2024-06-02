/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class TrianguloEquilatero extends Figura{
    private double base;
    private double altura;
    
    public TrianguloEquilatero(double base, double altura , String color ){
        super(color);
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return this.base*this.altura/2;
        }

    @Override
    public double getPerimetro() {
        return this.base + this.base + this.base;
    }

    @Override
    public String toString() {
        return "TrianguloEquilatero{" + "base=" + base + ", altura=" + altura + '}';
    }

   
}
