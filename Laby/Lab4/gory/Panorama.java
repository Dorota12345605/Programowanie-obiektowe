package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class Panorama extends Atrakcja {
    String nazwa;
    public Panorama(String nazwa) {
        super(0.5);
        this.nazwa = nazwa;

    }

    @Override
    public String getNazwa(){
        return "DrewnianaCerkiew";
    }


    public String getMiejscowosc() {
        return nazwa;
    }
}

