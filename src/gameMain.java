import javax.swing.*;

public class gameMain {

    public static void main(String[] args){
        JFrame frame = new JFrame("Isekai Side Scroller");

        level_one lvlOne = new level_one();

        frame.setBounds(0, 0, 1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(lvlOne);

        frame.setVisible(true);
    }

}
