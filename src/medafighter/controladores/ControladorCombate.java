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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import medafighter.modelo.ConexionBD;
import medafighter.vistas.VistaCombate;
import medafighter.modelo.*;

/**
 *
 * @author Fabián
 */

/* Clase ControladorCombate con sus atributos y métodos */

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
            
            if ((this.vc.getDefenderJ1().isEnabled() == true)&&(this.vc.getEsquivarJ1().isEnabled() == true)) {
                
                this.robobatalla.getJugador1().getMedabot().setSaludActual(this.robobatalla.getJugador1().getMedabot().getSaludActual() - this.robobatalla.getJugador1().getMedabot().getAtaqueTotal());
                
                this.vc.setSaludMedabotJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getSaludActual()));
            
                this.vc.setBarraSaludM1(this.robobatalla.getJugador1().getMedabot().getSaludActual());                
                
                this.vc.getLogBatalla().append("Se recibe todo el daño del ataque del turno anterior.\n\n");
                
                this.robobatalla.getJugador1().getMedabot().setAtaqueTotal(0);
                
            }
            
            String mpAtacante = (String)this.vc.getAtacanteJ1().getSelectedItem();
            String mpDefensora = (String)this.vc.getDefensorJ2().getSelectedItem();
            
            int dano = 0;
            
            if (mpAtacante.equals("Cabeza")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza());
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq());
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer());
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq());
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer());
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
            }
            
            if (mpAtacante.equals("Brazo Izquierdo")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 

                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
            }
            
            if (mpAtacante.equals("Brazo Derecho")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
            }
            
            if (mpAtacante.equals("Pierna Izquierda")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
            }
            
            if (mpAtacante.equals("Pierna Derecha")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
            }
            
            this.vc.setSaludCabezaM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual()));
            this.vc.setSaludBrazoIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual()));
            this.vc.setSaludBrazoDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual()));
            this.vc.setSaludPiernaIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual()));
            this.vc.setSaludPiernaDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual()));
                        
            //this.vc.setPHCabezaM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getCabeza().getPHRes()));
            //this.vc.setPHBrazoIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getPHRes()));
            //this.vc.setPHBrazoDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getPHRes()));
            //this.vc.setPHPiernaIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getPHRes()));
            //this.vc.setPHPiernaDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getPHRes()));
            
            this.vc.setPHJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPHRes()));
                        
            this.vc.setBarraSaludCabezaM2(this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual());
            this.vc.setBarraSaludBrazoIzqM2(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual());
            this.vc.setBarraSaludBrazoDerM2(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual());
            this.vc.setBarraSaludPiernaIzqM2(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual());
            this.vc.setBarraSaludPiernaDerM2(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual());
            
            this.vc.getDefenderJ1().setEnabled(false);
            this.vc.getEsquivarJ1().setEnabled(false);
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getAtacarJ2())) {
            
            if ((this.vc.getDefenderJ2().isEnabled() == true)&&(this.vc.getEsquivarJ2().isEnabled() == true)) {
                
                this.robobatalla.getJugador2().getMedabot().setSaludActual(this.robobatalla.getJugador2().getMedabot().getSaludActual() - this.robobatalla.getJugador2().getMedabot().getAtaqueTotal());
                
                this.vc.setSaludMedabotJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getSaludActual()));
            
                this.vc.setBarraSaludM2(this.robobatalla.getJugador2().getMedabot().getSaludActual());
                            
                this.vc.getLogBatalla().append("Se recibe todo el daño del ataque del turno anterior.\n\n");
                
                this.robobatalla.getJugador2().getMedabot().setAtaqueTotal(0);
                
            }
            
            String mpAtacante = (String)this.vc.getAtacanteJ2().getSelectedItem();
            String mpDefensora = (String)this.vc.getDefensorJ1().getSelectedItem();
            
            int dano = 0;
            
            if (mpAtacante.equals("Cabeza")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
 
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
            }
            
            if (mpAtacante.equals("Brazo Izquierdo")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
            }
            
            if (mpAtacante.equals("Brazo Derecho")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
            }
            
            if (mpAtacante.equals("Pierna Izquierda")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                            
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
            }
            
            if (mpAtacante.equals("Pierna Derecha")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                } 
                
            }
            
            this.vc.setSaludCabezaM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual()));
            this.vc.setSaludBrazoIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual()));
            this.vc.setSaludBrazoDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual()));
            this.vc.setSaludPiernaIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual()));
            this.vc.setSaludPiernaDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual()));
            
            //this.vc.setPHCabezaM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getCabeza().getPHRes()));
            //this.vc.setPHBrazoIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getPHRes()));
            //this.vc.setPHBrazoDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getPHRes()));
            //this.vc.setPHPiernaIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getPHRes()));
            //this.vc.setPHPiernaDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getPHRes()));
            
            this.vc.setPHJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPHRes()));
            
            this.vc.setBarraSaludCabezaM1(this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual());
            this.vc.setBarraSaludBrazoIzqM1(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual());
            this.vc.setBarraSaludBrazoDerM1(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual());
            this.vc.setBarraSaludPiernaIzqM1(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual());
            this.vc.setBarraSaludPiernaDerM1(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual());
            
            this.vc.getDefenderJ2().setEnabled(false);
            this.vc.getEsquivarJ2().setEnabled(false);
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getDefenderJ1())) {
            
            this.robobatalla.getJugador1().getMedabot().defender(this.robobatalla.getJugador1().getMedabot().getAtaqueTotal());
            
            this.vc.setSaludMedabotJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getSaludActual()));
            
            this.vc.setBarraSaludM1(this.robobatalla.getJugador1().getMedabot().getSaludActual());
            
            this.vc.setPHJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPHRes()));
            
            this.vc.getLogBatalla().append(""+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" se ha defendido de los ataques de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
            
            this.vc.getDefenderJ1().setEnabled(false);
            
            this.vc.getEsquivarJ1().setEnabled(false);
            
            this.vc.getAtacarJ1().setEnabled(true);
            
            this.vc.getAtacanteJ1().setEnabled(true);
            
            this.vc.getDefensorJ2().setEnabled(true);
            
            this.robobatalla.getJugador1().getMedabot().setAtaqueTotal(0);
                    
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getDefenderJ2())) {
            
            this.robobatalla.getJugador2().getMedabot().defender(this.robobatalla.getJugador2().getMedabot().getAtaqueTotal());
            
            this.vc.setSaludMedabotJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getSaludActual()));
            
            this.vc.setBarraSaludM2(this.robobatalla.getJugador2().getMedabot().getSaludActual());
            
            this.vc.setPHJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPHRes()));
            
            this.vc.getLogBatalla().append(""+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" se ha defendido de los ataques de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
            
            this.vc.getDefenderJ2().setEnabled(false);
            
            this.vc.getEsquivarJ2().setEnabled(false);
            
            this.vc.getAtacarJ2().setEnabled(true);
            
            this.vc.getAtacanteJ2().setEnabled(true);
            
            this.vc.getDefensorJ1().setEnabled(true);
            
            this.robobatalla.getJugador2().getMedabot().setAtaqueTotal(0);
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getEsquivarJ1())) {
            
            boolean esquivar = this.robobatalla.getJugador1().getMedabot().esquivar(this.robobatalla.getJugador1().getMedabot().getAtaqueTotal());
            
            this.vc.setSaludMedabotJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getSaludActual()));
            
            this.vc.setBarraSaludM1(this.robobatalla.getJugador1().getMedabot().getSaludActual());
            
            this.vc.setPHJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPHRes()));
            
            this.vc.getLogBatalla().append(""+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha intentado evadir de los ataques de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
            
            if (esquivar == true) this.vc.getLogBatalla().append("¡Evasión exitosa!\n\n");
            
            if (esquivar == false) this.vc.getLogBatalla().append("¡No pudo evadir el ataque enemigo!\n\n");
            
            this.vc.getDefenderJ1().setEnabled(false);
            
            this.vc.getEsquivarJ1().setEnabled(false);
            
            this.vc.getAtacarJ1().setEnabled(true);
            
            this.vc.getAtacanteJ1().setEnabled(true);
            
            this.vc.getDefensorJ2().setEnabled(true);
            
            this.robobatalla.getJugador1().getMedabot().setAtaqueTotal(0);
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getEsquivarJ2())) {
            
            boolean esquivar = this.robobatalla.getJugador2().getMedabot().esquivar(this.robobatalla.getJugador2().getMedabot().getAtaqueTotal());
            
            this.vc.setSaludMedabotJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getSaludActual()));
            
            this.vc.setBarraSaludM2(this.robobatalla.getJugador2().getMedabot().getSaludActual());
            
            this.vc.setPHJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPHRes()));
            
            this.vc.getLogBatalla().append(""+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha intentado evadir los ataques de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
            
            if (esquivar == true) this.vc.getLogBatalla().append("¡Evasión exitosa!\n\n");
            
            if (esquivar == false) this.vc.getLogBatalla().append("¡No pudo evadir el ataque enemigo!\n\n");this.vc.getDefenderJ2().setEnabled(false);
            
            this.vc.getEsquivarJ2().setEnabled(false);
            
            this.vc.getAtacarJ2().setEnabled(true);
            
            this.vc.getAtacanteJ2().setEnabled(true);
            
            this.vc.getDefensorJ1().setEnabled(true);
            
            this.robobatalla.getJugador2().getMedabot().setAtaqueTotal(0);
            
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
            
            if(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())) 
                
                this.robobatalla.setJugadorActivo(this.robobatalla.getJugador2().getNombre());
            
            else  
                
                this.robobatalla.setJugadorActivo(this.robobatalla.getJugador1().getNombre());
            
            if (robobatalla.getJugadorActivo().equals(robobatalla.getJugador1().getNombre())) {
            
                this.vc.getAtacanteJ2().setEnabled(false);
                this.vc.getDefensorJ1().setEnabled(false);
                this.vc.getAtacarJ2().setEnabled(false);
                this.vc.getMedafuerzaJ2().setEnabled(false);
                this.vc.getDefenderJ2().setEnabled(false);
                this.vc.getEsquivarJ2().setEnabled(false);
                
                this.vc.getAtacanteJ1().setEnabled(true);
                this.vc.getDefensorJ2().setEnabled(true);
                this.vc.getAtacarJ1().setEnabled(true);
                this.vc.getMedafuerzaJ1().setEnabled(true);
                this.vc.getDefenderJ1().setEnabled(true);
                this.vc.getEsquivarJ1().setEnabled(true);
                
            
            }
        
            if (robobatalla.getJugadorActivo().equals(robobatalla.getJugador2().getNombre())) {
            
                this.vc.getAtacanteJ1().setEnabled(false);
                this.vc.getDefensorJ2().setEnabled(false);
                this.vc.getAtacarJ1().setEnabled(false);
                this.vc.getMedafuerzaJ1().setEnabled(false);
                this.vc.getDefenderJ1().setEnabled(false);
                this.vc.getEsquivarJ1().setEnabled(false);
                
                this.vc.getAtacanteJ2().setEnabled(true);
                this.vc.getDefensorJ1().setEnabled(true);
                this.vc.getAtacarJ2().setEnabled(true);
                this.vc.getMedafuerzaJ2().setEnabled(true);
                this.vc.getDefenderJ2().setEnabled(true);
                this.vc.getEsquivarJ2().setEnabled(true);
            
            }
            
            //this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getCabeza().setPHRes(this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getCabeza().getPHMax());
            //this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getBrazoIzq().setPHRes(this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getBrazoIzq().getPHMax());
            //this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getBrazoDer().setPHRes(this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getBrazoDer().getPHMax());
            //this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getPiernaIzq().setPHRes(this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getPiernaIzq().getPHMax());
            //this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getPiernaDer().setPHRes(this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getPiernaDer().getPHMax());
            
            this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().setPHRes(this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getPHMax());
                        
            if (this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())) {
               
                //this.vc.setPHCabezaM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getCabeza().getPHRes()));
                //this.vc.setPHBrazoIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getPHRes()));
                //this.vc.setPHBrazoDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getPHRes()));
                //this.vc.setPHPiernaIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getPHRes()));
                //this.vc.setPHPiernaDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getPHRes()));
            
                this.vc.setPHJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPHRes()));
                
            }
            
            if (this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())) {
                
                //this.vc.setPHCabezaM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getCabeza().getPHRes()));
                //this.vc.setPHBrazoIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getPHRes()));
                //this.vc.setPHBrazoDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getPHRes()));
                //this.vc.setPHPiernaIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getPHRes()));
                //this.vc.setPHPiernaDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getPHRes()));
            
                this.vc.setPHJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPHRes()));
                
            }
                        
            this.robobatalla.setTurno(this.robobatalla.getTurno()+1);
            
            this.vc.getLogBatalla().append("* "+this.vc.numeroAOrdinal(this.robobatalla.getTurno()).substring(0, 1).toUpperCase() + this.vc.numeroAOrdinal(this.robobatalla.getTurno()).substring(1)+" turno - Turno de "+this.robobatalla.getJugadorActivo()+".\nPuede escoger entre defender o esquivar los ataques realizados el turno anterior, o recibir todo el daño y sólo atacar.\n\n");
           
        }
    
    }
    
}
