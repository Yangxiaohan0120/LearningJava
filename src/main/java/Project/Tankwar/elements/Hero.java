package Project.Tankwar.elements;

import java.util.Vector;

/**
 * @author Chris Yang
 * created 2022-04-07 14:57
 **/

public class Hero extends Tank {
    Shot shot = null;

    //可以发射多颗子弹
    Vector<Shot> shots = new Vector<>();

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank() {

        if(shots.size() == 5){
            return;
        }

        switch (getDirect()) {
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break; ///
                ///// 错误的最终源头：！！！ 终于找到了，原来是忘记了break，会一直循环到下一个选项，具体原文本参照test.java注释版
            case 1: //向右
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2: //向下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3: //向左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        // 把新创建的shot放到shots中
        shots.add(shot);
        //启动我们的Shot线程
        new Thread(shot).start();
    }
}

