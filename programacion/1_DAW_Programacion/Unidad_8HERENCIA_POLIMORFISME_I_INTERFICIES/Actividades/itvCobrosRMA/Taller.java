package itvCobrosRMA;
/**
 * @author RamónMorenoAlbert
 */
import java.util.Scanner;
public class Taller {
    private Box Boxs[];
    private CuaInicial cuaInicial;
    private CuaInicial pendientesPago;
    private double totalCobrado;
    private static final int NUM_BOXS = 6;    
        public Taller(){
            this.Boxs = new Box[Taller.NUM_BOXS]; //longitud del array
                for(int i = 0; i<Boxs.length; i++){   //este array crea los objetos 6 boxes
                    Boxs[i]=new Box(i+1); //el id de cada Boxs
                }                         
            this.cuaInicial = new CuaInicial();
            this.pendientesPago = new CuaInicial();
            this.totalCobrado=totalCobrado;
        }

    private Vehicle recollirVehicle() {
        String matricula = llegirMatricula();
        String model = llegirModel();
        TipusVehicle tipus = llegirTipus();
                 //   System.out.println("tipo antes del switch " + tipus  );// comprobacion interna BORRAR AL FINALIZAR
            switch (tipus) {
                case Cotxe:
                    return recollirCotxe(matricula, model);  // entra al swithc seleciona el ti`o que llama al metodo adecuado y devuelve al case 1 principal 
                case Furgoneta:
                    return recollirFurgoneta(matricula, model);
                case Microbus:
                    return recollirMicrobus(matricula, model);
                case Camió:
                    return recollirCamion(matricula, model);// no coresponde
       //default pendiente de eliminar usado para pruebas
                    default: 
            System.out.print("No valido");// en principio nunca podrá hacer el default
            return null;
            }
   }

    private Cotxe recollirCotxe(String matricula, String model) {
        double pma=0;
        int numPlaces =llegirNumPlazas(TipusVehicle.Cotxe); // Supongamos que tienes un método para esto
        int cilindres = llegirCilindres(TipusVehicle.Cotxe); 
        int centimetrosCubicos=llegirCentimetrosCubicos();
        double importe=Vehicle.calcularPrecio(cilindres, TipusVehicle.Cotxe, numPlaces, centimetrosCubicos, pma);      
            return new Cotxe(matricula, model, TipusVehicle.Cotxe, numPlaces, cilindres, centimetrosCubicos, importe);
    }
    private Microbus recollirMicrobus(String matricula, String model) {
        double pma=0;
        int numPlaces =llegirNumPlazas(TipusVehicle.Microbus); // Supongamos que tienes un método para esto
        int cilindres = llegirCilindres(TipusVehicle.Microbus); // Supongamos que tienes un método para esto
        int centimetrosCubicos=llegirCentimetrosCubicos();
        double importe=Vehicle.calcularPrecio(cilindres, TipusVehicle.Microbus, numPlaces, centimetrosCubicos, pma );
        
            return new Microbus(matricula, model, TipusVehicle.Microbus, numPlaces, cilindres, centimetrosCubicos, importe);
    }
    private Furgoneta recollirFurgoneta(String matricula, String model){      
        int numPlaces =0;
        int cilindres = llegirCilindres(TipusVehicle.Furgoneta);
        int centimetrosCubicos=0;//no se necesita para el importe
        double pma=llegirPMA();
        double importe=Vehicle.calcularPrecio(cilindres, TipusVehicle.Furgoneta, numPlaces, centimetrosCubicos, pma);     
            return new Furgoneta(matricula, model, TipusVehicle.Furgoneta, cilindres, centimetrosCubicos, pma, importe);
    }
    private Camion recollirCamion(String matricula, String model){
        int numPlaces =0;// no necesario para el importe
        int cilindres = llegirCilindres(TipusVehicle.Camió);
        int centimetrosCubicos=llegirCentimetrosCubicos();
        double pma=llegirPMA();
        double importe=Vehicle.calcularPrecio(cilindres, TipusVehicle.Camió, numPlaces, centimetrosCubicos, pma);      
            return new Camion(matricula, model, TipusVehicle.Camió, cilindres, centimetrosCubicos, pma, importe);
    }
    
    
    
    
    
    
    
