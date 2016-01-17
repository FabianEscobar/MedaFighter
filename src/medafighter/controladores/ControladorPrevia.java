/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import medafighter.vistas.VistaPrevia;

/**
 *
 * @author Fabián
 */
public class ControladorPrevia implements ActionListener {
    
    private VistaPrevia vp;
    
    private ControladorMenu cm;
    
    private ControladorCombate cc;
    
    public ControladorPrevia() {
    
        this.vp = new VistaPrevia(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if ((ae.getSource()).equals(this.vp.getRobobatalla())){
            
            String jugador1 = (String)this.vp.getJugador1L().getSelectedValue();
            
            String jugador2 = (String)this.vp.getJugador2L().getSelectedValue();
            
            this.cc = new ControladorCombate(jugador1,jugador2);
                       
            this.vp.setVisible(false);
                
            this.vp.dispose();
            
        }
        
        if ((ae.getSource()).equals(this.vp.getVolver())){
            
            this.cm = new ControladorMenu();
                       
            this.vp.setVisible(false);
                
            this.vp.dispose();
            
        }
    
    
    }
    
}
