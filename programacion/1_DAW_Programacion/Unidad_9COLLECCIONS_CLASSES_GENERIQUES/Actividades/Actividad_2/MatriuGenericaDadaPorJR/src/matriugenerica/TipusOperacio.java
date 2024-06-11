/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriugenerica;

/**
 *
 * @author jmas
 */
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