    private String llegirMatricula(){  /*para hacer return co un bucle usar do while si no tengo problemas con los return*/
        Scanner input = new Scanner(System.in); 
        String matricula; 
        boolean salir2 =false;
            do{
            System.out.print("Introdueix la matrícula en format [1234abc]:  ");
                matricula=input.nextLine().toUpperCase();
                    if(matricula.matches(Vehicle.PATRO_MATRICULA)){
                    salir2=true;                             
                }else {
                System.out.println("La matrícula no té el format correcte.");
                }
            }    
            while(!salir2); 
                return matricula;                
    }  
    private String llegirModel(){
        Scanner input = new Scanner(System.in);
            System.out.print("Introdueix el model: ");
                String model=input.nextLine();
        return model;
    }
     private  TipusVehicle llegirTipus(){
       Scanner input = new Scanner(System.in);
       boolean salir2=false;
       int opcio=0;
        do{ System.out.println("Selecione el tipus de vehicle");
            System.out.println("1. Cotxe.  2. Furgoneta.  3. Camió.  4. Microbús.  ");
            System.out.print("Opcio : ");

           if (input.hasNextInt()){
           opcio=input.nextInt();
           }
            if (opcio<=4&&opcio>=1){
                   salir2=true;
               }
           else{
               System.out.println("Ha de introduir un valor entre 1 i 4.");
           }
            input.nextLine();
       }
       while(!salir2);
        return Vehicle.TipusSegonsIndex(opcio);  /*llama a vehiculo.almetodo(retorna el valor)*/
   } 
   private int llegirCilindres(TipusVehicle tipusVehicle) {
    Scanner input = new Scanner(System.in);
    int cilindres=0;
    boolean salir2=false;
    if(tipusVehicle == TipusVehicle.Cotxe || tipusVehicle == TipusVehicle.Microbus ){     
        while (!salir2) {
            System.out.print("Introdueix el nombre de cilindres de "+tipusVehicle+" entre 2 i 6:");
                if(input.hasNextInt()){
                    cilindres =input.nextInt();
                if (cilindres >= 2 && cilindres <= 6) {
                    salir2=true;
                    } else {
                        input.nextLine();
                        System.out.println("Número de cilindres no vàlid. Ha d'estar entre 2 i 6.");
                        }
                }else{
                    System.out.println("Número de cilindres no vàlid. Ha d'estar entre 2 i 6.");
                    input.nextLine();
                }
        }
    }
    if(tipusVehicle == TipusVehicle.Furgoneta){      
        while (!salir2) {
            System.out.print("Introdueix el nombre de cilindres de "+tipusVehicle+" entre 4 i 10: ");
            if(input.hasNextInt()){
                    cilindres =input.nextInt();
                if (cilindres >= 4 && cilindres <= 10) {
                    salir2=true;
                    } 
                    else{
                        input.nextLine();
                        System.out.println("Número de cilindres no vàlid. Ha d'estar entre 4 i 10.");
                    }
                
            }else{
                    System.out.println("Número de cilindres no vàlid. Ha d'estar entre 4 i 10.");
                    input.nextLine();
                }
        }
    }
    if(tipusVehicle == TipusVehicle.Camió){      
        while (!salir2) {
            System.out.print("Introdueix el nombre de cilindres de "+tipusVehicle+" entre 8 i 16: ");
            if(input.hasNextInt()){
                    cilindres =input.nextInt();
                if (cilindres >= 8 && cilindres <= 16) {
                    salir2=true;
                    } 
                    else{          
                        System.out.println("Número de cilindres no vàlid. Ha d'estar entre 8 i 16.");
                        input.nextLine();
                    }
            }else{
                    System.out.println("Número de cilindres no vàlid. Ha d'estar entre 8 i 16.");
                    input.nextLine();
                }
        }
    }  
    return cilindres;
    }
   private int llegirNumPlazas(TipusVehicle tipusVehicle){
       Scanner input = new Scanner(System.in);
    int numPlaces=0;
    boolean salir2=false;
        if(tipusVehicle==TipusVehicle.Cotxe ){
            while(!salir2){
                System.out.print("Introdueix un nombre de places entre 2 i 7: ");
                if(input.hasNextInt()){
                    numPlaces=input.nextInt();
                    if(numPlaces >= 2 && numPlaces <=7){
                        salir2=true;
                    }
                    else{
                        System.out.println("Número de places no vàlid. Ha d'estar entre 2 i 7.");
                        input.nextLine();
                    }
                }else{
                    System.out.println("Número de places no vàlid. Ha d'estar entre 2 i 7.");
                    input.nextLine();
                }
            }
        }
        if(tipusVehicle==TipusVehicle.Microbus ){
            while(!salir2){
                System.out.print("Introdueix un nombre de places entre 2 i 20: ");
                if(input.hasNextInt()){
                    numPlaces=input.nextInt();
                    if(numPlaces >= 2 && numPlaces <=20){
                        salir2=true;
                    }
                    else{
                        System.out.println("Número de places no vàlid. Ha d'estar entre 2 i 20.");
                        input.nextLine();
                    }
                }else{
                    System.out.println("Número de places no vàlid. Ha d'estar entre 2 i 20.");
                    input.nextLine();
                }
            }
        }
        return numPlaces;
       
   }
   
