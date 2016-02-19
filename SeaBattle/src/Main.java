/**
 * Created by Mikhail on 2/12/2016.
 */
public class Main {
    public static final int FIELD_SIZE = 10;
    /*
    Задаем массив где кол-во элементов равно количеству кораблей на поле, а их значения равны количеству палуб у корабля.
    Прием взят из курса Java0
    */
    public static final int[] SHIPS = {1,1,1,1,2,2,2,3,3,4};
    public static Field gameField = new Field();

    public static void main(String[] args) {
        gameField.initField();
        gameField.generateShips();

        AiPlayer aiPlayer = new AiPlayer(gameField);

        for (int i = 0; i < 10; i++) {
            aiPlayer.makeTurn();
        }

        gameField.printField();
    }

}
