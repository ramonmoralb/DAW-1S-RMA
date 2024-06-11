import Triangle.Triangle;
import Triangle.TriangleIllegalException;

/**
 *
 * @author RamónMorenoAlbert
 */
public class TestTriagle {
     public static void main (String[] args) {
        Triangle t1; 
        Triangle t2; 
         
        try {
             t1= new Triangle(1.0, 1.0, 5.0);
                t1.mostarTriangulo();
        } catch (TriangleIllegalException e) {
            System.out.println("Error "+e.getMessage());
        }
        
        try {
             t2= new Triangle(5.0, 4.0, 7.0);
             t2.mostarTriangulo();
        } catch (TriangleIllegalException e) {
            System.out.println("Error "+e.getMessage());
        } 
       
    }
}
