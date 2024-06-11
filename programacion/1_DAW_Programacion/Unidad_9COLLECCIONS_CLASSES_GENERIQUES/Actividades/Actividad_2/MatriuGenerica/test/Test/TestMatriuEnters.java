
package Test;

import matriugenerica.*;
import matriugenerica.MatriuException;
public class TestMatriuEnters {
     public static void main(String[] args) throws MatriuException {
        MatriuEnters matrizInt=new MatriuEnters(2);
        Integer matrizIns[][] = new Integer[][] {{1,2},{3,4}};
        matrizInt.sumar(matrizIns); 
        matrizInt.imprimirUltimaOperacio();
        matrizInt.multiplicar(matrizIns);
        matrizInt.imprimirUltimaOperacio();
        MatriuFraccio mafra= new MatriuFraccio(2);
       
    }
}
