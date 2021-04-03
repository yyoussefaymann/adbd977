package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
public class DkunaiPickup implements CollisionListener {
    private Daidara daidara;
    public DkunaiPickup(Daidara s){
        this.daidara = s;
    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Kunai) {
            daidara.addKunai();
            e.getOtherBody().destroy();
        }

    }




}

