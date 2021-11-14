package com.company;

import java.util.Random;
import java.util.Scanner;

public class Bulls_cows_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String main_code;
        int len_code = readNumber(true);
        int n_symbol = readNumber(false);
    main_code = createCode(len_code, n_symbol);
    System.out.println("Хорошо, начинаем игру!");
    int n_move = 1;
    while (true) {
        System.out.println("Ход " + n_move + ":");
        String code = scanner.next();
        System.out.println("'"+code+"'");
        if (code != "") {
        int bulls = compareCodes(main_code, code);
        if (bulls == len_code) {break;}
        n_move++;}
    }
    System.out.println("Поздравляю! Вы угадали секретный код.");
    }


    public static int compareCodes(String main_code, String code) {
        int bulls = 0;
        int cows = 0;
        for (int i=0;i<code.length();i++) {
            if (code.charAt(i) == main_code.charAt(i)) {
                bulls++;
                continue;
            }
            if (main_code.contains(code.substring(i, i+1))) {
                cows++;
                continue;
            }
        }
        if (bulls == cows && bulls == 0) {System.out.println("Результат: None.");}
        if (cows == 0 && bulls != 0) {System.out.println("Результат: " + bulls + " бык(и)");}
        if (bulls == 0 && cows != 0) {System.out.println("Результат: " + cows + " коров(ы).");}
        if (cows != 0 && bulls != 0) {System.out.println("Результат: " +
                bulls + " быки и " + cows + " коровы");}
        return bulls;

    }

    public static String createCode(int len_code, int n_symbol) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        String line = "0123456789abcdefghijklmopqrstvwxyz";
            for (int i=0;i<len_code;i++) {
                code.append(line.charAt(random.nextInt(n_symbol + 1)));
            }
            StringBuilder possible_simbol = new StringBuilder(" ");
            for (int i=0;i<len_code;i++) {
                possible_simbol.append('*');
            }
            if (len_code > 10) {
                possible_simbol.append(" (0-9, a-" + line.charAt(n_symbol-1) + ")");
            } else {
                possible_simbol.append(" (0-" + line.charAt(n_symbol-1) + ")");
            }

            System.out.println("Серетный код приготовлен:" + possible_simbol);
            System.out.println("Серетный код: " + code);
            return code.toString();

    }

    public static int readNumber(boolean islenCode) {
        Scanner scanner = new Scanner(System.in);
        String line;
        int number;
        do {
            if (islenCode) {
                System.out.println("Введите длину секретного кода:");
            } else {
                System.out.println("Введите кол-во возможных символов в коде:");
            }
            line = scanner.nextLine();
            try {

                number = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Ошибка: '" + line + "' недействительное число.");
                continue;
            }
            if (number > 36) {
                if (islenCode) {
                    System.out.println("Ошибка. Слишком большая длина кода.");
                } else {
                    System.out.println("Ошибка: максимальное количество возможных символов в коде - 36 (0-9, a-z).");
                }
                continue;
            }
            break;
        } while (true);
        return number;
    }
}

