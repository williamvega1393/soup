package com.company;
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, m, k;
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        m = Integer.parseInt(scanner.nextLine());
        char soup[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < row.length(); j++) {
                soup[i][j] = row.charAt(j);
            }
        }
        k = Integer.parseInt(scanner.nextLine());
        String words[] = new String[k];
        int wordsCount[] = new int[k];
        for (int i = 0; i < k; i++) {
            words[i] = scanner.nextLine();
        }

        // Print matrix
        System.out.println("Sopa de letras");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(soup[i][j] + " ");
            }
            System.out.println();
        }
        // words
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

        // Result
        for (int i = 0; i < k; i++) {
            System.out.println(words[i] + ": " + wordsCount[i]);
        }
    }
}
