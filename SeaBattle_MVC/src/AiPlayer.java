import java.util.Random;

/**
 * Created by Mikhail on 2/21/2016.
 */
public class AiPlayer extends Player {
    Random random = new Random();

    @Override
    void makeTurn() {
        int y = random.nextInt(10);
        int x = random.nextInt(10);

        setShoot(y, x);
    }
}
