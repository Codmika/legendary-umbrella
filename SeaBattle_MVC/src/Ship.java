/**
 * Created by Mikhail on 2/21/2016.
 */
public class Ship {
    private int size;
    private int y1, x1;
    private int vy, vx; // 1,0 - ввниз; 0,1 - вправо
    private boolean isAlive = true;

    public Ship(int size, int y1, int x1, int vy, int vx) {
        this.size = size;
        this.y1 = y1;
        this.x1 = x1;
        this.vy = vy;
        this.vx = vx;
    }

    public boolean isYourCell(int y, int x) {
        if (y == y1) {
            if ((x >= x1) && (x < x1 + size)){
                return true;
            }
        } else if (x == x1) {
            if ((y >= y1) && (y < y1 + size)){
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

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
