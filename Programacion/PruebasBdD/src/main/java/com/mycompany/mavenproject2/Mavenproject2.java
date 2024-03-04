package com.mycompany.mavenproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mavenproject2 {
    private final String url = "jdbc:sqlite:database.db";

    /**
     * Connect to the database
     * @return the Connection object
     */
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Create a new table in the database
     */
    public void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS alumnos (\n"
                + " id integer PRIMARY KEY,\n"
                + " nombre text NOT NULL,\n"
                + " carrera text\n"
                + ");";
        
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   
    /**
     * Insert a new row into the alumnos table
     */
    public void insert(String nombre, String carrera) {
        String sql = "INSERT INTO alumnos(nombre, carrera) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, carrera);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Select all rows in the alumnos table
     */
    public void selectAll(){
        String sql = "SELECT id, nombre, carrera FROM alumnos";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("nombre") + "\t" +
                                   rs.getString("carrera"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Update data of a alumno specified by the id
     */
    public void update(int id, String nombre, String carrera) {
        String sql = "UPDATE alumnos SET nombre = ?, carrera = ? WHERE id = ?";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, carrera);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Delete a alumno specified by the id
     */
    public void delete(int id) {
        String sql = "DELETE FROM alumnos WHERE id = ?";
        
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
  
    }
    
    
    
        
    //métodos para  pruebas 
    //creo tabla con un nombre especifico
    //usado para practicas, la base de datos debe tener creadas las tablas
    
    public void createNewTablePruebas(String nombreTabla) {
        String sql = "CREATE TABLE IF NOT EXISTS "+nombreTabla+" (\n"
                + " id integer PRIMARY KEY,\n"
                + " nombre text NOT NULL,\n"
                + " carrera text\n"
                + ");";
        
        try (Connection conn = this.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql)) {
           pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //inserta los valores en la tabla selecionada
    public void insertPruebas(String nombreTabla, int id, String nombre, String carrera) {
           String sql="INSERT INTO "+nombreTabla+" (id, nombre, carrera) VALUES(?,?,?);";    //creo el string que se preparará para ejecutar
           try(Connection conn = this.connect(); 
               PreparedStatement pstmt = conn.prepareStatement(sql)){
               pstmt.setInt(1, id);                //sustituye los parametros values, que deben primero estar en el insert into los sustituye en el indice establecido por los valores
               pstmt.setString(2, nombre);        //setInt(index:, (parametro que recibe) )
               pstmt.setString(3, carrera);
               pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //seleciono todo pasando el parametro del nombre de la tabla deseadda
    public void selectAllPruebas(String nombreTabla){
            String sql = "SELECT * FROM " + nombreTabla; // consulta sql a la tabla pasada por parametros en el main devuelve todo *

            try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) { // ejecuta la consulta SQL y obtien resultados

                // Iterar sobre los resultados y mostrar o procesar cada fila
                System.out.println("Tabla : "+nombreTabla);
                while (rs.next()) {
                    int id = rs.getInt("id"); // Obtener el valor de la columna "id"
                    String nombre = rs.getString("nombre"); // obtiene el valor de la columna nombre
                    String carrera = rs.getString("carrera"); // obtiene el valor de la columna carrera

                // imprime valores
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Carrera: " + carrera);
                }
            } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
    }
    public void borrarTodo(String nombreTabla){
        String sql = "DELETE  FROM "+nombreTabla;
        try (Connection conn =this.connect();
             Statement stmt = conn.createStatement()) { 
                
            stmt.execute(sql);
        } catch (SQLException e) {
         System.out.println(e.getMessage());
        }
    }
    
 // de métodos para pruebas fin de pruebas



    public static void main(String[] args) {
        Mavenproject2 app = new Mavenproject2();
        /*
        // Create a new table
        app.createNewTable();
        
        // Insert new data
        app.insert("Juan Perez", "Ingeniería de Software");
        app.insert("Ana Lopez", "Ciencias de la Computación");
        
        // Select the data
        System.out.println("Lista de alumnos:");
        app.selectAll();
        
        // Update data
        app.update(1, "Juan Perez", "Ingeniería Informática");
        System.out.println("Datos actualizados:");
        app.selectAll();
        
        // Delete a student
        app.delete(2);
        System.out.println("Lista de alumnos después de eliminar:");
        app.selectAll();

   */
        

//con los métodos que he incluido,  creo tablas con el nombre pasado por parametro, inserto en las tablas selecciondas por parametros
        //app.createNewTablePruebas("NuevaTabla");
       //app.insertPruebas("NuevaTabla", 4, "Paco2", "concarreer");
       
       app.selectAllPruebas("NuevaTabla");
       app.borrarTodo("NuevaTabla"); 
       
    }
}
