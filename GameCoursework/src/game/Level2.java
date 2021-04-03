package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import javax.swing.*;

public class Level2 extends GameLevel{
    private SoundClip gameMusic2;
    public Level2(Game game) {
        super(game);
        try {
            gameMusic2 = new SoundClip("data/Naruto Level2.mp3");   // Open an audio input stream
            gameMusic2.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|
                LineUnavailableException e) {
            System.out.println(e);}

        //setting the positions of  both Naruto and Orochimaru
        getNaruto().setPosition(new Vec2(8, -10));
        getSasuke().setPosition(new Vec2(10, -10));

        //setting up the RamenPickup here
        getNaruto().addCollisionListener(new RamenPickup(getNaruto()));
        getNaruto().addCollisionListener(new KunaiPickup(getNaruto()));


        //make the ground
        Shape shape = new BoxShape(4, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(8.5f, -11.5f));

        //make platform 1
        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-8, 0f));

        //make platform 2
        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(5, 2.5f));



        //make wall 2
        Shape wallShape2 = new BoxShape(0.5f, 2f);
        StaticBody wall2 = new StaticBody(this, wallShape2);
        wall2.setPosition(new Vec2(2.5f, -8));

        //make wall 3
        Shape wallShape3 = new BoxShape(0.5f, 2f);
        StaticBody wall3 = new StaticBody(this, wallShape3);
        wall3.setPosition(new Vec2(-2.5f, -6));


        //create more bodies
        Sasori sasori= new Sasori(this);
        sasori.setPosition(new Vec2(6,6));
        SkunaiPickup pickup = new SkunaiPickup(sasori);
        sasori.addCollisionListener(pickup);

        Daidara daidara= new Daidara(this);
        daidara.setPosition(new Vec2(-6,1));
        DkunaiPickup pickup2 = new DkunaiPickup(daidara);
        daidara.addCollisionListener(pickup2);

        //create ramen pickups
        Ramen ramen =new Ramen(this);
        ramen.setPosition(new Vec2(5,-5));

        Ramen ramen2 =new Ramen(this);
        ramen2.setPosition(new Vec2(-2.7f,-3));

        Ramen ramen3 =new Ramen(this);
        ramen3.setPosition(new Vec2(8,6));

        Ramen ramen4 =new Ramen(this);
        ramen4.setPosition(new Vec2(-8,1f));


    }


    @Override
    public boolean isComplete(){
        if(getNaruto().getRamenCount()==4){
            gameMusic2.stop();
            return true;}
        else return false;

    }
    }



