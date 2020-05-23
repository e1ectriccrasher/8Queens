package pkg8reinas;


import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author edi
 */
public interface ConjuntoADT <E> extends  Set<E>{

    /**
     * es un metodo propio de la calse para añadir onjetos al arreglo sin que se repitan
     * @param elemento es un elemento de la clase E
     * @return un booleano si se pudo añadir o no
     */
    public boolean add(E elemento);
    /**
     * es un metodo adicional de la calse para poder eliminar objetos del arreglo en la última posisicion
     * @return regresa un booleano si si se pudo eliminar
     */
    public boolean removeI();
    /**
     * es un metodo dicional para saber cúal es el objeto que esta en la posicion n del arreglo
     * @param i es la posicion en la que se quiere buscar 
     * @return regresa el objeto de la posicion 
     */
    public E ele(int i);
    
}
