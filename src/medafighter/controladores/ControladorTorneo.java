/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import medafighter.modelo.ConexionBD;
import medafighter.vistas.VistaTorneo;

/**
 *
 * @author Fabián
 */
public class ControladorTorneo implements ActionListener {
    
    private VistaTorneo vt;
    
    private ControladorCombate cc;
    
    private ControladorMenu cm;
    
    private ConexionBD cbd;
    
    public ControladorTorneo() {
        
        this.vt = new VistaTorneo(this);        
        
    }
    
    public String[] buscarJugadores() throws SQLException {
        
        String[] jugadores = this.cbd.buscarJugadores();
        
        return jugadores;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vt != null){
            
            if (((JButton)ae.getSource()).equals(this.vt.getTorneo())){
                
                this.cc = new ControladorCombate();
                       
                this.vt.setVisible(false);
                
                this.vt.dispose();
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vt.getVolver())){
                
                this.cm = new ControladorMenu();
                       
                this.vt.setVisible(false);
                
                this.vt.dispose();
                
            }
            
            if (((JComboBox)ae.getSource()).equals(this.vt.getJugador1())||
                    
                ((JComboBox)ae.getSource()).equals(this.vt.getJugador2())||
                    
                ((JComboBox)ae.getSource()).equals(this.vt.getJugador3())||
                    
                ((JComboBox)ae.getSource()).equals(this.vt.getJugador4())||
                    
                ((JComboBox)ae.getSource()).equals(this.vt.getJugador5())||
                    
                ((JComboBox)ae.getSource()).equals(this.vt.getJugador6())||
                    
                ((JComboBox)ae.getSource()).equals(this.vt.getJugador7())||
                    
                ((JComboBox)ae.getSource()).equals(this.vt.getJugador8())){
                
                try {
                    
                    String[] jugadores = null; 
                            
                    jugadores = buscarJugadores();
                
                } 
                
                catch (SQLException ex) {
                    
                    Logger.getLogger(ControladorTorneo.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                
            }
            
            
        }
        
    }
    
}
