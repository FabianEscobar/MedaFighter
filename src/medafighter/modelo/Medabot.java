/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

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
    
    private int danoTotal;
    
    private int defensaTotal;
    
    private int esquiveTotal;
    
    private ConexionBD cbd;
    
    public Medabot (String nombre, String usuario) throws SQLException {
        
        this.nombre = nombre;
        this.jugador = usuario;
        
        this.danoTotal = 0;
        
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
        
        this.defensaTotal = this.cabeza.getDefensa() + this.brazoIzq.getDefensa() + this.brazoDer.getDefensa() + this.piernaIzq.getDefensa() + this.piernaDer.getDefensa();
        
        this.esquiveTotal = this.cabeza.getEsquive() + this.brazoIzq.getEsquive() + this.brazoDer.getEsquive() + this.piernaIzq.getEsquive() + this.piernaDer.getEsquive();
        
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
    
    public int getDanoTotal(){
        return this.danoTotal;
    }
    
    
    public void setSaludActual(int saludActual){
        this.saludActual = saludActual;
    }
    
    public void setDanoTotal(int danoTotal){
        this.danoTotal = danoTotal;
    }
    
    
    public int atacar(Medaparte medaparteAtacante, Medabot medabotEnemigo, Medaparte medaparteEnemiga) {
        
        int dano = 0;
        
        if (medaparteAtacante.getPHRes() > 0) {
            
            dano = medaparteAtacante.getAtaque() - medaparteEnemiga.getDefensa();
            
            if (dano > 0) {
                
                medaparteEnemiga.setSaludActual(medaparteEnemiga.getSaludActual() - dano);
                
            }  
            
            medaparteAtacante.setPHRes(medaparteAtacante.getPHRes() - 1);
            
            medabotEnemigo.setDanoTotal(medabotEnemigo.getDanoTotal() + dano);
            
        }
                
        return dano;
        
    }
    
    public void defender(int danoTotal) {
        
        int danoFinal = danoTotal - this.defensaTotal;
        
        if (danoFinal > 0) {
            
            this.saludActual = this.saludActual - danoFinal;            
            
        }
        
        this.danoTotal = 0;
     
    }
    
    public void esquivar(int danoTotal) {
        
        int danoFinal = 0;
        
        boolean probabilidadAtaque = new Random().nextInt(100 - this.esquiveTotal) == 0;
        
        if (probabilidadAtaque == true) {
            
            danoFinal = danoTotal;            
            
        }
        
        else {
            
            danoFinal = 0;            
            
        }
        
        if (danoFinal > 0) {
            
            this.saludActual = this.saludActual - danoFinal;            
            
        }
        
        this.danoTotal = 0;    
        
    }
    
    public void cargarMedafuerza() {
        
        
        
    }
    
    public void activarMedafuerza() {
        
        
        
    }
    
    public boolean noqueado(int saludActual, int dañoFinal) {
        
        boolean noqueado = false;
        
        
        return noqueado;
        
    }
    
}
