#include "Fox.h"
#include "../GameWorld.h"

#include <iostream>
using namespace std;

Fox::Fox(int x, int y, GameWorld *world): Animal(3, 7, x, y, world, 'F') {

}

void Fox::draw() {
    cout<<symbol;
}

void Fox::action() {
    Animal::action(); //dziedziczenie ruchu
}


Point Fox::newPostion() {
    int oldPosX = GetPositionX();
    int oldPosY = GetPositionY();
    Point newPoint={oldPosX, oldPosY};
    vector <Point> newSafePosition;

    for (int i = -1; i <= 1; ++i) {
        for (int j=-1; j<=1; ++j) {
            if (i==0 && j==0) {
                continue;
            }
            newPoint = {oldPosX+i, oldPosY+j};

            if (!gameWorld->isOkay(newPoint.getX(), newPoint.getY())) continue;

            Organism* other = gameWorld->getOrganism(newPoint.getX(), newPoint.getY());

            if (other == nullptr || this->GetStrength() >= other->GetStrength()) {
                newSafePosition.push_back(newPoint);
            }

        }
    }
    if (!newSafePosition.empty()) {
        int randNum = rand()%newSafePosition.size();
        newPoint = newSafePosition[randNum];
    }

    // Jeśli nie znalazł żadnego bezpiecznego miejsca
    return newPoint;
}
