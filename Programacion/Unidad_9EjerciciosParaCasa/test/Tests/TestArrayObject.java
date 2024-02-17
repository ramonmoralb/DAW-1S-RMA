package Tests;
import ArrayObjects.ArrayObjects;


/**
 *
 * @author RamónMorenoAlbert
 */
public class TestArrayObject {
    public static void main(String[] args){
        boolean pruebaMat=7<6;//false
        ArrayObjects array1 = new ArrayObjects();
        
        array1.añadirObjetos("Hola");
        array1.añadirObjetos(7);
        array1.añadirObjetos(true); 
        array1.añadirObjetos("7<6 = "+pruebaMat);
        array1.mostrarArray();
       
    }
}
