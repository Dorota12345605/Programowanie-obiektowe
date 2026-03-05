package pl.edu.pg.eti.ksg.po.lab1.transformacje;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class ZlozenieTransformacji implements Transformacja{
    private Transformacja [] tab;

    ZlozenieTransformacji(Transformacja [] tab) {

        this.tab = tab;
    }

    public Transformacja [] getTab() {

        return tab;
    }

//    @Override
//    public Punkt transformuj(Punkt p) {
//        for(int i=0;i<tab.length;i++){
//            p=tab[i].transformuj(p);
//        }
//        return p;
//    }

    @Override
    public Punkt transformuj(Punkt p) {
        Punkt temp = new Punkt(p.getX(), p.getY());
        for(int i = 0; i<tab.length; i++){
            temp = tab[i].transformuj(temp);
        }
        return temp;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() throws
            BrakTransformacjiOdwrotnejException {
        Transformacja [] OdwrotnaTransformacja = new Transformacja [tab.length];
       for(int i = 0; i<tab.length; i++){
           OdwrotnaTransformacja[i]=tab[i].getTransformacjaOdwrotna();
       }
        return new ZlozenieTransformacji(OdwrotnaTransformacja);
    }


    @Override
    public String toString() {
        StringBuffer string = new StringBuffer();
        for(int i = 0; i<tab.length; i++){
            string.append(tab[i].toString());
        }
        return string.toString();
    }
}
