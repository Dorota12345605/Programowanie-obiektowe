package Plants;

import World.GameWorld;
import World.Organism;
import World.Plant;

public class Guarana extends Plant {
    public Guarana(int x, int y, GameWorld world) {

        super(0, x, y, world, ',');
    }

    @Override
    public boolean isBlockAttack(Organism attacker) {
        attacker.setStrength(attacker.getStrength() + 3);
        return false;
    }
}
