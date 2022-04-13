package Project.Tankwar.elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

/**
 * @author Chris Yang
 * created 2022-04-07 14:58
 **/

// 使得Panel不停的重绘子弹，需要继承Runnable
public class MyPanelTank extends JPanel implements KeyListener, Runnable {
    // 我的坦克
    Hero hero = null;
    // 定义Bomb
    Vector<Bomb> bombs = new Vector<>();
    // 敌人的坦克
    Vector<EnemyTank> Enemies = new Vector<>();
    int enemyTankSize = 3;

    // 定义三张图片展示爆炸效果
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanelTank() {
        hero = new Hero(500, 100);
        for (int i = 0; i < enemyTankSize; i++) {
            // 创建敌人的坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            // 设置坦克的方向
            enemyTank.setDirect(2);
            // 设置线程，让这个坦克动起来
            new Thread(enemyTank).start();
            // 给这个敌人坦克加上一个子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            // 启动shot对象
            new Thread(shot).start();
            Enemies.add(enemyTank);

        }

        // 初始化图片爆炸效果
        image1 = Toolkit.getDefaultToolkit().getImage(new File("/Users/yxh/IntelliJProjects/LearningJava/src/main/java/Project/Tankwar/elements/bomb_1.gif").getAbsolutePath());
        image2 = Toolkit.getDefaultToolkit().getImage(new File("/Users/yxh/IntelliJProjects/LearningJava/src/main/java/Project/Tankwar/elements/bomb_2.gif").getAbsolutePath());
        image3 = Toolkit.getDefaultToolkit().getImage(new File("/Users/yxh/IntelliJProjects/LearningJava/src/main/java/Project/Tankwar/elements/bomb_3.gif").getAbsolutePath());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        if (hero != null && hero.isLive) {
            // 如果自己的坦克还活着，就绘制出来
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }

        // ========= 单个子弹
//        if (hero.shot != null && hero.shot.isLive == true) {
//            // 如果自己的子弹还有就也绘制出来
//            System.out.println("子弹被绘制");
//            g.draw3DRect(hero.shot.x, hero.shot.y, 1, 1, false);
//        }

        // ========= 绘制子弹合集
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive) {
                g.draw3DRect(shot.x, shot.y, 1, 1, false);
            } else {
                hero.shots.remove(shot);
            }
        }

        // ========= 如果有中弹的，则绘制
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDown();
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }


        // ========= 绘制出仍存活的敌人
        for (int i = 0; i < Enemies.size(); i++) {
            EnemyTank enemyTank = Enemies.get(i);
            if (enemyTank.isLive) { // 判断是否存活
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                // 绘制对应的子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);

                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }

    }

    // =========== 绘制坦克
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
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            // 向右
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            // 向下
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            // 向左：
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("");
        }
    }


    // =========== 射击敌人
    public void hitEnemyTank() {

        //  ========  子弹合集
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);

            if (shot != null && hero.shot.isLive) {
                for (int j = 0; j < Enemies.size(); j++) {
                    EnemyTank enemyTank = Enemies.get(j);
                    hitTank(hero.shot, enemyTank);
                }
            }
        }

        // ========  单颗子弹
//        if(hero.shot != null && hero.shot.isLive){
//            for (int i = 0; i < Enemies.size(); i++) {
//                EnemyTank enemyTank = Enemies.get(i);
//                hitTank(hero.shot,enemyTank);
//            }
//        }
    }

    // ======== 判断是否击中我
    //编写方法，判断敌人坦克是否击中我的坦克
    public void hitHero() {
        //遍历所有的敌人坦克
        for (int i = 0; i < Enemies.size(); i++) {
            //取出敌人坦克
            EnemyTank enemyTank = Enemies.get(i);
            //遍历enemyTank 对象的所有子弹
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                //取出子弹
                Shot shot = enemyTank.shots.get(j);
                //判断 shot 是否击中我的坦克
                if (hero.isLive && shot.isLive) {
                    hitTank(shot, hero);
                }
            }
        }
    }


    //编写方法，判断我方的子弹是否击中敌人坦克.
    //什么时候判断 我方的子弹是否击中敌人坦克 ? run方法
    //后面我们将 enemyTank 改成 tank名称
    public void hitTank(Shot s, Tank enemyTank) {
        //判断s 击中坦克
        switch (enemyTank.getDirect()) {
            case 0: //坦克向上 向上与向下所占据的长方形一致一起判断
            case 2: //坦克向下
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //当我的子弹击中敌人坦克后，将enemyTank 从Vector 拿掉
                    Enemies.remove(enemyTank);
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1: //坦克向右
            case 3: //坦克向左
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    //创建Bomb对象，加入到bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode() + "被按下....");

        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {

            // 判断子弹是否销毁，一颗子弹
//            if (hero.shot == null || !hero.shot.isLive) {
//                System.out.println("用户按下了J，开始射击");
//                hero.shotEnemyTank();
//            }
            // 多颗子弹
             hero.shotEnemyTank();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 判断是否击中敌人
            hitEnemyTank();

            // 判断是否击中我
            hitHero();

            this.repaint();
        }
    }
}
