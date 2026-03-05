#ifndef HUMAN_H
#define HUMAN_H
#include "../Animal.h"
#include "../GameWorld.h"

class Human: public Animal{
    bool isSkillActive=true;
    int specialSkillCounter=5;
    int coolDownSkillCounter=0;
    void updateSkill();
 public:
    Human(int x, int y, GameWorld* world);
    void draw() override;
    Point newPostion() override;
    bool isBlockAttack(Organism *attacker) override;


};


#endif //HUMAN_H
