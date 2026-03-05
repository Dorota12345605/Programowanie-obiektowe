package pl.edu.pg.eti.ksg.po.lab1.transformacje;

public class Translacja3D implements Transformacja {
    private final double dX,dY, dZ;
    public Translacja3D(double dX, double dY, double dZ) {
        this.dX = dX;
        this.dY = dY;
        this.dZ = dZ;
    }
    @Override
    public Transformacja getTransformacjaOdwrotna() {

        return new Translacja3D(-dX, -dY, -dZ);
    }
    @Override
    public Punkt transformuj(Punkt p) {
        Punkt3D newP = (Punkt3D) p;
        return new Punkt3D(newP.getX() + dX, newP.getY() + dY, newP.getZ()+dZ);
    }
    public double getdX() {

        return dX;
    }
    public double getdY() {

        return dY;
    }
    public double getdZ() {

        return dZ;
    }
    @Override
    public String toString() {
        return "Translacja o wektor 3D ("+dX+","+dY+","+dZ+")";
    }
}
