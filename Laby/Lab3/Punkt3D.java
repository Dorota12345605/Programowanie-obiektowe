package pl.edu.pg.eti.ksg.po.lab1.transformacje;

public class Punkt3D extends Punkt {
    private double z;
    public Punkt3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Punkt3D) {
            Punkt3D p = (Punkt3D) obj;
            return getX() == p.getX() && getY() == p.getY() && z==p.z;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {

        return 59 * Double.hashCode(getX())+ 59* Double.hashCode(getY())+ 59* Double.hashCode(getZ()) + 7;
    }

    @Override
    public String toString() {

        return "Instancja klasy Punkt o wspolrzednych "+ getX()+", "+getY()+", "+z;
    }

}
