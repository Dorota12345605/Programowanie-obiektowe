package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.sudety;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class WychodneSkalne  extends Atrakcja {
    String nazwaMiejscowosci;
    public WychodneSkalne(String nazwaMiejscowosci) {
        super(0.1);
        this.nazwaMiejscowosci = nazwaMiejscowosci;
    }

    @Override
    public String getNazwa(){
        return "WychodneSkalne";
    }


    public String getMiejscowosc() {
        return nazwaMiejscowosci;
    }
}
