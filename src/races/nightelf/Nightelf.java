package races.nightelf;

import races.Troop;

class Nightelf extends Troop {
    private static final double HEALTH = 120.0;
    private static final double ARMOR = 20.0;
    private static final double DAMAGE = 15.0;
    private static final int SPEED = 3;
    private static final double COST = 145.0;
    
    Nightelf() {
        super(HEALTH, ARMOR, DAMAGE, SPEED, COST);
    }
}

