package races;

/**
 * Factory Interface zur Erstellung von Truppen der spezifischen Rassen.
 */
public interface Factory {
    /**
     * Erstellt Truppen basierend auf dem Rassentypen und dem verfügbaren Geld.
     * 
     * @param race Der Rassentyp.
     * @param cashAmount Der Geldbetrag.
     * @return Ein Array an erstellten Truppen.
     */
    Troop[] createTroops(RaceType race, double cashAmount);
}

