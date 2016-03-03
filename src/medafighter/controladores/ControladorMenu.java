/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Paquete contenedor*/
package medafighter.controladores;

/* Clases importadas */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        // El menu consiste en varios botones y cada uno abre vistas distintas.
        // Tambien es posible cerrar sesion (se cerraran todas las sesiones activas 
        
        if(vm != null){
    
            if (((JButton)ae.getSource()).equals(this.vm.getAjustesMedabot())){
                
                try {
                    
                    this.cmed = new ControladorMedabot();
                
                } 
                
                catch (SQLException ex) {
                    
                    Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                       
                this.vm.setVisible(false);
                
                this.vm.dispose();
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vm.getRobobatalla())){
                
                this.cp = new ControladorPrevia();
                       
                this.vm.setVisible(false);
                
                this.vm.dispose();
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vm.getTorneo())){
                
                try {
                    
                    this.ct = new ControladorTorneo();
                } 
                
                catch (SQLException ex) {
                    
                    Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                       
                this.vm.setVisible(false);
                
                this.vm.dispose();
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vm.getCerrarSesion())){
                
                try {
                    
                    this.ci = new ControladorIngreso();
                } 
                
                catch (SQLException ex) {
                    
                    Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                       
                this.vm.setVisible(false);
                
                this.vm.dispose();
                
            }
    
        }
        
    }
    
}
