/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5y6;

/**
 *
 * @author ciclost
 */
public class Audiolibros extends Digitales {
    private double horas;

    public Audiolibros( String codIsbm, String titulo, int mb, double horas) {
        super(codIsbm, titulo, mb);
        this.horas = horas;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    @Override
    public void mostraInfo() {
 System.out.println("Material digital con codigo ISM = "+getCodIsbm()+ " de título " +getTitulo()+" y las siguientes páginas: "+getMb()+
                "con un número de horas de : "+getHoras());    }
     
    
    
}
