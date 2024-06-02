package ejerciciosrepaso3tri;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * @author Ramon
 */
public class EjerciciosRepaso3Tri {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //convertir el siguiente codigo al estilo funcional
        
        double precios [] = {2.54, 9.25, 1.23, 0.90, 19.06};
        double precioMaxImp=0;
        for (double precio : precios) {
            if(precioMaxImp < precio){
                precioMaxImp=precio;
            }
        }
        System.out.println("Precio máximo imperativa : "+ precioMaxImp);
    
        
         double precioMaxFun = Arrays.stream(precios)  
                 .reduce(0, Math::max)
            ;
         System.out.println("Funcional max : "+ precioMaxFun);
         System.out.println("p"+ esprimo(13)); 
         List<Integer> listaAsum = List.of(1, 2 ,3,4,5);
        
         int sumaTotal = sumadordeListas(listaAsum, i -> i>0);
         System.out.println("sumatotal " + sumaTotal);
    }
    private static boolean esprimo(final int numero){
        return numero >1 && IntStream.range(2, numero).noneMatch(i -> numero % i==0); 
    }
    //desenvolupa un mètode que a partir d'una llista d'Integers i un selector (predicat) ens retorne 
    //la suma de tots aquells elements que compleixen amb este selector.
    private static int sumadordeListas(List<Integer> lista , Predicate<Integer> a ){
        return lista.stream()
              .filter(a)
              .reduce(0, (c ,d ) -> c+d)
              ;
    }
    
    
}
