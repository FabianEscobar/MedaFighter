/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.otros;

/* Clases importadas */

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabián
 */
public class MyTableModel extends DefaultTableModel {    
    
    public MyTableModel(Vector<Vector<Object>> data, Vector<String> columnNames) {
                
        super(data, columnNames);
    
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
