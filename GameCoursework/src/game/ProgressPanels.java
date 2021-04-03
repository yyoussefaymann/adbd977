package game;

import javax.swing.*;

public class ProgressPanels {
    private GameLevel level;
    private JProgressBar healthBar;
    private JProgressBar damageBar;
    private JPanel mainPanel;
    private Naruto naruto;


    public ProgressPanels(GameLevel level){
        this.level= level;
        healthBar.setValue(0);
        damageBar.setValue(0);
        //healthbar should start at 50% and increase as player eats ramen
        //still have not figured out hot to get it to be responsive(need help)
            int i=0;
            int z=0;
            try {
                while (i <= 50) {

                    // fill the menu bar
                    healthBar.setValue(i+10);

                    // delay the thread
                    Thread.sleep(10);
                i +=20;
                }
            }
            catch (Exception e) {
            }
//damageBar should show how much damage a player has taken
        //but same as healthbar still not responsive
        try {
            while (z == 0) {

                // fill the menu bar
                damageBar.setValue(z);

                // delay the thread
                Thread.sleep(10);
                z +=10;
            }
        }
        catch (Exception e) {
        }

}
    public JPanel getMainPanel() {
        return mainPanel;
    }
    public Naruto getNaruto(){ return naruto; }

}
