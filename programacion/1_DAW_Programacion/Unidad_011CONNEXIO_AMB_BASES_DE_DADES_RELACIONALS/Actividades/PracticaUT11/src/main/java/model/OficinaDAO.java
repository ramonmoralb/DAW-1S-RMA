package model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OficinaDAO {
    

    public List<Oficina> getByCiutat(String ciutat){  
            List<Oficina> listaOficinas = new ArrayList<>();

        try {
                                                                            
           String sql = "SELECT * FROM oficines WHERE ciutat = ? "; 
           Connexio connexio = Connexio.getConnexio(); 
           PreparedStatement pstmt = connexio.getPrepared(sql); 
           pstmt.setString(1, ciutat); 
            ResultSet rs = pstmt.executeQuery(); 
                
          System.out.print("Lista de oficinas situadas en "+ciutat);
             while(rs.next()){  
                 Oficina oficina = new Oficina( 
                 rs.getInt("oficina"),
                 rs.getString("ciutat"),
                 rs.getInt("superficie"),
                 rs.getDouble("vendes")         
                 );
            
                 listaOficinas.add(oficina);   
             }        
             System.out.println();

            
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }
              
        return listaOficinas;
    }
    
    public boolean oficinaExiste(int oficina){      
        try {          
            String sql = "SELECT COUNT(*) FROM oficines WHERE oficina = ? ";
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);           
            pstmt.setInt(1, oficina);
            ResultSet rs = pstmt.executeQuery();
            
           if(rs.getInt(1)>0){
               
               return true;
           }
           else{
               
               return false;
           }
        } catch (SQLException e) {
            System.out.println("Erro SQL : "+ e.getMessage());
        }
        
               return false;
    }
    
    public ArrayList<Oficina> getAll(){
        try { 
            ArrayList<Oficina> listaOficinas = new ArrayList<>();
            String sql = "SELECT * FROM oficines";
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            ResultSet rs  = pstmt.executeQuery();
            System.out.println("Lista de oficinas");
            while(rs.next()){
                Oficina oficina = new Oficina(
                        rs.getInt("oficina"),
                        rs.getString("ciutat"),
                        rs.getInt("superficie"),
                        rs.getDouble("vendes"));

                listaOficinas.add(oficina);
            }
            
            return listaOficinas;
            
        } catch (SQLException e) {
            System.out.println("Error SQL :"+e.getMessage());
        }
            return null;
    }
    public void actualitzarCiutat(int oficina, String ciutat){
        try {
            String sql = "UPDATE oficines set ciutat = ? WHERE oficina = ?";
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            pstmt.setString(1, ciutat);
            pstmt.setInt(2, oficina);
            int lineas = pstmt.executeUpdate();
                if (lineas>0){
                    System.out.println("Oficinas modificada de ciudad correctamente");
                }else{
                     System.out.println("La oficina no existe");
                }                
        } catch (SQLException e) {
            System.out.println("Error SQL : "+ e.getMessage());
        }
    }
    public void incrementarVendes(int oficina, double incremento){
        double ventas=0.0;
        boolean oficinaExiste = true;
        try {
            String sql = "SELECT vendes FROM oficines WHERE oficina = ?";
            Connexio connexio = Connexio.getConnexio();
            PreparedStatement pstmt = connexio.getPrepared(sql);
            pstmt.setInt(1, oficina);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                ventas = rs.getDouble("vendes");
            }
            else{
                System.out.println("No existe la oficina.");
                oficinaExiste=false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error SQL : "+ e.getMessage());
        }
  
        if(oficinaExiste){
            try {
            
                String sql = "UPDATE oficines SET vendes = ? WHERE oficina = ?";
                Connexio connexio = Connexio.getConnexio();
            
                PreparedStatement pstmt =  connexio.getPrepared(sql);
                pstmt.setDouble(1, incremento+ventas);
                pstmt.setInt(2, oficina);
                pstmt.executeUpdate();
            
            } catch (SQLException e) {
                System.out.println("Error SQL : "+ e.getMessage());
            }
        }
    }
}
