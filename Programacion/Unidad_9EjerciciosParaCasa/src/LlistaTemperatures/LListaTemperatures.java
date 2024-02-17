
package LlistaTemperatures;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author RamónMorenoAlbert
 */
public class LListaTemperatures extends ArrayList<Double>{ 
    private ArrayList<Double> llistaTem;

    
    
    public LListaTemperatures(){
        this.llistaTem= new ArrayList<>(); 
        
    }
    
    public void anadirTemp(double temp){
        llistaTem.add(temp);
    }
    
    
    public double acumulat(){
        double sum=0;
        for(int i=0;i<llistaTem.size();i++){
            sum +=llistaTem.get(i);
        }
        return sum;
    }
    public double media(){
        double sumaTotal=acumulat();
        
        return sumaTotal/llistaTem.size();
    }
    
    public void mostrarAcumulat(){
        double sumaTotal=acumulat();
        System.out.printf("La temperatura acumulada es %.2f\n",sumaTotal);
    }
    
    public void mostrarMedia(){
        double tempMedia=media();
        System.out.printf("La temperatura media es %.2f \n",tempMedia);
    }
    
    
    public void frequencia(double ptemp){
        int acumulador=0;
        for(int i=0; i<llistaTem.size();i++){
           if(ptemp==llistaTem.get(i)){
               acumulador++;
           }       
        }
        if(acumulador==0){
            System.out.printf("La temperatura indicada  [%.2f] no aparece en la lista de temperaturas.\n",ptemp);
        }
        else{
            System.out.printf("La temperatura indicada  [%.2f] se repite "+acumulador+" en la lista de temperaturas.\n",ptemp);
        }      
    }
    
    public void oredenar(){
        Collections.sort(llistaTem);
    }
     public void desoredenar(){
        Collections.shuffle(llistaTem);
    }            
    public void mostrarLista(){
        System.out.println("Lista temp: ");
        for(int i=0;i<llistaTem.size();i++){
            System.out.print(llistaTem.get(i)+" ");
        }
        System.out.println();
    }
    
    
    
    
}
