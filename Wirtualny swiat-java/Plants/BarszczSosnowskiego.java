package Plants;

import World.GameWorld;
import World.Organism;
import World.Plant;
import Animals.Human;

//animal i gameWorld

public class BarszczSosnowskiego extends Plant {
    public BarszczSosnowskiego(int x, int y, GameWorld world) {
        super(10, x, y, world, 'U');
    }

    @Override
    public boolean isBlockAttack(Organism attacker) {
        gameWorld.killOrganism(attacker);
        attacker.setIsAlive(false);
        if (attacker instanceof Human) {
            gameWorld.endGame("Human was killed by attacking Barszcz Sosnowskiego");
        }
        return false;
    }

    @Override
    public void action() {
        // Zabija sasiadujace zwierzeta
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int nx = getPositionX() + i;
                int ny = getPositionY() + j;

                if (!gameWorld.isOkay(nx, ny))
                    continue;

                Organism neighbor = gameWorld.getOrganism(nx, ny);
                if (neighbor != null && neighbor.isAnimal()) {
                    gameWorld.killOrganism(neighbor);
                    neighbor.setIsAlive(false);
                    gameWorld.printResultOfFight(getSymbol(), neighbor.getSymbol());

                    if (neighbor instanceof Human) {
                        gameWorld.endGame("Human was killed by Barszcz Sosnowskiego.");
                    }
                }
            }
        }

        // proba rozsiewu
        super.action();
    }
}


