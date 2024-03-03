package Ejercicio2;
import  ExcepcionesEjerecicio2.*;
/**
 * @author Ramon
 */
public class Perro {
    private String nombre;
    private int edad;
    
    public Perro(String nombre, int edad)throws NombreInvalido,EdadInvalida{
        if(edad<0){
            throw new EdadInvalida("La edad no puede ser inferior a 0 años.");
        }
        if(nombre.length()<3){
            throw new EdadInvalida("El nombre no puede tener menos de tres caracteres.");
        }
        this.nombre=nombre;
        this.edad=edad;
        System.out.println("El perro se ha creado.");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws NombreInvalido{
         if(nombre.length()<3){
            throw new NombreInvalido("El nombre no puede tener menos de tres caracteres.");
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad)throws EdadInvalida{
         if(edad<0){
            throw new EdadInvalida("La edad no puede ser inferior a 0 años.");
        }
        this.edad = edad;
    }
}
