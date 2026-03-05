//
// Created by Dorota on 17.04.2025.
//
#include "Sheep.h"
#include <iostream>
using namespace std;

#include "../Animal.h"

Sheep::Sheep(int x, int y, GameWorld* game_world): Animal(4, 4, x, y, game_world, 'S') {
}

void Sheep::draw() {
    cout << symbol;
}

void Sheep::action(){
    Animal::action(); //dziedziczenie ruchu
}