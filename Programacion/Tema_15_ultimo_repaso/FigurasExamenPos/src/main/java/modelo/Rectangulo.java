/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Rectangulo extends Figura{
    private  double base;
    private double altura;
    
    public Rectangulo( double base, double altura, String color){
        super(color);
    } 

    public double getBase() {
        return base;
    }

    public void setBase(double base){
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
       return this.base * this.altura;
    }

    @Override
    public double getPerimetro() {
        return (2*this.base) +  (2*this.altura);
    }

    @Override
    public String toString() {
        return "Rectangulo{" + "base=" + base + ", altura=" + altura + '}';
    }


    
}
