package com.pset2.mario.Printers;

import com.pset2.mario.Printer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Filer implements Printer {
    Scanner scanner = new Scanner(System.in);
    private String fileName;
    private int height;
    public Filer( int height){
        this.height = height;
    }
    public void Print() {
        boolean prints = true;
        PrintWriter writer = null;
        while (prints) {
            try {
                System.out.println("What would you like the file to be called?:");
                fileName = scanner.next();
                if (!fileName.endsWith(".txt")) {
                    fileName += ".txt";
                }
                writer = new PrintWriter(fileName, "UTF-8");
                prints = false;
            } catch (FileNotFoundException ex) {
                System.out.println("File not found.");
                prints = true;
            } catch (UnsupportedEncodingException ex) {
                System.out.println("Unsupported encoding type.");
                prints = true;
            }
        }
        int counter = 1;
        for (int i = 1; i <= height; i++) {
            for (int k = 0; k < height - i; k++) {
                writer.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                writer.print("X");
            }
            if (counter < height) {
                writer.println();
                counter++;
            }
        }
        writer.close();
    }
}
