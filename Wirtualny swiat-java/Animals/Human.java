package Animals;

import World.Organism;
import World.Animal;
import World.GameWorld;
import World.Point;

public class Human extends Animal {
    private boolean isSkillActive = false;
    private int specialSkillCounter = 0;
    private int coolDownSkillCounter = 0;

    // gui sterowanie
    private int inputDX = 0;
    private int inputDY = 0;
    private boolean activateShield = false;
    public boolean isHuman = true;

    public Human(int x, int y, GameWorld world) {
        super(5, 4, x, y, world, '@');
    }

    @Override
    public void draw() {
        System.out.print(symbol);
    }

    public void updateSkill() {
        if (isSkillActive) {
            specialSkillCounter--;
            if (specialSkillCounter == 0) {
                isSkillActive = false;
                coolDownSkillCounter = 5;
            }
        } else if (coolDownSkillCounter > 0) {
            coolDownSkillCounter--;
        }
    }

    public String getShieldStatus() {
        if (isSkillActive) {
            return "Tarcza Alazura is ACTIVE (" + specialSkillCounter + " turns left)";
        } else if (coolDownSkillCounter > 0) {
            return "Tarcza Alazura is on cooldown (" + coolDownSkillCounter + " turns left)";
        } else {
            return "Tarcza Alazura is READY to activate (press V)";
        }
    }

    @Override
    public boolean isBlockAttack(Organism attacker) {
        if (attacker == null) return false;

        if (isSkillActive && attacker.isAnimal()) {
            gameWorld.printSpecialAttack("Tarcza Alazura defended human!");

            Point newPos = findFreeNeighbourPlace(new Point(getPositionX(), getPositionY()));
            if (newPos.getX() != -1 && newPos.getY() != -1) {
                gameWorld.moveOrganism(newPos.getX(), newPos.getY(), attacker.getPositionX(), attacker.getPositionY());
            } else {
                gameWorld.printWarning(attacker.getSymbol());
            }

            return true;
        }

        return false;
    }

    @Override
    public Point newPosition() {
        int newX = getPositionX() + inputDX;
        int newY = getPositionY() + inputDY;

        if (gameWorld.isOkay(newX, newY)) {
            return new Point(newX, newY);
        }

        return new Point(getPositionX(), getPositionY());
    }

    // gui
    public void setMoveDirection(int dx, int dy) {
        this.inputDX = dx;
        this.inputDY = dy;
    }

    public void setActivateShield(boolean activate)
    {
        if (activate && isSkillReady()) {
            isSkillActive = true;
            specialSkillCounter = 5;
        }
        else if (activate && !isSkillReady()) {
            gameWorld.printSpecialAttack("You cannot activate the shield!");
        }

        this.activateShield = false; //reset
    }

    public boolean isSkillReady() {
        if (!isSkillActive && coolDownSkillCounter == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasMoved() {
        if (inputDX != 0 || inputDY != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void resetMoveDirection() {
        inputDX = 0;
        inputDY = 0;
    }

    public boolean isSkillActive() {
        return isSkillActive;
    }

    public int getSpecialSkillCounter() {
        return specialSkillCounter;
    }

    public int getCoolDownSkillCounter() {
        return coolDownSkillCounter;
    }

    public void setSkillActive(boolean active) {
        this.isSkillActive = active;
    }

    public void setSpecialSkillCounter(int value) {
        this.specialSkillCounter = value;
    }

    public void setCoolDownSkillCounter(int value) {
        this.coolDownSkillCounter = value;
    }

}
