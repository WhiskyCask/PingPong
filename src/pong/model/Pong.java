package pong.model;


import pong.event.Event;
import pong.event.EventService;

import java.util.ArrayList;
import java.util.List;

/*
 * Logic for the Pong Game
 * Model class representing the "whole" game
 * Nothing visual here
 *
 */
public class Pong {

    public static final double GAME_WIDTH = 600;
    public static final double GAME_HEIGHT = 400;
    public static final double BALL_SPEED_FACTOR = 1.02;
    public static final long HALF_SEC = 500_000_000;

    public final Paddle rightpaddle;
    public final Paddle leftpaddle;
    public final Ball ball;

    private int pointsLeft;
    private int pointsRight;


    // TODO Constructor

    public Pong(Paddle leftpaddle, Paddle rightpaddle, Ball ball) {
        this.leftpaddle = leftpaddle;
        this.rightpaddle = rightpaddle;
        this.ball = ball;
    }

    // --------  Game Logic -------------

    private long timeForLastHit;         // To avoid multiple collisions
    private long lastUpdate;

    public void update(long now) {
        if (lastUpdate == 0) lastUpdate = now;
        double dT = (now - lastUpdate) / (Math.pow(10, 6) * 2);

        //Collision check
        if(ball.intersects(leftpaddle)) { ball.reflectLeft(leftpaddle); }
        else if ((ball.intersects(rightpaddle))) { ball.reflectRight(rightpaddle); }

        //Checking if ball is outside ish
        if(ball.isOutsideX() != Ball.X.NA) {
            if (ball.isOutsideX() == Ball.X.LEFT) {
                pointsRight++;
            }
            else if (ball.isOutsideX() == Ball.X.RIGHT) {
                pointsLeft++;
            }
            ball.init();
        }


        //Move AbstractMoveables
        this.ball.move(dT);
        this.leftpaddle.move(dT);
        this.rightpaddle.move(dT);
        lastUpdate = now;
    }



    // --- Used by GUI  ------------------------

    public List<IPositionable> getPositionables() {
        List<IPositionable> drawables = new ArrayList<>();
        // TODO

        drawables.add(this.leftpaddle);
        drawables.add(this.rightpaddle);

        drawables.add(this.ball);

        return drawables;
    }

    public int getPointsLeft() {
        return pointsLeft;
    }

    public int getPointsRight() {
        return pointsRight;
    }

    public void setSpeedRightPaddle(double dy) { this.rightpaddle.setVelY(dy); }

    public void setSpeedLeftPaddle(double dy) { this.leftpaddle.setVelY(dy); }
}
