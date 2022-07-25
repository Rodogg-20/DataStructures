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
public interface ColaADT<T> {
    public void agrega(T dato);
    public T quita();
    public boolean estaVacia();
    public T consultaPrimero();
    public T consultaUltimo();
    public int cuentaElementos();
    public ArrayList<T> multiQuita(int n);
}
