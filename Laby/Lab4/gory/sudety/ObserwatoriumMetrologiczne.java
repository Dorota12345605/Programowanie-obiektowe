package pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.gory.sudety;

import pl.edu.pg.eti.ksg.po.lab2.symulatorwycieczki.Atrakcja;

public class ObserwatoriumMetrologiczne extends Atrakcja {
    String nazwaMiejscowosci;
    public ObserwatoriumMetrologiczne(String nazwaMiejscowosci) {
        super(0.6);
        this.nazwaMiejscowosci = nazwaMiejscowosci;
    }

    @Override
    public String getNazwa(){
        return "ObserwatoriumMetrologiczne";
    }


    public String getMiejscowosc() {
        return nazwaMiejscowosci;
    }
}
