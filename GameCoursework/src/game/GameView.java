package game;

import city.cs.engine.UserView;
import city.cs.engine.World;


import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image background;
    public GameView(World w, int width, int height) {
        super(w, width, height);
            background = new ImageIcon("data/konoha.jpg").getImage();
}


    public void setBackground(String name){
         name="data/konoha.jpg";
        background = new ImageIcon(name).getImage();}
    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 0, this);
    }




}
