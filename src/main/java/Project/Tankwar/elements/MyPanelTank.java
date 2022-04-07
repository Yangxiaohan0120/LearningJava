package Project.Tankwar.elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author Chris Yang
 * created 2022-04-07 14:58
 **/
public class MyPanelTank extends JPanel implements KeyListener {
    Hero hero = null;
    Vector<EnemyTank> Enemies = new Vector<>();
    int enemyTankSize = 3;

    public MyPanelTank() {
        hero = new Hero(100, 100);
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDirect(2);
            Enemies.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
//        drawTank(hero.getX() + 100, hero.getY() + 100, g, 2, 1);

        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = Enemies.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
        }

    }

    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        switch (direct) {
            // 向上
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 10, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            // 向右
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 30, y + 10, 20, 20);
                g.drawLine(x + 60, y + 20, x + 30, y + 20);
                break;
            // 向下
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 30, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            // 向左：
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 10, y + 10, 20, 20);
                g.drawLine(x, y + 20, x + 30, y + 20);
                break;
            default:
                System.out.println("");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode() + "被按下....");

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDirect(3);
            hero.moveLeft();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
