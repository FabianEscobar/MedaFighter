/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import medafighter.vistas.VistaIngreso;

/**
 *
 * @author Fabián
 */
public class ControladorIngreso implements ActionListener {
    
    private VistaIngreso vi;
    
    private ControladorRegistro cr;
    
    private ControladorMenu cm;
    
    public ControladorIngreso() {
        
        this.vi = new VistaIngreso(this);        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vi != null){           
            
            if (((JButton)ae.getSource()).equals(this.vi.getIngresar())){
                
                                
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vi.getRegistrarse())){
                
                this.cr = new ControladorRegistro();
                
                this.vi.setVisible(false);
                
                this.vi.dispose();                
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vi.getSalir())){
                
                System.exit(0);
                
            }            
            
        } 
        
    }
    
    
}