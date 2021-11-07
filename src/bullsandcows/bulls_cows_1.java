package com.company;

import java.awt.event.MouseAdapter;
import java.util.Scanner;

public class bulls_cows_1 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final String main_code = "9305";
    compareCodes(main_code, scanner.nextLine());
    }


    public static void compareCodes(String main_code, String code) {
        int bulls = 0;
        int cows = 0;
        for (String i : code.split("")) {
            if (code.indexOf(i) == main_code.indexOf(i)) {
                bulls++;
                continue;
            }
            if (main_code.contains(i)) {
                cows++;
                continue;
            }
        }
        if (bulls == cows && bulls == 0) {System.out.printf("Grade: None. The secret code is %s.\n", main_code);}
        if (cows == 0 && bulls != 0) {System.out.println("Grade: " + bulls + " bull(s). The secret code is " + main_code + ".");}
        if (bulls == 0 && cows != 0) {System.out.println("Grade: " + cows + " cow(s). The secret code is " + main_code + ".");}
        if (cows != 0 && bulls != 0) {System.out.println("Grade: " +
                bulls + " bulls(s) and " + cows + " cow(s). The secret code is " + main_code + ".");}

    }

}

