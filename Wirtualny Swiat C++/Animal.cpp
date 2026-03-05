//
// Created by Dorota on 17.04.2025.
//

#include "Animal.h"
#include "Organism.h"
#include "GameWorld.h"
#include <cstdlib>

Animal::Animal(int strength, int initiative, int x, int y, GameWorld *gameWorld, char symbol): Organism(strength, initiative, x, y,
    gameWorld, symbol, 0, true) {
}

bool Animal::isBlockAttack(Organism *attacker) {
    return false;
}

bool Animal::isAbleToEscape(Organism *attacker) {
    return false;
}

Point Animal::newPostion() {
    int newX=0, newY=0;
    int oldPosX = GetPositionX();
    int oldPosY = GetPositionY();

    do {
        newX = oldPosX + rand()%3-1; //-1 1
        newY = oldPosY + rand()%3-1;
    }while (gameWorld->isOkay(newX, newY)==false || (newX==oldPosX && newY==oldPosY));
    return {newX, newY};
}

void Animal::collision( Organism* defender)
{
    if (defender->isBlockAttack(this)) {
        // Jeśli obrońca odbił atak na stare miejsce
        gameWorld->printResultOfAttack(this->GetSymbol(), defender->GetSymbol());
        return;
    }

    if (isAbleToEscape(defender)) {
        //wtedy przesun sie na pole sasiednie ktore jest wolne
        Point newPoints=findFreeNeibourPlace(Point{this->GetPositionX(), this->GetPositionY()});
        if (newPoints.getX()==-1 && newPoints.getY()==-1) {
            gameWorld->printWarning(this->GetSymbol());
            return;
        }
        gameWorld->moveOrganism(newPoints.getX(), newPoints.getY(), this->GetPositionX(), this->GetPositionY());
        return;
    }

    if ((this->GetStrength() > defender->GetStrength()) || (this->GetStrength() == defender->GetStrength()))
    {
        gameWorld->moveOrganism(defender->GetPositionX(), defender->GetPositionY(), this->GetPositionX(), this->GetPositionY()); //to odrazu zeruje ta stara pozycje
        defender->SetIsAlive(false);
        //moze byc roslinka
        if (defender->isAnimal()) {
            gameWorld->printResultOfFight(this->GetSymbol(), defender->GetSymbol());
        }
        else {
            gameWorld->printResultOfPlantEating(defender->GetSymbol(),this->GetSymbol());
        }

    }

    else { //mnijesza atakujacy przegrywa
        //tutaj trzeba usunac attackera i tamtetego nie ruszac
        gameWorld->killOrganism(this);
        this->SetIsAlive(false);
        // gameWorld->removeElement(this);
        gameWorld->printResultOfFight(defender->GetSymbol(), this->GetSymbol());
    }

}

void Animal::action() {
    //wybrane losowo sasiednie pole
    Point point=newPostion();

    //sprawdzenie czy jest takie same
    if (this->GetPositionX()==point.getX() && this->GetPositionY()==point.getY()) {
        return;
    }
    Organism* defender = gameWorld->getOrganism(point.getX(), point.getY());
    //sprawdzenie kolizji
    if (defender!= nullptr)  //cos tu jest zaczyna sie atak
    {
        if (defender->GetSymbol() == this->GetSymbol()) {
            cout<<defender->GetSymbol()<<" "<<this->GetSymbol()<<endl;

            Point newPoints=findFreeNeibourPlace(Point{this->GetPositionX(), this->GetPositionY()});
            if (newPoints.getX()==-1 && newPoints.getY()==-1) {
                gameWorld->printWarning(this->GetSymbol());
                return;
            }
            else {
                gameWorld->createNewOrganismFromSymbol(this->GetSymbol(), newPoints); //juz jest dodane
                gameWorld->printNewOrganismCreated(this->GetSymbol());
            }
        }
        else {
            this->collision(defender);
        }
    }
    else {
        int oldPosX = GetPositionX();
        int oldPosY = GetPositionY();
        gameWorld->moveOrganism(point.getX(), point.getY(), oldPosX, oldPosY);
    }
    
}

Point Animal::helperNewPositon(int oldX, int oldY, GameWorld *gameWorld) {
    int newX, newY;
    do {
        newX = oldX + rand() % 3 - 1;
        newY = oldY + rand() % 3 - 1;
    } while (!gameWorld->isOkay(newX, newY) || (newX == oldX && newY == oldY));

    return {newX, newY};
}

bool Animal::isAnimal() const {
    return true;
}



