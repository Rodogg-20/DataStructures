/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

/**
 *
 * @author rdo12
 */
public class Documento extends Archivo{
    private String tipoProcesador;

    public Documento(String tipoProcesador, double tamaño, String nombre, String dueño, String fecha) {
        super(tamaño, nombre, dueño, fecha);
        this.tipoProcesador = tipoProcesador;
    }

    
    
    
}