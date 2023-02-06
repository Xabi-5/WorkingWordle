package com.wordle;

import java.util.ArrayList;
import java.util.Collections;


public abstract class GameSolver {
    
    //Atributos
    public ArrayList<Solution> soluciones;
    public String nombre;

    
    //Getters & setters
    public ArrayList<Solution> getSoluciones() {
        return soluciones;
    }
    public void setSoluciones(ArrayList<Solution> soluciones) {
        this.soluciones = soluciones;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodos

    public void addSolucion(Solution solucion){
        soluciones.add(solucion);
    }

    public void clearSolucions(){
        soluciones.clear();
    }

    public abstract void solve();

    //A guía di de usar corrections.sort(soluciones) para ordenar, preguntar
    @Override
    public String toString(){
        Collections.sort(soluciones);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < soluciones.size(); i++) {
            str.append("" + i+1 + ". " + soluciones.get(i)+"\n");
        }
        return str.toString();
    }

    //Constructor
    public GameSolver(String nombre){
        this.nombre = nombre;
        soluciones = new ArrayList<Solution>();
    }

}
