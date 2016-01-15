/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import medafighter.vistas.VistaTorneo;

/**
 *
 * @author Fabián
 */
public class ControladorTorneo implements ActionListener {
    
    private VistaTorneo vt;
    
    private ControladorCombate cc;
    
    private ControladorMenu cm;
    
    public ControladorTorneo() {
        
        this.vt = new VistaTorneo(this);        
        
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
                
                
                
            }
            
            
        }
        
    }
    
}
