package game;
import city.cs.engine.*;
public class Tobi extends Walker {
    private static final Shape tobiShape = new PolygonShape(
            1.84f, 2.59f, 1.96f, -0.3f, 1.5f, -2.36f,
            -0.47f, -2.33f, -1.98f, 1.69f, 0.5f, 2.46f);
    private static final BodyImage image =
            new BodyImage("data/Tobi.png", 7f);

    public Tobi(World world) {
        super(world, tobiShape);
        addImage(image);
    }
}