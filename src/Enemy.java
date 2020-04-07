public class Enemy extends character{

    int knockback;

    public Enemy(int x, int y, int max_HP, int movement_speed, String char_image_path, int img_width, int img_height, boolean direction_right, level lvl, int knockback) {
        super(x, y, max_HP, movement_speed, char_image_path, img_width, img_height, direction_right, lvl);
        this.knockback = knockback;
    }

    public int getKnockback() {
        return knockback;
    }
}
