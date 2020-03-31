import javax.swing.*;
import java.awt.*;

public class protag extends character {

    public protag(int x, int y, int current_HP, int max_HP, int movement_speed, level lvl) {
        super(x, y, current_HP, max_HP, movement_speed, "protag_walk.gif", 54, 96,true, lvl);
    }

    @Override
    public Image get_char_final_img() {
        if (moving_left || moving_right)
            char_icon = new ImageIcon("images/protag_walk.gif");
        else
            char_icon = new ImageIcon("images/protag_standing.png");
        char_image = char_icon.getImage();
        return char_image;
    }
}
