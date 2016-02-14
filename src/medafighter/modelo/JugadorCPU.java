/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.modelo;

import java.sql.SQLException;
import java.util.ArrayList;


public class JugadorCPU extends Jugador {
    
    private String tipoCPU; 
    
    public JugadorCPU (String nombre, String versionMedabot) throws SQLException {
    
        this.cbd = new ConexionBD();
        
        this.nombre = nombre;
        
        ArrayList<Object> datosJugador = new ArrayList<>();
        
        datosJugador = cbd.buscarJugador(this.nombre);
        
        this.tipo = (String)datosJugador.get(2);
        
        this.victorias = (Integer)datosJugador.get(3);
        
        this.derrotas = (Integer)datosJugador.get(4);
        
        this.torneos = (Integer)datosJugador.get(5);
        
        this.tipoCPU = this.nombre.substring(this.nombre.length()-1);
        
        String nombreMedabot = new String();
        
        if (versionMedabot.equals("Version 1")) {
            
            nombreMedabot = ""+this.nombre+"V1" ;
            
        }
        
        if (versionMedabot.equals("Version 2")) {
            
            nombreMedabot = ""+this.nombre+"V2" ;
            
        }
        
        if (versionMedabot.equals("Version 3")) {
            
            nombreMedabot = ""+this.nombre+"V3" ;
            
        }
        
        this.medabot = new Medabot(nombreMedabot, this.nombre);
    
    }
    
    public String getTipoCPU(){
        return this.tipoCPU;
    }
    
}
