import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame {

    public GameScreen(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {

        GameScreen screen = new GameScreen("Space Game");

        screen.setResizable(false);
        screen.setFocusable(false);

        screen.setSize(800,600);

        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Game oyun = new Game();

        oyun.requestFocus();

        oyun.addKeyListener(oyun);

        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);

        screen.add(oyun);

        screen.setVisible(true);





    }


}