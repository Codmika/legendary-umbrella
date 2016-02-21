/**
 * Created by Mikhail on 2/21/2016.
 */
public class Cell {
    private int x, y;
    private CellState cellState;
    private Ship owner;

    public char getChar() {
        return cellState.getChar();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Ship getOwner() {
        return owner;
    }

    public void setOwner(Ship owner) {
        this.owner = owner;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.cellState = CellState.WATER;
    }

    public Cell(int x, int y, CellState cellState) {
        this.x = x;
        this.y = y;
        this.cellState = cellState;
    }
}
