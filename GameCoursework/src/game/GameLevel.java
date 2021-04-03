package game;
import city.cs.engine.World;
public abstract class GameLevel extends World {
    private Naruto naruto;
    private Sasuke sasuke;
    public GameLevel(Game game){
        naruto=new Naruto(this);
        sasuke=new Sasuke(this);
        SasukeRegroup encounter = new SasukeRegroup(this, game);
        naruto.addCollisionListener(encounter);

    }
    public Naruto getNaruto(){ return naruto; }
    public Sasuke getSasuke(){ return sasuke; }
    public abstract boolean isComplete();
}
