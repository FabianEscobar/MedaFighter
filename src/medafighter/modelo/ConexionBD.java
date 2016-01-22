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
    
    public int saludMaximaMedabot(String nombreMedabot) throws SQLException {
        
        int saludMaximaMedabot = 0;
        
        boolean resultadoConexion = this.conectar();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaMedabot = "SELECT * FROM MEDABOT WHERE NOMBRE = '" + nombreMedabot +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaMedabot);
                
                String cabeza = new String();
                String brazoIzq = new String();
                String brazoDer = new String();
                String piernaIzq = new String();
                String piernaDer = new String();
                
                int saludCabeza = 0;
                int saludBrazoIzq = 0;
                int saludBrazoDer = 0;
                int saludPiernaIzq = 0;
                int saludPiernaDer = 0;
            
                if(resultadoBusqueda.next()) {
                
                    cabeza = resultadoBusqueda.getString(4);
                    brazoIzq = resultadoBusqueda.getString(5);
                    brazoDer = resultadoBusqueda.getString(6);
                    piernaIzq = resultadoBusqueda.getString(7);
                    piernaDer = resultadoBusqueda.getString(8);
                    
                }
                
                String consultaCabeza = "SELECT SALUDMAXIMA FROM MEDAPARTE WHERE NOMBRE = '" + cabeza +"'";
                
                resultadoBusqueda= stmt.executeQuery(consultaCabeza);
                
                if(resultadoBusqueda.next()) {
                
                    saludCabeza = resultadoBusqueda.getInt(1);
                    
                }
                
                String consultaBrazoIzq = "SELECT SALUDMAXIMA FROM MEDAPARTE WHERE NOMBRE = '" + brazoIzq +"'";
                
                resultadoBusqueda= stmt.executeQuery(consultaBrazoIzq);
                
                if(resultadoBusqueda.next()) {
                
                    saludBrazoIzq = resultadoBusqueda.getInt(1);
                    
                }
                
                String consultaBrazoDer = "SELECT SALUDMAXIMA FROM MEDAPARTE WHERE NOMBRE = '" + brazoDer +"'";
                
                resultadoBusqueda= stmt.executeQuery(consultaBrazoDer);
                
                if(resultadoBusqueda.next()) {
                
                    saludBrazoDer = resultadoBusqueda.getInt(1);
                    
                }
                
                String consultaPiernaIzq = "SELECT SALUDMAXIMA FROM MEDAPARTE WHERE NOMBRE = '" + piernaIzq +"'";
                
                resultadoBusqueda= stmt.executeQuery(consultaPiernaIzq);
                
                if(resultadoBusqueda.next()) {
                
                    saludPiernaIzq = resultadoBusqueda.getInt(1);
                    
                }
                
                String consultaPiernaDer = "SELECT SALUDMAXIMA FROM MEDAPARTE WHERE NOMBRE = '" + piernaDer +"'";
                
                resultadoBusqueda= stmt.executeQuery(consultaPiernaDer);
                
                if(resultadoBusqueda.next()) {
                
                    saludPiernaDer = resultadoBusqueda.getInt(1);
                    
                }
                
                saludMaximaMedabot = saludCabeza + saludBrazoIzq + saludBrazoDer + saludPiernaIzq + saludPiernaDer;
                
            }           
            
        }  
        
        return saludMaximaMedabot;
        
    }
    
    public boolean registrarUsuario(String nombreUsuario, String contrasenia, String nombreMedabot) throws SQLException {
        
        boolean registroCorrecto = false;
        
        boolean resultadoConexion = this.conectar();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario01 = "INSERT INTO USUARIO (NOMBRE,PASS,TIPO,VICTORIAS,DERROTAS,TORNEOS) VALUES ('" + nombreUsuario +"','" + contrasenia +"','HUMANO',0,0,0)";
                
                String consultaUsuario02 = "INSERT INTO MEDABOT (SALUDMAXIMA,NOMBRE,USUARIO,CABEZA,BRAZOIZQ,BRAZODER,PIERNAIZQ,PIERNADER,MEDALLA,IMAGEN) VALUES (0,'" + nombreMedabot +"V1','" + nombreUsuario +"','Cabeza Generica (C)','Brazo Generico (BI)','Brazo Generico (BD)','Pierna Generica (PI)','Pierna Generica (PD)','Mono',0)";
                
                String consultaUsuario03 = "INSERT INTO MEDABOT (SALUDMAXIMA,NOMBRE,USUARIO,CABEZA,BRAZOIZQ,BRAZODER,PIERNAIZQ,PIERNADER,MEDALLA,IMAGEN) VALUES (0,'" + nombreMedabot +"V2','" + nombreUsuario +"','Cabeza Generica (C)','Brazo Generico (BI)','Brazo Generico (BD)','Pierna Generica (PI)','Pierna Generica (PD)','Mono',0)";
                
                String consultaUsuario04 = "INSERT INTO MEDABOT (SALUDMAXIMA,NOMBRE,USUARIO,CABEZA,BRAZOIZQ,BRAZODER,PIERNAIZQ,PIERNADER,MEDALLA,IMAGEN) VALUES (0,'" + nombreMedabot +"V3','" + nombreUsuario +"','Cabeza Generica (C)','Brazo Generico (BI)','Brazo Generico (BD)','Pierna Generica (PI)','Pierna Generica (PD)','Mono',0)";
                                
                String consultaUsuario05 = "INSERT INTO MEDALLAUSUARIO (USUARIO,MEDALLA) VALUES ('" + nombreUsuario +"','Mono')";

                String consultaUsuario06 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE,TIPO) VALUES ('" + nombreUsuario +"','Cabeza Generica (C)','Cabeza')";
                
                String consultaUsuario07 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE,TIPO) VALUES ('" + nombreUsuario +"','Brazo Generico (BI)','BrazoIzq')";
                
                String consultaUsuario08 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE,TIPO) VALUES ('" + nombreUsuario +"','Brazo Generico (BD)','BrazoDer')";
                
                String consultaUsuario09 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE,TIPO) VALUES ('" + nombreUsuario +"','Pierna Generica (PI)','PiernaIzq')";
                
                String consultaUsuario10 = "INSERT INTO MEDAPARTEUSUARIO (USUARIO,MEDAPARTE,TIPO) VALUES ('" + nombreUsuario +"','Pierna Generica (PD)','PiernaDer')";
                
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
                
                int saludMaximaMedabot = this.saludMaximaMedabot(nombreMedabot+"V1");
                
                String consultaUsuario11 = "UPDATE MEDABOT SET SALUDMAXIMA = " +saludMaximaMedabot+ " WHERE NOMBRE = '" + nombreMedabot +"V1'";
                
                String consultaUsuario12 = "UPDATE MEDABOT SET SALUDMAXIMA = " +saludMaximaMedabot+ " WHERE NOMBRE = '" + nombreMedabot +"V2'";
                
                String consultaUsuario13 = "UPDATE MEDABOT SET SALUDMAXIMA = " +saludMaximaMedabot+ " WHERE NOMBRE = '" + nombreMedabot +"V3'";
                                
                stmt.executeUpdate(consultaUsuario11);
                
                stmt.executeUpdate(consultaUsuario12);
                
                stmt.executeUpdate(consultaUsuario13);
                
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
    
    public String buscarNombreMedabot(String usuario) throws SQLException {
        
        String nombreMedabot = new String();
        
        boolean resultadoConexion = this.conectar();
                      
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
                
                String consultaMedabot = "SELECT NOMBRE FROM MEDABOT WHERE USUARIO = '" + usuario +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaMedabot);
            
                while(resultadoBusqueda.next()) {
                
                    nombreMedabot = resultadoBusqueda.getString(1);
                    
                    nombreMedabot = nombreMedabot.substring(0,nombreMedabot.length()-2);
                    
                }           
            
            }  
            
        }
        
        return nombreMedabot;
        
    }
    
    public boolean guardarMedabot(String versionMedabot, String nombreMedabot, ArrayList<String> medapartes, String medalla) throws SQLException {
        
        boolean medabotGuardado = false;        
                
        if (versionMedabot.equals("Version 1")) {
            
            nombreMedabot = ""+nombreMedabot+"V1" ;
            
        }
        
        if (versionMedabot.equals("Version 2")) {
            
            nombreMedabot = ""+nombreMedabot+"V2" ;
            
        }
        
        if (versionMedabot.equals("Version 3")) {
            
            nombreMedabot = ""+nombreMedabot+"V3" ;
            
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
                
                int saludMaximaMedabot = this.saludMaximaMedabot(nombreMedabot);
                
                consulta = "UPDATE MEDABOT SET SALUDMAXIMA = " +saludMaximaMedabot+ " WHERE NOMBRE = '" + nombreMedabot +"'";
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
    
    public ArrayList<String> buscarMedapartesUsuarioTipo(String usuario, String tipo) throws SQLException{
        
        boolean resultadoConexion = this.conectar();
        
        ArrayList<String> medapartes = new ArrayList<>();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaMedapartes = "SELECT MEDAPARTE FROM MEDAPARTEUSUARIO WHERE USUARIO = '" + usuario +"' AND TIPO = '" + tipo +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaMedapartes);
            
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
    
    public ArrayList<Object> buscarMedabot(String nombre) throws SQLException {
        
        boolean resultadoConexion = this.conectar();
        
        ArrayList<Object> datosMedabot = new ArrayList<>();
                      
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
                
                String consultaMedabot = "SELECT * FROM MEDABOT WHERE NOMBRE = '" + nombre +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaMedabot);
            
                if(resultadoBusqueda.next()) {
                
                    int saludMaxima = resultadoBusqueda.getInt(1);
                    datosMedabot.add(saludMaxima);
                                        
                    nombre = resultadoBusqueda.getString(2);
                    datosMedabot.add(nombre);
                    
                    String usuario = resultadoBusqueda.getString(3);
                    datosMedabot.add(usuario);
                    
                    String cabeza = resultadoBusqueda.getString(4);
                    datosMedabot.add(cabeza);
                    
                    String brazoIzq = resultadoBusqueda.getString(5);
                    datosMedabot.add(brazoIzq);
                    
                    String brazoDer = resultadoBusqueda.getString(6);
                    datosMedabot.add(brazoDer);
                    
                    String piernaIzq = resultadoBusqueda.getString(7);
                    datosMedabot.add(piernaIzq);
                    
                    String piernaDer = resultadoBusqueda.getString(8);
                    datosMedabot.add(piernaDer);
                    
                    String medalla = resultadoBusqueda.getString(9);
                    datosMedabot.add(medalla);
                    
                    int imagen = resultadoBusqueda.getInt(10);
                    datosMedabot.add(imagen);
                    
                }           
            
            }  
            
        }
        
        return datosMedabot;
        
    }
    
    public ArrayList<Object> buscarMedalla(String nombre) throws SQLException{
        
        boolean resultadoConexion = this.conectar();
        
        ArrayList<Object> datosMedalla = new ArrayList<>();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaMedalla = "SELECT * FROM MEDALLA WHERE NOMBRE = '" + nombre +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaMedalla);
            
                if(resultadoBusqueda.next()) {
                
                    nombre = resultadoBusqueda.getString(1);                    
                    datosMedalla.add(nombre);
                    
                    String potenciador = resultadoBusqueda.getString(2);                    
                    datosMedalla.add(potenciador);
                    
                    int cantidad = resultadoBusqueda.getInt(3);                    
                    datosMedalla.add(cantidad);
                    
                    String tipoCarga = resultadoBusqueda.getString(4);                    
                    datosMedalla.add(tipoCarga);
                    
                    String medafuerza = resultadoBusqueda.getString(5);                    
                    datosMedalla.add(medafuerza);
                    
                }           
            
            }  
            
        }
        
        return datosMedalla;
        
    }
    
    public ArrayList<Object> buscarMedaparte(String nombre) throws SQLException{
        
        boolean resultadoConexion = this.conectar();
        
        ArrayList<Object> datosMedaparte = new ArrayList<>();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaMedalla = "SELECT * FROM MEDAPARTE WHERE NOMBRE = '" + nombre +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaMedalla);
            
                if(resultadoBusqueda.next()) {
                
                    nombre = resultadoBusqueda.getString(1);                    
                    datosMedaparte.add(nombre);
                    
                    int saludMaxima = resultadoBusqueda.getInt(2);                    
                    datosMedaparte.add(saludMaxima);
                    
                    String tipo = resultadoBusqueda.getString(3);                    
                    datosMedaparte.add(tipo);
                    
                    int ataque = resultadoBusqueda.getInt(4);                    
                    datosMedaparte.add(ataque);
                    
                    String habilidad = resultadoBusqueda.getString(5);                    
                    datosMedaparte.add(habilidad);
                    
                    int defensa = resultadoBusqueda.getInt(6);                    
                    datosMedaparte.add(defensa);
                    
                    int precision = resultadoBusqueda.getInt(7);                    
                    datosMedaparte.add(precision);
                    
                    int recuperacion = resultadoBusqueda.getInt(8);                    
                    datosMedaparte.add(recuperacion);
                    
                    int esquive = resultadoBusqueda.getInt(9);                    
                    datosMedaparte.add(esquive);
                    
                    int puntosHabilidad = resultadoBusqueda.getInt(10);                    
                    datosMedaparte.add(puntosHabilidad);
                    
                }           
            
            }  
            
        }
        
        return datosMedaparte;
        
    }
    
    public ArrayList<Object> buscarJugador(String nombre) throws SQLException{
        
        boolean resultadoConexion = this.conectar();
        
        ArrayList<Object> datosJugador = new ArrayList<>();
        
        if(resultadoConexion == true) {
            
            Statement stmt = this.crearConsulta();
        
            if(stmt != null) {
            
                String consultaUsuario = "SELECT * FROM USUARIO WHERE NOMBRE = '" + nombre +"'";
        
                ResultSet resultadoBusqueda= stmt.executeQuery(consultaUsuario);
            
                if(resultadoBusqueda.next()) {
                
                    nombre = resultadoBusqueda.getString(1);                    
                    datosJugador.add(nombre);
                    
                    String pass = resultadoBusqueda.getString(2);                    
                    datosJugador.add(pass);
                    
                    String tipo = resultadoBusqueda.getString(3);                    
                    datosJugador.add(tipo);
                    
                    int victorias = resultadoBusqueda.getInt(4);                    
                    datosJugador.add(victorias);
                    
                    int derrotas = resultadoBusqueda.getInt(5);                    
                    datosJugador.add(derrotas);
                    
                    int torneos = resultadoBusqueda.getInt(6);                    
                    datosJugador.add(torneos);
                    
                }           
            
            }  
            
        }
        
        return datosJugador;
        
    }
        
}
    

