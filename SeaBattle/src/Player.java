/**
 * Created by Mikhail on 2/19/2016.
 */
abstract class Player {
    protected String name;
    protected Field playerField;
    protected Field enemyField;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Field getPlayerField() {
        return playerField;
    }

    public void setPlayerField(Field playerField) {
        this.playerField = playerField;
    }

    public Field getEnemyField() {
        return enemyField;
    }

    public void setEnemyField(Field enemyField) {
        this.enemyField = enemyField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        if (playerField != null ? !playerField.equals(player.playerField) : player.playerField != null) return false;
        return enemyField != null ? enemyField.equals(player.enemyField) : player.enemyField == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (playerField != null ? playerField.hashCode() : 0);
        result = 31 * result + (enemyField != null ? enemyField.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", playerField=" + playerField +
                ", enemyField=" + enemyField +
                '}';
    }

    Player(Field playerField, Field enemyField) {
        this.playerField = playerField;
        this.enemyField = enemyField;
    }

    abstract void makeTurn();

}
