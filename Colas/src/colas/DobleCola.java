/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import java.util.ArrayList;

/**
 *
 * @author rdo12
 */
public class DobleCola<T> implements ColaADT<T> {
    private T[] coleccion;    
    private final int MAX = 100;    
    private int inicio;
    private int ultimo;
    
     public DobleCola() {
        coleccion = (T[]) new Object[MAX];
        inicio=-1;
        ultimo=-1;
    }

    public DobleCola(int maximo) {
        coleccion = (T[]) new Object[maximo];
        this.inicio = -1;
        this.ultimo = -1;
    }

    public boolean estaVacia(){
        
        return inicio ==-1;
    }
    
    public T consultaPrimero(){
        if(this.estaVacia())
            throw new RuntimeException("No hay datos en la cola");
        else
            return coleccion[inicio];
    }
    
    public T consultaUltimo(){
        if(this.estaVacia())
            throw new RuntimeException("No hay datos en la cola");
        else
            return coleccion[ultimo];
    }
    
    public int cuentaElementos(){
        int total=0;
        
        if(!this.estaVacia()){    
        
            if(ultimo>=inicio){
                total=ultimo-inicio+1;
            }
            else{
                total=coleccion.length-(inicio-ultimo)+1;
            }
        }
        return total;
    }
    
    public ArrayList<T> multiQuita(int n){
        
        if (n>this.cuentaElementos()){
            throw new RuntimeException("pocos elementos");
        }
        
        ArrayList<T> resp = new ArrayList<T>();
        
        for (int i=0;i<n;i++){
            resp.add(this.quita());
        }
        return resp;
    }
    
    
    private boolean estaLlena(){
        return inicio == 0 && ultimo==coleccion.length ||   ultimo+1==inicio;
    }
    
    public void agrega(T nuevo){
        if (this.estaLlena())
            expande();
        else
            if(this.estaVacia()){
                inicio=0;
            }
        
        ultimo = (ultimo + 1) % coleccion.length;
        coleccion[ultimo] = nuevo;            
    }
    //lo raro
    public void agregaI (T nuevo){
        if (this.estaLlena())
            expande();
        else
            if(this.estaVacia()){
                inicio=0;
            }
        
        int j; 
        int indice =this.ultimo;
        ultimo=(ultimo+1)%coleccion.length;
        
        for (j=this.cuentaElementos(); j>1; j--){
            coleccion[(indice+1) % coleccion.length]=coleccion[indice];
            indice--;
        }
        coleccion[inicio]=nuevo;
    }
    
    
    
    private void expande(){
        T[] masGrande = (T[]) new Object[coleccion.length*2];
        
        int n = coleccion.length;
        int k = inicio;
        for (int i =0; i<n; i++){
            masGrande[i] = coleccion[k];
            k = (k + 1) % n;
        }
        inicio = 0;
        ultimo = n-1;
        coleccion = masGrande;
    }
    
    public T quita(){
        if(this.estaVacia())
            throw new RuntimeException("No hay datos en la cola");
        
        T eliminado = coleccion[inicio];
        coleccion[inicio] = null;
        
        if(inicio==ultimo){ //hay solo 1 elemento
            inicio = -1; //la cola queda vacia
            ultimo = -1;
        }
        else
            inicio = (inicio + 1) % coleccion.length;
        return eliminado;
    }
    ///lo raro
    public T quitaF(){
        if(this.estaVacia())
            throw new RuntimeException("No hay datos en la cola");
        
        T eliminado = coleccion[ultimo];
        coleccion[ultimo] = null;
        
        if(inicio==ultimo){ //hay solo 1 elemento
            inicio = -1; //la cola queda vacia
            ultimo = -1;
        }
        else
            ultimo = (ultimo - 1) % coleccion.length;
        return eliminado;
    }
    
    
    public String toString(){
        StringBuilder sB = new StringBuilder();
        
        if (!this.estaVacia()){
            int i,n;
            
            n = coleccion.length;
            i=0;
            do {
                sB.append(coleccion[(inicio+i) % n]).append(" ");
                i++;
            }while ((inicio+i)%n != ultimo);
            sB.append(coleccion[ultimo]);
        }
        return sB.toString();
        
    }
    
    
    
}
