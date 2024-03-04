package Ejercicio5y6;

/**
 *
 * @author RamóMorenoAlbert
 */
public class Revistas extends Impresos{
    private String periodicidad;

    public Revistas( String codIsbm, String titulo, int numPaginas, String periodicidad) {
        super(codIsbm, titulo, numPaginas);
        this.periodicidad = periodicidad;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }
      @Override
    public void mostraInfo() {
                System.out.println("Material mpreso de tipo libro con codigo ISM = "+getCodIsbm()+ 
                        " de título " +getTitulo()+" y las siguientes páginas: "+getNumPaginas()+" y con una periodicidad: "+getPeriodicidad()+" .");

    }   
    
}
