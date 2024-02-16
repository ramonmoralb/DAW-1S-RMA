
package Empleat;


public class Oficial extends Operari {
    public Oficial(String nom){
        super(nom);
    }

    @Override
    public String toString() {
       return super.toString()+"  --> Oficial";
    }    
}
