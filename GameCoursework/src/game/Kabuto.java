package game;
import city.cs.engine.*;
public class Kabuto extends Walker {
    private static final Shape kabutoShape = new PolygonShape(
            1.84f, 2.59f, 1.96f, -0.3f, 1.5f, -2.36f,
            -0.47f, -2.33f, -1.98f, 1.69f, 0.5f, 2.46f);
    private static final BodyImage image =
            new BodyImage("data/kabuto.png", 7f);
    private double kunaiCount;
    public Kabuto(World world) {
        super(world, kabutoShape);
        addImage(image);
        kunaiCount=0;
    }
    public void addKunai(){
        kunaiCount++;
        System.out.println("damage inflicted"+
                "from Kunai = "+ -kunaiCount );
    }
    public double getKunaiCount(){
        return kunaiCount;
    }
}

