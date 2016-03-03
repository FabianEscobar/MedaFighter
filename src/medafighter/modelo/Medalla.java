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
public class Medalla {
    
    private String nombre;
    
    private String potenciador;
    
    private String tipoCarga;
    
    private String medafuerza;
    
    private int cantidad;
    
    private int turnoCarga;
    
    private ConexionBD cbd;
    
    public Medalla (String nombre) throws SQLException {
        
        this.cbd = new ConexionBD();
        
        this.nombre = nombre;
        
        ArrayList<Object> datosMedalla = new ArrayList<>();
        
        datosMedalla = cbd.buscarMedalla(nombre);
        
        this.potenciador = (String)datosMedalla.get(1);
        
        this.cantidad = (Integer)datosMedalla.get(2);
        
        this.tipoCarga = (String)datosMedalla.get(3);
        
        this.medafuerza = (String)datosMedalla.get(4);
        
        this.turnoCarga = 0;
        
    }
    
    // getters
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getPotenciador(){
        return this.potenciador;
    }
    
    public String getTipoCarga(){
        return this.tipoCarga;
    }
    
    public String getMedafuerza(){
        return this.medafuerza;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    public int getTurnoCarga(){
        return this.turnoCarga;
    }
    
    // setters
    
    public void setTurnoCarga(int turnoCarga){
        this.turnoCarga = turnoCarga;
    }
    
}
