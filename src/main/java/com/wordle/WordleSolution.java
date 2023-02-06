package com.wordle;

import java.util.Random;

public class WordleSolution extends Solution {
    private String word;

    public WordleSolution(){}

    public WordleSolution(String str){
        this.word = str;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    @Override
    protected void setValor() {
        Random ram = new Random();
        valor = ram.nextInt(0,5);
    }

    public String toString(){
        return word.isEmpty() ? "" : word.toUpperCase();
    }
}
