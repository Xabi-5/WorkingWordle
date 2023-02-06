package com.wordle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.SupportedValuesAttribute;

public class WordleSolver extends GameSolver {

    // Constantes
    public static final String SOLVER_NAME = "Wordle Solver";
    public static final int DEFAULT_SIZE = 26;
    public static final String DEFAULT_WORDS_FILE = "english.txt";

    // Atributos
    public Letter[] letras;
    public static final File wordsfile = new File("L:/Programacion/2023/APIExercises/wordlesolverig/src/main/java/com/wordle/english.txt");
    public ArrayList<String> diccionario;

    // Constructor por defecto
    public WordleSolver() {
        super(SOLVER_NAME);
        letras = new Letter[DEFAULT_SIZE];
        try (Scanner sc = new Scanner(wordsfile)) {
            diccionario = new ArrayList<String>();
            while (sc.hasNextLine()) {
                diccionario.add(sc.next());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Arquivo non encontrado");
        }
    }
    public void printDictionary(){
        for (String palabra : diccionario) {
            System.out.println(palabra);
        }
    }

    // Metodos
    public void listLetters() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] != null) {
                str.append(letras[i] + "\n");
            }
        }
        System.out.println(str.toString());
    }

    public boolean addLetter(Letter letra) {
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == null) {
                letras[i] = letra;
                return true;
            }
        }
        return false;
    }

    public boolean addLetters(String palabra, String estado) {
        if (palabra.length() != estado.length()) {
            return false;
        } else {
            for (int i = 0; i < palabra.length(); i++) {
                Letter letra = new Letter(palabra.charAt(i), i, LetterStatus.getLetterStatus(estado.charAt(i)));
                addLetter(letra);
            }
            return true;
        }
    }


    public boolean checkPalabra(String palabra) {
        if (palabra == null) {
            return false;
        }
        palabra = palabra.toUpperCase();
        boolean valida = true;
        for (int i = 0; valida && i < letras.length; i++) {
            Letter letra = letras[i];
            if (letra != null && letra.getEstado() != LetterStatus.DESELECT
                    && letra.getPosicion() < palabra.length()) {
                switch (letra.getEstado()) {
                    case CORRECT ->
                        valida = palabra.charAt(letra.getPosicion())
                                == letra.getLetter();
                    case VALID ->
                        valida = palabra.contains(String.valueOf(letra.getLetter()))
                                && palabra.charAt(letra.getPosicion()) != letra.getLetter();
                    case BAD ->
                        valida = !palabra.contains(
                                String.valueOf(letra.getLetter()));
                    case DESELECT -> {
                    }
                }
            }
        }
        return valida;
    }


    public boolean checkPalabra2(String palabra) {
        for (Letter letra : letras) {
            if (letra.getEstado() != LetterStatus.DESELECT && letra != null) {
                if (letra.getEstado() == LetterStatus.CORRECT) {
                    if (letra.getLetter() == palabra.charAt(letra.getPosicion())) {

                    } else {
                        return false;
                    }
                } else if (letra.getEstado() == LetterStatus.VALID) {
                    boolean validstatus = false;
                    for (int i = 0; i < palabra.length(); i++) {
                        if (letra.getLetter() == palabra.charAt(i)) {
                            validstatus = true;
                        }
                    }
                    if (validstatus == false) {
                        return false;
                    }

                } else if (letra.getEstado() == LetterStatus.BAD) {
                    for (int i = 0; i < palabra.length(); i++) {
                        if (letra.getLetter() == palabra.charAt(i)) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void solve() {
    super.clearSolucions();
    String palabra = "";
        for (int i = 0; i < diccionario.size(); i++) {
            palabra = diccionario.get(i);
    
            if(checkPalabra(palabra)){
                WordleSolution solut = new WordleSolution(palabra);
                addSolucion(solut);
            }
        }
    }

}
