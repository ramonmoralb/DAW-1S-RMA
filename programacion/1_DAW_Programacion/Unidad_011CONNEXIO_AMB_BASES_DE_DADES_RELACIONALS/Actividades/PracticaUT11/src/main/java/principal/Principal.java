package principal;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import model.Connexio;
import model.Empleat;
import model.EmpleatDAO;
import model.Oficina;
import model.OficinaDAO;

public class Principal {

    public static void main(String[] args) {
        try {
            Scanner teclat = new Scanner(System.in);
            Connexio connexio = Connexio.getConnexio();

            System.out.println("1. Musestra todos los empleados de la base de datos desde el main.");
            String sql = "SELECT * FROM Empleats";
            PreparedStatement prepared = connexio.getPrepared(sql);
            ResultSet rs = prepared.executeQuery();
                
            System.out.println("Lista de empleados");
            while (rs.next()) {
                int numeroEmpleat = rs.getInt("numemp");
                String nom = rs.getString("nom");
                int edat = rs.getInt("edat");
                int oficina = rs.getInt("oficina");
                String ocupacio = rs.getString("ocupacio");
                String contracte = rs.getString("contracte");
                System.out.println(numeroEmpleat + " - " + nom + " - " + edat + " - " + oficina + " - " + ocupacio + " - " + contracte);

            }
           System.out.println();

           
           System.out.println("2. Lista de oficinas impresa desde el main.");
                sql = "SELECT * FROM oficines";
                connexio = Connexio.getConnexio(); 
                PreparedStatement pstmt = connexio.getPrepared(sql);  
                rs = pstmt.executeQuery(); 
                System.out.println("Lista de oficinas. ");
                    while(rs.next()){  
                        int oficina = rs.getInt("oficina");
                        String ciutat = rs.getString("ciutat");
                        int superficie = rs.getInt("superficie");
                        double vendes = rs.getDouble("vendes");
                System.out.println("Oficina ["+oficina+"] Ciudad ["+ciutat+"] superficie ["+superficie+"] ventas ["+vendes+"]");
            } 
           System.out.println();
          
            System.out.println("3. Lista de oficinas selecionadas por ciudad de oficina insertada en el main.");
            System.out.println(new OficinaDAO().getByCiutat("Petrer"));

            System.out.println("4. Lista de empleados por rango de edad, método implementado en OficinaDAO insertado por teclado por el usuario.");
            System.out.print("Introdueix edat mínima: ");
            int minima = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix edat màxima: ");
            int maxima = teclat.nextInt();
            teclat.nextLine();
            System.out.println( new EmpleatDAO().getEmpleatsRangoEdad(minima, maxima)); 
      
            System.out.println("5. Insercion de empleado con los datos introducidos por el "+
             "menos la fecha, la cual será la actual. Metodo implementado en EmpleadoDAO ");
            
            System.out.print("Introdueix codi empleat: ");
            int numeroEmpleat = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix nom: ");
            String nom = teclat.nextLine();
            System.out.print("Introdueix edat: ");
            int edat = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix codi oficina: ");
            int oficina = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix ocupació: ");
            String ocupacio = teclat.nextLine();
            new EmpleatDAO().añadirEmpleadoFechaActual(numeroEmpleat, nom, edat, oficina, ocupacio); 

            System.out.println("6. 7. 8. Introducido control de entrada para usuarios repetidos u oficinas inexistentes.");           
            System.out.println("Introduzca los datos del empleado que desea introducir en la base de datos.");
            boolean salir = false;
            int numeroEmpleado;
            do{
                System.out.print("Número empleado :");
                 numeroEmpleado=teclat.nextInt();
                teclat.nextLine();
                if(!new EmpleatDAO().empleadoExiste(numeroEmpleado)){
                    salir=true;
                }else{
                    System.out.println("El empleado ya existe en la base de datos");     
                    System.out.println("Ingrese un número de empleado que no exista");     
                }
            }while(!salir);
            System.out.print("Nombre :");
                String  nombreEmpleado=teclat.nextLine();
                
            System.out.print("Edad :");
                int edatEmpleado=teclat.nextInt();
            teclat.nextLine();
            salir = false;
            int numeroOficina;
            do{
                System.out.print("Número Oficina :");
                numeroOficina=teclat.nextInt();
                teclat.nextLine();
                if(new OficinaDAO().oficinaExiste(numeroOficina)){
                    salir=true;
                }else{
                    System.out.println("La oficina no existe.");     
                    System.out.println("Ingrese una oficina que exista");     
                }
            }while(!salir);
            
            System.out.print("Ocupación :");
            String ocupacionEmpleado = teclat.nextLine();
            System.out.println("Fecha contrato:");
            System.out.print("Dia :");
            int diaContrato = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Mes :");
            int mesContrato = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Año :");
            int añoContrato = teclat.nextInt();
            teclat.nextLine();
            LocalDate contratoEmpleado = LocalDate.of(añoContrato, mesContrato, diaContrato);
            Empleat empleatAInserir = new Empleat(numeroEmpleado, nombreEmpleado, edatEmpleado, numeroOficina, ocupacionEmpleado, contratoEmpleado);            
   
            System.out.println("Creado a "+empleatAInserir.getNom());
            new EmpleatDAO().afegir(empleatAInserir);

            System.out.println("Paso 9. Mover emplrados de oficia a otra oficina.");
            new EmpleatDAO().moure(2, 3);
         
            System.out.println("Paso 10. Eliminar al empleado selecionado por número de empleado introducido por teclado.");
            System.out.print("Selecciona en número de empleado que deseas eliminar de la base de datos: ");
            int empleadoAEliminar = teclat.nextInt();
            teclat.nextLine();
            new EmpleatDAO().eliminar(empleadoAEliminar);

            System.out.println("Paso 11. Lista de oficina desde la clase dao");
            System.out.println(new OficinaDAO().getAll());
            
            System.out.print("Paso 12. Muestra oficinas con una extension superior a la introducia por el usuario. ");
            System.out.print("Introdueix una superficie mínima: ");
            int superficie = teclat.nextInt();
            teclat.nextLine();
            ArrayList<Oficina> listaOficnas = new ArrayList<>();
            listaOficnas=new OficinaDAO().getAll();
            for (Oficina poficina : listaOficnas) {
                if(poficina.getSuperficie()>superficie){
                    System.out.print(poficina);
                }
            }

          System.out.print("Paso 13. Cambio la ciudad de una oficina, la oficina a cambiar de ciudad se solicita por el núemro de oficina.");
                new OficinaDAO().actualitzarCiutat(2, "Sax");
           
          System.out.print("Paso 14. Incrementa las ventas a la oficina seleccionada.");  
                new OficinaDAO().incrementarVendes(1, 100.5);
           

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
        
    }
}
