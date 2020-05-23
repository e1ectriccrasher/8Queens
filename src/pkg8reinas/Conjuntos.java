/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8reinas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 *es la clase conjunto 
 * @author Alejandro
 * @param <E>
 */
public class Conjuntos<E> implements ConjuntoADT<E> {

    /**
     * @param args the command line arguments
     */
    
    private E arr[];
    private  int tope;
    private static final int max =50;

    /**
     * es el cinstructor de la clase 
     */
    public Conjuntos() {
        arr = (E[]) new Object[max];
        this.tope =0;
    }

    /**
     * es el cionstructor de la calse porsi se quiere añadir un tamaño inical 
     * @param capacidadInicial es el tamaño inicial del arreglo
     */
    public Conjuntos(int capacidadInicial) {
        arr = (E[]) new Object[max];
        this.tope = capacidadInicial;
    }
    
    
    
    
    

    /**
     * metodo que determina el tamaño del arreglo
     * @return regresa el int tamaño dela arreglo
     */
    @Override
    public int size() {
        return tope;
        }
    /**
     * revisas si el arreglo esta vacio
     * @return regresza un booleano si realemnte esta vacio
     */
    @Override
    public boolean isEmpty() {
        return tope==0;
    }
    /**
     * metodo adicioknal para hacer la busqueda del objeto más rápida 
     * @param <E> es un metodo generico calse E
     * @param arr es el arreglo 
     * @param n es el numero total del arreglo
     * @param x es el objeto que se quiere buscar 
     * @return 
     */
    public  static <E> int busquedaSecuencialDesordenada(E[] arr, int n, Object x) {
		//no usa boolean
		int i=0;
		int pos;
		
		while(i<n && !arr[i].equals(x))
			i++;
		if(i==n)
			pos=-1;
		else
			pos=i;
		return pos;
	}
    /**
     * metodo para saber si el arreglo contine el elemento deseado
     * @param o es el elemnto a bucar 
     * @return regresa un booleano para ver si lo contiene
     */
    @Override
    public boolean contains(Object o) {
        boolean res=false;
        Iterator<E> it;
        it=iterator();
        while(it.hasNext()&&!res)
            res=it.next().equals(o);
        return res;
    }
    /**
     * es una clase aparte par apoder iterar sobre el arreglo
     * @return regresa la calse 
     */
    @Override
    public Iterator<E> iterator() {
        return  new IteratorArreglo<>(arr,tope);
    }
    /**
     * es un metodo que regresa el areglo como un elemnto de la calse Array
     * @return arreglo en clase Array
     */
    @Override
    public Object[] toArray() {
        
        Object [] arry = new Object[tope];
        if(this.isEmpty()){
            throw new ExceptionInInitializerError();
        }
        
        else{
            
            Iterator it = this.iterator();
            for(int i=0;i<tope;i++){
                arry[i]=it.next();
            }
        }
        return arry;
    }
    /**
     * es un metodo que regresa el areglo como un elemnto de la calse Array
     * @return arreglo en clase Array
     */
    @Override
    public <T> T[] toArray(T[] a) {
        try{
            Iterator it = this.iterator();
            for(int i=0;i<tope;i++){
              a[i] = (T) it.next();
            }
        }catch(RuntimeException e){
            e.getMessage();
        }
        return a;
    }
    /**
     * metodompara agregar elementos sin repetir
     * @param e elemento a gregar 
     * @return r egresa booleano para confira¡mar si se pudo agregar
     */
    @Override
    public boolean add(E e) {
    boolean resp;
    resp=contains(e);
    if(!resp){
        if(tope==arr.length)
            expande();
        arr[tope]=e;
        tope++;
    }
    return !resp;    
    }
    /**
     * en caso de que se acabe el arreglo este metodo copiara el arreglo a uno ms grande
     */
    private void expande(){
        E[] grande= (E[]) new Object[arr.length*2];
        for (int i=0; i<=tope-1;i++)
            grande[i]=arr[i];
        arr=grande;
    }
    /**
     * este metodo quta el elemento que se desea quitar
     * @param o elemento que se quiere quitar
     * @return regresa un booleano de confirmacion si se pudo quitar el elemento del arrgelo
     */
    @Override
    public boolean remove(Object o) {
        boolean resp;
        int pos= busquedaSecuencialDesordenada(arr, tope, o);
        if(pos>=0){
            resp=true;
            arr[pos]=arr[tope-1];
            tope--;
        }
        else
            resp=false;
        return resp;
        
    }
    /**
     * este es metodoa adicional que qui¡ta el último eleemnto del arreglo
     * @return regresa un booleano 
     */
    @Override
    public boolean removeI(){
        arr[tope-1]=null;
        tope--;
        return true;
    }
    /**
     * te dice el elemento que esta en la posiciosn deseada 
     * @param n al posicion en donde quieres busacr el elemento 
     * @return regresa el elemento en es aosicion 
     */
    public E ele(int n){
        return arr[n];
    }
    
