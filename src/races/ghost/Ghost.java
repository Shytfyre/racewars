package races.ghost;

import races.Troop;

/**
 * Geister Rasse.
 */
class Ghost extends Troop {

    private static final double HEALTH = 1.0;
    private static final double ARMOR = 0.0;
    private static final double DAMAGE = 1.0;
    private static final int SPEED = 1;
    private static final double COST = 0.0;
    
    /**
     * Erstellt eine Geistertruppe mit den angegebenen Werten.
     */
    Ghost() {
        super(HEALTH, ARMOR, DAMAGE, SPEED, COST);
    }
}

