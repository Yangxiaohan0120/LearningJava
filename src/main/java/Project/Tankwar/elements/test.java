package Project.Tankwar.elements;

/**
 * @author Chris Yang
 * created 2022-04-11 21:48
 **/

//public class Hero extends Tank {
//    Shot shot = null;
//
//    public Hero(int x, int y) {
//        super(x, y);
//    }
//
//    public void shotEnemyTank() {
//        switch (getDirect()) {
//            case 0:
//                shot = new Shot(getX() + 20, getY(), 0);
//            case 1: //向右
//                shot = new Shot(getX() + 60, getY() + 20, 1);
//                break;
//            case 2: //向下
//                shot = new Shot(getX() + 20, getY() + 60, 2);
//                break;
//            case 3: //向左
//                shot = new Shot(getX() , getY() + 20, 3);
//                break;
//        }
//        //启动我们的Shot线程
//        new Thread(shot).start();
//    }
//}