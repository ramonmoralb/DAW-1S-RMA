package Cua;
import java.util.ArrayList;
public class Cua {
    private ArrayList<Object> objetos; 
    public Cua(){
        objetos = new ArrayList<>();
    }
    public boolean estaBuida(){
        return objetos.isEmpty();
    }
    public int getTamany(){
        return objetos.size();
    }
    public Object primer(){
        if(estaBuida()){
            System.out.println("La cua està buida");
            return null;
        }else {
        return objetos.get(0);
        }
    }
    public Object traure(){
        if(estaBuida()){
            System.out.println("La cua està buida");
            return null;
        }else{
        return objetos.remove(0);
        }
    }
    public void afegir(Object pobject){
        objetos.add(pobject);      // por defecto si no se le especifica indice añade después del último
    }
    public void mostrar(){
        for(Object aux : objetos){ 
            System.out.println(aux); 
        }
    }
    public void mostrarSinForLoop(){
        for(int i =0; i<objetos.size();i++){
            System.out.println(objetos.get(i)); 
        }
    }
}
