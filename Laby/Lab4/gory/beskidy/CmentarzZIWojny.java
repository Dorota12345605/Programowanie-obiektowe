package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class CmentarzZIWojny extends Atrakcja {
    String nazwaMiejscowosci;
    public CmentarzZIWojny(String nazwaMiejscowosci) {
        super(0.6);
        this.nazwaMiejscowosci = nazwaMiejscowosci;
    }

    @Override
    public String getNazwa(){
        return "CmentarzZIWojny";
    }


    public String getMiejscowosc() {
        return nazwaMiejscowosci;
    }
}
