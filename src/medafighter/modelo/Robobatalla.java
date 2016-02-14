/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.modelo;

import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author Fabián
 */
public class Robobatalla {
    
    private Jugador jugador1;
    
    private Jugador jugador2;
    
    private String modoJuego;
    
    private int turno;
    
    private String jugadorActivo;
    
    private ConexionBD cbd;

    public Robobatalla(String jugador1, String jugador2, String versionMedabotJ1, String versionMedabotJ2, String modoJuego) throws SQLException {

        this.cbd = new ConexionBD();
        
        if (modoJuego.equals("Jugador v/s Jugador")) {
            
            this.jugador1 = new JugadorHumano(jugador1, versionMedabotJ1);
            this.jugador2 = new JugadorHumano(jugador2, versionMedabotJ2);
            
        }
        
        if (modoJuego.equals("Jugador v/s CPU")) {
            
            this.jugador1 = new JugadorHumano(jugador1, versionMedabotJ1);
            this.jugador2 = new JugadorCPU(jugador2, versionMedabotJ1);
            
        }
        
        if (modoJuego.equals("CPU V/S CPU")) {
            
            this.jugador1 = new JugadorCPU(jugador1, versionMedabotJ1);
            this.jugador2 = new JugadorCPU(jugador2, versionMedabotJ1);
            
        }
        
        this.turno = 1;
        
        this.modoJuego = modoJuego;
        
        this.jugadorActivo = this.jugador1.getNombre();
        
        boolean moneda = new Random().nextInt(2) == 0;
        
        if (moneda == true) {jugadorActivo = jugador1;} else {jugadorActivo = jugador2;}

    }
    
    public Jugador getJugador1(){
        return this.jugador1;
    }
    
    public Jugador getJugador2(){
        return this.jugador2;
    }
    
    public String getModoJuego(){
        return this.modoJuego;
    }
    
    public int getTurno(){
        return this.turno;
    }
    
    public String getJugadorActivo(){
        return this.jugadorActivo;
    }
    
    public Jugador getJugadorActivo(String jugadorActivo) {
        
        if (jugadorActivo.equals(this.jugador1.getNombre())) return this.jugador1;
        
        if (jugadorActivo.equals(this.jugador2.getNombre())) return this.jugador2;
        
        return null;
        
    }
    
    
    public void setTurno(int turno){
        this.turno = turno;
    }
    
    public void setJugadorActivo(String jugadorActivo){
        this.jugadorActivo = jugadorActivo;
    }

}