
/**
 * Created by Mikhail on 2/21/2016.
 */
abstract class Player {
    private Field ownField = new Field();
    private Field enemyField;
    private boolean isWiner = false;

    abstract void makeTurn();

    public void setShoot(int y, int x) {
        enemyField.setShoot(y, x);
        isWiner = checkIsWinner();
    }

    private boolean checkIsWinner() {
        Cell[][] cells = enemyField.getCells();

        for (int i = 0; i < Game.FIELD_SIZE; i++) {
            for (int j = 0; j < Game.FIELD_SIZE; j++) {
                if (cells[i][j].getCellState() == CellState.SHIP) {
                    return false;
                }
            }
        }

        return true;
    }

    public Field getEnemyField() {
        return enemyField;
    }

    public void setEnemyField(Field enemyField) {
        this.enemyField = enemyField;
    }

    public Field getOwnField() {
        return ownField;
    }

    public void setOwnField(Field ownField) {
        this.ownField = ownField;
    }

    public boolean isWiner() {
        return isWiner;
    }

    public void setWiner(boolean winer) {
        isWiner = winer;
    }
}
