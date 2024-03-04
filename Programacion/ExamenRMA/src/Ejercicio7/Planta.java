package Ejercicio7;

/**
 *
 * @author RamónMorenoAlbert
 */
public class Planta {
    private String nombre;
    private int altura;

    public Planta(String nombre, int altura) throws NombreInvalido, AltutaInvalida{
        if (nombre.length()<3){
            throw new NombreInvalido("El nombre de la planta no puede tener menos de tres caracteres. " +nombre) ;
        }
         if (altura<0){
            throw new AltutaInvalida("La altura no pùede ser un número negativo. " +altura) ;
        }
        this.nombre = nombre;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreInvalido{
         if (nombre.length()<3){
            throw new NombreInvalido("El nombre de la planta no puede tener menos de tres caracteres. "+nombre) ;
        }
        this.nombre = nombre;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) throws AltutaInvalida{
        if (altura<0){
            throw new AltutaInvalida("La altura no pùede ser un número negativo. "+altura) ;
        }
        this.altura = altura;
    }
    
    

}
