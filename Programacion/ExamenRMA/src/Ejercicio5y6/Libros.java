package Ejercicio5y6;

/**
 *
 * @author RamónMorenoAlbert
 */
public class Libros extends Impresos{
    private int numEdicion;

    public Libros(String codIsbm, String titulo, int numPaginas, int numEdicion) {
        super(codIsbm, titulo, numPaginas);
        this.numEdicion = numEdicion;
    }

    public int getNumEdicion() {
        return numEdicion;
    }

    public void setNumEdicion(int numEdicion) {
        this.numEdicion = numEdicion;
    }
    
     @Override
    public void mostraInfo() {
                System.out.println("Material impreso de tipo libro con codigo ISM = "+getCodIsbm()+ 
                        " de título " +getTitulo()+" y las siguientes páginas: "+getNumPaginas()+" y eedición número: "+getNumEdicion()+".");

    }   
}
