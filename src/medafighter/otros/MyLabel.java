/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.otros;

import javax.swing.JLabel;

/**
 *
 * @author Fabián
 */

// Esta clase es casi igual a un JLabel, pero tiene un detalle distinto: cuando un objeto de esta clase
// esta desactivado, entonces este no muesta un toolTipText cuando se desliza el mouse encima. Esto se usa
// para que cuando el medarotch este desactivado, este no funcione y mustre los parametros del medabot
// y sus medapartes

public class MyLabel extends JLabel {
    
    @Override
    public String getToolTipText() {
    
        if (this.isEnabled()) {
       
            return super.getToolTipText();
     
        }
     
        return null;
    
    }
    
}
