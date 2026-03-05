package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Wedrowka;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.GestyLas;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.CmentarzZIWojny;

public class CzlowiekZKontuzja extends Czlowiek
{
    public CzlowiekZKontuzja(String imie, String nazwisko, Plec plec) {
        super(imie, nazwisko, plec, 10, 21, 10);
    }

    @Override
    public int getUmiejetnosciNawigacyjne()
    {

        return 1;
    }

    @Override
    public void reagujNaWedrowke(Wedrowka w, double czas) {

        if(w instanceof GestyLas) {
            GestyLas gestLas = (GestyLas) w;
            mow("Nie mam juz sily w tym gestym lesie, mam kontuzje ");
            aktualizujZmeczenie(czas);
        }
        else {
            super.reagujNaWedrowke(w, czas);
        }
    }
}
