import java.util.Scanner;
public class U3Activitat1RMA {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double medidas[][] = new double[10][2];
        int medidasCorrectas = 0;
        int interaccion = 0;
        int opcionMenu;
        boolean salir = false;
        boolean salirSwich = false; 
        System.out.print("TENSIÓ ARTERIAL\n---------------------\nIntrodueix les mesures: ");
        while (!salir && medidasCorrectas < 10 ) { // la negacion 
            if (input.hasNextDouble()) {
                double valor = input.nextDouble();
                if (valor == 0) {
                    salir = true;
                }else if (valor >= 3 && valor <= 22) {
                    if (interaccion == 0) {
                        medidas[medidasCorrectas][0] = valor; // Sistólica
                    } else {
                        medidas[medidasCorrectas][1] = valor; // Diastólica
                        medidasCorrectas++;
                    }
                    interaccion = 1 - interaccion; // Alternar entre 0 y 1
                } 
            } else {
                input.next(); // Descartar entrada no válida
            }
        }
       // Imprimir las medidas almacenadas
  //     for (int i = 0; i < medidasCorrectas; i++) {
   //         System.out.println("Medida " + (i + 1) + ": Sistólica = " + medidas[i][0] + ", Diastólica = " + medidas[i][1]);
     //   }
        // maximas
        double sistolicaMaxima = 0;
        double diastolicaMinima = 0;
        for(int i = 0; i <medidasCorrectas;i++){
            if(sistolicaMaxima<medidas[i][0]){
                sistolicaMaxima=medidas[i][0];
             }    
            if(diastolicaMinima>medidas[i][1]){
                diastolicaMinima=medidas[i][1];
            }
            else if(diastolicaMinima==0){          // este if else hace que si la medida es 0 al no haberse rellenado el array entero busque el valor meno  diferente de 0
                diastolicaMinima=medidas[i][1];
            }       
        }
        //System.out.println("sistolica maxima  =  "+sistolicaMaxima+ "\ndiastolica maxima = "+diastolicaMaxima ); control interno de valores
        //compensada
        double diferencia[] = new double[medidasCorrectas];
        double dobleSistolicas[] = new double[medidasCorrectas];
        for(int i = 0;i< medidasCorrectas; i++){
            dobleSistolicas[i]=medidas[i][1]*2;
            diferencia[i]=Math.abs(dobleSistolicas[i]-medidas[i][0]);
         //   System.out.println("diferencia" +i+ "=  "+ diferencia[i]); control interno de valores
        }
        int indiceMinDiferencia = 0;
        for(int i = 1; i<diferencia.length; i++ ){  
            if(diferencia[i]<diferencia[0]){
                diferencia[0]=diferencia[i];
                indiceMinDiferencia=i;
            }
        }
       // System.out.println("indice= "+ indiceMinDiferencia );
       // System.out.println("medidad   sistolica"+ medidas[indiceMinDiferencia][0] +"  y medidad diastolica = " + medidas[indiceMinDiferencia][1]   );
        double sitolicaCompensada=medidas[indiceMinDiferencia][0];
        double diastolicaCompensada=medidas[indiceMinDiferencia][1];

       //tension media
       double sumaSistolica=0;
       double sumaDiastolica=0;
       double mediaSistolica=0;
       double mediaDiastolica=0;
        for(int i = 0; i<medidasCorrectas; i++ ){
            sumaSistolica= sumaSistolica + medidas[i][0];
            sumaDiastolica= sumaDiastolica + medidas[i][1];
            mediaSistolica= sumaSistolica/medidasCorrectas;
            mediaDiastolica= sumaDiastolica/medidasCorrectas;
        }
        //   System.out.println("media sistolica "+mediaSistolica+"media diasstolica m" + mediaDiastolica ); control interno de valores
        // estructura swich 
         System.out.println("\n1- Sistòlica màxima");
        System.out.println("2- Sistòlica mínima");
        System.out.println("3- Més compensada");
        System.out.println("4- Tensio mitjana");
        System.out.println("5- Salir");
        System.out.print("\nSelecciona l'opció desitjada: ");
        while (!salirSwich){
            if(input.hasNextInt()){
                opcionMenu=input.nextInt();
                
                if(opcionMenu>=1&&opcionMenu<=5){
                    
                    switch (opcionMenu) {   
                        case 1:                     
                            System.out.printf("%.1f Sistòlica màxima\n" , sistolicaMaxima   );
                            System.out.print("\nSelecciona l'opció desitjada: ");
                            break;
                        case 2:                     
                            System.out.printf("%.1f Diastòlica minima\n" , diastolicaMinima   );
                            System.out.print("\nSelecciona l'opció desitjada: ");                     
                            break;   
                        case 3:                       
                            System.out.printf("%.1f %.1f" ,  sitolicaCompensada , diastolicaCompensada );
                            if(sitolicaCompensada<12&&diastolicaCompensada<8){
                                System.out.print(" Óptima\n");
                                System.out.print("\nSelecciona l'opció desitjada: ");                
                            }
                            else if ((sitolicaCompensada>=12&&sitolicaCompensada<=12.9)&&(diastolicaCompensada>=8&&diastolicaCompensada<=8.4)){
                                System.out.print(" Normal\n");
                                System.out.print("\nSelecciona l'opció desitjada: ");                         
                            }
                             else if ((sitolicaCompensada>=13&&sitolicaCompensada<=13.9)&&(diastolicaCompensada>=8.5&&diastolicaCompensada<=8.9)){
                                System.out.print(" Normal-alta\n");
                                System.out.print("\nSelecciona l'opció desitjada: ");                            
                            }
                            else if ((sitolicaCompensada>=14&&sitolicaCompensada<=15.9)&&(diastolicaCompensada>=9&&diastolicaCompensada<=9.9)){
                                System.out.print(" Grau 1\n");
                                System.out.print("\nSelecciona l'opció desitjada: ");
                            }
                            else if ((sitolicaCompensada>=16&&sitolicaCompensada<=17.9)&&(diastolicaCompensada>=10&&diastolicaCompensada<=10.9)){
                                System.out.print(" Grau 2\n");
                                System.out.print("\nSelecciona l'opció desitjada: ");
                            }
                            else if (sitolicaCompensada>=18&&diastolicaCompensada>=11){
                                System.out.print(" Grau 3\n");
                                System.out.print("\nSelecciona l'opció desitjada: ");
                            }    
                            else if (sitolicaCompensada>=14&&diastolicaCompensada<9){
                                System.out.print(" Tensió aïllada\n"); 
                               System.out.print("\nSelecciona l'opció desitjada: ");
                            }
                            else {
                            System.out.print(" No contemplat");
                               System.out.print("\nSelecciona l'opció desitjada: ");

                            }                        
                            break; 
                            case 4:
                                 System.out.printf(" %.1f %.1f  és la tensió mitjana\n", mediaSistolica , mediaDiastolica); 
                                System.out.print("\nSelecciona l'opció desitjada: ");
                            break;
                            case 5:                       
                                salirSwich=true;                       
                            break;  
                           
                        default:

                            break;
                    }
                   
                }    
                else{
                System.out.print("Error.\nSelecciona l'opció desitjada: ");
                input.nextLine();
            }

            }
            else {
               System.out.print("Error.\nSelecciona l'opció desitjada: ");
                input.nextLine();  
            }
        }
        input.close();;
    }
    
}

