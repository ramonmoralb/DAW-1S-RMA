
package Tests;
import LlistaTemperatures.LListaTemperatures;
/**
 *
 * @author RamónMorenoAlbert
 */
public class TestLlistaTemperatures {
       public static void main(String []args){
        LListaTemperatures lista1 = new LListaTemperatures();
        lista1.anadirTemp(12.3);
        lista1.anadirTemp(12.3);
        lista1.anadirTemp(14.7);
        lista1.anadirTemp(1.9);
        lista1.anadirTemp(13.35);
        lista1.anadirTemp(0.3);
        lista1.anadirTemp(-17.3);
        lista1.mostrarAcumulat();                
        lista1.mostrarMedia();
        lista1.frequencia(12.3);
        lista1.frequencia(0.0);
        lista1.mostrarLista();
        lista1.oredenar();
        lista1.mostrarLista();
        lista1.desoredenar();
        lista1.mostrarLista();

        
    }
}
