package model;

public class Oficina {
    private int oficina;
    private String ciutat;
    private int superficie;
    private double vendes;

    public Oficina(int oficina, String ciutat, int superficie, double vendes) {
        this.oficina = oficina;
        this.ciutat = ciutat;
        this.superficie = superficie;
        this.vendes = vendes;
    }

    public int getOficina() {
        return oficina;
    }

    public void setOficina(int oficina) {
        this.oficina = oficina;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public double getVendes() {
        return vendes;
    }

    public void setVendes(double vendes) {
        this.vendes = vendes;
    }
 
    @Override
    public String toString() {
        return "Oficina[" +
               "oficina=" + oficina +
               ", ciutat=" + ciutat + 
               ", superficie=" + superficie +
               ", vendes=" + vendes +
               "]\n";
    }    
}
