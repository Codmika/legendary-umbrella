import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by Mikhail on 2/21/2016.
 */
public class Field {

    private Cell[][] cells = new Cell[Game.FIELD_SIZE][Game.FIELD_SIZE];
    private Ship[] ships = new Ship[10];
    private Random random = new Random();

    public Field() {
        initField();
        generateShips();
    }

    private void initField() {
        for (int i = 0; i < Game.FIELD_SIZE; i++) {
            for (int j = 0; j < Game.FIELD_SIZE; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    private void generateShips() {
        for (int i = 0; i < Array.getLength(Game.SHIPS); i++) {
            int vy;
            int vx;
            do {
                do {
                    vy = random.nextInt(2);
                    vx = random.nextInt(2);
                } while (vy + vx != 1);

            } while (!setShip(
                    Game.SHIPS[i],
                    random.nextInt(Game.FIELD_SIZE),
                    random.nextInt(Game.FIELD_SIZE),
                    vy,
                    vx,
                    i)
                    );
        }
    }

    public boolean setShip(int size, int y1, int x1, int vy, int vx, int shipId) {
        // определяем координату последней палубы (первая всегда самая левая и верхняя)
        int y2 = y1 + (size - 1) * vy;
        int x2 = x1 + (size - 1) * vx;

        if ((y2 > 9) || (x2 > 9)) {
            return false;
        }
        for (int i = ((y1 - 1) < 0) ? 0 : y1 - 1;
             i < (((y2 + 2) < Game.FIELD_SIZE) ? y2 + 2 : Game.FIELD_SIZE);
             i++) {
            for (int j = ((x1 - 1) < 0) ? 0 : x1 - 1;
                 j < (((x2 + 2) < Game.FIELD_SIZE) ? x2 + 2 : Game.FIELD_SIZE);
                 j++) {
                for (Ship ship : ships) {  //Здесь модно просто обращаться к ячейке и проверять есть ли owner
                    if (ship != null) {
                        if (ship.isYourCell(i, j)) {
                            return false;
                        }
                    }
                }
            }
        }

        ships[shipId] = new Ship(size, y1, x1, vy, vx);
        for (int i = y1; i < y1+((size-1)*vy) + 1; i++) {
            for (int j = x1; j < x1+((size-1)*vx) + 1; j++) {
                cells[i][j].setCellState(CellState.SHIP);
                cells[i][j].setOwner(ships[shipId]);
            }
        }
        return true;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Ship[] getShips() {
        return ships;
    }

    public void setShips(Ship[] ships) {
        this.ships = ships;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void setShoot(int y, int x) {
        if (cells[y][x].getOwner() != null) {
            cells[y][x].setCellState(CellState.HIT);
        }
        else {
            cells[y][x].setCellState(CellState.MIS);
        }
    }
}
