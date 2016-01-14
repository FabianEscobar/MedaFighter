/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import medafighter.vistas.VistaRegistro;

/**
 *
 * @author Fabián
 */
public class ControladorRegistro implements ActionListener {
    
    private VistaRegistro vr;
    
    private ControladorIngreso ci;
    
    public ControladorRegistro() {
        
        this.vr = new VistaRegistro(this);        
        
    }    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vr != null){           
            
            if (((JButton)ae.getSource()).equals(this.vr.getRegistrarse())){
                
                                
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vr.getVolver())){
                
                this.ci = new ControladorIngreso();
                
                this.vr.setVisible(false);
                
                this.vr.dispose();                
                
            }          
            
        } 
    
    }
    
}
