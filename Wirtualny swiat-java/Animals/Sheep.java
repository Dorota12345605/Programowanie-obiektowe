package Animals;

import World.Organism;
import World.Animal;
import World.GameWorld;
import World.Point;

public class Sheep extends Animal {
    public Sheep(int x, int y, GameWorld gameWorld) {
        super(4, 4, x, y, gameWorld, 'S');
    }

    @Override
    public void draw() {
        System.out.print(symbol);
    }

    @Override
    public void action() {
        super.action();
    }
}
