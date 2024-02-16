package Cua;
public class TestCua {
    public void inicio(){
        Cua cua = new Cua();
        cua.traure();
        cua.afegir("Ramón");
        cua.afegir(17);
        cua.afegir(7==7);
        cua.afegir(19.445);
        cua.afegir(true);
        cua.afegir(7>=9);
        cua.mostrar();
        cua.traure();
        cua.afegir("Ramón Moreno");
        cua.mostrarSinForLoop();     
    }
    public static void main(String[] args){
        TestCua tcua = new TestCua();
        tcua.inicio();
    }
}
