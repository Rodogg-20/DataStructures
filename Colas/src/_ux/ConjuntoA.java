/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aux;
import java.util.Iterator;

/**
 *
 * @author Rodo
 */
public class ConjuntoA <T> implements ConjuntoADT<T> {
    private T[] elementos;
    private int cardinalidad;
    private final int MAX = 50;
    
    public ConjuntoA(){
        elementos = (T[]) new Object[MAX];
        cardinalidad = 0;
    }
    
    public ConjuntoA(int maximo){
        elementos = (T[]) new Object[maximo];
        cardinalidad=0;
    }
    
    public boolean agrega(T nuevo) {
        boolean resp=false;
        
        if (!contiene(nuevo)){
            resp=true;
            if (cardinalidad == elementos.length)
                expande();
            elementos[cardinalidad]=nuevo;
            cardinalidad++;
        }
        return resp;
    }
    
    private void expande(){
        T[] masGrande = (T[]) new Object[elementos.length * 2];
        
        for (int i=0; i< cardinalidad; i++)
            masGrande[i] = elementos[i];
        elementos = masGrande;
    }
    
     private int buscaElemento(T dato, int i){
        if (i == cardinalidad)
            return -1;
        else
            if (dato.equals(elementos[i]))
                return i;
            else
                return buscaElemento(dato, i+1);
    }
    
    public T quita(T dato) {
        int pos;
        
        pos = buscaElemento(dato,0);
        
        if (pos<0)
            throw new RuntimeException("Dato no encontrado");
        T eliminado = elementos[pos];
        elementos[pos] = elementos[cardinalidad -1];
        cardinalidad--;
        
        return eliminado;
    }

    public boolean contiene(T dato) {
        return buscaElemento(dato,0) >= 0;
    }
    
    public Iterator<T> iterator() {
        return new IteradorArreglo(cardinalidad, elementos); 
    }

    public int getCardinalidad() {
        return cardinalidad;
    }
    
    public String toString(){
        return toString(0, new StringBuilder());
    }
    private String toString(int i, StringBuilder sB){
        if (i == cardinalidad)
            return sB.toString();
        else 
            sB.append(elementos[i]).append(" ");
            return toString(i+1, sB);
    }
    
    public ConjuntoADT<T> union(ConjuntoADT<T> otro) {
        if (otro == null)
            throw new RuntimeException("conjunto nulo");
        
        ConjuntoADT<T>res= new ConjuntoA();
        
        for (int i=0; i<cardinalidad; i++){
            res.agrega(elementos[i]);
        }
        Iterator<T>it=otro.iterator();
        while(it.hasNext()){
            res.agrega(it.next());
        }
        
        return res;
    }
    
    public ConjuntoADT<T> unionR(ConjuntoADT<T> otro){
        if (otro == null)
            throw new RuntimeException("conjunto nulo");
        
        ConjuntoADT<T>res= new ConjuntoA();
        
        unionR(res,otro.iterator());
        unionR(res,this.iterator());
        
        return res;
    }
    private void unionR(ConjuntoADT<T> res,Iterator<T> it){
        if (it.hasNext()){
            res.agrega(it.next());
            unionR(res,it);
        }
    }

    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro) {
        if(otro==null)
            throw new RuntimeException("conjunto nulo");
        
        ConjuntoADT<T> res = new ConjuntoA();
        
        //Opcion1: recorriendo el this
        /*
        for(int i = 0; i < cardinalidad; i++)
            if(otro.contiene(this.elementos[i]))
                res.agrega(this.elementos[i]);
        return res;
        */
        
        //Opcion 2: recorriendo a otro
        Iterator<T> it = otro.iterator();
        T dato;
        while (it.hasNext()){
            dato = it.next();
            if (this.contiene(dato))
                res.agrega(dato);
        }
        return res;
    }
    
    public ConjuntoADT<T> interseccionR(ConjuntoADT<T> otro) {
        if(otro==null)
            throw new RuntimeException("conjunto nulo");
        
        ConjuntoADT<T> res = new ConjuntoA();
        
        if(cardinalidad<otro.getCardinalidad())
            interseccionR(res, this.iterator(), otro);
        else
            interseccionR(res, otro.iterator(),this);
        return res;
    }
    
    private void interseccionR(ConjuntoADT<T>res, Iterator<T>it, ConjuntoADT<T> conj){
        if (it.hasNext()){
            T dato = it.next();
            if(conj.contiene(dato))
                res.agrega(dato);
        }
    }
    

    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro) {
        if(otro==null)
            throw new RuntimeException("conjunto nulo");
        
        ConjuntoADT<T> grande = this.union(otro);
        ConjuntoADT<T> peque = this.interseccion(otro);
        
        return diferencia(peque,grande,peque.iterator());
        
        }
    
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> peque, ConjuntoADT<T> grande, Iterator<T>it) {
        
        if (it.hasNext()){
            T dato = it.next();
            grande.quita(dato);
        }
        return grande;        
    }
    
}
