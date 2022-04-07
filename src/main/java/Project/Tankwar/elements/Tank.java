package Project.Tankwar.elements;

/**
 * @author Chris Yang
 * created 2022-04-07 14:57
 **/
class Tank {
    private int x;
    private int y;
    private int direct;
    private int speed = 1;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp(){
        y -= speed;
    }

    public void moveDown(){
        y += speed;
    }

    public void moveLeft(){
        x -= speed;
    }

    public void moveRight(){
        x += speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
}
