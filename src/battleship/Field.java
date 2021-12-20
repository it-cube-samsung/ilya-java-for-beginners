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


}
