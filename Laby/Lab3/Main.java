package pl.edu.pg.eti.ksg.po.lab1.transformacje;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
         * Konstrukcja językowa try {} catch (...){} służy do
         * obsługi wyjątków. Kod w bloku try jest monitorowany
         * pod kątem wystąpienia wyjątku bądź wyjątków
         * wspomnianych na początku bloku/bloków catch.
         * Jeżeli gdzieś w bloku try wystąpi wyjątek, to sterowanie
         * zostanie natychmiast przeniesione do bloku catch.
         * Tam powinien znajdować się kod obsługujący wyjątek.
         * Może to być np. wypisanie stosu wywołań na wyjście błędów
         * lub zapisanie wyjątku w logach, lub wyrzucenie (zgłoszenie)
         * innego wyjątku lepiej opisującego sytuacje (można załączyć
         * wyjątek który zainicjował to zdarzenie patrz. Konstruktor
         * klasy java.lang.Exception)
         */
        try {
            Punkt p1 = Punkt.E_X;
            System.out.println(p1);
            Transformacja tr = new Translacja(5, 6);
            System.out.println(tr);
            Punkt p2 = tr.transformuj(p1);
            System.out.println(p2);
            Transformacja trr = tr.getTransformacjaOdwrotna();
            System.out.println(trr);
            Punkt p3 = trr.transformuj(p2);
            System.out.println(p3);

        } catch (BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();

        try
        {
            Punkt p1 = new Punkt(2, 2);
            System.out.println(p1);
            Transformacja tr2 = new Skalowanie(5, 4);
            System.out.println(tr2);
            Punkt p2 = tr2.transformuj(p1);
            System.out.println(p2);
            Transformacja trr2 = tr2.getTransformacjaOdwrotna();
            System.out.println(trr2);
            Punkt p3 = trr2.transformuj(p2);
            System.out.println(p3);
        }
        catch(BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();

        try
        {
            Punkt p1 = new Punkt(2, 2);
            Transformacja tr2 = new Skalowanie(5, 0);
            System.out.println(tr2);
            System.out.println(p1);
            Punkt p2 = tr2.transformuj(p1);
            System.out.println(p2);
            Transformacja trr2 = tr2.getTransformacjaOdwrotna();
            System.out.println(trr2);
            Punkt p3 = trr2.transformuj(p2);
            System.out.println(p3);
        }
        catch(BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();


        //ZAD 3
        try {
            Punkt p1 = new Punkt(2, 2);
            System.out.println(p1);
            Transformacja tr = new Obrot(90);
            System.out.println(tr);
            Punkt p2 = tr.transformuj(p1);
            System.out.println(p2);
            Transformacja trr = tr.getTransformacjaOdwrotna();
            System.out.println(trr);
            Punkt p3 = trr.transformuj(p2);
            System.out.println(p3);

        } catch (BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();

        //ZAD 4


        try {
            Punkt p1 = new Punkt(2, 2);
            System.out.println(p1);
            Transformacja tr = new ZlozenieTransformacji( new Transformacja[]{new Skalowanie(5, 3), new Obrot(90)});
            System.out.println(tr);
            Punkt p2 = tr.transformuj(p1);
            System.out.println(p2);
            Transformacja trr = tr.getTransformacjaOdwrotna();
            System.out.println(trr);
            Punkt p3 = trr.transformuj(p2);
            System.out.println(p3);

        } catch (BrakTransformacjiOdwrotnejException ex)
        {
            ex.printStackTrace();
        }
        System.out.println();

        //zadania na zajeciach
        //1
        Punkt3D p1 = new Punkt3D(2, 2, 2);
        System.out.println(p1);
        //2
        Transformacja tr = new Translacja3D(5, 6, 1);
        System.out.println(tr);
        Punkt p2 = tr.transformuj(p1);
        System.out.println(p2);
        //3
        ObrotOS ob = new ObrotOS(90);
        System.out.println(ob);
        Punkt p3 = ob.transformuj3D('x', 90, p1);
        System.out.println(p3);
        //4
        Transformacja ob2 = new Obrot3D(45, 90, 120);
        System.out.println(ob2);
        Punkt p4 = ob2.transformuj(p1);
        System.out.println(p4);
        //5
        System.out.println("Zlozenie transformacji 3D tablica: ");
        Transformacja tr2 = new ZlozenieTransformacji3DTab( new Transformacja[]{new Translacja3D(5, 3, 2), new Obrot3D(90, 20, 10)});
        System.out.println(tr2);
        Punkt p5 = tr2.transformuj(p1);
        System.out.println(p5);
        //6
        System.out.println("Zlozenie transformacji 3D lista: ");
        ArrayList<Transformacja> tabCheck =new ArrayList<Transformacja>();
        tabCheck.add(new Translacja3D(5, 3, 2));
        tabCheck.add(new Obrot3D(90, 20, 10));

        Transformacja tr3 = new ZlozenieTransformacji3DList(tabCheck);
        System.out.println(tr2);
        Punkt p6 = tr3.transformuj(p1);
        System.out.println(p6);

    }
}