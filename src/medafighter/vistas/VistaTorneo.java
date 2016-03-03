/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.vistas;

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
        
        jugador6.setModel(modeloJugadores5);
        
        jugador7.setModel(modeloJugadores6);
        
        jugador8.setModel(modeloJugadores7);
        
        jugador5.setModel(modeloJugadores8);
        
        this.setVisible(true);
        
        agregarListener(al);
        
    }
    
    // Agrega listeners a los botones
    
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
        medabot1 = new javax.swing.JComboBox();
        medabot2 = new javax.swing.JComboBox();
        medabot3 = new javax.swing.JComboBox();
        medabot4 = new javax.swing.JComboBox();
        medabot5 = new javax.swing.JComboBox();
        medabot6 = new javax.swing.JComboBox();
        medabot7 = new javax.swing.JComboBox();
        medabot8 = new javax.swing.JComboBox();

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
        jLabel9.setText("Elija las posiciones para cada jugador en el torneo y las versiones de Medabot que usarán.");

        torneo.setText("Comenzar torneo");

        volver.setText("Volver");

        jLabel10.setText("Tipo de torneo");

        tipoTorneo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Torneo Normal", "Torneo Avanzado" }));

        medabot1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Version 1", "Version 2", "Version 3" }));

        medabot2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Version 1", "Version 2", "Version 3" }));

        medabot3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Version 1", "Version 2", "Version 3" }));

        medabot4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Version 1", "Version 2", "Version 3" }));

        medabot5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Version 1", "Version 2", "Version 3" }));

        medabot6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Version 1", "Version 2", "Version 3" }));

        medabot7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Version 1", "Version 2", "Version 3" }));

        medabot8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Version 1", "Version 2", "Version 3" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medabot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medabot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medabot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medabot4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(jugador6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(jugador7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addComponent(jugador8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(jugador5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medabot5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medabot7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medabot6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medabot8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(torneo)
                                .addGap(6, 6, 6)
                                .addComponent(volver))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(15, 15, 15)
                                .addComponent(tipoTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(176, 176, 176))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(medabot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(jugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medabot2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(jugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medabot3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(jugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medabot4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(jugador5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medabot5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(jugador6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medabot6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(jugador7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medabot7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(jugador8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(medabot8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
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

    // getters
    
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
    
    public javax.swing.JComboBox getMedabot1(){
        return this.medabot1;
    }
    
    public javax.swing.JComboBox getMedabot2(){
        return this.medabot2;
    }
    
    public javax.swing.JComboBox getMedabot3(){
        return this.medabot3;
    }
    
    public javax.swing.JComboBox getMedabot4(){
        return this.medabot4;
    }
    
    public javax.swing.JComboBox getMedabot5(){
        return this.medabot5;
    }
    
    public javax.swing.JComboBox getMedabot6(){
        return this.medabot6;
    }
    
    public javax.swing.JComboBox getMedabot7(){
        return this.medabot7;
    }
    
    public javax.swing.JComboBox getMedabot8(){
        return this.medabot8;
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
    private javax.swing.JComboBox medabot1;
    private javax.swing.JComboBox medabot2;
    private javax.swing.JComboBox medabot3;
    private javax.swing.JComboBox medabot4;
    private javax.swing.JComboBox medabot5;
    private javax.swing.JComboBox medabot6;
    private javax.swing.JComboBox medabot7;
    private javax.swing.JComboBox medabot8;
    private javax.swing.JComboBox tipoTorneo;
    private javax.swing.JButton torneo;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
