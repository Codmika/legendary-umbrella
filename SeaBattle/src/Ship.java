/**
 * Created by Mikhail on 2/16/2016.
 */
public class Ship {
    private int size;
    private int[] yx1;
    private int[] vector; // 1,0 - ввниз; 0,1 - вправо
    private boolean isAlive = true;

    public Ship() {

    }

    public Ship(int size, int[] yx1, int[] vector) {
        this.size = size;
        this.yx1 = yx1;
        this.vector = vector;
    }

    public boolean isYourCell(int y, int x) {
        if (y == yx1[0]) {
            if ((x >= yx1[1]) && (x < yx1[1] + size)){
                return true;
            }
        } else if (x == yx1[1]) {
            if ((y >= yx1[0]) && (y < yx1[0] + size)){
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getCoodinate() {
        return yx1;
    }

    public void setCoodinate(int[] coodinate) {
        this.yx1 = coodinate;
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
