/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aux;

import java.util.Iterator;

/**
 *
 * @author rdo12
 */
public interface ConjuntoADT <T> extends Iterable <T>{
    public boolean agrega (T nuevo);
    public T quita(T dato);
    public boolean contiene(T dato);
    
    public ConjuntoADT<T> union(ConjuntoADT<T> otro);
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro);
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro);
    public Iterator<T> iterator();
    public String toString();
    public int getCardinalidad();
    
}
