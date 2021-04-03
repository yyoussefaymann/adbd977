package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
public class KkunaiPickup implements CollisionListener {
    private Kabuto kabuto;
    public KkunaiPickup(Kabuto s){
        this.kabuto = s;
    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Kunai) {
            kabuto.addKunai();
            e.getOtherBody().destroy();
        }

    }




}

