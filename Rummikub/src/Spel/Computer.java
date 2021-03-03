package Spel;

public class Computer extends Speler {
    public Computer(String naam, Pot pot, Bord bord) {
        super(naam, pot, bord);
    }

    @Override
    public void zet() {
        for (int i = 0; i < 16; i++) {
            System.out.println();
        }
        System.out.println("Beep boop ik ben een robot en ik denk over mijn zet");
        wachtAantalSeconden(3);
        algoritme();
    }

    public void algoritme() {
        kijkOfIkNieuweRijKanAfleggen();
        kijkOfIkGetalKanAfleggen();
    }

    public void kijkOfIkNieuweRijKanAfleggen() {
        nieuweRijZelfdeGetal();
        nieuweRijZelfdeWaarde();
    }

    public void kijkOfIkGetalKanAfleggen() {

    }

    public void nieuweRijZelfdeGetal() {

    }

    public void nieuweRijZelfdeWaarde() {

    }

    private void wachtAantalSeconden(int aantalSeconden) {
        try {
            Thread.sleep(1000 * aantalSeconden);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
