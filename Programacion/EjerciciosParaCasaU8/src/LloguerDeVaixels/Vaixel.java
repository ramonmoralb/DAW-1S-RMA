
package LloguerDeVaixels;
import java.util.Date;
/**
 *
 * @author RamonMorenoAlbert
 */
public abstract class Vaixel{  //Declaro Vaixel como abstract
    private String matricula;
    private int eslora;
    private Date fecFabri;
 
public abstract double factorCalculoPrecio();    

/*El método abstracto se usará según la condición
en cada clase que herede de Vaixel, de ese modo se podrá 
añadir la lógica necesaria según las necesidades*/
    
        public Vaixel (String matricula, int eslora, Date fecFabri){
            this.matricula=matricula;
            this.eslora=eslora;
            this.fecFabri=fecFabri;
        }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getEslora() {
        return eslora;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    public Date getFecFabri() {
        return fecFabri;
    }

    public void setFecFabri(Date fecFabri) {
        this.fecFabri = fecFabri;
    }
   
    
    
        
}
