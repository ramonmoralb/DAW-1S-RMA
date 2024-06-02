/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Ramón 
 */
public abstract class Figura {
    private String color;
    
    public Figura(String color){
        this.color = color;
    }
    
    public abstract double getArea();        
    public abstract double getPerimetro();
    @Override
    public abstract String toString();
    
    public String  getColor(){
        return this.color;
    } 
}
