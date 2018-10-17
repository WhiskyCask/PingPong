package pong.model;

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

    // Accesors
    public double getVelX() { return this.velX; }
    public double getVelY() { return this.velY; }

    // Modifiers
    public void setVelX(double velX) { this.velX = velX; }
    public void setVelY(double velY) { this.velY = velY; }

}

