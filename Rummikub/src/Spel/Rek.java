package Spel;

import java.util.List;
import java.util.*;

public class Rek {
    private final List<Steen> stenen;
    private final Pot pot;
    private Random r;
    private final Scanner keyboard = new Scanner(System.in);
    private final Bord bord;

    public Rek(Pot pot, Bord bord) {
        this.pot = pot;
        this.bord = bord;
        stenen = new ArrayList<Steen>();
        for (int i = 0; i < 14; i++) {
            neemSteen();
        }
    }

    public void neemSteen() {
        Boolean lukt = false;
        while (lukt == false) {
            r = new Random();
            int getal = r.nextInt(104);
            if (pot.collectie[getal].inPot) {
                stenen.add(pot.collectie[getal]);
                pot.collectie[getal].neem();
                lukt = true;
            }
        }
    }

    public Boolean legRijAf() {
        List<Steen> tijdelijkelijst = new ArrayList<Steen>();
        Rij tijdelijkerij = new Rij(tijdelijkelijst);
        while (true) {
            System.out.println("Dit is de rij die u gaat af leggen: ");
            tijdelijkerij.toString();
            System.out.println("Wenst u: \n1)terug te gaan? \n2)een steen uit eigen rek toe te voegen\n3)een steen uit een bestaande rij toe te voegen?\n4)De tijdelijke rij afleggen?");
            int antwoord = keyboard.nextInt();
            if (antwoord == 1) {
                for (Steen s : tijdelijkelijst) {
                    stenen.add(s);
                }
                return false;
            }
            if (antwoord == 2) {
                int teller = 1;
                for (Steen s : stenen) {
                    System.out.print(teller + ") ");
                    s.toString();
                    System.out.println();
                    teller++;
                }
                System.out.println("Welke steen?");
                int selectieSteen = keyboard.nextInt();
                tijdelijkelijst.add(stenen.get(--selectieSteen));
                stenen.remove(selectieSteen);
            }
            if (antwoord == 3) {
                if (bord.rijen.isEmpty()) {
                    System.out.println("Sorry maar het bord is leeg!");
                } else {
                    int teller = 1;
                    for (Rij r : bord.rijen) {
                        System.out.print(teller++ + ") ");
                        r.toString();
                    }
                    System.out.println("Welke rij?");
                    int selectieRij = keyboard.nextInt();
                    Rij geslecteerderij = bord.rijen.get(--selectieRij);
                    Rij kopie = geslecteerderij;
                    bord.rijen.remove(selectieRij);
                    teller = 0;
                    for (Steen s : geslecteerderij.rijstenen) {
                        System.out.print(++teller + ") ");
                        s.toString();
                        System.out.println();
                    }
                    System.out.println("Welke steen wilt u eruit nemen?");
                    int selectieSteen = keyboard.nextInt();
                    Steen geselecteerdeSteen = geslecteerderij.rijstenen.get(--selectieSteen);
                    geslecteerderij.rijstenen.remove(selectieSteen);
                    geslecteerderij.sorteerWaarde();
                    if ((geslecteerderij.controleZelfdeKleur() && geslecteerderij.controleOpeenvolgendeWaarde()) || (geslecteerderij.controleVerschillendeKleur() && geslecteerderij.controleDezelfdeWaarde())) {
                        tijdelijkelijst.add(geselecteerdeSteen);
                        bord.rijen.add(geslecteerderij);
                    } else {
                        System.out.println("Sorry maar dit mag je niet doen.");
                        bord.rijen.add(kopie);
                    }
                }
            }
            if (antwoord == 4) {
                if (tijdelijkerij.Controleer(tijdelijkerij) == true) {
                    bord.rijen.add(tijdelijkerij);
                    return true;
                } else {
                    System.out.println("Sorry  maar die rij kan u niet afleggen!");
                }
            }
        }
    }

    public Boolean legSteenAf() {
        int teller = 0;
        for (Rij r : bord.rijen) {
            System.out.print(++teller + ") ");
            r.toString();
        }
        System.out.println("Welke rij wilt u een steen bij afleggen?");
        int antwoord = keyboard.nextInt();
        Rij geselecteerdeRij = bord.rijen.get(--antwoord);
        Rij kopierij = geselecteerdeRij;
        bord.rijen.remove(antwoord);
        teller = 0;
        for (Steen s : stenen) {
            System.out.print(++teller + ") ");
            s.toString();
            System.out.println();
        }
        geselecteerdeRij.toString();
        System.out.println("Welke steen wilt u toevoegen aan de geselecteerde rij?");
        antwoord = keyboard.nextInt();
        Steen kopiesteen = stenen.get(--antwoord);
        stenen.remove(antwoord);
        geselecteerdeRij.rijstenen.add(kopiesteen);
        geselecteerdeRij.sorteerWaarde();
        if ((geselecteerdeRij.controleVerschillendeKleur() && geselecteerdeRij.controleDezelfdeWaarde()) || (geselecteerdeRij.controleOpeenvolgendeWaarde() && geselecteerdeRij.controleZelfdeKleur())) {
            bord.rijen.add(geselecteerdeRij);
            for (Rij ri : bord.rijen) {
                r.toString();
            }
            return true;
        } else {
            System.out.println("Sorry maar deze zet mag je niet doen!");
            stenen.add(kopiesteen);
            bord.rijen.add(kopierij);
            return false;
        }
    }

    public void sorteerWaarde() {
        Collections.sort(stenen, (s1, s2) -> {
            return s1.getWaarde() - s2.getWaarde();
        });
    }

    @Override
    public String toString() {
        for (Steen s : stenen) {
            System.out.print(s.toString() + " ");
        }
        return "";
    }

    public Boolean isLeeg() {
        return stenen.isEmpty();
    }
}
