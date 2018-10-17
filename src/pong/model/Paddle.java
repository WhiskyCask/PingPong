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


    public Paddle(double x, double y) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }





}
