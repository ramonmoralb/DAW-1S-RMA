package Pila;
import java.util.ArrayList;
public class Pila {
    private ArrayList<Object> objetos;
    
    public Pila(){
        objetos = new ArrayList<>();
    }
    public boolean estaBuida(){
       return objetos.isEmpty();
    }
    public int getTamany(){
        return objetos.size();
    }
    public Object cima(){
        if (!estaBuida()) {
            return objetos.get(objetos.size() - 1);
        }
        System.out.println("La pila está vacia");
        return null; // Pila vacía
    }
    public Object traure(){
        if(estaBuida()){
            System.out.println("La pila está vacia");
            return null;
        }else{
            return objetos.remove(0);
        }
    }
    public void afegir(Object pelemeto){
        objetos.add(pelemeto);
    }
    public void mostrar() {
        for (Object elemento : objetos) {
            System.out.println(elemento);
        }
        /*for-each loop*/
    }
    public void mostrar1() {
        for (int i = 0; i<objetos.size();i++) {  
            System.out.println(objetos.get(i));
        }
        /*a los elementos cuando se usa arraylit utiliza el metodo get(index:) para acceder
        * en lugar de objetos[] */
                                                               
    }
    
   
    
}
