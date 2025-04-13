package mian;

import model.Vonal;

public class Vonalak {

    public static void main(String[] args) {
        try {
            Vonal szVonal = new Vonal(Vonal.PIROS_SZIN, 10, Vonal.SZAGGATOTT_V, 0);
            System.out.println(szVonal.allapot());

            Vonal nVonal = new Vonal(Vonal.SARGA_SZIN, 10, Vonal.NORMAL_V, 0);
            System.out.println(nVonal.allapot());

            Vonal dVonal = new Vonal(Vonal.ZOLD_SZIN, 10, Vonal.DUPLA_V, 0);
            System.out.println(dVonal.allapot());

            Vonal pVonal = new Vonal(Vonal.PIROS_SZIN, 10, Vonal.PONT_V, -5);
            System.out.println(pVonal.allapot());
        } catch (IllegalArgumentException ex) {
            System.err.println("A program futása leállt!");
            System.err.println("HIBA! ---> " + ex.getMessage());
        }
    }

}
