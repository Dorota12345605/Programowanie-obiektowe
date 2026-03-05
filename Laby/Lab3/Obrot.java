package pl.edu.pg.eti.ksg.po.lab1.transformacje;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Obrot implements Transformacja {
    private double alfa;
    public Obrot(double alfa) {
        alfa=Math.toRadians(alfa);
        this.alfa = alfa;
    }
    public double getAlfa() {
        return alfa;
    }

    void setAlfa(double alfa) {
        this.alfa = alfa;
    }

    @Override
    public Punkt transformuj(Punkt p) {
        double xP=p.getX()*cos(alfa)-p.getY()*sin(alfa);
        double yP=p.getX()*sin(alfa)+p.getY()*cos(alfa);
        return new Punkt(xP, yP);
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() throws
            BrakTransformacjiOdwrotnejException {
        return new Obrot(-alfa);
    }

    @Override
    public String toString() {
        return "Obrot o "+ alfa +" radianow";
    }
}
