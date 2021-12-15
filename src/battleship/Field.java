package battleship;
import java.util.HashMap;
import java.sql.Array;
import java.util.Arrays;

public class Field {
    char[][] seaField = new char[10][10];
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
                System.out.print(this.seaField[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void error() throws AccomodationException {
        throw new AccomodationException("Error! You placed it too close to another one.");
    }

    public void accommodation(int ship, String place, char direction) throws AccomodationException{
        char[] columns = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'К'};
    int column = new String(columns).indexOf(place.charAt(0));
    int line = Integer.parseInt(place.substring(1)) - 1;
    char[][] tryField = this.seaField;
        try {
        if (direction == '|') {
            for (int i=line;i<line+ship;i++) {
                tryField[i][column] = 'O';
            }
        }
        if (direction == '-') {
            for (int i=column;i<column+ship;i++) {
                tryField[line][i] = 'O';
            }
        }
        boolean f = this.borderShip(ship, column, line, direction);
        System.out.println(f);
        if (f == true) {
        this.seaField = tryField;
        } else {
            throw new ArrayIndexOutOfBoundsException("");
        }
    } catch (ArrayIndexOutOfBoundsException e) {
        this.error();
    }
}

    protected boolean borderShip(int ship, int column, int line, char direction) {
        boolean flag = true;
        if (direction == '-') {
            if (line > 0) {
                int a = column - 1 == -1 ? 0 : column - 1;
                for (int i = a;i<column+ship+1;i++) {
                    if (this.seaField[line-1][a] == 'O') {
                        flag = false;
                    }
                }
            }
            if (column > 0 && this.seaField[line][column-1] == 'O') {
                flag = false;
            }
            if (column < 9 && this.seaField[line][column+ship+1] == 'O') {
                flag = false;
            }
            if (line < 9) {
                int a = column - 1 == -1 ? 0 : column - 1;
                for (int i = a;i<column+ship+1;i++) {
                    if (this.seaField[line+1][a] == 'O') {
                        flag = false;
                    }
                }
            }
        } else {
            if (column > 0) {
                int a = line - 1 == -1 ? 0 : line - 1;
                for (int i = a;i<line+ship+1;i++) {
                    if (this.seaField[a][column-1] == 'O') {
                        flag = false;
                    }
                }
            }
            if (line > 0 && this.seaField[line-1][column] == 'O') {
                flag = false;
            }
            if (line < 9 && this.seaField[line+1+ship][column] == 'O') {
                flag = false;
            }
            if (column < 9) {
                int a = line - 1 == -1 ? 0 : line - 1;
                for (int i = a;i<line+ship+1;i++) {
                    if (this.seaField[a][column+1] == 'O') {
                        flag = false;
                    }
                }
            }
        }
        return flag;

    }
}
