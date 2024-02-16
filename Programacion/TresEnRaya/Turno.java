package TresEnRaya;
/**
 * @author Ramon
 */
import java.util.Random;
public class Turno {
    private Random random;
    private int valor;
    public Turno(){
        this.random= new Random();
        this.valor= random.nextInt(2); // crea un numero aleatorio entre 0 y 1.
    }
    public int toca(){ //este metodo devuelve el valor generado para establecer el turno inicial,
        return valor;
    }
    public int noToca(){  // lo usaré para cambiar el turno en el metodo cambiarTurno();
        if(valor==0){
            return 1;
        }else{
            return 0;
        }
    }
    public void cambiarTurno(){ // cambio de turno
        valor=noToca();
    }
    
}
