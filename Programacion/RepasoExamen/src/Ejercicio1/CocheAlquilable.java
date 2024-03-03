package Ejercicio1;
/**
 *
 * @author Ramón
 */
public class CocheAlquilable extends Coche implements Alquilable{
    private boolean alquilado;
    private double precio;
    private int diasAlquiler;
    private String nombreCliente;
    
    public CocheAlquilable(String matricula, String modelo,int ruedas, boolean aireAcondicionado, double precio){
        super(matricula, modelo, ruedas, true);
        this.alquilado=false;
        this.precio=precio;
        this.diasAlquiler=0;
        this.nombreCliente="";
        
        
    }
    
    

    @Override
    public void alquilar(String nomCliente, int numDias) {
        if(!alquilado){
            double totalPrecio=numDias*this.precio*IVA;
            System.out.println("El coche con mátricula ["+getMatricula()+"] ha sido alquilado a "+nomCliente+" durante "+numDias+" días por una cantidad de "+totalPrecio);
            this.nombreCliente=nomCliente;
            this.diasAlquiler=numDias;
            this.alquilado=true;
        }
        else{
             System.out.println("El coche con mátricula ["+getMatricula()+"]no está disponible puesto que está alquilado");
        }
    }

    @Override
    public void devolverVehiculo() {
        if(alquilado){
            alquilado=false;
            System.out.println("El coche con mátricula ["+getMatricula()+"] ha sido devuelto correctmente");
        }
        else{
            System.out.println("El coche con mátricula ["+getMatricula()+"] no se puede devolver porque no está alquilado");
        }
    }
    
}
