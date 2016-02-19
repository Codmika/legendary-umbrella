/**
 * Created by Mikhail on 2/18/2016.
 */
public class Cell {
    int x, y;
    CellState cellState;
    Ship owner;

    public Cell(int x, int y, CellState cellState) {
        this.x = x;
        this.y = y;
        this.cellState = cellState;
    }
}
