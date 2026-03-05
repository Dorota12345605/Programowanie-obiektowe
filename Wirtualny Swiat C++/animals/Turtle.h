#ifndef TURTLE_H
#define TURTLE_H
#include "../Animal.h"

class Turtle: public Animal{
    public:
        Turtle(int x, int y, GameWorld* world);
        void draw() override;
        void action() override;
        bool isBlockAttack(Organism *attacker) override;
};


#endif //TURTLE_H
