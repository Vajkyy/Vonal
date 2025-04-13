package teszt;

import model.Vonal;

public class VonalTeszt {

    public static void main(String[] args) {
        tesztKonstruktorHelyesErtekek();
        tesztKonstruktorHibasSzin();
        tesztKonstruktorHibasForma();
        tesztKonstruktorHibasHossz();

        tesztSetEltolasHelyesErtek();
        tesztSetEltolasNegativErtek();
    }

    public static void tesztKonstruktorHelyesErtekek() {
        Vonal vonal = new Vonal(Vonal.SARGA_SZIN, 5, Vonal.NORMAL_V, 2);
        assert vonal.getSzin().equals(Vonal.SARGA_SZIN) : "Szín nem megfelelő";
        assert vonal.getHossz() == 5 : "Hossz nem megfelelő";
        assert vonal.getForma().equals(Vonal.NORMAL_V) : "Forma nem megfelelő";
        assert vonal.getEltolas() == 2 : "Eltolás nem megfelelő";
        System.out.println("tesztKonstruktorHelyesErtekek rendben.");
    }

    public static void tesztKonstruktorHibasSzin() {
        try {
            Vonal vonal = new Vonal("hibas", 5, Vonal.NORMAL_V, 2);
            assert false : "Nem dobott kivételt hibás szín esetén";
        } catch (IllegalArgumentException e) {
            System.err.println("tesztKonstruktorHibasSzin rendben: " + e.getMessage());
        }
    }

    public static void tesztKonstruktorHibasForma() {
        try {
            Vonal vonal = new Vonal(Vonal.PIROS_SZIN, 5, "valami", 2);
            assert false : "Nem dobott kivételt hibás forma esetén";
        } catch (IllegalArgumentException e) {
            System.err.println("tesztKonstruktorHibasForma rendben: " + e.getMessage());
        }
    }

    public static void tesztKonstruktorHibasHossz() {
        try {
            Vonal vonal = new Vonal(Vonal.PIROS_SZIN, 0, Vonal.NORMAL_V, 2);
            assert false : "Nem dobott kivételt túl kicsi hossz esetén";
        } catch (IllegalArgumentException e) {
            System.err.println("tesztKonstruktorHibasHossz rendben: " + e.getMessage());
        }
    }

    public static void tesztSetEltolasHelyesErtek() {
        Vonal vonal = new Vonal(Vonal.ZOLD_SZIN, 5, Vonal.DUPLA_V, 1);
        vonal.setEltolas(3);
        assert vonal.getEltolas() == 3 : "Eltolás nem lett megfelelően beállítva";
        System.out.println("tesztSetEltolasHelyesErtek rendben.");
    }

    public static void tesztSetEltolasNegativErtek() {
        try {
            Vonal vonal = new Vonal(Vonal.ZOLD_SZIN, 5, Vonal.DUPLA_V, 1);
            vonal.setEltolas(-1);
            assert false : "Nem dobott kivételt negatív eltolás esetén";
        } catch (IllegalArgumentException e) {
            System.err.println("tesztSetEltolasNegativErtek rendben: " + e.getMessage());
        }
    }
}
