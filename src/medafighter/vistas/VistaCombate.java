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
public class VistaCombate extends javax.swing.JFrame {

    /**
     * Creates new form VistaCombate
     */
    public VistaCombate(ActionListener al) {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.setVisible(true);
        
        agregarListener(al);
        
    }
    
    void agregarListener(ActionListener al){
        
        this.atacarJ1.addActionListener(al);
        
        this.atacarJ2.addActionListener(al);
        
        this.defenderJ1.addActionListener(al);
        
        this.defenderJ2.addActionListener(al);
        
        this.esquivarJ1.addActionListener(al);
        
        this.esquivarJ2.addActionListener(al);
        
        this.rendirseJ1.addActionListener(al);
        
        this.rendirseJ2.addActionListener(al);
        
        this.medafuerzaJ1.addActionListener(al);
        
        this.medafuerzaJ2.addActionListener(al);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        logBatalla = new javax.swing.JTextArea();
        nombreMedabotJ1 = new javax.swing.JLabel();
        nombreMedabotJ2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        saludMedabotJ1 = new javax.swing.JLabel();
        saludMedabotJ2 = new javax.swing.JLabel();
        atacarJ1 = new javax.swing.JButton();
        esquivarJ1 = new javax.swing.JButton();
        defenderJ1 = new javax.swing.JButton();
        rendirseJ1 = new javax.swing.JButton();
        esquivarJ2 = new javax.swing.JButton();
        defenderJ2 = new javax.swing.JButton();
        rendirseJ2 = new javax.swing.JButton();
        atacarJ2 = new javax.swing.JButton();
        medafuerzaJ1 = new javax.swing.JButton();
        medafuerzaJ2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MedaFighter - Medabatalla");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        logBatalla.setEditable(false);
        logBatalla.setBackground(new java.awt.Color(204, 204, 204));
        logBatalla.setColumns(20);
        logBatalla.setRows(5);
        jScrollPane1.setViewportView(logBatalla);

        nombreMedabotJ1.setText("jLabel1");

        nombreMedabotJ2.setText("jLabel2");

        jLabel3.setText("Puntos de salud");

        jLabel4.setText("Puntos de salud");

        saludMedabotJ1.setText("jLabel7");

        saludMedabotJ2.setText("jLabel8");

        atacarJ1.setText("Atacar");

        esquivarJ1.setText("Esquivar");

        defenderJ1.setText("Defender");

        rendirseJ1.setText("Rendirse");

        esquivarJ2.setText("Esquivar");

        defenderJ2.setText("Defender");

        rendirseJ2.setText("Rendirse");

        atacarJ2.setText("Atacar");

        medafuerzaJ1.setText("Medafuerza");

        medafuerzaJ2.setText("Medafuerza");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(esquivarJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(atacarJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rendirseJ1)
                    .addComponent(defenderJ1))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(esquivarJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(atacarJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rendirseJ2)
                    .addComponent(defenderJ2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(saludMedabotJ1))
                    .addComponent(nombreMedabotJ1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(38, 38, 38)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(saludMedabotJ2))
                    .addComponent(nombreMedabotJ2))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(medafuerzaJ1)
                .addGap(40, 40, 40)
                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(medafuerzaJ2)
                .addGap(45, 45, 45)
                .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreMedabotJ1)
                            .addComponent(nombreMedabotJ2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))))
                    .addComponent(saludMedabotJ1)
                    .addComponent(saludMedabotJ2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(medafuerzaJ1)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medafuerzaJ2)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(atacarJ1)
                            .addComponent(defenderJ1))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(esquivarJ1)
                            .addComponent(rendirseJ1))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(atacarJ2)
                                    .addComponent(defenderJ2))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(esquivarJ2)
                                    .addComponent(rendirseJ2))
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JButton getAtacarJ1(){
        return this.atacarJ1;
    }
    
    public javax.swing.JButton getAtacarJ2(){
        return this.atacarJ2;
    }
    
    public javax.swing.JButton getDefenderJ1(){
        return this.defenderJ1;
    }
    
    public javax.swing.JButton getDefenderJ2(){
        return this.defenderJ2;
    }
    
    public javax.swing.JButton getEsquivarJ1(){
        return this.esquivarJ1;
    }
    
    public javax.swing.JButton getEsquivarJ2(){
        return this.esquivarJ2;
    }
    
    public javax.swing.JButton getRendirseJ1(){
        return this.rendirseJ1;
    }
    
    public javax.swing.JButton getRendirseJ2(){
        return this.rendirseJ2;
    }
    
    public javax.swing.JButton getMedafuerzaJ1(){
        return this.medafuerzaJ1;
    }
    
    public javax.swing.JButton getMedafuerzaJ2(){
        return this.medafuerzaJ2;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atacarJ1;
    private javax.swing.JButton atacarJ2;
    private javax.swing.JButton defenderJ1;
    private javax.swing.JButton defenderJ2;
    private javax.swing.JButton esquivarJ1;
    private javax.swing.JButton esquivarJ2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logBatalla;
    private javax.swing.JButton medafuerzaJ1;
    private javax.swing.JButton medafuerzaJ2;
    private javax.swing.JLabel nombreMedabotJ1;
    private javax.swing.JLabel nombreMedabotJ2;
    private javax.swing.JButton rendirseJ1;
    private javax.swing.JButton rendirseJ2;
    private javax.swing.JLabel saludMedabotJ1;
    private javax.swing.JLabel saludMedabotJ2;
    // End of variables declaration//GEN-END:variables
}
