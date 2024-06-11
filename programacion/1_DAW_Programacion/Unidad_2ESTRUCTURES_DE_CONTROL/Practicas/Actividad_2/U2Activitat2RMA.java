import java.util.Scanner;
public class U2Activitat2RMA {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int numeroDeIntento, intents, intentsMaxims, nombreIntroduit;
        numeroDeIntento = 1;
        intentsMaxims = 0;
        intents = 0;
        nombreIntroduit = 0;
        double nombreRamdon =  Math.random()*100;
        int ramdomEntero = (int) nombreRamdon;
        double diferencia;
    
        // System.out.print(+ramdomEntero+"\n"); //linea de consulta numero ramdon
      
        System.out.println("BENVINGUT AL JOC: ENDEVINA EL NÚMERO SECRET\n-------------------------------------------------");
        System.out.print("De quants intents vols disposar?: ");
        while ( !teclado.hasNextInt() || (intentsMaxims = teclado.nextInt()) <= 0 || intentsMaxims > 10 ) { 
            System.out.println("ERROR!El valor introduït ha de ser un número entre 1 i 10");
            System.out.print("De quants intents vols disposar?: ");
            teclado.nextLine(); // consume entrada por teclado hasta esta bien
        }
        teclado.nextLine(); // consume entrada hasta esta bien
        while ( intentsMaxims != intents  ){
        System.out.print("Intent " +numeroDeIntento+ ": ");
        while ( !teclado.hasNextInt() || (nombreIntroduit = teclado.nextInt()) <=0 || nombreIntroduit >= 100 ){ 
           System.out.print("ERROR! El valor introduït ha de ser un número entre 1 i 99.\nIntent " +numeroDeIntento+ ":");
           teclado.nextLine(); // consume entrada por teclado
        }
        teclado.nextLine(); // consume entrada por teclado   hasta aquí bien
        diferencia = Math.abs(ramdomEntero-nombreIntroduit);
        intents++;
        numeroDeIntento++;
       // System.out.println("diferrencia= " + diferencia); // lo uso para ver la diferencia y comprobar que las pistas son correctas
        if (diferencia > 29 && nombreIntroduit < ramdomEntero ){    
            System.out.println("El número introduït és menor (Fred)");// este if está ok
        }  
        if (diferencia > 29 && nombreIntroduit > ramdomEntero){    
            System.out.println("El número introduït és major (Fred)");  // este if está ok
        }    
        if (diferencia <= 29  && diferencia > 10 && nombreIntroduit < ramdomEntero ){    
            System.out.println("El número introduït és menor (Temperat)");
        } 
        if (diferencia <= 29 && diferencia > 10 && nombreIntroduit > ramdomEntero ){    
            System.out.println("El número introduït és major (Temperat)");
        } 
        if (diferencia <= 10 && nombreIntroduit < ramdomEntero ){    
            System.out.println("El número introduït és menor (Calent)");
        }   
        if (diferencia <= 10 && nombreIntroduit > ramdomEntero ){    
            System.out.println("El número introduït és major (Calent)");
        }   
        if (ramdomEntero == nombreIntroduit ){ 
            intentsMaxims = intents;
           //cuando acierta sale para ejecutar el if else final y asi imprimir si gana o pierde
        } 
        }  
        teclado.close();
        if (ramdomEntero == nombreIntroduit) {
            System.out.println("Enhorabona, has encertat el número");      
        } else {
            System.out.println("Has perdut el número era :"+ ramdomEntero);
        }
    }
}
   


    
