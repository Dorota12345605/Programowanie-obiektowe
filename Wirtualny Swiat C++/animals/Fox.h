//
// Created by Dorota on 17.04.2025.
//

#ifndef FOX_H
#define FOX_H
#include "../Animal.h"


class Fox: public Animal
{
public:
    Fox(int x, int y, GameWorld* world);
    void draw() override;
    void action() override;
    Point newPostion() override;
};

#endif //FOX_H
