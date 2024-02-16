package LloguerDeVaixels;
/**
 * @author RamónMorenoAlbert
 */
import java.util.Date;

public class ExportivesAMotor extends Vaixel{
    private double cavalls;
    
    public ExportivesAMotor(String matricula,int eslora, Date fecFabri, double cavalls ){
       super(matricula, eslora, fecFabri);
       this.cavalls=cavalls;
    }

    @Override
    public double factorCalculoPrecio() {
        return cavalls/2;
    }
    
    
}
