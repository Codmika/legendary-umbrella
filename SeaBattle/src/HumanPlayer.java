import java.util.Scanner;

/**
 * Created by Mikhail on 2/19/2016.
 */
public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);

    HumanPlayer(Field playerField, Field enemyField) {
        super(playerField, enemyField);
    }

    @Override
    void makeTurn() {
        System.out.println("Введите X и Y координаты...");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        enemyField.setShoot(y-1, x-1);

        System.out.println("Вы выстрелили в координату " + x + " " + y);
    }
}
