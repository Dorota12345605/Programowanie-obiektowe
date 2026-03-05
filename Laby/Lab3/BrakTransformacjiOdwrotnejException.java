package pl.edu.pg.eti.ksg.po.lab1.transformacje;

public class BrakTransformacjiOdwrotnejException extends Exception {
    public BrakTransformacjiOdwrotnejException() {
        super();
    }

    //tekst opisujacy blad
    public BrakTransformacjiOdwrotnejException(String message) {
        super(message);
    }
    //przyjmuje jako parametr refernecje, ktory spowodowal
    public BrakTransformacjiOdwrotnejException(Throwable cause) {
        super(cause);
    }
    //opisujacy blad i wyjatek ktory spowodowal
    public BrakTransformacjiOdwrotnejException(String message, Throwable cause) {
        super(message, cause);
    }
}