    private int llegirCentimetrosCubicos(){
        Scanner input = new Scanner(System.in);
        int centimetrosCubicos=0;
        boolean salir2=false;
            while(!salir2){
                System.out.print("Introduïu els Centímetres Cúbics del vehicle: ");
                 if(input.hasNextInt()){
                     centimetrosCubicos=input.nextInt();
                     if(centimetrosCubicos>0){
                     salir2=true;
                     }
                     else{
                        System.out.println("Error. Heu de introduir una dada correcta.");
                        input.nextLine();
                    }
                 }else{
                     System.out.println("Error. Heu de introduir una dada correcta.");
                     input.nextLine();
                 }
            }
   return centimetrosCubicos;
   }
    private double llegirPMA(){
        Scanner input = new Scanner(System.in);
        double pma=0;
        boolean salir2=false;
            while(!salir2){
                System.out.print("Introduïu el Pes Màxim Autoritzat del vehicle en tones: ");
                 if(input.hasNextDouble()){
                     pma=input.nextDouble();
                     if(pma>0){
                     salir2=true;
                     }
                     else{
                        System.out.println("Error. Heu de introduir una dada correcta..");
                        input.nextLine();
                    }
                 }else{
                     System.out.println("Error. Heu de introduir una dada correcta.");
                     input.nextLine();
                 }
            }
   return pma;
   } 
   

   private Box llegirBox(){
  Scanner input = new Scanner(System.in);
       boolean salir2=false;
       int opcio=0;
        do{ System.out.println("Seleccioneu un box del 1 al 6.");
            System.out.print("Opcio : ");

           if (input.hasNextInt()){
           opcio=input.nextInt();
           }
            if (opcio<=6&&opcio>=1){
                   salir2=true;
               }
           else{
               System.out.println("Ha de introduir un valor entre 1 i 6.");
           }
            input.nextLine();
       }
       while(!salir2);
       
       return Boxs[opcio-1]; //seleciona el box deseado entre el 1 y el 6 LE TENGO QUE RESTAR 1 PARA QUE COJA LA OPCION CORRECTA EN EL ARRAY
   }
   
