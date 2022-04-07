package Project.Tankwar.preprocessing;

import Project.Tankwar.elements.MyPanelTank;

import javax.swing.*;

/**
 * @author Chris Yang
 * created 2022-04-07 10:30
 **/
public class DrawTanker extends JFrame {
    private MyPanelTank mp;

    public DrawTanker() {
        mp = new MyPanelTank();
        this.add(mp);
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        DrawTanker drawTanker = new DrawTanker();
    }
}


