import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by Mikhail on 2/16/2016.
 */
public class Field {
    private Cell[][] field = new Cell[Main.FIELD_SIZE][Main.FIELD_SIZE];
    private Ship[] ships = new Ship[10];
    private Random random = new Random();

    public void generateShips() {
        for (int i = 0; i < Array.getLength(Main.SHIPS); i++) {
            int vy;
            int vx;
            do {
                do {
                    vy = random.nextInt(2);
                    vx = random.nextInt(2);
                } while (vy + vx != 1);

            } while (!setShip(
                    random.nextInt(Main.FIELD_SIZE),
                    random.nextInt(Main.FIELD_SIZE),
                    vy,
                    vx,
                    Main.SHIPS[i],
                    i)
                    );
        }
    }

    public boolean setShip(int y1, int x1, int vy, int vx, int size, int shipId) {
        // определяем координату последней палубы (первая всегда самая левая и верхняя)
        int y2 = y1 + (size - 1) * vy;
        int x2 = x1 + (size - 1) * vx;

        if ((y2 > 9) || (x2 > 9)) {
            return false;
        }
        for (int i = ((y1 - 1) < 0) ? 0 : y1 - 1;
                 i < (((y2 + 2) < Main.FIELD_SIZE) ? y2 + 2 : Main.FIELD_SIZE);
                 i++) {
            for (int j = ((x1 - 1) < 0) ? 0 : x1 - 1;
                     j < (((x2 + 2) < Main.FIELD_SIZE) ? x2 + 2 : Main.FIELD_SIZE);
                     j++) {
                for (Ship ship : ships) {
                    if (ship != null) {
                       if (ship.isYourCell(i, j)) {
                           return false;
                       }
                    }
                }
            }
        }

        int[] yx = {y1, x1};
        int[] vec = {vy, vx};
        ships[shipId] = new Ship(size, yx, vec);
        for (int i = yx[0]; i < yx[0]+((size-1)*vec[0]) + 1; i++) {
            for (int j = yx[1]; j < yx[1]+((size-1)*vec[1]) + 1; j++) {
                field[i][j].cellState = CellState.SHIP;
                field[i][j].owner = ships[shipId];
            }
        }
        return true;
    }

    public void printField() {
        for (int i = 0; i <= Main.FIELD_SIZE; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        for (int i = 0; i < Main.FIELD_SIZE; i++) {
            System.out.printf("%3d  ", i+1);

            for (int j = 0; j < Main.FIELD_SIZE; j++) {
                System.out.print(field[i][j].cellState.getChar() + "  ");
            }

            System.out.println();
        }
    }

    public void initField() {
        for (int i = 0; i < Main.FIELD_SIZE; i++) {
            for (int j = 0; j < Main.FIELD_SIZE; j++) {
                field[i][j] = new Cell(i, j, CellState.WATER);
            }
        }
    }

    public void setShoot(int y, int x) {
        if (field[y][x].owner != null) {
            field[y][x].cellState = CellState.HIT;
        }
        else {
            field[y][x].cellState = CellState.MIS;
        }
    }
}
