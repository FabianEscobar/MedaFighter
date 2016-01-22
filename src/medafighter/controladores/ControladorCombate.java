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
        
        this.robobatalla = new Robobatalla(jugador1,jugador2,versionMedabotJ1,versionMedabotJ2,modoJuego);
        
        this.vc = new VistaCombate(this,this.robobatalla);
           
    }
    
    public ControladorCombate(ArrayList<String> jugadores, String tipoTorneo) {
        
        this.vc = new VistaCombate(this,this.robobatalla);
        
        this.cbd = new ConexionBD();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (((JButton)ae.getSource()).equals(this.vc.getAtacarJ1())) {
            
            String mpAtacante = (String)this.vc.getAtacanteJ1().getSelectedItem();
            String mpDefensora = (String)this.vc.getDefensorJ2().getSelectedItem();
            
            if (mpAtacante.equals("Cabeza")) {
                
                if (mpDefensora.equals("Cabeza")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                if (mpDefensora.equals("Brazo Izquierdo")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                if (mpDefensora.equals("Brazo Derecho")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                if (mpDefensora.equals("Pierna Izquierda")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                if (mpDefensora.equals("Pierna Derecha")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
            }
            
            if (mpAtacante.equals("Brazo Izquierdo")) {
                
                if (mpDefensora.equals("Cabeza")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                if (mpDefensora.equals("Brazo Izquierdo")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                if (mpDefensora.equals("Brazo Derecho")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                if (mpDefensora.equals("Pierna Izquierda")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                if (mpDefensora.equals("Pierna Derecha")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
            }
            
            if (mpAtacante.equals("Brazo Derecho")) {
                
                if (mpDefensora.equals("Cabeza")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                if (mpDefensora.equals("Brazo Izquierdo")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                if (mpDefensora.equals("Brazo Derecho")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                if (mpDefensora.equals("Pierna Izquierda")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                if (mpDefensora.equals("Pierna Derecha")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
            }
            
            if (mpAtacante.equals("Pierna Izquierda")) {
                
                if (mpDefensora.equals("Cabeza")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                if (mpDefensora.equals("Brazo Izquierdo")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                if (mpDefensora.equals("Brazo Derecho")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                if (mpDefensora.equals("Pierna Izquierda")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                if (mpDefensora.equals("Pierna Derecha")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
            }
            
            if (mpAtacante.equals("Pierna Derecha")) {
                
                if (mpDefensora.equals("Cabeza")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                if (mpDefensora.equals("Brazo Izquierdo")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                if (mpDefensora.equals("Brazo Derecho")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                if (mpDefensora.equals("Pierna Izquierda")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                if (mpDefensora.equals("Pierna Derecha")) this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
            }
            
            this.vc.setSaludCabezaM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual()));
            this.vc.setSaludBrazoIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual()));
            this.vc.setSaludBrazoDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual()));
            this.vc.setSaludPiernaIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual()));
            this.vc.setSaludPiernaDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual()));
            
            this.vc.setPHCabezaM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getCabeza().getPH()));
            this.vc.setPHBrazoIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getPH()));
            this.vc.setPHBrazoDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getPH()));
            this.vc.setPHPiernaIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getPH()));
            this.vc.setPHPiernaDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getPH()));
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getAtacarJ2())) {
            
            String mpAtacante = (String)this.vc.getAtacanteJ2().getSelectedItem();
            String mpDefensora = (String)this.vc.getDefensorJ1().getSelectedItem();
            
            if (mpAtacante.equals("Cabeza")) {
                
                if (mpDefensora.equals("Cabeza")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                if (mpDefensora.equals("Brazo Izquierdo")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                if (mpDefensora.equals("Brazo Derecho")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                if (mpDefensora.equals("Pierna Izquierda")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                if (mpDefensora.equals("Pierna Derecha")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
            }
            
            if (mpAtacante.equals("Brazo Izquierdo")) {
                
                if (mpDefensora.equals("Cabeza")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                if (mpDefensora.equals("Brazo Izquierdo")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                if (mpDefensora.equals("Brazo Derecho")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                if (mpDefensora.equals("Pierna Izquierda")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                if (mpDefensora.equals("Pierna Derecha")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
            }
            
            if (mpAtacante.equals("Brazo Derecho")) {
                
                if (mpDefensora.equals("Cabeza")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                if (mpDefensora.equals("Brazo Izquierdo")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                if (mpDefensora.equals("Brazo Derecho")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                if (mpDefensora.equals("Pierna Izquierda")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                if (mpDefensora.equals("Pierna Derecha")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
            }
            
            if (mpAtacante.equals("Pierna Izquierda")) {
                
                if (mpDefensora.equals("Cabeza")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                if (mpDefensora.equals("Brazo Izquierdo")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                if (mpDefensora.equals("Brazo Derecho")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                if (mpDefensora.equals("Pierna Izquierda")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                if (mpDefensora.equals("Pierna Derecha")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
            }
            
            if (mpAtacante.equals("Pierna Derecha")) {
                
                if (mpDefensora.equals("Cabeza")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                if (mpDefensora.equals("Brazo Izquierdo")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                if (mpDefensora.equals("Brazo Derecho")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                if (mpDefensora.equals("Pierna Izquierda")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                if (mpDefensora.equals("Pierna Derecha")) this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
            }
            
            this.vc.setSaludCabezaM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual()));
            this.vc.setSaludBrazoIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual()));
            this.vc.setSaludBrazoDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual()));
            this.vc.setSaludPiernaIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual()));
            this.vc.setSaludPiernaDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual()));
            
            this.vc.setPHCabezaM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getCabeza().getPH()));
            this.vc.setPHBrazoIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getPH()));
            this.vc.setPHBrazoDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getPH()));
            this.vc.setPHPiernaIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getPH()));
            this.vc.setPHPiernaDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getPH()));
            
            
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
        
        if (((JButton)ae.getSource()).equals(this.vc.getTerminarTurno())) {
            
            
            
        }
    
    }
    
}
