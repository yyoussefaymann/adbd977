package game;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;


public class Level0 extends GameLevel {
    private SoundClip gameMusic;


    public Level0(Game game) {

        super(game);
        //insert background music
        //could be done in the main game method
        //but insert it here so each level has diff background music
        try {
            gameMusic = new SoundClip("data/Naruto level0.mp3");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException |
                LineUnavailableException e) {
            System.out.println(e);
        }

        //setting the positions of  both Naruto and Orochimaru
        getNaruto().setPosition(new Vec2(8, -10));
        getSasuke().setPosition(new Vec2(-5, -10));

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
        Orochimaru orochimaru = new Orochimaru(this);
        orochimaru.setPosition(new Vec2(6, 6));
        OkunaiPickup pickup3 = new OkunaiPickup(orochimaru);
        orochimaru.addCollisionListener(pickup3);

        Kabuto kabuto = new Kabuto(this);
        kabuto.setPosition(new Vec2(-6, 4.5f));
        KkunaiPickup pickup = new KkunaiPickup(kabuto);
        kabuto.addCollisionListener(pickup);
        //create ramen pickup
        for (int i = 0; i < 4; i++) {
            Ramen ramen = new Ramen(this);
            ramen.setPosition(new Vec2(i * 2f, 0));

        }
    }




    @Override
    public boolean isComplete() {
        if (getNaruto().getRamenCount() == 4) {
            gameMusic.stop();
            return true;
        } else return false;

    }


}
