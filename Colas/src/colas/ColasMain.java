/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import aux.ConjuntoA;
import aux.ConjuntoADT;
import aux.Pila;
import aux.PilaADT;
import java.util.Iterator;

/**
 *
 * @author rdo12
 */
public class ColasMain {
    
    //problema 33 de forma iterativa
    public static <T> void invertir(ColaADT<T> cola){
        PilaADT<T> pila = new Pila();
        
        while(!cola.estaVacia()){
            pila.push(cola.quita());
        }
        while (!pila.isEmpty()){
            cola.agrega(pila.pop());
        }       
    }
    //problema 33 de forma recursiva
    
    
    //Problema 34
    public static <T> void quitarRepe(ColaADT<T> cola){
        ColaADT<T> aux = new ColaA();
        T dato;
        if (cola.estaVacia())
            throw new RuntimeException("Cola vacia");
        else
            while (!cola.estaVacia()){
                dato=cola.quita();
                while (!cola.estaVacia() && dato==cola.consultaPrimero()){
                    cola.quita();
                }
                aux.agrega(dato);
            }
        copiaCola(aux,cola);
    }
    
    //Problema 35 
    public static <T> void quitarOcurrencias(ColaADT<T> cola, T dato){
        
        ColaADT<T> aux = new ColaA();
        while(!cola.estaVacia()){
            if (dato==cola.consultaPrimero())
                cola.quita();
            else
                aux.agrega(cola.quita());
        }
        copiaCola(aux,cola);
        
    }
    
    //Problema 35 version recursiva
    
    public static <T> void eliminaDato(ColaADT<T> cola, T dato){
        ColaADT<T> aux = new ColaA();
        
        eliminaDato(cola,dato,aux);  
        
        copiaCola(aux,cola);
        
    }
    private static <T> void eliminaDato(ColaADT<T> cola, T dato, ColaADT<T> aux){
        
        if (!cola.estaVacia()){
            if (dato==cola.consultaPrimero()){
                cola.quita();
            }
            else
                aux.agrega(cola.quita());
        }
        eliminaDato(cola,dato,aux);
    }
    
    
    public static <T> void copiaCola(ColaADT<T> original,ColaADT<T> destino){
        while (!original.estaVacia()){
            destino.agrega(original.quita());
        }
        
        
    }
    
    //Ejercicio 37 Conjuntos
    
    public static <T> void ordenarEdConj(ColaADT<Persona> cola){
        //checar que cola original no este vacia
        if (cola.estaVacia())
            throw new RuntimeException("cola original vacia");
        
        ConjuntoADT conjunto = new ConjuntoA();
        
        //vacia la cola original al conjunto
        while (!cola.estaVacia()){
            conjunto.agrega(cola.quita());
        }
        
        int max;
        Persona personaMax;
        Iterator<Persona> it;
        Persona pasajero;
        
        //empezar ciclo grandote
        while(conjunto.getCardinalidad()>0){
            
            max=0;
            personaMax=null;
            
            it = conjunto.iterator();
            
            while (it.hasNext()){
                
                pasajero=it.next();
                
                if (max<pasajero.calcEdad()){
                    max=pasajero.calcEdad();
                    personaMax=pasajero;
                }
            }
            
            cola.agrega(personaMax);
            conjunto.quita(personaMax);
            
        
        }
        
        
        
        
        
        
    }
    
    
    
    public static void main(String[] args) {
        ColaADT<String> numeros = new ColaA();
        numeros.agrega("uno");
        numeros.agrega("dos");
        numeros.agrega("tres");
        numeros.agrega("cuatro");
        System.out.println("\nCP1: luego de agregar 4 valores " + numeros);
        System.out.println("\nCP2: elementos quitados " + numeros.quita());
        System.out.println("\nCP3: luego de eliminar 1 elemento: " + numeros);
        while (!numeros.estaVacia())
            System.out.println(numeros.quita());
        try{
            System.out.println("\nCP4: consultando el primer dato:" + numeros.consultaPrimero());
        }catch (Exception e){
            System.out.println("\nCP4: " + e);
            }

        
        
        }
    
    


    
}
