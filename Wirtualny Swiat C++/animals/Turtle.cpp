//
// Created by Dorota on 17.04.2025.
//

#include "Turtle.h"

#include <iostream>
using namespace std;

Turtle::Turtle(int x, int y, GameWorld *world): Animal(2, 1, x, y, world,'T') {

}

void Turtle::action() {
    int changePosition = rand()%4;
    if (changePosition==1) {
        Animal::action(); //dziedziczenie ruchu
    }
}

void Turtle::draw() {
    cout<<symbol;
}

bool Turtle::isBlockAttack(Organism *attacker) {
    if (attacker->GetStrength()<5) {
        return true;
    }
    return false;
}



