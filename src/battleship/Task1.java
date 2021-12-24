package battleship;

import java.util.Scanner;
import java.util.ArrayList;

public class Task1 {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        System.out.println("Начало");
        String[] arrayShips;
        Scanner scanner = new Scanner(System.in);
        Field myField = new Field();
        System.out.println("Хотите ли вы играть по классическому составу кораблей(да, нет)?");
        String type = scanner.nextLine();
        if (type.equals("да")) {
            arrayShips = fleetComposition(1);
        } else {
            arrayShips = fleetComposition(2);
        }
        ArrayList<Ship> ships = new ArrayList<>();
        for (int i = 0; i < arrayShips.length; i++) {
            for (int j = 0; j < Integer.parseInt(arrayShips[i].split(" ")[2]); j++) {
                boolean flagMain;
                do {
                    flagMain = false;
                    myField.out();
                    System.out.printf("Введите координаты %sа (%s ячеек):\n",
                            arrayShips[i].split(" ")[0], arrayShips[i].split(" ")[1]);
                    String[] line = scanner.nextLine().split(" ");

                    if (!validation(line[0]) || !(line[1].equals("-") || line[1].equals("|"))) {
                        System.out.println(ANSI_RED + "Вы ввели некорректные данные. Попробуйте снова" + ANSI_RESET);
                        flagMain = true;
                        continue;
                    }
                    if (!framesField(line[0], Integer.parseInt(arrayShips[i].split(" ")[1]), line[1])) {
                        System.out.println(ANSI_RED + "Ваш корабль выходит за границы поля. Попробуйте снова" + ANSI_RESET);
                        flagMain = true;
                    }
                    int lin = Integer.parseInt(line[0].substring(1));
                    int column = transformation(line[0].substring(0, 1));
                    if (ships.size() == 0) {
                        Ship ship = new Ship(Integer.parseInt(arrayShips[i].split(" ")[1]),
                                arrayShips[i].split(" ")[0], lin, column, line[1].charAt(0));
                        ships.add(ship);
                        myField.filling(ship);
                    } else {
                        boolean flag = false;
                        for (int k=0;k<ships.size();k++) {
                            if (!flag) {
                               flag = ships.get(k).crossingRect(line[0], Integer.parseInt(arrayShips[i].split(" ")[1]),
                                       line[1]);}
                        }
                        if (!flag){
                            Ship ship = new Ship(Integer.parseInt(arrayShips[i].split(" ")[1]),
                                    arrayShips[i].split(" ")[0], lin, column, line[1].charAt(0));
                            ships.add(ship);
                            myField.filling(ship);
                        } else {
                            System.out.println(ANSI_RED + "Ваш корабль входит в границы других кораблей. Попробуйте снова" + ANSI_RESET);
                            flagMain = true;
                        }
                    }
                } while (flagMain);
            }
            myField.out();
            System.out.println("Вы успешно справились с расстановкой кораблей");
        }

    }

    static String[] fleetComposition(int type) {
        if (type == 1) {
            String[] fleet = {"Авианосец 5 1", "Линкор 4 1", "Подлодка 3 1", "Крейсер 3 1", "Эсминец 2 1"};
            return fleet;
        } else {
            String[] fleet = {"Авианосец 4 1", "Линкор 3 2", "Эсминец 2 3", "Катер 1 4"};
            return fleet;
        }
    }

    public static int transformation(String place) {
        String letters  = "АБВГДЕЖЗИК";
        return letters.indexOf(place.charAt(0)) + 1;
    }

    static boolean validation(String line){
        String[] letters  = {"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К"};
        boolean flag = false;
        boolean flagMain = true;
        for (String i : letters) {
            if (line.substring(0, 1).equals(i)) {
                flag = true;
            }
            }
        if (!flag || (Integer.parseInt(line.substring(1)) < 1 || Integer.parseInt(line.substring(1)) > 10)) {
            flagMain = false;
        }
        return flagMain;
    }


    static boolean framesField(String place, int length, String direction) {
        int line = Integer.parseInt(place.substring(1));
        boolean res;
        int column = transformation(place);
        if (direction.equals("-")) {
            if ((column - 1 + length) > 10) {
                res = false;
            } else { res = true; }
        } else {
            if ((line - 1 + length) > 10) {
                res = false;
            } else { res = true; }
        }
        return res;
    }
}