package World;

import java.util.ArrayList;
import java.util.List;


public abstract class Organism {
    protected int strength;
    protected int initiative;
    protected Point position;
    protected GameWorld gameWorld;
    protected char symbol;
    protected int lifeLength;
    protected boolean isAlive;

    //metody abstrakcyjne
    public abstract void action();
    public abstract void collision(Organism defender);

    public Organism(int strength, int initiative, int x, int y, GameWorld world, char symbol, int lifeLength, boolean isAlive)
    {
        this.strength = strength;
        this.initiative = initiative;
        this.position = new Point(x, y);
        this.gameWorld = world;
        this.symbol = symbol;
        this.lifeLength = lifeLength;
        this.isAlive = isAlive;
    }

    public void setLifeLength(int lifeLength) {

        this.lifeLength = lifeLength;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getLifeLength() {
        return lifeLength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getPositionX() {
        return position.getX();
    }

    public int getPositionY() {
        return position.getY();
    }

    public void setPositionX(int x) {
        this.position = new Point(x, position.getY());
    }

    public void setPositionY(int y) {
        this.position = new Point(position.getX(), y);
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void draw() {
        System.out.print(symbol);
    }

    //domyslne metody
    public boolean isBlockAttack(Organism attacker) {
        return false;
    }

    public boolean isAbleToEscape(Organism attacker) {
        return false;
    }

    public boolean isAnimal() {
        return false;
    }

    public Point findFreeNeighbourPlace(Point newPoint) {
        List<Point> options = new ArrayList<>();
        int[][] positions = {{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < positions.length; i++) {
            int[] d = positions[i];
            int nx = newPoint.getX() + d[0];
            int ny = newPoint.getY() + d[1];
            if (gameWorld.isOkay(nx, ny) && gameWorld.getOrganism(nx, ny) == null) {
                options.add(new Point(nx, ny));
            }
        }
        if (!options.isEmpty())
        {
            return options.get((int)(Math.random() * options.size())); //losowy punkt z tej listy
        }

        return new Point(-1, -1); // nie ma miejsca
    }

}

