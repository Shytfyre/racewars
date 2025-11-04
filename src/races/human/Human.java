package races.human;

import races.Troop;

/**
 * Basis Truppe Mensch.
 */
class Human extends Troop {

    private static final double HEALTH = 140.0;
    private static final double ARMOR = 40.0;
    private static final double DAMAGE = 40.0;
    private static final int SPEED = 2;
    private static final double COST = 110.0;
    
    /**
     * Erstellt eine Menschentruppe mit den angegebenen Werten.
     */
    Human() {
        super(HEALTH, ARMOR, DAMAGE, SPEED, COST);
    }
}

