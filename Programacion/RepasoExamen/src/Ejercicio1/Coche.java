package Ejercicio1;
/**
 *
 * @author Ramón
 */
public class Coche extends VehiculoTerrestre{
    private boolean aireAcondicionado;
    
    public Coche(String matricula, String modelo,int ruedas, boolean aireAcondicionado){
        super(matricula, modelo, ruedas);
        this.aireAcondicionado=aireAcondicionado;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }
    
    
    
    @Override
    public void imprimir(){
        String aire="";
        
        if(aireAcondicionado){
            aire="equipado";          
        }
        if(!aireAcondicionado){
            aire="no equipado";
        }
         System.out.println("Información del vheiculo terrestre: \n"
                + "Matrcícula = "+getMatricula()
                + "\nModelo     = "+getModelo()
                + "\nNum Ruedas = "+getRuedas()
                + "\nDe tipo coche con aire acondicionado "+aire );
        System.out.println("------------------------------------------");

    }
    
}
