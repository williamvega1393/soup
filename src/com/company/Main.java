package com.company;
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import com.company.controllers.SoupController;

public class Main {
    public static void main(String[] args) {
        SoupController soupController = new SoupController();
        soupController.printMatrix();
        soupController.countHorizontalI();
        soupController.printResult();
    }
}
