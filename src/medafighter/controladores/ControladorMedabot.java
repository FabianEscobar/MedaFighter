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
import medafighter.vistas.VistaMedabot;

/**
 *
 * @author Fabián
 */
public class ControladorMedabot implements ActionListener {
    
    private VistaMedabot vmed;
    
    private ControladorMenu cm;
    
    private ConexionBD cbd;
    
    private DialogIngreso di;
    
    public ControladorMedabot() throws SQLException {
        
        this.vmed = new VistaMedabot(this); 
        
        this.cbd = new ConexionBD();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {        
        
        if ((ae.getSource()).equals(this.vmed.getGuardar())) {
            
            String jugador = (String)this.vmed.getJugador().getSelectedItem();
            
            boolean uBoolean = false;
            
            try {
                
                uBoolean = this.cbd.verificarSesion(jugador);
            } 
            
            catch (SQLException ex) {
                
                Logger.getLogger(ControladorMedabot.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            
            if (uBoolean == false) {
                
                di = new DialogIngreso(this.vmed,true,jugador);
                
            }
            
            try {
                
                uBoolean = this.cbd.verificarSesion(jugador);
            
            } 
            
            catch (SQLException ex) {
                
                Logger.getLogger(ControladorMedabot.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            
            if (uBoolean == true) {
                
                ArrayList<String> medapartes = new ArrayList<>();
            
                String cabeza = (String)this.vmed.getCabeza().getSelectedItem();
                medapartes.add(cabeza);
            
                String brazoIzq = (String)this.vmed.getBrazoIzquierdo().getSelectedItem();
                medapartes.add(brazoIzq);
            
                String brazoDer = (String)this.vmed.getBrazoDerecho().getSelectedItem();
                medapartes.add(brazoDer);
            
                String piernaIzq = (String)this.vmed.getPiernaIzquierda().getSelectedItem();
                medapartes.add(piernaIzq);
            
                String piernaDer = (String)this.vmed.getPiernaDerecha().getSelectedItem();
                medapartes.add(piernaDer);
            
                String medalla = (String)this.vmed.getMedalla().getSelectedItem();
                        
                String versionMedabot = (String)this.vmed.getVersionMedabot().getSelectedItem();
            
                boolean medabotGuardado = false;
                        
                try {
                    
                    medabotGuardado = this.cbd.guardarMedabot(versionMedabot, jugador, medapartes, medalla);
                
                } 
                
                catch (SQLException ex) {
                    
                    Logger.getLogger(ControladorMedabot.class.getName()).log(Level.SEVERE, null, ex);
                        
                    JOptionPane.showMessageDialog(this.vmed, "Hubo un error al actualizar los datos. Consulte con el desarrollador del la aplicación.");
                
                }
                    
                if (medabotGuardado == true) {
                        
                    JOptionPane.showMessageDialog(this.vmed, "Cambios guardados exitosamente.");
                
                }
                
            }
            
            else {
                
                JOptionPane.showMessageDialog(this.vmed, "No ha sido posible guardar los cambios debido a que no se ha iniciado sesión. Si desea guardar los cambios, puede hacer otro intento ingresando al juego.");
                
            }
            
        }
        
        if ((ae.getSource()).equals(this.vmed.getVolver())) {
            
            this.cm = new ControladorMenu();
                       
            this.vmed.setVisible(false);
                
            this.vmed.dispose();
            
        }
    
    }
    
}
