package game;

import city.cs.engine.*;

public class Sasori extends Walker {
    private static final Shape sasoriShape = new PolygonShape(
            1.84f,1.99f, 1.96f,-0.3f, 1.5f,-2.36f,
            -0.47f,-2.33f, -1.98f,1.69f, 0.5f,2.46f);
    private static final BodyImage image =
            new BodyImage("data/Sasori.png", 7f);
    private double kunaiCount=0;

    public Sasori(World world) {
        super(world ,sasoriShape);
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


