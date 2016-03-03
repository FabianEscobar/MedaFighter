/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.modelo;

/**
 *
 * @author Fabián
 */
public abstract class Jugador {
    
    protected String nombre;
    
    protected String tipo;
    
    protected int victorias;
    
    protected int derrotas;
    
    protected int torneos;
    
    protected Medabot medabot;
    
    protected ConexionBD cbd;
    
    // getters
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Medabot getMedabot(){
        return this.medabot;
    }
    
    public int getVictorias(){
        return this.victorias;
    }
    
    public int getDerrotas(){
        return this.derrotas;
    }
    
    public int getTorneos(){
        return this.torneos;
    }
    
    public abstract String getTipoCPU();
    
    // setters
    
    public void setVictorias(int victorias){
        this.victorias = victorias;
    }
    
    public void setDerrotas(int derrotas){
        this.derrotas = derrotas;
    }
    
    public void setTorneos(int torneos){
        this.torneos = torneos;
    }
    
}
