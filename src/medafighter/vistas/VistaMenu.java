/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.vistas;

/**
 *
 * @author Fabián
 */
public class VistaMenu extends javax.swing.JFrame {

    /**
     * Creates new form VistaMenu
     */
    public VistaMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        queHacerLabel = new javax.swing.JLabel();
        robobatalla = new javax.swing.JButton();
        ajustesMedabot = new javax.swing.JButton();
        cerrarSesion = new javax.swing.JButton();
        torneo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        queHacerLabel.setText("¿Qué desea hacer?");

        robobatalla.setText("Robobatalla");

        ajustesMedabot.setText("Ajustes Medabot");

        cerrarSesion.setText("Cerrar sesión");

        torneo.setText("Torneo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cerrarSesion)
                    .addComponent(torneo)
                    .addComponent(ajustesMedabot)
                    .addComponent(robobatalla)
                    .addComponent(queHacerLabel))
                .addGap(139, 139, 139))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(queHacerLabel)
                .addGap(37, 37, 37)
                .addComponent(robobatalla)
                .addGap(27, 27, 27)
                .addComponent(ajustesMedabot)
                .addGap(27, 27, 27)
                .addComponent(torneo)
                .addGap(26, 26, 26)
                .addComponent(cerrarSesion)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajustesMedabot;
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JLabel queHacerLabel;
    private javax.swing.JButton robobatalla;
    private javax.swing.JButton torneo;
    // End of variables declaration//GEN-END:variables
}
