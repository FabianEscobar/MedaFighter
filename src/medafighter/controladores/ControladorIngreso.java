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
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import medafighter.modelo.ConexionBD;
import medafighter.otros.MyController;
import medafighter.vistas.VistaIngreso;

/**
 *
 * @author Fabián
 */
public class ControladorIngreso extends MyController implements ActionListener {
    
    private VistaIngreso vi;
    
    private ControladorRegistro cr;
    
    private ControladorMenu cm;
    
    private ConexionBD cbd;
    
    public ControladorIngreso() throws SQLException {
        
        this.cbd = new ConexionBD();
        
        this.cbd.limpiarSesionesActivas();
        
        this.vi = new VistaIngreso(this);
        
    }
    
    public boolean verificarUsuario(String nombreUsuario, String contrasenia) throws SQLException{
        
        this.cbd = new ConexionBD();
        
        boolean uBoolean = this.cbd.verificarUsuario(nombreUsuario, contrasenia);
        
        return uBoolean;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vi != null){           
            
            // Si el usuario elige ingresar a la aplicacion, se verifica el nombre de usuario y la
            // contraseña. Si es correcta, se ingresa normalmente. De lo contrario, se muestra
            // un mensaje emergente comunicando al usuario que los datos son incorrectos
            
            if (((JButton)ae.getSource()).equals(this.vi.getIngresar())) {
                
                String nombreUsuario = this.vi.getNombreUsuario().getText();
                   
                String contrasenia = this.vi.getContrasenia().getText();
                   
                boolean uBoolean = false;
                
                try {
                   
                    uBoolean = verificarUsuario(nombreUsuario, contrasenia);
                    
                } 
                   
                catch (SQLException ex) {
                   
                    Logger.getLogger(ControladorIngreso.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                   
                if (uBoolean == true){
                       
                    try {
                        
                        cbd.agregarSesionActiva(nombreUsuario, contrasenia);
                        
                        this.escribirLog(nombreUsuario+" ha ingresado a la aplicacion.");
                    
                    } 
                    
                    catch (SQLException ex) {
                        
                        Logger.getLogger(ControladorIngreso.class.getName()).log(Level.SEVERE, null, ex);
                    
                    } 
                    
                    catch (IOException ex) {
                        
                        Logger.getLogger(ControladorIngreso.class.getName()).log(Level.SEVERE, null, ex);
                    
                    }         
                    
                    // Se abre el menu
                    
                    this.cm = new ControladorMenu();
                       
                    this.vi.setVisible(false);
                
                    this.vi.dispose();
                       
                }
                    
                else{
                        
                    JOptionPane.showMessageDialog(vi, "El jugador ingresado no existe o la contraseña ingresada es incorrecta.");
                                                
                }  
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vi.getRegistrarse())){
                
                // Si el usuario quiere registrarse, entonces se abre el controlador y la vista registro
                
                this.cr = new ControladorRegistro();
                
                this.vi.setVisible(false);
                
                this.vi.dispose();                
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vi.getSalir())){
                
                // Si el usuario elige salir de la aplicacion, entonces esta se cierra 
                
                System.exit(0);
                
            }            
            
        } 
        
    }
   
}