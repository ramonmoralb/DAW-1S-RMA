/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package modelo;

/**
 *
 * @author Usuario
 */
public record Coche(String marca, String modelo, int anyoFabr, String color) {
    public String toString(){
        return "Coche \nMarca: "+marca+"\nModelo: "+modelo+"\nAño fabricación: "+anyoFabr+"\nColor: "+color;
    }
}
