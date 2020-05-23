/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8reinas;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author alexcesarmoya
 * @param <E>
 */
public class IteratorArreglo <E> implements Iterator<E> {
    
    private final E[] colec;
    private final int total;
    private int actual;
    
    public IteratorArreglo(E[]arre, int n){
        colec =arre;
        total = n;
        actual =0;
    }

    @Override
    public boolean hasNext() {
        return actual < total;
    }

    @Override
    public E next() {
        if(hasNext()){
            E res =colec[actual];
            actual++;
            return res;
        }
        else 
            throw new NoSuchElementException();
    }

    
    
}
