package races.nightelf;

import races.Element;
import races.Leader;

/**
 * Der Daemonslayer, Anführer der Nachtelfen
 */
class Daemonslayer extends Leader {

    private static final double BASE_HEALTH = 120.0;
    private static final double ARMOR = 20.0;
    private static final double BASE_DAMAGE = 15.0;
    private static final int SPEED = 3;
    private static final double COST = 290.0;
    private static final Element ELEMENT = Element.AIR;
    private static final double BONUS = 3.0;
    
    /**
     * Erstellt einen Daemonslayer mit den angegebenen Werten.
     */
    Daemonslayer() {
        super(BASE_HEALTH, ARMOR, BASE_DAMAGE, SPEED, COST, ELEMENT, BONUS);
    }
}

