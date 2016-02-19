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
    public static Field humanField = new Field();
    public static Field aiField = new Field();


    public static void main(String[] args) {
        humanField.initField();
        humanField.generateShips();
        aiField.initField();
        aiField.generateShips();

        AiPlayer aiPlayer = new AiPlayer(aiField, humanField);
        HumanPlayer humanPlayer = new HumanPlayer(humanField, aiField);

        aiField.printEnemyField();
        humanField.printPlayerField();

        while (!isAnyoneWin(humanField, aiField)){
            humanPlayer.makeTurn();
            aiField.printEnemyField();
            humanField.printPlayerField();
            aiPlayer.makeTurn();
            aiField.printEnemyField();
            humanField.printPlayerField();
        }

        if(isPlayerWin(aiField)) {
            System.out.println("Вы победили!!");
        } else {
            System.out.println("Вы проиграли :(");
        }

    }

    private static boolean isAnyoneWin(Field field1, Field field2) {
        boolean field1Status = isPlayerWin(field1);
        boolean field2Status = isPlayerWin(field2);

        return (field1Status || field2Status);
    }

    private static boolean isPlayerWin(Field field) {
        Cell[][] cells = field.getField();

        for (int i = 0; i < Main.FIELD_SIZE; i++) {
            for (int j = 0; j < Main.FIELD_SIZE; j++) {
                if (cells[i][j].cellState == CellState.SHIP) {
                    return false;
                }
            }
        }

        return true;
    }
}
