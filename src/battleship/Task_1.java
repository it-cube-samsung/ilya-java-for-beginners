package battleship;
import java.util.Scanner;

public class Task_1 {


    public static void main(String[] args) {
        System.out.println("Начало");
        Scanner scanner = new Scanner(System.in);
        Field my_field = new Field();
        my_field.out();
        String[] arrayShips = {"Авианосца", "Линкора", "Эсминца", "катера"};
        for (int i=0;i<4;i++) {
            for (int j=4-i;j<5;j++) {
            boolean flagMain = false;
            //for (int j = 0; i < line.length; i++) {
            //    System.out.println(line[i]);
            do {
                System.out.printf("Введите координаты %s (%d ячеек):\n", arrayShips[i], 4-i);
            String[] line = scanner.nextLine().split(" ");
            try {
                my_field.accommodation(4-i, line[0],  line[1].charAt(0));}
            catch (AccomodationException e){
                System.out.println("Ошибка! В данное место корабль поставить невозможно. Попробуйте снова:");
                flagMain = true;
            } finally {
                my_field.out();
            }
            } while (flagMain);
            }
            }

        }

}
