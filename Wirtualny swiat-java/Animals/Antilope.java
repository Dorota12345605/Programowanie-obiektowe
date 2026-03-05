package Animals;

import World.Organism;
import World.Animal;
import World.GameWorld;
import World.Point;

import java.util.Random;

public class Antilope extends Animal {
    private final Random random = new Random();

    public Antilope(int x, int y, GameWorld world) {

        super(4, 4, x, y, world, 'A');
    }

    @Override
    public void draw() {

        System.out.print(symbol);
    }

    @Override
    public void action() {

        super.action();
    }

    @Override
    public Point newPosition() {
        int oldX = getPositionX();
        int oldY = getPositionY();
        int newX, newY;

        do {
            newX = oldX + (random.nextInt(3) - 1) * 2;  // -2, 0, 2
            newY = oldY + (random.nextInt(3) - 1) * 2;
        } while (!gameWorld.isOkay(newX, newY) || (newX == oldX && newY == oldY));

        return new Point(newX, newY);
    }

    @Override
    public boolean isBlockAttack(Organism attacker) {
        int randNum=random.nextInt(2);
        if(randNum==0)
            return true;
        else
            return false;
    }
}

