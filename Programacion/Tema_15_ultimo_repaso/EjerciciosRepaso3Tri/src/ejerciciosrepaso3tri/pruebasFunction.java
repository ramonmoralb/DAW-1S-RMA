/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciosrepaso3tri;

import java.util.function.Function;

/**
 *
 * @author ramón
 */
public class pruebasFunction {
    public static void main(String[] args) {
    Function<Integer, Function<Double, Function<Double, Double>>> ivaDescuneto = 
            iva -> descuento -> precio -> precio + (precio * iva / 100) - ((precio + (precio * iva / 100)) * descuento / 100);
   final  var iva21Des10 = ivaDescuneto.apply(21).apply(10d);
        System.out.println("producto de 500 "+ iva21Des10.apply(500d));
   // iva21Des10.apply(500d);
    }
    
   
    
}
