/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter;

import java.sql.SQLException;
import javax.swing.UIManager;
import medafighter.controladores.ControladorIngreso;
import medafighter.modelo.ConexionBD;

/**
 *
 * @author Fabián
 */
public class MedaFighter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        try { 
    
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 

        } 
        catch (Exception ex) { 
    
            ex.printStackTrace(); 

        }
        
        ControladorIngreso ci = new ControladorIngreso();
        
    }
    
}
