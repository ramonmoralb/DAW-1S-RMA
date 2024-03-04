package Ejercicio5y6;

/**
 *
 * @author RamónMorenoAlbert 
 */
public class Ebooks extends Digitales{
    private String formato;

    public Ebooks( String codIsbm, String titulo, int mb, String formato) {
        super(codIsbm, titulo, mb);
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public void mostraInfo() {
        System.out.println("Material digital con codigo ISM = "+getCodIsbm()+ " de título " +getTitulo()+" y las siguientes páginas: "+getMb()+
                "con un formato en: "+getFormato());
    }
    
    
}
