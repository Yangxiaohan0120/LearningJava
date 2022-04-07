package Project.Tankwar.preprocessing;

import Project.Tankwar.elements.MyPanelTank;

import javax.swing.*;

/**
 * @author Chris Yang
 * created 2022-04-07 14:53
 **/
public class TankMove extends JFrame{
    private MyPanelTank mp;

    public TankMove(){
        mp = new MyPanelTank();
        this.add(mp);
        this.setSize(500,400);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TankMove tankMove = new TankMove();
    }
}



