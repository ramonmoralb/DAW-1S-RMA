
package Empleat;

/**
 * @author RamonMorenoAlbert
 */
public class Tecnic extends Operari {
        public Tecnic(String nom){
        super(nom);
    }

    @Override
    public String toString() {
       return super.toString()+" --> Tecnic";
    }    
}


