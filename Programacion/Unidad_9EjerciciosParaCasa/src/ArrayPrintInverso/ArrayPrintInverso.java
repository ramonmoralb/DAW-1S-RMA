
package ArrayPrintInverso;
import java.util.ArrayList;

/**
 *
 * @author RamónMorenoAlbert
 */
public class ArrayPrintInverso {
    private ArrayList<String> arrayStr;

    private final int longitudArray=5;
    public  final String numEnLetra []={"uno","dos","tres","cuatro","cinco" }; 
    
    
    public ArrayPrintInverso(){
        this.arrayStr=new ArrayList<String>(longitudArray);
        
        for(int i = 0;i<longitudArray;i++){
            arrayStr.add(numEnLetra[i]);
        }
    } 
    public void mostrarArray(){
        System.out.println("Ipresión por pantalla del array Original.");
        for(int i = 0;i<arrayStr.size();i++){
            System.out.print(arrayStr.get(i)+" "); 
        }
    }
    public void mostrarArrayAlReves(){
        System.out.println("Ipresión por pantalla del array Invertido.");
        for (int i = arrayStr.size() - 1; i >= 0; i--) { //i=es esl tamaño del array (-1 para que no salga de rango), la condicion para que acabe e ir restando.
            System.out.print(arrayStr.get(i) + " "); 
        }
    }
}
