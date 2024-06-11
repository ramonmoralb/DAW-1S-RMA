//Ramón Moreno Albert
import  java.util.Scanner;
public class U1Activitat6{
	public static void main(String[] asrg){
                                                                
        Scanner input = new Scanner(System.in);
	int preu;
	int dinersIntroduits;
        final int MONEDA1CENT = 1;
	final int MONEDA2CENT = 2;
        final int MONEDA5CENT = 5;
	final int MONEDA10CENT = 10;
	final int MONEDA20CENT = 20;
	final int MONEDA50CENT = 50;
	System.out.println("-MÀQUINA DE BEGUDES-\n");
        System.out.println("-------------\n");
        System.out.print("Introdueix el preu de la beguda que vols: ");
	preu = input.nextInt();        
        System.out.print("Diners que introdueixes a la màquina en cèntims (màxim 100): ");
	dinersIntroduits = input.nextInt();	
        int canvi = (dinersIntroduits-preu);
        System.out.print("El seu canvi és: " + canvi + " centims");       
        int quantitatMonedes50= canvi/MONEDA50CENT;
	System.out.print("\nLa quantitat de monedes de 50 cèntims és: " + quantitatMonedes50 );
 	canvi = canvi - (quantitatMonedes50*MONEDA50CENT);                                                                                                                 
        int quantitatMonedes20= canvi/MONEDA20CENT;
        System.out.print("\nLa quantitat de monedes de 20 cèntims és: " + quantitatMonedes20 );
        canvi = canvi - (quantitatMonedes20*MONEDA20CENT);       
        int quantitatMonedes10= canvi/MONEDA10CENT;
	System.out.print("\nLa quantitat de monedes de 10 cèntims és: " + quantitatMonedes10 );
	canvi =  canvi - (quantitatMonedes10*MONEDA10CENT);
        int quantitatMonedes5= canvi/MONEDA5CENT;
	System.out.print("\nLa quantitat de monedes de  5 cèntims és: " + quantitatMonedes5 );
	canvi =  canvi - (quantitatMonedes5*MONEDA5CENT);    
        int quantitatMonedes2= canvi/MONEDA2CENT;
	System.out.print("\nLa quantitat de monedes de  2 cèntims és: " + quantitatMonedes2 );
	canvi =  canvi - (quantitatMonedes2*MONEDA2CENT);        
        int quantitatMonedes1= canvi/MONEDA1CENT;
	System.out.print("\nLa quantitat de monedes de  1 cèntims és: " + quantitatMonedes1 );
	
   }
}    