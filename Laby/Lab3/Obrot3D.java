package pl.edu.pg.eti.ksg.po.lab1.transformacje;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Obrot3D extends ObrotOS{
    double beta, gamma;
    public Obrot3D(double alfa, double beta, double gamma) {
        super(alfa);
        beta=Math.toRadians(beta);
        gamma=Math.toRadians(gamma);
        this.beta = beta;
        this.gamma = gamma;
    }
    @Override
    public Punkt transformuj(Punkt p) {
        Punkt3D newP = (Punkt3D) p;
        newP=transformuj3D('x', getAlfa(), newP);
        newP=transformuj3D('y', beta, newP);
        newP=transformuj3D('z', gamma, newP);

        return new Punkt3D(newP.getX(), newP.getY(), newP.getZ());
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() throws
            BrakTransformacjiOdwrotnejException {
        return new Obrot3D(-getAlfa(), -beta, -gamma);
    }

    @Override
    public String toString() {
        return "Obrot 3D " + getAlfa() + ", " + beta + ", " + gamma;
    }
}
