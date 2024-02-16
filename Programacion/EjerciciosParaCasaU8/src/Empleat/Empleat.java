package Empleat;

/**
 *
 * @author RamónMorenoAlbert
 */
public  class Empleat {
    private String nom;
    
        public Empleat (String nom){
            this.nom=nom;
        }
        public void setNom(String nom){
            this.nom=nom;
        }
        public String getNom(){
            return this.nom;
        }
        
        public  String toString(){
            return "Empleat "+nom;
        }
                  
}
