/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import medafighter.vistas.VistaCombate;

/**
 *
 * @author Fabián
 */
public class ControladorCombate implements ActionListener {
    
    private VistaCombate vc;
    
    
    public ControladorCombate(String jugador1, String jugador2, String medabotJ1, String medabotJ2, String modoJuego) {
        
        this.vc = new VistaCombate(this);        
        
    }
    
    public ControladorCombate(ArrayList<String> jugadores, String tipoTorneo) {
        
        this.vc = new VistaCombate(this);        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
