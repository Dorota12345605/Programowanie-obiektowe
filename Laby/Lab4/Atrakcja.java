package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki;

public abstract class Atrakcja implements ElementWycieczki{
    //jak dlugo uczestnicy beda zwiedzac

    double dlugoscZwiedzania;

    protected Atrakcja(double dlugoscZwiedzania){
        this.dlugoscZwiedzania= dlugoscZwiedzania;
    }

    double getDlugoscZwiedzania(){
        return dlugoscZwiedzania;
    }

    @Override
    public abstract String getNazwa();

}
