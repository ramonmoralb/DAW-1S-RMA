
import LloguerDeVaixels.*;
import java.util.Date;
/**
 *
 * @author RamónMorenoAlbert
 */
public class TestLLoguer {
    public static void main(String[] args){
        Veler veler1= new Veler("1234VELR",12,new Date(),7);
        Lloguer lloguer1 = new Lloguer("Paco Martinez", "44558899P", 7, 1, veler1); 
        
       
        ExportivesAMotor exportivaMotor = new ExportivesAMotor("1235EXM", 12, new Date(), 50);
        Lloguer lloguer2 = new Lloguer("Paco Martinez", "44558899P", 7, 1, exportivaMotor);
        
         
        iotLuxe iotluxe = new iotLuxe("1235IOT", 12, new Date(), 50, 2);
        Lloguer lloguer3 = new Lloguer("Paco Martinez", "44558899P", 9, 1, iotluxe);
         
        System.out.println("LLoguer 1:  "+veler1.getMatricula()+" , "+lloguer1.getPrecio());
        System.out.println("LLoguer 2:  "+exportivaMotor.getMatricula()+" , "+lloguer2.getPrecio());
        System.out.println("LLoguer 3:  "+iotluxe.getMatricula()+" , "+lloguer3.getPrecio());
    }
}
