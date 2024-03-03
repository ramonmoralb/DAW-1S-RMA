package Ejercicio1;
/**
 * @author Ramón
 */
public class VehiculoAcuatico extends Vehiculo{
    private int eslora;
    
    public VehiculoAcuatico (String matricula, String modelo, int eslora){
        super(matricula, modelo);
        this.eslora=eslora;
    }

    public int getEslora() {
        return eslora;
    }

    public void setEslora(int eslora) {
        this.eslora = eslora;
    }

    @Override
    public void imprimir(){
        System.out.println("Información del vheiculo acuático: \n"
                + "Matrcícula = "+getMatricula()
                + "\nModelo     = "+getModelo()
                + "\nEslora en Mt = "+getEslora());
        System.out.println("------------------------------------------");
    }
    
}
