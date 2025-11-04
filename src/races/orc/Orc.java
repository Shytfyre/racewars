package races.orc;

import races.Troop;

/**
 * Basis Truppe Orc.
 */
class Orc extends Troop {

    private static final double HEALTH = 100.0;
    private static final double ARMOR = 30.0;
    private static final double DAMAGE = 33.0;
    private static final int SPEED = 1;
    private static final double COST = 150.0;
    
    /**
     * Erstellt eine Orctruppe mit den angegebenen Werten.
     */
    Orc() {
        super(HEALTH, ARMOR, DAMAGE, SPEED, COST);
    }
}

