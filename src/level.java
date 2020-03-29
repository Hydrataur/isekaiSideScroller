import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class level extends JPanel implements ActionListener {

    surface[] surfaces;

    Timer timer;

    protag mc;

    public level(){
        mc = new protag(400, 0, 0, 0, 10, this);

        addKeyListener(new Keys());
        setFocusable(true);

        timer = new Timer(45, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (mc.isMoving_right())
            if (!general_functions.checkCollisions(mc, surfaces))
                mc.setX(mc.getX() + mc.getMovement_speed());

        if (mc.isMoving_left())
            if (!general_functions.checkCollisions(mc, surfaces))
                mc.setX(mc.getX() - mc.getMovement_speed());

        repaint();
    }

    private class Keys extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();

            switch (key){
                case KeyEvent.VK_D:
                    mc.setMoving_right(true);
                    mc.setDirection_right(true);
                    break;
                case KeyEvent.VK_A:
                    mc.setMoving_left(true);
                    mc.setDirection_right(false);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);

            int key = e.getKeyCode();

            switch (key){
                case KeyEvent.VK_D:
                    mc.setMoving_right(false);
                    break;
                case KeyEvent.VK_A:
                    mc.setMoving_left(false);
                    break;
            }
        }
    }

}
