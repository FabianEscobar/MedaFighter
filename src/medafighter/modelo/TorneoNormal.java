/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.modelo;

import java.util.ArrayList;


public class TorneoNormal extends Torneo {
    
    public TorneoNormal(ArrayList<String> jugadores, ArrayList<String> medabots, String tipoTorneo) {
    
        this.cbd = new ConexionBD();
        
        this.participantes = new ArrayList<Jugador>();     
        
        this.batallas = new ArrayList<Robobatalla>();
        
        
    
    }

    @Override
    public void recuperacion(ArrayList<Jugador> participantes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
