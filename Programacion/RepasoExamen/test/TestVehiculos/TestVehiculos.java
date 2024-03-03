package TestVehiculos;
/**
 *
 * @author Ramón
 */
import java.util.ArrayList;
import Ejercicio1.*;
public class TestVehiculos {
    public static void main(String[] args){
        VehiculoTerrestre vt1 =new VehiculoTerrestre("1234trr", "patrol", 7);
        vt1.imprimir();
        
        Coche coche1 = new Coche("1234COCHE", "Seat", 4, false);
        coche1.imprimir();
        
        Moto moto1= new Moto("2222MOTO", "Triuph", 2, "Rojo");
        moto1.imprimir();
        
        Submarino subma1 = new Submarino("5555SUB", "Tortle", 15, 1000);
        subma1.imprimir();
        
        Barco barco1 = new Barco("9999BAR", "Contiki", 8, false);
        barco1.imprimir();
        
        
        //creo array y lo recorro 
        System.out.println("SEGUNDA PARTE");

        ArrayList<Vehiculo> listaDeVehiculos = new ArrayList<>();
        System.out.println("Lista de vehiculos, matrícula y getRuedas() si disponen de ruedas.");
        listaDeVehiculos.add(vt1);
        listaDeVehiculos.add(coche1);
        listaDeVehiculos.add(moto1);
        listaDeVehiculos.add(subma1);
        listaDeVehiculos.add(barco1);
        
        for (Vehiculo vehiculo : listaDeVehiculos) {
            System.out.println("Vehiculo con matrícula = "+vehiculo.getMatricula());
            if(vehiculo instanceof VehiculoTerrestre ){   
               System.out.println("Vehiculo con ruedas igual a = "+((VehiculoTerrestre) vehiculo).getRuedas());  /*necesito castear/ investigar patern en el instanceof puede que no sea necesario algo parecido a froeach*/
            }                                                                                                     
            else{                                                                                                
                System.out.println("Al no tratarse de un vehículo terrestre no contiene el método getRuedas."); 
            }
            System.out.println("-------------------------------------------------"); 
        } 
        
        
        //Interface alquilable
         System.out.println("TERCERA PARTE");
          System.out.println("Alquiler de coches");
         //creo coches alquilables y pruebo 
         CocheAlquilable cocheAlquiler1 = new CocheAlquilable("4444Alqui", "Leon", 4, true, 100);
         CocheAlquilable cocheAlquiler2 = new CocheAlquilable("5555Alqui", "Tigra", 4, true, 1);
         cocheAlquiler1.alquilar("Pepe el Cliente", 7);
         cocheAlquiler1.devolverVehiculo();
         cocheAlquiler1.alquilar("Paco el  2 Cliente", 2);
         //coche no alquilado a devolver 
         cocheAlquiler2.devolverVehiculo();
         
    }    
}
