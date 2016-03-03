/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.otros;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fabián
 */

// Esta clase casi igual a DefaultTablemModel, con la diferencia que los objetos de esta clase, por defecto,
// no pueden tener sus celdas editadas. Esto se usa en la vista DialogRecords, para que la informacion de los
// jugadores no pueda ser editada y no hayan adulteraciones


public class MyTableModel extends DefaultTableModel {    
    
    public MyTableModel(Vector<Vector<Object>> data, Vector<String> columnNames) {
                
        super(data, columnNames);
    
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
}
