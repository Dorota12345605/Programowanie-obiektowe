package pl.edu.pg.eti.ksg.po.lab2;

import java.util.HashSet;
import java.util.Set;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Grupa;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.SymulatorWycieczki;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Uczestnik;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Wycieczka;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.*;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.ChatkaStudencka;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.CmentarzZIWojny;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy.DrewnianaCerkiew;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.sudety.BagnoGorskie;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.sudety.ObserwatoriumMetrologiczne;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.sudety.WietrznaGran;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.sudety.WychodneSkalne;
import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.ludzie.*;

/**
 *
 * @author TB
 */
public class JavaLab2 {
    public static void main(String[] args) {
        Wycieczka w = wlasna();

        PrzewodnikStudencki przewodnik = new PrzewodnikStudencki("Stefan", "Długonogi", Czlowiek.Plec.MEZCZYZNA);
        Set<Uczestnik> uczestnicy = new HashSet<>();
        uczestnicy.add(new Student("Alojzy", "Mechanik", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new Hydrolog("Ada", "Lovelace", Czlowiek.Plec.KOBIETA));
        uczestnicy.add(new MistrzPanoram("Jan", "Elektronik", Czlowiek.Plec.MEZCZYZNA));
        uczestnicy.add(new PrzewodnikStudencki("Kasia","Teledetekcyjny", Czlowiek.Plec.KOBIETA));
        uczestnicy.add(new BagiennyBiegacz("Asia","Tele", Czlowiek.Plec.KOBIETA));

        
        Grupa g = new Grupa(przewodnik, uczestnicy);
        
        SymulatorWycieczki symulator = new SymulatorWycieczki(g, w);

        //implementacja klasy anonimowej
        symulator.dodajSluchacza2();

        symulator.dodajSluchacza((element, lp, liczbaElementow)->
                System.out.printf("Postęp: %d/%d - %s\n", lp, liczbaElementow, element.getNazwa())
        );


        
        symulator.symuluj();
    }
    
    public static Wycieczka doDydiowki() {
        Wycieczka ret = new Wycieczka("Do Dydiówki");
        ret.dodajElementWycieczki(new Droga(1.0));
        ret.dodajElementWycieczki(new DrewnianaCerkiew("Smolnik"));
        ret.dodajElementWycieczki(new Droga(4.0));
        ret.dodajElementWycieczki(new PrzeprawaPrzezRzeke(1.0));
        ret.dodajElementWycieczki(new GestyLas(2.0));
        ret.dodajElementWycieczki(new Las(2.0));
        ret.dodajElementWycieczki(new Droga(5.0));
        
        return ret;
    }

    public static Wycieczka wlasna(){
        Wycieczka ret = new Wycieczka("WlasnaNaLaby");
        //wedrowka
        ret.dodajElementWycieczki(new WietrznaGran(1.0));
        ret.dodajElementWycieczki(new WychodneSkalne("Sierniewice"));
        ret.dodajElementWycieczki(new BagnoGorskie(1.1));
        ret.dodajElementWycieczki(new ObserwatoriumMetrologiczne("Tychy"));
        ret.dodajElementWycieczki(new PrzeprawaPrzezRzeke(0.2));

        return ret;
    }


   
}
