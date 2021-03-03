package Spel;

public class Pot {
    public Steen[] collectie;

    public Pot() {
        collectie = new Steen[104];
        vulPot();
    }

    private void vulPot() {
        int teller = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 14; j++) {
                collectie[teller] = new Steen(ConsoleKleuren.BLACK, j);
                teller++;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 14; j++) {
                collectie[teller] = new Steen(ConsoleKleuren.BLUE, j);
                teller++;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 14; j++) {
                collectie[teller] = new Steen(ConsoleKleuren.YELLOW, j);
                teller++;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 14; j++) {
                collectie[teller] = new Steen(ConsoleKleuren.RED, j);
                teller++;
            }
        }
    }

    @Override
    public String toString() {
        for (Steen s : collectie) {
            System.out.print(s.toString() + " ");
        }
        return "";
    }
}
