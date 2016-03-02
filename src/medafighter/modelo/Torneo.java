/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.modelo;

import java.util.ArrayList;

/**
 *
 * @author Fabián
 */
public abstract class Torneo {
    
    protected ArrayList<Jugador> participantes;
    
    protected ArrayList<Robobatalla> batallas;
    
    protected String tipoTorneo;
    
    protected ConexionBD cbd;
    
    public void realizarBatallas(){
        
        
    }
    
    public ArrayList<Jugador> eliminacion(ArrayList<Jugador> participantes){
              
    return participantes;    
        
    }
    
    public abstract void recuperacion(ArrayList<Jugador> participantes);
    
}
