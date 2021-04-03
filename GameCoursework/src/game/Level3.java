package game;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import javax.swing.*;

public class Level3 extends GameLevel{
    private SoundClip gameMusic3;
    public Level3(Game game) {
        super(game);
        try {
            gameMusic3 = new SoundClip("data/Naruto Level3.mp3");   // Open an audio input stream
            gameMusic3.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|
                LineUnavailableException e) {
            System.out.println(e);}
        //setting the positions of  both Naruto and Sasuke
        getNaruto().setPosition(new Vec2(8.5f, -10));
        getSasuke().setPosition(new Vec2(10, -10));

        //setting up the RamenPickup here
        getNaruto().addCollisionListener(new RamenPickup(getNaruto()));
        getNaruto().addCollisionListener(new KunaiPickup(getNaruto()));
        //make ground 1
        Shape shape = new BoxShape(4, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(8.5f, -11.5f));
        //make ground 2
        Shape shape1 = new BoxShape(4, 0.5f);
        StaticBody ground1 = new StaticBody(this, shape1);
        ground1.setPosition(new Vec2(-8.5f, -11.5f));

        //make platform 1
        Shape platform1Shape = new BoxShape(2, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-11, 0f));

        //make platform 2
        Shape platform2Shape = new BoxShape(8, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(8, 2.5f));
        //make wall
        Shape wallShape = new BoxShape(0.5f, 5f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-8f, 0));
        //create ramen pickups
        Ramen ramen =new Ramen(this);
        ramen.setPosition(new Vec2(7.5f,-10));

        Ramen ramen2 =new Ramen(this);
        ramen2.setPosition(new Vec2(-8.5f,-10));

        Ramen ramen3 =new Ramen(this);
        ramen3.setPosition(new Vec2(-12.5f,2));

        Ramen ramen4 =new Ramen(this);
        ramen4.setPosition(new Vec2(7,4f));
        //create more bodies
        Itachi itachi= new Itachi(this);
        itachi.setPosition(new Vec2(-7.5f,-10));

        Tobi tobi= new Tobi(this);
        tobi.setPosition(new Vec2(5,3.5f));





    }
    @Override
    public boolean isComplete(){
        if(getNaruto().getRamenCount()==4){
            gameMusic3.stop();
            return true;}
        else return false;

    }

}
