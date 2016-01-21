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
    
    private int puntosHabilidad;
    
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
        
        this.puntosHabilidad = (Integer)datosMedaparte.get(9);
        
    }
    
    public int getSaludActual(){
        return this.saludActual;
    }
    
    public int getSaludMaxima(){
        return this.saludMaxima;
    }
    
    public int getPH(){
        return this.puntosHabilidad;
    }
    
}
