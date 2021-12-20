package battleship;

import java.util.Scanner;

public class Task_1 {


    public static void main(String[] args) {
        System.out.println("Начало");
        String[] arrayShips;
        Scanner scanner = new Scanner(System.in);
        // Ship ship = new Ship(4, "Авианосец", 5, 6, '-');
        Field my_field = new Field();
        System.out.println("Хотите ли вы играть по классическому составу кораблей(да, нет)?");
        String type = scanner.nextLine();
        if (type.equals("да")) {
            arrayShips = fleetComposition(1);
        } else {
            arrayShips = fleetComposition(2);
        }

        for (int i = 0; i < arrayShips.length; i++) {
            for (int j = 0; j < Integer.parseInt(arrayShips[i].split(" ")[2]); j++) {
                boolean flagMain = false;
                do {
                    System.out.printf("Введите координаты %sа (%s ячеек):\n",
                            arrayShips[i].split(" ")[0], arrayShips[i].split(" ")[1]);
                    String[] line = scanner.nextLine().split(" ");
                    if (!validation(line[0]) || !(line[1].equals("-") || line[1].equals("|"))) {
                        System.out.println("Вы ввели некорректные данные. Попробуйте снова");
                        flagMain = true;
                    }

                    // try {
                    //     //my_field.accommodation(4 - i, line[0], line[1].charAt(0));
                    // } catch (AccomodationException e) {
                    //     System.out.println("Ошибка! В данное место корабль поставить невозможно. Попробуйте снова:");
                    //     flagMain = true;
                    // } finally {
                    //     my_field.out();
                    // }
                } while (flagMain);
            }
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

    static int transformation(String place) {
        String letters  = "АБВГДЕЖЗИК";
        return letters.indexOf(place.charAt(0));
    }

    static boolean validation(String line){
        String[] letters  = {"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К"};
        boolean flag = false;
        boolean flagMain = true;
        for (String i : letters) {
            if (line.substring(0, 1).equals(i)) {
                flag = true;
            }
            if (!flag || (Integer.parseInt(line.substring(1)) < 1 || Integer.parseInt(line.substring(1)) > 10)) {
                flagMain = false;
            }
        }
        return flagMain;
    }
}
