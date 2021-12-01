package com.company.controllers;

import java.util.Locale;
import java.util.Scanner;

public class SoupController {
    private int n;
    private int m;
    private int k;
    private Scanner scanner;
    private char soup[][];
    private String words[];
    private int wordsCount[];

    public SoupController() {
        scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        m = Integer.parseInt(scanner.nextLine());
        soup = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < row.length(); j++) {
                soup[i][j] = row.charAt(j);
            }
        }
        k = Integer.parseInt(scanner.nextLine());
        words = new String[k];
        wordsCount = new int[k];
        for (int i = 0; i < k; i++) {
            words[i] = scanner.nextLine();
        }
    }


    // Print matrix
    public void printMatrix() {
        System.out.println("Sopa de letras");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print((soup[i][j] + " ").toUpperCase(Locale.ROOT));
            }
            System.out.println();
        }
    }

    public void countHorizontalI() {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                String row = "";
                for (int l = 0; l < m; l++) {
                    row += soup[j][l];
                }
                if (row.contains(words[i])) {
                    wordsCount[i]++;
                }
            }
        }
    }

    public void printResult() {
        for (int i = 0; i < k; i++) {
            System.out.println(words[i] + ": " + wordsCount[i]);
        }
    }
}
