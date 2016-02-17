/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medafighter.otros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Fabián
 */
public abstract class MyController {
    
    public void escribirLog(String log) throws IOException  {
            
        String ruta = "C:\\Users\\Fabián\\Documents\\NetBeansProjects\\MedaFighter\\log.txt";
        
        File adquisicion = new File(ruta);
        
        if(!adquisicion.exists()) {
            
            adquisicion.createNewFile();
        
        }
        
        PrintWriter procesador = new PrintWriter(new BufferedWriter(new FileWriter((adquisicion),true)));
        
        LocalDateTime fecha = LocalDateTime.now();
        
        log = fecha.getDayOfWeek().toString()+" "+fecha.getDayOfMonth()+"/"+fecha.getMonthValue()+"/"+fecha.getYear()+":"+" "+log;
        
        procesador.println(log);       
        
        procesador.close();
        
    }
    
}
