import java.util.Random;

/**
 * Created by Mikhail on 2/19/2016.
 */
public class AiPlayer extends Player {
    Random random = new Random();

    AiPlayer(Field playerField, Field enemyField) {
        super(playerField, enemyField);
    }

    @Override
    void makeTurn() {
        int y = random.nextInt(10);
        int x = random.nextInt(10);

        enemyField.setShoot(y, x);

        System.out.println("Компьютер выстрелил в координату " + (x+1) + " " + (y+1));
    }
}
