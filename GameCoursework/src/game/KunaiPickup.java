package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
public class KunaiPickup implements CollisionListener{
    private Naruto naruto;
    public KunaiPickup(Naruto s){

        this.naruto = s;

    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Kunai) {
            naruto.addKunai();
            e.getOtherBody().destroy();
        }

    }




}
