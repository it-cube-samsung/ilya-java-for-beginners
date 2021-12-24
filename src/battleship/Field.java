package battleship;
import java.sql.Array;
import java.util.Arrays;

public class Field {
    char[][] seaField = new char[10][10];
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    Field(){
        for (int i=0; i<10;i++) {
            for (int j=0;j<10;j++) {
                seaField[i][j] = '~';
            }

        }
    }

    public void out() {
        System.out.println("   А Б В Г Д Е Ж З И К");
        for (int i=0; i<10;i++) {
            if (i < 9) {
                System.out.printf("%d  ", i+1);
            }
            else {
                System.out.printf("%d ", i+1);
            }

            for (int j=0;j<10;j++) {
                if (this.seaField[i][j] == '~') {
                    System.out.print(ANSI_CYAN_BACKGROUND + this.seaField[i][j] + " " + ANSI_RESET);
                } else {
                    System.out.print(ANSI_WHITE_BACKGROUND + this.seaField[i][j] + " " + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

    public void filling(Ship ship) {
        for (int i=0;i<ship.coordinates.length;i++) {
            int line = Integer.parseInt(ship.coordinates[i].substring(1));
            int column = transformation(ship.coordinates[i].substring(0, 1));
            this.seaField[line-1][column-1] = 'O';

        }
    }

    public static int transformation(String place) {
        String letters  = "АБВГДЕЖЗИК";
        return letters.indexOf(place.charAt(0)) + 1;
    }

}
