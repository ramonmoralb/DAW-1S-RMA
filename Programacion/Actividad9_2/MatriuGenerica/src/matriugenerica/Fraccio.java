
package matriugenerica;


public class Fraccio extends Number {
    private int numerador;
    private int denominador;
    
    public Fraccio (int numerador, int denominador){
        this.numerador=numerador;
        
        
        if (denominador==0){
            throw new IllegalArgumentException("El denominador no puede ser 0.");
        }
        this.denominador=denominador;
    }
   @Override
    public int intValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long longValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public float floatValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double doubleValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public int getNumerador(){
        return numerador;
    }
     public int getDenominador(){
        return denominador;
    }
    
    
    public Fraccio suma(Fraccio fraccio){
        int denominador= (this.denominador * fraccio.getDenominador());
        int numerador =(this.numerador*fraccio.getDenominador())+(this.denominador*fraccio.getDenominador());
       
        return new Fraccio (numerador,denominador);               
    }
    public Fraccio multipicacio(Fraccio fraccio){
        return new Fraccio (numerador,denominador);
    }
    @Override
    public String toString(){
        return numerador +"/"+denominador;
    }
    
    
}