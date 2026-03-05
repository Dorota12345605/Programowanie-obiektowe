package World;

import java.util.*;
import java.io.*;

import Plants.Milkweed;
import Plants.BarszczSosnowskiego;
import Plants.Grass;
import Plants.Guarana;
import Plants.NightshadeBerries;

import Animals.Human;
import Animals.Fox;
import Animals.Wolf;
import Animals.Sheep;
import Animals.Turtle;
import Animals.Antilope;

public class GameWorld {
    private int mCols;
    private int nRows;
    private int numberOfTurn;
    private Organism[][] board;
    private List<Organism> organismList;
    private StringBuilder turnMessages = new StringBuilder();
    private GameWorldGUI gui;

    public GameWorld(int m, int n) {
        this.mCols = m;
        this.nRows = n;
        this.board = new Organism[m][n];
        this.organismList = new ArrayList<Organism>(); //lista dynamiczna na organizmy
        Random rand = new Random();

        int maxOrganisms = 10;
        int numberOfOrganisms = rand.nextInt(maxOrganisms - 3 + 1) + 3;

        setNumberOfTurn(1);
        board[0][0] = new Human(0, 0, this);
        addOrganism(board[0][0]);

        for (int i = 0; i < numberOfOrganisms; i++)
        {
            int x, y;
            do {
                x = rand.nextInt(m);
                y = rand.nextInt(n);
            } while (board[x][y] != null || !isOkay(x, y)); //losowanie miejsca dla organizmu

            int type;
            type = rand.nextInt(2);
            if (type == 0) {
                int AnimalType = rand.nextInt(5);
                switch (AnimalType) {
                    case 0:
                        board[x][y] = new Sheep(x, y, this);
                        break;
                    case 1 :
                        board[x][y] = new Wolf(x, y, this);
                        break;
                    case 2:
                        board[x][y] = new Antilope(x, y, this);
                        break;
                    case 3:
                        board[x][y] = new Fox(x, y, this);
                        break;
                    case 4:
                        board[x][y] = new Turtle(x, y, this);
                        break;
                    default:
                        break;
                }
            }
            else {
                switch (rand.nextInt(5)) {
                    case 0:
                        board[x][y] = new Grass(x, y, this);
                        break;
                    case 1:
                        board[x][y] = new Milkweed(x, y, this);
                        break;
                    case 2:
                        board[x][y] = new Guarana(x, y, this);
                        break;
                    case 3:
                        board[x][y] = new NightshadeBerries(x, y, this);
                        break;
                    case 4:
                        board[x][y] = new BarszczSosnowskiego(x, y, this);
                        break;
                    default:
                        break;
                }
            }
            addOrganism(board[x][y]);
        }
    }


    public void addOrganism(Organism organism) {
        organismList.add(organism);
    }

    public void moveOrganism(int newX, int newY, int oldX, int oldY)
    {
        Organism organismToMove = getOrganism(oldX, oldY);
        if (organismToMove == null || !isOkay(newX, newY))
        {
            return;
        }

        board[oldX][oldY] = null;

        organismToMove.setPositionX(newX);
        organismToMove.setPositionY(newY);

        board[newX][newY] = organismToMove;
    }

    public Organism getOrganism(int x, int y)
    {
        if(isOkay(x, y)){
            return board[x][y];
        }

        else{
            return null;
        }
    }

    public boolean isOkay(int x, int y)
    {
        if (x >= 0 && x < mCols && y >= 0 && y < nRows) {
            return true;
        }
        else {
            return false;
        }
    }

    public void killOrganism(Organism loser) {
        int x = loser.getPositionX();
        int y = loser.getPositionY();

        if (!loser.getIsAlive() && board[x][y] == loser) {
            board[x][y] = null;
        }
    }

    public void createNewOrganismFromSymbol(char symbol, Point position)
    {
        int x = position.getX();
        int y = position.getY();
        switch (symbol) {
            case '@':
                board[x][y] = new Human(x, y, this);
                break;
            case 'S':
                board[x][y] = new Sheep(x, y, this);
                break;
            case 'W':
                board[x][y] = new Wolf(x, y, this);
                break;
            case 'A':
                board[x][y] = new Antilope(x, y, this);
                break;
            case 'F':
                board[x][y] = new Fox(x, y, this);
                break;
            case 'T':
                board[x][y] = new Turtle(x, y, this);
                break;
            case 'U':
                board[x][y] = new BarszczSosnowskiego(x, y, this);
                break;
            case '/':
                board[x][y] = new Grass(x, y, this);
                break;
            case ',':
                board[x][y] = new Guarana(x, y, this);
                break;
            case '*':
                board[x][y] = new Milkweed(x, y, this);
                break;
            case '!':
                board[x][y] = new NightshadeBerries(x, y, this);
                break;
            default:
                break;
        }
        addOrganism(board[x][y]);
    }

    public String getOrganismName(char symbol) {
        switch (symbol) {
            case '@':
                return "Human";
            case 'S':
                return "Sheep";
            case 'W':
                return "Wolf";
            case 'A':
                return "Antilope";
            case 'F':
                return "Fox";
            case 'T':
                return "Turtle";
            case 'U':
                return "BarszSosnowskiego";
            case '/':
                return "Grass";
            case ',':
                return "Guarana";
            case '*':
                return "Milkweed";
            case '!':
                return "NightshadeBerries";
            default:
                return "Unknown";
        }
    }

