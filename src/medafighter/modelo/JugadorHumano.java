/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.modelo;

import java.sql.SQLException;
import java.util.ArrayList;


public class JugadorHumano extends Jugador {
    
    public JugadorHumano (String nombre, String versionMedabot) throws SQLException {
    
        this.cbd = new ConexionBD();
        
        this.nombre = nombre;
        
        String nombreMedabot = new String();
                
        nombreMedabot = this.cbd.buscarNombreMedabot(this.nombre);
        
        ArrayList<Object> datosJugador = new ArrayList<>();
        
        datosJugador = cbd.buscarJugador(this.nombre);
        
        this.tipo = (String)datosJugador.get(2);
        
        this.victorias = (Integer)datosJugador.get(3);
        
        this.derrotas = (Integer)datosJugador.get(4);
        
        this.torneos = (Integer)datosJugador.get(5);
        
        if (versionMedabot.equals("Version 1")) {
            
            nombreMedabot = ""+nombreMedabot+"V1" ;
            
        }
        
        if (versionMedabot.equals("Version 2")) {
            
            nombreMedabot = ""+nombreMedabot+"V2" ;
            
        }
        
        if (versionMedabot.equals("Version 3")) {
            
            nombreMedabot = ""+nombreMedabot+"V3" ;
            
        }
        
        this.medabot = new Medabot(nombreMedabot, this.nombre);
    
    }

    @Override
    public String getTipoCPU() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
