package Animals;

import World.Organism;
import World.Animal;
import World.GameWorld;
import World.Point;

public class Wolf extends Animal {
    public Wolf(int x, int y, GameWorld gameWorld) {
        super(9, 5, x, y, gameWorld, 'W');
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
