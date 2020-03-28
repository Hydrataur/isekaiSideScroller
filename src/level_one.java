import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class level_one extends level{

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(mc.get_char_final_img(), mc.getX(), mc.getY(), 320, 320, this);
    }

    public level_one(){
        super();
    }
}
