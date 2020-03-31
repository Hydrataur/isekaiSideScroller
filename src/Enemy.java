public class Enemy extends character{

    public Enemy(int x, int y, int current_HP, int max_HP, int movement_speed, String char_image_path, int img_width, int img_height, boolean direction_right, level lvl) {
        super(x, y, current_HP, max_HP, movement_speed, char_image_path, img_width, img_height, direction_right, lvl);
    }
}
