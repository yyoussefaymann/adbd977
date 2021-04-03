package game;

import city.cs.engine.*;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.io.IOException;

public class Ramen extends Walker {

    private static final Shape ramenShape = new CircleShape(1);
    private static SoundClip ramenSound;
    static {
        try {
            ramenSound = new SoundClip("data/ramen.wav");
            System.out.println("loading eating ramen sound");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }
    private static final BodyImage image =
            new BodyImage("data/Ramen.gif", 2f);

    public Ramen(World w) {
        super(w,ramenShape);
        addImage(image);

    }

    @Override
    public void destroy()
    {
        ramenSound.play();
        super.destroy();
    }

}

