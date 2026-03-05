package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Wedrowka;

/**
 * @author TB
 */
public class PrzeprawaPrzezRzeke extends Wedrowka{

    public PrzeprawaPrzezRzeke(double odleglosc) {
        super(odleglosc);
    }

    @Override
    public double modyfikujPredkoscGrupy(double predkosc) {
        return 0.1f * predkosc;
    }

    @Override
    public int getTrudnoscNawigacyjna() {
        return 9;
    }

    @Override
    public String getNazwa() {
        return "Przeprawa przez rzeke";
    }


}

