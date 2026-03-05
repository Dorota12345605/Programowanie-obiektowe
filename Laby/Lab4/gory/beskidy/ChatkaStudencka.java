package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.beskidy;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class ChatkaStudencka extends Atrakcja
{
    private String nazwaMiejscowosci;
    private String nazwaKlubu;

    public ChatkaStudencka(String nazwaMiejscowosc, String nazwaKlubu) {
        super(0.9);
        this.nazwaMiejscowosci = nazwaMiejscowosc;
        this.nazwaKlubu = nazwaKlubu;
    }

    @Override
    public String getNazwa()
    {
        return "ChatkaStudencka";
    }

    public String getMiejscowosc()
    {
        return nazwaMiejscowosci;
    }

    public String getNazwaKlubu()
    {
        return nazwaKlubu;
    }
}
