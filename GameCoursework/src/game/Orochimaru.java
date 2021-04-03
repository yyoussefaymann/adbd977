package game;
import city.cs.engine.*;
public class Orochimaru extends Walker{
    private static final Shape orochimaruShape = new PolygonShape(
            1.84f,1.99f, 1.96f,-0.3f, 1.5f,-2.36f,
            -0.47f,-2.33f, -1.98f,1.69f, 0.5f,2.46f);
    private static  BodyImage image =
            new BodyImage("data/orochimaru.png", 7f);
    private double kunaiCount;

    public Orochimaru(World world) {
        super(world ,orochimaruShape);
        addImage(image);
        kunaiCount=0;

    }
    public void addKunai(){
        kunaiCount++;
        System.out.println("damage inflicted"+
                "from Kunai = "+ -kunaiCount/2 );

    }
    public double getKunaiCount(){
        return kunaiCount;
    }
}

