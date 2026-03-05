package Plants;

import World.GameWorld;
import World.Organism;
import World.Plant;

public class NightshadeBerries extends Plant {
    public NightshadeBerries(int x, int y, GameWorld world) {
        super(99, x, y, world, '!');
    }

    @Override
    public boolean isBlockAttack(Organism attacker) {
        gameWorld.killOrganism(attacker);
        attacker.setIsAlive(false);
        return false;
    }
}
