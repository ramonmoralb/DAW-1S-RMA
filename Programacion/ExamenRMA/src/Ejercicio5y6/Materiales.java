
package Ejercicio5y6;

/**
 *
 * @author RamonMorenoAlbert
 */
public abstract class Materiales {
    private String codIsbm;
    private String titulo;
    
    public Materiales (String codIsbm, String titulo){
        this.codIsbm=codIsbm;
        this.titulo=titulo;
    }

    public String getCodIsbm() {
        return codIsbm;
    }

   

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public abstract void mostraInfo();
    
}
