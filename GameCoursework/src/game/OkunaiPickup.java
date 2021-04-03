package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
public class OkunaiPickup implements CollisionListener {
    private Orochimaru orochimaru;
    public OkunaiPickup(Orochimaru s){
        this.orochimaru = s;
    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Kunai) {
            orochimaru.addKunai();
            e.getOtherBody().destroy();
        }
    }
}

