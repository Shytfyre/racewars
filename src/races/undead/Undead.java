package races.undead;

import races.Troop;

/**
 * Basis Truppe Untote.
 */
class Undead extends Troop {

    private static final double HEALTH = 120.0;
    private static final double ARMOR = 30.0;
    private static final double DAMAGE = 16.0;
    private static final int SPEED = 2;
    private static final double COST = 70.0;
    
    /**
     * Erstellt eine Untotentruppe mit den vorgegebenen Werten.
     */
    Undead() {
        super(HEALTH, ARMOR, DAMAGE, SPEED, COST);
    }
}

