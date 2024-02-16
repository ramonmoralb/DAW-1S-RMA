package Empleat;
/**
 * @author RamónMorenoAlbert
 */
public class Operari extends Empleat {
    public Operari(String nom){
        super(nom);
    }

    @Override
    public String toString() {
       return super.toString()+" --> Operari";
    }    
}
