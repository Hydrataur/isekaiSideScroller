import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class level_one extends level{

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if (mc.isDirection_right())
            g.drawImage(mc.get_char_final_img(), mc.getX(), mc.getY(), mc.getImg_width(), mc.getImg_height(), this);
        else
            g.drawImage(mc.get_char_final_img(), mc.getX() + mc.getImg_width(), mc.getY(), -mc.getImg_width(), mc.getImg_height(), this);

        for (Surface surface : surfaces) {
            g.drawRect(surface.getX(), surface.getY(), surface.getWidth(), surface.getHeight());
        }
    }

    public level_one(){
        super();

        surfaces = new Surface[3];
        surfaces[0] = new Surface(700, 700, 100, 100);
        surfaces[1] = new Surface(200, 700, 100, 100);
        surfaces[2] = new Surface(0, 800, 1000, 5000);

    }
}
