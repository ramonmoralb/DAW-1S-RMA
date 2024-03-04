package Ejercicio5y6;

/**
 *
 * @author RamonMorenoAlbert
 */
public interface Alquilable {
    double IVA=1.04;
    
    double alquilar(String nombreCliente, int dias);
    
    public void devolver();
}
