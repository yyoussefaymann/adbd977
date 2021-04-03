package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
public class SkunaiPickup implements CollisionListener {
    private Sasori sasori;
    public SkunaiPickup(Sasori s){
        this.sasori = s;
    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Kunai) {
            sasori.addKunai();
            e.getOtherBody().destroy();
        }

    }

}
