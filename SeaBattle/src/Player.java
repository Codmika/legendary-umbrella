/**
 * Created by Mikhail on 2/19/2016.
 */
abstract class Player {
    protected String name;
    protected Field field;

    Player(Field field) {
        this.field = field;
    }

    abstract void makeTurn();
}
