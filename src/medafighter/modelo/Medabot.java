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
        
        if (this.medalla.getPotenciador().equals("ataqueCercano")) {
            
            this.cabeza.setAtaque(this.cabeza.getAtaque()+this.medalla.getCantidad());
            this.brazoIzq.setAtaque(this.brazoIzq.getAtaque()+this.medalla.getCantidad());
            this.brazoDer.setAtaque(this.brazoDer.getAtaque()+this.medalla.getCantidad());
            this.piernaIzq.setAtaque(this.piernaIzq.getAtaque()+this.medalla.getCantidad());
            this.piernaDer.setAtaque(this.piernaDer.getAtaque()+this.medalla.getCantidad());
            
        }
        
        if (this.medalla.getPotenciador().equals("defensa")) {
            
            this.cabeza.setDefensa(this.cabeza.getDefensa()+this.medalla.getCantidad());
            this.brazoIzq.setDefensa(this.brazoIzq.getDefensa()+this.medalla.getCantidad());
            this.brazoDer.setDefensa(this.brazoDer.getDefensa()+this.medalla.getCantidad());
            this.piernaIzq.setDefensa(this.piernaIzq.getDefensa()+this.medalla.getCantidad());
            this.piernaDer.setDefensa(this.piernaDer.getDefensa()+this.medalla.getCantidad());
            
        }
        
        if (this.medalla.getPotenciador().equals("precision")) {
            
            this.cabeza.setPrecision(this.cabeza.getPrecision()+this.medalla.getCantidad());
            this.brazoIzq.setPrecision(this.brazoIzq.getPrecision()+this.medalla.getCantidad());
            this.brazoDer.setPrecision(this.brazoDer.getPrecision()+this.medalla.getCantidad());
            this.piernaIzq.setPrecision(this.piernaIzq.getPrecision()+this.medalla.getCantidad());
            this.piernaDer.setPrecision(this.piernaDer.getPrecision()+this.medalla.getCantidad());
            
        }
        
        if (this.medalla.getPotenciador().equals("esquive")) {
            
            this.cabeza.setEsquive(this.cabeza.getEsquive()+this.medalla.getCantidad());
            this.brazoIzq.setEsquive(this.brazoIzq.getEsquive()+this.medalla.getCantidad());
            this.brazoDer.setEsquive(this.brazoDer.getEsquive()+this.medalla.getCantidad());
            this.piernaIzq.setEsquive(this.piernaIzq.getEsquive()+this.medalla.getCantidad());
            this.piernaDer.setEsquive(this.piernaDer.getEsquive()+this.medalla.getCantidad());
            
        }
        
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
    
    public Medalla getMedalla(){
        return this.medalla;
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
    
    public int getDefensaTotal() {
        return this.defensaTotal;        
    }
    
    public int getEsquiveTotal() {
        return this.esquiveTotal;        
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
    
    public void setDefensaTotal(int defensaTotal) {
        this.defensaTotal = defensaTotal;
    }
    
    public void setEsquiveTotal(int esquiveTotal) {
        this.esquiveTotal = esquiveTotal;
    }
    
        
    public int atacar(Medaparte medaparteAtacante, Medabot medabotEnemigo, Medaparte medaparteEnemiga) {
        
        int dano = 0;
        
        if (this.getPHRes() > 0) {
            
            int porcentaje = (int)(100 - medaparteAtacante.getPrecision() + medaparteEnemiga.getEsquive());
            
            if(new Random().nextInt(100) > porcentaje) dano = medaparteAtacante.getAtaque() - medaparteEnemiga.getDefensa();
            
            else dano = -1;
                        
            if (dano > 0) {
                
                medaparteEnemiga.setSaludActual(medaparteEnemiga.getSaludActual() - dano);
                
                medabotEnemigo.ataqueTotal = medabotEnemigo.ataqueTotal + medaparteAtacante.getAtaque();
                
            }  
            
            this.setPHRes(this.getPHRes() - medaparteAtacante.getCostoPH());
            
            //medabotEnemigo.setDanoTotal(medabotEnemigo.getDanoTotal() + dano);
            
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
            
            int porcentaje = 100 - this.esquiveTotal; 
        
            esquive = new Random().nextInt(100) > porcentaje;
        
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
    
    public boolean cargarMedafuerza(Medabot medabotEnemigo) {
        
        boolean carga = false;
        
            if (this.medalla.getTipoCarga().equals("venganza")) {
        
                if ((this.saludActual == (int)this.saludMaxima*0.75)||(this.saludActual == (int)this.saludMaxima*0.5)||(this.saludActual == (int)this.saludMaxima*0.25)) {
                
                    carga = true;
                
                }
            
            }
            
            if (this.medalla.getTipoCarga().equals("racha")) {
        
                if ((medabotEnemigo.getSaludActual() == (int)medabotEnemigo.getSaludMaxima()*0.75)||(medabotEnemigo.getSaludActual() == (int)medabotEnemigo.getSaludMaxima()*0.5)||(medabotEnemigo.getSaludActual() == (int)medabotEnemigo.getSaludMaxima()*0.25)) {
                
                    carga = true;
                
                }
            
            }
            
            if (this.medalla.getTipoCarga().equals("concentracion")) {
        
                if (this.medalla.getTurnoCarga() == 15) {
                
                    carga = true;
                
                }
                
                else this.medalla.setTurnoCarga(this.medalla.getTurnoCarga()+1);
            
            }
        
        return carga;
        
    }
    
    public boolean activarMedafuerza() {
        
        if (this.medalla.getMedafuerza().equals("Regeneracion")) {
            
            this.saludActual = (int) (this.saludActual*1.25);
            
            this.cabeza.setSaludActual((int) (this.cabeza.getSaludActual()*1.25));
            
            this.brazoIzq.setSaludActual((int) (this.brazoIzq.getSaludActual()*1.25));
            
            this.brazoDer.setSaludActual((int) (this.brazoDer.getSaludActual()*1.25));
            
            this.piernaIzq.setSaludActual((int) (this.piernaIzq.getSaludActual()*1.25));
            
            this.piernaDer.setSaludActual((int) (this.piernaDer.getSaludActual()*1.25));
            
        }
        
        if (this.medalla.getMedafuerza().equals("Reaccion")) {
            
            this.puntosHabilidadRes = this.puntosHabilidadRes*2;
            
        }
        
        if (this.medalla.getMedafuerza().equals("Poder")) {
            
            this.cabeza.setAtaque(this.cabeza.getAtaque()*2);
            
            this.brazoIzq.setAtaque(this.brazoIzq.getAtaque()*2);
            
            this.brazoDer.setAtaque(this.brazoDer.getAtaque()*2);
            
            this.piernaIzq.setAtaque(this.piernaIzq.getAtaque()*2);
            
            this.piernaDer.setAtaque(this.piernaDer.getAtaque()*2);
            
        }
        
        if (this.medalla.getMedafuerza().equals("Velocidad")) {
            
            this.esquiveTotal = this.esquiveTotal +50;
            
        }
        
        if (this.medalla.getMedafuerza().equals("Invulnerabilidad")) {
            
            this.defensaTotal = this.defensaTotal+100;
            
        }
        
        return true;
        
    }
    
    public boolean noqueado(int saludActual, int dañoFinal) {
        
        boolean noqueado = false;
        
        return noqueado;
        
    }
    
}
