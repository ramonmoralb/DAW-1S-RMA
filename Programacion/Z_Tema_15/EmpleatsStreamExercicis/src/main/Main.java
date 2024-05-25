/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.*;
import dto.Empleat;
import java.util.List;
import java.util.stream.Collectors;
import dto.Departament;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author jmas
 */
public class Main {

    public static void main(String[] args) {
        List<Departament> listaDepartamentos = DepartamentsDAO.getDepartaments(); // creo la listaDedeparpamentos !! producción no contiene empleados
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
                .forEach(System.out::println);
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
                .forEach(System.out::println);
        System.out.println();
        System.out.println("----------------------------");

        // 1.- Imprimeix el primer empleat trobat amb més de 50 anys
        System.out.println("1. Primero mayor de 50:");
        listaDeEmpleados.stream() // 
                .filter(e -> e.getEdat() > 50) // la condición
                .findFirst() // el primero que queda de la condición  
                .ifPresent(e -> System.out.println(e)) // devuelve un optional, por eso el if present            
                ;
        System.out.println();
        System.out.println("----------------------------");

        // 2. Imprimeix true si tots els empleats son majors d'edat i false en cas contrari
        System.out.println("2. Imprimeix true si tots els empleats son majors d'edat i false en cas contrari");
        final boolean mayoresDeEdad = listaDeEmpleados.stream() // meto en un boolean la lista, por eso tengo que buscar metodos que devuelvan true or false
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
        System.out.println("Empleados mayores de 50: " + listaDeEmpleados.stream() //lo puedo meter todo dentro de un print o como count devuelve un long hacer la constante e imprimirla
                .filter(e -> e.getEdat() > 50)
                .count()
        );
        System.out.println();

        final long CANTIDADMAYORES50 = listaDeEmpleados.stream()
                .filter(e -> e.getEdat() > 50)
                .count();
        System.out.println("Empleados mayores de 50 con constante: " + CANTIDADMAYORES50);
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
                .ifPresentOrElse(System.out::println, () -> System.out.println("No encontrado")); // 

        System.out.println();

        // 7. Imprimeix el nom dels departaments que comencen per C
        System.out.println("7. Imprimeix el nom dels departaments que comencen per C");
        listaDepartamentos.stream()
                .map(e -> e.getNom())
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
                .collect(Collectors.toMap(departamento -> departamento.getNom(), departamento -> departamento.getEmpleatsNoUsar().size()))
                .forEach((a, b) -> System.out.println("Departamento: " + a + " número operarios  " + b));

        // 10. UTILITZANT EL MÈTODE GETEMPLEATS DE LA CLASSE DEPARTAMENT (NOMÉS PER A L'EXERCICI 9 I 10)
        // Imprimeix la llista de noms dels empleats del departament comercial i de comptatilitat (una única llista d'String)
        System.out.println("10. Imprimeix la llista de noms dels empleats del departament comercial i de comptatilitat (una única llista d'String)");
        listaDepartamentos.stream()
                .filter(e -> e.getNom().equals("Comptabilitat") || e.getNom().equals("Comercial"))
                .map(r -> r.getEmpleatsNoUsar())
                .flatMap(d -> d.stream())
                .map(n -> n.getNom())
                .toList()
                .forEach(empleados -> System.out.println(empleados));
        System.out.println();
        System.out.println("--------------");

        // para imprimir departamentos puedo hacer un map que key departamento value lista emp
        System.out.println("Mapa que imprime los departamentos de contabilidad e comercial, con sus trabajadores:. ");
        listaDepartamentos.stream()
                .filter(e -> e.getNom().equals("Comptabilitat") || e.getNom().equals("Comercial"))
                .collect(Collectors.toMap(e -> e.getNom(), e -> e.getEmpleatsNoUsar()))
                .forEach((departamento, empleados) -> System.out.println("Departamento :  " + departamento + "\nNombre de los empleados:\n" + empleados));
        System.out.println();
        System.out.println("-----------------");

        // 11. El mateix d'abans però mostra els noms ordenats alfabèticament.
        System.out.println("11. El mateix d'abans però mostra els noms ordenats alfabèticament");
        listaDeEmpleados.stream()
                .filter(e -> e.getDepartament().getNom().equals("Comercial") || e.getDepartament().getNom().equals("Comptabilitat"))
                .map(e -> e.getNom())
                .sorted((a, b) -> a.compareTo(b))
                .toList()
                .forEach(empleado -> System.out.println(empleado));

        // 12. Mostra la mitjana d'edat dels empleats del departament d'informàtica.
        //para los del departamento de informatica
        listaDeEmpleados.stream()
                .filter(e -> e.getDepartament().getNom().equals("Informàtica"))
                .map(Empleat::toString)
                .forEach(System.out::println);

//tambien puedo sacar la suma de las edades.
        System.out.println(listaDeEmpleados.stream() // lo meto dentro del print y lo saco directamente, si no debería hacer una constante  final int SUMA ....
                .filter(e -> e.getDepartament().getNom().equals("Informàtica"))
                .mapToInt(Empleat::getEdat)
                .sum());

        //solución
        System.out.println("12. La media de edad de los empleados del departamentoo de informatica es: ");
        listaDeEmpleados.stream()
                .filter(e -> e.getDepartament().getNom().equals("Informàtica"))
                .mapToInt(Empleat::getEdat)
                .average()
                .ifPresent(System.out::print) // average() devuelve un Optional por lo tanto metodos de optional
                ;
        System.out.println();

        // 13. Mostra un String que serà el resultat de concatenar la primera lletra de cada departament.
        // esto no devuelve un string pero muestra lo que pide
        System.out.println("13. Mostra un String que serà el resultat de concatenar la primera lletra de cada departament.");
        listaDeEmpleados.stream()
                .map(e -> e.getDepartament().getNom().charAt(0))
                .distinct()
                .forEach(System.out::print) // imprime directamente / pero no es un string
                ;
        System.out.println();
        System.out.println("-----------------------------------------");
        //esto devuelve un string

        String primerasLetrasStr = listaDeEmpleados.stream()
                .map(e -> e.getDepartament().getNom().substring(0, 1))
                .collect(Collectors.joining());
        System.out.println(primerasLetrasStr);
        System.out.println();
        System.out.println("-----------------------------------------");

        // 14. Mostra el número de telèfon més alt dels departaments.
        System.out.println("14. Mostra el número de telèfon més alt dels departaments.");
        listaDeEmpleados.stream()
                .map(e -> e.getDepartament().getTelefon())
                .max((a, b) -> a.compareTo(b)) // esto irá iterando y guardando en a el valor máximo y comparandolo con la siguiente entrada del mapa
                .ifPresent(System.out::println) // max() devuelve optional   
                ;
        System.out.println();
        System.out.println("-----------------------------------------");

        // 15. Mostra el departament complet amb el número de telèfon més alt.
        System.out.println("15. Mostra el departament complet amb el número de telèfon més alt.");
        listaDeEmpleados.stream()
                .map(e -> e.getDepartament())
                .max((a, b) -> a.getTelefon() - b.getTelefon())
                .ifPresentOrElse(e -> System.out.println("El número mas alto es: " + e), () -> System.out.println("No encontrado"));

        // 16. Sense fer ús del mètode "getEmpleats". Dels departament que tenen treballadors, mostrar el nom del departament i el nombre de treballadors que hi treballen.      
        System.out.println("16. Sense fer ús del mètode \"getEmpleats\". Dels departament que tenen treballadors, mostrar el nom del departament i el nombre de treballadors que hi treballen.");
        listaDeEmpleados.stream()
                .map(Empleat::getDepartament)
                .collect(Collectors.groupingBy(Departament::getNom, Collectors.counting())) //la segunda parte del gropuingBy interactua con los valores de la primera
                .forEach((a, e) -> System.out.println("Departamento:  " + a + "\nNúmero de empleados: " + e));
        System.out.println("-----------------------------------------");
        System.out.println();

        // 17A. Guarda en un Map un registre per a cada Departament (que tinga treballadors) que tinga associat com a valor la llista d'empleats d'eixe departament
        System.out.println("17A. Guarda en un Map un registre per a cada Departament (que tinga treballadors) que tinga associat com a valor la llista d'empleats d'eixe departament");
        listaDeEmpleados.stream()
                //.map(Empleat::getDepartament)
                .collect(Collectors.groupingBy(e -> e.getDepartament().getNom(), Collectors.toList()))
                .forEach((a, e) -> System.out.println("Departamento:  " + a + "\nObjeto de empleados: " + e));
        System.out.println("-----------------------------------------");
        System.out.println();

        System.out.println("\n--------------------\n");

        // 17B. Igual que l'anterior pero la llista no serà d'empleats sino del nom dels empleats
        System.out.println("17B. Igual que l'anterior pero la llista no serà d'empleats sino del nom dels empleats");
        listaDeEmpleados.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartament().getNom(), Collectors.mapping(Empleat::getNom, Collectors.toList())))
                .forEach((a, e) -> System.out.println("Departamento:  " + a + "\nNombre de empleados: " + e));
        System.out.println("-----------------------------------------");
        System.out.println();

        // 17C. Igual que l'anterior pero amb els empleats ordenats alfabèticament
        System.out.println("17C. Igual que l'anterior pero amb els empleats ordenats alfabèticament");
        listaDeEmpleados.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartament().getNom(), Collectors.mapping(Empleat::getNom, Collectors.toList())))
                .forEach((a, e) -> System.out.println("Departamento:  " + a + "\nNombre de empleados: " + e.stream() // de la lista hago otro stream
                .sorted((palabra1, palabra2) -> palabra1.compareTo(palabra2))
                .collect(Collectors.toList())
        ));
        System.out.println("-----------------------------------------");
        System.out.println();
        // 18A. Obtín un Map que continga per a cada departament una llista d'enters grans (BigInteger) que es corresponguen amb les edats dels empleats d'eixe departament
        System.out.println(" 18A. Obtín un Map que continga per a cada departament una llista d'enters grans (BigInteger) que es corresponguen amb les edats dels empleats d'eixe departament");
        listaDeEmpleados.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartament().getNom(), Collectors.mapping(e -> BigInteger.valueOf(e.getEdat()), Collectors.toList())))
                .forEach((departamento, listaedades) -> System.out.println("departamento: " + departamento + " edades en big integer:  " + listaedades));
        System.out.println("-----------------------------------------");
        System.out.println();

        // 18B. El mateix que abans però en comptes de l'edat, el probable següent número primer
        System.out.println("18B. El mateix que abans però en comptes de l'edat, el probable següent número primer");
        listaDeEmpleados.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartament().getNom(), Collectors.mapping(e -> BigInteger.valueOf(e.getEdat()).nextProbablePrime(), Collectors.toList())))
                .forEach((departamento, listaedades) -> System.out.println("departamento: " + departamento + " Proximo numero primo edades en big integer:  " + listaedades));
        System.out.println("-----------------------------------------");
        System.out.println();

        // 19. Obtín un Map que continga per a cada departament l'empleat més jove.
        System.out.println("19. Obtín un Map que continga per a cada departament l'empleat més jove.");
        listaDeEmpleados.stream()
                .sorted((e, a) -> e.getEdat() - a.getEdat())
                .collect(Collectors.groupingBy(e -> e.getDepartament().getNom(), Collectors.collectingAndThen(Collectors.toList(), t -> t.get(0).getNom())))
                .forEach((a, b) -> System.out.println("Departamento :  " + a + "| empleado más joven :  " + b));
        System.out.println("-----------------------------------------");
        System.out.println();

        // 20. Obtín un String que continga el mateix que abans, amb el format "Departament1:Empleat1, Departament2:Empleat2 ..."
        System.out.println("20. Obtín un String que continga el mateix que abans, amb el format \"Departament1:Empleat1, Departament2:Empleat2 ...");
        Map<String, String> mapaEmleadoEdad = listaDeEmpleados.stream()
                .sorted((e, a) -> e.getEdat() - a.getEdat())
                .collect(Collectors.groupingBy(e -> e.getDepartament().getNom(), Collectors.collectingAndThen(Collectors.toList(), e -> e.get(0).getNom())));
        mapaEmleadoEdad.forEach((dpt, empleado) -> System.out.println("Departamento : " + dpt + "      ->   Empleado edad mínima : " + empleado));
        System.out.println("-----------------------------------------");
        System.out.println();
        //consultar otra manera que no seal el get, si el indice eta vacio el programa peta

        // 21. Obtín un Map que conté com a clau el DNI dels empleats i com a valor el nom d'eixe empleat
        System.out.println("21. Obtín un Map que conté com a clau el DNI dels empleats i com a valor el nom d'eixe empleat");
        listaDeEmpleados.stream()
                .collect(Collectors.toMap(Empleat::getDni, Empleat::getNom))
                .forEach((a, e) -> System.out.println(a + e));
        System.out.println("-----------------------------------------");
        System.out.println();

        // 21. Obtín una llista d'Strings que continga DNI dels empleats i el nom d'eixe empleat amb el format DNI - Nom. Llista ordenada per DNI
        System.out.println("21. Obtín una llista d'Strings que continga DNI dels empleats i el nom d'eixe empleat amb el format DNI - Nom. Llista ordenada per DNI");
        listaDeEmpleados.stream()
                .map(e -> e.getDni() + "---" + e.getNom())
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");
        System.out.println();

        // 22A. Donat un array bidimensional d'Integer transformar-lo en un array unidimensional amb els mateixos valors:
        System.out.println("22A. Donat un array bidimensional d'Integer transformar-lo en un array unidimensional amb els mateixos valors:");
        Integer[][] matriuInteger = {{3, 2, 5}, {0, -8, 7}, {9, 9, 6}};
        Stream.of(matriuInteger)
                .flatMap(aplanado -> Stream.of(aplanado))
                //  .map(String::valueOf)
                .toArray();
        System.out.println("-----------------------------------------");
        System.out.println();

        // 22B. Versió amb int[] en comptes d'Integer[]
        System.out.println(" 22B. Versió amb int[] en comptes d'Integer[]");
        int[][] matriuInt = {{3, 2, 5}, {0, -8, 7}, {9, 9, 6}};
        int s[] = Stream.of(matriuInt)
                .flatMapToInt(aplanadoInt -> Arrays.stream(aplanadoInt))
                .toArray();
        for (int i : s) {
            System.out.println("matriz de int :  " + i);
        }
        System.out.println("-----------------------------------------");
        System.out.println();

        // 23. Guarda una llista amb els noms dels estudis de tots els empleats (de forma única), ordenats alfabèticament.
        System.out.println("23. Guarda una llista amb els noms dels estudis de tots els empleats (de forma única), ordenats alfabèticament.");
        listaDeEmpleados.stream()
                .map(Empleat::getTitols)
                .flatMap(e -> e.stream())
                .distinct()
                //  .forEach(System.out::println)
                .toList();
        System.out.println("-----------------------------------------");
        System.out.println();

        // 24. Imprimeix per pantalla aquells empleats que tinguen un CFGS
        System.out.println("24. Imprimeix per pantalla aquells empleats que tinguen un CFGS");
        listaDeEmpleados.stream()
                .filter(e -> e.getTitols().contains("CFGS"))
                .map(Empleat::getNom)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");
        System.out.println();
        // 25. Muestra un empleado cualquiera que tenga una licenciatura
        System.out.println("25. Muestra un empleado cualquiera que tenga una licenciatura");
        listaDeEmpleados.stream()
                .filter(e -> e.getTitols().contains("Llicenciatura"))
                .findAny()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Nínguno está licenciado"));
        System.out.println("-----------------------------------------");
        System.out.println();
        // 26. Mostra per a cada nom d'empleat la suma de les lletres dels seus titols
        System.out.println("26. Mostra per a cada nom d'empleat la suma de les lletres dels seus titols");
        listaDeEmpleados.stream()
                .collect(Collectors.toMap(Empleat::getNom, e -> e.getTitols().stream().mapToInt(String::length).sum()))
                .forEach((a, e) -> System.out.println("Nombre: " + a + "conteo de las letras de los títulos:  " + e));
        System.out.println("-----------------------------------------");
        System.out.println();

        // 27. Mostra el total de lletres dels titols (incloent duplicats) dels empleats
        System.out.println("27. Mostra el total de lletres dels titols (incloent duplicats) dels empleats");
        int totalLetrasTitulos = listaDeEmpleados.stream()
                .map(Empleat::getTitols)
                .flatMap(e -> e.stream())
                .mapToInt(e -> e.length())
                .sum();
        System.out.println("Total letras títulos: " + totalLetrasTitulos);
        System.out.println("-----------------------------------------");
        System.out.println();

        // 28. Mostra l'empleat amb major quantitat de títols
        listaDeEmpleados.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(e -> e.getTitols().size())))
                .ifPresent(System.out::println);

        // 29A. Obtín una llista que continga 5 aleatoris entre 0 i 9 en format String
        List<String> listaAleatorios = Stream.iterate(0, i -> i + 1)
                .limit(5)
                .map(rp -> new Random().nextInt(10))
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println("Lista de 5 aleatorios  " + listaAleatorios);
        System.out.println("-----------------------------------------");
        System.out.println();

        // 29B. El mateix d'abans, però ara sense valors repetits.
        System.out.println(" 29B. El mateix d'abans, però ara sense valors repetits.");
        List<String> listaAleatoriosSinRepes = Stream.iterate(0, i -> i + 1)
                .map(rp -> new Random().nextInt(10))
                .distinct()
                .limit(5)
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println("Lista de 5 aleatorios sin repetidos  " + listaAleatoriosSinRepes);
        System.out.println("-----------------------------------------");
        System.out.println();

        // 30. Crea un stream amb tots els números positius divisibles entre 3. Després filtra aquells que siguen quadrats perfectes. 
        // Després descarta els 5 primers valors obtinguts. Finalment mostra els 10 següents valors obtinguts
        Stream.iterate(0, i -> i + 1)
                .filter(n -> n > 0 && n % 3 == 0 && n == Math.sqrt(n) * Math.sqrt(n))
                .skip(5)
                .limit(10)
                .forEach(cp -> System.out.println("5 Cuadrados perofectos divisibles entre 3 a partir del 5to = " + cp));
        System.out.println("-----------------------------------------");
        System.out.println();

        // 31. A partir dels cognoms dels empleats imprimeix amb una operació intermèdia els cognoms sense transformar i després transformats en majúscules.
        System.out.println("31. A partir dels cognoms dels empleats imprimeix amb una operació intermèdia els cognoms sense transformar i després transformats en majúscules.");
        listaDeEmpleados.stream()
                .map(Empleat::getCognoms)
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .count();
        System.out.println("-----------------------------------------");
        System.out.println();
        // Finalment retorna el nombre d'empleats.
        // 32. Imprimeix el cognom dels empleats ordenats en ordre alfabètic invers.
        System.out.println("32. Imprimeix el cognom dels empleats ordenats en ordre alfabètic invers.");
        listaDeEmpleados.stream()
                .map(Empleat::getCognoms)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");
        System.out.println();

        // 33. Obtín la suma dels títols de tots els empleats
        System.out.println(" 33. Obtín la suma dels títols de tots els empleats");
        final int totalTitulos = listaDeEmpleados.stream()
                .mapToInt(e -> e.getTitols().size())
                .sum();
        System.out.println("total titulos " + totalTitulos);
        System.out.println("-----------------------------------------");
        System.out.println();
        // 34. Obtín un String amb la concatenació dels títols d'aquells empleats que tinguen menys de 30 anys, separats per espais (sense duplicats)
        System.out.println("34. Obtín un String amb la concatenació dels títols d'aquells empleats que tinguen menys de 30 anys, separats per espais (sense duplicats)");
        String titulosMenos30 = listaDeEmpleados.stream()
                .filter(e -> e.getEdat() < 30)
                .flatMap(t -> t.getTitols().stream())
                .distinct()
                .collect(Collectors.joining("  \n", "Lista de titulos menores de 30: \n", "."));
        System.out.println(titulosMenos30);
        System.out.println("-----------------------------------------");
        System.out.println();
        // 35A. Mostra el cognom del primer dels empleats trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra "No trobat"
        System.out.println(" // 35A. Mostra el cognom del primer dels empleats trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra \"No trobat\"");

        listaDeEmpleados.stream()
                .filter(e -> e.getEdat() < 30 && e.getTitols().contains("Llicenciatura"))
                .map(Empleat::getCognoms)
                .findFirst()
                .ifPresentOrElse(e -> System.out.println("Apellido Primero menor de 30 años con licentiatura " + e), () -> System.out.println("No trobat"));
        System.out.println("-----------------------------------------");
        System.out.println();
        // ¿I si proves per a menors de 40?
        listaDeEmpleados.stream()
                .filter(e -> e.getEdat() < 40 && e.getTitols().contains("Llicenciatura"))
                .map(Empleat::getCognoms)
                .findFirst()
                .ifPresentOrElse(e -> System.out.println("Apellido Primero menor de 40 años con licentiatura  : " + e), () -> System.out.println("No trobat"));
        System.out.println("-----------------------------------------");
        System.out.println();
        // 35B. Mostra el primer dels empleats (complet) trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra "No trobat"
        System.out.println(" 35B. Mostra el primer dels empleats (complet) trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra \"No trobat\"");
        listaDeEmpleados.stream()
                .filter(e -> e.getEdat() < 30 && e.getTitols().contains("Llicenciatura"))
                .findFirst()
                .ifPresentOrElse(e -> System.out.println("Empleado completo Primero menor de 30 años con licentiatura  : " + e), () -> System.out.println("No trobat"));
        System.out.println("-----------------------------------------");
        System.out.println();
        // ¿I si proves per a menors de 40?
        System.out.println(" 35B. Mostra el primer dels empleats (complet) trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra \"No trobat\"");
        listaDeEmpleados.stream()
                .filter(e -> e.getEdat() < 40 && e.getTitols().contains("Llicenciatura"))
                .findFirst()
                .ifPresentOrElse(e -> System.out.println("Empleado completo Primero menor de 40 años con licentiatura  : " + e), () -> System.out.println("No trobat"));
        System.out.println("-----------------------------------------");
        System.out.println();

        // 36. Obtín un LinkedHashSet dels títols que tenen tots els empleats.
        System.out.println("36. Obtín un LinkedHashSet dels títols que tenen tots els empleats.");
        listaDeEmpleados.stream()
                .map(Empleat::getTitols)
                .flatMap(e -> e.stream())
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");
        System.out.println();
        // 37. Obtín un Map amb dos claus, la primera tindrá com a valors una llista dels empleats amb el títol de CFGS i l'altra clau tindrá una llista amb els que no el tenen.
        System.out.println("37. Obtín un Map amb dos claus, la primera tindrá com a valors una llista dels empleats amb el títol de CFGS i l'altra clau tindrá una llista amb els que no el tenen.");
        listaDeEmpleados.stream()
                .collect(Collectors.collectingAndThen(Collectors.partitioningBy(e -> e.getTitols().contains("CFGS")), e -> e))
                .forEach((k, v) -> System.out.println(k + " -- " + v));
        System.out.println("-----------------------------------------");
        System.out.println();

        // 38. A partir d'una llista d'String retorna la mateixa llista pero sense cadenes buides
        System.out.println("38. A partir d'una llista d'String retorna la mateixa llista pero sense cadenes buides");
        List<String> elementsOriginals = List.of("aigua", "", "llet", "oli", "", "  ", "lletuga");
        elementsOriginals.stream()
                .filter(e -> !e.isBlank())
                .toList()
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");
        System.out.println();
        // 39. Obtín una cadena separada per comes basada en una llista determinada d'enters.
        System.out.println("39. Obtín una cadena separada per comes basada en una llista determinada d'enters.");
        List<Integer> enterosLista = List.of(1, 2, 3, 4, 5);
        enterosLista.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println("Lista de enteros separada por comas: " + enterosLista);
        System.out.println("-----------------------------------------");
        System.out.println();
        // Cada element ha d'anar precedit de la lletra 'p' si el nombre és parell i precedit de la lletra 'i' si el nombre és imparell. 
        System.out.println("Cada element ha d'anar precedit de la lletra 'p' si el nombre és parell i precedit de la lletra 'i' si el nombre és imparell.");
        enterosLista.stream()
                .map(i -> { if (i % 2 == 0) { return "p".concat(String.valueOf(i)); } else {return "i".concat(String.valueOf(i)); } })
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");
        System.out.println();
                   
                                                                             
               
        // 40.A partir dels empleats. Obtín un mapa que tinga com a clau el nom del departament i com a valor un altre mapa
        System.out.println("40.A partir dels empleats. Obtín un mapa que tinga com a clau el nom del departament i com a valor un altre mapa");
        listaDeEmpleados.stream()
                .collect(Collectors.groupingBy(Empleat::getDepartament, Collectors.toMap(Empleat::getCognoms,e -> e.getTitols().stream().toList() )))    
                ; 
        // Este segon mapa tindrà com a clau el cognom de l'empleat y com a valor la llista de títols que té.
        // EXTRA A: A partir d'un String retorna les lletres distintes que conté, separades per comes (només lletres, no espais ni números ni altres caracters)
        String frase1 = "Tinc un 8 en PROG";

        // EXTRA B: A partir d'un String retorna la quantitat de lletres distintes que conté (només lletres, no espais ni números ni altres caracters)
        // EXTRA C: Obtín un mapa que mostre com a clau cada lletra distinta del String, i com a valor la quantitat de vegades que apareix.
        // EXTRA D: Mostra la lletra amb major freqüencia d'aparicions, i el nombre d'aparicions d'eixa lletra.
    }

}
