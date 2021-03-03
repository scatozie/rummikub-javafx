package Spel;

import java.time.*;
import java.util.*;

//TODO .tolowercase nog overal aanpassen

public class Rummikub {
    private LocalDate datum;
    private LocalTime tijdstip;
    private Highscore highscore;
    private List<Highscore> highscoreLijst;
    private final Scanner keyboard = new Scanner(System.in);
    private Match match;

    public Rummikub() {

    }

    public void Start() {
        System.out.println("Opstarten rummikub ...");
        HoofdMenu();
    }

    public void HoofdMenu() {
        while (true) {
            vrijMakenConsole();
            System.out.println("\n Welk van volgende opties wil je hebben?\n" + ConsoleKleuren.BLACK + " 1: voor speel match \n" + ConsoleKleuren.YELLOW + " 2: zie highscores \n" + ConsoleKleuren.BLUE + " 3: meer informatie \n" + ConsoleKleuren.RED + " 4: afsluiten\n" + ConsoleKleuren.RESET);
            String antw = keyboard.next();
            if (antw.equals("1")) {
                System.out.println("Spel.Match starting...");
                speelMatch();
            }
            if (antw.equals("2")) {
                zieHighscores();
            }
            if (antw.equals("3")) {
                meerInformatie();
            }
            if (antw.equals("4")) {
                System.exit(1);
            }
        }
    }

    public void speelMatch() {
        vrijMakenConsole();
        while (true) {
            System.out.println("Wilt u tegen de computer? (j = ja, n = nee, t = terug)");
            String s = keyboard.next();
            if (s.equals("j") || s.equals("J")) {
                Match match = new Match(2, true);
                match.speel();
                break;
            }
            if (s.equals("n") || s.equals("N")) {
                while (true) {
                    System.out.println("Hoeveel spelers zijn er? (MAX 4 spelers) (t = terug)");
                    int aantalSpelers = keyboard.nextInt();
                    //TODO  MOET NOG CONTROLE OM TE ZIEN OF HET WEL DEGELIJK EEN GETAL IS!!!!
                    if (aantalSpelers > 0 && aantalSpelers < 5) { //todo SPELERS MOETEN GROTER ZIJN DAN 0!! DIT WAS ENKEL VOOR TESTDOELEN
                        Match match = new Match(aantalSpelers, false);
                        match.speel();
                        wachtAantalSeconden(3);
                        break;
                    } else {
                        System.out.println("Sorry, te veel spelers!");
                    }
                    if (s.equalsIgnoreCase("t")) {
                        break;
                    }
                }
                break;
            }
            if (s.equals("t") || s.equals("T")) {
                break;
            }
        }
    }

    public void zieHighscores() {
        vrijMakenConsole();
        /* for (Spel.Highscore h: highscoreLijst) {
            System.out.println(h.toString());
        }*/
        System.out.println("Onder constructie");
        drukOpEnter();
    }

    public void meerInformatie() {
        vrijMakenConsole();
        System.out.println(" gemaakt door " + ConsoleKleuren.GREEN + "Timothy Vermeiren" + ConsoleKleuren.RESET + " en " + ConsoleKleuren.GREEN + "Giuseppe Janssens\n " + ConsoleKleuren.BLUE + "klas" + ConsoleKleuren.RESET + ": 103b \n " + ConsoleKleuren.BLUE + "lesgever" + ConsoleKleuren.RESET + ": Hans Vochten \n " + ConsoleKleuren.BLUE + "peer-tutors" + ConsoleKleuren.RESET + ": Thijs Van Leemput en Kenzo Smulders");
        drukOpEnter();
    }

    public void drukOpEnter() {
        System.out.println("Druk op enter om terug naar het hoofdmenu te gaan ...");
        Scanner keyboardTijdelijk = new Scanner(System.in);
        keyboardTijdelijk.nextLine();
    }

    public void vrijMakenConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void wachtAantalSeconden(int aantalSeconden) {
        try {
            Thread.sleep(1000 * aantalSeconden);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}


