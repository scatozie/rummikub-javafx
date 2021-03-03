package Spel;

import java.util.*;

class Speler {
    protected Rek rek;
    private final String naam;
    protected Pot pot;
    protected Bord bord;
    private final Scanner keyboard = new Scanner(System.in);

    public Speler(String naam, Pot pot, Bord bord) {
        this.naam = naam;
        this.pot = pot;
        rek = new Rek(pot, bord);
        this.bord = bord;
    }

    public void legAf() {
        while (true) {
            System.out.println("Wenst u: \n1) een nieuwe rij toe te voegen \n2) een steen af te leggen bij een bestaande rij\n3) een steen te nemen\n4) het rek te sorteren");
            int antwoord = keyboard.nextInt();
            if (antwoord == 1) {
                if (rek.legRijAf() == true) {
                    while (true) {
                        System.out.println("Wilt u nog iets afleggen?");
                        String antw2 = keyboard.next();
                        if (antw2.equalsIgnoreCase("j")) {
                            legAf();
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            if (antwoord == 2) {
                if (rek.legSteenAf() == true) {
                    while (true) {
                        System.out.println("Wilt u nog iets afleggen?");
                        String antw2 = keyboard.next();
                        if (antw2.equalsIgnoreCase("j")) {
                            legAf();
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            if (antwoord == 3) {
                rek.neemSteen();
                break;
            }
            if (antwoord == 4) {
                rek.sorteerWaarde();
                rek.toString();
                System.out.println();
            }
        }
    }

    public void zet() {
        for (int i = 0; i < 16; i++) {
            System.out.println();
        }
        System.out.println("Dit is het bord:");
        bord.toString();
        System.out.println("Nu is het de zet voor " + naam + "\n");
        System.out.println("Spel.Rek " + naam + ": \n");
        rek.toString();
        System.out.println();
        Boolean klaar = false;
        while (klaar == false) {
            System.out.println("Wilt u afleggen? (j of n)");
            String antw = keyboard.next();
            if (antw.equals("j") || antw.equals("J")) {
                legAf();
                klaar = true;
            }
            if (antw.equals("n") || antw.equals("N")) {
                rek.neemSteen();
                klaar = true;
            }
        }
    }

    public Boolean isGewonnen() {
        return rek.isLeeg();
    }
}
