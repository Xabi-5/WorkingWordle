package com.wordle;

public abstract class Solution implements Comparable<Solution>{
    
    public int valor;

    public Solution(){}

    public int getValor() {
        return valor;
    }
    abstract void setValor();

    public int compareTo(Solution solucion){
        return this.valor - solucion.valor;
    }
}
