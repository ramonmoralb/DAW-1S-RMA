package ejerciciosrepaso3tri;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 *
 * @author Ramon
 */
public class NumerosPrimos {
    public static boolean esPrimo(final int numero){     
            for (int i = 2; i <numero; i++) {
                if(numero%i==0){
                    return false;
            }       
        }    
        return numero>1;
    }
    public static boolean esPrimoFun(final int numero){
        return numero >1  
                && IntStream.range(2, numero).noneMatch(i -> numero%i==0)
                ;
    }
    /*
    Desenvolupa un mètode que a partir d'una llista d'Integers i un selector (predicat) 
    ens retorne la suma de tots aquells elements que compleixen amb este selector.
    */
    public static Integer sumadorListaInt(List<Integer> listaEnteros, Predicate<Integer> p ){
        return listaEnteros.stream()
                .filter(p)
                .reduce(0, (a,b)-> a+b )
                ;
    }
    
    
    public static void main(String[] args) {
        System.out.println("p imp " +esPrimo(8)); 
        System.out.println("p imp " +esPrimoFun(8)); 
        
        System.out.println("sumador de pares "+sumadorListaInt( List.of(5, 6,7,8,9,10), n -> n%2==0));
        sumadorListaInt( List.of(5, 6,7,8,9,10), n -> n%2==0);
        
        
    }
    
}
