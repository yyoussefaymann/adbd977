package game;

import city.cs.engine.*;


public class Naruto extends Walker {
    private static final Shape narutoShape = new PolygonShape(
            -0.11f,3,
            0.87f,1.48f,
            0.99f,0.29f,
            0.24f,-2.32f,
            -1.12f,-2.27f,
            -1.24f,1.21f);

    private static final BodyImage image =
            new BodyImage("data/naruto.png", 7f);

    private int kunaiCount;
    private int ramenCount;
    private int health;

    public Naruto(World world) {
        super(world, narutoShape);
        addImage(image);

        kunaiCount = 0;
        ramenCount=0;
        health=ramenCount-kunaiCount;
    }

    public void addKunai(){
        kunaiCount++;
        System.out.println("self inflicting damage " +
                "from Kunai = " + -kunaiCount);
    }
    public int getKunaiCount(){
        return kunaiCount;
    }

    public void addRamen(){
        ramenCount++;
        System.out.println("health inrease " +
                "= " + "+"+(ramenCount*50));
    }
    public int getRamenCount(){
        return ramenCount;
    }


}


