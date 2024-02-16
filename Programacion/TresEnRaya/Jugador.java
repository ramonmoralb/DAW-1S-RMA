package TresEnRaya;

/**
 * @author Usuario
 */

public class Jugador {
    private estadoCasilla color;
    
    public Jugador(estadoCasilla color){
        this.color = color; 
    }
    public estadoCasilla getColor(){
        return color;
    }
    public Coordenada recogerCoordenadaValida(Tablero tablero) {
         Coordenada coordenada = new Coordenada();
         coordenada.leerCoordenada();
         return coordenada;    
    }
     public void cantarVictoria() {
            
            System.out.println("---------------------------------------------------------------------");
            System.out.println("¡Enhorabuena! El jugador de color [" + color + "] ha hecho tres en raya. ¡Gana!");
            System.out.println("---------------------------------------------------------------------");
    }    
}
