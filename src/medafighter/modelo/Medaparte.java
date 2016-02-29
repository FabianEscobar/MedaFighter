/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.modelo;

/* Clases importadas */

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabián
 */
public class Medaparte {
    
    private String nombre;
    
    private String tipo;
    
    private String habilidad;
    
    private int saludMaxima;
    
    private int saludActual;
    
    private int ataque;
    
    private int defensa;
    
    private int precision;
    
    private int recuperacion;
    
    private int esquive;
    
    private int costoPH;
    
    private ConexionBD cbd;
    
    public Medaparte (String nombre) throws SQLException {
        
        this.nombre = nombre;
        
        this.cbd = new ConexionBD();
        
        ArrayList<Object> datosMedaparte = new ArrayList<>();
        
        datosMedaparte = cbd.buscarMedaparte(nombre);
        
        this.saludMaxima = (Integer)datosMedaparte.get(1);
        
        this.saludActual = saludMaxima;
        
        this.tipo = (String)datosMedaparte.get(2);
        
        this.ataque = (Integer)datosMedaparte.get(3);
        
        this.habilidad = (String)datosMedaparte.get(4);
        
        this.defensa = (Integer)datosMedaparte.get(5);
        
        this.precision = (Integer)datosMedaparte.get(6);
        
        this.recuperacion = (Integer)datosMedaparte.get(7);
        
        this.esquive = (Integer)datosMedaparte.get(8);
        
        this.costoPH = (Integer)datosMedaparte.get(9);
        
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public String getHabilidad(){
        return this.habilidad;
    }
    
    public int getSaludActual(){
        return this.saludActual;
    }
    
    public int getSaludMaxima(){
        return this.saludMaxima;
    }
    
    public int getCostoPH(){
        return this.costoPH;
    }
    
    public int getAtaque(){
        return this.ataque;
    }
    
    public int getDefensa(){
        return this.defensa;
    }
    
    public int getPrecision(){
        return this.precision;
    }
    
    public int getRecuperacion(){
        return this.recuperacion;
    }
    
    public int getEsquive(){
        return this.esquive;
    }
    
    
    public void setSaludActual(int saludActual){
        this.saludActual = saludActual;
    }
    
    public void setAtaque(int ataque){
        this.ataque = ataque;
    }
    
    public void setDefensa(int defensa){
        this.defensa = defensa;
    }
    
    public void setPrecision(int precision){
        this.precision = precision;
    }
    
    public void setRecuperacion(int recuperacion){
        this.recuperacion = recuperacion;
    }
    
    public void setEsquive(int esquive){
        this.esquive = esquive;
    }
    
}
