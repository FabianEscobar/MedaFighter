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
import javax.swing.JButton;
import medafighter.modelo.ConexionBD;
import medafighter.vistas.VistaCombate;
import medafighter.modelo.*;

/**
 *
 * @author Fabián
 */
public class ControladorCombate implements ActionListener {
    
    private VistaCombate vc;
    
    private ConexionBD cbd;
    
    private Jugador jugador1;    
    private Jugador jugador2;
    
    private Medabot medabotJ1;    
    private Medabot medabotJ2;
            
    private Medalla medallaJ1;
    private Medalla medallaJ2;
    
    private Robobatalla robobatalla;
    
    private Torneo torneo;
    
    public ControladorCombate(String jugador1, String jugador2, String versionMedabotJ1, String versionMedabotJ2, String modoJuego) throws SQLException {
        
        this.cbd = new ConexionBD();
        
        if (modoJuego.equals("Jugador v/s Jugador")) {
            
            this.jugador1 = new JugadorHumano(jugador1, versionMedabotJ1);
            this.jugador2 = new JugadorHumano(jugador2, versionMedabotJ2);
            
        }
        
        if (modoJuego.equals("Jugador v/s CPU")) {
            
            this.jugador1 = new JugadorHumano(jugador1, versionMedabotJ1);
            this.jugador2 = new JugadorCPU(jugador1, versionMedabotJ1);
            
        }
        
        if (modoJuego.equals("CPU V/S CPU")) {
            
            this.jugador1 = new JugadorCPU(jugador1, versionMedabotJ1);
            this.jugador2 = new JugadorCPU(jugador1, versionMedabotJ1);
            
        }
        
        this.robobatalla = new Robobatalla(this.jugador1,this.jugador2);
        
        this.vc = new VistaCombate(this,this.jugador1,this.jugador2);
           
    }
    
    public ControladorCombate(ArrayList<String> jugadores, String tipoTorneo) {
        
        this.vc = new VistaCombate(this,this.jugador1,this.jugador2);
        
        this.cbd = new ConexionBD();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (((JButton)ae.getSource()).equals(this.vc.getAtacarJ1())) {
            
            
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getAtacarJ2())) {
            
            
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getDefenderJ1())) {
            
            
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getDefenderJ2())) {
            
            
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getEsquivarJ1())) {
            
            
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getEsquivarJ2())) {
            
            
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getRendirseJ1())) {
            
            
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getRendirseJ2())) {
            
            
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getMedafuerzaJ1())) {
            
            
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getMedafuerzaJ2())) {
            
            
            
        }
    
    }
    
}
