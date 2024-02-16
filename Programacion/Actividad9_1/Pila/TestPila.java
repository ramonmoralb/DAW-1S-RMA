
package Pila;
public class TestPila {
    public void inicio(){
        Pila pila = new Pila(); 
        pila.afegir("String"); 
        pila.afegir(true);
        pila.afegir(1714);
        pila.mostrar1();
        System.out.println(pila.cima());
        System.out.println(pila.getTamany());
    }
    public static void main(String[] args){
        TestPila test = new TestPila();
        test.inicio();
    }
}
