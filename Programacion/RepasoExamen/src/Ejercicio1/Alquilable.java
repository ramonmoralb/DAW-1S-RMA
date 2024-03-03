package Ejercicio1;
/**
 *
 * @author Ramón
 */
public interface Alquilable {
    final double  IVA =1.21;
    
  
    void alquilar(String nomCliente, int numDias);
    void devolverVehiculo();
}
