/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.vistas;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import medafighter.modelo.ConexionBD;

/**
 *
 * @author Fabián
 */
public class VistaPrevia extends javax.swing.JFrame {
    
    private ConexionBD cbd;

    /**
     * Creates new form VistaPrevia
     */
    public VistaPrevia(ActionListener al) {
                
        initComponents();
        
        this.setVisible(true);
        
        agregarListener(al);       
        
    }
    
    void agregarListener(ActionListener al){
        
        this.robobatalla.addActionListener(al);
        
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

        queRobobatallaLabel = new javax.swing.JLabel();
        modoJuegoLabel = new javax.swing.JLabel();
        modoJuegoCB = new javax.swing.JComboBox();
        jugadoresLabel = new javax.swing.JLabel();
        jugador1SP = new javax.swing.JScrollPane();
        jugador1L = new javax.swing.JList();
        jugador2SP = new javax.swing.JScrollPane();
        jugador2L = new javax.swing.JList();
        robobatalla = new javax.swing.JButton();
        volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MedaFighter - Previa Medabatalla");

        queRobobatallaLabel.setText("¿Qué clase de robobatalla desea?");

        modoJuegoLabel.setText("Modo de juego");

        modoJuegoCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jugador v/s Jugador", "Jugador v/s CPU", "CPU V/S CPU" }));
        modoJuegoCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                modoJuegoCBItemStateChanged(evt);
            }
        });

        jugadoresLabel.setText("Jugadores");

        jugador1L.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jugador1SP.setViewportView(jugador1L);

        jugador2L.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jugador2SP.setViewportView(jugador2L);

        robobatalla.setText("Robobatalla!");

        volver.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modoJuegoLabel)
                    .addComponent(jugadoresLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jugador1SP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jugador2SP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modoJuegoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(queRobobatallaLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(robobatalla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(volver)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(queRobobatallaLabel)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modoJuegoLabel)
                    .addComponent(modoJuegoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jugador1SP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador2SP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(robobatalla)
                    .addComponent(volver))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jugadoresLabel)
                .addGap(195, 195, 195))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modoJuegoCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_modoJuegoCBItemStateChanged
        
        String modoJuego = (String)modoJuegoCB.getSelectedItem();
        
        this.cbd = new ConexionBD();
        
        if(modoJuego.equals("Jugador v/s Jugador")){
            
            ArrayList<String> jugadoresHumanos = new ArrayList<>();
            
            try {
            
                jugadoresHumanos = cbd.buscarJugadoresTipo("HUMANO");
            
            } 
            
            catch (SQLException ex) {
            
                Logger.getLogger(VistaPrevia.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            
            String[] arrayJugadoresHumanos;
            
            arrayJugadoresHumanos = jugadoresHumanos.toArray(new String[100]);
            
            jugador1L.setListData(arrayJugadoresHumanos);
            
            jugador2L.setListData(arrayJugadoresHumanos);
            
        }
        
        if(modoJuego.equals("Jugador v/s CPU")){
            
            ArrayList<String> jugadoresHumanos = new ArrayList<>();
            ArrayList<String> jugadoresCPU = new ArrayList<>();
            
            try {
            
                jugadoresHumanos = cbd.buscarJugadoresTipo("HUMANO");
                jugadoresCPU = cbd.buscarJugadoresTipo("CPU");
            
            } 
            
            catch (SQLException ex) {
            
                Logger.getLogger(VistaPrevia.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            
            String[] arrayJugadoresHumanos;
            
            String[] arrayJugadoresCPU;
            
            arrayJugadoresHumanos = jugadoresHumanos.toArray(new String[100]);
            
            arrayJugadoresCPU = jugadoresCPU.toArray(new String[100]);
            
            jugador1L.setListData(arrayJugadoresHumanos);
            
            jugador2L.setListData(arrayJugadoresCPU);
            
        }
        
        if(modoJuego.equals("CPU V/S CPU")){
            
            ArrayList<String> jugadoresCPU = new ArrayList<>();
            
            try {
            
                jugadoresCPU = cbd.buscarJugadoresTipo("CPU");
            
            } 
            catch (SQLException ex) {
            
                Logger.getLogger(VistaPrevia.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            
            String[] arrayJugadoresCPU;
            
            arrayJugadoresCPU = jugadoresCPU.toArray(new String[100]);
            
            jugador1L.setListData(arrayJugadoresCPU);
            
            jugador2L.setListData(arrayJugadoresCPU);
            
        }
        
        
    }//GEN-LAST:event_modoJuegoCBItemStateChanged

    public javax.swing.JList getJugador1L(){
        return this.jugador1L;
    }
    
    public javax.swing.JList getJugador2L(){
        return this.jugador2L;
    }
    
    public javax.swing.JComboBox getModoJuegoCB(){
        return this.modoJuegoCB;
    }
    
    public javax.swing.JButton getRobobatalla(){
        return this.robobatalla;
    }
    
    public javax.swing.JButton getVolver(){
        return this.volver;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jugador1L;
    private javax.swing.JScrollPane jugador1SP;
    private javax.swing.JList jugador2L;
    private javax.swing.JScrollPane jugador2SP;
    private javax.swing.JLabel jugadoresLabel;
    private javax.swing.JComboBox modoJuegoCB;
    private javax.swing.JLabel modoJuegoLabel;
    private javax.swing.JLabel queRobobatallaLabel;
    private javax.swing.JButton robobatalla;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
