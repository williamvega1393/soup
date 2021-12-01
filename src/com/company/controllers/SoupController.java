package com.company.controllers;

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

    public void countHorizontalL() {
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

    public void countHorizontalR() {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                String row = "";
                for (int l = m - 1; l >= 0; l--) {
                    row += soup[j][l];
                }
                if (row.contains(words[i])) {
                    wordsCount[i]++;
                }
            }
        }
    }

    public void countVerticalT() {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                String row = "";
                for (int l = 0; l < m; l++) {
                    row += soup[l][j];
                }
                if (row.contains(words[i])) {
                    wordsCount[i]++;
                }
            }
        }
    }

    public void countVerticalB() {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                String row = "";
                for (int l = m - 1; l >= 0; l--) {
                    row += soup[l][j];
                }
                if (row.contains(words[i])) {
                    wordsCount[i]++;
                }
            }
        }
    }

    public void countDiagonalLT() {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                String row = "";
                for (int l = j; l < m; l++) {
                    row += soup[l - j][l];
                }
                if (row.contains(words[i])) {
                    wordsCount[i]++;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                String row = "";
                for (int l = j; l < n; l++) {
                    row += soup[l][l - j];
                }
                if (row.contains(words[i]) && j != 0) {
                    wordsCount[i]++;
                }
            }
        }
    }

    public void countDiagonalRB() {
        for (int i = 0; i < k; i++) {
            int aux = 0;
            for (int j = m - 1; j >= 0; j--) {
                String row = "";
                for (int l = j; l >= 0; l--) {
                    row += soup[l + aux][l];
                }
                if (row.contains(words[i])) {
                    wordsCount[i]++;
                }
                aux++;
            }
        }
        for (int i = 0; i < k; i++) {
            int aux = 0;
            for (int j = m - 1; j >= 0; j--) {
                String row = "";
                for (int l = j; l >= 0; l--) {
                    row += soup[l][l + aux];
                }
                if (row.contains(words[i]) && j != m - 1) {
                    wordsCount[i]++;
                }
                aux++;
            }
        }
    }

    public void countDiagonalRT() {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                String row = "";
                for (int l = j; l < m; l++) {
                    row += soup[l - j][m - 1 - l];
                }
                if (row.contains(words[i])) {
                    wordsCount[i]++;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                String row = "";
                for (int l = j; l < m; l++) {
                    row += soup[l][m - 1 - l + j];
                }
                if (row.contains(words[i]) && j != 0) {
                    wordsCount[i]++;
                }
            }
        }
    }

    public void countDiagonalBR() {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                String row = "";
                for (int l = j; l < m; l++) {
                    row += soup[m - 1 - l][l - j];
                }
                if (row.contains(words[i])) {
                    wordsCount[i]++;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                String row = "";
                for (int l = j; l < m; l++) {
                    row += soup[m - 1 - l + j][l];
                }
                if (row.contains(words[i]) && j != 0) {
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
