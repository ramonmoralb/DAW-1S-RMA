import java.util.Scanner;

public class U4Activitat1RMA {
    public static void main(String[] args) {
        U4Activitat1RMA programa = new U4Activitat1RMA();
        programa.inicio();
    }

    public void inicio() {
        boolean salir2 = false;
        String palabraRamdon = generarPalabra();
        String palabraIntroducida;
        
        while (!salir2) {
            palabraIntroducida = leerTexto();
          //  imprimirPalabra(palabraRamdon, palabraIntroducida);
            pista(palabraRamdon, palabraIntroducida);

            if (palabraRamdon.equals(palabraIntroducida)) {
                salir2 = true;
            }
        }
        imprimirGanar();
    }

    public String generarPalabra() {
        String palabraRamdon = "";
        for (int i = 0; i < 5; i++) {
            int numeroAleatorio = (int) (Math.random() * 26);
            char letra = (char) ('a' + numeroAleatorio);
            palabraRamdon = palabraRamdon + letra;
        }
        return palabraRamdon;
    }

    public void imprimirPalabra(String palabraRamdon, String palabraIntroducida) {
        System.out.println("Palabra aleatoria =" + palabraRamdon);
        System.out.println("Palabra intro =" + palabraIntroducida);
    }

    public String leerTexto() {
        Scanner input = new Scanner(System.in);
        boolean salir = false;
        String palabraIntroducida = "";

        System.out.print("Introduce una respuesta de 5 letras minusculas: ");
        while (!salir) {
            palabraIntroducida = input.nextLine();
            palabraIntroducida = palabraIntroducida.toLowerCase();

            if (palabraIntroducida.length() == 5 && palabraIntroducida.matches("[a-z]+")) {
                salir = true;
            } else {
                System.out.print("Introduce una respuesta de 5 letras minusculas: ");
            }
        }

        return palabraIntroducida;
    }

    public void pista(String palabraRamdon, String palabraIntroducida) {
        System.out.print("[ ");
        for (int i = 0; i < 5; i++) {
            if (palabraRamdon.indexOf(palabraIntroducida.charAt(i)) != -1 && palabraRamdon.indexOf(palabraIntroducida.charAt(i)) != i) {
                System.out.print("-");
            } else if (palabraRamdon.charAt(i) == palabraIntroducida.charAt(i)) {
                System.out.print("0");
            } else {
                System.out.print("X");
            }
        }
        System.out.print(" ]");
        System.out.println();
    }

    public void imprimirGanar() {
        System.out.println("Has acertado!");
    }
}
