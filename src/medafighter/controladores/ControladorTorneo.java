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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import medafighter.modelo.ConexionBD;
import medafighter.vistas.DialogIngreso;
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
    
    private DialogIngreso di;
    
    public ControladorTorneo() throws SQLException {
        
        this.vt = new VistaTorneo(this);
        
        this.cbd = new ConexionBD();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vt != null){
            
            if ((ae.getSource()).equals(this.vt.getTorneo())){
                
                ArrayList<String> jugadores = new ArrayList<>();
                
                ArrayList<String> medabots = new ArrayList<>();
                
                String jugador1 = (String)this.vt.getJugador1().getSelectedItem();
                jugadores.add(jugador1);
                
                String jugador2 = (String)this.vt.getJugador2().getSelectedItem();
                jugadores.add(jugador2);
                
                String jugador3 = (String)this.vt.getJugador3().getSelectedItem();
                jugadores.add(jugador3);
                
                String jugador4 = (String)this.vt.getJugador4().getSelectedItem();
                jugadores.add(jugador4);
                
                String jugador5 = (String)this.vt.getJugador5().getSelectedItem();
                jugadores.add(jugador5);
                
                String jugador6 = (String)this.vt.getJugador6().getSelectedItem();
                jugadores.add(jugador6);
                
                String jugador7 = (String)this.vt.getJugador7().getSelectedItem();
                jugadores.add(jugador7);
                
                String jugador8 = (String)this.vt.getJugador8().getSelectedItem();
                jugadores.add(jugador8);
                                
                String medabot1 = (String)this.vt.getMedabot1().getSelectedItem();
                medabots.add(medabot1);
                
                String medabot2 = (String)this.vt.getMedabot2().getSelectedItem();
                medabots.add(medabot2);
                
                String medabot3 = (String)this.vt.getMedabot3().getSelectedItem();
                medabots.add(medabot3);
                
                String medabot4 = (String)this.vt.getMedabot4().getSelectedItem();
                medabots.add(medabot4);
                
                String medabot5 = (String)this.vt.getMedabot5().getSelectedItem();
                medabots.add(medabot5);
                
                String medabot6 = (String)this.vt.getMedabot6().getSelectedItem();
                medabots.add(medabot6);
                
                String medabot7 = (String)this.vt.getMedabot7().getSelectedItem();
                medabots.add(medabot7);
                
                String medabot8 = (String)this.vt.getMedabot8().getSelectedItem();
                medabots.add(medabot8);
                
                boolean validador = true;
                
                for (int i = 0; i < jugadores.size()-1; i++) {
			
                    for (int j = i+1; j < jugadores.size(); j++) {
			
                        if(jugadores.get(i).equals(jugadores.get(j))){                            
                                                        
                            validador = false;
                            
                            break;
                            
                        }
		
                    }
		
                }
                
                if (validador == true){
                    
                    boolean uBoolean1 = false;
                    boolean uBoolean2 = false;
                    boolean uBoolean3 = false;
                    boolean uBoolean4 = false;
                    boolean uBoolean5 = false;
                    boolean uBoolean6 = false;
                    boolean uBoolean7 = false;
                    boolean uBoolean8 = false;
                    
                    String tipoJugador1 = new String();                    
                    String tipoJugador2 = new String();
                    String tipoJugador3 = new String();
                    String tipoJugador4 = new String();
                    String tipoJugador5 = new String();
                    String tipoJugador6 = new String();
                    String tipoJugador7 = new String();
                    String tipoJugador8 = new String();
            
                    try {       
                
                        tipoJugador1 = this.cbd.buscarTipoJugador(jugador1);                
                        tipoJugador2 = this.cbd.buscarTipoJugador(jugador2);
                        tipoJugador3 = this.cbd.buscarTipoJugador(jugador3);
                        tipoJugador4 = this.cbd.buscarTipoJugador(jugador4);
                        tipoJugador5 = this.cbd.buscarTipoJugador(jugador5);
                        tipoJugador6 = this.cbd.buscarTipoJugador(jugador6);
                        tipoJugador7 = this.cbd.buscarTipoJugador(jugador7);
                        tipoJugador8 = this.cbd.buscarTipoJugador(jugador8);
                
                    } 
            
                    catch (SQLException ex) {
                
                        Logger.getLogger(ControladorTorneo.class.getName()).log(Level.SEVERE, null, ex);
            
                    }
                    
                    try {
                
                        uBoolean1 = this.cbd.verificarSesion(jugador1);
                        uBoolean2 = this.cbd.verificarSesion(jugador2);
                        uBoolean3 = this.cbd.verificarSesion(jugador3);
                        uBoolean4 = this.cbd.verificarSesion(jugador4);
                        uBoolean5 = this.cbd.verificarSesion(jugador5);
                        uBoolean6 = this.cbd.verificarSesion(jugador6);
                        uBoolean7 = this.cbd.verificarSesion(jugador7);
                        uBoolean8 = this.cbd.verificarSesion(jugador8);
            
                    } 
            
                    catch (SQLException ex) {
                
                        Logger.getLogger(ControladorTorneo.class.getName()).log(Level.SEVERE, null, ex);
            
                    }
                    
                    if(tipoJugador1.equals("HUMANO")) {
                
                        if(uBoolean1 == false) {
                    
                            di = new DialogIngreso(this.vt,true,jugador1);
                    
                        }                
                
                    }
                    
                    if(tipoJugador2.equals("HUMANO")) {
                
                        if(uBoolean2 == false) {
                    
                            di = new DialogIngreso(this.vt,true,jugador2);
                    
                        }                
                
                    }
                    
                    if(tipoJugador3.equals("HUMANO")) {
                
                        if(uBoolean3 == false) {
                    
                            di = new DialogIngreso(this.vt,true,jugador3);
                    
                        }                
                
                    }
                    
                    if(tipoJugador4.equals("HUMANO")) {
                
                        if(uBoolean4 == false) {
                    
                            di = new DialogIngreso(this.vt,true,jugador4);
                    
                        }                
                
                    }
                    
                    if(tipoJugador5.equals("HUMANO")) {
                
                        if(uBoolean5 == false) {
                    
                            di = new DialogIngreso(this.vt,true,jugador5);
                    
                        }                
                
                    }
                    
                    if(tipoJugador6.equals("HUMANO")) {
                
                        if(uBoolean6 == false) {
                    
                            di = new DialogIngreso(this.vt,true,jugador6);
                    
                        }                
                
                    }
                    
                    if(tipoJugador7.equals("HUMANO")) {
                
                        if(uBoolean7 == false) {
                    
                            di = new DialogIngreso(this.vt,true,jugador7);
                    
                        }                
                
                    }
                    
                    if(tipoJugador8.equals("HUMANO")) {
                
                        if(uBoolean8 == false) {
                    
                            di = new DialogIngreso(this.vt,true,jugador8);
                    
                        }                
                
                    }
                    
                    try {
                
                        uBoolean1 = this.cbd.verificarSesion(jugador1);
                        uBoolean2 = this.cbd.verificarSesion(jugador2);
                        uBoolean3 = this.cbd.verificarSesion(jugador3);
                        uBoolean4 = this.cbd.verificarSesion(jugador4);
                        uBoolean5 = this.cbd.verificarSesion(jugador5);
                        uBoolean6 = this.cbd.verificarSesion(jugador6);
                        uBoolean7 = this.cbd.verificarSesion(jugador7);
                        uBoolean8 = this.cbd.verificarSesion(jugador8);
            
                    } 
            
                    catch (SQLException ex) {
                
                        Logger.getLogger(ControladorTorneo.class.getName()).log(Level.SEVERE, null, ex);
            
                    }
                    
                    if(tipoJugador1.equals("CPU")) uBoolean1 = true;
                    if(tipoJugador2.equals("CPU")) uBoolean2 = true;
                    if(tipoJugador3.equals("CPU")) uBoolean3 = true;
                    if(tipoJugador4.equals("CPU")) uBoolean4 = true;
                    if(tipoJugador5.equals("CPU")) uBoolean5 = true;
                    if(tipoJugador6.equals("CPU")) uBoolean6 = true;
                    if(tipoJugador7.equals("CPU")) uBoolean7 = true;
                    if(tipoJugador8.equals("CPU")) uBoolean8 = true;
                    
                    if((uBoolean1 == true)&&(uBoolean2 == true)&&
                       (uBoolean3 == true)&&(uBoolean4 == true)&&
                       (uBoolean5 == true)&&(uBoolean6 == true)&&
                       (uBoolean7 == true)&&(uBoolean8 == true)) {
                
                        String tipoTorneo = (String)this.vt.getTipoTorneo().getSelectedItem();
                    
                        try {
                            
                            this.cc = new ControladorCombate(jugadores, medabots, tipoTorneo);
                        
                        } 
                        
                        catch (SQLException ex) {
                        
                            Logger.getLogger(ControladorTorneo.class.getName()).log(Level.SEVERE, null, ex);
                        
                        }
                       
                        this.vt.setVisible(false);
                
                        this.vt.dispose();
                
                    }
            
                    else {
                
                        JOptionPane.showMessageDialog(this.vt, "No ha sido posible iniciar el torneo debido a que no todos los jugadores fueron ingresados. Si desea iniciar un torneo, puede hacer otro intento ingresando a los jugadores que falten.");
                
                    }
                    
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
