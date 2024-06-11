//Ramón Moreno Albert 1ºDAW Semipresencial
import java.util.Scanner;
public class U2Activitat1RMA {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        double sou , souAnual ;
        final double PAGUES, IMPOST30, IMPOST20, LLIURE;
        PAGUES = 12;
        IMPOST30 = 0.3;
        IMPOST20 = 0.2;
        LLIURE = 0;
        
        System.out.print("Introdueix el teu sou brut mensual(\u20AC)"); 
        while (!teclado.hasNextDouble() || (sou = teclado.nextDouble()) <= 0 ) { //puedo introducir variables dentro de las condiciones!
            teclado.nextLine(); 
            System.out.println("ERROR!El valor introduid ha de ser un nombre major que zero.");
            System.out.print("Introdueix el teu sou brut mensual(€)");           
        }
        teclado.nextLine();
        souAnual = sou*PAGUES;       // souAnual= 9999;  comprobador de porcentajes 
        System.out.printf("El teu sou anual és: %.1f€\n" ,souAnual); 
        teclado.close();     
        if (souAnual > 40000) {
            System.out.printf("Et toca pagar %.1f€ y no reps cap ajuda " ,souAnual*IMPOST30);
        } 
        else if (souAnual <= 40000 && souAnual >= 15000) {
            System.out.printf("Et toca pagar %.1f€ y no reps cap ajuda " ,souAnual*IMPOST20);
        }
        else if (souAnual < 15000 && souAnual >= 10000 ) {
            System.out.printf("Et toca pagar %.1f€ y reps una ajuda de 1500€" ,souAnual*IMPOST20);
        }
        else if (souAnual < 10000 ) {
            System.out.printf("Et toca pagar %.1f€ y reps una ajuda de 1500€" ,LLIURE);
        }
  }    
}
