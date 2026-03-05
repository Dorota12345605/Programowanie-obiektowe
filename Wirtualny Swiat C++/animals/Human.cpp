#include "Human.h"
#include "../Animal.h"
#include <conio.h>

#include <iostream>
using namespace std;

//czlowiek to bedzie malpa
Human::Human(int x, int y, GameWorld *world): Animal(5, 4, x, y, world, '@'){
}

void Human::draw() {
    cout<<symbol;
}

void Human::updateSkill() {
    if (isSkillActive== false && coolDownSkillCounter==0) {
        isSkillActive=true;
        specialSkillCounter=5;
    }
    else if (isSkillActive && coolDownSkillCounter==0 && specialSkillCounter>0) {
        specialSkillCounter--;
        if (specialSkillCounter==0) {
            isSkillActive=false;
            coolDownSkillCounter=5;
        }
    }
    else {
        coolDownSkillCounter-=1;
    }
}


bool Human::isBlockAttack(Organism *attacker) {
    if (attacker == nullptr) {
        cout << "Something went wrong" << endl;
        return false;
    }

    if (isSkillActive==true && attacker->isAnimal())//mozna juz aktywowac umiejetnosc czlowieka
    {
        cout<<"Press special key to get 'tarcza Alazura'!"<<endl;
          // sprawdza, czy naciśnięto klawisz
            char key = getch();
            // Jeśli naciśnięto klawisz "S" (dla skill)
            if (key == 'v') {
                gameWorld->printSpecialAttack("tarcza Alazura");
                updateSkill();
                //odstraszenie wszytkich zwierzat przesuniecie na losowa pozycje sasiednia

                // Losowanie pozycji przy człowieku
                Point newPos = this->helperNewPositon(this->GetPositionX(), this->GetPositionY(), gameWorld);

                // Przeniesienie atakującego ze swojego obecnego miejsca na nowe
                int oldX = attacker->GetPositionX();
                int oldY = attacker->GetPositionY();

                gameWorld->moveOrganism(newPos.getX(), newPos.getY(), attacker->GetPositionX(), attacker->GetPositionY());
                return true;
            }
    }
    return false;
}


Point Human::newPostion() {
    do{
        cout << "Enter the direction of human movement" << endl;
        unsigned char character= getch();
        int dX=0, dY=0;
        if (character == 0 || character == 224) {
            // sygnał specjalnego klawisza (np. strzałka)
            character = getch();
            switch (character) {
                case 72: //gora
                    dY = -1;
                break;
                case 80: //dol
                    dY = 1;
                break;
                case 75: //lewo
                    dX = -1;
                break;
                case 77: //prawo
                    dX = 1;
                break;
                default:
                    break;
            }
        }
        if (dX==0 && dY==0) {
            cout<<"Something went wrong press arrow keys"<<endl;
        }
        else if (gameWorld->isOkay(GetPositionX()+dX, GetPositionY()+dY)) {
            return Point(GetPositionX()+dX, GetPositionY()+dY);
        }
        else {
            cout<<"You cannot go further"<<endl;
        }
    }while(true);
}