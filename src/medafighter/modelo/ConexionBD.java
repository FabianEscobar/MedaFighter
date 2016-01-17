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
import java.util.ArrayList;

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
    
    public boolean verificarNombreUsuario(String nombreUsuario) throws SQLException {
        
        boolean uBoolean = false;
    
        boolean resultadoConexion = this.conectar();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario = "SELECT * FROM USUARIO WHERE NOMBRE = '" + nombreUsuario +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaUsuario);
            
                if(resultadoBusqueda.next()) {
                
                    uBoolean = true;
                    
                }           
            
            }  
            
        }
        
        return uBoolean;
    
    }
    
    public boolean registrarUsuario(String nombreUsuario, String contrasenia, String nombreMedabot) throws SQLException {
        
        boolean registroCorrecto = false;
        
        boolean resultadoConexion = this.conectar();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario1 = "INSERT INTO USUARIO (NOMBRE,PASS,TIPO,VICTORIAS,DERROTAS,TORNEOS) VALUES ('" + nombreUsuario +"','" + contrasenia +"','HUMANO',0,0,0)";
                
                String consultaUsuario2 = "INSERT INTO MEDABOT (SALUDMAXIMA,NOMBRE,USUARIO,CABEZA,BRAZOIZQ,BRAZODER,PIERNAIZQ,PIERNADER,MEDALLA,IMAGEN) VALUES (1100,'" + nombreMedabot +"','" + nombreUsuario +"','Cabeza Generica (C)','Brazo Generico (BI)','Brazo Generico (BD)','Pierna Generica (PI)','Pierna Generica (PD)','Mono',0)";
                
                String consultaUsuario3 = "INSERT INTO MEDALLAUSUARIO (USUARIO,MEDALLA) VALUES ('" + nombreUsuario +"','Mono')";

                String consultaUsuario4 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE) VALUES ('" + nombreUsuario +"','Cabeza Generica (C)')";
                
                String consultaUsuario5 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE) VALUES ('" + nombreUsuario +"','Brazo Generico (BI)')";
                
                String consultaUsuario6 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE) VALUES ('" + nombreUsuario +"','Brazo Generico (BD)')";
                
                String consultaUsuario7 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE) VALUES ('" + nombreUsuario +"','Pierna Generica (PI)')";
                
                String consultaUsuario8 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE) VALUES ('" + nombreUsuario +"','Pierna Generica (PD)')";
                
                stmt.executeUpdate(consultaUsuario1);
                
                stmt.executeUpdate(consultaUsuario2);
                
                stmt.executeUpdate(consultaUsuario3);
                
                stmt.executeUpdate(consultaUsuario4);
                
                stmt.executeUpdate(consultaUsuario5);
                
                stmt.executeUpdate(consultaUsuario6);
                
                stmt.executeUpdate(consultaUsuario7);
                
                stmt.executeUpdate(consultaUsuario8);
                
                registroCorrecto = true;
                
            }           
            
        }  
        
        return registroCorrecto;
            
    }
    
    public ArrayList<String> buscarJugadores() throws SQLException{
        
        boolean resultadoConexion = this.conectar();
        
        ArrayList<String> jugadores = new ArrayList<>();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario = "SELECT NOMBRE FROM USUARIO";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaUsuario);
            
                while(resultadoBusqueda.next()) {
                
                    String nombre = resultadoBusqueda.getString(1);
                    
                    jugadores.add(nombre);
                    
                }           
            
            }  
            
        }
        
        return jugadores;
        
    }
        
}
    

