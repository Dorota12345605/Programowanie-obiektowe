package Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import World.Organism;
import World.Animal;
import World.GameWorld;
import World.Point;



public class Fox extends Animal {
    private final Random random = new Random();

    public Fox(int x, int y, GameWorld world) {

        super(3, 7, x, y, world, 'F');
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
        Point newPoint = new Point(oldX, oldY);
        List<Point> newSafePositions = new ArrayList<Point>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;

                int newX = oldX + i;
                int newY = oldY + j;

                if (!gameWorld.isOkay(newX, newY))
                    continue;

                Organism other = gameWorld.getOrganism(newX, newY);

                if (other == null || getStrength() >= other.getStrength()) {
                    newSafePositions.add(new Point(newX, newY));
                }
            }
        }

        if (!newSafePositions.isEmpty()) {
            int randomPosition = random.nextInt(newSafePositions.size());
            newPoint=newSafePositions.get(randomPosition);
        }

        // jesli nie ma bezpiecznych miejsc to zostaje na miejscu
        return newPoint;
    }
}

