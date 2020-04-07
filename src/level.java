import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class level extends JPanel implements ActionListener {

    Surface[] surfaces;
    character[] characters;
    character[] renderedCharacters;

    Timer timer;

    Distance distance;

    public level(){
        distance = new Distance();

        characters = new character[2];
        characters[0] = new protag(400, 500, 10, 10, this);

        characters[1] = new EnemyRoller(1000, 500, true, this);

        renderedCharacters = general_functions.returnRenderedCharacterArray(characters, 1920, 1080, distance.getxDis());

        addKeyListener(new Keys());
        setFocusable(true);

        timer = new Timer(45, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderedCharacters = general_functions.returnRenderedCharacterArray(characters, 1920, 1080, distance.getxDis());
        for (character Character : renderedCharacters) {
            distance.setxDis(Character.handle_movement(surfaces, distance.getxDis()));
            if (Character instanceof Enemy)
                if (general_functions.checkEnemyCollisions((protag) characters[0], (Enemy) Character))
                    general_functions.playerEnemyInteraction((protag) characters[0], (Enemy) Character, surfaces, distance);
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
