/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author jmas
 */
public class Empleat {
    private final String dni;
    private final String nom;
    private final String cognoms;
    private final int edat;
    private final ArrayList<String> titols;
    private final Departament departament;

    public Empleat(String dni, String nom, String cognoms, int edat, ArrayList<String> titols, Departament departament) {
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        this.edat = edat;
        this.titols = titols;
        this.departament = departament;
    }



    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public int getEdat() {
        return edat;
    }

    public Departament getDepartament() {
        return departament;
    }

    public ArrayList<String> getTitols() {
        return titols;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.dni);
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
        final Empleat other = (Empleat) obj;
        return Objects.equals(this.dni, other.dni);
    }

    @Override
    public String toString() {
        return "Empleat{" + "dni=" + dni + ", nom=" + nom + ", cognoms=" + cognoms + ", edat=" + edat + ", titols=" + titols + ", departament=" + departament + '}';
    }

     
}
