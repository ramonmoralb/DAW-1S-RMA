package todasPracticas;
/**
 * @author Ramón
 */
import java.util.Scanner;
public class Practica {
    

    public void sumaUltimo(){
        
        int numIntro;
        int digitDreta; // el modulo de un numero por 10 siempre es el digito de la derecha 11/10 el resto seria 1
        int numSumaUlt;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce un número y le suma la última cifra: ");
        numIntro=input.nextInt();
        System.out.println("Numero introducido: ["+numIntro+"]");
        digitDreta=numIntro % 10;
        numSumaUlt=numIntro+digitDreta;
        System.out.println("Numero derececha  :   ["+digitDreta+"]");
        System.out.println("Resultado suma    : ["+numSumaUlt+"]  ");
    }   
   
    // acaba en 3 o 5 o es par o tiene 2 cifras
    // mirar practica caracteres por si se desea hacer con boolean
    public void parTresCincoCifras(){
        Scanner input = new Scanner(System.in);
        
        int numIntro;
        int ultiDig;
        
        System.out.println("Introduce un número y el programa te dirá si es par, si acaba en tres o en cinco y si tiene dos cifras");
        System.out.print("Introduce un número: ");
            numIntro=input.nextInt();
            ultiDig=numIntro%10;
                if(numIntro%2==0){ // el modulo %2 de cualquier numero si es igual a 0 es par si no impar
                    System.out.println("El número es par.");  
                }
                else{
                    System.out.println("El número no es par");
                }
                if(numIntro%10==5||numIntro%10==3){// modulo de 10 da como resultado el ultimo número
                    if(numIntro%10==3){
                        System.out.println("El número acaba en 3");
                    }
                    else{
                        System.out.println("El número acaba en 5");
                    }
                }else {
                    System.out.println("El número no acaba en 5 ni en 3.");
                    System.out.println("El número acaba en: "+ultiDig);
                }
                if(numIntro>=10&&numIntro<=99){
                    System.out.println("El número tiene 2 cifras ");
                }
                else{
                    System.out.println("El número no tiene 2 cifras ");
                }
    }
    
    // practica char
    public void practicaCaracteres(){
        Scanner input = new Scanner(System.in);
        String caracter; 
        int valorCaracter;
        
        System.out.println("Introduce un carácter, el programa te dirá si es mayuscula, una letra o un número");
        System.out.print("Introduce el caracter deseado: ");
        
        caracter=input.nextLine();
        valorCaracter= (int)caracter.charAt(0); // valor des String en la posicion 0
        boolean eSMayuscula= (valorCaracter>=65&&valorCaracter<=90);  // en el boolean pongo la condicion.Se cumple TRUE, no se cumple FALSE
        boolean eSNumero= (valorCaracter>=48&&valorCaracter<=57);
        boolean eSMinuscula= (valorCaracter>=97&&valorCaracter<=122);
        // if(valorCaracter>=65&&valorCaracter<=90){ // se puede hacer con if pero la practica pide boolean
       //     System.out.println("El caracter introducido es una letra Mayuscula");
       //     }
       System.out.println("Letra Mayuscula = " +eSMayuscula );
       System.out.println("Letra Minuscula = " +eSMinuscula );
       System.out.println("Número = "+eSNumero);
        
    }
    
    
    //prueba con boolean
    public void pruebaBoolean(){
        boolean a = 7==7;
        int b = 1;
        int c = 1;
         System.out.println(a); // imprime true
         System.out.println(b==c); // imprime true
         System.out.println(b!=c); // imprime false
    }
    
    
    // programa que imprime lineas horizontales.
    public void lineasHorizontal(){
        Scanner input = new Scanner(System.in);
        int numLineas=0;
        int contador=0;
        boolean salir=false;
        do{
        System.out.print("Indique el numero de lineas horizpntales que desea que desea imprimir: " ); 
        if(input.hasNextInt()){
            numLineas=input.nextInt();
            salir=true;
        }
            else{
                System.out.println("Error debe introducir un numero entero." );
                input.nextLine();
            }
        }while(!salir);
        while(numLineas>contador){
            System.out.println("_" +(contador+1));
            contador++;
        }     
    }
    
