import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * Created by Mikhail on 2/21/2016.
 */
public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void makeTurn() {
        System.out.println("Введите X и Y координаты...");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        setShoot(y-1, x-1);
    }
}
