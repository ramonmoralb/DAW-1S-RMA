
package itv2;

/**
 * @author Ramón
 */
import java.util.Scanner;
import itv2.util.GestorIO;
public class Taller {
    private Box Boxs[];
    private CuaInicial cuaInicial;
    private static final int NUM_BOXS = 6;    
        public Taller(){
            this.Boxs = new Box[Taller.NUM_BOXS]; //longitud del array
                for(int i = 0; i<Boxs.length; i++){   //este array crea los objetos 6 boxes
                    Boxs[i]=new Box(i+1); //el id de cada Boxs
                }                         
            this.cuaInicial = new CuaInicial();
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
                    
                    /*llamo a cuaInicial con el metodo que añade vehiculos y con el objeto entre los parentesis*/
                    /*ahegir vehicle necesita tener en los parentesis el constructo (Vehicle vehicle )*/
                    /*para poder recibir nuevovehicle*/
                    if(!cuaInicial.conteMatrcicula(nuevoVehiculo.getMatricula())){//en el parentesis recibe el objeto que interactua con conte matricula
                    cuaInicial.afegirVehicle(nuevoVehiculo);
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
                                 System.out.println("No es pot anyadir. La primera fase del box esta ocupada");
                                  
                            }
                     }else{
                         System.out.println("La cua Inicial està buida");                        }      
                    break; 
                case 3:
                   Box boxAMoure=llegirBox();
                   boxAMoure.pasarVehiclesDeFase();
                   boxAMoure.mostrar();           
                    break;
                case 4:
                   llegirBox().mostrar();
                    break; 
                case 5:
                    mostrarBoxs();
                    break; 
                case 6:
                    System.out.println("Programa fnalizat.");
                    pararEjecutar=true;
                    break;   
            }
            
         }    
    }
    private Vehicle recollirVehicle(){
        Vehicle vehicle = new Vehicle(llegirMatricula(), llegirModel(), llegirTipus());/*se puede meter el metodo en los atributos*/
        return vehicle;
       
    }
    private String llegirMatricula(){  /*para hacer return co un bucle usar do while si no tengo problemas con los return*/
        Scanner input = new Scanner(System.in); 
        String matricula;
        boolean salir2 =false;
            do{
            System.out.print("Introduce la matricula [1234aaa] :  ");
                matricula=input.nextLine().toUpperCase();
                    if(matricula.matches(Vehicle.PATRO_MATRICULA)){
                    salir2=true;                             
                }else {
                System.out.println("La matricula no tiene el formato correcto.");
                }
            }    
            while(!salir2); 
                return matricula;                
    }
    
    private String llegirModel(){
        Scanner input = new Scanner(System.in);
            System.out.print("Introduce el modelo : ");
                String model=input.nextLine();
        return model;
    }
   private  TipusVehicle llegirTipus(){
       Scanner input = new Scanner(System.in);
       boolean salir2=false;
       int opcio=0;
        do{ System.out.println("Selecione el tipus de vehicle");
            System.out.println("1. Cotxe.  2. Furgoneta.  3. Camió  4. Microbús.  5.  Altre.  ");
            System.out.print("Opcio : ");

           if (input.hasNextInt()){
           opcio=input.nextInt();
           }
            if (opcio<=5&&opcio>=1){
                   salir2=true;
               }
           else{
               System.out.println("Debe introducir un valor entre 1 y 5.");
           }
            input.nextLine();
       }
       while(!salir2);
        return Vehicle.TipusSegonsIndex(opcio);  /*llama a vehiculo.almetodo(retorna el valor)*/
   } 
   private Box llegirBox(){
  Scanner input = new Scanner(System.in);
       boolean salir2=false;
       int opcio=0;
        do{ System.out.println("Selecione un box del 1 al 6.");
            System.out.print("Opcio : ");

           if (input.hasNextInt()){
           opcio=input.nextInt();
           }
            if (opcio<=6&&opcio>=1){
                   salir2=true;
               }
           else{
               System.out.println("Debe introducir un valor entre 1 y 6.");
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

    
    public static void main(String[] args ){
    new Taller().inicio();
    }
}