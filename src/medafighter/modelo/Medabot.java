/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabián
 */
public class Medabot {
    
    private String nombre;
    
    private String jugador;
    
    private Medaparte cabeza;
    
    private Medaparte brazoIzq;
    
    private Medaparte brazoDer;
    
    private Medaparte piernaIzq;
    
    private Medaparte piernaDer;
    
    private Medalla medalla;
    
    private int saludMaxima;
    
    private int saludActual;
    
    private ConexionBD cbd;
    
    public Medabot (String nombre, String usuario) throws SQLException {
        
        this.nombre = nombre;
        this.jugador = usuario;
        
        this.cbd = new ConexionBD();
        
        ArrayList<Object> datosMedabot = new ArrayList<>();
        
        datosMedabot = cbd.buscarMedabot(nombre);
                 
        this.saludMaxima = (Integer)datosMedabot.get(0);
                
        this.saludActual = saludMaxima;
        
        this.cabeza = new Medaparte((String)datosMedabot.get(3));
        this.brazoIzq = new Medaparte((String)datosMedabot.get(4));
        this.brazoDer = new Medaparte((String)datosMedabot.get(5));
        this.piernaIzq = new Medaparte((String)datosMedabot.get(6));
        this.piernaDer = new Medaparte((String)datosMedabot.get(7));
        
        this.medalla = new Medalla((String)datosMedabot.get(8));
        
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Medaparte getCabeza(){
        return this.cabeza;
    }
    
    public Medaparte getBrazoIzq(){
        return this.brazoIzq;
    }
    
    public Medaparte getBrazoDer(){
        return this.brazoDer;
    }
    
    public Medaparte getPiernaIzq(){
        return this.piernaIzq;
    }
    
    public Medaparte getPiernaDer(){
        return this.piernaDer;
    }
    
    public int getSaludActual(){
        return this.saludActual;
    }
    
    public int getSaludMaxima(){
        return this.saludMaxima;
    }
    
    
    public void setSaludActual(int saludActual){
        this.saludActual = saludActual;
    }
    
    public void atacar() {
        
        
    }
    
    public void defender() {
        
     
    }
    
    public void esquivar() {        
        
        
    }
    
    public boolean noqueado(int saludActual, int dañoFinal) {
        
        boolean noqueado = false;
        
        
        return noqueado;
        
    }
    
    
    
}
