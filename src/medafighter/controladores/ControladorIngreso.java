/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import medafighter.modelo.ConexionBD;
import medafighter.vistas.VistaIngreso;

/**
 *
 * @author Fabián
 */
public class ControladorIngreso implements ActionListener {
    
    private VistaIngreso vi;
    
    private ControladorRegistro cr;
    
    private ControladorMenu cm;
    
    private ConexionBD cbd;
    
    public ControladorIngreso() {
        
        this.vi = new VistaIngreso(this);        
        
    }
    
    public boolean verificarUsuario(String nombreUsuario, String contrasenia){
        
        this.cbd = new ConexionBD();
        
        boolean uBoolean = this.cbd.verificarUsuario(nombreUsuario, contrasenia);
        
        return uBoolean;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(vi != null){           
            
            if (((JButton)ae.getSource()).equals(this.vi.getIngresar())){
                
                   String nombreUsuario = this.vi.getNombreUsuario().getText();
                   
                   String contrasenia = this.vi.getContrasenia().getText();
                   
                   boolean uBoolean = verificarUsuario(nombreUsuario, contrasenia);
                   
                    if (uBoolean == true){
                       
                        this.cm = new ControladorMenu();
                       
                        this.vi.setVisible(false);
                
                        this.vi.dispose();
                       
                    }
                    
                    else{
                        
                        JOptionPane.showMessageDialog(vi, "El jugador ingresado no existe o la contraseña ingresada es incorrecta.");
                                                
                    }
                    
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vi.getRegistrarse())){
                
                this.cr = new ControladorRegistro();
                
                this.vi.setVisible(false);
                
                this.vi.dispose();                
                
            }
            
            if (((JButton)ae.getSource()).equals(this.vi.getSalir())){
                
                System.exit(0);
                
            }            
            
        } 
        
    }
    
    
}