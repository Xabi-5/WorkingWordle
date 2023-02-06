package com.wordle;

public class Letter implements Comparable<Letter> {

    // Constants
    private static final int DEFAULT_POSITION = -1;

    // Atributes
    public char letter;
    public LetterStatus estado;
    public int posicion;

    public Letter(char letter, int posicion, LetterStatus estado) {
        if (Character.isLetter(letter)) {
            this.letter = Character.toUpperCase(letter);

        } else {
            this.letter = 0;
        }

        if (estado == LetterStatus.DESELECT || posicion < 0) {
            posicion = DEFAULT_POSITION;
        } else
            this.posicion = posicion;
        this.estado = estado;
    }

    public Letter(char letter) {
        this.letter = (Character.isLetter(letter)) ? Character.toUpperCase(letter) : 0;

        this.estado = LetterStatus.DESELECT;
        this.posicion = DEFAULT_POSITION;
    }

    // Getters & setters
    public LetterStatus getEstado() {
        return estado;
    }

    public void setEstado(LetterStatus estado) {
        this.estado = estado;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = (posicion < 0) ? DEFAULT_POSITION : posicion;
    }

    @Override
    public boolean equals(Object objeto) {
        if (objeto instanceof Letter) {
            Letter lob = (Letter) objeto;
            if (Character.valueOf(this.letter).equals(lob.getLetter()) && (this.posicion == lob.getPosicion())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Letter letra) {
        return (Character.valueOf(this.letter).equals(letra.getLetter())) ? this.posicion - letra.getPosicion()
                : this.letter - letra.getLetter();
    }

    public String toString() {
        return "" + Character.toUpperCase(letter) + "[" + posicion + "]" + "   (" + estado + ")\n";
    }

}
