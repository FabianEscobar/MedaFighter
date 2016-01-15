/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import medafighter.vistas.VistaMenu;

/**
 *
 * @author Fabián
 */
public class ControladorMenu implements ActionListener {
    
    private VistaMenu vm;
    
    private ControladorPrevia cp;
    
    private ControladorMedabot cmed;
    
    private ControladorTorneo ct;
    
    private ControladorIngreso ci;
    
    public ControladorMenu() {
        
        this.vm = new VistaMenu(this);        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vm != null){
    
            if (((JButton)ae.getSource()).equals(this.vm.getAjustesMedabot())){
                
                this.cmed = new ControladorMedabot();
                       
                this.vm.setVisible(false);
                
                this.vm.dispose();
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vm.getRobobatalla())){
                
                this.cp = new ControladorPrevia();
                       
                this.vm.setVisible(false);
                
                this.vm.dispose();
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vm.getTorneo())){
                
                this.ct = new ControladorTorneo();
                       
                this.vm.setVisible(false);
                
                this.vm.dispose();
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vm.getCerrarSesion())){
                
                this.ci = new ControladorIngreso();
                       
                this.vm.setVisible(false);
                
                this.vm.dispose();
                
            }
    
        }
        
    }
    
}
