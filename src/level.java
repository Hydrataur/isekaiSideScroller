import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class level extends JPanel implements ActionListener {

    Surface[] surfaces;
    character[] characters;

    Timer timer;

    int distance;

    public level(){
        characters = new character[2];
        characters[0] = new protag(400, 500, 0, 0, 10, this);

        characters[1] = new Enemy(1000, 500, 0, 0, 5, "roller.gif", 54, 54, true, this);
        characters[1].setMoving_right(true);
        characters[1].setMoving_left(false);

        distance = 0;

        addKeyListener(new Keys());
        setFocusable(true);

        timer = new Timer(45, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (character Character : characters) {
            distance = Character.handle_movement(surfaces, distance);
        }
        repaint();
    }

    private class Keys extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();

            switch (key){
                case KeyEvent.VK_D:
                    characters[0].setMoving_right(true);
                    characters[0].setMoving_left(false);
                    characters[0].setDirection_right(true);
                    break;
                case KeyEvent.VK_A:
                    characters[0].setMoving_right(false);
                    characters[0].setMoving_left(true);
                    characters[0].setDirection_right(false);
                    break;
                case KeyEvent.VK_SPACE:
                    characters[0].jump();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);

            int key = e.getKeyCode();

            switch (key){
                case KeyEvent.VK_D:
                    characters[0].setMoving_right(false);
                    break;
                case KeyEvent.VK_A:
                    characters[0].setMoving_left(false);
                    break;
            }
        }
    }

}
