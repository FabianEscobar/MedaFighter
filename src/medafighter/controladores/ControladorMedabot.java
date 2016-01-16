/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import medafighter.modelo.ConexionBD;
import medafighter.vistas.VistaMedabot;

/**
 *
 * @author Fabián
 */
public class ControladorMedabot implements ActionListener {
    
    private VistaMedabot vmed;
    
    private ControladorMenu cm;
    
    private ConexionBD cbd;
    
    public ControladorMedabot() {
        
        this.vmed = new VistaMedabot(this);        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
