
package TresEnRaya;

/**
 *
 * @author Ramon
 */
public class Tablero {
    private estadoCasilla casilla[][];  // se crea el tablero co las dimensiones deseadas
    public static final int DIMENSION  =3;
   
    
    public Tablero(){
        this.casilla=new estadoCasilla[DIMENSION][DIMENSION];  
        vaciarTablero();
       /**contructor del tablero con las casillas en estado vacio**/             
    }
    
  public void mostrar() {
    System.out.println(); //linea superior
    System.out.println("       1   2   3"); // numeros columan

    for (int i = 0; i < DIMENSION; i++) {
        System.out.print("   "+(i + 1) +"   " ); // numero fila
        for (int j = 0; j < DIMENSION; j++) {
            System.out.print(casilla[i][j] + "   "); // espacar mas
        }
        System.out.println(); // salto de linea despues de las filas
    }
    System.out.println();  //linea inferior
}

    public void vaciarTablero(){
        for(int i = 0; i<DIMENSION; i++){
            for(int j = 0; j<DIMENSION; j++){
                casilla[i][j]=estadoCasilla.v;
            }
        }    
    }
    public void ponerFicha(Coordenada coordenada, estadoCasilla situacionCasilla) {
        casilla[coordenada.getFila()][coordenada.getColumna()] = situacionCasilla;
    }

   public boolean estaOcupada(Coordenada coordenada) { 
        int fila = coordenada.getFila();
        int columna = coordenada.getColumna();
            return casilla[fila][columna] != estadoCasilla.v;
        /**comprueba si la casilla esta ocupada
         *devuelve true si la casilla esta ocupada indistintivamente del jugador
         **/
   }
   public boolean estaLleno() { 
        for(int i =0;i< DIMENSION; i++){
            for(int j =0;j< DIMENSION; j++){
                if(casilla[i][j]==estadoCasilla.v){        // si en alguna posicion la casilla esta vacia hace return        
                    return false;
                }
            }  
        }
        System.out.println("---------------------------"  );
        System.out.println("------------EMPATE----------"  );
          
        return true;           
   }
   public boolean hayTresEnRaya(){
            //compruebo 0
            for (int i = 0; i < DIMENSION; i++) { // compruebo lineas
                if (casilla[i][0] == estadoCasilla.O && casilla[i][1] == estadoCasilla.O && casilla[i][2] == estadoCasilla.O){  
                    return true;
                } 
            }    
            for (int j = 0; j < DIMENSION; j++) {  //compruebo columnas
                 if (casilla[0][j] == estadoCasilla.O && casilla[1][j] == estadoCasilla.O && casilla[2][j] == estadoCasilla.O) {
                     return true;
                 }
            } 
            //diagonales
            if (casilla[0][0] == estadoCasilla.O && casilla[1][1] == estadoCasilla.O && casilla[2][2] == estadoCasilla.O) {
                return true;
            }
            if (casilla[0][2] == estadoCasilla.O && casilla[1][1] == estadoCasilla.O && casilla[2][0] == estadoCasilla.O) {
                    return true;
            }
            
           //compruebo x 
            for (int i = 0; i < DIMENSION; i++) { // compruebo lineas
                if (casilla[i][0] == estadoCasilla.X && casilla[i][1] == estadoCasilla.X && casilla[i][2] == estadoCasilla.X){  
                    return true;
                } 
            }    
            for (int j = 0; j < DIMENSION; j++) {  //compruebo columnas
                 if (casilla[0][j] == estadoCasilla.X && casilla[1][j] == estadoCasilla.X && casilla[2][j] == estadoCasilla.X) {
                     return true;
                 }
            } 
            //diagonales
            if (casilla[0][0] == estadoCasilla.X && casilla[1][1] == estadoCasilla.X && casilla[2][2] == estadoCasilla.X) {
                return true;
            }
            if (casilla[0][2] == estadoCasilla.X && casilla[1][1] == estadoCasilla.X && casilla[2][0] == estadoCasilla.X) {
                    return true;
            }           

           return false; // devuelve falso si no hay tres en raya     
    }
}
