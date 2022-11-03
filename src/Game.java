import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


class Fire {

    private int x;
    private int y;

    public Fire(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Game extends JPanel implements KeyListener, ActionListener {

    Timer timer = new Timer(3,this);


    private int time = 0;
    private int fire = 0;

    private BufferedImage image;

    private ArrayList<Fire> fires = new ArrayList<Fire>();

    private int fireX =1;

    private int ball =0;

    private int balls =2;

    private int spaceShip = 0;

    private int space = 20;

    public boolean control(){

        for (Fire ates :fires) {

            if (new Rectangle(ates.getX(),ates.getY(),10,20).intersects(new Rectangle(ball,0,20,20))){
                return true;
            }

        }
        return false;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        time += 5;


        g.setColor(Color.RED);

        g.fillOval(ball,0,  20,20);

        g.drawImage(image, spaceShip,490,image.getWidth()/10,image.getHeight()/10,this);

        for (Fire firex : fires) {

            if (firex.getY() <0){
                fires.remove(firex);
            }

        }

        g.setColor(Color.ORANGE);

        for (Fire ates : fires) {
            g.fillRect(ates.getX(), ates.getY(),10,20);

        }

        if (control()){
            timer.stop();
            String message = "You won..\n" +
                    "Get Fire :" + fire +
                    "\nTime: " + time /1000.0 + " second" ;
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);

        }



    }

    @Override
    public void repaint() {
        super.repaint();

    }

    public Game() {

        try {
            image = ImageIO.read(new FileImageInputStream(new File("spacerocket.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setBackground(Color.BLACK);


        timer.start();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (Fire ates: fires) {
            ates.setY(ates.getY() - fireX);

        }

        ball += balls;

        if (ball >= 750){
            balls = -balls;
        }

        if (ball <=0){
            balls = -balls;
        }

        repaint();



    }

    @Override
    public void keyTyped(KeyEvent e) {



    }

    @Override
    public void keyPressed(KeyEvent e) {

        int c = e.getKeyCode();

        if (c == KeyEvent.VK_LEFT){
            if (spaceShip <= 0){
                spaceShip =0;
            }else {
                spaceShip -= space;
            }

        }else if (c == KeyEvent.VK_RIGHT){

            if (spaceShip >= 750){
                spaceShip =750;
            }else {
                spaceShip += space;
            }
        }else if (c == KeyEvent.VK_CONTROL){

            fires.add(new Fire(spaceShip +15,470));

            fire++;



        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}