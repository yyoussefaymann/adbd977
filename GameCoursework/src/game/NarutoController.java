package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.io.IOException;
public class NarutoController implements KeyListener {

        private static final float WALKING_SPEED = 6;
        private static final float JUMPING_HEIGHT=10;
        private Naruto naruto;

        public NarutoController(Naruto s){
            naruto = s;
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            // other key commands omitted
            if (code == KeyEvent.VK_LEFT) {
                naruto.startWalking(-WALKING_SPEED);
            } else if (code == KeyEvent.VK_RIGHT) {
                naruto.startWalking(WALKING_SPEED);
            }else if (code==KeyEvent.VK_SPACE){
                naruto.jump(JUMPING_HEIGHT);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_LEFT) {
                naruto.stopWalking();
            } else if (code == KeyEvent.VK_RIGHT) {
                naruto.stopWalking();
            }

        }
        public void updateNaruto(Naruto naruto){
            this.naruto = naruto;
        }
    }


