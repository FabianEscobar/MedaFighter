/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.vistas;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import medafighter.modelo.ConexionBD;

/**
 *
 * @author Fabián
 */
public class DialogIngreso extends javax.swing.JDialog {
    
    private ConexionBD cbd;

    /**
     * Creates new form DialogIngreso
     */
    
    // Esta vista es una version reducida de VistaIngreso (no tiene la opcion de registro) y sirve para ingresar jugadores
    // en otras vistas como en la vista previa, vista medabot y vista torneo
    
    public DialogIngreso(java.awt.Frame parent, boolean modal, String jugador) {
        
        super(parent, modal);
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        nombreUsuarioTF.setText(jugador);
        
        this.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ingresar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        nombreUsuarioLabel = new javax.swing.JLabel();
        contraseniaLabel = new javax.swing.JLabel();
        nombreUsuarioTF = new javax.swing.JTextField();
        contraseniaTF = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MedaFighter - Ingreso");
        setAutoRequestFocus(false);
        setResizable(false);

        ingresar.setText("Ingresar");
        ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        nombreUsuarioLabel.setText("Nombre de usuario");

        contraseniaLabel.setText("Contraseña");

        nombreUsuarioTF.setEditable(false);

        jLabel1.setText("Ingrese su contraseña para ingresar.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contraseniaLabel)
                            .addComponent(nombreUsuarioLabel))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contraseniaTF, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(nombreUsuarioTF)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(ingresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreUsuarioLabel)
                    .addComponent(nombreUsuarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseniaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contraseniaLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingresar)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarActionPerformed
        
        boolean uBoolean = false;
        
        this.cbd = new ConexionBD();
                
        try {
                   
            uBoolean = cbd.verificarUsuario(nombreUsuarioTF.getText(), contraseniaTF.getText());
                    
        } 
                   
        catch (SQLException ex) {
                   
            Logger.getLogger(DialogIngreso.class.getName()).log(Level.SEVERE, null, ex);
                
        }
        
        if(uBoolean == true) {
            
            try {
            
                cbd.agregarSesionActiva(nombreUsuarioTF.getText(), contraseniaTF.getText());
        
            } 
        
            catch (SQLException ex) {
        
                Logger.getLogger(DialogIngreso.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            this.setVisible(false);
                
            this.dispose();
            
        }
        
        if(uBoolean == false) {
            
            JOptionPane.showMessageDialog(this, "La contraseña ingresada es incorrecta.");
            
        }
        
    }//GEN-LAST:event_ingresarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        
        this.setVisible(false);
                
        this.dispose();
        
    }//GEN-LAST:event_cancelarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel contraseniaLabel;
    private javax.swing.JPasswordField contraseniaTF;
    private javax.swing.JButton ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombreUsuarioLabel;
    private javax.swing.JTextField nombreUsuarioTF;
    // End of variables declaration//GEN-END:variables
}
