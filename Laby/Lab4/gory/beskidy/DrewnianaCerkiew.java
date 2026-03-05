package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class DrewnianaCerkiew extends Atrakcja {
    String nazwa;
    String nazwaMiejscowosci;
    public DrewnianaCerkiew(String nazwa) {
        super(0.5);
        this.nazwa = nazwa;
        this.nazwaMiejscowosci = nazwa;

    }

    @Override
    public String getNazwa(){
        return "DrewnianaCerkiew";
    }


    public String getMiejscowosc() {
        return nazwaMiejscowosci;
    }
}
