package Spel;

public class Match {
    private final Bord bord;
    private final Pot pot;
    private final Speler[] spelers;

    public Match(int aantalSpelers, Boolean metRobot) {
        pot = new Pot();
        bord = new Bord();
        spelers = new Speler[aantalSpelers];
        //PVP
        if (metRobot == false) {
            for (int i = 0; i < aantalSpelers; i++) {
                String naam = ("speler " + (i + 1));
                spelers[i] = new Speler(naam, pot, bord);
            }
        }
        //TODO hier komt PVE
        else {
            spelers[0] = new Speler("Spel.Speler", pot, bord);
            spelers[1] = new Computer("Spel.Computer", pot, bord);
        }
    }

    protected void speel() {
        Boolean eindigen = false;
        while (eindigen == false) {
            for (Speler s : spelers) {
                s.zet();
                if (s.isGewonnen() == true) {
                    System.out.println("Proficiat " + s.toString() + " heeft gewonnen!!!");
                    eindigen = true;
                }
            }
        }
    }
}