 /**
  * este metodo regresa el arreglo en forma de cadena 
  * @param it es el iterador para poder recorrer el erreglo
  * @param cad es la cadena donde se insertan los elementols 
  * @return regresa los elementos del arreglo en forma de String
  */
    private String toString(Iterator<E> it,StringBuilder cad){
        if (!it.hasNext())
            return cad.toString();
        else{
            cad.append(it.next()).append(" ");
            return toString(it,cad);
        }
    }
     /**
  * este metodo regresa el arreglo en forma de cadena 
  *  
  * @return regresa los elementos del arreglo en forma de String
  */
    @Override
    public String toString(){
        return toString(iterator(), new StringBuilder());
    }
    
    /**
     * este metodo dice si los elementos de la coleccion esan dentro del arreglo 
     * @param c es el arreglo que se quiere usar 
     * @return un booleano para ver si el arreglo cumple con las condiciones 
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator it = c.iterator();
        boolean resp = true;
        while(it.hasNext() && resp){
            if(!this.contains(it.next())){
                resp =false;
            }
            else{
                resp = true;
            }
        }
        return resp;
    }
    /**
     * este metodo agrega todos los elementos de la coleccion al arreglo 
     * @param c es la coleccion que se quiere agregar
     * @return regresa un arrglo conjunto con la coleccion añadida 
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean resp = false;
        if(c.isEmpty()){
            throw new ExceptionInInitializerError();
        }
        else{
            Iterator it = c.iterator();
            while(it.hasNext()){
                this.add((E) it.next());
            }
            resp = true;
        }
        return resp;
    }
    /**
     * este metodo reteiene los elementos que tienen en comun los dos conjunto 
     * @param c es la coleccion que se quiere comparar 
     * @return regresa el conjunto modificado
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean resp = true;
        Iterator it = this.iterator();
        while(it.hasNext()){
            Object value= it.next();
            if(!c.contains(value)){
                this.remove(value);
            }
        }
        return resp;
    }
    /**
     * este metodo quita todos los elemento unicos de el conjunto que se trabaja 
     * @param c es el conjunto con el que se quiere trabajar 
     * @return regresa el conjunto modificado
     */
    @Override
    public boolean removeAll(Collection<?> c) {
         boolean resp = true;
        Iterator it = this.iterator();
        while(it.hasNext()){
            Object value= it.next();
            if(c.contains(value)){
                this.remove(value);
            }
        }
        return resp;
    }
    /**
     * este metodo elimina todos los elementos del arreglo 
     */
    @Override
    public void clear() {
        if(this == null){
            throw new ExceptionInInitializerError();
        }
        else {
            for (int i=0;i<tope;i++){
                arr[i]=null;
            }
            tope =0;
        }
        
    }
    /**
     * este es un metodo donde de un conjunto lo psas a un archivo de texto182146
     * @param arch
     * @return 
     */
    public static ConjuntoADT leeArchivo(String arch){
        ConjuntoADT resp = new Conjuntos();
        File f = new File(arch);
        try {
            Scanner scn = new Scanner(f);
            while(scn.hasNext()){
                resp .add(scn.next());
            }
        } catch (FileNotFoundException ex) {
            System.err.println(" no se encuentra e archivo");
        }
       return resp; 
    }
    
}
