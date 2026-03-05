package pl.edu.pg.eti.ksg.po.lab1.transformacje;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class ObrotOS extends Obrot {

    public ObrotOS(double alfa) {
       super(alfa);
    }

    public Punkt3D transformuj3D(char os, double kat, Punkt3D p)
    {   double xP=p.getX();
        double yP=p.getY();
        double zP=p.getZ();
        if(os == 'z'){
            xP=p.getX()*cos(kat)-p.getY()*sin(kat);
            yP=p.getX()*sin(kat)+p.getY()*cos(kat);
        }
        else if(os == 'x'){
            yP=p.getY()*cos(kat)-p.getZ()*sin(kat);
            zP=p.getY()*sin(kat)+p.getZ()*cos(kat);
        }

        else if(os == 'y'){
            xP=p.getX()*cos(kat)+p.getZ()*sin(kat);
            zP=-p.getX()*sin(kat)+p.getZ()*cos(kat);
        }

        return new Punkt3D(xP, yP, zP);
    }

//    @Override
//    public Transformacja getTransformacjaOdwrotna() throws
//            BrakTransformacjiOdwrotnejException {
//        return new Obrot(-alfa);
//    }

    @Override
    public String toString() {
        return "Obrot OS";
    }
}
