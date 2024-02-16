
package LloguerDeVaixels;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class iotLuxe extends Vaixel{
    private double cavalls;
    private int cabines;
     
    public iotLuxe(String matricula,int eslora, Date fecFabri, double cavalls, int cabines){
        super(matricula, eslora , fecFabri);
        this.cavalls=cavalls;
        this.cabines=cabines;
    }
    

    @Override
    public double factorCalculoPrecio() {
        return (cavalls/2)+(cabines*10);
    }
    
    
}
