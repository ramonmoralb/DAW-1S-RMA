package Ejercicio1;
/**
 *
 * @author Ramón
 */
public class Submarino extends VehiculoAcuatico{
    private int profundidaMax;
    
    public Submarino(String matricula, String modelo, int eslora, int profundidaMax ){
        super(matricula, modelo, eslora);
        this.profundidaMax=profundidaMax;
    }

    public int getProfundidaMax() {
        return profundidaMax;
    }

    public void setProfundidaMax(int profundidaMax) {
        this.profundidaMax = profundidaMax;
    }
    
     @Override
    public void imprimir(){
        System.out.println("Información del vheiculo acuático: \n"
                + "Matrcícula = "+getMatricula()
                + "\nModelo     = "+getModelo()
                + "\nEslora en Mt = "+getEslora()
                + "\nProfundidad máxima = "+getProfundidaMax());
        System.out.println("------------------------------------------");
    }
    
}
