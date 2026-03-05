package Animals;

import java.util.Random;

import World.Organism;
import World.Animal;
import World.GameWorld;
import World.Point;

public class Turtle extends Animal {
    private final Random random = new Random();

    public Turtle(int x, int y, GameWorld world) {

        super(2, 1, x, y, world, 'T');
    }

    @Override
    public void action() {
        int changePosition = random.nextInt(4);
        if (changePosition == 1) {
            super.action(); // tylko w 25% przypadków wykonuje ruch
        }
    }

    @Override
    public void draw() {
        System.out.print(symbol);
    }

    @Override
    public boolean isBlockAttack(Organism attacker) {
        if (attacker.getStrength() < 5) {
            return true;
        } else {
            return false;
        }
    }
}
