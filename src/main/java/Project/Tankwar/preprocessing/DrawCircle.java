package Project.Tankwar.preprocessing;

import javax.swing.*;
import java.awt.*;

/**
 * @author Chris Yang
 * created 2022-04-07 10:18
 **/
public class DrawCircle extends JFrame {
    private MyPaneltest mp = null;

    public DrawCircle(){
        mp = new MyPaneltest();
        this.add(mp);
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DrawCircle();
    }
}


class MyPaneltest extends JPanel{

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawOval(100,100,100,100);
        g.drawLine(100,100,100,100);
        g.drawRect(100,100,100,100);

        g.setColor(Color.ORANGE);
        g.fillRect(100,100,100,100);

        g.setColor(Color.BLUE);
        g.fillOval(100,10,100,100);


    }
}
