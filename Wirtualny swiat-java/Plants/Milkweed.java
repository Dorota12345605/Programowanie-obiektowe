package Plants;

import World.GameWorld;
import World.Organism;
import World.Plant;

public class Milkweed extends Plant {
    public Milkweed(int x, int y, GameWorld world) {
        super(0, x, y, world, '*');
    }

    @Override
    public void action() {
        for (int i = 0; i < 3; i++) {
            super.action(); // trzy razy probuje sie rozsiac
        }
    }
}