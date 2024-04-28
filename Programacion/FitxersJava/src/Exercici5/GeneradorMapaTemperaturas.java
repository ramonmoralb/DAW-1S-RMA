
package Exercici5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author ramon
 */
public class GeneradorMapaTemperaturas {
    
    private  Map <Ciudad, DatosMeterologicos> mapaTemp;
    
    public GeneradorMapaTemperaturas(){
        this.mapaTemp=new HashMap<>();    
    }
    
    public Map <Ciudad, DatosMeterologicos> generaMapa(File archivoAemt) throws FileNotFoundException, IOException{
        Map <Ciudad, DatosMeterologicos> mapaTemp = new HashMap<>();
       
        BufferedReader br = new BufferedReader(new FileReader(archivoAemt));
       
        String linea;
        boolean salir = false;
        while(!salir){
            linea=br.readLine();
            if(linea==null){
                salir = true;
            }else{
                //Estaca de Bares;A Coruña;15.5;13:10;13.0;21:40;0 fromato del csv
                String valoresLinea[]= linea.split(";");
               // for(int i = 0; i<valoresLinea.length; i++){
                    String nombreCiudad = valoresLinea[0];
                    String nomProvincia = valoresLinea[1];
                    double tempMaxima = Double.parseDouble(valoresLinea[2]);
                    String horaMaxima = valoresLinea[3];
                    double tempMinima = Double.parseDouble(valoresLinea[4]);
                    String horaMinima = valoresLinea[5];
                    double precipitaciones = Double.parseDouble(valoresLinea[6]);
                    
                    Ciudad ciudad = new Ciudad(nombreCiudad, nomProvincia);
                    DatosMeterologicos datos = new DatosMeterologicos(tempMaxima, horaMaxima, tempMinima, horaMinima, precipitaciones);
               // }
               mapaTemp.put(ciudad, datos );
               
            }   
        }       
        return mapaTemp;
    }

 
    public void mostrarCiudadElegida( Map<Ciudad,DatosMeterologicos> mapa){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Introduce la ciudad de la que deseas ver la info: ");
        String nombreCiudad= input.nextLine();
        
        for (Map.Entry<Ciudad, DatosMeterologicos> entry : mapa.entrySet()) { 
            Ciudad ciudad = entry.getKey();
            DatosMeterologicos datos = entry.getValue();
            
            if(nombreCiudad.equals(ciudad.getNombre())){
                System.out.println(ciudad);
                System.out.println(datos);
                System.out.println("*******************");
            }            
        }     
    }

    public void mostrarMaximaTemperatura(Map<Ciudad,DatosMeterologicos> mapa) {
        double temperaturaMaxima= 0;
        Ciudad ciudadTempMax = null;
        DatosMeterologicos datosTempMax = null;
        for (Map.Entry<Ciudad, DatosMeterologicos> entry : mapa.entrySet()) {
            Ciudad ciudad = entry.getKey();
            DatosMeterologicos datos = entry.getValue();
            if (temperaturaMaxima< datos.getTemperaturaMaxima()) {
               temperaturaMaxima=datos.getTemperaturaMaxima();
               ciudadTempMax = ciudad; 
               datosTempMax = datos;
            }                  
        }
        
        System.out.println(ciudadTempMax);
        System.out.println(datosTempMax);
        System.out.println("****************");
    }
    
}
