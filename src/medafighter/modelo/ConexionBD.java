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
            
                String consultaUsuario01 = "INSERT INTO USUARIO (NOMBRE,PASS,TIPO,VICTORIAS,DERROTAS,TORNEOS) VALUES ('" + nombreUsuario +"','" + contrasenia +"','HUMANO',0,0,0)";
                
                String consultaUsuario02 = "INSERT INTO MEDABOT (SALUDMAXIMA,NOMBRE,USUARIO,CABEZA,BRAZOIZQ,BRAZODER,PIERNAIZQ,PIERNADER,MEDALLA,IMAGEN) VALUES (1100,'" + nombreMedabot +"V1','" + nombreUsuario +"','Cabeza Generica (C)','Brazo Generico (BI)','Brazo Generico (BD)','Pierna Generica (PI)','Pierna Generica (PD)','Mono',0)";
                
                String consultaUsuario03 = "INSERT INTO MEDABOT (SALUDMAXIMA,NOMBRE,USUARIO,CABEZA,BRAZOIZQ,BRAZODER,PIERNAIZQ,PIERNADER,MEDALLA,IMAGEN) VALUES (1100,'" + nombreMedabot +"V2','" + nombreUsuario +"','Cabeza Generica (C)','Brazo Generico (BI)','Brazo Generico (BD)','Pierna Generica (PI)','Pierna Generica (PD)','Mono',0)";
                
                String consultaUsuario04 = "INSERT INTO MEDABOT (SALUDMAXIMA,NOMBRE,USUARIO,CABEZA,BRAZOIZQ,BRAZODER,PIERNAIZQ,PIERNADER,MEDALLA,IMAGEN) VALUES (1100,'" + nombreMedabot +"V3','" + nombreUsuario +"','Cabeza Generica (C)','Brazo Generico (BI)','Brazo Generico (BD)','Pierna Generica (PI)','Pierna Generica (PD)','Mono',0)";
                                
                String consultaUsuario05 = "INSERT INTO MEDALLAUSUARIO (USUARIO,MEDALLA) VALUES ('" + nombreUsuario +"','Mono')";

                String consultaUsuario06 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE) VALUES ('" + nombreUsuario +"','Cabeza Generica (C)')";
                
                String consultaUsuario07 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE) VALUES ('" + nombreUsuario +"','Brazo Generico (BI)')";
                
                String consultaUsuario08 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE) VALUES ('" + nombreUsuario +"','Brazo Generico (BD)')";
                
                String consultaUsuario09 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE) VALUES ('" + nombreUsuario +"','Pierna Generica (PI)')";
                
                String consultaUsuario10 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE) VALUES ('" + nombreUsuario +"','Pierna Generica (PD)')";
                
                stmt.executeUpdate(consultaUsuario01);
                
                stmt.executeUpdate(consultaUsuario02);
                
                stmt.executeUpdate(consultaUsuario03);
                
                stmt.executeUpdate(consultaUsuario04);
                
                stmt.executeUpdate(consultaUsuario05);
                
                stmt.executeUpdate(consultaUsuario06);
                
                stmt.executeUpdate(consultaUsuario07);
                
                stmt.executeUpdate(consultaUsuario08);
                
                stmt.executeUpdate(consultaUsuario09);
                
                stmt.executeUpdate(consultaUsuario10);
                
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
    
    public ArrayList<String> buscarJugadoresTipo(String tipoJugador) throws SQLException{
        
        boolean resultadoConexion = this.conectar();
        
        ArrayList<String> jugadores = new ArrayList<>();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario = "SELECT NOMBRE FROM USUARIO WHERE TIPO = '" + tipoJugador +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaUsuario);
            
                while(resultadoBusqueda.next()) {
                
                    String nombre = resultadoBusqueda.getString(1);
                    
                    jugadores.add(nombre);
                    
                }           
            
            }  
            
        }
        
        return jugadores;
        
    }
    
    public void limpiarSesionesActivas() throws SQLException {
        
        boolean resultadoConexion = this.conectar();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario = "DELETE FROM SESIONESACTIVAS WHERE 1=1";
        
                stmt.executeUpdate(consultaUsuario);    
            
            }  
            
        }
        
    }
    
    public void agregarSesionActiva(String nombreUsuario, String contrasenia) throws SQLException {
        
        boolean resultadoConexion = this.conectar();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario = "INSERT INTO SESIONESACTIVAS (NOMBRE,PASS) VALUES('" + nombreUsuario +"','" + contrasenia +"')";
        
                stmt.executeUpdate(consultaUsuario);    
            
            }  
            
        }
        
    }
    
    public boolean verificarSesion(String nombreUsuario) throws SQLException {
        
        boolean uBoolean = false;
    
        boolean resultadoConexion = this.conectar();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario = "SELECT * FROM SESIONESACTIVAS WHERE NOMBRE = '" + nombreUsuario +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaUsuario);
            
                if(resultadoBusqueda.next()) {
                
                    uBoolean = true;
                    
                }           
            
            }  
            
        }
        
        return uBoolean;
    
    }
    
    public String buscarTipoJugador(String nombreJugador) throws SQLException{
        
        boolean resultadoConexion = this.conectar();
        
        String tipoJugador = new String();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario = "SELECT * FROM USUARIO WHERE NOMBRE = '"+ nombreJugador +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaUsuario);
            
                if(resultadoBusqueda.next()){
                
                tipoJugador = resultadoBusqueda.getString("TIPO");
                
                }
                
            }  
            
        }
        
        return tipoJugador;
        
    }
    
    public boolean guardarMedabot(String versionMedabot, String jugador, ArrayList<String> medapartes, String medalla) throws SQLException {
        
        boolean medabotGuardado = false;
        
        String nombreMedabot = new String();
        
        if (versionMedabot.equals("Version 1")) {
            
            nombreMedabot = ""+jugador+"V1" ;
            
        }
        
        if (versionMedabot.equals("Version 2")) {
            
            nombreMedabot = ""+jugador+"V2" ;
            
        }
        
        if (versionMedabot.equals("Version 3")) {
            
            nombreMedabot = ""+jugador+"V3" ;
            
        }
        
        boolean resultadoConexion = this.conectar();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consulta = "UPDATE MEDABOT SET CABEZA = '" + medapartes.get(0) +"' WHERE NOMBRE = '" + nombreMedabot +"'";
                stmt.executeUpdate(consulta);
                
                consulta = "UPDATE MEDABOT SET BRAZOIZQ = '" + medapartes.get(1) +"' WHERE NOMBRE = '" + nombreMedabot +"'";
                stmt.executeUpdate(consulta);
                
                consulta = "UPDATE MEDABOT SET BRAZODER = '" + medapartes.get(2) +"' WHERE NOMBRE = '" + nombreMedabot +"'";
                stmt.executeUpdate(consulta);
                
                consulta = "UPDATE MEDABOT SET PIERNAIZQ = '" + medapartes.get(3) +"' WHERE NOMBRE = '" + nombreMedabot +"'";
                stmt.executeUpdate(consulta);
                
                consulta = "UPDATE MEDABOT SET PIERNADER = '" + medapartes.get(4) +"' WHERE NOMBRE = '" + nombreMedabot +"'";
                stmt.executeUpdate(consulta);
                
                consulta = "UPDATE MEDABOT SET MEDALLA = '" + medalla +"' WHERE NOMBRE = '" + nombreMedabot +"'";
                stmt.executeUpdate(consulta);
                
                medabotGuardado = true;
                
            }           
            
        }  
        
        return medabotGuardado;
        
    }
    
    public ArrayList<String> buscarMedapartesTipo(String tipoMedaparte) throws SQLException{
        
        boolean resultadoConexion = this.conectar();
        
        ArrayList<String> medapartes = new ArrayList<>();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario = "SELECT NOMBRE FROM MEDAPARTE WHERE TIPO = '" + tipoMedaparte +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaUsuario);
            
                while(resultadoBusqueda.next()) {
                
                    String nombre = resultadoBusqueda.getString(1);
                    
                    medapartes.add(nombre);
                    
                }           
            
            }  
            
        }
        
        return medapartes;
        
    }
    
    public ArrayList<String> buscarMedallas() throws SQLException{
        
        boolean resultadoConexion = this.conectar();
        
        ArrayList<String> medallas = new ArrayList<>();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario = "SELECT NOMBRE FROM MEDALLA";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaUsuario);
            
                while(resultadoBusqueda.next()) {
                
                    String nombre = resultadoBusqueda.getString(1);
                    
                    medallas.add(nombre);
                    
                }           
            
            }  
            
        }
        
        return medallas;
        
    }
        
}
    

