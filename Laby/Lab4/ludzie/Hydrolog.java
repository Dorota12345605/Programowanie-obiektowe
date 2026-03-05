package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Wedrowka;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.Panorama;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.ZalanyLas;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.CmentarzZIWojny;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.DrewnianaCerkiew;

import java.util.List;

public class Hydrolog extends Czlowiek {
    private List<Double> danePrzewodnosci;
    private List<Double> danePh;


    public Hydrolog(String imie, String nazwisko, Plec plec) {

        super(imie, nazwisko, plec, 10, 13, 20);

    }

    public double obliczPrzewodnosc() {
        return Math.random() * 2000 + 1000;
    }

    public double obliczPh(){
        return Math.random() * 14;
    }

    public void dodajPomiary(double przewodnosc, double ph) {
        danePrzewodnosci.add(przewodnosc);
        danePh.add(ph);
    }


    @Override
    public int getUmiejetnosciNawigacyjne()
    {
        return 8;
    }

    @Override
    public void reagujNaWedrowke(Wedrowka w, double czas) {
        if(w instanceof ZalanyLas){
            mow("Uuu! Gdybym mogl pomierzyłbym wszytko, co sie da!!!");
            aktualizujZmeczenie(czas);
            double przewodnosc = obliczPrzewodnosc();
            double ph = obliczPh();
            dodajPomiary(przewodnosc,ph);
        }
        else
            super.reagujNaWedrowke(w, czas);
    }
}
