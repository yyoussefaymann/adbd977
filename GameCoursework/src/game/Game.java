package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import city.cs.engine.DebugViewer;
import java.awt.event.ActionListener;

/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel level;

    /** A graphical display of the world (a specialised JPanel). */
    private GameView view;
    private NarutoController controller;





    /** Initialise a new Game. */
    public Game() {

        level = new Level0(this);

        // make a view
        view = new GameView(level, 500, 467);
        view.setZoom(20);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        view.addMouseListener(new MouseHandler(level, view));

        controller = new NarutoController(level.getNaruto());
        view.addKeyListener(controller);


        view.addMouseListener(new GiveFocus(view));

        //world.addStepListener(new Tracker(view, world.getStudent()));
        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Naruto Game");

        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        ControlPanel buttons = new ControlPanel(level);
        frame.add(buttons.getMainPanel(), BorderLayout.NORTH);

        ProgressPanels progress = new ProgressPanels(level);
        frame.add(progress.getMainPanel(), BorderLayout.SOUTH);

        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);


        //uncomment this to make a debugging view
       // JFrame debugView = new DebugViewer(level, 500, 500);
        // start our game world simulation!
        level.start();

    }


    public void goToNextLevel(){

        if (level instanceof Level0){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level1(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateNaruto(level.getNaruto());
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level1){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level2(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateNaruto(level.getNaruto());
            //start the simulation in the new level
            level.start();
        }
        else if (level instanceof Level2){
            //stop the current level
            level.stop();
            //create the new (appropriate) level
            //level now refers to new level
            level = new Level3(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateNaruto(level.getNaruto());
            //start the simulation in the new level
            level.start();
        }

        else if(level instanceof Level3) {
            System.out.println("Well done! Game complete.");
            System.exit(0);
        }

    }



    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}





