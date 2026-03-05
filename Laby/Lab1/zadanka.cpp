#include <iostream>
#include "Prostokat.h"
using namespace std;

int main()
{
    Prostokat p(3, 4);
    cout << p.Obwod() << endl;
    cout << "Hello World!\n";
    cout << p;

    //petla 3 obiekty statyczne i dynamiczne 
    //statyczne
    
    //statycznie
    for (int i = 0; i < 3; i++) {
        Prostokat p(i, i + 1);
    }

    //dynamiczne
    for (int i = 0; i < 3; i++) {
        Prostokat* nowy = new Prostokat(i, i + 1);
    }


}
