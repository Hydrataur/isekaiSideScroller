public class EnemyGoblinShooter extends Enemy{

    EnemyProjectile projectile;

    public EnemyGoblinShooter(int x, int y, level lvl) {
        super(x, y, 5, 0, "Goblin Shooter.gif", 32, 46, false, lvl, 0);
    }
}
