package Spel;

import java.util.ArrayList;
import java.util.List;

public class Bord {
    public List<Rij> rijen;

    public Bord() {
        rijen = new ArrayList<Rij>();
    }

    public String toString() {
        System.out.println();
        for (Rij r : rijen) {
            System.out.println(r.toString());
        }
        if (rijen.isEmpty()) {
            System.out.println("Het bord is momenteel nog leeg");
        }
        System.out.println();
        return "";
    }
}
