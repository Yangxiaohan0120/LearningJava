package Project.Tankwar.preprocessing;

import Project.Tankwar.elements.MyPanelTank;

import javax.swing.*;

/**
 * @author Chris Yang
 * created 2022-04-11 21:55
 **/
public class TankBomb extends JFrame {
    MyPanelTank mp = null;

    public TankBomb(){
        mp = new MyPanelTank();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);

        this.setSize(1200,950);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TankBomb tankBomb = new TankBomb();
    }


}
