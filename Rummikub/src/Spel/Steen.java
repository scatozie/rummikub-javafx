package Spel;

/**
 * Spel.Steen klasse
 * Een steen heeft een kleur en een waarde tussen 1 en 13. Bovendien zijn er ook 2 jokerstenen.
 */

public class Steen {
    private final String kleur;
    private final int JOKER_PUNTEN = 0; //Tijdelijk geinitialiseerd op 0 omdat er een waarde MOET meegegeven worden aan een final.
    private final int waarde;
    public Boolean inPot;

    public Steen(String kleur, int waarde) {
        this.kleur = kleur;
        this.waarde = waarde;
        inPot = true;
    }

    public Boolean inPot() {
        return inPot;
    }

    public void neem() {
        inPot = false;
    }

    public int getWaarde() {
        return waarde;
    }

    public String getKleur() {
        return kleur;
    }

    @Override
    public String toString() {
        System.out.print(kleur + waarde + ConsoleKleuren.RESET);
        return "";
    }
}
