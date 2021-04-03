package game;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
public class Level1 extends GameLevel{
    private SoundClip gameMusic1;
    public Level1(Game game) {
        super(game);
        try {
            gameMusic1 = new SoundClip("data/Naruto Level1.mp3");   // Open an audio input stream
            gameMusic1.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|
                LineUnavailableException e) {
            System.out.println(e);}

        //setting the positions of  both Naruto and Orochimaru
        getNaruto().setPosition(new Vec2(8, -10));
        getSasuke().setPosition(new Vec2(-6, 4.5f));

        //setting up the Pickups here
        getNaruto().addCollisionListener(new RamenPickup(getNaruto()));
        getNaruto().addCollisionListener(new KunaiPickup(getNaruto()));

        //make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        //make platform 1
        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-8, 4.5f));

        //make platform 2
        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(5, 2.5f));

        //make wall 1
        Shape wallShape = new BoxShape(0.5f, 20f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        //make wall 2
        Shape wallShape2 = new BoxShape(0.5f, 6f);
        StaticBody wall2 = new StaticBody(this, wallShape2);
        wall2.setPosition(new Vec2(11.5f, -6));

        //create more bodies
        Orochimaru orochimaru= new Orochimaru(this);
        orochimaru.setPosition(new Vec2(6,6));
        OkunaiPickup pickup3 = new OkunaiPickup(orochimaru);
        orochimaru.addCollisionListener(pickup3);

        Kabuto kabuto= new Kabuto(this);
        kabuto.setPosition(new Vec2(-5,-10));
        KkunaiPickup pickup = new KkunaiPickup(kabuto);
        kabuto.addCollisionListener(pickup);

        //create ramen pickups
        Ramen ramen =new Ramen(this);
        ramen.setPosition(new Vec2(5,-5));

        Ramen ramen2 =new Ramen(this);
        ramen2.setPosition(new Vec2(-7,-5));

        Ramen ramen3 =new Ramen(this);
        ramen3.setPosition(new Vec2(8,6));

        Ramen ramen4 =new Ramen(this);
        ramen4.setPosition(new Vec2(-8,7.5f));

    }


    @Override
    public boolean isComplete(){
        if(getNaruto().getRamenCount()==4){
            gameMusic1.stop();
            return true;}
        else  return false;

    }

}



