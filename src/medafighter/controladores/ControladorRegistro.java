/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import medafighter.modelo.ConexionBD;
import medafighter.vistas.VistaRegistro;

/**
 *
 * @author Fabián
 */
public class ControladorRegistro implements ActionListener {
    
    private VistaRegistro vr;
    
    private ControladorIngreso ci;
    
    private ConexionBD cbd;
    
    public ControladorRegistro() {
        
        this.vr = new VistaRegistro(this);        
        
    }
    
    public boolean verificarNombreUsuario(String nombreUsuario) throws SQLException{
        
        this.cbd = new ConexionBD();
        
        boolean uBoolean = this.cbd.verificarNombreUsuario(nombreUsuario);
        
        return uBoolean;
        
    }
    
    public void registrarUsuario(String nombreUsuario, String contrasenia) throws SQLException{
        
        this.cbd = new ConexionBD();
        
        this.cbd.registrarUsuario(nombreUsuario, contrasenia);
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vr != null){           
            
            if (((JButton)ae.getSource()).equals(this.vr.getRegistrarse())){
                
                String nombreUsuario = this.vr.getNombreUsuario().getText();
                   
                String contrasenia = this.vr.getContrasenia().getText();
                
                boolean uBoolean = false;
                
                   try {
                   
                       uBoolean = verificarNombreUsuario(nombreUsuario);
                    
                   } 
                   
                   catch (SQLException ex) {
                   
                       Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
                
                   }
                   
                    if (uBoolean == true){
                       
                        JOptionPane.showMessageDialog(vr, "El usuario ingresado ya existe. Ingrese uno distinto.");
                       
                    }
                    
                    else{
                        
                        try {
                            
                            registrarUsuario(nombreUsuario, contrasenia);                                    
                            
                        }
                        
                        catch (SQLException ex) {
                   
                            Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
                
                        }
                        
                    }
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vr.getVolver())){
                
                this.ci = new ControladorIngreso();
                
                this.vr.setVisible(false);
                
                this.vr.dispose();                
                
            }          
            
        } 
    
    }
    
}
