package Project.Tankwar.elements;

/**
 * @author Chris Yang
 * created 2022-04-11 20:48
 **/
public class Bomb {
    int x,y;
    int life = 9;
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown(){
        if(life >0){
            life --;
        }else {
            isLive = false;
        }
    }
}
