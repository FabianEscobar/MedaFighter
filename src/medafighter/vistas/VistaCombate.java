/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.vistas;

/* Clases importadas */

import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.event.ChangeListener;
import medafighter.modelo.*;
import medafighter.otros.MyLabel;

/**
 *
 * @author Fabián
 */
public class VistaCombate extends javax.swing.JFrame {

    /**
     * Creates new form VistaCombate
     */
    public VistaCombate(EventListener el, Robobatalla robobatalla) {
        
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
        
        
        this.phCabezaM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getCabeza().getCostoPH()));
        this.phCabezaM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getCabeza().getCostoPH()));
        
        this.phBrazoIzqM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getBrazoIzq().getCostoPH()));
        this.phBrazoIzqM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getBrazoIzq().getCostoPH()));
        
        this.phBrazoDerM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getBrazoDer().getCostoPH()));
        this.phBrazoDerM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getBrazoDer().getCostoPH()));
        
        this.phPiernaIzqM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getPiernaIzq().getCostoPH()));
        this.phPiernaIzqM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getPiernaIzq().getCostoPH()));
        
        this.phPiernaDerM1.setText(String.valueOf(robobatalla.getJugador1().getMedabot().getPiernaDer().getCostoPH()));
        this.phPiernaDerM2.setText(String.valueOf(robobatalla.getJugador2().getMedabot().getPiernaDer().getCostoPH()));
        
        
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
        
        String logInicial = ""+robobatalla.getJugador1().getNombre()+"'s "+robobatalla.getJugador1().getMedabot().getNombre().substring(0,robobatalla.getJugador1().getMedabot().getNombre().length()-2)+" V/S "+robobatalla.getJugador2().getNombre()+"'s "+robobatalla.getJugador2().getMedabot().getNombre().substring(0,robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"\n\n"
                            + "¡Que comience la robobatalla!\n\n";
        
        logBatalla.setText(logInicial);
        
        String descripcionM1 = "<html><body>Nombre: "+robobatalla.getJugador1().getMedabot().getNombre().substring(0,robobatalla.getJugador1().getMedabot().getNombre().length()-2)+"<br>"
                + "Ataque/Defensa/Esquive Cabeza: "+robobatalla.getJugador1().getMedabot().getCabeza().getAtaque()+"/"+robobatalla.getJugador1().getMedabot().getCabeza().getDefensa()+"/"+robobatalla.getJugador1().getMedabot().getCabeza().getEsquive()+"<br>"
                + "Ataque/Defensa/Esquive Brazo Izquierdo: "+robobatalla.getJugador1().getMedabot().getBrazoIzq().getAtaque()+"/"+robobatalla.getJugador1().getMedabot().getBrazoIzq().getDefensa()+"/"+robobatalla.getJugador1().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                + "Ataque/Defensa/Esquive Brazo Derecho: "+robobatalla.getJugador1().getMedabot().getBrazoDer().getAtaque()+"/"+robobatalla.getJugador1().getMedabot().getBrazoDer().getDefensa()+"/"+robobatalla.getJugador1().getMedabot().getBrazoDer().getEsquive()+"<br>"
                + "Ataque/Defensa/Esquive Pierna Izquierda: "+robobatalla.getJugador1().getMedabot().getPiernaIzq().getAtaque()+"/"+robobatalla.getJugador1().getMedabot().getPiernaIzq().getDefensa()+"/"+robobatalla.getJugador1().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                + "Ataque/Defensa/Esquive Pierna Derecha: "+robobatalla.getJugador1().getMedabot().getPiernaDer().getAtaque()+"/"+robobatalla.getJugador1().getMedabot().getPiernaDer().getDefensa()+"/"+robobatalla.getJugador1().getMedabot().getPiernaDer().getEsquive()+"<br>"
                + "Medafuerza: "+robobatalla.getJugador1().getMedabot().getMedalla().getMedafuerza()+"<br>"
                + "Carga: "+robobatalla.getJugador1().getMedabot().getMedalla().getTipoCarga()+"<br>"
                + "Defensa Total: "+robobatalla.getJugador1().getMedabot().getDefensaTotal()+"<br>"
                + "Esquive Total: "+robobatalla.getJugador1().getMedabot().getEsquiveTotal()+"</body></html>";
        
        String descripcionM2 = "<html><body>Nombre: "+robobatalla.getJugador2().getMedabot().getNombre().substring(0,robobatalla.getJugador2().getMedabot().getNombre().length()-2)+"<br>"
                + "Ataque/Defensa/Esquive Cabeza: "+robobatalla.getJugador2().getMedabot().getCabeza().getAtaque()+"/"+robobatalla.getJugador2().getMedabot().getCabeza().getDefensa()+"/"+robobatalla.getJugador2().getMedabot().getCabeza().getEsquive()+"<br>"
                + "Ataque/Defensa/Esquive Brazo Izquierdo: "+robobatalla.getJugador2().getMedabot().getBrazoIzq().getAtaque()+"/"+robobatalla.getJugador2().getMedabot().getBrazoIzq().getDefensa()+"/"+robobatalla.getJugador2().getMedabot().getBrazoIzq().getEsquive()+"<br>"
                + "Ataque/Defensa/Esquive Brazo Derecho: "+robobatalla.getJugador2().getMedabot().getBrazoDer().getAtaque()+"/"+robobatalla.getJugador2().getMedabot().getBrazoDer().getDefensa()+"/"+robobatalla.getJugador2().getMedabot().getBrazoDer().getEsquive()+"<br>"
                + "Ataque/Defensa/Esquive Pierna Izquierda: "+robobatalla.getJugador2().getMedabot().getPiernaIzq().getAtaque()+"/"+robobatalla.getJugador2().getMedabot().getPiernaIzq().getDefensa()+"/"+robobatalla.getJugador2().getMedabot().getPiernaIzq().getEsquive()+"<br>"
                + "Ataque/Defensa/Esquive Pierna Derecha: "+robobatalla.getJugador2().getMedabot().getPiernaDer().getAtaque()+"/"+robobatalla.getJugador2().getMedabot().getPiernaDer().getDefensa()+"/"+robobatalla.getJugador2().getMedabot().getPiernaDer().getEsquive()+"<br>"
                + "Medafuerza: "+robobatalla.getJugador2().getMedabot().getMedalla().getMedafuerza()+"<br>"
                + "Carga: "+robobatalla.getJugador2().getMedabot().getMedalla().getTipoCarga()+"<br>"
                + "Defensa Total: "+robobatalla.getJugador2().getMedabot().getDefensaTotal()+"<br>"
                + "Esquive Total: "+robobatalla.getJugador2().getMedabot().getEsquiveTotal()+"</body></html>";
        
        this.medarotchJ1.setToolTipText(descripcionM1);
        
        this.medarotchJ2.setToolTipText(descripcionM2);
        
        this.setVisible(true);
        
        agregarActionListener((ActionListener) el);
        
        agregarChangeListener((ChangeListener) el);
        
        this.medafuerzaJ1.setEnabled(false);
        this.medafuerzaJ2.setEnabled(false);
        
        this.medafuerzaJ1.setEnabled(false);
        this.medafuerzaJ2.setEnabled(false);
        
        if (robobatalla.getJugadorActivo().equals(robobatalla.getJugador1().getNombre())) {
            
            this.atacanteJ2.setEnabled(false);
            this.defensorJ1.setEnabled(false);
            this.atacarJ2.setEnabled(false);            
            this.defenderJ2.setEnabled(false);
            this.esquivarJ2.setEnabled(false);
            this.atacanteJ2.setEnabled(false);
            this.defenderJ1.setEnabled(false);
            this.esquivarJ1.setEnabled(false);
            this.rendirseJ2.setEnabled(false);
            this.medarotchJ2.setEnabled(false);
            
        }
        
        if (robobatalla.getJugadorActivo().equals(robobatalla.getJugador2().getNombre())) {
            
            this.atacanteJ1.setEnabled(false);
            this.defensorJ2.setEnabled(false);
            this.atacarJ1.setEnabled(false);
            this.defenderJ1.setEnabled(false);
            this.esquivarJ1.setEnabled(false);
            this.atacanteJ1.setEnabled(false);
            this.defenderJ2.setEnabled(false);
            this.esquivarJ2.setEnabled(false);            
            this.rendirseJ1.setEnabled(false);
            this.medarotchJ1.setEnabled(false);
            
        }                
        
        logBatalla.append("* "+numeroAOrdinal(robobatalla.getTurno()).substring(0, 1).toUpperCase() + this.numeroAOrdinal(robobatalla.getTurno()).substring(1)+" turno - Turno de "+robobatalla.getJugadorActivo()+".\n- Como es el primer turno, puede atacar sin la necesidad de defender o esquivar un ataque anterior.\n\n");
        
        if (robobatalla.getModoJuego().equals("Jugador v/s CPU")) {
            
            this.atacanteJ2.setEnabled(false);
            this.defensorJ1.setEnabled(false);
            this.atacarJ2.setEnabled(false);            
            this.defenderJ2.setEnabled(false);
            this.esquivarJ2.setEnabled(false);
            this.atacanteJ2.setEnabled(false);
            this.defenderJ1.setEnabled(false);
            this.esquivarJ1.setEnabled(false);
            this.rendirseJ2.setEnabled(false);
            this.terminarTurno.setEnabled(false);
            this.medarotchJ2.setEnabled(false);
            
        }
        
        if (robobatalla.getModoJuego().equals("CPU V/S CPU")) {
            
            this.atacanteJ2.setEnabled(false);
            this.defensorJ1.setEnabled(false);
            this.atacarJ2.setEnabled(false);            
            this.defenderJ2.setEnabled(false);
            this.esquivarJ2.setEnabled(false);
            this.atacanteJ2.setEnabled(false);
            this.defenderJ1.setEnabled(false);
            this.esquivarJ1.setEnabled(false);
            this.rendirseJ2.setEnabled(false);
            this.medarotchJ2.setEnabled(false);
            
            this.atacanteJ2.setEnabled(false);
            this.defensorJ1.setEnabled(false);
            this.atacarJ2.setEnabled(false);            
            this.defenderJ2.setEnabled(false);
            this.esquivarJ2.setEnabled(false);
            this.atacanteJ2.setEnabled(false);
            this.defenderJ1.setEnabled(false);
            this.esquivarJ1.setEnabled(false);
            this.rendirseJ2.setEnabled(false);
            this.medarotchJ1.setEnabled(false);
            this.terminarTurno.setEnabled(false);  
            
        }
        
    }
    
    void agregarActionListener(ActionListener al){
        
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
    
    void agregarChangeListener(ChangeListener cl){
        
        this.barraSaludM1.addChangeListener(cl);
        
        this.barraSaludCabezaM1.addChangeListener(cl);
        
        this.barraSaludBrazoIzqM1.addChangeListener(cl);
        
        this.barraSaludBrazoDerM1.addChangeListener(cl);
        
        this.barraSaludPiernaIzqM1.addChangeListener(cl);
        
        this.barraSaludPiernaDerM1.addChangeListener(cl);
        
        this.barraSaludM2.addChangeListener(cl);
        
        this.barraSaludCabezaM2.addChangeListener(cl);
        
        this.barraSaludBrazoIzqM2.addChangeListener(cl);
        
        this.barraSaludBrazoDerM2.addChangeListener(cl);
        
        this.barraSaludPiernaIzqM2.addChangeListener(cl);
        
        this.barraSaludPiernaDerM2.addChangeListener(cl);
        
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
        cabezaJ1 = new javax.swing.JLabel();
        brazoIzqJ1 = new javax.swing.JLabel();
        brazoDerJ1 = new javax.swing.JLabel();
        piernaIzqJ1 = new javax.swing.JLabel();
        piernaDerJ1 = new javax.swing.JLabel();
        cabezaJ2 = new javax.swing.JLabel();
        brazoIzqJ2 = new javax.swing.JLabel();
        brazoDerJ2 = new javax.swing.JLabel();
        piernaIzqJ2 = new javax.swing.JLabel();
        piernaDerJ2 = new javax.swing.JLabel();
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
        costoPHLabelJ1 = new javax.swing.JLabel();
        phCabezaM1 = new javax.swing.JLabel();
        phBrazoIzqM1 = new javax.swing.JLabel();
        phBrazoDerM1 = new javax.swing.JLabel();
        phPiernaIzqM1 = new javax.swing.JLabel();
        phPiernaDerM1 = new javax.swing.JLabel();
        costoPHLabelJ2 = new javax.swing.JLabel();
        phCabezaM2 = new javax.swing.JLabel();
        phBrazoIzqM2 = new javax.swing.JLabel();
        phBrazoDerM2 = new javax.swing.JLabel();
        phPiernaIzqM2 = new javax.swing.JLabel();
        phPiernaDerM2 = new javax.swing.JLabel();
        terminarTurno = new javax.swing.JButton();
        phRestanteLabelJ1 = new javax.swing.JLabel();
        phRestanteLabelJ2 = new javax.swing.JLabel();
        phRestanteJ1 = new javax.swing.JLabel();
        phRestanteJ2 = new javax.swing.JLabel();
        medabotJ1 = new javax.swing.JLabel();
        medabotJ2 = new javax.swing.JLabel();
        estadoMedafuerzaJ1 = new javax.swing.JLabel();
        estadoMedafuerzaJ2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        medarotchJ1 = new medafighter.otros.MyLabel();
        medarotchJ2 = new medafighter.otros.MyLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MedaFighter - Medabatalla");
        setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logBatalla.setEditable(false);
        logBatalla.setBackground(new java.awt.Color(204, 204, 204));
        logBatalla.setColumns(20);
        logBatalla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        logBatalla.setRows(5);
        logBatalla.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        logBatalla.setMargin(new java.awt.Insets(10, 10, 10, 10));
        panelLog.setViewportView(logBatalla);

        getContentPane().add(panelLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 380, 120));

        nombreJ1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreJ1.setText("Jugador1");
        getContentPane().add(nombreJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 12, 66, -1));

        nombreJ2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreJ2.setText("Jugador2");
        getContentPane().add(nombreJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 11, 66, -1));

        nombreM1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nombreM1.setText("Medabot");
        getContentPane().add(nombreM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 55, 66, -1));
        getContentPane().add(barraSaludM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 55, 100, 20));
        getContentPane().add(barraSaludM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 54, 100, 20));

        nombreM2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nombreM2.setText("Medabot");
        getContentPane().add(nombreM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 54, 66, -1));

        saludMedabotJ1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saludMedabotJ1.setText("1000");
        getContentPane().add(saludMedabotJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 54, 40, -1));

        saludMedabotJ2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saludMedabotJ2.setText("1000");
        getContentPane().add(saludMedabotJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 52, -1, -1));

        atacarJ1.setText("Atacar");
        getContentPane().add(atacarJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 360, 100, -1));

        esquivarJ1.setText("Esquivar");
        getContentPane().add(esquivarJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 489, -1, -1));

        defenderJ1.setText("Defender");
        getContentPane().add(defenderJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 489, -1, -1));

        rendirseJ1.setText("Rendirse");
        getContentPane().add(rendirseJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, -1, -1));

        esquivarJ2.setText("Esquivar");
        getContentPane().add(esquivarJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(709, 489, -1, -1));

        defenderJ2.setText("Defender");
        getContentPane().add(defenderJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(614, 489, -1, -1));

        rendirseJ2.setText("Rendirse");
        getContentPane().add(rendirseJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 530, -1, -1));

        atacarJ2.setText("Atacar");
        getContentPane().add(atacarJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 100, -1));

        medafuerzaJ1.setText("Medafuerza");
        getContentPane().add(medafuerzaJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        medafuerzaJ2.setText("Medafuerza");
        getContentPane().add(medafuerzaJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, -1, -1));

        cabezaJ1.setText("Cabeza");
        getContentPane().add(cabezaJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 97, -1, -1));

        brazoIzqJ1.setText("Brazo Izquierdo");
        getContentPane().add(brazoIzqJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 137, -1, -1));

        brazoDerJ1.setText("Brazo Derecho");
        getContentPane().add(brazoDerJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 177, -1, -1));

        piernaIzqJ1.setText("Pierna Izquierda");
        getContentPane().add(piernaIzqJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 217, -1, -1));

        piernaDerJ1.setText("Pierna Derecha");
        getContentPane().add(piernaDerJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 258, -1, -1));

        cabezaJ2.setText("Cabeza");
        getContentPane().add(cabezaJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 96, -1, -1));

        brazoIzqJ2.setText("Brazo Izquierdo");
        getContentPane().add(brazoIzqJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 136, -1, -1));

        brazoDerJ2.setText("Brazo Derecho");
        getContentPane().add(brazoDerJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 176, -1, -1));

        piernaIzqJ2.setText("Pierna Izquierda");
        getContentPane().add(piernaIzqJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 216, -1, -1));

        piernaDerJ2.setText("Pierna Derecha");
        getContentPane().add(piernaDerJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 257, -1, -1));
        getContentPane().add(barraSaludCabezaM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 97, 100, -1));
        getContentPane().add(barraSaludBrazoIzqM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 137, 100, -1));
        getContentPane().add(barraSaludBrazoDerM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 177, 100, -1));
        getContentPane().add(barraSaludPiernaIzqM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 217, 100, -1));
        getContentPane().add(barraSaludPiernaDerM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 258, 100, -1));
        getContentPane().add(barraSaludCabezaM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 96, 100, -1));
        getContentPane().add(barraSaludBrazoIzqM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 136, 100, -1));
        getContentPane().add(barraSaludBrazoDerM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 176, 100, -1));
        getContentPane().add(barraSaludPiernaIzqM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 216, 100, -1));
        getContentPane().add(barraSaludPiernaDerM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 257, 100, -1));

        saludCabezaM1.setText("1000");
        getContentPane().add(saludCabezaM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 96, -1, -1));

        saludBrazoIzqM1.setText("1000");
        getContentPane().add(saludBrazoIzqM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 136, -1, -1));

        saludBrazoDerM1.setText("1000");
        getContentPane().add(saludBrazoDerM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 176, -1, -1));

        saludPiernaIzqM1.setText("1000");
        getContentPane().add(saludPiernaIzqM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 216, -1, -1));

        saludPiernaDerM1.setText("1000");
        getContentPane().add(saludPiernaDerM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 257, -1, -1));

        saludCabezaM2.setText("1000");
        getContentPane().add(saludCabezaM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 94, -1, -1));

        saludBrazoIzqM2.setText("1000");
        getContentPane().add(saludBrazoIzqM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 134, -1, -1));

        saludBrazoDerM2.setText("1000");
        getContentPane().add(saludBrazoDerM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 174, -1, -1));

        saludPiernaIzqM2.setText("1000");
        getContentPane().add(saludPiernaIzqM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 214, -1, -1));

        saludPiernaDerM2.setText("1000");
        getContentPane().add(saludPiernaDerM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 255, -1, -1));

        atacanteJ1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));
        getContentPane().add(atacanteJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 312, -1, -1));

        defensorJ2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));
        getContentPane().add(defensorJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 312, -1, -1));

        atacanteJ2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));
        getContentPane().add(atacanteJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, -1, -1));

        defensorJ1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeza", "Brazo Izquierdo", "Brazo Derecho", "Pierna Izquierda", "Pierna Derecha" }));
        getContentPane().add(defensorJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, -1));

        costoPHLabelJ1.setText("Costo PH");
        getContentPane().add(costoPHLabelJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 54, -1, -1));

        phCabezaM1.setText("0");
        getContentPane().add(phCabezaM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 96, -1, -1));

        phBrazoIzqM1.setText("0");
        getContentPane().add(phBrazoIzqM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 136, -1, -1));

        phBrazoDerM1.setText("0");
        getContentPane().add(phBrazoDerM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 176, -1, -1));

        phPiernaIzqM1.setText("0");
        getContentPane().add(phPiernaIzqM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 216, -1, -1));

        phPiernaDerM1.setText("0");
        getContentPane().add(phPiernaDerM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 257, -1, -1));

        costoPHLabelJ2.setText("Costo PH");
        getContentPane().add(costoPHLabelJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 52, -1, -1));

        phCabezaM2.setText("0");
        getContentPane().add(phCabezaM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 94, -1, -1));

        phBrazoIzqM2.setText("0");
        getContentPane().add(phBrazoIzqM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 134, -1, -1));

        phBrazoDerM2.setText("0");
        getContentPane().add(phBrazoDerM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 174, -1, -1));

        phPiernaIzqM2.setText("0");
        getContentPane().add(phPiernaIzqM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 214, -1, -1));

        phPiernaDerM2.setText("0");
        getContentPane().add(phPiernaDerM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 255, -1, -1));

        terminarTurno.setText("Terminar turno");
        getContentPane().add(terminarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, -1, -1));

        phRestanteLabelJ1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        phRestanteLabelJ1.setText("PH Restante");
        getContentPane().add(phRestanteLabelJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 13, -1, -1));

        phRestanteLabelJ2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        phRestanteLabelJ2.setText("PH Restante");
        getContentPane().add(phRestanteLabelJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 12, -1, -1));

        phRestanteJ1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        phRestanteJ1.setText("10");
        getContentPane().add(phRestanteJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 13, -1, -1));

        phRestanteJ2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        phRestanteJ2.setText("10");
        getContentPane().add(phRestanteJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 12, -1, -1));

        medabotJ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medafighter/imagenes/medabotJ1.jpg"))); // NOI18N
        medabotJ1.setText("jLabel1");
        getContentPane().add(medabotJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 100, -1));

        medabotJ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medafighter/imagenes/medabotJ2.jpg"))); // NOI18N
        medabotJ2.setText("jLabel1");
        getContentPane().add(medabotJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 100, -1));

        estadoMedafuerzaJ1.setText("Medafuerza Inactiva");
        getContentPane().add(estadoMedafuerzaJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, -1, -1));

        estadoMedafuerzaJ2.setText("Medafuerza Inactiva");
        getContentPane().add(estadoMedafuerzaJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, -1, -1));

        jLabel1.setText("Atacante");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        jLabel2.setText("Defensora");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jLabel3.setText("Atacante");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        jLabel4.setText("Defensora");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, -1, -1));

        medarotchJ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medafighter/imagenes/medarotch.png"))); // NOI18N
        medarotchJ1.setText("myLabel1");
        getContentPane().add(medarotchJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 80, -1));

        medarotchJ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medafighter/imagenes/medarotch.png"))); // NOI18N
        medarotchJ2.setText("myLabel2");
        getContentPane().add(medarotchJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 80, -1));

        fondo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/medafighter/imagenes/vistaCombate.png"))); // NOI18N
        fondo.setText("jLabel13");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public javax.swing.JLabel getNombreJ1(){
        return this.nombreJ1;
    }
    
    public javax.swing.JLabel getPHRestanteLabelJ1(){
        return this.phRestanteLabelJ1;
    }
    
    public javax.swing.JLabel getNombreM1(){
        return this.nombreM1;
    }
    
    public javax.swing.JLabel getCostoPHLabelJ1(){
        return this.costoPHLabelJ1;
    }
    
    public javax.swing.JLabel getMedabotJ1(){
        return this.medabotJ1;
    }
    
    public javax.swing.JLabel getCabezaJ1(){
        return this.cabezaJ1;
    }
    
    public javax.swing.JLabel getBrazoIzqJ1(){
        return this.brazoIzqJ1;
    }
    
    public javax.swing.JLabel getBrazoDerJ1(){
        return this.brazoDerJ1;
    }
    
    public javax.swing.JLabel getPiernaIzqJ1(){
        return this.piernaIzqJ1;
    }
    
    public javax.swing.JLabel getPiernaDerJ1(){
        return this.piernaDerJ1;
    }
    
    public javax.swing.JLabel getEstadoMedafuerzaJ1(){
        return this.estadoMedafuerzaJ1;
    }
    
    public javax.swing.JLabel getNombreJ2(){
        return this.nombreJ2;
    }
    
    public javax.swing.JLabel getPHRestanteLabelJ2(){
        return this.phRestanteLabelJ2;
    }
    
    public javax.swing.JLabel getNombreM2(){
        return this.nombreM2;
    }
    
    public javax.swing.JLabel getCostoPHLabelJ2(){
        return this.costoPHLabelJ2;
    }
    
    public javax.swing.JLabel getMedabotJ2(){
        return this.medabotJ2;
    }
    
    public javax.swing.JLabel getCabezaJ2(){
        return this.cabezaJ2;
    }
    
    public javax.swing.JLabel getBrazoIzqJ2(){
        return this.brazoIzqJ2;
    }
    
    public javax.swing.JLabel getBrazoDerJ2(){
        return this.brazoDerJ2;
    }
    
    public javax.swing.JLabel getPiernaIzqJ2(){
        return this.piernaIzqJ2;
    }
    
    public javax.swing.JLabel getPiernaDerJ2(){
        return this.piernaDerJ2;
    }
    
    public javax.swing.JLabel getEstadoMedafuerzaJ2(){
        return this.estadoMedafuerzaJ2;
    }
    
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
    
    public MyLabel getMedarotchJ1(){
        return this.medarotchJ1;
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
    
    public javax.swing.JLabel getSaludPiernaIzqM2(){
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
    
    public MyLabel getMedarotchJ2(){
        return this.medarotchJ2;
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
        return this.barraSaludCabezaM2;
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
    
    public void setEstadoMedafuerzaJ1(String text){
        this.estadoMedafuerzaJ1.setText(text);
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
    
    public void setEstadoMedafuerzaJ2(String text){
        this.estadoMedafuerzaJ2.setText(text);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox atacanteJ1;
    private javax.swing.JComboBox atacanteJ2;
    private javax.swing.JButton atacarJ1;
    private javax.swing.JButton atacarJ2;
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
    private javax.swing.JLabel brazoDerJ1;
    private javax.swing.JLabel brazoDerJ2;
    private javax.swing.JLabel brazoIzqJ1;
    private javax.swing.JLabel brazoIzqJ2;
    private javax.swing.JLabel cabezaJ1;
    private javax.swing.JLabel cabezaJ2;
    private javax.swing.JLabel costoPHLabelJ1;
    private javax.swing.JLabel costoPHLabelJ2;
    private javax.swing.JButton defenderJ1;
    private javax.swing.JButton defenderJ2;
    private javax.swing.JComboBox defensorJ1;
    private javax.swing.JComboBox defensorJ2;
    private javax.swing.JButton esquivarJ1;
    private javax.swing.JButton esquivarJ2;
    private javax.swing.JLabel estadoMedafuerzaJ1;
    private javax.swing.JLabel estadoMedafuerzaJ2;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextArea logBatalla;
    private javax.swing.JLabel medabotJ1;
    private javax.swing.JLabel medabotJ2;
    private javax.swing.JButton medafuerzaJ1;
    private javax.swing.JButton medafuerzaJ2;
    private medafighter.otros.MyLabel medarotchJ1;
    private medafighter.otros.MyLabel medarotchJ2;
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
    private javax.swing.JLabel phRestanteLabelJ1;
    private javax.swing.JLabel phRestanteLabelJ2;
    private javax.swing.JLabel piernaDerJ1;
    private javax.swing.JLabel piernaDerJ2;
    private javax.swing.JLabel piernaIzqJ1;
    private javax.swing.JLabel piernaIzqJ2;
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
