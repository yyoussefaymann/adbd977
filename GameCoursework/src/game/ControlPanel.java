package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class ControlPanel {
    private GameLevel level;
    private Level0 level0;
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton quitButton;
    private JButton resumeButton;


    public ControlPanel(GameLevel level) {
        this.level=level;

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.stop();
            }
        });
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level.start();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



    }
    public JPanel getMainPanel() {
        return mainPanel;
    }


}

