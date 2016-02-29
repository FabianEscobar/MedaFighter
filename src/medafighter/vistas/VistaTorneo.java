/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.vistas;

/* Clases importadas */

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import medafighter.modelo.ConexionBD;

/**
 *
 * @author Fabián
 */
public class VistaTorneo extends javax.swing.JFrame {
    
    private ConexionBD cbd;

    /**
     * Creates new form VistaTorneo
     */
    public VistaTorneo(ActionListener al) throws SQLException {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        ArrayList<String> jugadores = new ArrayList<>();
        
        this.cbd = new ConexionBD();
        
        jugadores = cbd.buscarJugadores();
        
        String[] arrayJugadores;
        
        arrayJugadores = jugadores.toArray(new String[100]);
        
        DefaultComboBoxModel modeloJugadores1 = new DefaultComboBoxModel(arrayJugadores);
        DefaultComboBoxModel modeloJugadores2 = new DefaultComboBoxModel(arrayJugadores);
        DefaultComboBoxModel modeloJugadores3 = new DefaultComboBoxModel(arrayJugadores);
        DefaultComboBoxModel modeloJugadores4 = new DefaultComboBoxModel(arrayJugadores);
        DefaultComboBoxModel modeloJugadores5 = new DefaultComboBoxModel(arrayJugadores);
        DefaultComboBoxModel modeloJugadores6 = new DefaultComboBoxModel(arrayJugadores);
        DefaultComboBoxModel modeloJugadores7 = new DefaultComboBoxModel(arrayJugadores);
        DefaultComboBoxModel modeloJugadores8 = new DefaultComboBoxModel(arrayJugadores);
        
        jugador1.setModel(modeloJugadores1);
        
        jugador2.setModel(modeloJugadores2);
        
        jugador3.setModel(modeloJugadores3);
        
        jugador4.setModel(modeloJugadores4);
        
        jugador5.setModel(modeloJugadores5);
        
        jugador6.setModel(modeloJugadores6);
        
        jugador7.setModel(modeloJugadores7);
        
        jugador8.setModel(modeloJugadores8);
        
        this.setVisible(true);
        
        agregarListener(al);
        
    }
    
    void agregarListener(ActionListener al){
        
        this.torneo.addActionListener(al);
        
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

        jugador1 = new javax.swing.JComboBox();
        jugador2 = new javax.swing.JComboBox();
        jugador3 = new javax.swing.JComboBox();
        jugador4 = new javax.swing.JComboBox();
        jugador5 = new javax.swing.JComboBox();
        jugador6 = new javax.swing.JComboBox();
        jugador7 = new javax.swing.JComboBox();
        jugador8 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        torneo = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tipoTorneo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MedaFighter - Torneo");
        setResizable(false);

        jLabel1.setText("1.-");

        jLabel2.setText("2.-");

        jLabel3.setText("3.-");

        jLabel4.setText("4.-");

        jLabel5.setText("5.-");

        jLabel6.setText("6.-");

        jLabel7.setText("7.-");

        jLabel8.setText("8.-");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Elija las posiciones para cada jugador en el torneo");

        torneo.setText("Comenzar torneo");

        volver.setText("Volver");

        jLabel10.setText("Tipo de torneo");

        tipoTorneo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Torneo Normal", "Torneo Avanzado" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(jugador5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(jugador6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(jugador7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(torneo)
                        .addGap(6, 6, 6)
                        .addComponent(volver))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(jugador8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(15, 15, 15)
                        .addComponent(tipoTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugador7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tipoTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(torneo)
                    .addComponent(volver))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JButton getTorneo(){
        return this.torneo;
    }
    
    public javax.swing.JButton getVolver(){
        return this.volver;
    }
    
    public javax.swing.JComboBox getJugador1(){
        return this.jugador1;
    }
    
    public javax.swing.JComboBox getJugador2(){
        return this.jugador2;
    }
    
    public javax.swing.JComboBox getJugador3(){
        return this.jugador3;
    }
    
    public javax.swing.JComboBox getJugador4(){
        return this.jugador4;
    }
    
    public javax.swing.JComboBox getJugador5(){
        return this.jugador5;
    }
    
    public javax.swing.JComboBox getJugador6(){
        return this.jugador6;
    }
    
    public javax.swing.JComboBox getJugador7(){
        return this.jugador7;
    }
    
    public javax.swing.JComboBox getJugador8(){
        return this.jugador8;
    }
    
    public javax.swing.JComboBox getTipoTorneo(){
        return this.tipoTorneo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox jugador1;
    private javax.swing.JComboBox jugador2;
    private javax.swing.JComboBox jugador3;
    private javax.swing.JComboBox jugador4;
    private javax.swing.JComboBox jugador5;
    private javax.swing.JComboBox jugador6;
    private javax.swing.JComboBox jugador7;
    private javax.swing.JComboBox jugador8;
    private javax.swing.JComboBox tipoTorneo;
    private javax.swing.JButton torneo;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
