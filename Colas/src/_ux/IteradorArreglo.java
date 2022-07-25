/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aux;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author rdo12
 */
public class IteradorArreglo <T> implements Iterator<T> {
    private int total;
    private int actual;
    private T[] coleccion;

    public IteradorArreglo(int total, T[] coleccion) {
        this.actual = 0;
        this.total = total;
        this.coleccion = coleccion;
    }
    
    public boolean hasNext(){
        return actual < total;
    }
    
    public T next(){
        if (hasNext()){
            T visitado = coleccion[actual];
            actual++;
            return visitado;
        }
        else
            throw new NoSuchElementException();
    }
    
    
    
    
    
}
