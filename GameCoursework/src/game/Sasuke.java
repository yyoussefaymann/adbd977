package game;

import city.cs.engine.*;


public class Sasuke extends Walker {
    private static final Shape sasukeShape = new PolygonShape(
            1.84f,1.99f, 1.96f,-0.3f, 1.5f,-2.36f,
            -0.47f,-2.33f, -1.98f,1.69f, 0.5f,2.46f);
    private static final BodyImage image =
            new BodyImage("data/sasuke.png", 7f);


    public Sasuke(World world) {
        super(world ,sasukeShape);
        addImage(image);

    }

}