  public void mostrarBoxs() {
        for (int i=0; i<Boxs.length;i++) {
            Box box = Boxs[i];
            box.mostrar();
        }
  }
  public boolean obtenerRespuestaUsuario() {
        Scanner input = new Scanner(System.in);
        boolean entradaCorrecta = false;
        char respuesta = '0';

        do {
            System.out.println("Desitja pagar el primer vehicle de la cua?");
            System.out.println("Sí, premeu 's'. No, premeu 'n'.");
            System.out.print("s/n: ");
            String entrada = input.nextLine().toLowerCase(); // Convertir a minúsculas para que fu tanto 'S' como 's'
            
            if (entrada.length() == 1) {
                respuesta = entrada.charAt(0);
                if (respuesta == 's') {
                    return true;
                } else {
                    return false;
                }
            } else {
                System.out.println("Entrada no vàlida. Si us plau, introdueix 's' o 'n'.");
            }
        } while (!entradaCorrecta);

        return false;
    }

  
    public void inicio(){
         Scanner input = new Scanner (System.in);
         Menu menu = new Menu();
         boolean pararEjecutar = false;
         while(!pararEjecutar){
         menu.mostrar();
         int opcio=menu.llegirOpcio();
            switch (opcio){
                case 1:
                   /*creo nuevo vehiculo||con el metodo que lo crea*/
                    Vehicle nuevoVehiculo=recollirVehicle();
                 //   System.out.println("nuevo vehiculo  mas getImporte  = "+nuevoVehiculo.getimporte()+" €");
                    /*llamo a cuaInicial con el metodo que añade vehiculos y con el objeto entre los parentesis*/
                    /*ahegir vehicle necesita tener en los parentesis el constructo (Vehicle vehicle )*/
                    /*para poder recibir nuevovehicle*/
                    if(!cuaInicial.conteMatrcicula(nuevoVehiculo.getMatricula())){//en el parentesis recibe el objeto que interactua con conte matricula
                    cuaInicial.afegirVehicle(nuevoVehiculo, "cua inicial");
                    cuaInicial.mostrarCua();
                    }
                    else{
                    cuaInicial.mostrarCua();
                    }
                    break;
                case 2:
                    if(!cuaInicial.estaBuida()){
                        Box box=llegirBox(); //creo el objeto box devolviendole con leer box el box selecionado.
                            if(box.estaLliure()){           
                            box.afegirVehicle(cuaInicial.traure());
                            box.mostrar();
                            }else{
                                 System.out.println("No es pot anyadir. La primera fase del box "+box.getId()+" està ocupada.");
                                  
                            }
                     }else{
                         System.out.println("La cua inicial està buida.");                        }      
                    break; 
                case 3:
                   Box boxAMoure=llegirBox(); 
                   if(!boxAMoure.tieneVehiculoUltima()){
                   pendientesPago.afegirVehicle(boxAMoure.pasarVehiclesDeFase(), "Pendents pagament");
                   }else{
                   boxAMoure.pasarVehiclesDeFase();    
                   }
                   boxAMoure.mostrar(); 
                   
                    break; 
                case 4:
                   llegirBox().mostrar(); 
                    break; 
                case 5:
                    mostrarBoxs();
                    break; 
                case 6:
                    
                    if(!pendientesPago.estaBuida()){
                    pendientesPago.mostrarCuaPaga();
                        if(obtenerRespuestaUsuario()){
                        Vehicle vPagaYsale=pendientesPago.traure();
                        totalCobrado += vPagaYsale.getimporte();//   vPagaYsale.getimporte();
                            System.out.println("------------------------------");
                            System.out.println("Vehicle      : "+vPagaYsale);
                            System.out.println("Import total :     "+vPagaYsale.getimporte()+" €");
                            System.out.println("PAGAT. ABANDONA LA COLA.");
                            System.out.println("¡BON VIATGE!");
                            System.out.println("------------------------------");
                            }else {   
                                System.out.println("------------------------------");
                                System.out.println("Operació cancelada");
                                System.out.println("------------------------------");
                            }
                        }else {   
                            System.out.println("------------------------------");
                            System.out.println("La de pagaments està buida.");
                            System.out.println("------------------------------");
                        }
                    break; 
                case 7:
                     System.out.println("------------------------------");
                     System.out.println("La quantitat total recaptada ascendeix a : "+totalCobrado+" €");
                     System.out.println("------------------------------");
                    break; 
                case 8:
                    System.out.println("Programa fnalizat.");
                    pararEjecutar=true;
                    break;     
            }           
        }    
    }
    
    public static void main(String[] args ){
    new Taller().inicio();
    }
}