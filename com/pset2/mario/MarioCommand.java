package com.pset2.mario;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.io.PrintWriter;


public class MarioCommand {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String size;
        int height = 0;
        boolean cont = true;
        while (height > 23 || height < 0 || cont) {
            try {
                if (height < 0 || height > 23) {
                    System.out.println("Invalid entry. Input must be in the form of numbers between 0 and 23 " +
                            "inclusive.\nTry again.");
                    System.out.print("How high is the pyramid? (between 0 and 23 inclusive): ");
                    size = scanner.next();
                    height = 0;
                } else {
                    System.out.print("How high is the pyramid? (between 0 and 23 inclusive): ");
                    size = scanner.next();

                }
                if (size == null) {
                    System.out.println("Thank you! Have a nice day!");
                    return;
                }

                height = Integer.parseInt(size);

                cont = false;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid entry. Input must be in the form of numbers between 0 and 23 inclusive" +
                        ".\nTry again.");
                height = 0;
                cont = true;
            }
        }
        Printing(height);
    }

    public static void Printing(int height) {
        Scanner scanner = new Scanner(System.in);
        String printer = "null";
        boolean ready = true;
        while (ready) {
            if (printer.equals("null")) {
                System.out.println("Print to console or file? (choose one): ");
                printer = scanner.next();
            } else if (!printer.equals("CONSOLE") && !printer.equals("Console") && !printer.equals("console") &&
                    !printer
                            .equals("FILE") && !printer.equals("File") && !printer.equals("file")) {
                System.out.println("Invalid input. Enter either console or file: ");
            }
            if (printer.equals("CONSOLE") || printer.equals("Console") || printer.equals("console") || printer.equals
                    ("FILE") || printer
                    .equals("File") || printer.equals("file")) {
                ready = false;
            }
        }
        if (printer.equals("CONSOLE") || printer.equals("Console") || printer.equals("console")) {
            int counter = 1;
            for (int i = 1; i <= height; i++) {
                for (int k = 0; k < height - i; k++) {
                    System.out.print(" ");
                }

                for (int j = 1; j <= i; j++) {
                    System.out.print("X");
                }
                if (counter < height) {
                    System.out.println();
                    counter++;
                }
            }
        } else if (printer.equals("FILE") || printer.equals("File") || printer.equals("file")) {
            String fileName;
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
}
