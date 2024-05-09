/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.*;
import dto.Empleat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import dto.Departament;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collector;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import java.util.stream.IntStream;

/**
 *
 * @author jmas
 */
public class Main {

    public static void main(String[] args) {
        List<Departament>  listaDepartamentos = DepartamentsDAO.getDepartaments(); // creo la listaDedeparpamentos !! producción no contiene empleados
        List<Empleat> listaDeEmpleados = EmpleatsDAO.getEmpleats();  // creo la lista de empleados
      /*        System.out.println("Lista original de empleados: ");
        for (Empleat e : listaDeEmpleados) { // con salto de linea
            System.out.println(e);
        }
        System.out.println();
        */
        //muestro la lista con stream
        System.out.println("Lista de empleados con programación funcional: ");
        listaDeEmpleados.stream()
                //.map(e -> e)  // no hace falta mapear, ya tiene toda la lista
                .forEach(System.out::println)              
                ;
        System.out.println();

        
        
        /*
        System.out.println("Lista de departamentos: ");  //muestra todos los departamentos, hasta producción que está vacio
        for (Departament e : listaDepartamentos) {        
               System.out.println("Nombre departamento: "+e.getNom());   //  
               System.out.println(e.getEmpleatsNoUsar());
        }
        System.out.println();
        System.out.println("----------------------------");
        */
        
        System.out.println("Lista departamentos c0n programación funcional");
        listaDepartamentos.stream()
                .forEach(System.out::println) 
                ;
        System.out.println();
        System.out.println("----------------------------");
        
        

        // 1.- Imprimeix el primer empleat trobat amb més de 50 anys
        System.out.println("1. Primero mayor de 50:");
        listaDeEmpleados.stream()  // 
                .filter(e -> e.getEdat() > 50) // la condición
                .findFirst() // el primero que queda de la condición  
                .ifPresent(e -> System.out.println(e)) // devuelve un optional, por eso el if present            
                ;
        System.out.println();
        System.out.println("----------------------------");
        

        // 2. Imprimeix true si tots els empleats son majors d'edat i false en cas contrari
        System.out.println("2. Imprimeix true si tots els empleats son majors d'edat i false en cas contrari");
        final  boolean mayoresDeEdad = listaDeEmpleados.stream()  // meto en un boolean la lista, por eso tengo que buscar metodos que devuelvan true or false
                .allMatch(e -> e.getEdat() >= 18); 
        System.out.println("Mayores de edad: " + mayoresDeEdad);
        System.out.println();
        System.out.println("----------------------------");
        
        // 3. Imprimeix true si hi ha algun empleat major de 65 anys i false en cas contrari
        System.out.println("3. Imprimeix true si hi ha algun empleat major de 65 anys i false en cas contrari");
        final boolean hayMayores65 = listaDeEmpleados.stream()
                .anyMatch(e -> e.getEdat() > 65);  // devuelve un boolean 
        System.out.println("Mayores de 65 en la lista: " + hayMayores65);
        System.out.println();
        System.out.println("--------------");


        // 4. Imprimeix el número d'empleats que tenen més de 50 anys
        System.out.println("Empleados mayores de 50: " + listaDeEmpleados.stream()  //lo puedo meter todo dentro de un print o como count devuelve un long hacer la constante e imprimirla
                .filter(e -> e.getEdat() > 50)
                .count()
        );
        System.out.println();
        
        final long  CANTIDADMAYORES50 = listaDeEmpleados.stream()
                .filter(e -> e.getEdat() > 50)
                .count()
                ;
        System.out.println("Empleados mayores de 50 con constante: "+ CANTIDADMAYORES50);
        System.out.println();
        System.out.println("--------------");
        
        // 5. Imprimeix el nom dels empleats del departament d'informàtica, en majúscules.
        System.out.println("5. Imprimeix el nom dels empleats del departament d'informàtica, en majúscules.");
        listaDeEmpleados.stream()
                .filter(e -> e.getDepartament().getNom().equals("Informàtica"))
                .map(e -> e.getNom()) //equivalente 
                //.map(Empleat::getNom)  //
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println();
        System.out.println("--------------");

        
        // 6. Imprimeix la quantitat de lletres de l'empleat d'informàtica amb el nom més llarg.
        System.out.println("6. Imprimeix la quantitat de lletres de l'empleat d'informàtica amb el nom més llarg.");
        listaDeEmpleados.stream()
                .filter(e -> e.getDepartament().getNom().equals("Informàtica"))
                .map(Empleat::getNom)
                .mapToInt(m -> m.length())
                .max()
                .ifPresent(System.out::println);
        System.out.println();
        
        
        // 7. Imprimeix el nom dels departaments que comencen per C
        System.out.println("7. Imprimeix el nom dels departaments que comencen per C");
        listaDeEmpleados.stream()
                .map(e -> e.getDepartament().getNom())
                .filter(n -> n.startsWith("C"))
                .forEach(System.out::println);
        System.out.println();
        System.out.println("-----------------");
        
        // 8. Imprimeix la suma de totes les edats dels empleats
        System.out.println("8. Imprimeix la suma de totes les edats dels empleats");
        final int SUMA_EDADES = listaDeEmpleados.stream()
                .mapToInt(e -> e.getEdat())
                .sum();
        System.out.println("Todas las edades de la lista suman: " + SUMA_EDADES);
        System.out.println();
        System.out.println("-----------------");

        // 9 UTILITZA EL MÈTODE GETEMPLEATS DE LA CLASSE DEPARTAMENT (NOMÉS PER A L'EXERCICI 9 I 10)
        // Imprimeix la quantitat d'empleats de cada departament 
        System.out.println("9.  Imprimeix la quantitat d'empleats de cada departament");
              listaDepartamentos.stream() 
             .collect(Collectors.toMap(  departamento -> departamento.getNom() , departamento -> departamento.getEmpleatsNoUsar().size()))       
             .forEach((a,b) -> System.out.println("Departamento: "+ a +" número operarios  "+ b))
             ;
         
        
    /*    //sin usar el getEmpleats, de la clase departament, faltaría un departamento por que está vaccio y desde la lista de empleados no lo recupera
        Map<Departament, Long> empleadosPorDepartamento = listaDeEmpleados.stream()
                .collect(groupingBy(Empleat::getDepartament, counting())); //groupingby en un map, primer lugar clave y segundo el valor
        empleadosPorDepartamento.forEach((departamento, numero) -> System.out.println("Departamento: " + departamento + "  Empleados : " + numero));
        System.out.println();
      */  
        
      
        // 10. UTILITZANT EL MÈTODE GETEMPLEATS DE LA CLASSE DEPARTAMENT (NOMÉS PER A L'EXERCICI 9 I 10)
        // Imprimeix la llista de noms dels empleats del departament comercial i de comptatilitat (una única llista d'String)
        System.out.println("10. Imprimeix la llista de noms dels empleats del departament comercial i de comptatilitat (una única llista d'String)");
        listaDepartamentos.stream()
                .filter(e -> e.getNom().equals("Comptabilitat") || e.getNom().equals("Comercial"))
                .flatMap(d -> d.getEmpleatsNoUsar().stream())
                .toList() // no imprime los departamentos..
                //.collect(Collectors.toMap(d -> d.getNom() , d  -> d.getEmpleatsNoUsar()))
                //.forEach((a,b) -> System.out.println(a + b))
                ;
      
        
        
        
        System.out.println("----------------");
        List<String> departametosCyCo = listaDeEmpleados.stream()
                .filter(e -> e.getDepartament().getNom().equals("Comercial") || e.getDepartament().getNom().equals("Comptabilitat"))
                .map(e -> e.getNom())
                .toList();
        System.out.println(departametosCyCo);
        System.out.println();
        // 11. El mateix d'abans però mostra els noms ordenats alfabèticament.

        System.out.println("11. El mateix d'abans però mostra els noms ordenats alfabèticament");
        List<String> departametosCyCoalafa = listaDeEmpleados.stream()
                .filter(e -> e.getDepartament().getNom().equals("Comercial") || e.getDepartament().getNom().equals("Comptabilitat"))
                .map(e -> e.getNom())
                .sorted()   //  por defecto ordenalfabetico
               // .sorted(comparing(String::length)) // comparara la longitud
                .toList();
        System.out.println(departametosCyCoalafa);
        System.out.println();
        
        
        
        // 12. Mostra la mitjana d'edat dels empleats del departament d'informàtica.
        
        //para los del departamento de informatica
        listaDeEmpleados.stream()
                .filter(e -> e.getDepartament().getNom().equals("Informàtica"))
                .map(Empleat::toString)
                .forEach(System.out::println) 
                ;
        
//tambien puedo sacar la suma de las edades.
        System.out.println(listaDeEmpleados.stream()  // lo meto dentro del print y lo saco directamente, si no debería hacer una constante  final int SUMA ....
                .filter(e -> e.getDepartament().getNom().equals("Informàtica"))
                .mapToInt(Empleat::getEdat)
                .sum());
        
               
        
        
        //solución
        System.out.println("12. La media de edad de los empleados del departamentoo de informatica es: ");
        listaDeEmpleados.stream()
                .filter(e -> e.getDepartament().getNom().equals("Informàtica"))
                .mapToInt(Empleat::getEdat)
                .average()
                .ifPresent(System.out::print)  // average() devuelve un Optional por lo tanto metodos de optional
                ;
        System.out.println();
        
        
        // 13. Mostra un String que serà el resultat de concatenar la primera lletra de cada departament.
        
        // esto no devuelve un string pero muestra lo que pide
        System.out.println("13. Mostra un String que serà el resultat de concatenar la primera lletra de cada departament.");
            listaDeEmpleados.stream()
                .map(e -> e.getDepartament().getNom().charAt(0))
                .forEach(System.out::print)  // imprime directamente / pero no es un string
                ;
        System.out.println();
        
            //esto devuelve un string
        String primerasLetrasStr = listaDeEmpleados.stream()
                .map(e -> e.getDepartament().getNom().substring(0, 1))
                .collect(Collectors.joining())                
                ;
           System.out.println(primerasLetrasStr);
           System.out.println();
            
           //pruebas 
           String alimentos = Stream.of("Patatas","Tomates")
                   //.map(e -> e) //
                   .collect(Collectors.joining("\n", "Lista de compra: \n", "\nplease wait..... "))
                   ;
           System.out.println(alimentos);
           System.out.println();
           
      
        // 14. Mostra el número de telèfon més alt dels departaments.
        System.out.println("14. Mostra el número de telèfon més alt dels departaments.");
        Optional p = listaDeEmpleados.stream()
                .map(e -> e.getDepartament().getTelefon())
                .max((a,b)-> a.compareTo(b)) // esto irá iterando y guardando en a el valor máximo y comparandolo con la siguiente entrada del mapa
                //.ifPresent(System.out::println) // max() devuelve optional   
                ;
                p.ifPresent(System.out::println);  
        
        // 15. Mostra el departament complet amb el número de telèfon més alt.
        
        
        
        System.out.println();  
        
      listaDeEmpleados.stream()
              .map(e -> e.getDepartament())
              .max((a,b) -> a.getTelefon()-b.getTelefon()) 
              .ifPresent(System.out::print)   
              ;
        // 16. Sense fer ús del mètode "getEmpleats". Dels departament que tenen treballadors, mostrar el nom del departament i el nombre de treballadors que hi treballen.
       
        
        
        // 17A. Guarda en un Map un registre per a cada Departament (que tinga treballadors) que tinga associat com a valor la llista d'empleats d'eixe departament
        // 17B. Igual que l'anterior pero la llista no serà d'empleats sino del nom dels empleats
        // 17C. Igual que l'anterior pero amb els empleats ordenats alfabèticament
        // 18A. Obtín un Map que continga per a cada departament una llista d'enters grans (BigInteger) que es corresponguen amb les edats dels empleats d'eixe departament
        // 18B. El mateix que abans però en comptes de l'edat, el probable següent número primer
        // 19. Obtín un Map que continga per a cada departament l'empleat més jove.
        // 20. Obtín un String que continga el mateix que abans, amb el format "Departament1:Empleat1, Departament2:Empleat2 ..."
        // 21. Obtín un Map que conté com a clau el DNI dels empleats i com a valor el nom d'eixe empleat
        // 21. Obtín una llista d'Strings que continga DNI dels empleats i el nom d'eixe empleat amb el format DNI - Nom. Llista ordenada per DNI
        // 22A. Donat un array bidimensional d'Integer transformar-lo en un array unidimensional amb els mateixos valors:
        Integer[][] matriuInteger = {{3, 2, 5}, {0, -8, 7}, {9, 9, 6}};

        // 22B. Versió amb int[] en comptes d'Integer[]
        // 23. Guarda una llista amb els noms dels estudis de tots els empleats (de forma única), ordenats alfabèticament.
        // 24. Imprimeix per pantalla aquells empleats que tinguen un CFGS
        // 25. Mostra un empleat qualsevol que tinga una llicenciatura
        // 26. Mostra per a cada nom d'empleat la suma de les lletres dels seus titols
        // 27. Mostra el total de lletres dels titols (incloent duplicats) dels empleats
        // 28. Mostra l'empleat amb major quantitat de títols
        // 29A. Obtín una llista que continga 5 aleatoris entre 0 i 9 en format String
        // 29B. El mateix d'abans, però ara sense valors repetits.
        // 30. Crea un stream amb tots els números positius divisibles entre 3. Després filtra aquells que siguen quadrats perfectes. 
        // Després descarta els 5 primers valors obtinguts. Finalment mostra els 10 següents valors obtinguts
        // 31. A partir dels cognoms dels empleats imprimeix amb una operació intermèdia els cognoms sense transformar i després transformats en majúscules.
        // Finalment retorna el nombre d'empleats.
        // 32. Imprimeix el cognom dels empleats ordenats en ordre alfabètic invers.
        // 33. Obtín la suma dels títols de tots els empleats
        // 34. Obtín un String amb la concatenació dels títols d'aquells empleats que tinguen menys de 30 anys, separats per espais (sense duplicats)
        // 35A. Mostra el cognom del primer dels empleats trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra "No trobat"
        // ¿I si proves per a menors de 40?
        // 35B. Mostra el primer dels empleats (complet) trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra "No trobat"
        // ¿I si proves per a menors de 40?
        // 36. Obtín un LinkedHashSet dels títols que tenen tots els empleats.
        // 37. Obtín un Map amb dos claus, la primera tindrá com a valors una llista dels empleats amb el títol de CFGS i l'altra clau tindrá una llista amb els que no el tenen.
        // 38. A partir d'una llista d'String retorna la mateixa llista pero sense cadenes buides
        List<String> elementsOriginals = List.of("aigua", "", "llet", "oli", "", "  ", "lletuga");

        // 39. Obtín una cadena separada per comes basada en una llista determinada d'enters. 
        // Cada element ha d'anar precedit de la lletra 'p' si el nombre és parell i precedit de la lletra 'i' si el nombre és imparell. 
        // Per exemple, si la llista d'entrada és (3,44), la eixida hauria de ser 'i3, p44'.
        List<Integer> llistaEnters = List.of(9, 23, 4, 15);

        // 40.A partir dels empleats. Obtín un mapa que tinga com a clau el nom del departament i com a valor un altre mapa
        // Este segon mapa tindrà com a clau el cognom de l'empleat y com a valor la llista de títols que té.
        // EXTRA A: A partir d'un String retorna les lletres distintes que conté, separades per comes (només lletres, no espais ni números ni altres caracters)
        String frase1 = "Tinc un 8 en PROG";

        // EXTRA B: A partir d'un String retorna la quantitat de lletres distintes que conté (només lletres, no espais ni números ni altres caracters)
        // EXTRA C: Obtín un mapa que mostre com a clau cada lletra distinta del String, i com a valor la quantitat de vegades que apareix.
        // EXTRA D: Mostra la lletra amb major freqüencia d'aparicions, i el nombre d'aparicions d'eixa lletra.
    }

}
