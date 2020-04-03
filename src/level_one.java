import java.awt.*;

public class level_one extends level{

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for (character Character : renderedCharacters) {
            if (Character.isDirection_right())
                g.drawImage(Character.get_char_final_img(), Character.getX() - distance, Character.getY(), Character.getImg_width(), Character.getImg_height(), this);
            else
                g.drawImage(Character.get_char_final_img(), Character.getX() + Character.getImg_width() - distance, Character.getY(), -Character.getImg_width(), Character.getImg_height(), this);
        }

        for (Surface surface : surfaces) {
            g.drawRect(surface.getX() - distance, surface.getY(), surface.getWidth(), surface.getHeight());
        }
    }

    public level_one(){
        super();

        surfaces = new Surface[4];
        surfaces[0] = new Surface(700, 750, 100, 50);
        surfaces[1] = new Surface(200, 750, 100, 50);
        surfaces[2] = new Surface(1200, 750, 100, 50);
        surfaces[3] = new Surface(0, 800, 2000, 5000);

    }
}
