package com.wordle;

public enum LetterStatus {
    CORRECT('c'), VALID('v'), BAD('b'), DESELECT('d');

    // Atribute
    private char caracter;

    // Constructor
    private LetterStatus(char L) {
        if (Character.valueOf(L).equals('c')) {
            caracter = 'c';
        } else if (Character.valueOf(L).equals('v')) {
            caracter = 'v';
        } else if (Character.valueOf(L).equals('b')) {
            caracter = 'b';
        } else if (Character.valueOf(L).equals('d')) {
            caracter = 'd';
        } else {
            System.out.println("Valor non válido ");
        }
    }

    // Methods
    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public static LetterStatus getLetterStatus(final char c){
        for(LetterStatus type : LetterStatus.values()){
            if(Character.valueOf(type.name().charAt(0)).equals(Character.toUpperCase(c))){
                return type;
            }
        }return null;
    }
    
}
