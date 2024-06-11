//Ramón Moreno Albert
public class U1Activitat4{
	public static void main(String[] args){
 	                                                    // A= 3.4, B= 50.2, C= 2.1, D=0.55, E=44.5, F=5.9
 	final double A = 3.4;
	final double B = 50.2;
 	final double C = 2.1;
	final double D = 0.55;
	final double E = 44.5;
	final double F = 5.9;
        double x = ((E*D-B*F))/((A*D-B*C));
	double y = ((A*F-E*C))/((A*D-B*C));
	double convalidacionX1Ecu = ((( E- (A*x)) /B));  
        double convalidacionX2Ecu = ((( F- (C*x)) /D));                                                            
	
	System.out.println("SISTEMA D'EQUACIONS LINEALS");
	System.out.println("------------------------------------------");
   	System.out.println("3.4x + 50.2y = 44.5");      
	System.out.println("2.1x + 0.55y = 5.9\n"); 
	System.out.println("SOLUCIÓ PER CRAMER"); 
	System.out.println("------------------------------------------"); 
	System.out.printf("x = %.2f\n" , x );
	System.out.printf("y = %.2f\n\n" , y);
	System.out.println("COMPROVACIÓ DONADA LA 'x'"); 
	System.out.println("------------------------------------------");
	System.out.printf("y = %.2f\n" , convalidacionX1Ecu);
	System.out.printf("y = %.2f\n" , convalidacionX2Ecu);      


  }
}