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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
    
    public ControladorTorneo() throws SQLException {
        
        this.vt = new VistaTorneo(this);        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vt != null){
            
            if ((ae.getSource()).equals(this.vt.getTorneo())){
                
                ArrayList<String> jugadores = new ArrayList<>();
                
                String jugador1 = (String)this.vt.getJugador1().getSelectedItem();
                jugadores.add(jugador1);
                
                String jugador2 = (String)this.vt.getJugador1().getSelectedItem();
                jugadores.add(jugador2);
                
                String jugador3 = (String)this.vt.getJugador1().getSelectedItem();
                jugadores.add(jugador3);
                
                String jugador4 = (String)this.vt.getJugador1().getSelectedItem();
                jugadores.add(jugador4);
                
                String jugador5 = (String)this.vt.getJugador1().getSelectedItem();
                jugadores.add(jugador5);
                
                String jugador6 = (String)this.vt.getJugador1().getSelectedItem();
                jugadores.add(jugador6);
                
                String jugador7 = (String)this.vt.getJugador1().getSelectedItem();
                jugadores.add(jugador7);
                
                String jugador8 = (String)this.vt.getJugador1().getSelectedItem();
                jugadores.add(jugador8);
                
                boolean validador = true;
                
                for (int i = 0; i < jugadores.size()-1; i++) {
			
                    for (int j = i+1; j < jugadores.size(); j++) {
			
                        if(jugadores.get(i).equals(jugadores.get(j))){                            
                                                        
                            validador = false;
                            
                        }
		
                    }
		
                }
                
                if (validador == true){
                    
                    this.cc = new ControladorCombate(jugadores);
                       
                    this.vt.setVisible(false);
                
                    this.vt.dispose();
                    
                }
                    
                else {
                            
                JOptionPane.showMessageDialog(vt, "Los jugadores sólo pueden estar en una posición.");     
                    
                }  
                
            }
            
            if ((ae.getSource()).equals(this.vt.getVolver())){
                
                this.cm = new ControladorMenu();
                       
                this.vt.setVisible(false);
                
                this.vt.dispose();
                
            }
            
        }
        
    }
    
}
