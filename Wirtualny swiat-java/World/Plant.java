package World;

import java.util.Random;

public class Plant extends Organism {
    private final Random random = new Random();

    public Plant(int strength, int x, int y, GameWorld world, char symbol)
    {
        super(strength, 0, x, y, world, symbol, 0, true);
    }

    @Override
    public void action() {
        int probability = random.nextInt(100);
        if (probability > 80) { // 20% szans
            Point newPoints = findFreeNeighbourPlace(new Point(getPositionX(), getPositionY()));
            if (newPoints.getX() == -1 && newPoints.getY() == -1) {
                gameWorld.printWarning(this.getSymbol());
                return;
            } else {
                gameWorld.createNewOrganismFromSymbol(getSymbol(), newPoints);
                gameWorld.printSeedNewPlant(this.getSymbol());
            }
        }
    }

    @Override
    public void collision(Organism defender) {
        System.out.println("This is a plant.");
    }

    public Point newPosition() {
        return new Point(-1, -1); // Rośliny się nie ruszają
    }

    @Override
    public boolean isAnimal()
    {
        return false;
    }
}
