package Empleat;

/**
 * @author RamónMorenoAlbert
 */
public class Directiu extends Empleat {
    public Directiu(String nom){
        super(nom);
    }

    @Override
    public String toString() {
       return super.toString()+" --> Directiu";
    }    
}
