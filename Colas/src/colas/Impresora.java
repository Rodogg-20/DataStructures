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
public class Impresora {
    private String marca;
    private ColaADT<Archivo> cola;

    public Impresora(String marca) {
        this.marca = marca;
        this.cola =  new ColaA();
    }
    
    public static <T> void copiaCola(ColaADT<T> original,ColaADT<T> destino){
        while (!original.estaVacia()){
            destino.agrega(original.quita());
        }   
    }
    
    public void eliminarFotos(){
        Archivo dato;
        ColaADT<Archivo> colaAux = new ColaA();
        
        if (cola.estaVacia())
            throw new RuntimeException("cola de archivos vacia");
        
        else{
            while(!cola.estaVacia()){
                dato=cola.consultaPrimero();
                
                if(dato instanceof Foto){
                    cola.quita();
                }
                else{
                    colaAux.agrega(cola.quita());
                }
            }
         copiaCola(colaAux,cola);   
        }
        
    }
    
    public void elimDoc500(){
        Archivo dato;
        ColaADT<Archivo> colaAux = new ColaA();
        
        if (cola.estaVacia())
            throw new RuntimeException("cola de archivos vacia");
        
        else{
            while(!cola.estaVacia()){
                dato=cola.consultaPrimero();
                
                if(dato instanceof Documento && dato.getTamaño()>500){
                    cola.quita();
                }
                else{
                    colaAux.agrega(cola.quita());
                }
            }
            
         copiaCola(colaAux,cola);   
        }
        
    }
    
    
    
    
    
    
}