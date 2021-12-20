package battleship;

public class Ship {
    String name;
    int length;
    String[] coordinates;
    String[] paddedPlaces;
    char definition;


    Ship(int length, String name, int line, int column, char definition){
        this.name = name;
        this.length = length;
        this.coordinates = new String[length];
        this.definition = definition;
        String[] letters  = {"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К"};
        if (definition == '-') {
            for (int i=line;i<line+length;i++) {
            this.coordinates[i-line] = (letters[i-1] + Integer.toString(column));
            System.out.print(this.coordinates[i-line] + " ");
        }

        } else {
            for (int i=column;i<column+length;i++) {
                this.coordinates[i-column] = (letters[line-1] + Integer.toString(i));
                System.out.print(this.coordinates[i-column] + " ");
            }
        }
        System.out.println();

    }
}
