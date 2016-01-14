/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Fabián
 */
public class ConexionBD {
    
    private static final String SERVIDOR = "localhost";
    private static final String PUERTO = "1527";
    private static final String NOMBRE_BD = "contact";
    private static final String USUARIO = "nbuser";
    private static final String PASSWORD = "nbuser";
    public static final String URL_CONEXION = "jdbc:derby://" + SERVIDOR + ":"+ PUERTO +"/"+ NOMBRE_BD +";user="+ USUARIO +";password=" + PASSWORD;

    private Connection conexion = null;
    
    public boolean conectar() throws SQLException {
        
        this.conexion = DriverManager.getConnection(URL_CONEXION);
        
        if(this.conexion != null) {
            
            return true;
        
        }
        
        else{
            
            return false;
        
        }
    
    }
    
    public void desconectar() throws SQLException {
        
        if(this.conexion != null) {
            
            this.conexion.close();
        
        }
    
    }
    
    public Statement crearConsulta() throws SQLException {
        
        if(this.conexion != null) {
            
            return this.conexion.createStatement();
        
        }
        
        else {
            
            return null;
            
        }
        
    }
    
    public boolean verificarUsuario(String nombreUsuario, String contrasenia) throws SQLException {
        
        boolean uBoolean = false;
    
        boolean resultadoConexion = this.conectar();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario = "SELECT * FROM USUARIO WHERE NOMBRE = '" + nombreUsuario + "' AND PASS = '" + contrasenia +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaUsuario);
            
                if(resultadoBusqueda.next()) {
                
                    uBoolean = true;
                    
                }           
            
            }  
            
        }
        
        return uBoolean;
    
    }
    
}
