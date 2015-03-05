package com.pset2.mario;

import java.util.Scanner;

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
        Picker picked = new Picker(height);
        picked.Pick();
    }
}
