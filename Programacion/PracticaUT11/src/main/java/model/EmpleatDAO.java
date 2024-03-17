package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

/*esta clase contendrá los metodos necesarios que interactuaran con la base de datos*/
public class EmpleatDAO /*extends OficinaDAO*/{ // extendia para poder usar el metodo oficinaxiste
    public List<Empleat> getEmpleatsRangoEdad(int minima, int maxima) {
        List<Empleat> listaEmpleats = new ArrayList<>();
        try {
            String sql = "SELECT * FROM empleats WHERE edat BETWEEN ? AND ? ";
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            pstmt.setInt(1, minima);
            pstmt.setInt(2, maxima);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                String contracte = rs.getString("contracte");
                LocalDate contracteFormatoDate = LocalDate.parse(contracte);
                
                Empleat empleat = new Empleat(
                        rs.getInt("numemp"),
                        rs.getString("nom"), 
                        rs.getInt("edat"),
                        rs.getInt("oficina"),
                        rs.getString("ocupacio"),
                        contracteFormatoDate);    
                
                listaEmpleats.add(empleat);
            }
          
       } catch (SQLException e) {
           System.out.println(e.getMessage()); 
       }
        return listaEmpleats;
   }
  
    public void añadirEmpleadoFechaActual(int numemp, String nom,int edat, int oficina, String ocupacio){
        try {
            LocalDate fechaActual = LocalDate.now();
            String fechaActualTexto = fechaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
                String sql = "INSERT INTO empleats (numemp, nom, edat, oficina, ocupacio, contracte) VALUES (? , ? , ? , ?, ?, ?)";
                Connexio connexio = Connexio.getConnexio();
                PreparedStatement pstmt = connexio.getPrepared(sql);
           
            pstmt.setInt(1, numemp);
            pstmt.setString(2, nom);
            pstmt.setInt(3, edat);
            pstmt.setInt(4, oficina);
            pstmt.setString(5, ocupacio);
            pstmt.setString(6, fechaActualTexto);         
            pstmt.executeUpdate();
            
            System.out.println("Empleado añadido a la base de datos correctamente.");

        } catch (SQLException e) {
            System.out.println("Error SQL "+e.getMessage());
        }
    }

     public void afegir(Empleat empleat){                 
        try  {         
            String sql = "INSERT INTO empleats (numemp, nom, edat, oficina, ocupacio, contracte) VALUES (? , ? , ? , ?, ?, ?)";  
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
                
        LocalDate fechaContra = empleat.getContracte(); //fecha            
        String fechaContraTexto = fechaContra.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                
           
                pstmt.setInt(1, empleat.getNumemp());
                pstmt.setString(2, empleat.getNom());
                pstmt.setInt(3, empleat.getEdat());
                pstmt.setInt(4, empleat.getOficina());
                pstmt.setString(5, empleat.getOcupacio());
                pstmt.setString(6, fechaContraTexto);         
                pstmt.executeUpdate(); 
            
                    System.out.println("Empleado añadido a la base de datos correctamente.");

            } catch (SQLException e) {
                    System.out.println("Error SQL "+e.getMessage());
            }
    }
     
     public boolean empleadoExiste(int numemp){
         try {
            String sql = "SELECT COUNT(*) FROM empleats WHERE numemp = ? ";
            Connexio connexio = Connexio.getConnexio();       
            PreparedStatement pstmt = connexio.getPrepared(sql);
             
             Boolean existe;
                        
                pstmt.setInt(1, numemp);
                ResultSet rs = pstmt.executeQuery();
            if(rs.getInt(1)>0) {
                existe= true;
            }else{
                existe= false;
            }
            
            return existe;

        } catch (SQLException e) {
            System.out.println("Error SQL "+e.getMessage());
        }
         
        return false; 
     }

     public void moure(int numEmpDestino , int numEmpOrigen ){
         try {
             String sql = "UPDATE empleats SET oficina = ? WHERE oficina = ?";
             Connexio connexio = Connexio.getConnexio();
             PreparedStatement pstmt = connexio.getPrepared(sql);
             
            pstmt.setInt(1,numEmpDestino);
            pstmt.setInt(2,numEmpOrigen);
            
            int lineas = pstmt.executeUpdate();
            if(lineas>0){
                System.out.println("Empleados cambiados de oficina de ."+numEmpOrigen+" a "+numEmpDestino);
            }else{
                System.out.println("No extisten empleados en esa oficina."+numEmpOrigen);
            }             
             
         } catch (SQLException e) {
             System.out.println("Error SQL : "+ e.getMessage());
         }
     } 
     public void eliminar(int numEmpleado){
         try {            
             String sql = "DELETE FROM empleats WHERE numemp = ?";
             Connexio connexio  = Connexio.getConnexio();
             PreparedStatement pstmt = connexio.getPrepared(sql);
             pstmt.setInt(1, numEmpleado); 
             int linea =pstmt.executeUpdate();
             
             if(linea>0){
                 System.out.println("Empleado número ["+numEmpleado+"] eliminado correctamente de la base de datos.");
             }
             else{
                 System.out.println("No existe un empledo con ese número de empelado.");
             }
             
         } catch (SQLException e) {
             System.out.println("Error SQL : "+e.getMessage());
         }
     }
    
}
