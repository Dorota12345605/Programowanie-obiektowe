//
// Created by Dorota on 17.04.2025.
//

#include "Antilope.h"
#include "../GameWorld.h"
#include <iostream>
using namespace std;

Antilope::Antilope(int x, int y, GameWorld *world): Animal(4, 4, x, y, world, 'A') {

}

void Antilope::draw() {
    cout<<symbol;
}

void Antilope::action() {
    Animal::action(); //dziedziczenie ruchu
}

Point Antilope::newPostion() {
    int newX=0, newY=0;
    int oldPosX = GetPositionX();
    int oldPosY = GetPositionY();

    do {
        newX = oldPosX + (rand()%3-1)*2; //-1 1
        newY = oldPosY + (rand()%3-1)*2;
    }while (gameWorld->isOkay(newX, newY)==false || (newX==oldPosX && newY==oldPosY));
    return {newX, newY};
}

bool Antilope::isBlockAttack(Organism *attacker) {
    int randNum = rand()%2; //50 procent szans
    if (randNum==0) {
        return true;
    }
    return false;
}
