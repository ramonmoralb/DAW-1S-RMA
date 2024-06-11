import java.util.Scanner;
public class U3Activitat2RMA {
 public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int valorIntroducido=0;
        int tamaño;

        System.out.print("Introdueix la mida de la matriu: ");
        while(!input.hasNextInt()||(valorIntroducido=input.nextInt())<0){
            input.nextLine();
        }
        input.close();
        tamaño=valorIntroducido;     
        int[][] matriz = new int[tamaño][tamaño];
        // Llenar la matriz con 0s y 1s de manera aleatoria
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                int valorAleatorio = (int) (Math.random() * 2); // Genera aleatoriamente 0 o 1.
                matriz[fila][columna] = valorAleatorio;
            }
        }

        //  la matriz 
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                System.out.print(matriz[fila][columna]);
            }
            System.out.println(); // importante si no agrgas el salto de linea no imprime matriz , sino todo juntp
        }

        // cintador de unos de cada fila
       
        int maximoContadorFila = 0;
        boolean hayUnosEnFilas = false; 

        // Primero, encuentra el máximo número de 1s en una fila y verifica si hay al menos un "1".
        for (int fila = 0; fila < tamaño; fila++) {
            int contador = 0;
            for (int columna = 0; columna < tamaño; columna++) {
                contador += matriz[fila][columna];
            }

            if (contador > maximoContadorFila) {
                maximoContadorFila = contador;
            }

            if (contador > 0) {
                hayUnosEnFilas = true;
             //   System.out.println("Fila " + fila + ": " + contador);  //   compruebp que coincide
            }
        }

        // Verificar si la matriz solo contiene ceros en las filas
        if (!hayUnosEnFilas) {
            System.out.println("La matriu només té zeros.");
        } else {
            // print todas las filas con el mayor numero de unos
          
            for (int fila = 0; fila < tamaño; fila++) {
                int contador = 0;
                for (int columna = 0; columna < tamaño; columna++) {
                    contador += matriz[fila][columna];
                }
                if (contador == maximoContadorFila) {
                    System.out.println("1.  Fila " + fila + " amb major nombre " + maximoContadorFila + ", 1s.");
                }
            }
        }

        // contador de 1 en columnas
        int maximoContadorColumna = 0;
        boolean hayUnosEnColumnas = false;

        // busvo los unos admás de comprobar que hay.
        for (int columna = 0; columna < tamaño; columna++) {
            int contador = 0;
            for (int fila = 0; fila < tamaño; fila++) {
                contador += matriz[fila][columna];
            }

            if (contador > maximoContadorColumna) {
                maximoContadorColumna = contador;
            }

            if (contador > 0) {
                hayUnosEnColumnas = true;
            }
        }

        // compruebo si solo tien 0 
        if (!hayUnosEnColumnas) {
            System.out.println("La matriu només conte zeros en les columnes");
        } else {
            // Luego, imprime todas las columnas que coinciden con el máximo número de 1s
            for (int columna = 0; columna < tamaño; columna++) {
                int contador = 0;
                for (int fila = 0; fila < tamaño; fila++) {
                    contador += matriz[fila][columna];
                }
                if (contador == maximoContadorColumna) {
                    System.out.println("2.  Columna " + columna + " amb major nombre " + maximoContadorColumna + ",  1s.");
                }
            }
        }

        // Verificar si hay filas con valores repetidos
        boolean filasConValoresRepetidos = false;

        for (int fila = 0; fila < tamaño; fila++) {
            boolean filaRepetida = true;
            for (int columna = 1; columna < tamaño; columna++) {
                if (matriz[fila][columna] != matriz[fila][0]) {
                    filaRepetida = false;
                }
            }

            if (filaRepetida) {
                System.out.println("3.  La fila " + fila + "té tots el valors iguals.");
                filasConValoresRepetidos = true;
            }
        }

        if (!filasConValoresRepetidos) {
            System.out.println("3.  No hi ha files amb el mateixos numeros.");
        }

        // columnas repetida?
        boolean columnasConValoresRepetidos = false;
        for (int columna = 0; columna < tamaño; columna++) {
            boolean columnaRepetida = true;
            for (int fila = 1; fila < tamaño; fila++) {
                if (matriz[fila][columna] != matriz[0][columna]) {
                    columnaRepetida = false;
                }
            }
            if (columnaRepetida) {
                System.out.println("4.  La columna " + columna + " té tots els valors iguals.");
                columnasConValoresRepetidos = true;
            }
        }
        if (!columnasConValoresRepetidos) {
            System.out.println("4.  No hi ha columnes amb el mateixos números.");
        }
        // comprobar si la doagonal mayor tiene los valores iguales
        int primerValorDiagonal = matriz[0][0];
        boolean diagonalPrincipalRepetida = true;

        for (int i = 1; i < tamaño; i++) {
            if (matriz[i][i] != primerValorDiagonal) {
                diagonalPrincipalRepetida = false;
            }
        }
        if (diagonalPrincipalRepetida) {
            System.out.println("5.  La diagonal major té tots els valor iguals.");
        } else {
            System.out.println("5.  La diagonal major no té tots els valors iguals.");
        }
        // compruebo si la dubdiagonal es igual
        int primerValorSubdiagonal = matriz[1][0];
        boolean subdiagonalRepetida = true;

        for (int i = 2; i < tamaño; i++) {
            if (matriz[i][i - 1] != primerValorSubdiagonal) {
                subdiagonalRepetida = false;
            }
        }

        if (subdiagonalRepetida) {
            System.out.println("6.  La subdiagonal té tods els valors iguals.");
        } else {
            System.out.println("6.  La subdiagonal no té tots els valors iguals.");
        }
    }
}
