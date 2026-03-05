package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Wycieczka;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.Panorama;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.CmentarzZIWojny;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.DrewnianaCerkiew;

public class PrzewodnikBeskidzki extends Czlowiek{

    protected PrzewodnikBeskidzki(String imie, String nazwisko, Plec plec) {
        super(imie, nazwisko, plec, 5.0, 10, 10);
    }

    @Override
    public int getUmiejetnosciNawigacyjne() {
        return 4;
    }

    @Override
    public void opiszWycieczke(Wycieczka wycieczka) {
        mow("Szanowna grupo, proszę o uwagę. Teraz opowiem Wam o wycieczce.");
        super.opiszWycieczke(wycieczka);
    }

    @Override
    public void reagujNaAtrakcje(Atrakcja a, double czas) {
        if(a instanceof DrewnianaCerkiew) {
            DrewnianaCerkiew cerkiewka = (DrewnianaCerkiew) a;
            mow("Szanowni Panstwo to jest drewniana cerkiew w miejcowości " + cerkiewka.getMiejscowosc() + ". Jest ona bardzo popularna i wiele można takich spotkać w Beskidach. ");
            regeneruj(czas);
        }

        else if(a instanceof CmentarzZIWojny) {
            CmentarzZIWojny cmentarz = (CmentarzZIWojny) a;
            mow("Tutaj widzimy cmentarz z I Wojny Światowej w miejcowości "+cmentarz.getMiejscowosc()+". Takie cmentarze były kiedys bardzo popularne.");
            regeneruj(czas);
        }
        else {
            super.reagujNaAtrakcje(a, czas);
        }
    }

}
