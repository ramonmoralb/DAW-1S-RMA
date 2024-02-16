
package matriugenerica;


public enum TipusOperacio {
    SUMA, MULTIPLICACIO, RES;
    
    public String simbolOperacio() {
        switch(this) {
            case SUMA:
                return "+";
            case MULTIPLICACIO:
                return "X";
            case RES:
                return "";
            default:
                return null;
        }
    }
}
