#ifndef SHEEP_H
#define SHEEP_H
#include "../Animal.h"


class Sheep: public Animal{
public:
    Sheep(int x, int y, GameWorld* world);
    void draw() override;
    void action() override;
};


#endif //SHEEP_H
