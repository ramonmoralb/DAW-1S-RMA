
package ArrayObjects;

/**
 *
 * @author RamónMorenoAlbert
 */
import java.util.ArrayList;
public class ArrayObjects {
    private  ArrayList <Object> arrayObjec; 
    
    public ArrayObjects(){
        this.arrayObjec=new ArrayList<Object>(); 
    }
    public void añadirObjetos(Object o){
        arrayObjec.add(o);
    }
    public void mostrarArray(){
        System.out.println("Este array de la clase object acepta todos los Objetos.");
        for(int i= 0; i<arrayObjec.size();i++){
            System.out.println(arrayObjec.get(i)+"  "); 
        }
    }
    
}
