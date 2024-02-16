package matriugenerica;

import java.util.Random;

public abstract class MatriuGenerica<T extends Number> {

    // Matrius implicades en l'última operació realitzada
    private T[][] matriuOpEsquerra;
    private T[][] matriuOpDreta;

    private TipusOperacio tipusUltimaOperacio;

    // Matriu resultat
    private T[][] matriu;

    public MatriuGenerica(int tamany) {
        Random random = new Random();

        this.matriu = (T[][]) new Number[tamany][tamany];
        for (int i = 0; i < this.matriu.length; i++) {
            for (int j = 0; j < this.matriu[i].length; j++) {
            this.matriu[i][j] = aleatori();            }
        }

        this.matriuOpEsquerra = null;
        this.matriuOpDreta = null;
        this.tipusUltimaOperacio = TipusOperacio.RES;
    }

    public abstract T suma(T a, T b);

    public abstract T multiplicacio(T a, T b);

    public abstract T zero();

    public abstract T aleatori();

    public void sumar(T[][] matriu) throws MatriuException {
        T[][] resultat = (T[][]) new Number[this.matriu.length][this.matriu[0].length];

        for (int i = 0; i < resultat.length; i++) {
            for (int j = 0; j < resultat[i].length; j++) {
                resultat[i][j] = suma(this.matriu[i][j], matriu[i][j]);
            }
        }

        this.matriuOpEsquerra = this.matriu;
        this.matriuOpDreta = matriu;
        this.matriu = resultat;
        this.tipusUltimaOperacio = TipusOperacio.SUMA;
    }

    public void multiplicar(T[][] matriu) throws MatriuException {
        T[][] resultat = (T[][]) new Number[this.matriu.length][matriu[0].length];

        for (int i = 0; i < resultat.length; i++) {
            for (int j = 0; j < resultat[i].length; j++) {
                resultat[i][j] = zero();

                for (int k = 0; k < this.matriu[0].length; k++) {
                    resultat[i][j] = suma(resultat[i][j], multiplicacio(this.matriu[i][k], matriu[k][j]));
                }
            }
        }

        this.matriuOpEsquerra = this.matriu;
        this.matriuOpDreta = matriu;
        this.matriu = resultat;
        this.tipusUltimaOperacio = TipusOperacio.MULTIPLICACIO;
    }

    public void imprimirUltimaOperacio() {
        for (int i = 0; i < matriuOpEsquerra.length; i++) {
            for (int j = 0; j < matriuOpEsquerra[0].length; j++) {
                System.out.print(" " + matriuOpEsquerra[i][j]);
            }

            if (i == matriuOpEsquerra.length / 2) {
                System.out.print(" " + this.tipusUltimaOperacio.simbolOperacio() + " ");
            } else {
                System.out.print("   ");
            }

            for (int j = 0; j < matriuOpDreta.length; j++) {
                System.out.print(" " + matriuOpDreta[i][j]);
            }

            if (i == matriuOpEsquerra.length / 2) {
                System.out.print(" = ");
            } else {
                System.out.print("   ");
            }

            for (int j = 0; j < matriu.length; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("");
    }
}