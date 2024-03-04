package Ejercicio5y6;
/**
 *
 * @author RamónMorenoAlbert
 */
import java.util.ArrayList;
public class TestBiblioteca {
    public static void main(String[] args) {
        //instancias
        Impresos impreso1= new Impresos("cod111", "El  impreso de java", 1700);
        Digitales digital1 = new Digitales("dig123", "El  digital de Java", 55);
        Revistas revista1= new Revistas("rev123", "La revista de Java", 5, "mensual");
        Libros libro1 = new Libros("lib123", "El libro de  java", 500, 1);
        Ebooks ebook1 = new  Ebooks("eo123", "el Ebook de java ", 500, "PDF");
        Audiolibros audiolibro1 = new Audiolibros("Aud123", "El audioLibro de Java", 123, 7);
        
        //mostrar 
        impreso1.mostraInfo();
        digital1.mostraInfo();
        revista1.mostraInfo();
        libro1.mostraInfo();
        ebook1.mostraInfo();
        audiolibro1.mostraInfo();
        
        ArrayList<Materiales> materialesBiblioteca = new ArrayList<>();
        materialesBiblioteca.add(impreso1);
        materialesBiblioteca.add(digital1);
        materialesBiblioteca.add(revista1);
        materialesBiblioteca.add(libro1);
        materialesBiblioteca.add(ebook1);
        materialesBiblioteca.add(audiolibro1);
        
        System.out.println("--------------------------------------");    

        System.out.println("Lista de materiales de la biblioteca. Segun su tipo");
        for (Materiales materiales : materialesBiblioteca) {
            
            if(materiales instanceof Impresos ){
              System.out.println("Matrial impreso con codigo "+materiales.getCodIsbm()+" y las siguientes páginas : "+((Impresos) materiales).getNumPaginas()); 
    
            }
            if(materiales instanceof Digitales ){
              System.out.println("Matrial digital con codigo "+materiales.getCodIsbm()+" y los siguientes MB : "+((Digitales) materiales).getMb()); 
    
            }
            
           
            
        }
                

        System.out.println("--------------------------------------");    
        System.out.println("Pruebas sobre el libro Alquilable:");
         LibroAlquilabe libro1alq = new LibroAlquilabe("123alqull", "El libro alq de java", 500, 5, 10);
                    
         libro1alq.alquilar("Pepe", 7);
         libro1alq.mostraInfo();
         libro1alq.alquilar("Antonio", 4);
         libro1alq.devolver();
         libro1alq.devolver();
    }
}
