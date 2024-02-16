package TresEnRaya;
/**
 * @author Ramon
 */
import java.util.Scanner;
public class Coordenada {
    private int fila;
    private int columna;
        public Coordenada(){   // constructor vacio¿ para poder inicializar el objeto sin pasarle parametros?
        } 
        public Coordenada(int fila, int columna){ // construcrtor lleno
            this.fila=fila;
            this.columna=columna;
        } 
        public int getFila(){
            return fila;
        }
        public int getColumna(){
            return columna;
        }
          public void leerCoordenada(){
             Scanner input= new Scanner(System.in);
                boolean salir=false;
                
                while(!salir){
                    System.out.print("Introduce una fila [1-3]: ");
                    if(input.hasNextInt()){
                        fila=input.nextInt();
                        if (fila >=1 && fila<=3){
                        salir=true;
                         
                        }
                        else{
                            input.nextLine();
                            System.out.println("Valor incorrecto.");
                        }
                    }
                    else{
                            input.nextLine();
                            System.out.println("Valor incorrecto.");
                    }
                }
                    salir=false;
                    while(!salir){
                    System.out.print("Introduce una columna [1-3]: ");
                    if(input.hasNextInt()){
                        columna=input.nextInt();
                        if (columna >=1 && columna<=3){
                        salir=true;
                        }
                        else{
                            input.nextLine();
                            System.out.print("Valor incorrecto.");
                        }
                    }
                    else{
                            input.nextLine();
                            System.out.print("Valor incorrecto.");
                    }
                }
                fila--;  //es necesario para que el valor que devuelva esta dentro del array 
                columna--;    // he intentado restarselo al getColumna() y getFila pero no se porque no funciona 
            }
            
}      