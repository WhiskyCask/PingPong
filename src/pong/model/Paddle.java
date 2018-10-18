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

    public static final enum Type {
        LEFT,
        RIGHT;
    }

    public Paddle(double x, double y, Type type) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

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
    }
}
