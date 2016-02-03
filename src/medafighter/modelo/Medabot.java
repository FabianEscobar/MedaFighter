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
    
    private int ataqueTotal;
    
    private int defensaTotal;
    
    private int esquiveTotal;
    
    private int puntosHabilidadMax;
    
    private int puntosHabilidadRes;
    
    private ConexionBD cbd;
    
    public Medabot (String nombre, String usuario) throws SQLException {
        
        this.nombre = nombre;
        this.jugador = usuario;
        
        this.danoTotal = 0;
        
        this.ataqueTotal = 0;
        
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
        
        this.puntosHabilidadMax = 10;
        
        this.puntosHabilidadRes = this.puntosHabilidadMax;
        
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
    
    public int getAtaqueTotal(){
        return this.ataqueTotal;
    }
    
    public int getDanoTotal(){
        return this.danoTotal;
    }
    
    public int getPHMax() {
        return this.puntosHabilidadMax;        
    }
    
    public int getPHRes() {
        return this.puntosHabilidadRes;        
    }
    
    
    public void setSaludActual(int saludActual){
        this.saludActual = saludActual;
    }
    
    public void setAtaqueTotal(int ataqueTotal){
        this.ataqueTotal = ataqueTotal;
    }
    
    public void setDanoTotal(int danoTotal){
        this.danoTotal = danoTotal;
    }
    
    public void setPHRes(int puntosHabilidadesRes) {
        this.puntosHabilidadRes = puntosHabilidadesRes;
    }
    
        
    public int atacar(Medaparte medaparteAtacante, Medabot medabotEnemigo, Medaparte medaparteEnemiga) {
        
        int dano = 0;
        
        if (this.getPHRes() > 0) {
            
            dano = medaparteAtacante.getAtaque() - medaparteEnemiga.getDefensa();
            
            if (dano > 0) {
                
                medaparteEnemiga.setSaludActual(medaparteEnemiga.getSaludActual() - dano);
                
            }  
            
            this.setPHRes(this.getPHRes() - 2);
            
            medabotEnemigo.setDanoTotal(medabotEnemigo.getDanoTotal() + dano);
            
            medabotEnemigo.ataqueTotal = medabotEnemigo.ataqueTotal + medaparteAtacante.getAtaque();
            
        }        
                       
        return dano;
        
    }
    
    public void defender(int ataqueTotal) {
        
        //int danoFinal = danoTotal - this.defensaTotal;
        
        int danoFinal = ataqueTotal - this.defensaTotal;
        
        if(this.getPHRes() > 0) {
            
            if (danoFinal > 0) {
            
                this.saludActual = this.saludActual - danoFinal;            
            
            }
        
            this.danoTotal = 0;
            
            this.setPHRes(this.getPHRes() - 2);
            
        }
     
    }
    
    public boolean esquivar(int danoTotal) {
        
        boolean esquive = false;
        
        if(this.getPHRes() > 0) {
            
            int danoFinal = 0;
        
            esquive = new Random().nextInt(100 - this.esquiveTotal) == 0;
        
            if (esquive == false) {
            
                danoFinal = danoTotal;            
            
            }   
        
            else {
            
                danoFinal = 0;            
            
            }
        
            if (danoFinal > 0) {
            
                this.saludActual = this.saludActual - danoFinal;            
            
            }
        
            this.danoTotal = 0;
            
            this.setPHRes(this.getPHRes() - 2);
            
        }
        
        return esquive;
        
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
