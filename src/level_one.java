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

        for (surface surf : surfaces) {
            g.drawRect(surf.getX(), surf.getY(), surf.getWidth(), surf.getHeight());
        }
    }

    public level_one(){
        super();

        surfaces = new surface[2];
        surfaces[0] = new surface(700, 0, 100, 100);
        surfaces[1] = new surface(200, 0, 100, 100);

    }
}
