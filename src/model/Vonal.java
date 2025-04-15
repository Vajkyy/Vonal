package model;

public class Vonal {

    private int hossz;
    private String szin;
    private int eltolas;
    private String forma;
    public static final String SZAGGATOTT_V = "szaggatott";
    public static final String NORMAL_V = "normál";
    public static final String DUPLA_V = "dupla";
    public static final String PONT_V = "pont";
    public static final String PIROS_SZIN = "\u001B[31m";
    public static final String SARGA_SZIN = "\u001B[33m";
    public static final String ZOLD_SZIN = "\u001B[32m";

    public Vonal(String szin, int hossz, String forma, int eltolas) throws IllegalArgumentException {
        if (!szin.equals(PIROS_SZIN) && !szin.equals(SARGA_SZIN) && !szin.equals(ZOLD_SZIN)) {
            throw new IllegalArgumentException("Nem létező szín: " + szin);
        }
        this.szin = szin;
        this.hossz = hossz;

        if (!forma.equals(SZAGGATOTT_V) && !forma.equals(NORMAL_V)
                && !forma.equals(DUPLA_V)
                && !forma.equals(PONT_V)) {
            throw new IllegalArgumentException("Nem létező forma: " + forma);
        }
        this.forma = forma;

        if (hossz < 1) {
            throw new IllegalArgumentException("A hossz értéke legalább 1 kell legyen: " + hossz);
        }

        setEltolas(eltolas);
    }

    public void setEltolas(int eltolas) throws IllegalArgumentException {
        if (eltolas < 0) {
            throw new IllegalArgumentException("Az eltolás nem lehet negatív: " + eltolas);
        }
        this.eltolas = eltolas;
    }

    public int getHossz() {
        return hossz;
    }

    public String getSzin() {
        return szin;
    }

    public int getEltolas() {
        return eltolas;
    }

    public String getForma() {
        return forma;
    }

    public String allapot() {
        return "A vonal hossza: " + hossz + " egység"
                + ", színe: " + vonalSzine() + ", " + forma
                + " karakterekből áll: " + vonalForma() + " eltolva ennyivel: " + eltolas;
    }

    private String vonalSzine() {
        String RED = "piros";
        String YELLOW = "sárga";
        String GREEN = "zöld";
        String RESET = "\u001B[30m";

        String kod = "";
        switch (szin) {
            case Vonal.PIROS_SZIN:
                kod = RED;
                break;
            case Vonal.SARGA_SZIN:
                kod = YELLOW;
                break;
            case Vonal.ZOLD_SZIN:
                kod = GREEN;
                break;
            default:
                kod = RESET;
                break;
        }
        return kod + szin + RESET;
    }

    private String vonalForma() {
        String SZAGG = "—-";
        String NORM = "___";
        String DUPLA = "===";
        String PONT = "...";
        String RESET = "\u001B[30m";

        String form = "";
        switch (forma) {
            case Vonal.SZAGGATOTT_V:
                form = SZAGG;
                break;
            case Vonal.NORMAL_V:
                form = NORM;
                break;
            case Vonal.DUPLA_V:
                form = DUPLA;
                break;
            case Vonal.PONT_V:
                form = PONT;
                break;
            default:
                break;
        }
        return this.szin + form.repeat(hossz) + RESET;
    }

}
