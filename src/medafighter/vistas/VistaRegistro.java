/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.vistas;

import java.awt.event.ActionListener;

/**
 *
 * @author Fabián
 */
public class VistaRegistro extends javax.swing.JFrame {

    /**
     * Creates new form VistaRegistro
     */
    public VistaRegistro(ActionListener al) {
        
        initComponents();
        
        this.setVisible(true);
        
        agregarListener(al);
        
    }
    
    void agregarListener(ActionListener al){
        
        this.registrarse.addActionListener(al);
        
        this.volver.addActionListener(al);
        
    }    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registrarse = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        nombreUsuarioLabel = new javax.swing.JLabel();
        contraseniaLabel = new javax.swing.JLabel();
        nombreUsuarioTF = new javax.swing.JTextField();
        ingreseDatosLabel = new javax.swing.JLabel();
        contraseniaTF = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MedaFighter - Registro");

        registrarse.setText("Registrarse");

        volver.setText("Volver");

        nombreUsuarioLabel.setText("Nombre de usuario");

        contraseniaLabel.setText("Contraseña");

        ingreseDatosLabel.setText("Ingrese sus datos en los siguientes campos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingreseDatosLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreUsuarioLabel)
                            .addComponent(contraseniaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreUsuarioTF, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(contraseniaTF))
                        .addGap(87, 87, 87))))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(registrarse)
                .addGap(41, 41, 41)
                .addComponent(volver)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(ingreseDatosLabel)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreUsuarioLabel)
                    .addComponent(nombreUsuarioTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseniaLabel)
                    .addComponent(contraseniaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrarse)
                    .addComponent(volver))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JButton getRegistrarse(){
        return this.registrarse;
    }
    
    public javax.swing.JButton getVolver(){
        return this.volver;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contraseniaLabel;
    private javax.swing.JPasswordField contraseniaTF;
    private javax.swing.JLabel ingreseDatosLabel;
    private javax.swing.JLabel nombreUsuarioLabel;
    private javax.swing.JTextField nombreUsuarioTF;
    private javax.swing.JButton registrarse;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
