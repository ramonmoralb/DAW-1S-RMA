
package Test;

import matriugenerica.*;
import matriugenerica.MatriuException;
public class TestMatriuFraccions {
      public static void main(String[] args) throws MatriuException {
   
        MatriuFraccio mafra= new MatriuFraccio(2);
        Fraccio f1 = new Fraccio(1, 2);
        Fraccio f2 = new Fraccio(1, 2);
        Fraccio f3 = new Fraccio(1, 2);
        Fraccio f4 = new Fraccio(1, 2);
        Fraccio fArray[][]={{f1,f2},{f3,f4}};
        mafra.sumar(fArray);
        mafra.imprimirUltimaOperacio(); 
        mafra.multiplicar(fArray);
        mafra.imprimirUltimaOperacio();
    }
}
