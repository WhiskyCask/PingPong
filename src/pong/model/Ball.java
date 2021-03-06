package pong.model;

import pong.event.Event;
import pong.event.EventService;

import static pong.model.Pong.GAME_HEIGHT;
import static pong.model.Pong.GAME_WIDTH;
import static pong.model.Pong.BALL_SPEED_FACTOR;

/*
 * A Ball for the Pong game
 * A model class
 */
public class Ball extends AbstractMoveable {

    public static final double WIDTH = 40;
    public static final double HEIGHT = 40;

    private static final java.util.Random rand = new java.util.Random();
    private static final double velAbs = 0.4;

    public static enum X{
        LEFT,
        NA,
        RIGHT;
    }

    // Constructor
    public Ball() {
        super((GAME_WIDTH - WIDTH) / 2, (GAME_HEIGHT - HEIGHT) / 2, WIDTH, HEIGHT);
    }

    public void init() {
        // Get the starting position of the ball

        this.setX((GAME_WIDTH - this.getWidth()) / 2);
        this.setY((GAME_HEIGHT - this.getHeight()) / 2);

        // Get the initial speed of the ball

        // Start by getting the initial angle from which the ball will be fired at
        double angle = rand.nextInt(90) - 45;
        int direction = rand.nextInt(1);
        angle += 180 * direction;
        angle = Math.toRadians(angle);

        // Now get the velocity from this angle an velAbs
        this.setVelX(this.velAbs * Math.cos(angle));
        this.setVelY(this.velAbs * Math.sin(angle));

    }

    @Override
    public void move(double dT) {
        if(this.isOutsideY()){
            this.reflectY();
        }
        super.move(dT);
    }


    void reflectLeft(IPositionable other) {
        this.setVelX(-BALL_SPEED_FACTOR * this.getVelX());
        this.setX(other.getX() + other.getWidth() + 1);
        EventService.add(new Event(Event.Type.BALL_HIT_PADDLE));
    }

    void reflectRight(IPositionable other) {
        this.setVelX(-BALL_SPEED_FACTOR * this.getVelX());
        this.setX(other.getX() - this.getWidth() - 1);
        EventService.add(new Event(Event.Type.BALL_HIT_PADDLE));
    }

    public X isOutsideX() {
        X x;
        boolean right = GAME_WIDTH < this.getX() + this.getWidth();
        boolean left = 0 > this.getX();
        if(right){
            x = X.RIGHT;
        }
        else if(left){
            x = X.LEFT;
        }
        else{
            x = X.NA;
        }
        return x;
    }
}
