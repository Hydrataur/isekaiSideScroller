import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class level_one extends JPanel implements ActionListener {

    Timer timer;

    int i = 0;

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        ImageIcon protagIcon = new ImageIcon("images/protag.png");
        Image protagImage = protagIcon.getImage();
        BufferedImage protagFrame = new BufferedImage(protagImage.getWidth(null)/3, protagImage.getHeight(null)/3, BufferedImage.TYPE_INT_ARGB);
        Graphics protagGraphics = protagFrame.getGraphics();
        if (i/3 == 0)
            protagGraphics.drawImage(protagImage, -32 * i, 0, 96, 96, this);
        if (i/3 == 1)
            protagGraphics.drawImage(protagImage, -32 * (i % 3), -32, 96, 96, this);
        if (i/3 == 2)
            protagGraphics.drawImage(protagImage, -32 * (i % 3), -64, 96, 96, this);
        g.drawImage(protagFrame, 50, 50, 320, 320, this);
    }

    public level_one(){
        timer = new Timer(500, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        i++;
        if (i == 8)
            i = 0;
        repaint();
    }
}
