package Ejercicio5y6;

/**
 *
 * @author ciclost
 */
public class LibroAlquilabe extends Libros implements Alquilable{
    private double precioDia;
    private boolean alquilado;
    private String nombreCliente;
    private int dias;

    public LibroAlquilabe( String codIsbm, String titulo, int numPaginas, int numEdicion, double precioDia) {
        super(codIsbm, titulo, numPaginas, numEdicion);
        this.precioDia = precioDia;
        this.alquilado = false;
        this.nombreCliente = "";
        this.dias = 0;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    
    
    
    
    
    @Override
    public double alquilar(String nombreCliente, int dias) {
         if(!alquilado){
             this.alquilado=true;
             this.nombreCliente=nombreCliente;
             this.dias=dias;
             
                System.out.println("El libro se ha alquilado correctamente");
             
             return precioDia*IVA*dias;
            
         }
         else{
           System.out.println("El libro no se puede alquilar puesto que ya lo está.");
           return 0;   
         }
         
    }

    @Override
    public void devolver(){
        if(alquilado){
            this.alquilado = false;
            this.nombreCliente = "";
            this.dias = 0;
            
                System.out.println("El libro se ha devuelto correctamente");
            
        }
        else{
               System.out.println("El libro no se puede devolver puesto que no está alquilado");

        }
    }
     @Override
    public void mostraInfo() {
                System.out.println("El libro con codigo ISBM: "+getCodIsbm()+ " y título "+getTitulo()+" esta alquilado a "+getNombreCliente()+" por "+getDias()+" por un importe de "+
                      (precioDia*IVA*dias)+"€."  );

    }   
    
    
    
}
