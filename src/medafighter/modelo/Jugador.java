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
    
    public Medabot medabot;
    
    protected ConexionBD cbd;
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Medabot getMedabot(){
        return this.medabot;
    }
    
}
