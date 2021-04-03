package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;


public class SasukeRegroup implements CollisionListener{
    private GameLevel level;
    private Game game;


    public SasukeRegroup(GameLevel level, Game game){
        this.level = level;
        this.game = game;
}
@Override
public void collide(CollisionEvent e) {
    //if student collided with professor and the
    //conditions for completing the level are fulfilled
    //goToNextLevel
    if (e.getOtherBody() instanceof Sasuke
            && level.isComplete()){
        game.goToNextLevel();
    }
}


}