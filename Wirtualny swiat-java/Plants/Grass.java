package Plants;

import World.GameWorld;
import World.Organism;
import World.Plant;

public class Grass extends Plant {
    public Grass(int x, int y, GameWorld world) {

        super(0, x, y, world, '/');
    }
}
