/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Departament;
import java.util.ArrayList;

/**
 *
 * @author jmas
 */
public class DepartamentsDAO {
    public static ArrayList<Departament> getDepartaments(){
        ArrayList<Departament> resultat = new ArrayList<>();
        resultat.add(new Departament("RRHH", 965474418));
        resultat.add(new Departament("Comercial", 945788413));
        resultat.add(new Departament("Comptabilitat", 965778941));
        resultat.add(new Departament("Informàtica", 965558733));
        resultat.add(new Departament("Producció", 944784115));
        return resultat;
    }
    
}
