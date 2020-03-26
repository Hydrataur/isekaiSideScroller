import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class character {

    private int x;
    private int y;

    private int current_HP;
    private int max_HP;

    private int movement_speed;

    private ImageIcon char_icon;
    private Image char_spritesheet;
    private BufferedImage char_image;

    private int img_width;
    private int img_height;

    private int current_frame;
    private int frames;
    private int frame_rows;
    private int frame_cols;

    private boolean direction_right;

    private level_one lvl;

    public character(int x, int y, int current_HP, int max_HP, int movement_speed, String char_image_path,
                     int img_width, int img_height, boolean direction_right, level_one lvl, int frames, int frame_rows, int frame_cols){
        this.x = x;
        this.y = y;
        this.current_HP = current_HP;
        this.max_HP = max_HP;
        this.movement_speed = movement_speed;
        this.char_icon = new ImageIcon("images/" + char_image_path);
        this.char_spritesheet = char_icon.getImage();
        this.img_width = img_width;
        this.img_height = img_height;
        this.direction_right = direction_right;
        this.current_frame = 0;
        this.lvl = lvl;
        this.frames = frames;
        this.frame_rows = frame_rows;
        this.frame_cols = frame_cols;
    }

    public BufferedImage get_char_final_img(){
        char_image = new BufferedImage(char_spritesheet.getWidth(null) / frame_rows,
                char_spritesheet.getHeight(null) / frame_cols, BufferedImage.TYPE_INT_ARGB);
        Graphics char_graphics = char_image.getGraphics();

        for(int i = 0; i < frame_rows; i++){
            if (current_frame / frame_rows == i)
                char_graphics.drawImage(char_spritesheet, (current_frame % frame_cols) * (-img_width), i * (-img_height), img_width * frame_rows, img_height * frame_cols, lvl);
        }

        current_frame++;
        if (current_frame == frames)
            current_frame = 0;

        return char_image;
    }

}
