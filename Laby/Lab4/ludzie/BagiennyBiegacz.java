package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Wedrowka;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.BlotnistaDroga;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.Panorama;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.PrzeprawaPrzezRzeke;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.CmentarzZIWojny;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.DrewnianaCerkiew;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.Czlowiek;

//meczy sie dwa razy wolniej na terenach podmoklych
public class BagiennyBiegacz extends Czlowiek {

    public BagiennyBiegacz(String imie, String nazwisko, Plec plec) {

        super(imie, nazwisko, plec, 6.0, 15, 16);
    }

    @Override
    public int getUmiejetnosciNawigacyjne() {

        return 3;
    }

    @Override
    public void reagujNaAtrakcje(Atrakcja a, double czas)
    {
        super.reagujNaAtrakcje(a, czas);
    }

    @Override
    public void reagujNaWedrowke(Wedrowka w, double czas) {
        if(w instanceof BlotnistaDroga){
            mow("Uuu! Uwielbiam mokre tereny!");
            aktualizujZmeczenie(2*czas);
        }
        else
            super.reagujNaWedrowke(w, czas);
    }

}
