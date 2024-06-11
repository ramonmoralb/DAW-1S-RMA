//Ramón Moreno Albert
import java.util.Scanner;
public class U1Activitat1{
	public static void main(String[] args){
        Scanner input = new Scanner(System.in);       
        
	double radi, baseRectangle, alturaRectangle, catet1, catet2, perimetreCercle, areaCercle, areaRectangle, hipotenusa, hipotenusaAlCuadrado; 
      
        final double PI = 3.1416;
        
	System.out.print("Dis-me el valor del radi d'un cercle: ");
 	radi = input.nextDouble();
        System.out.print("\nAra dis-me el valor de la base d'un rectangle: ");
 	baseRectangle = input.nextDouble();
        System.out.print("\nNo oblides dir-me també el valor de l'altura del rectangle: ");
 	alturaRectangle = input.nextDouble();       
        perimetreCercle = PI*2*radi;
 	areaCercle = PI*(radi*radi);
	areaRectangle = baseRectangle*alturaRectangle;
	System.out.printf("\nDe moment tenim un cercle de perímetre %.2f i àrea %.2f, i un rectangle d'àrea %.2f\n", perimetreCercle, areaCercle, areaRectangle  );
	System.out.printf("\nM'agrada el teorema de Pitàgores, dis-me el valor del catet 1: ");
	catet1 = input.nextDouble();
	System.out.printf("\nI també del catet 2: ");
	catet2 = input.nextDouble();
	hipotenusa = (catet1*catet1)+(catet2*catet2);
	hipotenusaAlCuadrado = Math.sqrt(hipotenusa); //raiz cuadrada
	System.out.printf("\nD'acord, el valor de la hipotenusa al quadrat és %.2f, per tant, el valor de la hipotenusa és %.2f",  hipotenusa , hipotenusaAlCuadrado ); 



}
}