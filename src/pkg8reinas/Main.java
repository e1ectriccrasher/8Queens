/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8reinas;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;
import conjuntos.ConjuntoADT;
import conjuntos.Conjuntos;
import java.util.ArrayList;

import java.util.Arrays;

/**
 *
 * @author alexcesarmoya
 */
public class Main {
    
    private static final int Ren =8;
    
    private static final int Col=8;
    
    
    
    private static ConjuntoADT k = new Conjuntos();
    
    private  static ConjuntoADT c = new Conjuntos();
    
    private  static ConjuntoADT Diag45 = new Conjuntos();
    
    private  static ConjuntoADT Diag135 = new Conjuntos();

    /**
     * esta es el constructor de la calse en donde van a estar todos los arreglos para calcular las posibles solciones 
     */
    public Main() {
        k = this.k;
        c=this.c;
        Diag45 = this.Diag45;
        Diag135 = this.Diag135;
        
        
    }
    
    public Main(int x, int y) {
        this();
    }
    

    /**
     * 
     * @param x es la coor x
     * @param y es la coor y
     * @return regresa para ver si esta disponible esa coordenada 
     */
    public  boolean VerificaCoor(int x, int y){
        
        boolean resp;
        if(!k.contains(x) && !c.contains(y) && !Diag45.contains(x+y) && !Diag135.contains(x-y) ){
            k.add(x);
            c.add(y);
            Diag45.add(x+y);
            Diag135.add(x-y);
            resp = true;
            
            
        }
        else 
            resp = false;
        {
            
        }
        return resp;
    }
    /**
     * este programa pone en el tablero la pirmera corrdenada del usuario
     * @param x la cooredeanda  ue pone el usuario
     * @param y la cooredenada que pone el usuario
     */
    public void lugarUsuario(int x, int y){
        k.add(x);
        c.add(y);
        Diag45.add(x+y);
        Diag135.add(x-y);
        
    }
    /**
     * Lo que hace es eliminar del arreglo las soluciones de un ¡a coordenada que no llevara a ninguna solucion
     */
    public void elimina(){
        k.removeI();
        c.removeI();
        Diag45.removeI();
        Diag135.removeI();
        
    }
    /**
     * es un metodo recirsivo para dar solucion al problema de las n reinas 
     * @param x es la coordenada del usuario
     * @param y es al corrdenada del usiario
     * @return esto nos lleva a otro metodo recursivo
     */
    public boolean Sol(int x, int y){
        int i=0;
        int j=0;
        lugarUsuario(x, y);
        
        return Sol(x, y, i, j);
    }
    /**
     * es la continuacion del metodo recursivo 
     * @param x es la cooredenada del usiario
     * @param y es la coordenada del usuario
     * @param i son los contadores que se despalzan por el tablero 
     * @param j son los contadores que se desplazan por el tablero
     * @return regresa si hay solución 
     */
    private boolean Sol(int x, int y, int i, int j){
        if(j>=0){
            if(j<Ren){
                if(i<Col){ // significa que no puso nada se gastarin todas las posibilidades 
                    if(y==j){
                        return Sol(x, y, i, j+1);
                    }
                    if(VerificaCoor(i, j)){  // añadir si no es la que puso el  usuario 
                         return Sol(x, y, i=0, j+1);
                    }
                    else {
                        return Sol(x, y, i+1, j);
                    }
                }
                
            }
            if(k.size()== Ren){
                return true;
            }
            else {
                if(k.ele(k.size()-1).equals(x)){
                    return Sol(x, y, (int) c.ele(c.size()-1), -1);
                }
                else{
                    int aux1 = (int) k.ele(k.size()-1)+1;
                    int aux2 = (int)c.ele(c.size()-1);
                    elimina();
                    return Sol(x, y, aux1, aux2);
                }
            }
        }
        return false;
    }
    /**
     * imprimer en un ArrayList las corrdenasdas de respuesta para que sean mas manejables 
     * @return un ArrayList
     */
    public  ArrayList imprimeK(){
        ArrayList l = new ArrayList();
        for(int i=0;i<k.size();i++){
            l.add(k.ele(i));
        }
        return l;
    }
    /**
     * imprime en un ArrayList las corrdenasdas de respuesta para que sean mas manejables 
     * @return un ArrayList 
     */
    public  ArrayList imprimeC(){
        ArrayList l = new ArrayList();
        for(int i=0;i<c.size();i++){
            l.add(c.ele(i));
        }
        return l;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        
        Main m = new Main();
        
        System.out.println(m.Sol(3,0));
        
        System.out.println(Arrays.toString(k.toArray()));
        System.out.println(Arrays.toString(c.toArray()));
        System.out.println(Arrays.toString(Diag45.toArray()));
        System.out.println(Arrays.toString(Diag135.toArray()));
        
        
        

//        m.lugarUsuario(1, 2);
//        
//        System.out.println(m.VerificaCoor(0, 0));
//        m.elimina();
        
//        System.out.println(k.size());
        
        
//        m.lugarUsuario(2, 3);
//        
//        
//        
//        
//        System.out.println(m.VerificaCoor(1, 0));
//        System.out.println(m.VerificaCoor(3, 1));
//        System.out.println(m.VerificaCoor(0, 2));
//        System.out.println(m.VerificaCoor(4, 4));
//        k.removeI();
//        System.out.println(Arrays.toString(k.toArray()));
        
        
        
        
        
        
        
       


        
        
    }
    
}
