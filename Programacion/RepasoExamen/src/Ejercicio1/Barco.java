package Ejercicio1;
/**
 * @author Ramóm
 */
public class Barco extends VehiculoAcuatico {
   private boolean motor;
   
   public Barco(String matricula, String modelo, int eslora, boolean motor){
       super(matricula, modelo, eslora);
       this.motor=motor;
   }

    public boolean isMotor() {
        return motor;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }
    
      @Override
    public void imprimir(){
        String motorEstado="motor =";
        if(motor){
            motorEstado +=" equipado";
        }
        if(!motor){
            motorEstado +=" sin equipar";
        }
        
        System.out.println("Información del vheiculo acuático: \n"
                + "Matrcícula = "+getMatricula()
                + "\nModelo     = "+getModelo()
                + "\nEslora en Mt = "+getEslora()
                + "\n"+motorEstado);
        System.out.println("------------------------------------------");
    }
}
