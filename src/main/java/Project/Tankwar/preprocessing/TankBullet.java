package Project.Tankwar.preprocessing;

import Project.Tankwar.elements.MyPanelTank;

import javax.swing.*;

/**
 * @author Chris Yang
 * created 2022-04-11 20:40
 **/
public class TankBullet extends JFrame {
    MyPanelTank mp = null;

    public static void main(String[] args) {
        TankBullet tankBullet = new TankBullet();

    }

    public TankBullet(){
        mp = new MyPanelTank();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);

        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
