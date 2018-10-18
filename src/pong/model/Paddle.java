package pong.model;

import static pong.model.Pong.GAME_HEIGHT;

/*
 * A Paddle for the Pong game
 * A model class
 *
 */
public class Paddle extends AbstractMoveable {

    public static final double PADDLE_WIDTH = 10;
    public static final double PADDLE_HEIGHT = 60;
    public static final double PADDLE_SPEED = 0.5;

    public enum Type {
        LEFT,
        RIGHT
    }

    private Type type;

    public Paddle(double x, double y, Type type) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.type = type;
    }
/*
    @Override
    public void move(double dT) {
        if (this.isOutsideY()){
            this.reflectY();
            super.move(dT);
            this.setVelY(0);
        }
        else {
            super.move(dT);
        }
    }*/

    public void collisionWithWall(Wall wall){
        this.setVelY(0);
        if(wall.getWall() == Wall.Type.TOP){
            this.setY(1);
            //this.setVelY(Math.abs(this.getVelY()) * 1);
        }else if(wall.getWall() == Wall.Type.BOTTOM){
            this.setY(GAME_HEIGHT-PADDLE_HEIGHT-1);
            //this.setVelY(Math.abs(this.getVelY()) * -1);
        }
    }

    // Acessors
    public Type getType() { return this.type; }
}
