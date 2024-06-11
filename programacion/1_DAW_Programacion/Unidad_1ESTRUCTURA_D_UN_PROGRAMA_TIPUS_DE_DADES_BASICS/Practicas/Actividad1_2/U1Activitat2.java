//Ramón Moreno Albert
public class U1Activitat2{
	public static void main(String[] agrs){
       
	double actualPoblacion = 312032486;
        final double SEGUNDOSANO = 31536000;
        double any = 2023;
        double crecimientoAnual = ((SEGUNDOSANO/7) + (SEGUNDOSANO/45)) - (SEGUNDOSANO/13);

	System.out.println("\nPROJECCIÓ DE LA POBLACIÓ ALS EUA\n");
	System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ \n");
        System.out.printf("\tAny actual:       %.0f    persones\n"  ,actualPoblacion);
        System.out.printf("\tAny  %.0f :       %.0f    persones\n" , ++any, (crecimientoAnual + actualPoblacion)) ;
	actualPoblacion = ( crecimientoAnual + actualPoblacion );   
        System.out.printf("\tAny  %.0f :       %.0f    persones\n" , ++any, (crecimientoAnual + actualPoblacion)) ;
        actualPoblacion = ( crecimientoAnual + actualPoblacion ); 
	System.out.printf("\tAny  %.0f :       %.0f    persones\n" , ++any, (crecimientoAnual + actualPoblacion)) ;
        actualPoblacion = ( crecimientoAnual + actualPoblacion ); 
	System.out.printf("\tAny  %.0f :       %.0f    persones\n" , ++any, (crecimientoAnual + actualPoblacion)) ;
        actualPoblacion = ( crecimientoAnual + actualPoblacion ); 
	System.out.printf("\tAny  %.0f :       %.0f    persones\n" , ++any, (crecimientoAnual + actualPoblacion)) ;
        actualPoblacion = ( crecimientoAnual + actualPoblacion ); 



  }
}