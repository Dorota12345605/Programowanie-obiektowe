#ifndef ANIMAL_H
#define ANIMAL_H
#include "Organism.h"

class Animal: public Organism
{
public:
    Animal(int strength, int initiative, int x, int y, GameWorld* world, char symbol);
    void action() override;
    void collision(Organism * defender) override;

    Point newPostion() override;
    bool isBlockAttack(Organism *attacker) override;
    bool isAbleToEscape(Organism *attacker) override;
    static Point helperNewPositon(int x, int y, GameWorld* world);
    bool isAnimal() const override;
};

#endif //ANIMAL_H
