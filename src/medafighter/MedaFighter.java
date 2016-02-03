/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.UIManager;
import medafighter.controladores.ControladorIngreso;
/**
 *
 * @author Fabián
 */
public class MedaFighter {

    /**
     * @param args the command line arguments
     */
    
    /*Main de la aplicación: selecciona el diseño de UI de Windows y crea un objeto ControladorIngreso,*/
    /*el cual permite crear a su vez un objeto VistaIngreso para que el usuario pueda ingresar.*/
    
    public static void main(String[] args) throws SQLException {
        
        try { 
    
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 

        } 
        catch (Exception ex) { 
    
            ex.printStackTrace(); 

        }
        
        ControladorIngreso ci = new ControladorIngreso();
        
    }
    
}
