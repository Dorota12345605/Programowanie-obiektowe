//
// Created by Dorota on 17.04.2025.
//

#include "Wolf.h"

#include "../GameWorld.h"

Wolf::Wolf(int x, int y, GameWorld* game_world): Animal(9, 5, x, y, game_world, 'W') {

}


void Wolf::draw() {
    cout << symbol;
}

void Wolf::action() {
    Animal::action(); //dziedziczenie ruchu
}