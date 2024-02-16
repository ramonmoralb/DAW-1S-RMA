
package LloguerDeVaixels;

import java.util.Date;

/**
 *
 * @author RamonMorenoAlbert
 */
public class Veler extends Vaixel{
    private Integer numMastelers;
    
    
    public Veler(String matricula, int eslora, Date fecFabri, int numMastelers ){
    super(matricula, eslora, fecFabri);
    this.numMastelers=numMastelers;
    
    }

    

    public Integer getNumMastelers() {
        return numMastelers;
    }

    public void setNumMastelers(Integer numMastelers) {
        this.numMastelers = numMastelers;
    }
    
   
    @Override
    public double factorCalculoPrecio() {
        return getNumMastelers();
    }
}
