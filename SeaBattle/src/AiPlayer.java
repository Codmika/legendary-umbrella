import java.util.Random;

/**
 * Created by Mikhail on 2/19/2016.
 */
public class AiPlayer extends Player {
    Random random = new Random();

    AiPlayer(Field field) {
        super(field);
    }

    @Override
    void makeTurn() {
        int y = random.nextInt(10);
        int x = random.nextInt(10);

        field.setShoot(y, x);

        System.out.println("aiPlayer make turn");
    }
}
