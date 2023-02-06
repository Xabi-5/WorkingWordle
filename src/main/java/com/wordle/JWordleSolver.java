package com.wordle;

import java.util.Scanner;

public class JWordleSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WordleSolver Solucionador = new WordleSolver();
        int exit = 0;
        do {
            System.out.println("Introduce a palabra: ");
            String palabra = sc.next();
            System.out.println("Intrododuce o estado da palabra en formato lllll: ");
            String estado = sc.next();
            Solucionador.addLetters(palabra, estado);
            Solucionador.listLetters();
            Solucionador.solve();
            System.out.println(Solucionador.toString());
        } while (exit == 0);
        

        

    }
}
