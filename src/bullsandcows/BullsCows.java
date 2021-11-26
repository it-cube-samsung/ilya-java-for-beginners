package bullsandcows;

import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class BullsCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mainCode;
        int lenCode = readNumber(true, 0);
        int numberOfSymbol = readNumber(false, lenCode);
        mainCode = createCode(lenCode, numberOfSymbol);
        System.out.println("Хорошо, начинаем игру!");
        int nMove = 1;
        while (true) {
            System.out.println("Ход " + nMove + ":");
            String code = scanner.next();
            if (code != "") {
                int bulls = compareCodes(mainCode, code);
                if (bulls == lenCode) {
                    break;
                }
                nMove++;
            }
        }
        System.out.println("Поздравляю! Вы угадали секретный код.");
    }


    public static int compareCodes(String mainCode, String code) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == mainCode.charAt(i)) {
                bulls++;
                continue;
            }
            if (mainCode.contains(code.substring(i, i + 1))) {
                cows++;
                continue;
            }
        }
        if (bulls == cows && bulls == 0) {
            System.out.println("Результат: None.");
        }
        if (cows == 0 && bulls != 0) {
            System.out.println("Результат: " + bulls + " бык(и)");
        }
        if (bulls == 0 && cows != 0) {
            System.out.println("Результат: " + cows + " коров(ы).");
        }
        if (cows != 0 && bulls != 0) {
            System.out.println("Результат: " +
                    bulls + " быки и " + cows + " коровы");
        }
        return bulls;

    }

    public static String createCode(int lenCode, int numberOfSymbol) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        String line = "0123456789abcdefghijklmopqrstvwxyz";
        List<String> lst_symbols = Arrays.asList(line.substring(lenCode-1).split(""));
        Collections.shuffle(lst_symbols);
        for (String symbol : lst_symbols) {
            code.append(symbol);
        }
        StringBuilder possibleSimbol = new StringBuilder(" ");
        for (int i = 0; i < lenCode; i++) {
            possibleSimbol.append('*');
        }
        if (lenCode > 10) {
            possibleSimbol.append(" (0-9, a-" + line.charAt(numberOfSymbol - 1) + ")");
        } else {
            possibleSimbol.append(" (0-" + line.charAt(numberOfSymbol - 1) + ")");
        }

        System.out.println("Серетный код приготовлен:" + possibleSimbol);
        System.out.println("Серетный код: " + code);
        return code.toString();

    }

    public static int readNumber(boolean islenCode, int lenCode) {
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
            if (!islenCode && number < lenCode){
                System.out.println("Невозможно составить уникальный пароль!");
                continue;
            }
            break;
        } while (true);
        return number;
    }
}

