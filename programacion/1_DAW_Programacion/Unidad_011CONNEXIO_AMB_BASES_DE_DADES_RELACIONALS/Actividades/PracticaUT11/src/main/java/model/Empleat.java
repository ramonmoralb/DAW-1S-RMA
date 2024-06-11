package model;

import java.time.LocalDate;

public class Empleat {
    private int numemp;
    private String nom;
    private int edat;
    private int oficina;
    private String ocupacio;
    private LocalDate contracte;

    public Empleat(int numemp, String nom,int edat, int oficina, String ocupacio, LocalDate contracte) {
        this.numemp = numemp;
        this.nom = nom;
        this.edat=edat;
        this.oficina = oficina;
        this.ocupacio = ocupacio;
        this.contracte = contracte;
    }
    public int getEdat(){
        return edat;
    }
    public void setEdat(int edat){
        this.edat=edat;
    }
    public int getNumemp() {
        return numemp;
    }

    public void setNumemp(int numemp) {
        this.numemp = numemp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getOficina() {
        return oficina;
    }

    public void setOficina(int oficina) {
        this.oficina = oficina;
    }

    public String getOcupacio() {
        return ocupacio;
    }

    public void setOcupacio(String ocupacio) {
        this.ocupacio = ocupacio;
    }

    public LocalDate getContracte() {
        return contracte;
    }

    public void setContracte(LocalDate contracte) {
        this.contracte = contracte;
    }
    
    
    @Override
    public String toString(){
        return "Empleat Num: "+numemp+" - "+
                "Nombre : "+nom+" - "+
                "Edat : "+edat+" - "+
                "Oficina : "+oficina+" - "+
                "Ocupacio : "+ocupacio+" - "+
                "Contracte "+contracte+"\n"
                ;
    }
   
}
