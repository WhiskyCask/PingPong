package pong.model;

import static pong.model.Pong.GAME_HEIGHT;

public class AbstractMoveable extends AbstractPositionable {

    private double velX;
    private double velY;

    public AbstractMoveable(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public void move(double dT) {
        this.setX(this.getX() + this.velX * dT);
        this.setY(this.getY() + this.velY * dT);
    }

    public boolean isOutsideY() {
        boolean bool = false;
        boolean above = GAME_HEIGHT > getY() + getHeight();
        boolean below = 0 < getY();
        bool = !(above || below);
        return bool;
    }

    // Accesors
    public double getVelX() { return this.velX; }
    public double getVelY() { return this.velY; }

    // Modifiers
    public void setVelX(double velX) { this.velX = velX; }
    public void setVelY(double velY) { this.velY = velY; }

}

