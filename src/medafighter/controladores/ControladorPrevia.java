/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import medafighter.modelo.ConexionBD;
import medafighter.vistas.DialogIngreso;
import medafighter.vistas.VistaPrevia;

/**
 *
 * @author Fabián
 */
public class ControladorPrevia implements ActionListener {
    
    private VistaPrevia vp;
    
    private ControladorMenu cm;
    
    private ControladorCombate cc;
    
    private ConexionBD cbd;
    
    private DialogIngreso di;
    
    public ControladorPrevia() {
    
        this.vp = new VistaPrevia(this);
        
        this.cbd = new ConexionBD();
    
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if ((ae.getSource()).equals(this.vp.getRobobatalla())){
            
            String jugador1 = (String)this.vp.getJugador1L().getSelectedValue();
            
            String jugador2 = (String)this.vp.getJugador2L().getSelectedValue();
            
            boolean uBoolean1 = false;
            
            boolean uBoolean2 = false;
            
            String tipoJugador1 = new String();
                    
            String tipoJugador2 = new String();
            
            try {       
                
                tipoJugador1 = this.cbd.buscarTipoJugador(jugador1);
                
                tipoJugador2 = this.cbd.buscarTipoJugador(jugador2);
                
            } 
            
            catch (SQLException ex) {
                
                Logger.getLogger(ControladorPrevia.class.getName()).log(Level.SEVERE, null, ex);
            
            }
                    
            try {
                
                uBoolean1 = this.cbd.verificarSesion(jugador1);
                
                uBoolean2 = this.cbd.verificarSesion(jugador2);
            
            } 
            
            catch (SQLException ex) {
                
                Logger.getLogger(ControladorPrevia.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            
            if(tipoJugador1.equals("HUMANO")) {
                
                if(uBoolean1 = false) {
                    
                    di = new DialogIngreso(this.vp,true,jugador1);
                    
                }                
                
            }
            
            if(tipoJugador2.equals("HUMANO")) {
                
                if(uBoolean2 = false) {
                    
                    di = new DialogIngreso(this.vp,true,jugador2);                  
                    
                }                
                
            }
            
            try {
                
                uBoolean1 = this.cbd.verificarSesion(jugador1);
                
                uBoolean2 = this.cbd.verificarSesion(jugador2);
            
            } 
            
            catch (SQLException ex) {
                
                Logger.getLogger(ControladorPrevia.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            
            if(tipoJugador1.equals("CPU")) uBoolean1 = true;
            
            if(tipoJugador2.equals("CPU")) uBoolean2 = true;
            
            if((uBoolean1 == true)&&(uBoolean2 == true)) {
                
                this.cc = new ControladorCombate(jugador1,jugador2);
                       
                this.vp.setVisible(false);
                
                this.vp.dispose();
                
            }
            
            else {
                
                JOptionPane.showMessageDialog(this.vp, "No ha sido posible iniciar la partida debido a que no todos los jugadores fueron ingresados. Si desea iniciar una partida, puede hacer otro intento ingresando a los jugadores que falten.");
                
            }
             
        }
        
        if ((ae.getSource()).equals(this.vp.getVolver())){
            
            this.cm = new ControladorMenu();
                       
            this.vp.setVisible(false);
                
            this.vp.dispose();
            
        }
    
    
    }
    
}
