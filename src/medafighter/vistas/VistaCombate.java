/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.vistas;

import java.awt.event.ActionListener;
import medafighter.modelo.*;

/**
 *
 * @author Fabián
 */
public class VistaCombate extends javax.swing.JFrame {

    /**
     * Creates new form VistaCombate
     */
    public VistaCombate(ActionListener al, Robobatalla robobatalla) {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.nombreJ1.setText(robobatalla.getJugador1().getNombre());        
        this.nombreJ2.setText(robobatalla.getJugador2().getNombre());
        
        this.nombreM1.setText(robobatalla.getJugador1().getMedabot().getNombre().substring(0,robobatalla.getJugador1().getMedabot().getNombre().length()-2));
        this.nombreM2.setText(robobatalla.getJugador2().getMedabot().getNombre().substring(0,robobatalla.getJugador2().getMedabot().getNombre().length()-2));
        
        this.saludMedabotJ1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getSaludActual()));
        this.saludMedabotJ2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getSaludActual()));
        
        this.saludCabezaM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual()));
        this.saludCabezaM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual()));
        
        this.saludBrazoIzqM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual()));
        this.saludBrazoIzqM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual()));
        
        this.saludBrazoDerM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual()));
        this.saludBrazoDerM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual()));
        
        this.saludPiernaIzqM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual()));
        this.saludPiernaIzqM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual()));
        
        this.saludPiernaDerM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual()));
        this.saludPiernaDerM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual()));
        
        
        this.phCabezaM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getCabeza().getPHMax()));
        this.phCabezaM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getCabeza().getPHMax()));
        
        this.phBrazoIzqM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getBrazoIzq().getPHMax()));
        this.phBrazoIzqM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getBrazoIzq().getPHMax()));
        
        this.phBrazoDerM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getBrazoDer().getPHMax()));
        this.phBrazoDerM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getBrazoDer().getPHMax()));
        
        this.phPiernaIzqM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getPiernaIzq().getPHMax()));
        this.phPiernaIzqM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getPiernaIzq().getPHMax()));
        
        this.phPiernaDerM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getPiernaDer().getPHMax()));
        this.phPiernaDerM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getPiernaDer().getPHMax()));
        
        
        this.barraSaludM1.setMaximum(robobatalla.getJugador1().getMedabot().getSaludMaxima());
        this.barraSaludM2.setMaximum(robobatalla.getJugador2().getMedabot().getSaludMaxima());
        
        this.barraSaludCabezaM1.setMaximum(robobatalla.getJugador1().getMedabot().getCabeza().getSaludMaxima());
        this.barraSaludCabezaM2.setMaximum(robobatalla.getJugador2().getMedabot().getCabeza().getSaludMaxima());
        
        this.barraSaludBrazoIzqM1.setMaximum(robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludMaxima());
        this.barraSaludBrazoIzqM2.setMaximum(robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludMaxima());
        
        this.barraSaludBrazoDerM1.setMaximum(robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludMaxima());
        this.barraSaludBrazoDerM2.setMaximum(robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludMaxima());
        
        this.barraSaludPiernaIzqM1.setMaximum(robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludMaxima());
        this.barraSaludPiernaIzqM2.setMaximum(robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludMaxima());
        
        this.barraSaludPiernaDerM1.setMaximum(robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludMaxima());
        this.barraSaludPiernaDerM2.setMaximum(robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludMaxima());
        
        
        this.barraSaludM1.setValue(robobatalla.getJugador1().getMedabot().getSaludActual());
        this.barraSaludM2.setValue(robobatalla.getJugador2().getMedabot().getSaludActual());
        
        this.barraSaludCabezaM1.setValue(robobatalla.getJugador1().getMedabot().getCabeza().getSaludActual());
        this.barraSaludCabezaM2.setValue(robobatalla.getJugador2().getMedabot().getCabeza().getSaludActual());
        
        this.barraSaludBrazoIzqM1.setValue(robobatalla.getJugador1().getMedabot().getBrazoIzq().getSaludActual());
        this.barraSaludBrazoIzqM2.setValue(robobatalla.getJugador2().getMedabot().getBrazoIzq().getSaludActual());
        
        this.barraSaludBrazoDerM1.setValue(robobatalla.getJugador1().getMedabot().getBrazoDer().getSaludActual());
        this.barraSaludBrazoDerM2.setValue(robobatalla.getJugador2().getMedabot().getBrazoDer().getSaludActual());
        
        this.barraSaludPiernaIzqM1.setValue(robobatalla.getJugador1().getMedabot().getPiernaIzq().getSaludActual());
        this.barraSaludPiernaIzqM2.setValue(robobatalla.getJugador2().getMedabot().getPiernaIzq().getSaludActual());
        
        this.barraSaludPiernaDerM1.setValue(robobatalla.getJugador1().getMedabot().getPiernaDer().getSaludActual());
        this.barraSaludPiernaDerM2.setValue(robobatalla.getJugador2().getMedabot().getPiernaDer().getSaludActual());
                
        logBatalla.setLineWrap(true);
        
        logBatalla.setWrapStyleWord(true);
        
        String logInicial = "\n"+robobatalla.getJugador1().getNombre()+"'s "+robobatalla.getJugador1().getMedabot().getNombre().substring(0,robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" V/S "+robobatalla.getJugador2().getNombre()+"'s "+robobatalla.getJugador2().getMedabot().getNombre().substring(0,robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"\n\n"
                            + "¡Que comience la robobatalla!\n\n";
        
        logBatalla.setText(logInicial);
        
        this.setVisible(true);
        
        agregarListener(al);
        
        if (robobatalla.getJugadorActivo().equals(robobatalla.getJugador1().getNombre())) {
            
            this.atacanteJ2.setEnabled(false);
            this.defensorJ1.setEnabled(false);
            this.atacarJ2.setEnabled(false);
            this.medafuerzaJ2.setEnabled(false);
            this.defenderJ2.setEnabled(false);
            this.esquivarJ2.setEnabled(false);
            this.atacanteJ2.setEnabled(false);
            this.defenderJ1.setEnabled(false);
            this.esquivarJ1.setEnabled(false);
            
        }
        
        if (robobatalla.getJugadorActivo().equals(robobatalla.getJugador2().getNombre())) {
            
            this.atacanteJ1.setEnabled(false);
            this.defensorJ2.setEnabled(false);
            this.atacarJ1.setEnabled(false);
            this.medafuerzaJ1.setEnabled(false);
            this.defenderJ1.setEnabled(false);
            this.esquivarJ1.setEnabled(false);
            this.atacanteJ1.setEnabled(false);
            this.defenderJ2.setEnabled(false);
            this.esquivarJ2.setEnabled(false);
            
        }
        
        logBatalla.append("* "+numeroAOrdinal(robobatalla.getTurno()).substring(0, 1).toUpperCase() + this.numeroAOrdinal(robobatalla.getTurno()).substring(1)+" turno - Turno de "+robobatalla.getJugadorActivo()+".\n\n");
        
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
    
    public String numeroAOrdinal(int numero) {
        
        String ordinal = new String();  
      
        String[] unidad={"", "primer", "segundo", "tercer", "cuarto", "quinto", "sexto", "septimo", "octavo", "noveno"};  
      
        String[] decena={"", "decimo", "vigesimo", "trigesimo", "cuadragesimo","quincuagesimo", "sexagesimo", "septuagesimo", "octogesimo", "nonagesimo"};  
      
        String[] centena={"", "centesimo", "ducentesimo", "tricentesimo", " cuadringentesimo", " quingentesimo", " sexcentesimo", " septingentesimo"," octingentesimo", " noningentesimo"};  
      
        int u = numero%10;  
      
        int d =(numero/10)%10;  
      
        int c = numero/100;  
      
        if(numero >= 100){  
        
            ordinal = (centena[c]+" "+decena[d]+" "+unidad[u]);  
      
        }
        
        else {  
        
            if(numero >= 10){  
            
                ordinal = (decena[d]+" "+unidad[u]);  
          
            }
            
            else {  
              
                ordinal = (unidad[numero]);  
          
            }  
      
        }
        
        return ordinal;
        
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        phRestanteJ1 = new javax.swing.JLabel();
        phRestanteJ2 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MedaFighter - Medabatalla");
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setLocation(new java.awt.Point(0, 0));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        logBatalla.setEditable(false);
        logBatalla.setBackground(new java.awt.Color(204, 204, 204));
        logBatalla.setColumns(20);
        logBatalla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        logBatalla.setRows(5);
        logBatalla.setBorder(null);
        panelLog.setViewportView(logBatalla);

        getContentPane().add(panelLog);
        panelLog.setBounds(210, 450, 380, 110);

        nombreJ1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreJ1.setText("Jugador1");
        getContentPane().add(nombreJ1);
        nombreJ1.setBounds(19, 12, 66, 15);

        nombreJ2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreJ2.setText("Jugador2");
        getContentPane().add(nombreJ2);
        nombreJ2.setBounds(416, 11, 66, 15);

        nombreM1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nombreM1.setText("Medabot");
        getContentPane().add(nombreM1);
        nombreM1.setBounds(19, 55, 66, 14);
        getContentPane().add(barraSaludM1);
        barraSaludM1.setBounds(132, 55, 100, 14);
        getContentPane().add(barraSaludM2);
        barraSaludM2.setBounds(530, 54, 100, 14);

        nombreM2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nombreM2.setText("Medabot");
        getContentPane().add(nombreM2);
        nombreM2.setBounds(416, 54, 66, 14);
        getContentPane().add(barraMedafuerzaM1);
        barraMedafuerzaM1.setBounds(150, 410, 146, 14);
        getContentPane().add(barraMedafuerzaM2);
        barraMedafuerzaM2.setBounds(630, 410, 146, 14);

        saludMedabotJ1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saludMedabotJ1.setText("1000");
        getContentPane().add(saludMedabotJ1);
        saludMedabotJ1.setBounds(250, 54, 30, 14);

        saludMedabotJ2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saludMedabotJ2.setText("1000");
        getContentPane().add(saludMedabotJ2);
        saludMedabotJ2.setBounds(648, 52, 28, 14);

        atacarJ1.setText("Atacar");
        getContentPane().add(atacarJ1);
        atacarJ1.setBounds(139, 360, 100, 23);

        esquivarJ1.setText("Esquivar");
        getContentPane().add(esquivarJ1);
        esquivarJ1.setBounds(105, 489, 73, 23);

        defenderJ1.setText("Defender");
        getContentPane().add(defenderJ1);
        defenderJ1.setBounds(10, 489, 77, 23);

        rendirseJ1.setText("Rendirse");
        getContentPane().add(rendirseJ1);
        rendirseJ1.setBounds(60, 530, 75, 23);

        esquivarJ2.setText("Esquivar");
        getContentPane().add(esquivarJ2);
        esquivarJ2.setBounds(709, 489, 73, 23);

        defenderJ2.setText("Defender");
        getContentPane().add(defenderJ2);
        defenderJ2.setBounds(614, 489, 77, 23);

        rendirseJ2.setText("Rendirse");
        getContentPane().add(rendirseJ2);
        rendirseJ2.setBounds(660, 530, 75, 23);

        atacarJ2.setText("Atacar");
        getContentPane().add(atacarJ2);
        atacarJ2.setBounds(542, 360, 100, 23);

        medafuerzaJ1.setText("Medafuerza");
        getContentPane().add(medafuerzaJ1);
        medafuerzaJ1.setBounds(20, 410, 89, 23);

        medafuerzaJ2.setText("Medafuerza");
        getContentPane().add(medafuerzaJ2);
        medafuerzaJ2.setBounds(500, 410, 89, 23);

        jLabel1.setText("Cabeza");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(19, 97, 36, 14);

        jLabel2.setText("Brazo Izquierdo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(19, 137, 75, 14);

        jLabel5.setText("Brazo Derecho");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(19, 177, 70, 14);

        jLabel6.setText("Pierna Izquierda");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(19, 217, 78, 14);

        jLabel7.setText("Pierna Derecha");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(19, 258, 73, 14);

        jLabel8.setText("Cabeza");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(416, 96, 36, 14);

        jLabel9.setText("Brazo Izquierdo");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(416, 136, 75, 14);

        jLabel10.setText("Brazo Derecho");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(416, 176, 70, 14);

        jLabel11.setText("Pierna Izquierda");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(416, 216, 78, 14);

        jLabel12.setText("Pierna Derecha");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(416, 257, 73, 14);
        getContentPane().add(barraSaludCabezaM1);
        barraSaludCabezaM1.setBounds(132, 97, 100, 14);
        getContentPane().add(barraSaludBrazoIzqM1);
        barraSaludBrazoIzqM1.setBounds(132, 137, 100, 14);
        getContentPane().add(barraSaludBrazoDerM1);
        barraSaludBrazoDerM1.setBounds(132, 177, 100, 14);
        getContentPane().add(barraSaludPiernaIzqM1);
        barraSaludPiernaIzqM1.setBounds(132, 217, 100, 14);
        getContentPane().add(barraSaludPiernaDerM1);
        barraSaludPiernaDerM1.setBounds(132, 258, 100, 14);
        getContentPane().add(barraSaludCabezaM2);
        barraSaludCabezaM2.setBounds(530, 96, 100, 14);
        getContentPane().add(barraSaludBrazoIzqM2);
        barraSaludBrazoIzqM2.setBounds(530, 136, 100, 14);
        getContentPane().add(barraSaludBrazoDerM2);
        barraSaludBrazoDerM2.setBounds(530, 176, 100, 14);
        getContentPane().add(barraSaludPiernaIzqM2);
        barraSaludPiernaIzqM2.setBounds(530, 216, 100, 14);
        getContentPane().add(barraSaludPiernaDerM2);
        barraSaludPiernaDerM2.setBounds(530, 257, 100, 14);

        saludCabezaM1.setText("1000");
        getContentPane().add(saludCabezaM1);
        saludCabezaM1.setBounds(250, 96, 24, 14);

        saludBrazoIzqM1.setText("1000");
        getContentPane().add(saludBrazoIzqM1);
        saludBrazoIzqM1.setBounds(250, 136, 24, 14);

        saludBrazoDerM1.setText("1000");
        getContentPane().add(saludBrazoDerM1);
        saludBrazoDerM1.setBounds(250, 176, 24, 14);

        saludPiernaIzqM1.setText("1000");
        getContentPane().add(saludPiernaIzqM1);
        saludPiernaIzqM1.setBounds(250, 216, 24, 14);

        saludPiernaDerM1.setText("1000");
        getContentPane().add(saludPiernaDerM1);
        saludPiernaDerM1.setBounds(250, 257, 24, 14);

        saludCabezaM2.setText("1000");
        getContentPane().add(saludCabezaM2);
        saludCabezaM2.setBounds(648, 94, 24, 14);

        saludBrazoIzqM2.setText("1000");
        getContentPane().add(saludBrazoIzqM2);
        saludBrazoIzqM2.setBounds(648, 134, 24, 14);

        saludBrazoDerM2.setText("1000");
        getContentPane().add(saludBrazoDerM2);
        saludBrazoDerM2.setBounds(648, 174, 24, 14);

        saludPiernaIzqM2.setText("1000");
        getContentPane().add(saludPiernaIzqM2);
        saludPiernaIzqM2.setBounds(648, 214, 24, 14);

        saludPiernaDerM2.setText("1000");
        getContentPane().add(saludPiernaDerM2);
        saludPiernaDerM2.setBounds(648, 255, 24, 14);

        atacanteJ1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));
        getContentPane().add(atacanteJ1);
        atacanteJ1.setBounds(139, 312, 103, 20);

        defensorJ2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));
        getContentPane().add(defensorJ2);
        defensorJ2.setBounds(260, 312, 103, 20);

        atacanteJ2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));
        getContentPane().add(atacanteJ2);
        atacanteJ2.setBounds(542, 312, 103, 20);

        defensorJ1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));
        getContentPane().add(defensorJ1);
        defensorJ1.setBounds(671, 312, 103, 20);

        jLabel23.setText("Atacante/Defensor");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(19, 315, 92, 14);

        jLabel24.setText("Atacante/Defensor");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(416, 315, 92, 14);

        jLabel25.setText("Costo PH");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(296, 54, 44, 14);

        phCabezaM1.setText("0");
        getContentPane().add(phCabezaM1);
        phCabezaM1.setBounds(296, 96, 6, 14);

        phBrazoIzqM1.setText("0");
        getContentPane().add(phBrazoIzqM1);
        phBrazoIzqM1.setBounds(296, 136, 6, 14);

        phBrazoDerM1.setText("0");
        getContentPane().add(phBrazoDerM1);
        phBrazoDerM1.setBounds(296, 176, 6, 14);

        phPiernaIzqM1.setText("0");
        getContentPane().add(phPiernaIzqM1);
        phPiernaIzqM1.setBounds(296, 216, 6, 14);

        phPiernaDerM1.setText("0");
        getContentPane().add(phPiernaDerM1);
        phPiernaDerM1.setBounds(296, 257, 6, 14);

        jLabel32.setText("Costo PH");
        getContentPane().add(jLabel32);
        jLabel32.setBounds(700, 52, 44, 14);

        phCabezaM2.setText("0");
        getContentPane().add(phCabezaM2);
        phCabezaM2.setBounds(700, 94, 6, 14);

        phBrazoIzqM2.setText("0");
        getContentPane().add(phBrazoIzqM2);
        phBrazoIzqM2.setBounds(700, 134, 6, 14);

        phBrazoDerM2.setText("0");
        getContentPane().add(phBrazoDerM2);
        phBrazoDerM2.setBounds(700, 174, 6, 14);

        phPiernaIzqM2.setText("0");
        getContentPane().add(phPiernaIzqM2);
        phPiernaIzqM2.setBounds(700, 214, 6, 14);

        phPiernaDerM2.setText("0");
        getContentPane().add(phPiernaDerM2);
        phPiernaDerM2.setBounds(700, 255, 6, 14);

        terminarTurno.setText("Terminar turno");
        getContentPane().add(terminarTurno);
        terminarTurno.setBounds(350, 410, 103, 23);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("PH Restante");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(132, 13, 70, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("PH Restante");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(530, 12, 70, 14);

        phRestanteJ1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        phRestanteJ1.setText("10");
        getContentPane().add(phRestanteJ1);
        phRestanteJ1.setBounds(210, 13, 14, 14);

        phRestanteJ2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        phRestanteJ2.setText("10");
        getContentPane().add(phRestanteJ2);
        phRestanteJ2.setBounds(608, 12, 14, 14);

        fondo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medafighter/imagenes/vistaCombate.png"))); // NOI18N
        fondo.setText("jLabel13");
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 800, 600);

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
    
    public javax.swing.JButton getTerminarTurno(){
        return this.terminarTurno;
    }
    
    public javax.swing.JComboBox getAtacanteJ1(){
        return this.atacanteJ1;
    }
    
    public javax.swing.JComboBox getAtacanteJ2(){
        return this.atacanteJ2;
    }
    
    public javax.swing.JComboBox getDefensorJ1(){
        return this.defensorJ1;
    }
    
    public javax.swing.JComboBox getDefensorJ2(){
        return this.defensorJ2;
    }
    
    public javax.swing.JLabel getSaludMedabotJ1(){
        return this.saludMedabotJ1;
    }
    
    public javax.swing.JLabel getSaludCabezaM1(){
        return this.saludCabezaM1;
    }
    
    public javax.swing.JLabel getSaludBrazoIzqM1(){
        return this.saludBrazoIzqM1;
    }
    
    public javax.swing.JLabel getSaludBrazoDerM1(){
        return this.saludBrazoDerM1;
    }
    
    public javax.swing.JLabel getSaludPiernaIzqM1(){
        return this.saludPiernaIzqM1;
    }
    
    public javax.swing.JLabel getSaludPiernaDerM1(){
        return this.saludPiernaDerM1;
    }
    
    public javax.swing.JLabel getPHRestanteJ1(){
        return this.phRestanteJ1;
    }
    
    public javax.swing.JLabel getPHCabezaM1(){
        return this.phCabezaM1;
    }
    
    public javax.swing.JLabel getPHBrazoIzqM1(){
        return this.phBrazoIzqM1;
    }
    
    public javax.swing.JLabel getPHBrazoDerM1(){
        return this.phBrazoDerM1;
    }
    
    public javax.swing.JLabel getPHPiernaIzqM1(){
        return this.phPiernaIzqM1;
    }
    
    public javax.swing.JLabel getPHPiernaDerM1(){
        return this.phPiernaDerM1;
    }
    
    public javax.swing.JLabel getSaludMedabotJ2(){
        return this.saludMedabotJ2;
    }
    
    public javax.swing.JLabel getSaludCabezaM2(){
        return this.saludCabezaM2;
    }
    
    public javax.swing.JLabel getSaludBrazoIzqM2(){
        return this.saludBrazoIzqM2;
    }
    
    public javax.swing.JLabel getSaludBrazoDerM2(){
        return this.saludBrazoDerM2;
    }
    
    public javax.swing.JLabel getsaludPiernaIzqM2(){
        return this.saludPiernaIzqM2;
    }
    
    public javax.swing.JLabel getSaludPiernaDerM2(){
        return this.saludPiernaDerM2;
    }
    
    public javax.swing.JLabel getPHRestanteJ2(){
        return this.phRestanteJ2;
    }
    
    public javax.swing.JLabel getPHCabezaM2(){
        return this.phCabezaM2;
    }
    
    public javax.swing.JLabel getPHBrazoIzqM2(){
        return this.phBrazoIzqM2;
    }
    
    public javax.swing.JLabel getPHBrazoDerM2(){
        return this.phBrazoDerM2;
    }
    
    public javax.swing.JLabel getPHPiernaIzqM2(){
        return this.phPiernaIzqM2;
    }
    
    public javax.swing.JLabel getPHPiernaDerM2(){
        return this.phPiernaDerM2;
    }
    
    public javax.swing.JProgressBar getBarraSaludM1(){
        return this.barraSaludM1;
    }
    
    public javax.swing.JProgressBar getBarraSaludCabezaM1(){
        return this.barraSaludCabezaM1;
    }
    
    public javax.swing.JProgressBar getBarraSaludBrazoIzqM1(){
        return this.barraSaludBrazoIzqM1;
    }
    
    public javax.swing.JProgressBar getBarraSaludBrazoDerM1(){
        return this.barraSaludBrazoDerM1;
    }
    
    public javax.swing.JProgressBar getBarraSaludPiernaIzqM1(){
        return this.barraSaludPiernaIzqM1;
    }
    
    public javax.swing.JProgressBar getBarraSaludPiernaDerM1(){
        return this.barraSaludPiernaDerM1;
    }
    
    public javax.swing.JProgressBar getBarraSaludM2(){
        return this.barraSaludM2;
    }
    
    public javax.swing.JProgressBar getBarraSaludCabezaM2(){
        return this.barraSaludCabezaM1;
    }
    
    public javax.swing.JProgressBar getBarraSaludBrazoIzqM2(){
        return this.barraSaludBrazoIzqM2;
    }
    
    public javax.swing.JProgressBar getBarraSaludBrazoDerM2(){
        return this.barraSaludBrazoDerM2;
    }
    
    public javax.swing.JProgressBar getBarraSaludPiernaIzqM2(){
        return this.barraSaludPiernaIzqM2;
    }
    
    public javax.swing.JProgressBar getBarraSaludPiernaDerM2(){
        return this.barraSaludPiernaDerM2;
    }
    
    public javax.swing.JTextArea getLogBatalla(){
        return this.logBatalla;
    }
    
    public void setBarraSaludM1(int value){
        this.barraSaludM1.setValue(value);
    }
    
    public void setBarraSaludCabezaM1(int value){
        this.barraSaludCabezaM1.setValue(value);
    }
    
    public void setBarraSaludBrazoIzqM1(int value){
        this.barraSaludBrazoIzqM1.setValue(value);
    }
    
    public void setBarraSaludBrazoDerM1(int value){
        this.barraSaludBrazoDerM1.setValue(value);
    }
    
    public void setBarraSaludPiernaIzqM1(int value){
        this.barraSaludPiernaIzqM1.setValue(value);
    }
    
    public void setBarraSaludPiernaDerM1(int value){
        this.barraSaludPiernaDerM1.setValue(value);
    }
    
    public void setBarraSaludM2(int value){
        this.barraSaludM2.setValue(value);
    }
    
    public void setBarraSaludCabezaM2(int value){
        this.barraSaludCabezaM2.setValue(value);
    }
    
    public void setBarraSaludBrazoIzqM2(int value){
        this.barraSaludBrazoIzqM2.setValue(value);
    }
    
    public void setBarraSaludBrazoDerM2(int value){
        this.barraSaludBrazoDerM2.setValue(value);
    }
    
    public void setBarraSaludPiernaIzqM2(int value){
        this.barraSaludPiernaIzqM2.setValue(value);
    }
    
    public void setBarraSaludPiernaDerM2(int value){
        this.barraSaludPiernaDerM2.setValue(value);
    }
    
    public void setSaludMedabotJ1(String text){
        this.saludMedabotJ1.setText(text);
    }
    
    public void setSaludCabezaM1(String text){
        this.saludCabezaM1.setText(text);
    }
    
    public void setSaludBrazoIzqM1(String text){
        this.saludBrazoIzqM1.setText(text);
    }
    
    public void setSaludBrazoDerM1(String text){
        this.saludBrazoDerM1.setText(text);
    }
    
    public void setSaludPiernaIzqM1(String text){
        this.saludPiernaIzqM1.setText(text);
    }
    
    public void setSaludPiernaDerM1(String text){
        this.saludPiernaDerM1.setText(text);
    }
    
    public void setPHJ1(String text){
        this.phRestanteJ1.setText(text);
    }
    
    public void setPHCabezaM1(String text){
        this.phCabezaM1.setText(text);
    }
    
    public void setPHBrazoIzqM1(String text){
        this.phBrazoIzqM1.setText(text);
    }
    
    public void setPHBrazoDerM1(String text){
        this.phBrazoDerM1.setText(text);
    }
    
    public void setPHPiernaIzqM1(String text){
        this.phPiernaIzqM1.setText(text);
    }
    
    public void setPHPiernaDerM1(String text){
        this.phPiernaDerM1.setText(text);
    }
    
    public void setPHJ2(String text){
        this.phRestanteJ2.setText(text);
    }
    
    public void setSaludMedabotJ2(String text){
        this.saludMedabotJ2.setText(text);
    }
    
    public void setSaludCabezaM2(String text){
        this.saludCabezaM2.setText(text);
    }
    
    public void setSaludBrazoIzqM2(String text){
        this.saludBrazoIzqM2.setText(text);
    }
    
    public void setSaludBrazoDerM2(String text){
        this.saludBrazoDerM2.setText(text);
    }
    
    public void setSaludPiernaIzqM2(String text){
        this.saludPiernaIzqM2.setText(text);
    }
    
    public void setSaludPiernaDerM2(String text){
        this.saludPiernaDerM2.setText(text);
    }
    
    public void setPHCabezaM2(String text){
        this.phCabezaM2.setText(text);
    }
    
    public void setPHBrazoIzqM2(String text){
        this.phBrazoIzqM2.setText(text);
    }
    
    public void setPHBrazoDerM2(String text){
        this.phBrazoDerM2.setText(text);
    }
    
    public void setPHPiernaIzqM2(String text){
        this.phPiernaIzqM2.setText(text);
    }
    
    public void setPHPiernaDerM2(String text){
        this.phPiernaDerM2.setText(text);
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
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel phRestanteJ1;
    private javax.swing.JLabel phRestanteJ2;
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
