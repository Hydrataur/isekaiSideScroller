import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class character {

    int x;
    int y;

    boolean falling;
    int falling_velocity;

    int current_HP;
    int max_HP;

    int movement_speed;

    ImageIcon char_icon;
    Image char_image;

    int img_width;
    int img_height;

    boolean direction_right;

    boolean moving_right;
    boolean moving_left;

    level lvl;

    public character(int x, int y, int max_HP, int movement_speed, String char_image_path,
                     int img_width, int img_height, boolean direction_right, level lvl){
        this.x = x;
        this.y = y;
        this.current_HP = max_HP;
        this.max_HP = max_HP;
        this.movement_speed = movement_speed;
        this.char_icon = new ImageIcon("images/" + char_image_path);
        this.char_image = char_icon.getImage();
        this.img_width = img_width;
        this.img_height = img_height;
        this.direction_right = direction_right;
        this.lvl = lvl;
    }

    public Image get_char_final_img(){
        if (moving_left || moving_right)
            char_icon = new ImageIcon("images/roller.gif");
        char_image = char_icon.getImage();
        return char_image;
    }

    public int handle_movement(Surface[] surfaces, int distance){
        if (this.isMoving_right())
            if (!general_functions.checkHorizontalCollisions(this, surfaces)) {
                this.setX(this.getX() + this.getMovement_speed());
                if (this instanceof protag)
                    distance += this.getMovement_speed();
            }
        if (this.isMoving_left())
            if (!general_functions.checkHorizontalCollisions(this, surfaces)) {
                this.setX(this.getX() - this.getMovement_speed());
                if (this instanceof protag)
                    distance -= this.getMovement_speed();
            }

        if (general_functions.checkVerticalCollisions(this, surfaces)) {
            falling = false;
            falling_velocity = 0;
        }
        else {
            falling = true;
            falling_velocity += 10;
            y += falling_velocity;
        }

        general_functions.checkVerticalCollisions(this, surfaces);

        return distance;
    }

    public void jump(){
        if (falling)
            return;
        falling = true;
        falling_velocity = -50;
        y -= 1;
    }

    public int getCurrent_HP() {
        return current_HP;
    }

    public void setCurrent_HP(int current_HP) {
        this.current_HP = current_HP;
    }

    public boolean isDirection_right() {
        return direction_right;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getImg_width() {
        return img_width;
    }

    public int getImg_height() {
        return img_height;
    }

    public boolean isMoving_right() {
        return moving_right;
    }

    public void setMoving_right(boolean moving_right) {
        this.moving_right = moving_right;
    }

    public boolean isMoving_left() {
        return moving_left;
    }

    public void setMoving_left(boolean moving_left) {
        this.moving_left = moving_left;
    }

    public int getMovement_speed() {
        return movement_speed;
    }

    public void setDirection_right(boolean direction_right) {
        this.direction_right = direction_right;
    }

    public boolean isFalling() {
        return falling;
    }

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public int getFalling_velocity() {
        return falling_velocity;
    }

    public void setFalling_velocity(int falling_velocity) {
        this.falling_velocity = falling_velocity;
    }
}
