/**
 * Created by Mikhail on 2/21/2016.
 */
public class FieldViewer {

    public static void printPlayerField(Field field) {
        Cell[][] cells = field.getCells();
        for (int i = 0; i <= Game.FIELD_SIZE; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        for (int i = 0; i < Game.FIELD_SIZE; i++) {
            System.out.printf("%3d  ", i+1);

            for (int j = 0; j < Game.FIELD_SIZE; j++) {
                System.out.print(cells[i][j].getChar() + "  ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void printEnemyField(Field field) {
        Cell[][] cells = field.getCells();
        for (int i = 0; i <= Game.FIELD_SIZE; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        for (int i = 0; i < Game.FIELD_SIZE; i++) {
            System.out.printf("%3d  ", i+1);

            for (int j = 0; j < Game.FIELD_SIZE; j++) {
                char c = cells[i][j].getChar();
                System.out.print((c == 'O')? "~" : c);
                System.out.print("  ");
            }

            System.out.println();
        }

        System.out.println();
    }
}
