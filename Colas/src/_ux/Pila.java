/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aux;

import aux.PilaADT;
import colas.ColeccionVaciaExcepcion;

/**
 *
 * @author rdo12
 */
public class Pila <T> implements PilaADT<T>{
    private final int CAP_MAX = 20;
    private int tope;
    private T[] pila;

    public Pila() {
        pila = (T[]) new Object[CAP_MAX];
        tope = -1; //Indica pila vacia
    }
    
    public Pila(int maximo){
        pila = (T[]) new Object[maximo];
        tope = -1; //indica pila vacia
    }
    
    public boolean isEmpty(){
        return tope == -1;
    }
    
    public void push(T dato){
        if (tope==pila.length-1) //pila llena
            expandeCapacidad();
        tope++;
        pila [tope] = dato;
    }
    
    private void expandeCapacidad(){
        T[] masGrande = (T[]) new Object[pila.length * 2];
        
        for(int i = 0; i <= tope; i++)
            masGrande[i] = pila[i];
        pila = masGrande;
    
    }
    
    public T pop(){
        if (isEmpty())
            throw new ColeccionVaciaExcepcion("Pila vacia");
        T resultado;
        resultado = pila[tope];
        tope--;
        return resultado;
    }
    
    public T peek(){
        if (isEmpty())
            throw new ColeccionVaciaExcepcion("Pila vacia");
        
        return pila[tope];
    }

    
    
}
