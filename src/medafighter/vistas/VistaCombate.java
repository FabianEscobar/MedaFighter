/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.vistas;

import java.awt.event.ActionListener;
import medafighter.modelo.Jugador;

/**
 *
 * @author Fabián
 */
public class VistaCombate extends javax.swing.JFrame {

    /**
     * Creates new form VistaCombate
     */
    public VistaCombate(ActionListener al, Jugador jugador1, Jugador jugador2) {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.nombreJ1.setText(jugador1.getNombre());        
        this.nombreJ2.setText(jugador2.getNombre());
        
        this.nombreM1.setText(jugador1.getMedabot().getNombre().substring(0,jugador1.getMedabot().getNombre().length()-2));
        this.nombreM2.setText(jugador2.getMedabot().getNombre().substring(0,jugador2.getMedabot().getNombre().length()-2));
        
        this.saludMedabotJ1.setText(String.valueOf(jugador1.getMedabot().getSaludActual()));
        this.saludMedabotJ2.setText(String.valueOf(jugador2.getMedabot().getSaludActual()));
        
        this.saludCabezaM1.setText(String.valueOf(jugador1.getMedabot().getCabeza().getSaludActual()));
        this.saludCabezaM2.setText(String.valueOf(jugador2.getMedabot().getCabeza().getSaludActual()));
        
        this.saludBrazoIzqM1.setText(String.valueOf(jugador1.getMedabot().getBrazoIzq().getSaludActual()));
        this.saludBrazoIzqM2.setText(String.valueOf(jugador2.getMedabot().getBrazoIzq().getSaludActual()));
        
        this.saludBrazoDerM1.setText(String.valueOf(jugador1.getMedabot().getBrazoDer().getSaludActual()));
        this.saludBrazoDerM2.setText(String.valueOf(jugador2.getMedabot().getBrazoDer().getSaludActual()));
        
        this.saludPiernaIzqM1.setText(String.valueOf(jugador1.getMedabot().getPiernaIzq().getSaludActual()));
        this.saludPiernaIzqM2.setText(String.valueOf(jugador2.getMedabot().getPiernaIzq().getSaludActual()));
        
        this.saludPiernaDerM1.setText(String.valueOf(jugador1.getMedabot().getPiernaDer().getSaludActual()));
        this.saludPiernaDerM2.setText(String.valueOf(jugador2.getMedabot().getPiernaDer().getSaludActual()));
        
        
        this.phCabezaM1.setText(String.valueOf(jugador1.getMedabot().getCabeza().getPH()));
        this.phCabezaM2.setText(String.valueOf(jugador2.getMedabot().getCabeza().getPH()));
        
        this.phBrazoIzqM1.setText(String.valueOf(jugador1.getMedabot().getBrazoIzq().getPH()));
        this.phBrazoIzqM2.setText(String.valueOf(jugador2.getMedabot().getBrazoIzq().getPH()));
        
        this.phBrazoDerM1.setText(String.valueOf(jugador1.getMedabot().getBrazoDer().getPH()));
        this.phBrazoDerM2.setText(String.valueOf(jugador2.getMedabot().getBrazoDer().getPH()));
        
        this.phPiernaIzqM1.setText(String.valueOf(jugador1.getMedabot().getPiernaIzq().getPH()));
        this.phPiernaIzqM2.setText(String.valueOf(jugador2.getMedabot().getPiernaIzq().getPH()));
        
        this.phPiernaDerM1.setText(String.valueOf(jugador1.getMedabot().getPiernaDer().getPH()));
        this.phPiernaDerM2.setText(String.valueOf(jugador2.getMedabot().getPiernaDer().getPH()));
        
        
        this.barraSaludM1.setMaximum(jugador1.getMedabot().getSaludMaxima());
        this.barraSaludM2.setMaximum(jugador2.getMedabot().getSaludMaxima());
        
        this.barraSaludCabezaM1.setMaximum(jugador1.getMedabot().getCabeza().getSaludMaxima());
        this.barraSaludCabezaM2.setMaximum(jugador2.getMedabot().getCabeza().getSaludMaxima());
        
        this.barraSaludBrazoIzqM1.setMaximum(jugador1.getMedabot().getBrazoIzq().getSaludMaxima());
        this.barraSaludBrazoIzqM2.setMaximum(jugador2.getMedabot().getBrazoIzq().getSaludMaxima());
        
        this.barraSaludBrazoDerM1.setMaximum(jugador1.getMedabot().getBrazoDer().getSaludMaxima());
        this.barraSaludBrazoDerM2.setMaximum(jugador2.getMedabot().getBrazoDer().getSaludMaxima());
        
        this.barraSaludPiernaIzqM1.setMaximum(jugador1.getMedabot().getPiernaIzq().getSaludMaxima());
        this.barraSaludPiernaIzqM2.setMaximum(jugador2.getMedabot().getPiernaIzq().getSaludMaxima());
        
        this.barraSaludPiernaDerM1.setMaximum(jugador1.getMedabot().getPiernaDer().getSaludMaxima());
        this.barraSaludPiernaDerM2.setMaximum(jugador2.getMedabot().getPiernaDer().getSaludMaxima());
        
        this.barraSaludM1.setValue(WIDTH);
        
        String logInicial = ""+jugador1.getNombre()+"'s "+jugador1.getMedabot().getNombre()+" V/S "+jugador2.getMedabot().getNombre()+"'s "+jugador1.getNombre()+"\n\n"
                            + "¡Que comience la robobatalla!\n\n";
        
        logBatalla.setText(logInicial);
        
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
        
        this.terminarTurno.addActionListener(al);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLog = new javax.swing.JScrollPane();
        logBatalla = new javax.swing.JTextArea();
        nombreJ1 = new javax.swing.JLabel();
        nombreJ2 = new javax.swing.JLabel();
        nombreM1 = new javax.swing.JLabel();
        barraSaludM1 = new javax.swing.JProgressBar();
        barraSaludM2 = new javax.swing.JProgressBar();
        nombreM2 = new javax.swing.JLabel();
        barraMedafuerzaM1 = new javax.swing.JProgressBar();
        barraMedafuerzaM2 = new javax.swing.JProgressBar();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        barraSaludCabezaM1 = new javax.swing.JProgressBar();
        barraSaludBrazoIzqM1 = new javax.swing.JProgressBar();
        barraSaludBrazoDerM1 = new javax.swing.JProgressBar();
        barraSaludPiernaIzqM1 = new javax.swing.JProgressBar();
        barraSaludPiernaDerM1 = new javax.swing.JProgressBar();
        barraSaludCabezaM2 = new javax.swing.JProgressBar();
        barraSaludBrazoIzqM2 = new javax.swing.JProgressBar();
        barraSaludBrazoDerM2 = new javax.swing.JProgressBar();
        barraSaludPiernaIzqM2 = new javax.swing.JProgressBar();
        barraSaludPiernaDerM2 = new javax.swing.JProgressBar();
        saludCabezaM1 = new javax.swing.JLabel();
        saludBrazoIzqM1 = new javax.swing.JLabel();
        saludBrazoDerM1 = new javax.swing.JLabel();
        saludPiernaIzqM1 = new javax.swing.JLabel();
        saludPiernaDerM1 = new javax.swing.JLabel();
        saludCabezaM2 = new javax.swing.JLabel();
        saludBrazoIzqM2 = new javax.swing.JLabel();
        saludBrazoDerM2 = new javax.swing.JLabel();
        saludPiernaIzqM2 = new javax.swing.JLabel();
        saludPiernaDerM2 = new javax.swing.JLabel();
        atacanteJ1 = new javax.swing.JComboBox();
        defensorJ2 = new javax.swing.JComboBox();
        atacanteJ2 = new javax.swing.JComboBox();
        defensorJ1 = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        phCabezaM1 = new javax.swing.JLabel();
        phBrazoIzqM1 = new javax.swing.JLabel();
        phBrazoDerM1 = new javax.swing.JLabel();
        phPiernaIzqM1 = new javax.swing.JLabel();
        phPiernaDerM1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        phCabezaM2 = new javax.swing.JLabel();
        phBrazoIzqM2 = new javax.swing.JLabel();
        phBrazoDerM2 = new javax.swing.JLabel();
        phPiernaIzqM2 = new javax.swing.JLabel();
        phPiernaDerM2 = new javax.swing.JLabel();
        terminarTurno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MedaFighter - Medabatalla");
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        logBatalla.setEditable(false);
        logBatalla.setBackground(new java.awt.Color(204, 204, 204));
        logBatalla.setColumns(20);
        logBatalla.setRows(5);
        panelLog.setViewportView(logBatalla);

        nombreJ1.setText("Jugador1");

        nombreJ2.setText("Jugador2");

        nombreM1.setText("Medabot");

        nombreM2.setText("Medabot");

        saludMedabotJ1.setText("1000");

        saludMedabotJ2.setText("1000");

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

        jLabel1.setText("Cabeza");

        jLabel2.setText("Brazo Izquierdo");

        jLabel5.setText("Brazo Derecho");

        jLabel6.setText("Pierna Izquierda");

        jLabel7.setText("Pierna Derecha");

        jLabel8.setText("Cabeza");

        jLabel9.setText("Brazo Izquierdo");

        jLabel10.setText("Brazo Derecho");

        jLabel11.setText("Pierna Izquierda");

        jLabel12.setText("Pierna Derecha");

        saludCabezaM1.setText("1000");

        saludBrazoIzqM1.setText("1000");

        saludBrazoDerM1.setText("1000");

        saludPiernaIzqM1.setText("1000");

        saludPiernaDerM1.setText("1000");

        saludCabezaM2.setText("1000");

        saludBrazoIzqM2.setText("1000");

        saludBrazoDerM2.setText("1000");

        saludPiernaIzqM2.setText("1000");

        saludPiernaDerM2.setText("1000");

        atacanteJ1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));
        atacanteJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atacanteJ1ActionPerformed(evt);
            }
        });

        defensorJ2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));

        atacanteJ2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));

        defensorJ1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));

        jLabel23.setText("Atacante/Defensor");

        jLabel24.setText("Atacante/Defensor");

        jLabel25.setText("PH");

        phCabezaM1.setText("0");

        phBrazoIzqM1.setText("0");

        phBrazoDerM1.setText("0");

        phPiernaIzqM1.setText("0");

        phPiernaDerM1.setText("0");

        jLabel32.setText("PH");

        phCabezaM2.setText("0");

        phBrazoIzqM2.setText("0");

        phBrazoDerM2.setText("0");

        phPiernaIzqM2.setText("0");

        phPiernaDerM2.setText("0");

        terminarTurno.setText("Terminar turno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(defenderJ1)
                        .addGap(18, 18, 18)
                        .addComponent(esquivarJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(rendirseJ1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(panelLog, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rendirseJ2)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(defenderJ2)
                        .addGap(18, 18, 18)
                        .addComponent(esquivarJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreM1)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(nombreJ1))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barraSaludM1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraSaludCabezaM1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraSaludBrazoIzqM1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraSaludBrazoDerM1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraSaludPiernaIzqM1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraSaludPiernaDerM1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saludMedabotJ1)
                            .addComponent(saludCabezaM1)
                            .addComponent(saludBrazoIzqM1)
                            .addComponent(saludBrazoDerM1)
                            .addComponent(saludPiernaIzqM1)
                            .addComponent(saludPiernaDerM1))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phPiernaDerM1)
                            .addComponent(phPiernaIzqM1)
                            .addComponent(phBrazoDerM1)
                            .addComponent(phBrazoIzqM1)
                            .addComponent(phCabezaM1)
                            .addComponent(jLabel25)))
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(atacarJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(atacanteJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(defensorJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreM2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(nombreJ2))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barraSaludM2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraSaludCabezaM2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraSaludBrazoIzqM2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraSaludBrazoDerM2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraSaludPiernaIzqM2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraSaludPiernaDerM2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saludMedabotJ2)
                            .addComponent(saludPiernaDerM2)
                            .addComponent(saludPiernaIzqM2)
                            .addComponent(saludBrazoDerM2)
                            .addComponent(saludBrazoIzqM2)
                            .addComponent(saludCabezaM2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phCabezaM2)
                            .addComponent(jLabel32)
                            .addComponent(phBrazoIzqM2)
                            .addComponent(phBrazoDerM2)
                            .addComponent(phPiernaIzqM2)
                            .addComponent(phPiernaDerM2))))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(medafuerzaJ1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barraMedafuerzaM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(terminarTurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(medafuerzaJ2)
                        .addGap(45, 45, 45)
                        .addComponent(barraMedafuerzaM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(atacarJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(atacanteJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(defensorJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreJ1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(nombreM1)
                                    .addComponent(barraSaludM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel1)
                                    .addComponent(barraSaludCabezaM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel2)
                                    .addComponent(barraSaludBrazoIzqM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel5)
                                    .addComponent(barraSaludBrazoDerM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel6)
                                    .addComponent(barraSaludPiernaIzqM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel7)
                                    .addComponent(barraSaludPiernaDerM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludMedabotJ1)
                                    .addComponent(jLabel25))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludCabezaM1)
                                    .addComponent(phCabezaM1))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludBrazoIzqM1)
                                    .addComponent(phBrazoIzqM1))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludBrazoDerM1)
                                    .addComponent(phBrazoDerM1))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludPiernaIzqM1)
                                    .addComponent(phPiernaIzqM1))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludPiernaDerM1)
                                    .addComponent(phPiernaDerM1))
                                .addGap(41, 41, 41))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreJ2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(nombreM2)
                                    .addComponent(barraSaludM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel8)
                                    .addComponent(barraSaludCabezaM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel9)
                                    .addComponent(barraSaludBrazoIzqM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel10)
                                    .addComponent(barraSaludBrazoDerM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel11)
                                    .addComponent(barraSaludPiernaIzqM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel12)
                                    .addComponent(barraSaludPiernaDerM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludMedabotJ2)
                                    .addComponent(jLabel32))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludCabezaM2)
                                    .addComponent(phCabezaM2))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludBrazoIzqM2)
                                    .addComponent(phBrazoIzqM2))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludBrazoDerM2)
                                    .addComponent(phBrazoDerM2))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludPiernaIzqM2)
                                    .addComponent(phPiernaIzqM2))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(saludPiernaDerM2)
                                    .addComponent(phPiernaDerM2))))
                        .addGap(41, 41, 41)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(atacanteJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defensorJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atacanteJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defensorJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atacarJ1)
                    .addComponent(atacarJ2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(medafuerzaJ1)
                    .addComponent(barraMedafuerzaM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medafuerzaJ2)
                    .addComponent(barraMedafuerzaM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminarTurno))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(defenderJ1)
                            .addComponent(esquivarJ1))
                        .addGap(34, 34, 34)
                        .addComponent(rendirseJ1)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(defenderJ2)
                                    .addComponent(esquivarJ2))
                                .addGap(33, 33, 33)
                                .addComponent(rendirseJ2)
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(panelLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atacanteJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atacanteJ1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atacanteJ1ActionPerformed

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
    
    public javax.swing.JButton getTerminarTurno(){
        return this.terminarTurno;
    }
    
    public javax.swing.JComboBox getAtacanteJ1(){
        return this.atacanteJ1;
    }
    
    public javax.swing.JComboBox getatacanteJ2(){
        return this.atacanteJ2;
    }
    
    public javax.swing.JComboBox getDefensorJ1(){
        return this.defensorJ1;
    }
    
    public javax.swing.JComboBox getDefensorJ2(){
        return this.defensorJ2;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox atacanteJ1;
    private javax.swing.JComboBox atacanteJ2;
    private javax.swing.JButton atacarJ1;
    private javax.swing.JButton atacarJ2;
    private javax.swing.JProgressBar barraMedafuerzaM1;
    private javax.swing.JProgressBar barraMedafuerzaM2;
    private javax.swing.JProgressBar barraSaludBrazoDerM1;
    private javax.swing.JProgressBar barraSaludBrazoDerM2;
    private javax.swing.JProgressBar barraSaludBrazoIzqM1;
    private javax.swing.JProgressBar barraSaludBrazoIzqM2;
    private javax.swing.JProgressBar barraSaludCabezaM1;
    private javax.swing.JProgressBar barraSaludCabezaM2;
    private javax.swing.JProgressBar barraSaludM1;
    private javax.swing.JProgressBar barraSaludM2;
    private javax.swing.JProgressBar barraSaludPiernaDerM1;
    private javax.swing.JProgressBar barraSaludPiernaDerM2;
    private javax.swing.JProgressBar barraSaludPiernaIzqM1;
    private javax.swing.JProgressBar barraSaludPiernaIzqM2;
    private javax.swing.JButton defenderJ1;
    private javax.swing.JButton defenderJ2;
    private javax.swing.JComboBox defensorJ1;
    private javax.swing.JComboBox defensorJ2;
    private javax.swing.JButton esquivarJ1;
    private javax.swing.JButton esquivarJ2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea logBatalla;
    private javax.swing.JButton medafuerzaJ1;
    private javax.swing.JButton medafuerzaJ2;
    private javax.swing.JLabel nombreJ1;
    private javax.swing.JLabel nombreJ2;
    private javax.swing.JLabel nombreM1;
    private javax.swing.JLabel nombreM2;
    private javax.swing.JScrollPane panelLog;
    private javax.swing.JLabel phBrazoDerM1;
    private javax.swing.JLabel phBrazoDerM2;
    private javax.swing.JLabel phBrazoIzqM1;
    private javax.swing.JLabel phBrazoIzqM2;
    private javax.swing.JLabel phCabezaM1;
    private javax.swing.JLabel phCabezaM2;
    private javax.swing.JLabel phPiernaDerM1;
    private javax.swing.JLabel phPiernaDerM2;
    private javax.swing.JLabel phPiernaIzqM1;
    private javax.swing.JLabel phPiernaIzqM2;
    private javax.swing.JButton rendirseJ1;
    private javax.swing.JButton rendirseJ2;
    private javax.swing.JLabel saludBrazoDerM1;
    private javax.swing.JLabel saludBrazoDerM2;
    private javax.swing.JLabel saludBrazoIzqM1;
    private javax.swing.JLabel saludBrazoIzqM2;
    private javax.swing.JLabel saludCabezaM1;
    private javax.swing.JLabel saludCabezaM2;
    private javax.swing.JLabel saludMedabotJ1;
    private javax.swing.JLabel saludMedabotJ2;
    private javax.swing.JLabel saludPiernaDerM1;
    private javax.swing.JLabel saludPiernaDerM2;
    private javax.swing.JLabel saludPiernaIzqM1;
    private javax.swing.JLabel saludPiernaIzqM2;
    private javax.swing.JButton terminarTurno;
    // End of variables declaration//GEN-END:variables
}
