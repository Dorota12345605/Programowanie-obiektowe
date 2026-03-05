package World;

import Animals.Human;

import java.util.Random;

public abstract class Animal extends Organism
{
    private final Random random = new Random();

    public Animal(int strength, int initiative, int x, int y, GameWorld gameWorld, char symbol) {
        super(strength, initiative, x, y, gameWorld, symbol, 0, true);
    }

    protected Point newPosition() {
        int newX=0;
        int newY=0;
        int oldPosX = getPositionX();
        int oldPosY = getPositionY();

        do {
            newX = oldPosX + random.nextInt(3) - 1; // -1, 0, 1
            newY = oldPosY + random.nextInt(3) - 1;
        } while (!gameWorld.isOkay(newX, newY) || (newX == oldPosX && newY == oldPosY));

        return new Point(newX, newY);
    }

    @Override
    public void action() {
        Point point = newPosition();

        if (getPositionX() == point.getX() && getPositionY() == point.getY()) {
            return;
        }

        Organism defender = gameWorld.getOrganism(point.getX(), point.getY());

        if (defender != null) {
            if (defender.getSymbol() == this.getSymbol())
            {
                Point newPoint = findFreeNeighbourPlace(new Point(getPositionX(), getPositionY()));
                if (newPoint.getX() == -1 && newPoint.getY() == -1)
                {
                    gameWorld.printWarning(this.getSymbol());
                    return;
                }
                gameWorld.createNewOrganismFromSymbol(this.getSymbol(), newPoint);
                gameWorld.printNewReproduction(this.getSymbol());
            } else
            {
                collision(defender);
            }
        } else {
            gameWorld.moveOrganism(point.getX(), point.getY(), getPositionX(), getPositionY());
        }
    }

    public void collision(Organism defender) {
        if (defender.isBlockAttack(this)) {
            gameWorld.printResultOfAttack(this.getSymbol(), defender.getSymbol());

            // jesli czlowiek
            if (defender instanceof Human) {
                gameWorld.printSpecialAttack("Alazura's Shield saved the Human from an attack by " + gameWorld.getOrganismName(this.getSymbol()));
            }

            return;
        }

        if (isAbleToEscape(defender)) {
            Point newPoint = findFreeNeighbourPlace(new Point(getPositionX(), getPositionY()));
            if (newPoint.getX() == -1 && newPoint.getY() == -1) {
                gameWorld.printWarning(this.getSymbol());
                return;
            }
            gameWorld.moveOrganism(newPoint.getX(), newPoint.getY(), getPositionX(), getPositionY());
            return;
        }

        //kolizja
        if (this.getStrength() >= defender.getStrength()) {

            if (defender instanceof Human) {
                defender.setIsAlive(false);
                gameWorld.killOrganism(defender);

                gameWorld.endGame("Human was killed by " + gameWorld.getOrganismName(this.getSymbol()));
                return;
            }
            else if (defender.isAnimal())
            {
                defender.setIsAlive(false);
                gameWorld.killOrganism(defender);
                gameWorld.moveOrganism(defender.getPositionX(), defender.getPositionY(), getPositionX(), getPositionY());
                gameWorld.printResultOfFight(this.getSymbol(), defender.getSymbol());
            }
            else {
                gameWorld.printResultOfPlantEating(defender.getSymbol(), this.getSymbol());
                defender.setIsAlive(false);
                gameWorld.killOrganism(defender);
                gameWorld.moveOrganism(defender.getPositionX(), defender.getPositionY(), getPositionX(), getPositionY());
            }

        }
        else {
            gameWorld.killOrganism(this);
            this.setIsAlive(false);
            if (this instanceof Human) {
                gameWorld.endGame("Human was killed by " + gameWorld.getOrganismName(defender.getSymbol()));
            }
        }
    }

    public Point helperNewPosition(int oldX, int oldY) {
        int newX, newY;
        do {
            newX = oldX + random.nextInt(3) - 1;
            newY = oldY + random.nextInt(3) - 1;
        } while (!gameWorld.isOkay(newX, newY) || (newX == oldX && newY == oldY));

        return new Point(newX, newY);
    }

    @Override
    public boolean isAnimal() {
        return true;
    }
}
