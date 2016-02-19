/**
 * Created by Mikhail on 2/19/2016.
 */
public class HumanPlayer extends Player {

    HumanPlayer(Field field) {
        super(field);
    }

    @Override
    void makeTurn() {
        System.out.println("HumanPlayer make turn");
    }
}