    //programa de tabla de multiplicar
    public void tablaMultiplicar(){
        Scanner input = new Scanner(System.in);
        
        int numAmultiplicar=0;
        int multiplicador=0;
        int resultado;
        boolean salir=false;
        do{
            System.out.print("Que número desea multiplicar: ");
            if(input.hasNextInt()){
                numAmultiplicar=input.nextInt();
                salir=true;
            }
                else{
                System.out.println("Error.Debe introducir un número entero.");
                }
        }while(!salir);
        salir=false;
        do{
            System.out.print("Hasta donde quiere que se multiplique su número: ");
            if(input.hasNextInt()){
                multiplicador=input.nextInt();
                salir=true;
            }
                else{
                System.out.println("Error.Debe introducir un número entero.");
                }
        }while(!salir);
        
        for(int i = 0; i<multiplicador;i++){
            resultado=numAmultiplicar*i;
            System.out.println(numAmultiplicar+"x"+i+"="+resultado);
        }       
    }
    
    //residuo de division sin %  
    public void residuoDiv(){
        Scanner input = new Scanner(System.in);
        int dividendo=0;
        int divisor=0;
        int residuo;
        int resultado;
        boolean salir = false;
        do{
            System.out.print("Introduzca el dividendo: ");
            if(input.hasNextInt()){
                dividendo=input.nextInt();
                salir=true;
            }else {
                System.out.println("Debe de introducir un número entero.");
                input.nextLine();
            }
        }while(!salir);
        salir=false;
        do{
            System.out.print("Introduzca el divisor: ");
            if(input.hasNextInt()){
                divisor=input.nextInt();
                salir=true;
            }else {
                System.out.println("Debe de introducir un número entero.");
                input.nextLine();
            }
        }while(!salir);
        resultado=dividendo/divisor;
        residuo=dividendo - (divisor*resultado);
        
        System.out.println(dividendo +"/"+divisor+"= "+resultado); 
        System.out.println("Residuo = "+residuo); 
    }
    
    
    //practica 3_1 arrays varios valores en la mismas linea
    
    public void practica3_1Arrays(){
        Scanner input = new Scanner(System.in);
        int cantidadNotas=0;
        double nota;
        double contenedorNotas[];
        double valorAux;
        int contadorAux=0;
        boolean salir = false;
        double sumaNotas=0;
        double mediaNotas;
        double notaMaxima=0;
        double notaABuscar=0;
        
        
        System.out.println("NOTAS");
        System.out.println("-----------");
        while(!salir){
            System.out.println("Cuantas notas desea introducir: ");   /**inicializo el array*/
            if(input.hasNextInt()){
                cantidadNotas=input.nextInt();                // establece la longitud del array 
                salir=true;
            }
            else{
                System.out.println("Error. debe introducir un número entero");
                input.nextLine();
            }
        }
        contenedorNotas = new double [cantidadNotas];
        salir=false; //devuelvo el boolean ha false
        System.out.println("A continuación ingrese las notas, si desea parar de introducir notas introduzca '-1' y pulse enter ");
        System.out.println("Introduzca las notas: ");
        while(!salir){
            
            if(input.hasNextDouble()){
                valorAux=input.nextDouble();  //cojo un valor compruebo que sea doble
                
                if(valorAux>=0&&valorAux<=10){
                    nota=valorAux;
                    contenedorNotas[contadorAux]=nota;
                    contadorAux++;                   
                }
                if(valorAux==-1||contadorAux==contenedorNotas.length){ //importante +1 para no salir de rango en el array
                    salir=true;
                }
            }else{
                input.next();
            }   
        
        }        
        salir=false;        
            
        //imprime el array
        System.out.print("Las notas introducidas son: ");
        for(int i = 0; i<contadorAux; i++){
            System.out.print(contenedorNotas[i]); 
            if(!(contadorAux-1==i)){
                System.out.print(", ");
            }
            else{
                System.out.print(".");
            }
            
            //para sacar la media
            sumaNotas +=contenedorNotas[i];
            //parte para sacar el maximo
            if(notaMaxima<contenedorNotas[i]){
               notaMaxima=contenedorNotas[i];
            }
        }
        //media
        System.out.println();
        System.out.println("La suma de las notas es: "+sumaNotas);
        mediaNotas=sumaNotas/contadorAux;
        System.out.println("La media es: "+mediaNotas);
        
        //valor maximo
        System.out.println("El valor máximo es:  "+notaMaxima);
        
        while(!salir){
            System.out.println("Introduce una nota, y se comprobará si está en la lista y en que posición.");
            if(input.hasNextDouble()){
                notaABuscar=input.nextDouble();
                if(notaABuscar<=10&&notaABuscar>=0){
                    salir=true;
                }
                else{
                    System.out.println("Error, debe introducir un número entre 0 y 10.");
                }
                }else{
                    System.out.println("Error, debe introducir un número entre 0 y 10"); 
                }
            input.nextLine();
        }
        for(int i = 0; i<contadorAux; i++){
            if(notaABuscar==contenedorNotas[i]){
                System.out.println("la nota ["+notaABuscar+"] se encuntra en la posición "+(i+1));
            }
        }       
    }
    