    public void takeTurn() {
        organismList.sort((a, b) -> {
            if (a.getInitiative() == b.getInitiative()) {
                return Integer.compare(b.getLifeLength(), a.getLifeLength());
            }
            return Integer.compare(b.getInitiative(), a.getInitiative());
        });

        for (Organism organism : new ArrayList<>(organismList)) {
            if (organism.getIsAlive()) {
                if (organism instanceof Human human) {
                    if (human.hasMoved()) {
                        human.action();
                        human.resetMoveDirection();
                        organism.setLifeLength(organism.getLifeLength() + 1);
                    }
                    human.setActivateShield(false);
                }
                else {
                    organism.action();
                    organism.setLifeLength(organism.getLifeLength() + 1);
                }
            }
        }
    }


    public void removeAllDeadOrganism()
    {
        organismList.removeIf(o -> !o.getIsAlive());
    }

    public void saveToFile(String filename)
    {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println(mCols + " " + nRows + " " + numberOfTurn);
            writer.println(organismList.size());
            for (Organism o : organismList) {
                StringBuilder line = new StringBuilder();
                line.append(o.getSymbol()).append(" ").append(o.getPositionX()).append(" ").append(o.getPositionY()).append(" ").append(o.getStrength()).append(" ").append(o.getLifeLength()).append(" ").append(o.getIsAlive() ? 1 : 0);

                if (o instanceof Human)
                {
                    Human h = (Human) o;
                    line.append(" ").append(h.isSkillActive() ? 1 : 0).append(" ").append(h.getSpecialSkillCounter()).append(" ").append(h.getCoolDownSkillCounter());
                }
                writer.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename)))
        {
            mCols = scanner.nextInt();
            nRows = scanner.nextInt();
            numberOfTurn = scanner.nextInt();
            board = new Organism[mCols][nRows];
            organismList.clear();

            int numberOfOrganism = scanner.nextInt();

            for (int i = 0; i < numberOfOrganism; i++)
            {
                char symbol = scanner.next().charAt(0);
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int strength = scanner.nextInt();
                int lifeLength = scanner.nextInt();
                boolean isAlive = scanner.nextInt() == 1;

                Point pos = new Point(x, y);
                createNewOrganismFromSymbol(symbol, pos);
                Organism o = getOrganism(x, y);

                o.setStrength(strength);
                o.setLifeLength(lifeLength);
                o.setIsAlive(isAlive);

                if (o instanceof Human && scanner.hasNextInt())
                {
                    Human h = (Human) o;
                    boolean isSkillActive = scanner.nextInt() == 1;
                    int skillCounter = scanner.nextInt();
                    int cooldownCounter = scanner.nextInt();

                    h.setSkillActive(isSkillActive);
                    h.setSpecialSkillCounter(skillCounter);
                    h.setCoolDownSkillCounter(cooldownCounter);
                }

                addOrganism(o);
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getNumberOfTurn()
    {
        return numberOfTurn;
    }

    public void setNumberOfTurn(int numberOfTurn) {
        this.numberOfTurn = numberOfTurn;
    }

    public int getM() {

        return mCols;
    }

    public int getN() {

        return nRows;
    }

    public void setM(int m) {

        this.mCols = m;
    }

    public void setN(int n) {

        this.nRows = n;
    }

    public Human getHuman() {
        for (Organism o : organismList) {
            if (o instanceof Human) {
                return (Human) o;
            }
        }
        return null;
    }

    public String getTurnMessages() {
        return turnMessages.toString();
    }

    private void log(String msg) {
        turnMessages.append(msg).append("\n");
    }

    public void printResultOfFight(char winner, char loser) {
        log("Fight between " + getOrganismName(winner) + " and " + getOrganismName(loser));
        log(getOrganismName(winner) + " won");
    }

    public void printResultOfPlantEating(char plant, char organism) {
        log("Plant " + getOrganismName(plant) + " eaten by " + getOrganismName(organism));
    }

    public void printSpecialAttack(String nameOfSpecialAttack) {
        log("Special Attack: " + nameOfSpecialAttack);
    }

    public void printResultOfAttack(char attacker, char defender) {
        log("Attack blocked! " + getOrganismName(defender) + " defended!");
    }

    public void printWarning(char symbol) {
        log("WARNING: no place for new " + getOrganismName(symbol));
    }

    public void printNewReproduction(char symbol) {
        log(getOrganismName(symbol) + " have reproduced");
    }

    public void printSeedNewPlant(char symbol) {
        log("New " + getOrganismName(symbol) + " seeded");
    }

    public void setGUI(GameWorldGUI gui) {
        this.gui = gui;
    }

    public void endGame(String reason) {
        if (gui != null) {
            gui.endGame(reason);
        }
    }

    public void clearTurnMessages()
    {
        turnMessages.setLength(0); // usuwa cala zawartosc stringa
    }
}
