package pong.model;

import java.util.ArrayList;
import java.util.List;

public class Wall extends AbstractPositionable {


    public enum Type{
        TOP, BOTTOM, LEFT, RIGHT;
    }

    public Wall(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public static List<Wall> makeCeilingAndFloor(double gameWidth, double gameHeight){
        List<Wall> walls = new ArrayList<Wall>();

        Wall ceiling = new Wall(0,0,gameWidth,0);
        Wall floor = new Wall(0,gameHeight,gameWidth,0);

        walls.add(ceiling);
        walls.add(floor);

        return walls;
    }

}
