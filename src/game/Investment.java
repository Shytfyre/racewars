package game;

import races.RaceType;

/**
 * Spiegelt das Investment in eine der spielbaren Rassen wider
 */
public class Investment {

    private final RaceType raceType;
    private final double cashAmount;

    /**
     * Erstellt ein neues Investment mit der übergebenen Rasse und Geldbetrag
     * 
     * @param raceType Die Rasse in die investiert wird
     * @param cashAmount die Menge an Geld die investiert wird
     */
    public Investment(RaceType raceType, double cashAmount) {
        this.raceType = raceType;
        this.cashAmount = cashAmount;
    }

    /**
     * Gibt die Rasse des Investments zurück
     * 
     * @return Die Rasse des Investments
     */
    public RaceType getRaceType() {
        return raceType;
    }

    /**
     * Gibt den Geldbetrag des Investments zurück
     * 
     * @return Der Geldbetrag des Investments
     */
    public double getCashAmount() {
        return cashAmount;
    }
}

