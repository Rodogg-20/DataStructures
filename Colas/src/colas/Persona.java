/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import java.time.LocalDate;
import java.time.Period;


public class Persona {
    private String nombre;
    private String fechaNac;

    public Persona(String nombre, String fechaNac) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }
    
    public int calcEdad(){
        
        String fecha=this.getFechaNac();
        
        if (fecha.charAt(4)== '-' || fecha.charAt(7) == '-'){
            
            LocalDate fechaN = LocalDate.parse(fecha);
            LocalDate fechaA = LocalDate.now();
            
             if ((fechaN != null) && (fechaA != null)) {
                return Period.between(fechaN, fechaA).getYears();
             } else {
                return -1;
             }
          
        }
        else
            throw new RuntimeException("Error formato fecha");
        
    }
    
    
    
    
}
