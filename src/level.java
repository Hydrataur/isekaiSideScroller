import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class level extends JPanel implements ActionListener {

    Timer timer;

    protag mc;

    public level(){
        mc = new protag(0, 0, 0, 0, 0, this);

        addKeyListener(new Keys());
        setFocusable(true);

        timer = new Timer(45, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (mc.isMoving_right())
            mc.setX(mc.getX() + 10);
        if (mc.isMoving_left())
            mc.setX(mc.getX() - 10);

        repaint();
    }

    private class Keys extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_D)
                mc.setMoving_right(true);

            if (key == KeyEvent.VK_A)
                mc.setMoving_left(true);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_D)
                mc.setMoving_right(false);

            if (key == KeyEvent.VK_A)
                mc.setMoving_left(false);
        }
    }

}
