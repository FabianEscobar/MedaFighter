/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Paquete contenedor*/

package medafighter.controladores;

/* Clases importadas */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import medafighter.modelo.ConexionBD;
import medafighter.otros.MyController;
import medafighter.vistas.VistaRegistro;

/**
 *
 * @author Fabián
 */
public class ControladorRegistro extends MyController implements ActionListener {
    
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
    
    public boolean registrarUsuario(String nombreUsuario, String contrasenia, String nombreMedabot) throws SQLException, IOException{
        
        boolean registroCorrecto = false;
        
        this.cbd = new ConexionBD();
        
        registroCorrecto = this.cbd.registrarUsuario(nombreUsuario, contrasenia, nombreMedabot);
        
        this.escribirLog(nombreUsuario+" se ha registrado correctamente en la aplicacion.");
        
        return registroCorrecto;       
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vr != null){           
            
            if (((JButton)ae.getSource()).equals(this.vr.getRegistrarse())){
                
                String nombreUsuario = this.vr.getNombreUsuario().getText();
                   
                String contrasenia = this.vr.getContrasenia().getText();
                
                String nombreMedabot = this.vr.getNombreMedabot().getText();
                
                int largoNombreUsuario = nombreUsuario.length();
                        
                int largoContrasenia = contrasenia.length();
                        
                int largoNombreMedabot = nombreMedabot.length();
                
                if((4 <= largoNombreUsuario)&&(6 <= largoContrasenia)&&(4 <= largoNombreMedabot)){
                    
                    if((largoNombreUsuario <=15)&&(largoContrasenia <=15)&&(largoNombreMedabot <=15)){
                        
                        boolean uBoolean = false;
                
                        boolean registroCorrecto = false;
                
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
                            
                                registroCorrecto = registrarUsuario(nombreUsuario, contrasenia, nombreMedabot);
                            
                                if (registroCorrecto == true){
                                
                                    JOptionPane.showMessageDialog(vr, "El registro se ha realizado de manera satisfactoria. Presione 'Volver' para ir a la ventana de ingreso.");
                                
                                }
                            
                            }
                        
                            catch (SQLException ex) {
                   
                                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
                
                            } catch (IOException ex) {
                                
                                Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
                            
                            }
                        
                        }
                        
                    }
                    
                }
                
                else {
                    
                    JOptionPane.showMessageDialog(vr, "Datos inválidos. Asegúrese de que estén dentro de los límites de caracteres.");
                    
                }
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vr.getVolver())){
                
                try {
                
                    this.ci = new ControladorIngreso();
                
                } 
                
                catch (SQLException ex) {
                    
                    Logger.getLogger(ControladorRegistro.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                
                this.vr.setVisible(false);
                
                this.vr.dispose();                
                
            }          
            
        } 
    
    }
    
}
