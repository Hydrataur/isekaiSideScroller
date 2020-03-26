import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class level_one extends JPanel implements ActionListener {

    Timer timer;

    protag mc;

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(mc.get_char_final_img(), 50, 50, 320, 320, this);
    }

    public level_one(){
        mc = new protag(0, 0, 0, 0, 0, this);

        timer = new Timer(500, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }
}
