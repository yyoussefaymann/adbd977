package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
public class RamenPickup implements CollisionListener{
    private Naruto naruto;
    public RamenPickup(Naruto w){
        this.naruto = w;
    }
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Ramen) {
            naruto.addRamen();
            e.getOtherBody().destroy();
        }
    }
}
