package Ejercicio5y6;

/**
 *
 * @author RamónMorenoAlbert
 */
public class Digitales extends Materiales{
    private int mb;

    public Digitales(String codIsbm, String titulo, int mb ) {
        super(codIsbm, titulo);
        this.mb = mb;
    }

    public int getMb() {
        return mb;
    }

    public void setMb(int mb) {
        this.mb = mb;
    }

    @Override
    public void mostraInfo() {
                System.out.println("Material digital con codigo ISM = "+getCodIsbm()+ " de título " +getTitulo()+" y las siguientes páginas: "+getMb()+".");

    }   
}
