package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.Panorama;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.CmentarzZIWojny;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.DrewnianaCerkiew;

public class MistrzPanoram extends Czlowiek {
    public MistrzPanoram(String imie, String nazwisko, Plec plec) {

        super(imie, nazwisko, plec, 15, 10, 20);
    }

    @Override
    public int getUmiejetnosciNawigacyjne()
    {
        return 5;
    }

    @Override
    public void reagujNaAtrakcje(Atrakcja a, double czas) {
        if(a instanceof Panorama) {
            mow("Ale sliczna panorama. Woooooow. ");
            regeneruj(2*czas);
        }
        else {
            super.reagujNaAtrakcje(a, czas);
        }
    }
}
