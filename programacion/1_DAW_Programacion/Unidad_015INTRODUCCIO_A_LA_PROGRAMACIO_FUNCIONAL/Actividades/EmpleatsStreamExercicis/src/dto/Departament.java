/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import dao.EmpleatsDAO;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author jmas
 */
public class Departament {
    private final String nom;
    private final int telefon;

    public Departament(String nom, int telefon) {
        this.nom = nom;
        this.telefon = telefon;
    }
    

    public String getNom() {
        return nom;
    }

    public int getTelefon() {
        return telefon;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departament other = (Departament) obj;
        return Objects.equals(this.nom, other.nom);
    }

    @Override
    public String toString() {
        return "Departament{" + "nom=" + nom + ", telefon=" + telefon + '}';
    }

    public ArrayList<Empleat> getEmpleatsNoUsar(){
        ArrayList<Empleat> llista = new ArrayList<>();
        for(Empleat e: EmpleatsDAO.getEmpleats()){
            if(e.getDepartament().equals(this)){
                llista.add(e);
            }
        }
        return llista;
    }

    
}
