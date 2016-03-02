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
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import medafighter.modelo.ConexionBD;
import medafighter.vistas.VistaCombate;
import medafighter.modelo.*;
import medafighter.otros.MyController;

/**
 *
 * @author Fabián
 */

/* Clase ControladorCombate con sus atributos y métodos */

public class ControladorCombate extends MyController implements ActionListener, ChangeListener {
    
    private VistaCombate vc;
    
    private ConexionBD cbd;
    
    private ControladorMenu cm;
    
    private Robobatalla robobatalla;
    
    private Torneo torneo;
    
    public ControladorCombate(String jugador1, String jugador2, String versionMedabotJ1, String versionMedabotJ2, String modoJuego) throws SQLException {
        
        this.cbd = new ConexionBD();
        
        this.robobatalla = new Robobatalla(jugador1,jugador2,versionMedabotJ1,versionMedabotJ2,modoJuego);
        
        this.vc = new VistaCombate(this,this.robobatalla,false);
        
        if(this.robobatalla.getModoJuego().equals("Jugador v/s CPU")&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())) {
            
            if(this.robobatalla.getJugador2().getTipoCPU().equals("1")) {
                
                this.turnoCPU1J2();
                
            }
            
            if(this.robobatalla.getJugador2().getTipoCPU().equals("2")) {
                
                this.turnoCPU1J2();
                
            }
            
            if(this.robobatalla.getJugador2().getTipoCPU().equals("3")) {
                
                this.turnoCPU1J2();
                
            }
            
            if(this.robobatalla.getJugador2().getTipoCPU().equals("4")) {
                
                this.turnoCPU1J2();
                
            }
            
        }
        
