
package matriugenerica;

import java.util.Random;


public class MatriuFraccio extends MatriuGenerica<Fraccio> { 
    
    public MatriuFraccio(int tamany){
        super(tamany);
    }
    
     @Override
    public Fraccio suma(Fraccio a, Fraccio b) {
        return a.suma(b) ;
    }

    @Override
    public Fraccio multiplicacio(Fraccio a, Fraccio b) {
        return a.multipicacio(b);
    }

    @Override
    public Fraccio zero() {
        return new Fraccio(0, 1);
    }

    @Override
    public Fraccio aleatori() {
        Random random = new Random();
        return new Fraccio(random.nextInt(10),random.nextInt(10)+1);
    }
    
    
}
