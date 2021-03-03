package Spel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rij {
    public List<Steen> rijstenen;

    public Rij(List<Steen> rijstenen) {
        this.rijstenen = rijstenen;
    }

    public Boolean controleZelfdeKleur() {
        String deKleur = rijstenen.get(0).getKleur();
        Boolean test = true;
        for (Steen s : rijstenen) {
            if (!s.getKleur().equals(deKleur)) {
                test = false;
            }
        }
        return test;
    }

    public Boolean controleOpeenvolgendeWaarde() {
        int eersteWaarde = (rijstenen.get(0).getWaarde() - 1);
        Boolean test = true;
        for (Steen s : rijstenen) {
            int verschil = s.getWaarde() - eersteWaarde;
            eersteWaarde = s.getWaarde();
            if (verschil != 1) {
                test = false;
            }
        }
        return test;
    }

    public Boolean controleDezelfdeWaarde() {
        Boolean test = true;
        int waarde = rijstenen.get(0).getWaarde();
        for (Steen s : rijstenen) {
            if (s.getWaarde() != waarde) {
                test = false;
            }
        }
        return test;
    }

    public Boolean controleVerschillendeKleur() {
        Boolean test = true;
        List<String> controle = new ArrayList<String>();
        for (Steen s : rijstenen) {
            for (String k : controle) {
                if (s.getKleur().equals(k)) {
                    test = false;
                }
            }
            controle.add(s.getKleur());
        }
        return test;
    }

    public Boolean Controleer(Rij r) {
        //Controle op juistheid getallen
        if (r.rijstenen.size() >= 3) {
            //Controle op opeenvolgende getallen, zelfde kleur
            r.sorteerWaarde();
            if (controleZelfdeKleur() && controleOpeenvolgendeWaarde()) {
                return true;
            }

            //Controle op zeflde getallen, verschillende kleuren
            return controleVerschillendeKleur() && controleDezelfdeWaarde();
        }
        return false;
    }

    public void sorteerWaarde() {
        Collections.sort(rijstenen, (s1, s2) -> {
            return s1.getWaarde() - s2.getWaarde();
        });
    }

    @Override
    public String toString() {
        for (Steen s : rijstenen) {
            s.toString();
            System.out.print(" ");
        }
        System.out.println();
        return "";
    }
}
