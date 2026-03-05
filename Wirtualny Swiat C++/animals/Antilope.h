//
// Created by Dorota on 17.04.2025.
//

#ifndef ANTILOPE_H
#define ANTILOPE_H

#include "../Animal.h"


class Antilope: public Animal {
public:
    Antilope(int x, int y, GameWorld* world);
    void draw() override;
    void action() override;
    Point newPostion() override;
    bool isBlockAttack(Organism *attacker) override;
};



#endif //ANTILOPE_H
