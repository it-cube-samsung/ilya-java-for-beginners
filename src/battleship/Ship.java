package battleship;

public class Ship {
    String name;
    int length;
    String[] coordinates;
    String[] paddedPlaces;
    char definition;


    Ship(int length, String name, int line, int column, char definition) {
        this.name = name;
        this.length = length;
        this.coordinates = new String[length];
        this.definition = definition;
        String[] letters = {"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К"};
        if (definition == '-') {
            for (int i = column; i < column + length; i++) {
                this.coordinates[i - column] = (letters[i - 1] + Integer.toString(line));
                //System.out.print(this.coordinates[i - column] + " ");
            }
        } else {
            for (int i = line; i < line + length; i++) {
                this.coordinates[i - line] = (letters[column - 1] + Integer.toString(i));
                //System.out.print(this.coordinates[i - line] + " ");
            }
        }
        //System.out.println();

    }

    public static int transformation(String place) {
        String letters = "АБВГДЕЖЗИК";
        return letters.indexOf(place.charAt(0));
    }

    boolean crossingRect(String place, int length, String direction) {
        int xOther = transformation(place.substring(0, 1));
        int yOther = Integer.parseInt(place.substring(1));
        int x1Other;
        int y1Other;
        if (direction.equals("-")) {
            y1Other = yOther;
            x1Other = xOther - 1 + length;
        } else {
            y1Other = yOther - 1 + length;
            x1Other = xOther;
        }
        int xMy = transformation(this.coordinates[0].substring(0, 1)) - 1;
        int yMy = Integer.parseInt(this.coordinates[0].substring(1)) - 1;
        int x1My = transformation(this.coordinates[this.coordinates.length - 1].substring(0, 1)) + 1;
        int y1My = Integer.parseInt(this.coordinates[this.coordinates.length - 1].substring(1)) + 1;
        return (
                (
                        (
                                (xMy >= xOther && xMy <= x1Other) || (x1My >= xOther && x1My <= x1Other)
                        ) && (
                                (yMy >= yOther && yMy <= y1Other) || (y1My >= yOther && y1My <= y1Other)
                        )
                ) || (
                        (
                                (xOther >= xMy && xOther <= x1My) || (x1Other >= xMy && x1Other <= x1My)
                        ) && (
                                (yOther >= yMy && yOther <= y1My) || (y1Other >= yMy && y1Other <= y1My)
                        )
                )
        ) || (
                (
                        (
                                (xMy >= xOther && xMy <= x1Other) || (x1My >= xOther && x1My <= x1Other)
                        ) && (
                                (yOther >= yMy && yOther <= y1My) || (y1Other >= yMy && y1Other <= y1My)
                        )
                ) || (
                        (
                                (xOther >= xMy && xOther <= x1My) || (x1Other >= xMy && x1Other <= x1My)
                        ) && (
                                (yMy >= yOther && yMy <= y1Other) || (y1My >= yOther && y1My <= y1Other)
                        )
                )
        );
    }
}
