public class EnemyRoller extends Enemy{

    public EnemyRoller(int x, int y, boolean direction_right, level lvl) {
        super(x, y, 5, 5, "roller.gif", 54, 54, direction_right, lvl, 30);
        this.setMoving_right(true);
        this.setMoving_left(false);
    }
}
