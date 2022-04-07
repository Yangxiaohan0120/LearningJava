package Project.Tankwar.preprocessing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Chris Yang
 * created 2022-04-07 11:00
 **/
public class KeyBoardControl extends JFrame {

    private MyPanelBall mp;

    public KeyBoardControl() {
        mp = new MyPanelBall();
        this.add(mp);
        this.setSize(600, 400);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        KeyBoardControl keyBoardControl = new KeyBoardControl();
    }
}

class MyPanelBall extends JPanel implements KeyListener {

    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode() + "被按下....");

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }

        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