        if(this.robobatalla.getModoJuego().equals("CPU V/S CPU")) {
            
            this.simulacion();
            
        }
           
    }
    
    public ControladorCombate(ArrayList<String> jugadores, ArrayList<String> medabots, String tipoTorneo) throws SQLException {
        
        this.cbd = new ConexionBD();
        
        if (tipoTorneo.equals("Torneo Normal")) this.torneo = new TorneoNormal(jugadores,medabots,tipoTorneo);
        
        if (tipoTorneo.equals("Torneo Avanzado")) this.torneo = new TorneoAvanzado(jugadores,medabots,tipoTorneo);
        
        for (int i = 0; i < 8; i = i + 2) {

            if(jugadores.get(0).startsWith("cpu")) {

                this.robobatalla = new Robobatalla(jugadores.get(i),jugadores.get(i+1),medabots.get(i),medabots.get(i+1),"CPU V/S CPU");

            }

            if(jugadores.get(1).startsWith("cpu")) {

                this.robobatalla = new Robobatalla(jugadores.get(i),jugadores.get(i+1),medabots.get(i),medabots.get(i+1),"Jugador v/s CPU");

            }

            this.robobatalla = new Robobatalla(jugadores.get(i),jugadores.get(i+1),medabots.get(i),medabots.get(i+1),"Jugador v/s Jugador");

            this.vc = new VistaCombate(this,this.robobatalla,true);

            if(this.robobatalla.getModoJuego().equals("Jugador v/s CPU")&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())) {

                if(this.robobatalla.getJugador2().getTipoCPU().equals("1")) {

                    this.turnoCPU1J2();

                }

                if(this.robobatalla.getJugador2().getTipoCPU().equals("2")) {

                    this.turnoCPU1J2();

                }

                if(this.robobatalla.getJugador2().getTipoCPU().equals("3")) {

                    this.turnoCPU1J2();

                }

                if(this.robobatalla.getJugador2().getTipoCPU().equals("4")) {

                    this.turnoCPU1J2();

                }

            }

            if(this.robobatalla.getModoJuego().equals("CPU V/S CPU")) {

                this.simulacion();

            }
            
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (((JButton)ae.getSource()).equals(this.vc.getAtacarJ1())) {
            
            if ((this.vc.getDefenderJ1().isEnabled() == true)&&(this.vc.getEsquivarJ1().isEnabled() == true)) {
                
                this.robobatalla.getJugador1().getMedabot().setSaludActual(this.robobatalla.getJugador1().getMedabot().getSaludActual() - this.robobatalla.getJugador1().getMedabot().getAtaqueTotal());
                
                this.vc.setSaludMedabotJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getSaludActual()));
            
                this.vc.setBarraSaludM1(this.robobatalla.getJugador1().getMedabot().getSaludActual());                
                
                this.vc.getLogBatalla().append("- Al no defender o intentar esquivar, "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" recibe todo el daño de los ataques del turno anterior.\n\n");
                
                this.robobatalla.getJugador1().getMedabot().setAtaqueTotal(0);
                
            }
            
            String mpAtacante = (String)this.vc.getAtacanteJ1().getSelectedItem();
            String mpDefensora = (String)this.vc.getDefensorJ2().getSelectedItem();
            
            int dano = 0;
            
            if (mpAtacante.equals("Cabeza")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza());
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
                    
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
                    
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
                               
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq());
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
                    
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
                    
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer());
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
                    
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq());
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer());
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
            }
            
            if (mpAtacante.equals("Brazo Izquierdo")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 

                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
            }
            
            if (mpAtacante.equals("Brazo Derecho")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
            }
            
            if (mpAtacante.equals("Pierna Izquierda")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
            }
            
            if (mpAtacante.equals("Pierna Derecha")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
           
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
           
                } 
                
            }
            
            this.vc.setSaludCabezaM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual()));
            this.vc.setSaludBrazoIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual()));
            this.vc.setSaludBrazoDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual()));
            this.vc.setSaludPiernaIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual()));
            this.vc.setSaludPiernaDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual()));
                        
            this.vc.setPHJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPHRes()));
                        
            this.vc.setBarraSaludCabezaM2(this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual());
            this.vc.setBarraSaludBrazoIzqM2(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual());
            this.vc.setBarraSaludBrazoDerM2(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual());
            this.vc.setBarraSaludPiernaIzqM2(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual());
            this.vc.setBarraSaludPiernaDerM2(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual());
            
            this.vc.getDefenderJ1().setEnabled(false);
            this.vc.getEsquivarJ1().setEnabled(false);
            
            this.vc.getTerminarTurno().setEnabled(true);
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getAtacarJ2())) {
            
            if ((this.vc.getDefenderJ2().isEnabled() == true)&&(this.vc.getEsquivarJ2().isEnabled() == true)) {
                
                this.robobatalla.getJugador2().getMedabot().setSaludActual(this.robobatalla.getJugador2().getMedabot().getSaludActual() - this.robobatalla.getJugador2().getMedabot().getAtaqueTotal());
                
                this.vc.setSaludMedabotJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getSaludActual()));
            
                this.vc.setBarraSaludM2(this.robobatalla.getJugador2().getMedabot().getSaludActual());
                            
                this.vc.getLogBatalla().append("- Al no defender o intentar esquivar, "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" recibe todo el daño de los ataques del turno anterior.\n\n");
                
                this.robobatalla.getJugador2().getMedabot().setAtaqueTotal(0);
                
            }
            
            String mpAtacante = (String)this.vc.getAtacanteJ2().getSelectedItem();
            String mpDefensora = (String)this.vc.getDefensorJ1().getSelectedItem();
            
            int dano = 0;
            
            if (mpAtacante.equals("Cabeza")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
 
                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
            }
            
            if (mpAtacante.equals("Brazo Izquierdo")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
            }
            
            if (mpAtacante.equals("Brazo Derecho")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
            }
            
            if (mpAtacante.equals("Pierna Izquierda")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                            
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
            }
            
            if (mpAtacante.equals("Pierna Derecha")) {
                
                if (mpDefensora.equals("Cabeza")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
                
                if (mpDefensora.equals("Brazo Izquierdo")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

                } 
                
                if (mpDefensora.equals("Brazo Derecho")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

                } 
                
                
                if (mpDefensora.equals("Pierna Izquierda")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
                
                if (mpDefensora.equals("Pierna Derecha")) {
                    
                    dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                    if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                    if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                    if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
                } 
                
            }
            
            this.vc.setSaludCabezaM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual()));
            this.vc.setSaludBrazoIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual()));
            this.vc.setSaludBrazoDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual()));
            this.vc.setSaludPiernaIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual()));
            this.vc.setSaludPiernaDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual()));
            
            this.vc.setPHJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPHRes()));
            
            this.vc.setBarraSaludCabezaM1(this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual());
            this.vc.setBarraSaludBrazoIzqM1(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual());
            this.vc.setBarraSaludBrazoDerM1(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual());
            this.vc.setBarraSaludPiernaIzqM1(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual());
            this.vc.setBarraSaludPiernaDerM1(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual());
            
            this.vc.getDefenderJ2().setEnabled(false);
            this.vc.getEsquivarJ2().setEnabled(false);
            
            this.vc.getTerminarTurno().setEnabled(true);
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getDefenderJ1())) {
            
            this.robobatalla.getJugador1().getMedabot().defender(this.robobatalla.getJugador1().getMedabot().getAtaqueTotal());
            
            this.vc.setSaludMedabotJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getSaludActual()));
            
            this.vc.setBarraSaludM1(this.robobatalla.getJugador1().getMedabot().getSaludActual());
            
            this.vc.setPHJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPHRes()));
            
            this.vc.getLogBatalla().append("- "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" se ha defendido de los ataques de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
            
            if (this.robobatalla.getJugador1().getMedabot().getSaludActual() > 0) {
            
                this.vc.getDefenderJ1().setEnabled(false);
            
                this.vc.getEsquivarJ1().setEnabled(false);
            
                this.vc.getAtacarJ1().setEnabled(true);
            
                this.vc.getAtacanteJ1().setEnabled(true);
            
                this.vc.getDefensorJ2().setEnabled(true);
                
                this.vc.getTerminarTurno().setEnabled(true);
            
                this.robobatalla.getJugador1().getMedabot().setAtaqueTotal(0);
            
            }
                    
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getDefenderJ2())) {
            
            this.robobatalla.getJugador2().getMedabot().defender(this.robobatalla.getJugador2().getMedabot().getAtaqueTotal());
            
            this.vc.setSaludMedabotJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getSaludActual()));
            
            this.vc.setBarraSaludM2(this.robobatalla.getJugador2().getMedabot().getSaludActual());
            
            this.vc.setPHJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPHRes()));
            
            this.vc.getLogBatalla().append("- "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" se ha defendido de los ataques de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
            
            if (this.robobatalla.getJugador1().getMedabot().getSaludActual() > 0) {
            
                this.vc.getDefenderJ2().setEnabled(false);
            
                this.vc.getEsquivarJ2().setEnabled(false);
            
                this.vc.getAtacarJ2().setEnabled(true);
            
                this.vc.getAtacanteJ2().setEnabled(true);
            
                this.vc.getDefensorJ1().setEnabled(true);
                
                this.vc.getTerminarTurno().setEnabled(true);
            
                this.robobatalla.getJugador2().getMedabot().setAtaqueTotal(0);
            
            }
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getEsquivarJ1())) {
            
            boolean esquivar = this.robobatalla.getJugador1().getMedabot().esquivar(this.robobatalla.getJugador1().getMedabot().getAtaqueTotal());
            
            this.vc.setSaludMedabotJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getSaludActual()));
            
            this.vc.setBarraSaludM1(this.robobatalla.getJugador1().getMedabot().getSaludActual());
            
            this.vc.setPHJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPHRes()));
            
            this.vc.getLogBatalla().append(""+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha intentado evadir de los ataques de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
            
            if (esquivar == true) this.vc.getLogBatalla().append("- ¡Evasión exitosa!\n\n");
            
            if (esquivar == false) this.vc.getLogBatalla().append("- ¡No pudo evadir el ataque enemigo!\n\n");
            
            if (this.robobatalla.getJugador1().getMedabot().getSaludActual() > 0) {
            
                this.vc.getDefenderJ1().setEnabled(false);
            
                this.vc.getEsquivarJ1().setEnabled(false);
            
                this.vc.getAtacarJ1().setEnabled(true);
            
                this.vc.getAtacanteJ1().setEnabled(true);
            
                this.vc.getDefensorJ2().setEnabled(true);
                
                this.vc.getTerminarTurno().setEnabled(true);
            
                this.robobatalla.getJugador1().getMedabot().setAtaqueTotal(0);
                
            }
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getEsquivarJ2())) {
            
            boolean esquivar = this.robobatalla.getJugador2().getMedabot().esquivar(this.robobatalla.getJugador2().getMedabot().getAtaqueTotal());
            
            this.vc.setSaludMedabotJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getSaludActual()));
            
            this.vc.setBarraSaludM2(this.robobatalla.getJugador2().getMedabot().getSaludActual());
            
            this.vc.setPHJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPHRes()));
            
            this.vc.getLogBatalla().append(""+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha intentado evadir los ataques de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");
            
            if (esquivar == true) this.vc.getLogBatalla().append("- ¡Evasión exitosa!\n\n");
            
            if (esquivar == false) this.vc.getLogBatalla().append("- ¡No pudo evadir el ataque enemigo!\n\n");this.vc.getDefenderJ2().setEnabled(false);
            
            if (this.robobatalla.getJugador1().getMedabot().getSaludActual() > 0) {
            
                this.vc.getEsquivarJ2().setEnabled(false);
            
                this.vc.getAtacarJ2().setEnabled(true);
            
                this.vc.getAtacanteJ2().setEnabled(true);
            
                this.vc.getDefensorJ1().setEnabled(true);
                
                this.vc.getTerminarTurno().setEnabled(true);
            
                this.robobatalla.getJugador2().getMedabot().setAtaqueTotal(0);
            
            }
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getRendirseJ1())) {
            
            int opcion = JOptionPane.showConfirmDialog(this.vc, "¿Está seguro que desea rendirse?", "Medafighter - Rendirse", 2);
            
            if (opcion == 0) {
                
                this.vc.getNombreJ1().setEnabled(false);
                this.vc.getNombreM1().setEnabled(false);
                this.vc.getPHRestanteLabelJ1().setEnabled(false);
                this.vc.getPHRestanteJ1().setEnabled(false);
                this.vc.getBarraSaludM1().setEnabled(false);
                this.vc.getSaludMedabotJ1().setEnabled(false);
                this.vc.getCostoPHLabelJ1().setEnabled(false);
                
                this.vc.getCabezaJ1().setEnabled(false);
                this.vc.getBrazoIzqJ1().setEnabled(false);
                this.vc.getBrazoDerJ1().setEnabled(false);
                this.vc.getPiernaIzqJ1().setEnabled(false);
                this.vc.getPiernaDerJ1().setEnabled(false);
                
                this.vc.getBarraSaludCabezaM1().setEnabled(false);
                this.vc.getBarraSaludBrazoIzqM1().setEnabled(false);
                this.vc.getBarraSaludBrazoDerM1().setEnabled(false);
                this.vc.getBarraSaludPiernaIzqM1().setEnabled(false);
                this.vc.getBarraSaludPiernaDerM1().setEnabled(false);
                
                this.vc.getSaludCabezaM1().setEnabled(false);
                this.vc.getSaludBrazoIzqM1().setEnabled(false);
                this.vc.getSaludBrazoDerM1().setEnabled(false);
                this.vc.getSaludPiernaIzqM1().setEnabled(false);
                this.vc.getSaludPiernaDerM1().setEnabled(false);
                
                this.vc.getPHCabezaM1().setEnabled(false);
                this.vc.getPHBrazoIzqM1().setEnabled(false);
                this.vc.getPHBrazoDerM1().setEnabled(false);
                this.vc.getPHPiernaIzqM1().setEnabled(false);
                this.vc.getPHPiernaDerM1().setEnabled(false);
                
                this.vc.getMedabotJ1().setEnabled(false);
                this.vc.getAtacanteJ1().setEnabled(false);
                this.vc.getDefensorJ2().setEnabled(false);
                this.vc.getAtacarJ1().setEnabled(false);
                this.vc.getMedafuerzaJ1().setEnabled(false);
                this.vc.getDefenderJ1().setEnabled(false);
                this.vc.getEsquivarJ1().setEnabled(false);            
                this.vc.getRendirseJ1().setEnabled(false);
                
                this.vc.getTerminarTurno().setEnabled(false);
                
                this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getNombre()+" se ha rendido!\n\n- ¡"+this.robobatalla.getJugador2().getNombre()+" es el ganador!\n\n");
                
                JOptionPane.showMessageDialog(vc, "- ¡"+this.robobatalla.getJugador1().getNombre()+" se ha rendido!\n\n- ¡"+this.robobatalla.getJugador2().getNombre()+" es el ganador!\n\n");
                
                try {
                    
                    this.cbd.actualizarDatosJugadores(this.robobatalla.getJugador1().getNombre(),this.robobatalla.getJugador2().getNombre(),false);
                    
                    this.cbd.agregarMedaparteJugador(this.robobatalla.getJugador2(),this.robobatalla.getJugador1());
                    
                    this.escribirLog(this.robobatalla.getJugador2().getNombre()+" ha vencido a "+this.robobatalla.getJugador1().getNombre()+" en una robobatalla.");
                
                } 
                
                catch (SQLException ex) {
                    
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                
                } 
                
                catch (IOException ex) {
                    
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                
                if (!this.vc.getTorneo()) this.cm = new ControladorMenu();
                
                this.vc.setVisible(false);
                
                this.vc.dispose();
                
            }
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getRendirseJ2())) {
            
            int opcion = JOptionPane.showConfirmDialog(this.vc, "¿Está seguro que desea rendirse?", "Medafighter - Rendirse", 2);
            
            if (opcion == 0) {
                
                this.vc.getNombreJ2().setEnabled(false);
                this.vc.getNombreM2().setEnabled(false);
                this.vc.getPHRestanteLabelJ2().setEnabled(false);
                this.vc.getPHRestanteJ2().setEnabled(false);
                this.vc.getBarraSaludM2().setEnabled(false);
                this.vc.getSaludMedabotJ2().setEnabled(false);
                this.vc.getCostoPHLabelJ2().setEnabled(false);
                
                this.vc.getCabezaJ2().setEnabled(false);
                this.vc.getBrazoIzqJ2().setEnabled(false);
                this.vc.getBrazoDerJ2().setEnabled(false);
                this.vc.getPiernaIzqJ2().setEnabled(false);
                this.vc.getPiernaDerJ2().setEnabled(false);
                
                this.vc.getBarraSaludCabezaM2().setEnabled(false);
                this.vc.getBarraSaludBrazoIzqM2().setEnabled(false);
                this.vc.getBarraSaludBrazoDerM2().setEnabled(false);
                this.vc.getBarraSaludPiernaIzqM2().setEnabled(false);
                this.vc.getBarraSaludPiernaDerM2().setEnabled(false);
                
                this.vc.getSaludCabezaM2().setEnabled(false);
                this.vc.getSaludBrazoIzqM2().setEnabled(false);
                this.vc.getSaludBrazoDerM2().setEnabled(false);
                this.vc.getSaludPiernaIzqM2().setEnabled(false);
                this.vc.getSaludPiernaDerM2().setEnabled(false);
                
                this.vc.getPHCabezaM2().setEnabled(false);
                this.vc.getPHBrazoIzqM2().setEnabled(false);
                this.vc.getPHBrazoDerM2().setEnabled(false);
                this.vc.getPHPiernaIzqM2().setEnabled(false);
                this.vc.getPHPiernaDerM2().setEnabled(false);
                
                this.vc.getMedabotJ2().setEnabled(false);
                this.vc.getAtacanteJ2().setEnabled(false);
                this.vc.getDefensorJ1().setEnabled(false);
                this.vc.getAtacarJ2().setEnabled(false);
                this.vc.getMedafuerzaJ2().setEnabled(false);
                this.vc.getDefenderJ2().setEnabled(false);
                this.vc.getEsquivarJ2().setEnabled(false);            
                this.vc.getRendirseJ2().setEnabled(false);
                
                this.vc.getTerminarTurno().setEnabled(false);
                
                this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getNombre()+" se ha rendido!\n\n- ¡"+this.robobatalla.getJugador1().getNombre()+" es el ganador!\n\n");
                
                JOptionPane.showMessageDialog(vc, "- ¡"+this.robobatalla.getJugador2().getNombre()+" se ha rendido!\n\n- ¡"+this.robobatalla.getJugador1().getNombre()+" es el ganador!\n\n");
                                
                try {
                    
                    this.cbd.actualizarDatosJugadores(this.robobatalla.getJugador2().getNombre(),this.robobatalla.getJugador1().getNombre(),false);
                    
                    this.cbd.agregarMedaparteJugador(this.robobatalla.getJugador1(),this.robobatalla.getJugador2());
                    
                    this.escribirLog(this.robobatalla.getJugador1().getNombre()+" ha vencido a "+this.robobatalla.getJugador2().getNombre()+" en una robobatalla.");
                
                } 
                
                catch (SQLException ex) {
                    
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                
                } 
                
                catch (IOException ex) {
                    
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                                
                if (!this.vc.getTorneo()) this.cm = new ControladorMenu();
                
                this.vc.setVisible(false);
                
                this.vc.dispose(); 
                
            }
            
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getMedafuerzaJ1())) {
            
            this.robobatalla.getJugador1().getMedabot().activarMedafuerza();
            
            this.vc.getLogBatalla().append("¡La medafuerza de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0, this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha sido activada!\n\n");
            
            this.vc.getMedafuerzaJ1().setEnabled(false);
            
            this.vc.setEstadoMedafuerzaJ1("¡Medafuerza Activada!");
            
            if(this.robobatalla.getJugador1().getMedabot().getMedalla().getTipoCarga().equals("concentracion")) {
                
                this.robobatalla.getJugador1().getMedabot().getMedalla().setTurnoCarga(0);
                
            }
            
            if(this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza().equals("Poder")) {
                                
                String descripcionM1 = "<html><body>Nombre: "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()+"(*2)/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()+"(*2)/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()+"(*2)/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()+"(*2)/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()+"(*2)/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+robobatalla.getJugador1().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+robobatalla.getJugador1().getMedabot().getEsquiveTotal()+"</body></html>";
                
                this.vc.getMedarotchJ1().setToolTipText(descripcionM1);
                
            }
            
            if(this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza().equals("Velocidad")) {
                
                String descripcionM1 = "<html><body>Nombre: "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador1().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador1().getMedabot().getEsquiveTotal()+"(+50)</body></html>";
                
                this.vc.getMedarotchJ1().setToolTipText(descripcionM1);
                
            }
            
            if(this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza().equals("Invulnerabilidad")) {
                
                String descripcionM1 = "<html><body>Nombre: "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador1().getMedabot().getDefensaTotal()+"(+100)<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador1().getMedabot().getEsquiveTotal()+"</body></html>";
                
                this.vc.getMedarotchJ1().setToolTipText(descripcionM1);
                                
            }
                                 
        }
        
        if (((JButton)ae.getSource()).equals(this.vc.getMedafuerzaJ2())) {
            
            this.robobatalla.getJugador2().getMedabot().activarMedafuerza();
            
            this.vc.getLogBatalla().append("¡La medafuerza de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0, this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha sido activada!\n\n");
            
            this.vc.getMedafuerzaJ2().setEnabled(false);
            
            this.vc.setEstadoMedafuerzaJ2("¡Medafuerza Activada!");
            
            if(this.robobatalla.getJugador2().getMedabot().getMedalla().getTipoCarga().equals("concentracion")) { 
                
                this.robobatalla.getJugador2().getMedabot().getMedalla().setTurnoCarga(0);
                
            }            
            
            if(this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza().equals("Poder")) {
                                
                String descripcionM2 = "<html><body>Nombre: "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()+"(*2)/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()+"(*2)/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()+"(*2)/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()+"(*2)/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()+"(*2)/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+robobatalla.getJugador2().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+robobatalla.getJugador2().getMedabot().getEsquiveTotal()+"</body></html>";
                
                this.vc.getMedarotchJ2().setToolTipText(descripcionM2);
                
            }
            
            if(this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza().equals("Velocidad")) {
                
                String descripcionM2 = "<html><body>Nombre: "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador2().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador2().getMedabot().getEsquiveTotal()+"(+50)</body></html>";
                
                this.vc.getMedarotchJ2().setToolTipText(descripcionM2);
                
            }
            
            if(this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza().equals("Invulnerabilidad")) {
                
                String descripcionM2 = "<html><body>Nombre: "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador2().getMedabot().getDefensaTotal()+"(+100)<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador2().getMedabot().getEsquiveTotal()+"</body></html>";
                
                this.vc.getMedarotchJ2().setToolTipText(descripcionM2);
                                
            }
                        
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
                this.vc.getDefenderJ2().setEnabled(false);
                this.vc.getEsquivarJ2().setEnabled(false);
                this.vc.getRendirseJ2().setEnabled(false);
                this.vc.getMedarotchJ2().setEnabled(false);
                
                this.vc.getAtacanteJ1().setEnabled(true);
                this.vc.getDefensorJ2().setEnabled(true);
                this.vc.getAtacarJ1().setEnabled(true);
                this.vc.getDefenderJ1().setEnabled(true);
                this.vc.getEsquivarJ1().setEnabled(true);
                this.vc.getRendirseJ1().setEnabled(true);
                this.vc.getMedarotchJ1().setEnabled(true);
                
                if ((this.vc.getEstadoMedafuerzaJ2().isEnabled())&&(this.vc.getEstadoMedafuerzaJ2().getText().equals("¡Medafuerza Activada!"))) {
                    
                    if(this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza().equals("Poder")){
                        
                        this.robobatalla.getJugador2().getMedabot().getCabeza().setAtaque((int) (this.robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()*0.5));
                                
                        this.robobatalla.getJugador2().getMedabot().getBrazoIzq().setAtaque((int) (this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()*0.5));
                                        
                        this.robobatalla.getJugador2().getMedabot().getBrazoDer().setAtaque((int) (this.robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()*0.5));
                                                
                        this.robobatalla.getJugador2().getMedabot().getPiernaIzq().setAtaque((int) (this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()*0.5));
                                                        
                        this.robobatalla.getJugador2().getMedabot().getPiernaDer().setAtaque((int) (this.robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()*0.5));
                        
                    }
                    
                    if(this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza().equals("Velocidad")){
                        
                        this.robobatalla.getJugador2().getMedabot().setEsquiveTotal(this.robobatalla.getJugador2().getMedabot().getEsquiveTotal()-50);
                        
                    }
                    
                    if(this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza().equals("Reaccion")){
                        
                        this.robobatalla.getJugador2().getMedabot().setPHRes((int) (this.robobatalla.getJugador2().getMedabot().getPHRes()*0.5));
                        
                    }
                    
                    if(this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza().equals("Invulnerabilidad")){
                        
                        this.robobatalla.getJugador2().getMedabot().setDefensaTotal(this.robobatalla.getJugador2().getMedabot().getDefensaTotal()-100);
                        
                    }
                    
                    this.vc.setEstadoMedafuerzaJ2("Medafuerza Inactiva");
                    this.vc.getEstadoMedafuerzaJ2().setEnabled(false);                    
                    
                    String descripcionM2 = "<html><body>Nombre: "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"<br>"
                            + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getEsquive()+"<br>"
                            + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                            + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getEsquive()+"<br>"
                            + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                            + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getEsquive()+"<br>"
                            + "Medafuerza: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza()+"<br>"
                            + "Carga: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getTipoCarga()+"<br>"
                            + "Defensa Total: "+this.robobatalla.getJugador2().getMedabot().getDefensaTotal()+"<br>"
                            + "Esquive Total: "+this.robobatalla.getJugador2().getMedabot().getEsquiveTotal()+"</body></html>";

                    this.vc.getMedarotchJ2().setToolTipText(descripcionM2);
                    
                }
                
                boolean mfActivadaJ1 = this.robobatalla.getJugador1().getMedabot().cargarMedafuerza(this.robobatalla.getJugador2().getMedabot());
            
                if (mfActivadaJ1) {
                    
                    this.vc.getMedafuerzaJ1().setEnabled(true);
                    
                    this.vc.getLogBatalla().append("¡La medafuerza de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0, this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" está lista para ser activada!\n\n");
                
                    this.vc.getEstadoMedafuerzaJ1().setEnabled(true);
                    
                    this.vc.setEstadoMedafuerzaJ1("¡Medafuerza Lista!");                    
                    
                }
                
            }
        
            if (robobatalla.getJugadorActivo().equals(robobatalla.getJugador2().getNombre())) {
            
                this.vc.getAtacanteJ1().setEnabled(false);
                this.vc.getDefensorJ2().setEnabled(false);
                this.vc.getAtacarJ1().setEnabled(false);
                this.vc.getDefenderJ1().setEnabled(false);
                this.vc.getEsquivarJ1().setEnabled(false);
                this.vc.getRendirseJ1().setEnabled(false);
                this.vc.getMedarotchJ1().setEnabled(false);
                
                this.vc.getAtacanteJ2().setEnabled(true);
                this.vc.getDefensorJ1().setEnabled(true);
                this.vc.getAtacarJ2().setEnabled(true);
                this.vc.getDefenderJ2().setEnabled(true);
                this.vc.getEsquivarJ2().setEnabled(true);
                this.vc.getRendirseJ2().setEnabled(true);
                this.vc.getMedarotchJ2().setEnabled(true);
                
                if ((this.vc.getEstadoMedafuerzaJ1().isEnabled())&&(this.vc.getEstadoMedafuerzaJ1().getText().equals("¡Medafuerza Activada!"))) {
                    
                    if(this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza().equals("Poder")){
                        
                        this.robobatalla.getJugador1().getMedabot().getCabeza().setAtaque((int) (this.robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()*0.5));
                                
                        this.robobatalla.getJugador1().getMedabot().getBrazoIzq().setAtaque((int) (this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()*0.5));
                                        
                        this.robobatalla.getJugador1().getMedabot().getBrazoDer().setAtaque((int) (this.robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()*0.5));
                                                
                        this.robobatalla.getJugador1().getMedabot().getPiernaIzq().setAtaque((int) (this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()*0.5));
                                                        
                        this.robobatalla.getJugador1().getMedabot().getPiernaDer().setAtaque((int) (this.robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()*0.5));
                        
                        
                    }
                    
                    if(this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza().equals("Velocidad")){
                        
                        this.robobatalla.getJugador1().getMedabot().setEsquiveTotal(this.robobatalla.getJugador1().getMedabot().getEsquiveTotal()-50);
                        
                    }
                    
                    if(this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza().equals("Reaccion")){
                        
                        this.robobatalla.getJugador1().getMedabot().setPHRes((int) (this.robobatalla.getJugador1().getMedabot().getPHRes()*0.5));
                        
                    }
                    
                    if(this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza().equals("Invulnerabilidad")){
                        
                        this.robobatalla.getJugador1().getMedabot().setDefensaTotal(this.robobatalla.getJugador1().getMedabot().getDefensaTotal()-100);
                        
                    }
                    
                    this.vc.setEstadoMedafuerzaJ1("Medafuerza Inactiva");
                    this.vc.getEstadoMedafuerzaJ1().setEnabled(false);

                    String descripcionM1 = "<html><body>Nombre: "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+"<br>"
                            + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getEsquive()+"<br>"
                            + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                            + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getEsquive()+"<br>"
                            + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                            + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getEsquive()+"<br>"
                            + "Medafuerza: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza()+"<br>"
                            + "Carga: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getTipoCarga()+"<br>"
                            + "Defensa Total: "+this.robobatalla.getJugador1().getMedabot().getDefensaTotal()+"<br>"
                            + "Esquive Total: "+this.robobatalla.getJugador1().getMedabot().getEsquiveTotal()+"</body></html>";

                    this.vc.getMedarotchJ1().setToolTipText(descripcionM1);

                }
                
                boolean mfActivadaJ2 = this.robobatalla.getJugador2().getMedabot().cargarMedafuerza(this.robobatalla.getJugador1().getMedabot());
            
                if (mfActivadaJ2) {
                    
                    this.vc.getMedafuerzaJ2().setEnabled(true);
                    
                    this.vc.getLogBatalla().append("¡La medafuerza de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0, this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" está lista para ser activada!\n\n");
                
                    this.vc.getEstadoMedafuerzaJ2().setEnabled(true);
                    
                    this.vc.setEstadoMedafuerzaJ2("¡Medafuerza Lista!");
                    
                }
            
            }
            
            this.vc.getTerminarTurno().setEnabled(false);
            
            this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().setPHRes(this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getPHMax());
                        
            if (this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())) {
               
                this.vc.setPHJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPHRes()));
                
            }
            
            if (this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())) {
                
                this.vc.setPHJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPHRes()));
                
            }
                        
            this.robobatalla.setTurno(this.robobatalla.getTurno()+1);
            
            this.vc.getLogBatalla().append("* "+this.vc.numeroAOrdinal(this.robobatalla.getTurno()).substring(0, 1).toUpperCase() + this.vc.numeroAOrdinal(this.robobatalla.getTurno()).substring(1)+" turno - Turno de "+this.robobatalla.getJugadorActivo()+".\nPuede escoger entre defender o esquivar los ataques realizados el turno anterior, o recibir todo el daño y sólo atacar.\n\n");
                      
            if(this.robobatalla.getModoJuego().equals("Jugador v/s CPU")&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())) {
            
                this.vc.getAtacanteJ2().setEnabled(false);
                this.vc.getDefensorJ1().setEnabled(false);
                this.vc.getAtacarJ2().setEnabled(false);            
                this.vc.getDefenderJ2().setEnabled(false);
                this.vc.getEsquivarJ2().setEnabled(false);
                this.vc.getAtacanteJ2().setEnabled(false);
                this.vc.getDefenderJ1().setEnabled(false);
                this.vc.getEsquivarJ1().setEnabled(false);
                this.vc.getRendirseJ2().setEnabled(false);
                this.vc.getTerminarTurno().setEnabled(false); 
                this.vc.getMedafuerzaJ2().setEnabled(false);                
                this.vc.getMedarotchJ2().setEnabled(false);
                
                if(this.robobatalla.getJugador2().getTipoCPU().equals("1")) {
                
                    this.turnoCPU1J2();
                
                }
            
                if(this.robobatalla.getJugador2().getTipoCPU().equals("2")) {
                
                    this.turnoCPU1J2();
                
                }
            
                if(this.robobatalla.getJugador2().getTipoCPU().equals("3")) {
                
                    this.turnoCPU1J2();
                
                }
            
                if(this.robobatalla.getJugador2().getTipoCPU().equals("4")) {
                
                    this.turnoCPU1J2();
                
                }
            
            }
            
        }   
    
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludM1())) {
            
            if (this.vc.getBarraSaludM1().getValue() == 0) {
                
                this.vc.setSaludMedabotJ1("0");
                
                this.vc.getNombreJ1().setEnabled(false);
                this.vc.getNombreM1().setEnabled(false);
                this.vc.getPHRestanteLabelJ1().setEnabled(false);
                this.vc.getPHRestanteJ1().setEnabled(false);
                this.vc.getBarraSaludM1().setEnabled(false);
                this.vc.getSaludMedabotJ1().setEnabled(false);
                this.vc.getCostoPHLabelJ1().setEnabled(false);
                
                this.vc.getCabezaJ1().setEnabled(false);
                this.vc.getBrazoIzqJ1().setEnabled(false);
                this.vc.getBrazoDerJ1().setEnabled(false);
                this.vc.getPiernaIzqJ1().setEnabled(false);
                this.vc.getPiernaDerJ1().setEnabled(false);
                
                this.vc.getBarraSaludCabezaM1().setEnabled(false);
                this.vc.getBarraSaludBrazoIzqM1().setEnabled(false);
                this.vc.getBarraSaludBrazoDerM1().setEnabled(false);
                this.vc.getBarraSaludPiernaIzqM1().setEnabled(false);
                this.vc.getBarraSaludPiernaDerM1().setEnabled(false);
                
                this.vc.getSaludCabezaM1().setEnabled(false);
                this.vc.getSaludBrazoIzqM1().setEnabled(false);
                this.vc.getSaludBrazoDerM1().setEnabled(false);
                this.vc.getSaludPiernaIzqM1().setEnabled(false);
                this.vc.getSaludPiernaDerM1().setEnabled(false);
                
                this.vc.getPHCabezaM1().setEnabled(false);
                this.vc.getPHBrazoIzqM1().setEnabled(false);
                this.vc.getPHBrazoDerM1().setEnabled(false);
                this.vc.getPHPiernaIzqM1().setEnabled(false);
                this.vc.getPHPiernaDerM1().setEnabled(false);
                
                this.vc.getMedabotJ1().setEnabled(false);
                this.vc.getAtacanteJ1().setEnabled(false);
                this.vc.getDefensorJ2().setEnabled(false);
                this.vc.getAtacarJ1().setEnabled(false);
                this.vc.getMedafuerzaJ1().setEnabled(false);
                this.vc.getDefenderJ1().setEnabled(false);
                this.vc.getEsquivarJ1().setEnabled(false);            
                this.vc.getRendirseJ1().setEnabled(false);
                
                this.vc.getTerminarTurno().setEnabled(false);
                
                this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha sido noqueado!\n\n- ¡"+this.robobatalla.getJugador2().getNombre()+" es el ganador!\n\n");
                
                JOptionPane.showMessageDialog(vc, "- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha sido noqueado!\n\n- ¡"+this.robobatalla.getJugador2().getNombre()+" es el ganador!\n\n");
                                
                try {
                    
                    this.cbd.actualizarDatosJugadores(this.robobatalla.getJugador2().getNombre(),this.robobatalla.getJugador1().getNombre(),false);
                    
                    this.cbd.agregarMedaparteJugador(this.robobatalla.getJugador2(),this.robobatalla.getJugador1());
                    
                    this.escribirLog(this.robobatalla.getJugador2().getNombre()+" ha vencido a "+this.robobatalla.getJugador1().getNombre()+" en una robobatalla.");
                
                } 
                
                catch (SQLException ex) {
                    
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                
                } 
                
                catch (IOException ex) {
                    
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                
                }                
                
                if (!this.vc.getTorneo()) this.cm = new ControladorMenu();
                
                this.vc.setVisible(false);
                
                this.vc.dispose();
                
                try {
                
                    this.finalize();
                
                } 
                
                catch (Throwable ex) {
                
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                
            }
            
        }
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludCabezaM1())) {
            
            if (this.vc.getBarraSaludCabezaM1().getValue() == 0) {
                
                this.vc.getAtacanteJ1().removeItem("Cabeza");
                
                this.vc.getDefensorJ1().removeItem("Cabeza");
                
                this.vc.setSaludCabezaM1("0");
                
                this.vc.getBarraSaludCabezaM1().setEnabled(false);                
                
                this.vc.getSaludCabezaM1().setEnabled(false);
                
                this.vc.getCabezaJ1().setEnabled(false);
                
                this.vc.getPHCabezaM1().setEnabled(false);                                
                
                this.robobatalla.getJugador1().getMedabot().setDefensaTotal(this.robobatalla.getJugador1().getMedabot().getDefensaTotal() - this.robobatalla.getJugador1().getMedabot().getCabeza().getDefensa());
                
                this.robobatalla.getJugador1().getMedabot().setEsquiveTotal(this.robobatalla.getJugador1().getMedabot().getEsquiveTotal() - this.robobatalla.getJugador1().getMedabot().getCabeza().getEsquive());

                String descripcionM1 = "<html><body>Nombre: "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador1().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador1().getMedabot().getEsquiveTotal()+"</body></html>";

                this.vc.getMedarotchJ1().setToolTipText(descripcionM1);
                
                this.vc.getLogBatalla().append("- La Cabeza de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha dejado de funcionar debido a que su salud llegó a 0.\n\n");
                                
            }
            
        }
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludBrazoIzqM1())) {
            
            if (this.vc.getBarraSaludBrazoIzqM1().getValue() == 0) {
                
                this.vc.getAtacanteJ1().removeItem("Brazo Izquierdo");
                
                this.vc.getDefensorJ1().removeItem("Brazo Izquierdo");
                
                this.vc.setSaludBrazoIzqM1("0");
                
                this.vc.getBarraSaludBrazoIzqM1().setEnabled(false);
                
                this.vc.getSaludBrazoIzqM1().setEnabled(false);
                
                this.vc.getBrazoIzqJ1().setEnabled(false);
                
                this.vc.getPHBrazoIzqM1().setEnabled(false);
                
                this.robobatalla.getJugador1().getMedabot().setDefensaTotal(this.robobatalla.getJugador1().getMedabot().getDefensaTotal() - this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getDefensa());
                
                this.robobatalla.getJugador1().getMedabot().setEsquiveTotal(this.robobatalla.getJugador1().getMedabot().getEsquiveTotal() - this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getEsquive());
                                
                String descripcionM1 = "<html><body>Nombre: "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador1().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador1().getMedabot().getEsquiveTotal()+"</body></html>";

                this.vc.getMedarotchJ1().setToolTipText(descripcionM1);
                                
                this.vc.getLogBatalla().append("- El Brazo Izquierdo de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha dejado de funcionar debido a que su salud llegó a 0.\n\n");
                 
            }
            
        }
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludBrazoDerM1())) {
            
            if (this.vc.getBarraSaludBrazoDerM1().getValue() == 0) {
                
                this.vc.getAtacanteJ1().removeItem("Brazo Derecho");
                
                this.vc.getDefensorJ1().removeItem("Brazo Derecho");
                
                this.vc.setSaludBrazoDerM1("0");
                
                this.vc.getBarraSaludBrazoDerM1().setEnabled(false);
                
                this.vc.getSaludBrazoDerM1().setEnabled(false);
                
                this.vc.getBrazoDerJ1().setEnabled(false);
                
                this.vc.getPHBrazoDerM1().setEnabled(false);
                
                this.robobatalla.getJugador1().getMedabot().setDefensaTotal(this.robobatalla.getJugador1().getMedabot().getDefensaTotal() - this.robobatalla.getJugador1().getMedabot().getBrazoDer().getDefensa());
                
                this.robobatalla.getJugador1().getMedabot().setEsquiveTotal(this.robobatalla.getJugador1().getMedabot().getEsquiveTotal() - this.robobatalla.getJugador1().getMedabot().getBrazoDer().getEsquive());
                                
                String descripcionM1 = "<html><body>Nombre: "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador1().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador1().getMedabot().getEsquiveTotal()+"</body></html>";

                this.vc.getMedarotchJ1().setToolTipText(descripcionM1);
                                
                this.vc.getLogBatalla().append("- El Brazo Derecho de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha dejado de funcionar debido a que su salud llegó a 0.\n\n");
                 
            }
            
        }
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludPiernaIzqM1())) {
            
            if (this.vc.getBarraSaludPiernaIzqM1().getValue() == 0) {
                
                this.vc.getAtacanteJ1().removeItem("Pierna Izquierda");
                
                this.vc.getDefensorJ1().removeItem("Pierna Izquierda");
                
                this.vc.setSaludPiernaIzqM1("0");
                
                this.vc.getBarraSaludPiernaIzqM1().setEnabled(false);
                
                this.vc.getSaludPiernaIzqM1().setEnabled(false);
                
                this.vc.getPiernaIzqJ1().setEnabled(false);
                
                this.vc.getPHPiernaIzqM1().setEnabled(false);
                
                this.robobatalla.getJugador1().getMedabot().setDefensaTotal(this.robobatalla.getJugador1().getMedabot().getDefensaTotal() - this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getDefensa());
                
                this.robobatalla.getJugador1().getMedabot().setEsquiveTotal(this.robobatalla.getJugador1().getMedabot().getEsquiveTotal() - this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getEsquive());
                                
                String descripcionM1 = "<html><body>Nombre: "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador1().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador1().getMedabot().getEsquiveTotal()+"</body></html>";

                this.vc.getMedarotchJ1().setToolTipText(descripcionM1);
                                
                this.vc.getLogBatalla().append("- La Pierna Izquierda de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha dejado de funcionar debido a que su salud llegó a 0.\n\n");
                 
            }
            
        }
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludPiernaDerM1())) {
            
            if (this.vc.getBarraSaludPiernaDerM1().getValue() == 0) {
                
                this.vc.getAtacanteJ1().removeItem("Pierna Derecha");
                
                this.vc.getDefensorJ1().removeItem("Pierna Derecha");
                
                this.vc.setSaludPiernaDerM1("0");
                
                this.vc.getBarraSaludPiernaDerM1().setEnabled(false);
                
                this.vc.getSaludPiernaDerM1().setEnabled(false);
                
                this.vc.getPiernaDerJ1().setEnabled(false);
                
                this.vc.getPHPiernaDerM1().setEnabled(false);
                
                this.robobatalla.getJugador1().getMedabot().setDefensaTotal(this.robobatalla.getJugador1().getMedabot().getDefensaTotal() - this.robobatalla.getJugador1().getMedabot().getPiernaDer().getDefensa());
                
                this.robobatalla.getJugador1().getMedabot().setEsquiveTotal(this.robobatalla.getJugador1().getMedabot().getEsquiveTotal() - this.robobatalla.getJugador1().getMedabot().getPiernaDer().getEsquive());
                                
                String descripcionM1 = "<html><body>Nombre: "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador1().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador1().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador1().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador1().getMedabot().getEsquiveTotal()+"</body></html>";

                this.vc.getMedarotchJ1().setToolTipText(descripcionM1);
                                
                this.vc.getLogBatalla().append("- La Pierna Derecha de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha dejado de funcionar debido a que su salud llegó a 0.\n\n");
                 
            }
            
        }
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludM2())) {
            
            if (this.vc.getBarraSaludM2().getValue() == 0) {
                
                this.vc.setSaludMedabotJ2("0");
                
                this.vc.getNombreJ2().setEnabled(false);
                this.vc.getNombreM2().setEnabled(false);
                this.vc.getPHRestanteLabelJ2().setEnabled(false);
                this.vc.getPHRestanteJ2().setEnabled(false);
                this.vc.getBarraSaludM2().setEnabled(false);
                this.vc.getSaludMedabotJ2().setEnabled(false);
                this.vc.getCostoPHLabelJ2().setEnabled(false);
                
                this.vc.getCabezaJ2().setEnabled(false);
                this.vc.getBrazoIzqJ2().setEnabled(false);
                this.vc.getBrazoDerJ2().setEnabled(false);
                this.vc.getPiernaIzqJ2().setEnabled(false);
                this.vc.getPiernaDerJ2().setEnabled(false);
                
                this.vc.getBarraSaludCabezaM2().setEnabled(false);
                this.vc.getBarraSaludBrazoIzqM2().setEnabled(false);
                this.vc.getBarraSaludBrazoDerM2().setEnabled(false);
                this.vc.getBarraSaludPiernaIzqM2().setEnabled(false);
                this.vc.getBarraSaludPiernaDerM2().setEnabled(false);
                
                this.vc.getSaludCabezaM2().setEnabled(false);
                this.vc.getSaludBrazoIzqM2().setEnabled(false);
                this.vc.getSaludBrazoDerM2().setEnabled(false);
                this.vc.getSaludPiernaIzqM2().setEnabled(false);
                this.vc.getSaludPiernaDerM2().setEnabled(false);
                
                this.vc.getPHCabezaM2().setEnabled(false);
                this.vc.getPHBrazoIzqM2().setEnabled(false);
                this.vc.getPHBrazoDerM2().setEnabled(false);
                this.vc.getPHPiernaIzqM2().setEnabled(false);
                this.vc.getPHPiernaDerM2().setEnabled(false);
                
                this.vc.getMedabotJ2().setEnabled(false);
                this.vc.getAtacanteJ2().setEnabled(false);
                this.vc.getDefensorJ1().setEnabled(false);
                this.vc.getAtacarJ2().setEnabled(false);
                this.vc.getMedafuerzaJ2().setEnabled(false);
                this.vc.getDefenderJ2().setEnabled(false);
                this.vc.getEsquivarJ2().setEnabled(false);            
                this.vc.getRendirseJ2().setEnabled(false);
                
                this.vc.getTerminarTurno().setEnabled(false);
                
                this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha sido noqueado!\n\n- ¡"+this.robobatalla.getJugador1().getNombre()+" es el ganador!\n\n");
                
                JOptionPane.showMessageDialog(vc, "- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha sido noqueado!\n\n- ¡"+this.robobatalla.getJugador1().getNombre()+" es el ganador!\n\n");
                                
                try {
                    
                    this.cbd.actualizarDatosJugadores(this.robobatalla.getJugador1().getNombre(),this.robobatalla.getJugador2().getNombre(),false);
                    
                    this.cbd.agregarMedaparteJugador(this.robobatalla.getJugador1(),this.robobatalla.getJugador2());
                    
                    this.escribirLog(this.robobatalla.getJugador1().getNombre()+" ha vencido a "+this.robobatalla.getJugador2().getNombre()+" en una robobatalla.");
                
                } 
                
                catch (SQLException ex) {
                    
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                
                } 
                
                catch (IOException ex) {
                
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                
                }                
                
                if (!this.vc.getTorneo()) this.cm = new ControladorMenu();
                
                this.vc.setVisible(false);
                
                this.vc.dispose();
                
                try {
                    
                    this.finalize();
                
                } 
                
                catch (Throwable ex) {
                
                    Logger.getLogger(ControladorCombate.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                
            }
            
        }
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludCabezaM2())) {
            
            if (this.vc.getBarraSaludCabezaM2().getValue() == 0) {
                
                this.vc.getAtacanteJ2().removeItem("Cabeza");
                
                this.vc.getDefensorJ2().removeItem("Cabeza");
                
                this.vc.setSaludCabezaM2("0");
                
                this.vc.getBarraSaludCabezaM2().setEnabled(false);
                
                this.vc.getSaludCabezaM2().setEnabled(false);
                
                this.vc.getCabezaJ2().setEnabled(false);
                
                this.vc.getPHCabezaM2().setEnabled(false);
                
                this.robobatalla.getJugador2().getMedabot().setDefensaTotal(this.robobatalla.getJugador2().getMedabot().getDefensaTotal() - this.robobatalla.getJugador2().getMedabot().getCabeza().getDefensa());
                
                this.robobatalla.getJugador2().getMedabot().setEsquiveTotal(this.robobatalla.getJugador2().getMedabot().getEsquiveTotal() - this.robobatalla.getJugador2().getMedabot().getCabeza().getEsquive());

                String descripcionM2 = "<html><body>Nombre: "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador2().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador2().getMedabot().getEsquiveTotal()+"</body></html>";

                this.vc.getMedarotchJ2().setToolTipText(descripcionM2);                    

                this.vc.getLogBatalla().append("- La Cabeza de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha dejado de funcionar debido a que su salud llegó a 0.\n\n");
                             
            }
            
        }
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludBrazoIzqM2())) {
            
            if (this.vc.getBarraSaludBrazoIzqM2().getValue() == 0) {
                
                this.vc.getAtacanteJ2().removeItem("Brazo Izquierdo");
                
                this.vc.getDefensorJ2().removeItem("Brazo Izquierdo");
                
                this.vc.setSaludBrazoIzqM2("0");
                
                this.vc.getBarraSaludBrazoIzqM2().setEnabled(false);
                
                this.vc.getSaludBrazoIzqM2().setEnabled(false);
                
                this.vc.getBrazoIzqJ2().setEnabled(false);
                
                this.vc.getPHBrazoIzqM2().setEnabled(false);
                
                this.robobatalla.getJugador2().getMedabot().setDefensaTotal(this.robobatalla.getJugador2().getMedabot().getDefensaTotal() - this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getDefensa());
                
                this.robobatalla.getJugador2().getMedabot().setEsquiveTotal(this.robobatalla.getJugador2().getMedabot().getEsquiveTotal() - this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getEsquive());
               
                String descripcionM2 = "<html><body>Nombre: "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador2().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador2().getMedabot().getEsquiveTotal()+"</body></html>";

                this.vc.getMedarotchJ2().setToolTipText(descripcionM2);                    
                
                this.vc.getLogBatalla().append("- El Brazo Izquierdo de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha dejado de funcionar debido a que su salud llegó a 0.\n\n");
                
            }
            
        }
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludBrazoDerM2())) {
            
            if (this.vc.getBarraSaludBrazoDerM2().getValue() == 0) {
                
                this.vc.getAtacanteJ2().removeItem("Brazo Derecho");
                
                this.vc.getDefensorJ2().removeItem("Brazo Derecho");
                
                this.vc.setSaludBrazoDerM2("0");
                
                this.vc.getBarraSaludBrazoDerM2().setEnabled(false);
                
                this.vc.getSaludBrazoDerM2().setEnabled(false);
                
                this.vc.getBrazoDerJ2().setEnabled(false);
                
                this.vc.getPHBrazoDerM2().setEnabled(false);
                
                this.robobatalla.getJugador2().getMedabot().setDefensaTotal(this.robobatalla.getJugador2().getMedabot().getDefensaTotal() - this.robobatalla.getJugador2().getMedabot().getBrazoDer().getDefensa());
                
                this.robobatalla.getJugador2().getMedabot().setEsquiveTotal(this.robobatalla.getJugador2().getMedabot().getEsquiveTotal() - this.robobatalla.getJugador2().getMedabot().getBrazoDer().getEsquive());
               
                String descripcionM2 = "<html><body>Nombre: "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador2().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador2().getMedabot().getEsquiveTotal()+"</body></html>";

                this.vc.getMedarotchJ2().setToolTipText(descripcionM2);                    
                
                this.vc.getLogBatalla().append("- El Brazo Derecho de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha dejado de funcionar debido a que su salud llegó a 0.\n\n");
                
            }
            
        }
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludPiernaIzqM2())) {
            
            if (this.vc.getBarraSaludPiernaIzqM2().getValue() == 0) {
                
                this.vc.getAtacanteJ2().removeItem("Pierna Izquierda");
                
                this.vc.getDefensorJ2().removeItem("Pierna Izquierda");
                
                this.vc.setSaludPiernaIzqM2("0");
                
                this.vc.getBarraSaludPiernaIzqM2().setEnabled(false);
                
                this.vc.getSaludPiernaIzqM2().setEnabled(false);
                
                this.vc.getPiernaIzqJ2().setEnabled(false);
                
                this.vc.getPHPiernaIzqM2().setEnabled(false);
                
                this.robobatalla.getJugador2().getMedabot().setDefensaTotal(this.robobatalla.getJugador2().getMedabot().getDefensaTotal() - this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getDefensa());
                
                this.robobatalla.getJugador2().getMedabot().setEsquiveTotal(this.robobatalla.getJugador2().getMedabot().getEsquiveTotal() - this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getEsquive());
                                
                String descripcionM2 = "<html><body>Nombre: "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador2().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador2().getMedabot().getEsquiveTotal()+"</body></html>";

                this.vc.getMedarotchJ2().setToolTipText(descripcionM2);                    
                
                this.vc.getLogBatalla().append("- La Pierna Izquierda de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha dejado de funcionar debido a que su salud llegó a 0.\n\n");
                
            }
            
        }
        
        if (((JProgressBar)ce.getSource()).equals(this.vc.getBarraSaludPiernaDerM2())) {
            
            if (this.vc.getBarraSaludPiernaDerM2().getValue() == 0) {
                
                this.vc.getAtacanteJ2().removeItem("Pierna Derecha");
                
                this.vc.getDefensorJ2().removeItem("Pierna Derecha");
                
                this.vc.setSaludPiernaDerM2("0");
                
                this.vc.getBarraSaludPiernaDerM2().setEnabled(false);
                
                this.vc.getSaludPiernaDerM2().setEnabled(false);
                
                this.vc.getPiernaDerJ2().setEnabled(false);
                
                this.vc.getPHPiernaDerM2().setEnabled(false);
                
                this.robobatalla.getJugador2().getMedabot().setDefensaTotal(this.robobatalla.getJugador2().getMedabot().getDefensaTotal() - this.robobatalla.getJugador2().getMedabot().getPiernaDer().getDefensa());
                
                this.robobatalla.getJugador2().getMedabot().setEsquiveTotal(this.robobatalla.getJugador2().getMedabot().getEsquiveTotal() - this.robobatalla.getJugador2().getMedabot().getPiernaDer().getEsquive());
                                
                String descripcionM2 = "<html><body>Nombre: "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"<br>"
                        + "Ataque/Defensa/Esquive Cabeza: "+this.robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getCabeza().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Izquierdo: "+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Brazo Derecho: "+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getBrazoDer().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Izquierda: "+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                        + "Ataque/Defensa/Esquive Pierna Derecha: "+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getDefensa()+"/"+this.robobatalla.getJugador2().getMedabot().getPiernaDer().getEsquive()+"<br>"
                        + "Medafuerza: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza()+"<br>"
                        + "Carga: "+this.robobatalla.getJugador2().getMedabot().getMedalla().getTipoCarga()+"<br>"
                        + "Defensa Total: "+this.robobatalla.getJugador2().getMedabot().getDefensaTotal()+"<br>"
                        + "Esquive Total: "+this.robobatalla.getJugador2().getMedabot().getEsquiveTotal()+"</body></html>";

                this.vc.getMedarotchJ2().setToolTipText(descripcionM2);                    
                
                this.vc.getLogBatalla().append("- La Pierna Derecha de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha dejado de funcionar debido a que su salud llegó a 0.\n\n");
                
            }
            
        }
    
    }
    
    public void turnoCPU1J1() {
        
        int dano = 0;
        
        String mpAtacante, mpDefensora;
        
        this.robobatalla.getJugador1().getMedabot().setSaludActual(this.robobatalla.getJugador1().getMedabot().getSaludActual() - this.robobatalla.getJugador1().getMedabot().getAtaqueTotal());
                
        this.vc.setSaludMedabotJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getSaludActual()));
            
        this.vc.setBarraSaludM1(this.robobatalla.getJugador1().getMedabot().getSaludActual());                
                
        this.vc.getLogBatalla().append("- Al no defender o intentar esquivar, "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" recibe todo el daño de los ataques del turno anterior.\n\n");
                
        this.robobatalla.getJugador1().getMedabot().setAtaqueTotal(0);
        
        while(this.robobatalla.getJugador1().getMedabot().getPHRes() > 0) {
        
        if(this.vc.getCabezaJ2().isEnabled()&&this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual()>0) {
                        
            mpAtacante = "Cabeza";
            
            if(this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual() > 0) {
            
                mpDefensora = "Cabeza";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza());
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Izquierdo";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq());
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Derecho";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer());
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Izquierda";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq());
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Derecha";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getCabeza(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer());
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }            
        
        } 
        
        else if(this.vc.getBrazoIzqJ2().isEnabled()&&this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual()>0) {
                        
            mpAtacante = "Brazo Izquierdo";
            
            if(this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual() > 0) {
            
                mpDefensora = "Cabeza";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 

                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Izquierdo";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

        }
            
            else if(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Derecho";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Izquierda";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Derecha";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
        
        }
        
        else if(this.vc.getBrazoDerJ2().isEnabled()&&this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual()>0) {
                        
            mpAtacante = "Brazo Derecho";
            
            if(this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual() > 0) {
            
                mpDefensora = "Cabeza";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Izquierdo";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Derecho";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Izquierda";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Derecha";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getBrazoDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
        
        }
        
        else if(this.vc.getPiernaIzqJ2().isEnabled()&&this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual()>0) {
                        
            mpAtacante = "Pierna Izquierda";
            
            if(this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual() > 0) {
            
                mpDefensora = "Cabeza";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Izquierdo";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Derecho";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Izquierda";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Derecha";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaIzq(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
        
        }
        
        else if(this.vc.getPiernaDerJ2().isEnabled()&&this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual()>0) {
                        
            mpAtacante = "Pierna Derecha";
            
            if(this.vc.getCabezaJ2().isEnabled()) {
            
                mpDefensora = "Cabeza";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getCabeza()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.vc.getBrazoIzqJ2().isEnabled()) {
            
                mpDefensora = "Brazo Izquierdo";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.vc.getBrazoDerJ2().isEnabled()) {
            
                mpDefensora = "Brazo Derecho";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getBrazoDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.vc.getPiernaIzqJ2().isEnabled()) {
            
                mpDefensora = "Pierna Izquierda";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.vc.getPiernaDerJ2().isEnabled()) {
            
                mpDefensora = "Pierna Derecha";
            
                dano = this.robobatalla.getJugador1().getMedabot().atacar(this.robobatalla.getJugador1().getMedabot().getPiernaDer(), this.robobatalla.getJugador2().getMedabot(), this.robobatalla.getJugador2().getMedabot().getPiernaDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador1().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
        
        }
        
        this.vc.setSaludCabezaM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual()));
        this.vc.setSaludBrazoIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual()));
        this.vc.setSaludBrazoDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual()));
        this.vc.setSaludPiernaIzqM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual()));
        this.vc.setSaludPiernaDerM2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual()));
            
        this.vc.setPHJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPHRes()));
            
        this.vc.setBarraSaludCabezaM2(this.robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual());
        this.vc.setBarraSaludBrazoIzqM2(this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual());
        this.vc.setBarraSaludBrazoDerM2(this.robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual());
        this.vc.setBarraSaludPiernaIzqM2(this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual());
        this.vc.setBarraSaludPiernaDerM2(this.robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual());
                
        }
                      
        
        if(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())) 
                
            this.robobatalla.setJugadorActivo(this.robobatalla.getJugador2().getNombre());
            
        else  
                
            this.robobatalla.setJugadorActivo(this.robobatalla.getJugador1().getNombre());
            
        if (robobatalla.getJugadorActivo().equals(robobatalla.getJugador2().getNombre())) {
            
            this.vc.getAtacanteJ1().setEnabled(false);
            this.vc.getDefensorJ2().setEnabled(false);
            this.vc.getAtacarJ1().setEnabled(false);
            this.vc.getDefenderJ1().setEnabled(false);
            this.vc.getEsquivarJ1().setEnabled(false);
            this.vc.getRendirseJ1().setEnabled(false);
                
            this.vc.getAtacanteJ2().setEnabled(true);
            this.vc.getDefensorJ1().setEnabled(true);
            this.vc.getAtacarJ2().setEnabled(true);
            this.vc.getDefenderJ2().setEnabled(true);
            this.vc.getEsquivarJ2().setEnabled(true);
            this.vc.getRendirseJ2().setEnabled(true);
                
            if ((this.vc.getEstadoMedafuerzaJ1().isEnabled())&&(this.vc.getEstadoMedafuerzaJ1().getText().equals("¡Medafuerza Activada!"))) {
                    
                if(this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza().equals("Poder")){
                        
                    this.robobatalla.getJugador1().getMedabot().getCabeza().setAtaque((int) (this.robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()*0.5));
                                
                    this.robobatalla.getJugador1().getMedabot().getBrazoIzq().setAtaque((int) (this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()*0.5));
                                        
                    this.robobatalla.getJugador1().getMedabot().getBrazoDer().setAtaque((int) (this.robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()*0.5));
                                                
                    this.robobatalla.getJugador1().getMedabot().getPiernaIzq().setAtaque((int) (this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()*0.5));
                                                        
                    this.robobatalla.getJugador1().getMedabot().getPiernaDer().setAtaque((int) (this.robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()*0.5));
                        
                }
                    
                if(this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza().equals("Velocidad")){
                        
                    this.robobatalla.getJugador1().getMedabot().setEsquiveTotal(this.robobatalla.getJugador1().getMedabot().getEsquiveTotal()-50);
                        
                }
                    
                if(this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza().equals("Reaccion")){
                        
                    this.robobatalla.getJugador1().getMedabot().setPHRes((int) (this.robobatalla.getJugador1().getMedabot().getPHRes()*0.5));
                        
                }
                    
                if(this.robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza().equals("Invulnerabilidad")){
                        
                    this.robobatalla.getJugador1().getMedabot().setDefensaTotal(this.robobatalla.getJugador1().getMedabot().getDefensaTotal()-100);
                        
                }
                    
                this.vc.setEstadoMedafuerzaJ1("Medafuerza Inactiva");
                this.vc.getEstadoMedafuerzaJ1().setEnabled(false);
                    
            }
                
            boolean mfActivadaJ2 = this.robobatalla.getJugador2().getMedabot().cargarMedafuerza(this.robobatalla.getJugador2().getMedabot());
            
            if (mfActivadaJ2) {
                    
                this.vc.getMedafuerzaJ2().setEnabled(true);
                    
                this.vc.getLogBatalla().append("¡La medafuerza de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0, this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" está lista para ser activada!\n\n");
                
                this.vc.getEstadoMedafuerzaJ2().setEnabled(true);
                    
                this.vc.setEstadoMedafuerzaJ2("¡Medafuerza Lista!");
                    
            }
                
        }
    
        this.vc.getTerminarTurno().setEnabled(false);
            
        this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().setPHRes(this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getPHMax());
                        
        if (this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())) {
               
            this.vc.setPHJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPHRes()));
                
        }
            
        if (this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())) {
                
            this.vc.setPHJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPHRes()));
                
        }
                        
        this.robobatalla.setTurno(this.robobatalla.getTurno()+1);
            
        this.vc.getLogBatalla().append("* "+this.vc.numeroAOrdinal(this.robobatalla.getTurno()).substring(0, 1).toUpperCase() + this.vc.numeroAOrdinal(this.robobatalla.getTurno()).substring(1)+" turno - Turno de "+this.robobatalla.getJugadorActivo()+".\nPuede escoger entre defender o esquivar los ataques realizados el turno anterior, o recibir todo el daño y sólo atacar.\n\n");
             
    }    
    
    public void turnoCPU1J2() {
        
        int dano = 0;
        
        String mpAtacante, mpDefensora;
        
        this.robobatalla.getJugador2().getMedabot().setSaludActual(this.robobatalla.getJugador2().getMedabot().getSaludActual() - this.robobatalla.getJugador2().getMedabot().getAtaqueTotal());
                
        this.vc.setSaludMedabotJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getSaludActual()));
            
        this.vc.setBarraSaludM2(this.robobatalla.getJugador2().getMedabot().getSaludActual());
                            
        this.vc.getLogBatalla().append("- Al no defender o intentar esquivar, "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" recibe todo el daño de los ataques del turno anterior.\n\n");
                
        this.robobatalla.getJugador2().getMedabot().setAtaqueTotal(0);
        
        while(this.robobatalla.getJugador2().getMedabot().getPHRes() > 0) {
        
        if(this.vc.getCabezaJ1().isEnabled()&&this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual()>0) {
                        
            mpAtacante = "Cabeza";
            
            if(this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual() > 0) {
            
                mpDefensora = "Cabeza";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
 
                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
     
            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Izquierdo";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Derecho";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Izquierda";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Derecha";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getCabeza(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }            
        
        } 
        
        else if(this.vc.getBrazoIzqJ1().isEnabled()&&this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual()>0) {
                        
            mpAtacante = "Brazo Izquierdo";
            
            if(this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual() > 0) {
            
                mpDefensora = "Cabeza";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Izquierdo";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Derecho";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Izquierda";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Derecha";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
        
        }
        
        else if(this.vc.getBrazoDerJ1().isEnabled()&&this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual()>0) {
                        
            mpAtacante = "Brazo Derecho";
            
            if(this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual() > 0) {
            
                mpDefensora = "Cabeza";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Izquierdo";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Derecho";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");
           
                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Izquierda";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Derecha";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getBrazoDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque del "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
        
        }
        
        else if(this.vc.getPiernaIzqJ1().isEnabled()&&this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual()>0) {
                        
            mpAtacante = "Pierna Izquierda";
            
            if(this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual() > 0) {
            
                mpDefensora = "Cabeza";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Izquierdo";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual() > 0) {
            
                mpDefensora = "Brazo Derecho";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Izquierda";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
            
            else if(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual() > 0) {
            
                mpDefensora = "Pierna Derecha";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaIzq(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                            
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
        
        }
        
        else if(this.vc.getPiernaDerJ1().isEnabled()&&this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual()>0) {
                        
            mpAtacante = "Pierna Derecha";
            
            if(this.vc.getCabezaJ1().isEnabled()) {
            
                mpDefensora = "Cabeza";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getCabeza()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
            
            else if(this.vc.getBrazoIzqJ1().isEnabled()) {
            
                mpDefensora = "Brazo Izquierdo";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.vc.getBrazoDerJ1().isEnabled()) {
            
                mpDefensora = "Brazo Derecho";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getBrazoDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nEl "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún daño!\n\n");

                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡El "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");

            }
            
            else if(this.vc.getPiernaIzqJ1().isEnabled()) {
            
                mpDefensora = "Pierna Izquierda";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaIzq()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
            
            else if(this.vc.getPiernaDerJ1().isEnabled()) {
            
                mpDefensora = "Pierna Derecha";
            
                dano = this.robobatalla.getJugador2().getMedabot().atacar(this.robobatalla.getJugador2().getMedabot().getPiernaDer(), this.robobatalla.getJugador1().getMedabot(), this.robobatalla.getJugador1().getMedabot().getPiernaDer()); 
                
                if((dano > 0)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\nLa "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha recibido "+dano+" de daño por el ataque de la "+mpAtacante+" de "+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+".\n\n");

                if((dano == 0)&&(this.robobatalla.getJugador2().getMedabot().getPHRes() != 0)&&(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" no ha recibido ningún dano!\n\n");
 
                if((dano == -1)&&this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre()))this.vc.getLogBatalla().append("- ¡"+this.robobatalla.getJugador2().getMedabot().getNombre().substring(0,this.robobatalla.getJugador2().getMedabot().getNombre().length()-2)+" ataca!\n¡La "+mpDefensora+" de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0,this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" ha evadido el ataque!\n\n");
 
            }
        
        }
        
        this.vc.setSaludCabezaM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual()));
        this.vc.setSaludBrazoIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual()));
        this.vc.setSaludBrazoDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual()));
        this.vc.setSaludPiernaIzqM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual()));
        this.vc.setSaludPiernaDerM1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual()));
            
        this.vc.setPHJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPHRes()));
            
        this.vc.setBarraSaludCabezaM1(this.robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual());
        this.vc.setBarraSaludBrazoIzqM1(this.robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual());
        this.vc.setBarraSaludBrazoDerM1(this.robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual());
        this.vc.setBarraSaludPiernaIzqM1(this.robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual());
        this.vc.setBarraSaludPiernaDerM1(this.robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual());
                
        }
                      
        
        if(this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())) 
                
            this.robobatalla.setJugadorActivo(this.robobatalla.getJugador2().getNombre());
            
        else  
                
            this.robobatalla.setJugadorActivo(this.robobatalla.getJugador1().getNombre());
            
        if (robobatalla.getJugadorActivo().equals(robobatalla.getJugador1().getNombre())) {
            
            this.vc.getAtacanteJ2().setEnabled(false);
            this.vc.getDefensorJ1().setEnabled(false);
            this.vc.getAtacarJ2().setEnabled(false);
            this.vc.getDefenderJ2().setEnabled(false);
            this.vc.getEsquivarJ2().setEnabled(false);
            this.vc.getRendirseJ2().setEnabled(false);
                
            this.vc.getAtacanteJ1().setEnabled(true);
            this.vc.getDefensorJ2().setEnabled(true);
            this.vc.getAtacarJ1().setEnabled(true);
            this.vc.getDefenderJ1().setEnabled(true);
            this.vc.getEsquivarJ1().setEnabled(true);
            this.vc.getRendirseJ1().setEnabled(true);
            
            this.vc.getMedarotchJ1().setEnabled(true);
                
            if ((this.vc.getEstadoMedafuerzaJ2().isEnabled())&&(this.vc.getEstadoMedafuerzaJ2().getText().equals("¡Medafuerza Activada!"))) {
                    
                if(this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza().equals("Poder")){
                        
                    this.robobatalla.getJugador2().getMedabot().getCabeza().setAtaque((int) (this.robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()*0.5));
                                
                    this.robobatalla.getJugador2().getMedabot().getBrazoIzq().setAtaque((int) (this.robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()*0.5));
                                        
                    this.robobatalla.getJugador2().getMedabot().getBrazoDer().setAtaque((int) (this.robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()*0.5));
                                                
                    this.robobatalla.getJugador2().getMedabot().getPiernaIzq().setAtaque((int) (this.robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()*0.5));
                                                        
                    this.robobatalla.getJugador2().getMedabot().getPiernaDer().setAtaque((int) (this.robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()*0.5));
                        
                }
                    
                if(this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza().equals("Velocidad")){
                        
                    this.robobatalla.getJugador2().getMedabot().setEsquiveTotal(this.robobatalla.getJugador2().getMedabot().getEsquiveTotal()-50);
                        
                }
                    
                if(this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza().equals("Reaccion")){
                        
                    this.robobatalla.getJugador2().getMedabot().setPHRes((int) (this.robobatalla.getJugador2().getMedabot().getPHRes()*0.5));
                        
                }
                    
                if(this.robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza().equals("Invulnerabilidad")){
                        
                    this.robobatalla.getJugador2().getMedabot().setDefensaTotal(this.robobatalla.getJugador2().getMedabot().getDefensaTotal()-100);
                        
                }
                    
                this.vc.setEstadoMedafuerzaJ2("Medafuerza Inactiva");
                this.vc.getEstadoMedafuerzaJ2().setEnabled(false);
                    
            }
                
            boolean mfActivadaJ1 = this.robobatalla.getJugador1().getMedabot().cargarMedafuerza(this.robobatalla.getJugador2().getMedabot());
            
            if (mfActivadaJ1) {
                    
                this.vc.getMedafuerzaJ1().setEnabled(true);
                    
                this.vc.getLogBatalla().append("¡La medafuerza de "+this.robobatalla.getJugador1().getMedabot().getNombre().substring(0, this.robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" está lista para ser activada!\n\n");
                
                this.vc.getEstadoMedafuerzaJ1().setEnabled(true);
                    
                this.vc.setEstadoMedafuerzaJ1("¡Medafuerza Lista!");
                    
            }
                
        }
    
        this.vc.getTerminarTurno().setEnabled(false);
            
        this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().setPHRes(this.robobatalla.getJugadorActivo(this.robobatalla.getJugadorActivo()).getMedabot().getPHMax());
                        
        if (this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador1().getNombre())) {
               
            this.vc.setPHJ1(String.valueOf(this.robobatalla.getJugador1().getMedabot().getPHRes()));
                
        }
            
        if (this.robobatalla.getJugadorActivo().equals(this.robobatalla.getJugador2().getNombre())) {
                
            this.vc.setPHJ2(String.valueOf(this.robobatalla.getJugador2().getMedabot().getPHRes()));
                
        }
                        
        this.robobatalla.setTurno(this.robobatalla.getTurno()+1);
            
        this.vc.getLogBatalla().append("* "+this.vc.numeroAOrdinal(this.robobatalla.getTurno()).substring(0, 1).toUpperCase() + this.vc.numeroAOrdinal(this.robobatalla.getTurno()).substring(1)+" turno - Turno de "+this.robobatalla.getJugadorActivo()+".\nPuede escoger entre defender o esquivar los ataques realizados el turno anterior, o recibir todo el daño y sólo atacar.\n\n");
             
    }
    
    private void simulacion() {
        
        while(this.robobatalla.getJugador1().getMedabot().getSaludActual() >0 && this.robobatalla.getJugador2().getMedabot().getSaludActual() >0) {
            
            if (this.robobatalla.getJugador1().getMedabot().getSaludActual() >0 && this.robobatalla.getJugador2().getMedabot().getSaludActual() >0) this.turnoCPU1J1();
            if (this.robobatalla.getJugador1().getMedabot().getSaludActual() >0 && this.robobatalla.getJugador2().getMedabot().getSaludActual() >0) this.turnoCPU1J2();
            
        }
        
    }
    
}
