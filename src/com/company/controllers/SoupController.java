package com.company.controllers;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class SoupController {
    private int n; // ROWS
    private int m; // COLUMNS
    private int k; // WORDS
    private Scanner scanner;
    private char soup[][];
    private String words[];
    private int wordsCount[];
    private ArrayList<String> aux;

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

    public void searchOnWords() {
        for (String s : aux) {
            for (int i = 0; i < words.length; i++) {
                if (s.contains(words[i])) {
                    wordsCount[i]++;
                }
            }
        }
    }

    public void countHorizontalL() {
        aux = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            String row = "";
            for (int l = 0; l < m; l++) {
                row += soup[j][l];
            }
            aux.add(row);
        }
        searchOnWords();
    }

    public void countHorizontalR() {
        aux = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            String row = "";
            for (int l = m - 1; l >= 0; l--) {
                row += soup[j][l];
            }
            aux.add(row);
        }
        searchOnWords();
    }

    public void countVerticalT() {
        aux = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            String row = "";
            for (int l = 0; l < m; l++) {
                row += soup[l][j];
            }
            aux.add(row);
        }
        searchOnWords();
    }

    public void countVerticalB() {
        aux = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            String row = "";
            for (int l = m - 1; l >= 0; l--) {
                row += soup[l][j];
            }
            aux.add(row);
        }
        searchOnWords();
    }

    public void countDiagonalLT() {
        aux = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            String row = "";
            for (int l = j; l < m; l++) {
                row += soup[l - j][l];
            }
            aux.add(row);
        }
        for (int j = 0; j < n; j++) {
            String row = "";
            for (int l = j; l < n; l++) {
                row += soup[l][l - j];
            }
            if (j != 0) {
                aux.add(row);
            }
        }
        searchOnWords();
    }

    public void countDiagonalRB() {
        aux = new ArrayList<>();
        int count = 0;
        for (int j = m - 1; j >= 0; j--) {
            String row = "";
            for (int l = j; l >= 0; l--) {
                row += soup[l + count][l];
            }
            aux.add(row);
            count++;
        }
        count = 0;
        for (int j = m - 1; j >= 0; j--) {
            String row = "";
            for (int l = j; l >= 0; l--) {
                row += soup[l][l + count];
            }
            if (j != m - 1) {
                aux.add(row);
            }
            count++;
        }
        searchOnWords();
    }

    public void countDiagonalRT() {
        aux = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            String row = "";
            for (int l = j; l < m; l++) {
                row += soup[l - j][m - 1 - l];
            }
            aux.add(row);
        }
        for (int j = 0; j < m; j++) {
            String row = "";
            for (int l = j; l < m; l++) {
                row += soup[l][m - 1 - l + j];
            }
            if (j != 0) {
                aux.add(row);
            }
        }
        searchOnWords();
    }

    public void countDiagonalBR() {
        aux = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            String row = "";
            for (int l = j; l < m; l++) {
                row += soup[m - 1 - l][l - j];
            }
            aux.add(row);
        }
        for (int j = 0; j < m; j++) {
            String row = "";
            for (int l = j; l < m; l++) {
                row += soup[m - 1 - l + j][l];
            }
            if (j != 0) {
                aux.add(row);
            }
        }
        searchOnWords();
    }

    public void printResult() {
        for (int i = 0; i < k; i++) {
            System.out.println(words[i] + ": " + wordsCount[i]);
        }
    }
}
