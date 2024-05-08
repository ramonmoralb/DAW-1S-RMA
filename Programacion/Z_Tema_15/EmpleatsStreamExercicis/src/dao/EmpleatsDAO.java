/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Departament;
import dto.Empleat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmas
 */
public class EmpleatsDAO {
    public static ArrayList<Empleat> getEmpleats(){
        ArrayList<Departament> departaments = DepartamentsDAO.getDepartaments();
        ArrayList<Empleat> resultat = new ArrayList<>();
        resultat.add(new Empleat("14928186", "Cara", "Magot", 34, new ArrayList<>(List.of("ESO", "Batxillerat")), departaments.get(2)));
        resultat.add(new Empleat("83609570", "Roderic", "Took-Brandybuck", 21, new ArrayList<>(List.of("ESO", "CFGM")), departaments.get(0)));
        resultat.add(new Empleat("04236571", "Alfrida", "Brockhouse", 25, new ArrayList<>(List.of("ESO", "Batxillerat", "CFGS")),departaments.get(3)));
        resultat.add(new Empleat("44457800", "Hildibrand", "Bolger", 83, new ArrayList<>(List.of("Llicenciatura")), departaments.get(0)));
        resultat.add(new Empleat("36989746", "Lavinia", "Hayward", 35, new ArrayList<>(List.of("ESO", "Batxillerat", "Llicenciatura")), departaments.get(1)));
        resultat.add(new Empleat("31313047", "Linda", "Zaragamba", 19, new ArrayList<>(List.of("CFGB", "CFGM")), departaments.get(3)));
        resultat.add(new Empleat("24312294", "Hildifons", "Gardner", 26, new ArrayList<>(List.of("CFGB", "CFGM", "CFGS")),  departaments.get(2)));
        resultat.add(new Empleat("27513846", "Semolina", "Boffin", 46, new ArrayList<>(List.of("ESO", "CFGM", "CFGS", "Llicenciatura")), departaments.get(3)));
        
        
        return resultat;
    }
    
}
