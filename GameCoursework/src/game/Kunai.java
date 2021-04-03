package game;

import city.cs.engine.*;


public class Kunai extends DynamicBody{
    private static final Shape kunaiShape = new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("data/kunai.png", 2f);

        public Kunai(World w) {
            super(w,kunaiShape);
            addImage(image);

        }
}