    //impresion de caracteres +- sin array
    public void caraterSinArray(){
        Scanner input = new Scanner(System.in);
        int n;
        int cambio=0;
         
        System.out.print("Introduce el el tamaño NxN: ");
        n=input.nextInt();
        
        for(int i =0; i<n; i++){
            for (int j =0; j<n; j++){
                if(cambio%2==0){
                    System.out.print("+");
                    cambio=1;
                }else{
                    System.out.print("-");
                    cambio=0;
                }
            }    
           System.out.println();
       }
    }
    
    //matriz cuadrada que sume se uno en uno
    
    public void matrizSumaUno(){
         Scanner input = new Scanner(System.in);
         int tamaño;
         int acumulador=1;
         System.out.print("Introduce el el tamaño de la matriz: ");
         tamaño=input.nextInt();
         int matriz[][]= new int[tamaño][tamaño];
         for(int i = 0; i<tamaño;i++){
             for(int j = 0; j<tamaño;j++){
             matriz[i][j]=acumulador;
             acumulador++;
             System.out.print(matriz[i][j]+"  ");
            }
             System.out.println();
         }
    }
    
    
    
    //suma de dos matrices           
    public void sumaMatrices(){
        Scanner input = new Scanner(System.in);
        int tamaño;
        int matrizUno[][];
        int matrizDos[][];
        int matrizResultado[][];
        int contador=0;
        
        System.out.print("Introduce el tamaño de la matriz a sumar:  ");
        tamaño=input.nextInt();
        matrizUno= new int[tamaño][tamaño];
        matrizDos= new int[tamaño][tamaño];
        matrizResultado= new int[tamaño][tamaño];
       System.out.println("valores para matrizUno :");  
        for(int i = 0; i<tamaño;i++){
             for(int j = 0; j<tamaño;j++){
             System.out.print("Introduce el valor "+(contador+1)+"/"+(tamaño*tamaño)+" de la matriz 1: ");
             matrizUno[i][j]=input.nextInt();
             contador++;
            }
        }
        System.out.println();
        contador=0;
        System.out.println("valores para matrizDos :");
        for(int i = 0; i<tamaño;i++){
             for(int j = 0; j<tamaño;j++){
             System.out.print("Introduce el valor "+(contador+1)+"/"+(tamaño*tamaño)+" de la matriz 2: ");
             matrizDos[i][j]=input.nextInt();
             contador++;
            }
        }
        //realiza la suma
        for(int i = 0; i<tamaño;i++){
             for(int j = 0; j<tamaño;j++){  
             matrizResultado[i][j]=matrizDos[i][j]+matrizUno[i][j];  
            }
        }
        
        //imprime matrices 
        System.out.println("matrizUno :");            
        for(int i = 0; i<tamaño;i++){
            for(int j = 0; j<tamaño;j++){
            System.out.print(matrizUno[i][j]+" ");            
            }
                System.out.println();
        }
         System.out.println("matrizDos :");            
        for(int i = 0; i<tamaño;i++){
            for(int j = 0; j<tamaño;j++){
            System.out.print(matrizDos[i][j]+" ");            
            }
                System.out.println();
        }       
        System.out.println("Resultado : ");         
        for(int i = 0; i<tamaño;i++){
            for(int j = 0; j<tamaño;j++){
            System.out.print(matrizResultado[i][j]+" ");            
            }
                System.out.println();
        }
    }   
}
    
    
