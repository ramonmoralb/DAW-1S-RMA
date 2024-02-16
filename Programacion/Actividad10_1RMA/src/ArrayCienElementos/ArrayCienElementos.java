package ArrayCienElementos;
/**
 * @author RamónMorenoAlbert
 */
import java.util.ArrayList;
import java.util.Random;
public class ArrayCienElementos {
    final private int  TAMAÑO;
    private ArrayList<Integer> arrayRandom;
 
    public ArrayCienElementos(){ // construyo el array
        
        Random r = new Random();
        this.TAMAÑO=100;
        this.arrayRandom = new ArrayList<>(TAMAÑO);
        
            for(int i = 0;i<=TAMAÑO;i++){ 
                arrayRandom.add(r.nextInt(500+1));           
            }     
    }
    
    public void imprimirDiezRandom(){         
        for(int k = 0; k<10;k++){
            int j =indicesAleatrios();            
                try {          
                        System.out.println("En la posición ["+j+"] del array se encuentra el valor ["+arrayRandom.get(j)+"]");
                    } catch (IndexOutOfBoundsException e) {
                            System.out.println("El indice ["+j+"] del Array está fuera de rango.");
                    } 
        }        
    }   
    public int indicesAleatrios(){ // generador de aleatorios
        Random r = new Random();
        return r.nextInt(-50, 151); //Java coge el primer indice y deja el ultimo fuera por eso 151
    }             
}
