package TresEnRaya;

import java.util.Scanner;
public class TresEnRaya {
    private Tablero tablero;
    private Jugador[] jugadores;
    private Turno turno;
    private boolean terminaJuego=false;
    
    public TresEnRaya() {
        this.tablero = new Tablero();
        this.jugadores = new Jugador[2];
        this.jugadores[0] = new Jugador(estadoCasilla.X); // iniccializo el array con cada jugador especifico
        this.jugadores[1] = new Jugador(estadoCasilla.O);
        this.turno = new Turno();
    }
   private void realizarJugada() {
    Jugador jugadorActual;
    boolean comprobarEstado=false; //sale del while para cambiar al jugador y el bucle del inicio vuelve a realizar la jugadaInicial
        if (turno.toca() == 0) {
                jugadorActual = jugadores[0];
            }else {
                jugadorActual = jugadores[1];
        }  
        while(!comprobarEstado){
            if(!tablero.estaLleno() || !tablero.hayTresEnRaya()){  // entra si el tablero esta vacio o no hay tres en raya
            System.out.println("Turno de jugador color:  ".toUpperCase()+jugadorActual.getColor());  // imprime al jugador
            Coordenada coordenada = jugadorActual.recogerCoordenadaValida(tablero); //lee la coordenada y la alamcena en la variable
                if(!tablero.estaOcupada(coordenada)){  // comprueba si la casilla está disponible con el condicional           
                    tablero.ponerFicha(coordenada, jugadorActual.getColor()); //el metodo recibe la coordenada y el jugador
                    turno.cambiarTurno();//cambia el turno a cada iteraccion
                    comprobarEstado=true;  // cambia el valor para salir del bucle, !! el metodo realizarJugada() se repite por el bucle del void inicio cuando empieza el bucle el valor vuelve a false. Por eso cambia el jugador
                }else{
                    System.out.println("La casilla situada en la [fila: "+(coordenada.getFila()+1)+"] y [columa: "+(coordenada.getColumna()+1)+"] está ocupada."  );
                }
  
                if(tablero.hayTresEnRaya()){ // importante poner delante el tres hay tres en raya  de lo contarrio cantaria empate en la ultima jugada la entrar primero el if de tablero lleno
                    tablero.mostrar();
                    jugadorActual.cantarVictoria(); 
                    terminaJuego=volverJugar();
                
                }        
                if(tablero.estaLleno()){  
                    tablero.mostrar();
                    terminaJuego=volverJugar();         
                }
            } 
        }
    }
  
private boolean volverJugar() {  //este metodo cambia el valor del boolean del while del inicio cuando empatan o ganan pregunta si se desea seguir jugando
    Scanner input = new Scanner(System.in);
    boolean salir = false;
    boolean volverAJugar = true;

    while (!salir) {
        System.out.println("¿Desean volver a jugar?");
        System.out.println("Pulse [s] para si, para no pulse [n]");
        System.out.print("[s/n]: ");
        if (input.hasNextLine()) {
            String respuesta = input.nextLine().toLowerCase();
            if (respuesta.length() == 1) {
                char primeraLetra = respuesta.charAt(0);
                if (primeraLetra == 's') {
                    volverAJugar = false;
                    tablero.vaciarTablero();
                    salir = true;
                } else if (primeraLetra == 'n') {
                    volverAJugar = true;
                    salir = true;
                } else {
                    System.out.println("Valor incorrecto.");                
                }
            }else {
                    System.out.println("Valor incorrecto.");                
                }
        }
    }
    return volverAJugar; 
}

    public void inicio() {
        System.out.println("**********************.");
        System.out.println("*****TRES EN RAYA*****.");
        System.out.println("**********************.");
                
       // el while repite y de este modo la jugada va cambiando de jugador cuando empieza el metodo puesto que dentro de realizar jugada está el metodo cambiar();
        while(!terminaJuego){
            tablero.mostrar();
            realizarJugada();
        }      
    }    
    public static void main(String[] args) {
        TresEnRaya programa = new TresEnRaya();
        programa.inicio();
    }    
}
