import java.util.SortedMap;

/**
 * Created by Mikhail on 2/21/2016.
 */
public class Game {
    public static final int FIELD_SIZE = 10;
    public static final int[] SHIPS = {1,1,1,1,2,2,2,3,3,4};

    private AiPlayer player = new AiPlayer();
    private AiPlayer ai = new AiPlayer();

    public Game() {
        player.setEnemyField(ai.getOwnField());
        ai.setEnemyField(player.getOwnField());

        while (!(player.isWiner() || ai.isWiner())) {
            ai.makeTurn();
            player.makeTurn();
            FieldViewer.printPlayerField(player.getOwnField());
            FieldViewer.printEnemyField(player.getEnemyField());
        }

        if (player.isWiner()) {
            System.out.println("Вы победили!");
        } else {
            System.out.println("Вы проиграли...");
        }
    }
}
