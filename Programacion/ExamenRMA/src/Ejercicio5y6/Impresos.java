package Ejercicio5y6;

/**
 *
 * @author RamónMorenoAlbert 
 */
public class Impresos extends Materiales {
    private int numPaginas;

    public Impresos(String codIsbm, String titulo, int numPaginas) {
        super(codIsbm, titulo); 
        this.numPaginas=numPaginas;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public void mostraInfo() {
        System.out.println("Material impreso con codigo ISM = "+getCodIsbm()+ " de título " +getTitulo()+" y las siguientes páginas: "+getNumPaginas()+".");
        
    }
    
   
    
}
