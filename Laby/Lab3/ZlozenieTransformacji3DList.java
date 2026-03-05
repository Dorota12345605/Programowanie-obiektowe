package pl.edu.pg.eti.ksg.po.lab1.transformacje;

import java.util.ArrayList;

public class ZlozenieTransformacji3DList implements Transformacja{
    private ArrayList<Transformacja> tab;

    ZlozenieTransformacji3DList(ArrayList<Transformacja> tab)
    {
        this.tab = tab;
    }

    public ArrayList<Transformacja> getTab()
    {
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
        Punkt3D newP = (Punkt3D) p;
        Punkt3D temp = new Punkt3D(newP.getX(), newP.getY(), newP.getZ());
        for(int i = 0; i<tab.size(); i++){
            temp = (Punkt3D)tab.get(i).transformuj(temp);
        }
        return temp;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() throws
            BrakTransformacjiOdwrotnejException {
        Transformacja [] OdwrotnaTransformacja = new Transformacja [tab.size()];
        for(int i = 0; i<tab.size(); i++){
            OdwrotnaTransformacja[i]=tab.get(i).getTransformacjaOdwrotna();
        }
        return new ZlozenieTransformacji(OdwrotnaTransformacja);
    }


    @Override
    public String toString() {
        StringBuffer string = new StringBuffer();
        for(int i = 0; i<tab.size(); i++){
            string.append(tab.get(i).toString());
        }
        return string.toString();
    }
}
