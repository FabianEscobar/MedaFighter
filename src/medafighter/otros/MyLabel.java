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
public class MyLabel extends JLabel {
    
    @Override
    public String getToolTipText() {
    
        if (this.isEnabled()) {
       
            return super.getToolTipText();
     
        }
     
        return null;
    
    }
    
}
