package Ejercicio1;
/**
 * @author Ramón
 */
public abstract class Vehiculo {
    protected String matricula;
    protected String modelo;
   
        public Vehiculo(String matricula, String modelo){
            this.matricula=matricula;
            this.modelo=modelo;
        }

    public String getMatricula() {
        return matricula;
    }
/*  --desabolitado puesto la mátricula pide el ejercicio que no pueda ser modificada
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
*/
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public abstract void   imprimir();
}